package com.tehorie.simple_translator.controller;

import com.tehorie.simple_translator.model.TranslateRequest;
import com.tehorie.simple_translator.model.TranslateResponse;
import com.tehorie.simple_translator.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/translate")
public class TranslateController {

    @Autowired
    private TranslationService translationService;

    @PostMapping
    public ResponseEntity<TranslateResponse> translate(@RequestBody TranslateRequest request) {
        try {
            String translatedText = translationService.translate(request.getText(),
                    request.getSourceLanguage(), request.getTargetLanguage());

            TranslateResponse response = new TranslateResponse(translatedText);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
