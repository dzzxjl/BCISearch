package util;

public class testParser {

	/**
	 * @param args
	 */
	public static void main(String args[]){
		String a = "Combination chemotherapy with adriamycin ( NSC-123127 ) and cyclophosphamide ( NSC-26271 ) for solid tumors : a phase II trial .";

		try {
			System.out.println(RecognizeOnline.parser(a));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
