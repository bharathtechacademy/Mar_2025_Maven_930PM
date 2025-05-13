package tests;

import utilities.PDFUtil;

public class ReadPDF {

	public static void main(String[] args) {
		System.out.println(PDFUtil.getPDFText("TestFile.pdf").contains("Google product"));
		
	}

}
