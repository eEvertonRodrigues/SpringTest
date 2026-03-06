package com.example.SpringTest.services;

import org.springframework.web.multipart.MultipartFile;

public interface IConverterService {
    byte[] converterImage2PDF(MultipartFile imageFile);
    byte[] converterImages2PDF(MultipartFile[] imageFiles);
}