package com.keduit.amigo.config;

public class AjaxUtils {

    public static boolean isAjaxRequest(String requestedWith) {
        return "XMLHttpRequest".equals(requestedWith);
    }

}
