package com.assignment.project.service;

import com.assignment.project.Constants.AppConstants;
import org.apache.commons.validator.routines.UrlValidator;

import java.util.Random;

public class GenerateShortUrl {

    public static String generateRandomString() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < AppConstants.LENGTH; i++) {
            sb.append(AppConstants.CHARACTERS.charAt(random.nextInt(AppConstants.CHARACTERS.length())));
        }
        sb.append(AppConstants.CHARACTERS.charAt(random.nextInt(52)));
        return sb.toString();
    }

    public static boolean isValidUrl(String url) {
        UrlValidator urlValidator = new UrlValidator(
               new String[]{"http","https"}
        );
        return  urlValidator.isValid(url);
    }

}
