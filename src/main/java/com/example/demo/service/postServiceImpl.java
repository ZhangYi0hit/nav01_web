package com.example.demo.service;

import com.example.demo.model.Post;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class postServiceImpl {



    public Post getJson(String post) {
        Post postJson = new Post();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            postJson = objectMapper.readValue(post, Post.class);

        }catch(IOException e) {
            System.out.printf("Error", e.toString());
        }
//		GalleryItem photo = galleryItemRepo.findById(galleryItemId).get();
//		postJson.setGalleryItem(photo);

        return postJson;
    }
}
