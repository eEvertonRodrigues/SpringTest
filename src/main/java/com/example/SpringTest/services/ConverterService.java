package com.example.SpringTest.services;

import org.hibernate.query.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfDocumentInfo;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.properties.AreaBreakType;
import com.itextpdf.io.image.ImageDataFactory;
import java.io.ByteArrayOutputStream;

@Service
public class ConverterService implements IConverterService {
    @Override
    public byte[] converterImage2PDF(MultipartFile imageFile) {    
        try {
            if(imageFile.isEmpty()) {
                throw new IllegalArgumentException("O arquivo de imagem está vazio.");
            }

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PdfWriter writer = new PdfWriter(outputStream);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);

            ImageData imageData = ImageDataFactory.create(imageFile.getBytes());
            Image image = new Image(imageData);

            image.setAutoScale(true);
            pdfDoc.setDefaultPageSize(new PageSize(image.getImageWidth(), image.getImageHeight()));

            PdfDocumentInfo info = pdfDoc.getDocumentInfo();
            info.setTitle("Conversão de Imagem original: " + imageFile.getOriginalFilename());
            info.setCreator("Minha API Spring Boot");
            info.setSubject("PDF gerado a partir de: " + imageFile.getOriginalFilename());
            info.setKeywords("conversão, imagem, PDF, Spring Boot");

            document.setMargins(0, 0, 0, 0);
            document.add(image);
            document.close();


            return outputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao processar o arquivo de imagem: " + e.getMessage());
        }
    }

    @Override
    public byte[] converterImages2PDF(MultipartFile[] imageFiles) {
        try {
            if(imageFiles == null || imageFiles.length == 0) {
                throw new IllegalArgumentException("Nenhum arquivo de imagem fornecido.");
            }

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PdfWriter writer = new PdfWriter(outputStream);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);

            Integer pageIndex = 0;

            for (MultipartFile imageFile : imageFiles) {
                if(imageFile.isEmpty()) {
                    continue;
                }

                pageIndex++;

                ImageData imageData = ImageDataFactory.create(imageFile.getBytes());
                Image image = new Image(imageData);
                PageSize pageSize = new PageSize(image.getImageWidth(), image.getImageHeight());
                pdfDoc.setDefaultPageSize(pageSize);
                // image.setAutoScale(true);
                
                if (pageIndex > 1) {
                    document.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
                }

                document.setMargins(0, 0, 0, 0);
                document.add(image);
            }

            document.close();
            return outputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao processar os arquivos de imagem: " + e.getMessage());
        }
    }
}