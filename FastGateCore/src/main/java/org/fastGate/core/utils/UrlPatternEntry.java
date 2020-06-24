package org.fastGate.core.utils;

public class UrlPatternEntry {

    private String url;
    private boolean isEnd;

    public UrlPatternEntry(){

    }


    public UrlPatternEntry(String url, boolean isEnd) {
        this.url = url;
        this.isEnd = isEnd;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }
}
