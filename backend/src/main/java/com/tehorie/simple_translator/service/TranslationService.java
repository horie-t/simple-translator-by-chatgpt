package com.tehorie.simple_translator.service;

import org.springframework.stereotype.Service;

@Service
public class TranslationService {

    // このサンプルメソッドは、実際の翻訳APIを呼び出す代わりにダミーの翻訳を返します。
    public String translate(String text, String sourceLanguage, String targetLanguage) {
        return "Translated Text: " + text + ", Source Language: " + sourceLanguage + ", Target Language: " + targetLanguage;
    }
}

