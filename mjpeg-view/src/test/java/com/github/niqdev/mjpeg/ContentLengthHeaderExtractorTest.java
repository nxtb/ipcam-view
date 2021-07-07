package com.github.niqdev.mjpeg;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

public class ContentLengthHeaderExtractorTest {
    @Test
    public void contentLengthHeaderExtractor_LowerCaseWithBackslashNReturnsCorrectExtractedInteger() throws IOException {
        String exampleHeader = "--arflebarfle\nContent-type: image/jpeg\ncontent-length: 33499\n\n";
            byte[] exampleBytes = exampleHeader.getBytes(StandardCharsets.UTF_8);
        int contentLength = HeaderExtractor.parseContentLength(exampleBytes);
        assertEquals(33499, contentLength);
    }


    @Test
    public void contentLengthHeaderExtractor_UpperCaseWithBackslashNReturnsCorrectExtractedInteger() throws IOException {
        String exampleHeader = "--arflebarfle\nContent-type: image/jpeg\nContent-Length: 33499\n\n";
        byte[] exampleBytes = exampleHeader.getBytes(StandardCharsets.UTF_8);
        int contentLength = HeaderExtractor.parseContentLength(exampleBytes);
        assertEquals(33499, contentLength);
    }


    @Test
    public void contentLengthHeaderExtractor_LowerCaseWithBackslashRReturnsCorrectExtractedInteger() throws IOException {
        String exampleHeader = "--arflebarfle\rContent-type: image/jpeg\rcontent-length: 33499\r\r";
        byte[] exampleBytes = exampleHeader.getBytes(StandardCharsets.UTF_8);
        int contentLength = HeaderExtractor.parseContentLength(exampleBytes);
        assertEquals(33499, contentLength);
    }


    @Test
    public void contentLengthHeaderExtractor_UpperCaseWithBackslashRReturnsCorrectExtractedInteger() throws IOException {
        String exampleHeader = "--arflebarfle\rContent-type: image/jpeg\rContent-Length: 33499\r\r";
        byte[] exampleBytes = exampleHeader.getBytes(StandardCharsets.UTF_8);
        int contentLength = HeaderExtractor.parseContentLength(exampleBytes);
        assertEquals(33499, contentLength);
    }
}