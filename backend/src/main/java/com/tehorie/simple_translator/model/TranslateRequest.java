package com.tehorie.simple_translator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TranslateRequest {
    private String text;
    private String sourceLanguage;
    private String targetLanguage;
}
