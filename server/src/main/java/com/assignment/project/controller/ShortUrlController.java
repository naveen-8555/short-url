package com.assignment.project.controller;

import com.assignment.project.model.Url;
import com.assignment.project.service.ShortUrlService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("shortUrl")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class ShortUrlController {


    private ShortUrlService shortUrlService;

    @GetMapping("/{url}")
    public List<String> getOriginalUrl(@PathVariable("url") String url) {
        return shortUrlService.getOriginalUrl(url);
    }

    @PostMapping
    public Url generateShortUrl(@RequestBody String url) {
        return shortUrlService.generateShortUrl(url);
    }

}
