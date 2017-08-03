package util;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import org.chasen.crfpp.Tagger;

import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;


public class RkgnizeOnline {

	public static String parser(String text) throws Exception {
		start(text);
		File outfile = new File(System.getProperty("user.dir")+"/outputtext");
		FileReader fr = new FileReader(outfile);
		BufferedReader br = new BufferedReader(fr);
		StringBuffer sb = new StringBuffer();
		String line = null;
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		br.close();
		String t = sb.toString();
		return t;
	}

	private static void start(String text) throws Exception {
		File outFile = new File(System.getProperty("user.dir") + "/text");
		if(outFile.exists())outFile.delete();
		outFile.createNewFile();
		FileWriter fw = new FileWriter(outFile);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(text);
		bw.close();
		mark();
		gettext();
	}

	private static void mark() throws Exception {
		String[] arg = { "models/english-left3words-distsim.tagger",System.getProperty("user.dir") + "/text" };
		Tagger(arg);

		String path = System.getProperty("user.dir") + "/text#";

		Line line;
		mtagger mt = new mtagger("-m " + System.getProperty("user.dir")
				+ "/model -v 3");
		File file = new File(path);
		if(file.exists())file.delete();
		file.createNewFile();
		FileInputStream fileins = new FileInputStream(file);
		InputStreamReader ins = new InputStreamReader(fileins, "UTF-8");
		BufferedReader br = new BufferedReader(ins);

		String s = "";
		while ((s = br.readLine()) != null) {
			String[] sentence = s.split("\\./\\.");
			for (int i = 0; i < sentence.length; i++) {
				String[] phrase = sentence[i].split(" ");
				for (int j = 0; j < phrase.length; j++) {
					line = new Line(phrase[j]);
					String result = line.outputline();
					mt.add(result);
				}
				mt.add(". 0 0 0 0 0 0 0 0");
			}

		}
		br.close();
		File outFile = new File(System.getProperty("user.dir") + "/output");
		if(outFile.exists())outFile.delete();
		outFile.createNewFile();
		mt.recognizeto(System.getProperty("user.dir") + "/output");

	}

	private static void Tagger(String[] args) throws Exception {

		if (args.length != 2) {
			System.err.println("usage: java TaggerDemo modelFile fileToTag");
			return;
		}
		MaxentTagger tagger = new MaxentTagger(args[0]);
		List<List<HasWord>> sentences = MaxentTagger
				.tokenizeText(new BufferedReader(new FileReader(args[1])));
		File file = new File(System.getProperty("user.dir") + "/text#");
		if(file.exists())file.delete();
		file.createNewFile();
		FileOutputStream out = new FileOutputStream(file);
		for (List<HasWord> sentence : sentences) {
			List<TaggedWord> tSentence = tagger.tagSentence(sentence);
			byte bt[] = Sentence.listToString(tSentence, false).getBytes();
			out.write(bt);
		}
		out.close();
	}

	private static void gettext() throws Exception {
		File file = new File(System.getProperty("user.dir") +"/output");
		FileInputStream fileins = new FileInputStream(file);
		InputStreamReader ins = new InputStreamReader(fileins,"UTF-8");
		BufferedReader br = new BufferedReader(ins);
		File outfile = new File(System.getProperty("user.dir")+"/outputtext");
		if(outfile.exists())outfile.delete();
		outfile.createNewFile();
		FileOutputStream out = new FileOutputStream(outfile);
		OutputStreamWriter outwriter = new OutputStreamWriter(out);
		BufferedWriter bw = new BufferedWriter(outwriter);
		String s = "";
		bw.append("<!DOCTYPE HTML>\n"
				+ "<html>\n"
				+ "<head>\n"
				+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n"
				+ "<style type=\"text/css\">\n" + ".protein{color:#FFcc99;"
				+ "herf:protein\n" + "}\n"
				+ ".cell_type{color:#99ffff;herf:cell_type} \n"
				+ ".cell_line{color:#ccffff;herf:cell_line} \n"
				+ ".DNA{color:#FFcccc;herf:DNA} \n"
				+ ".RNA{color:#ffff99;herf:RNA} \n"
				+ ".virus{color:#8600FF;herf:virus} \n" + "</style>\n"
				+ "</head>\n" + "<body>\n");
		int m = 0;

		while ((s = br.readLine()) != null) {
			String[] word = s.split("\t");

			if (m == 1 && word[word.length - 1].equals("O")) {
				bw.append("</b>");
				m = 0;
			}
			if (word[word.length - 1].equals("B-protein")) {
				if (m == 0) {
					bw.append("<b  class=\"protein\" title=\"protein\">");
				} else {
					bw.append("</b><b  class=\"protein\" title=\"protein\">");
				}
				m = 1;
			}
			if (word[word.length - 1].equals("B-DNA")) {
				if (m == 0) {
					bw.append("<b  class=\"DNA\" title=\"DNA\">");
				} else {
					bw.append("</b><b  class=\"DNA\" title=\"DNA\">");
				}
				m = 1;
			}
			if (word[word.length - 1].equals("B-RNA")) {
				if (m == 0) {
					bw.append("<b  class=\"RNA\" title=\"RNA\">");
				} else {
					bw.append("</b><b  class=\"RNA\" title=\"RNA\">");
				}
				m = 1;
			}
			if (word[word.length - 1].equals("B-cell_line")) {
				if (m == 0) {
					bw.append("<b  class=\"cell_line\" title=\"cell_line\">");
				} else {
					bw.append("</b><b  class=\"cell_line\" title=\"cell_line\">");
				}
				m = 1;
			}
			if (word[word.length - 1].equals("B-cell_type")) {
				if (m == 0) {
					bw.append("<b  class=\"cell_type\" title=\"cell_type\">");
				} else {
					bw.append("</b><b  class=\"cell_type\" title=\"cell_type\">");
				}
				m = 1;
			}
			if (word[word.length - 1].equals("B-virus")) {
				if (m == 0) {
					bw.append("<b  class=\"virus\" title=\"virus\">");
				} else {
					bw.append("</b><b  class=\"virus\" title=\"virus\">");
				}
				m = 1;
			}
			if (word[0].equals(".")) {
				bw.append(word[0] + "<br/>");
			} else {
				bw.append(word[0] + " ");
			}

		}
		bw.append("</body>\n</html>");
		bw.close();
		br.close();
	}
	public static void main(String[] args) throws Exception {
		System.out.println(parser("ssdadasdas"));
	}
}

