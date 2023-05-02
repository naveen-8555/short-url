package com.assignment.project.service;

import com.assignment.project.Constants.AppConstants;
import com.assignment.project.model.Url;
import com.assignment.project.repository.UrlRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.assignment.project.service.GenerateShortUrl.generateRandomString;
import static com.assignment.project.service.GenerateShortUrl.isValidUrl;


@Service
@AllArgsConstructor
public class ShortUrlService {

    private UrlRepository urlRepository;


    public Url generateShortUrl(String url) {
        if (!isValidUrl(url)) {
            return null;
        }

        Url urlObject = new Url();
        urlObject.setOriginalUrl(url);
        String shortUrl = generateRandomString();
        urlObject.setShortUrl(shortUrl);
        urlObject.setCreationTime(LocalDateTime.now());
        urlObject.setGeneratedUrl("http://localhost:7000/url/shortner/" + shortUrl);
        return urlRepository.save(urlObject);
    }

    public  List<String> getOriginalUrl(String url) {
        List<String> response = new ArrayList<>();
        Url allByShortUrl = urlRepository.findByShortUrl(url).orElse(null);
        if (allByShortUrl != null) {
            LocalDateTime creationTime = allByShortUrl.getCreationTime();
            if (creationTime.plusMinutes(5).isBefore(LocalDateTime.now())) {
                response.add(AppConstants.URL_EXPIRED);
                return response;
            }
            response.add(allByShortUrl.getOriginalUrl());
        } else {
             response.add(AppConstants.URL_NOT_EXIST);
        }
        return response;
    }
}
