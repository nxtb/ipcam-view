package com.github.niqdev.mjpeg;

import java.io.IOException;

public class HeaderExtractor {

    static int parseContentLength(byte[] headerBytes) throws IOException, IllegalArgumentException {
        String CONTENT_LENGTH = "Content-Length";

        int j = 0;
        int i = 0;
        while (i < headerBytes.length && j < CONTENT_LENGTH.length()) {
            if (headerBytes[i] == Character.toUpperCase(CONTENT_LENGTH.charAt(j)) || headerBytes[i] == Character.toLowerCase(CONTENT_LENGTH.charAt(j))) {
                j++;
            }
            i++;
        }

        if(j != CONTENT_LENGTH.length()) {
            return -1;
        }

        // :
        i++;

        // <space> after :
        i++;

        int end = i;

        // UNTIL the \n at the end of the line
        while(!isNewlineOrCR(headerBytes[end])) {
            end++;
        }

        return Integer.parseInt(new String(headerBytes, i, end-i));
    }

    private static Boolean isNewlineOrCR(byte byteToCheck){
        return byteToCheck == '\n' || byteToCheck == '\r';
    }

}
