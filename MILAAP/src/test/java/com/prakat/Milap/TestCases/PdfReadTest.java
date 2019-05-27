package com.prakat.Milap.TestCases;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.testng.annotations.Test;

import com.prakat.Generic.Helper.PdfReaderHelper;

public class PdfReadTest {
	@Test
	public void test() throws InvalidPasswordException, IOException {
		PdfReaderHelper pdf= new PdfReaderHelper();
		
		String contents=pdf.getPdfContent();
		System.out.println(contents);
		
	}

}