class mtagger {

	private static Tagger tagger;

	mtagger(String s) {
		tagger = new Tagger(s);
		tagger.clear();
	}

	public void add(String s) {
		tagger.add(s);
	}

	public void recognizeto(String path) throws Exception {

		File outfile = new File(path);
		FileOutputStream out = new FileOutputStream(outfile);
		OutputStreamWriter outwriter = new OutputStreamWriter(out);
		BufferedWriter bw = new BufferedWriter(outwriter);

		if (!tagger.parse()) {
			bw.close();
			return;
		}
		for (int i = 0; i < tagger.size(); ++i) {
			for (int j = 0; j < tagger.xsize(); ++j) {
				String s1 = tagger.x(i, j) + "\t";
				bw.append(s1); // 各个特征
			}
			String s2 = tagger.y2(i);
			bw.append(s2 + "\n"); // test原来标注的实体
		}
		bw.close();
	}

	static {
		try {
			System.out.println(System.getProperty("java.library.path"));
			System.loadLibrary("CRFPP");
		} catch (UnsatisfiedLinkError e) {
			System.err
					.println("Cannot load the example native code.\nMake sure your LD_LIBRARY_PATH contains \'.\'\n"
							+ e);
			System.exit(1);
		}
	}
}

class Line {
	private String word;
	private String cx = null;
	private String num = null;
	private String letterandnum = null;
	private String hythen = null;
	private String underline = null;
	private String allcap = null;
	private String lowercase = null;
	private String initcap = null;

	Line(String phrase) {
		if (phrase.contains("//:")) {
			word = "/";
			cx = ":";
		} else {
			String[] s = phrase.split("/");
			word = s[0];
			cx = s[1];
		}
		mark();
	}

	private void mark() {
		// TODO Auto-generated method stub
		setword();
		setnum();
		setletterandnum();
		setunderline();
		sethythen();
		setinitcap();
		setallcap();
		setlowercase();
	}

	public String outputline() {
		String s = word + " " + cx + " " + num + " " + letterandnum + " "
				+ hythen + " " + underline + " " + initcap + " " + allcap + " "
				+ lowercase;
		return s;
	}

	public void setword() {
		if (word.equals("-LRB-")) {
			word = "(";
		} else if (word.equals("-LSB-")) {
			word = "[";
		} else if (word.equals("-RRB-")) {
			word = ")";
		} else if (word.equals("-RSB-")) {
			word = "]";
		}
	}

	public void setcx(String _cx) {
		cx = _cx;
	}

	public void setnum() {
		if (word.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$")) {
			num = "1";
		} else {
			num = "0";
		}
	}

	public void setletterandnum() {

		int k = 0;
		for (int n = 0; n < word.length(); n++) {
			if (Character.isDigit(word.charAt(n))) {
				k++;
			}
		}
		if (k == 0) {
			letterandnum = "0";
			return;
		}
		if (k < word.length()) {
			letterandnum = "1";
		} else {
			letterandnum = "0";
		}
	}

	public void sethythen() {
		if (word.indexOf("-") > -1) {
			hythen = "1";
			return;
		}
		hythen = "0";
	}

	public void setunderline() {
		if (word.indexOf("_") > -1) {
			underline = "1";
			return;
		}
		underline = "0";

	}

	public void setinitcap() {
		if (Character.isUpperCase(word.charAt(0))) {
			initcap = "1";
			return;
		}
		initcap = "0";

	}

	public void setallcap() {
		if (word.matches("[A-Z]+")) {
			allcap = "1";
		} else {

			allcap = "0";
		}
	}

	public void setlowercase() {

		if (word.matches("[a-z]+")) {
			lowercase = "1";
		} else {
			lowercase = "0";
		}
	}	
}


