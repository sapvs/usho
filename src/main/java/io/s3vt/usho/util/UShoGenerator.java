package io.s3vt.usho.util;

import java.util.Random;

public class UShoGenerator {
    private static final String data = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNPPQRSTUVWXYZ1234567890";
    private static final Random rand = new Random();

    public static String generateShortUrl(int length) {
        StringBuilder retString = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            retString.append(data.charAt(rand.nextInt(data.length() - 1))
            );
        }
        return retString.toString();
    }
}
