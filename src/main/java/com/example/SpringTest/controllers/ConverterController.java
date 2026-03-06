package com.example.SpringTest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;
import java.util.List;

import com.example.SpringTest.services.IConverterService;

@RestController
@RequestMapping("/converter")
public class ConverterController {
    @Autowired
    private IConverterService service;

    @PostMapping(value = "/converter-image2pdf", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public byte[] converterImage2PDF(@RequestParam("imagem") MultipartFile imageFile){
        return service.converterImage2PDF(imageFile); 
    }

    @PostMapping(value = "/converter-images2pdf-2", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public byte[] converterImages2PDF(@RequestParam("imagens") List<MultipartFile> imageFiles){
        return service.converterImages2PDF(imageFiles.toArray(new MultipartFile[0]));
    }
}