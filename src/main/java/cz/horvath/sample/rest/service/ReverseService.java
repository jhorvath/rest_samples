package cz.horvath.sample.rest.service;

import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class ReverseService {

    private static final char[] AEIOU = {'a', 'e', 'i', 'o', 'u', 'á', 'é', 'ě', 'í', 'ó', 'ú', 'ů'};

    /**
     * Creates a string with reversed order of characters. In the result string
     * it replaces 1+ spaces by a single space and makes uppercase characters at
     * index of vowels in original string. It also works with Czech characters
     *
     * @param sentence
     * @return
     */
    public String reverseString(String sentence) {
        String normalized = sentence.replaceAll("\\ +", " ").toLowerCase();
        char[] result = new char[normalized.length()];

        for (int i = 0; i < normalized.length(); i++) {
            char ch = normalized.charAt(normalized.length() - 1 - i);
            for (int j = 0; j < AEIOU.length; j++) {
                if (normalized.charAt(i) == AEIOU[j]) {
                    ch = Character.toUpperCase(ch);
                    break;
                }
            }
            result[i] = ch;
        }
        return String.valueOf(result);
    }
}
