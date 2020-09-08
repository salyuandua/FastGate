package org.fastGate.core.utils;

import org.springframework.web.client.RestTemplate;

public class RestTemplateUtils {

    private static final RestTemplate restTemplate=new RestTemplate();

    public static RestTemplate getRestTemplate(){
        return restTemplate;
    }
}
