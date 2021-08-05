package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Table(name="user")
    public class User {

        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)

        private Integer id;

        @Column(nullable=false)
        @NotEmpty()

        private String userName;


        private String name;

        @Email(message="{errors.invalid_email}")

        private String email;

    }

