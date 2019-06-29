package com.sad.model;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class SplitPDF {
    /**
     * @param inputStream  Input PDF file
     * @param outputStream Output PDF file
     * @param fromPage     start page from input PDF file
     * @param toPage       end page from input PDF file
     * @author viralpatel.net
     */
    public void splitPDF(InputStream inputStream, OutputStream outputStream, int fromPage, int toPage) {
        Document document = new Document();
        try {
            PdfReader inputPDF = new PdfReader(inputStream);
            int totalPages = inputPDF.getNumberOfPages();
            //make fromPage equals to toPage if it is greater
            if (fromPage > toPage) {
                fromPage = toPage;
            }
            if (toPage > totalPages) {
                toPage = totalPages;
            }
            // Create a writer for the outputstream
            PdfWriter writer = PdfWriter.getInstance(document, outputStream);
            document.open();
            PdfContentByte cb = writer.getDirectContent(); // Holds the PDF data
            PdfImportedPage page;
            while (fromPage <= toPage) {
                document.newPage();
                page = writer.getImportedPage(inputPDF, fromPage);
                cb.addTemplate(page, 0, 0);
                fromPage++;
            }
            outputStream.flush();
            document.close();
            outputStream.close();
            inputPDF.close();
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (document.isOpen())
                document.close();
            try {
                if (outputStream != null)
                    outputStream.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}
