package org.fastGate.core.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class URLUtils {

    public static void parsePatternUrl(String patternUrl){
        if (StringUtils.isBlank(patternUrl)||patternUrl.length()<2) throw new IllegalArgumentException();
        List<UrlPatternEntry> urlPatternEntries=new ArrayList<>();
        for (String s:patternUrl.split("/")){
            //urlPatternEntries
        }

    }
}
