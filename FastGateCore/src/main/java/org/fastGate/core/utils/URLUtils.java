package org.fastGate.core.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;
import java.util.List;

public class URLUtils {

    public static LinkedList<UrlPatternEntry> parsePatternUrl(String patternUrl){
        if (StringUtils.isBlank(patternUrl)||patternUrl.length()<2) throw new IllegalArgumentException();
        LinkedList<UrlPatternEntry> urlPatternEntries=new LinkedList<>();
        String[] splitUrls=patternUrl.split("/");
        for (int i=0;i<splitUrls.length;i++){
            UrlPatternEntry urlPatternEntry=new UrlPatternEntry("/"+splitUrls[i],false);
            if (i==splitUrls.length-1) urlPatternEntry.setEnd(true);
            urlPatternEntries.add(urlPatternEntry);
        }
        return urlPatternEntries;

    }
}
