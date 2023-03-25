package com.tehorie.simple_translator.service;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TranslationService {

    @Value("${translation.apiKey:${TRANSLATION_API_KEY}}")
    private String apiKey;

    public String translate(String text, String sourceLanguage, String targetLanguage) {
        // APIキーを使用して、Google Cloud Translation APIクライアントを作成します。
        Translate translate = TranslateOptions.newBuilder()
                .setApiKey(apiKey)
                .build()
                .getService();

        // リクエストの構成を指定して、翻訳を実行します。
        Translation translation = translate.translate(
                text,
                Translate.TranslateOption.sourceLanguage(sourceLanguage),
                Translate.TranslateOption.targetLanguage(targetLanguage)
        );

        // 翻訳されたテキストを返します。
        return translation.getTranslatedText();
    }
}
