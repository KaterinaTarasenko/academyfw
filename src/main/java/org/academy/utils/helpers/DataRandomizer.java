package org.academy.utils.helpers;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;

public class DataRandomizer {
    private static final String ALPHABET_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ALPHABET_LOWER = "abcdefghijklmnoprstuvwxyz";

    /**
     * Generate random string with Uppercase and Lowercase chars
     *
     * @param count = chars
     * @return random string
     */
    public String getRandomString(int count) {
        String alphaBet = ALPHABET_LOWER + ALPHABET_UPPER;
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; ++i) {
            sb.append(alphaBet.charAt(secureRandom.nextInt(alphaBet.length())));
        }
        return sb.toString();
    }

    /**
     * Generates random string where each word starts from Uppercase char
     *
     * @param countWords               = count words separated with space
     * @param countAlphabetsInEachWord = count chars in each word
     * @return string like "Fsbd Hsdf Jsdf"
     */
    public StringBuilder getRandomStringStartsUpperCase(int countWords, Integer... countAlphabetsInEachWord) {
        StringBuilder word = new StringBuilder();

        Collections.reverse(Arrays.asList(countAlphabetsInEachWord));
        int queueInCountAlphabet = countAlphabetsInEachWord.length;
        for (int i = 0; i < countWords; i++) {
            queueInCountAlphabet = queueInCountAlphabet - 1;
            if (queueInCountAlphabet < 0) {
                queueInCountAlphabet = 0;
            }
            word
                    .append(getRandomString(1).toUpperCase())
                    .append(getRandomString(countAlphabetsInEachWord[Math.abs(queueInCountAlphabet)] - 1)
                            .toLowerCase());
            if (i != countWords - 1) {
                word.append(" ");
            }
        }
        return word;
    }
}
