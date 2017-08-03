package util;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import abner.Tagger;

import java.io.StringReader;

import edu.stanford.nlp.process.Tokenizer;
import edu.stanford.nlp.process.TokenizerFactory;
import edu.stanford.nlp.process.CoreLabelTokenFactory;
import edu.stanford.nlp.process.DocumentPreprocessor;
import edu.stanford.nlp.process.PTBTokenizer;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.ling.Tag;
import edu.stanford.nlp.ling.Word;
import edu.stanford.nlp.trees.*;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
class Parser{
	private TokenizerFactory<CoreLabel> tokenizerFactory;
	private LexicalizedParser lp;
	private Tagger bioEntityTag;
	public Parser() {
		super();
		this.tokenizerFactory =PTBTokenizer.factory(new CoreLabelTokenFactory(), ""); 
		this.lp = LexicalizedParser.loadModel("edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz"); 
		this.bioEntityTag = new abner.Tagger();
	}
	static String getBaseForm(String word){
		if(word.endsWith("s"))
			if (word.endsWith("sses"))word=word.substring(0, word.length()-2);
			else if(word.endsWith("ies"))word=word.substring(0, word.length()-3)+"y";
			else word=word.substring(0, word.length()-1);
		if (word.endsWith("eed")){			
			if (word.length() > 4) word=word.substring(0, word.length()-1);}
		else if (word.endsWith("ed")){
			word=word.substring(0,word.length()-2);
			if(word.endsWith("at")|word.endsWith("bl")|word.endsWith("iz"))word+="e";
			else if(word.charAt(word.length()-1)==word.charAt(word.length()-2)){
				if(!(word.charAt(word.length()-1)=='l'|word.charAt(word.length()-1)=='s'|word.charAt(word.length()-1)=='z'))
					word=word.substring(0,word.length()-1);
			}
		}
		else if (word.endsWith("ing")){
			word=word.substring(0,word.length()-3);
			if(word.endsWith("at")|word.endsWith("bl")|word.endsWith("iz")|word.endsWith("as"))word+="e";		
			else if(word.charAt(word.length()-1)==word.charAt(word.length()-2)){
				if(!(word.charAt(word.length()-1)=='l'|word.charAt(word.length()-1)=='s'|word.charAt(word.length()-1)=='z'))
					word=word.substring(0,word.length()-1);
			}
		}
		return word;
  }
	public ArrayList parseSent(String sent){
		String sent1=bioEntityTag.tagABNER(sent);
		ArrayList<String> al=new ArrayList<String>();
		if(sent1.contains("|B-")){
			Tokenizer<CoreLabel> tok =tokenizerFactory.getTokenizer(new StringReader(sent));
	        List<CoreLabel> rawWords2 = tok.tokenize();   
	        Tree parse = lp.apply(rawWords2);
	        //parse.pennPrint();
	        HashMap<String,String> hm=new HashMap<String,String>();
	        
	        int npCount=0;
	        for(Tree sub:parse){
	        	if(sub.label().toString().equals("NP")){
	        		String temp=sub.getLeaves().toString().replaceAll(", ", " ").replaceAll(" , ",", ");
	        		temp=temp.substring(1, temp.length()-1);
	        		if(sent.contains(temp)&temp.split(" ").length>1){
	        			String rep="NP"+npCount;
	        			hm.put(rep, temp);
	        			sent=sent.replace(temp, rep);
	        			npCount++;
	        		}	        		
	        	}
	        }
	        tokenizerFactory =PTBTokenizer.factory(new CoreLabelTokenFactory(), "");
	        tok =tokenizerFactory.getTokenizer(new StringReader(sent));
	        rawWords2 = tok.tokenize();   
	        parse = lp.apply(rawWords2);
	        
	        TreebankLanguagePack tlp = lp.treebankLanguagePack(); // PennTreebankLanguagePack for English
	        GrammaticalStructureFactory gsf = tlp.grammaticalStructureFactory();
	        GrammaticalStructure gs = gsf.newGrammaticalStructure(parse);
	        List<TypedDependency> tdl = gs.typedDependenciesCCprocessed();
	        String subject="",verb="",object="";
	        if(tdl.toString().contains("nsubj(")&tdl.toString().contains("dobj(")){	        	
		        for(TypedDependency t:tdl){
		        	//System.out.println(t);
		        	if(t.toString().startsWith("nsubj(")){
		        		String temp=t.toString();
		        		temp=temp.substring(6,temp.length()-1);
		        		subject=temp.split(", ")[1].split("-")[0];
		        		verb=temp.split(", ")[0].split("-")[0];	        		
		        	}
		        	if(t.toString().startsWith("dobj(")){
		        		String temp=t.toString();
		        		temp=temp.substring(5,temp.length()-1);
		        		object=temp.split(", ")[1].split("-")[0];	        			        		
		        	}	        	
		        }		       
	        }
	        else if(tdl.toString().contains("nsubjpass(")&tdl.toString().contains("nmod:agent(")){
		        for(TypedDependency t:tdl){
		        	//System.out.println(t);
		        	if(t.toString().startsWith("nsubjpass(")){
		        		String temp=t.toString();
		        		temp=temp.substring(10,temp.length()-1);
		        		object=temp.split(", ")[1].split("-")[0];
		        		verb=temp.split(", ")[0].split("-")[0];	        		
		        	}
		        	if(t.toString().startsWith("nmod:agent(")){
		        		String temp=t.toString();
		        		temp=temp.substring(11,temp.length()-1);
		        		subject=temp.split(", ")[1].split("-")[0];	        			        		
		        	}	        	
		        }		        
	        }
	        else{
	        	 for(TypedDependency t:tdl){
			        	System.out.println(t);}
	        	System.out.println("This sentence has no subjects and objectes simultaneously!");
	        }
	        if(!(subject.equals("")|verb.equals("")|object.equals(""))){
	        	String subPhrase=hm.containsKey(subject)?hm.get(subject):subject;
		        String obPhrase=hm.containsKey(object)?hm.get(object):object;
		        if(subPhrase.contains(" and ")){	        	
		        	al.add(subPhrase.split(" and ")[0]+"\t"+getBaseForm(verb)+"\t"+hm.get(object));
		        	al.add(subPhrase.split(" and ")[1]+"\t"+getBaseForm(verb)+"\t"+hm.get(object));
		        }else if(obPhrase.contains(" and ")){
		        	al.add(subPhrase+"\t"+getBaseForm(verb)+"\t"+obPhrase.split(" and ")[0]);
		        	al.add(subPhrase+"\t"+getBaseForm(verb)+"\t"+obPhrase.split(" and ")[1]);
		        }else
		        	al.add(subPhrase+"\t"+getBaseForm(verb)+"\t"+obPhrase);
	        }
	    }
	    else{
	    	System.out.println("This sentence has no biomedical entities!");
	    }
		
		return al;
	}
}
public class ParserDemo {

  public static void main(String[] args) {
	String sent = "IL-2 gene expression and NF-kappa B activation through CD28 requires reactive oxygen production by 5-lipoxygenase.";
	Parser p=new Parser();
	ArrayList al=p.parseSent(sent);
	for(int i=0;i<al.size();i++){
		System.out.println(al.get(i));
	}
  }
  
}
