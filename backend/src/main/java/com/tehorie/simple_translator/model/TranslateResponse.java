package com.tehorie.simple_translator.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TranslateResponse {
    private String translatedText;
}
