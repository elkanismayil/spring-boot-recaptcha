package com.javacoder.springbootrecaptcha.util;

import com.javacoder.springbootrecaptcha.model.CaptchaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CaptchaValidator {

    @Autowired
    private RestTemplate restTemplate;

    public boolean isValidCaptcha(String captcha) {
        String url = "https://www.google.com/recaptcha/api/siteverify";
        String params = "?secret=6LfGvkEaAAAAAOin3qWmz8uziTTMhbgMj2wC_hFg&response=" + captcha;
        String completeUrl = url + params;
        CaptchaResponse resp = restTemplate.postForObject(completeUrl, null, CaptchaResponse.class);
        return resp.isSuccess();
    }
}
