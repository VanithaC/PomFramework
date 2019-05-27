package com.prakat.Generic.Helper;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;

public class PdfReaderHelper {
     public String getPdfContent() throws InvalidPasswordException, IOException {
    	 
    	 File file = new File(ConstantHelper.PdfFilePath);
    	 PDDocument document= new PDDocument().load(file);
    	 PDFTextStripper text= new PDFTextStripper();
    	 String content=text.getText(document);
    		document.close();
		return content;
    	
		//document.close();
     } 
}
