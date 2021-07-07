package com.github.niqdev.mjpeg;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

public class ContentLengthHeaderExtractorTest {
    @Test
    public void contentLengthHeaderExtractor_LowerCaseReturnsCorrectExtractedInteger() throws IOException {
        String exampleHeader = "--arflebarfle\nContent-type: image/jpeg\ncontent-length: 33499\n\n";
            byte[] exampleBytes = exampleHeader.getBytes(StandardCharsets.UTF_8);
        int contentLength = HeaderExtractor.parseContentLength(exampleBytes);
        assertEquals(33499, contentLength);
    }


    @Test
    public void contentLengthHeaderExtractor_UpperCaseReturnsCorrectExtractedInteger() throws IOException {
        String exampleHeader = "--arflebarfle\nContent-type: image/jpeg\nContent-Length: 33499\n\n";
        byte[] exampleBytes = exampleHeader.getBytes(StandardCharsets.UTF_8);
        int contentLength = HeaderExtractor.parseContentLength(exampleBytes);
        assertEquals(33499, contentLength);
    }
}