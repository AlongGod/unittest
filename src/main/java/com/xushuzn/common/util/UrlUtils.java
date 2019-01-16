package com.xushuzn.common.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public final class UrlUtils {
    private static final String DEFAULT_CHARSET = "UTF-8";

    public static String encode(String value) {
        return encode(value, DEFAULT_CHARSET);
    }

    public static String encode(String value, String charset) {
        try {
            return URLEncoder.encode(value, charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String decode(String value) {
        return decode(value, DEFAULT_CHARSET);
    }

    public static String decode(String value, String charset) {
        try {
            return URLDecoder.decode(value, charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private UrlUtils() {
    }
}
