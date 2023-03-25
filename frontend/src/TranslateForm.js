import React, { useState } from 'react';
import axios from 'axios';

const TranslateForm = () => {
  const [text, setText] = useState('');
  const [sourceLanguage, setSourceLanguage] = useState('en');
  const [targetLanguage, setTargetLanguage] = useState('ja');
  const [translatedText, setTranslatedText] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('http://localhost:8080/translate', {
        text,
        sourceLanguage,
        targetLanguage,
      });
          

      setTranslatedText(response.data.translatedText);
    } catch (error) {
      console.error('Error during translation:', error);
    }
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <label>
          Text to translate:
          <input
            type="text"
            value={text}
            onChange={(e) => setText(e.target.value)}
          />
        </label>
        <label>
          Source language:
          <input
            type="text"
            value={sourceLanguage}
            onChange={(e) => setSourceLanguage(e.target.value)}
          />
        </label>
        <label>
          Target language:
          <input
            type="text"
            value={targetLanguage}
            onChange={(e) => setTargetLanguage(e.target.value)}
          />
        </label>
        <button type="submit">Translate</button>
      </form>
      <div>
        <h3>Translated text:</h3>
        <p>{translatedText}</p>
      </div>
    </div>
  );
};

export default TranslateForm;
