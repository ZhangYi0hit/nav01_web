package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashMap;


    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    public class Post {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private Integer id;


        private String postDate;


        private String postTime;

        @NotNull(message="Please enter a title.")
        @Size(min=1, max = 50, message = "Title can not be longer than 50 characters")

        private String title;

        @NotNull(message="Post should not be empty.")
        private String content;

        @NotNull
        private String tag;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;






    }
