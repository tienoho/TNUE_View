package com.sad.model;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Content {

    private static final int dpi = 150;
    private InputStream input;
    private PDDocument document;
    private PDFRenderer render;
    private BufferedImage bufferedImage;
    private ByteArrayOutputStream outputStream;
    private int total;
    private static int totala;
    private static String url;

    public Content(String url) {
        Content.url = url;
    }

    public void loadPDF() {
        try {
            System.setProperty("sun.java2d.cmm", "sun.java2d.cmm.kcms.KcmsServiceProvider");
            input = new URL(url).openStream();

            document = PDDocument.load(input);

            render = new PDFRenderer(document);
            total = document.getNumberOfPages();
            totala = total;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] image(int page, int numberPage) {
        try {
            bufferedImage = render.renderImageWithDPI(page, dpi, ImageType.RGB);
            outputStream = new ByteArrayOutputStream();
            outputStream.flush();
            ImageIO.write(bufferedImage, "jpeg", outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }

    public void closeDocument() {
        try {
            input.close();
            outputStream.close();
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getTotal() {
        return total;
    }

    public static int getTotala() {
        return totala;
    }

    public static String getUrl() {
        return url;
    }
}
