package com.assignment.project.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String shortUrl;
    private String originalUrl;
    private LocalDateTime creationTime;
    private String generatedUrl;
}
