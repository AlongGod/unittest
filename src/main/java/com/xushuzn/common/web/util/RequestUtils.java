package com.xushuzn.common.web.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public final class RequestUtils {
    private static final String[] PROXY_IP_HEADER_NAMES = { "X-Forwarded-For", "Proxy-Client-IP", "WL-Proxy-Client-IP" };

    public static String getRequestURI() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        return getRequestURI(request);
    }

    public static String getRequestURIWithQueryString() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        return getRequestURIWithQueryString(request);
    }

    public static String getClientIp() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        return getClientIp(request);
    }

    public static String getRequestInfo(String... hiddenParams) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        return getRequestInfo(request, hiddenParams);
    }

    public static String getRequestURI(HttpServletRequest request) {
        return request.getRequestURI();
    }

    public static String getRequestURIWithQueryString(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder(getRequestURI(request));
        String queryString = request.getQueryString();
        if (StringUtils.isNotEmpty(queryString)) {
            sb.append("?").append(queryString);
        }
        return sb.toString();
    }

    public static String getClientIp(HttpServletRequest request) {
        String ip = null;
        for (String name : PROXY_IP_HEADER_NAMES) {
            ip = request.getHeader(name);
            if (StringUtils.isNotEmpty(ip) && StringUtils.indexOf(ip, ',') != -1) {
                String[] ss = StringUtils.split(ip, ',');
                ip = ss[0];
                if ("unknown".equalsIgnoreCase(ip)) {
                    ip = ss[1];
                }
            }
            if (StringUtils.isNotEmpty(ip) && !"unknown".equalsIgnoreCase(ip)) {
                break;
            }
        }

        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        return StringUtils.trim(ip);
    }

    public static String getRequestInfo(HttpServletRequest request, String... hiddenParams) {
        StringBuilder sb = new StringBuilder();

        // Method
        sb.append(request.getMethod()).append(" ");

        // Request URI
        sb.append(request.getRequestURI());

        // Query String
        if (StringUtils.isNotEmpty(request.getQueryString())) {
            sb.append("?").append(request.getQueryString());
        }

        sb.append("\n");

        // Forward
        String forwardUri = (String) request.getAttribute("javax.servlet.forward.request_uri");
        if (StringUtils.isNotEmpty(forwardUri)) {
            sb.append("Forward From: ").append(forwardUri);

            String forwardQueryString = (String) request.getAttribute("javax.servlet.forward.query_string");
            if (StringUtils.isNotEmpty(forwardQueryString)) {
                sb.append("?").append(forwardQueryString);
            }

            String forwardPathInfo = (String) request.getAttribute("javax.servlet.forward.path_info");
            if (StringUtils.isNotEmpty(forwardPathInfo)) {
                sb.append(", Path Info: ").append(forwardPathInfo);
            }

            sb.append("\n");
        }

        // Include
        String includeUri = (String) request.getAttribute("javax.servlet.include.request_uri");
        if (StringUtils.isNotEmpty(includeUri)) {
            sb.append("Include From: ").append(includeUri);

            String includeQueryString = (String) request.getAttribute("javax.servlet.include.query_string");
            if (StringUtils.isNotEmpty(includeQueryString)) {
                sb.append("?").append(includeQueryString);
            }

            String includePathInfo = (String) request.getAttribute("javax.servlet.include.path_info");
            if (StringUtils.isNotEmpty(includePathInfo)) {
                sb.append(", Path Info: ").append(includePathInfo);
            }

            sb.append("\n");
        }

        // Remote IP Address
        sb.append("Remote IP Address: ").append(getClientIp(request)).append("\n");

        // User Agent
        sb.append("User-Agent: ").append(request.getHeader("User-Agent")).append("\n");

        // Referer
        String referer = request.getHeader("Referer");
        if (StringUtils.isNotEmpty(referer)) {
            sb.append("Referer: ").append(referer).append("\n");
        }

        // Parameters
        sb.append("Parameters: ");
        boolean first = true;
        for (Object object : request.getParameterMap().keySet()) {
            String key = object.toString();

            if (!first) {
                sb.append("&");
            } else {
                first = false;
            }

            sb.append(key).append("=");

            boolean hidden = false;
            if (hiddenParams != null) {
                for (String hiddenParam : hiddenParams) {
                    if (key.equals(hiddenParam)) {
                        hidden = true;
                        break;
                    }
                }
            }

            if (!hidden) {
                sb.append(StringUtils.join(request.getParameterValues(key), ","));
            } else {
                sb.append("******");
            }
        }

        return sb.toString();
    }

    public static String replaceParamValue(String url, String paramName, String paramValue) {
        StringBuilder sb = new StringBuilder();

        String str = paramName + "=";
        if (url.indexOf("?") != -1) {
            int idx = url.indexOf(str);
            if (idx != -1) {
                int ampIdx = url.indexOf("&", idx);
                if (ampIdx != -1) {
                    sb.append(url.substring(0, idx));
                    if (paramValue != null) {
                        sb.append(str).append(paramValue).append(url.substring(ampIdx));
                    } else {
                        sb.append(url.substring(ampIdx + 1));
                    }
                } else {
                    if (paramValue != null) {
                        sb.append(url.substring(0, idx)).append(str).append(paramValue);
                    } else {
                        sb.append(url.substring(0, idx - 1));
                    }
                }
            } else {
                sb.append(url);
                if (paramValue != null) {
                    sb.append("&").append(str).append(paramValue);
                }
            }
        } else {
            sb.append(url);
            if (paramValue != null) {
                sb.append("?").append(str).append(paramValue);
            }
        }

        return sb.toString();
    }

    private RequestUtils() {
    }
}
