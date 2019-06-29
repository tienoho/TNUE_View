package com.sad.utils.marc21;

import com.sad.model.CheckIp;
import com.sad.model.Content;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) throws IOException {
//        InputStream input = new URL("http://catalog.tdt.edu.vn/exlibris/aleph/a23_1/apache_media/K53428AK8U4T9K79F9LUCENJ12LKPH.pdf").openStream();
//      //  PDDocument document = PDDocument.load(new File("C:\\Users\\USER\\Desktop\\Ebook.pdf"));
//        PDDocument document = PDDocument.load(input);
//        PDFRenderer render = new PDFRenderer(document);
//        BufferedImage bufferedImage = render.renderImageWithDPI(0, 150, ImageType.RGB);
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        outputStream.flush();
//        ImageIO.write(bufferedImage, "jpg", outputStream);
//        String zx = DatatypeConverter.printBase64Binary(outputStream.toByteArray());
//        System.out.print(zx);
//        System.out.println(getIpLocal("10.0.2.9")+".*.*");
//        CheckIp checkIp=new CheckIp();
        Content content = new Content("http://catalog.tdtu.edu.vn/exlibris/aleph/a23_1/apache_media/VAP66QJ55JLINPLHUAG1E6CSY93L7K.pdf");
        content.loadPDF();
        for (int i = 0; i < 500; i++) {
            content.image(i, 499);
        }

    }

    public static String getIpLocal(String ip) {
        int index = ip.lastIndexOf(".");
        String str = ip.substring(0, ip.lastIndexOf(".", index - 1));
        return str;
    }
}

