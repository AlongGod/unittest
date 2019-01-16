package com.xushuzn.common.web.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public final class ResponseUtils {
    public static void writeText(String text) {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
        writeText(response, text);
    }

    public static void writeText(HttpServletResponse response, String text) {
        write(response, "text/plain; charset=UTF-8", text);
    }

    public static void write(HttpServletResponse response, String contentType, String s) {
        response.setContentType(contentType);

        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.write(s);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    private ResponseUtils() {
    }
}
