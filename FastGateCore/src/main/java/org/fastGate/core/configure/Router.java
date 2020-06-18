package org.fastGate.core.configure;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Router {

    private String patternUrl;

    private Set<String> targetUrls;

    public static class Builder{
        private String patternUrl;

        private Set<String> targetUrls;

        public Builder(String patternUrl,String... targetUrls){
            Objects.requireNonNull(patternUrl);
            Objects.requireNonNull(targetUrls);
            if (targetUrls.length==0) throw new IllegalArgumentException("At least one target URL");
            this.patternUrl=patternUrl;
            this.targetUrls=new HashSet<String>();
            Collections.addAll(this.targetUrls, targetUrls);

        }

        public Router build( ){
            return new Router(this);

        }

    }
    private Router(Builder builder){
        this.patternUrl=builder.patternUrl;
        this.targetUrls=builder.targetUrls;
    }

    public String getSourceUrl() {
        return patternUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.patternUrl = sourceUrl;
    }

    public Set<String> getTargetUrls() {
        return targetUrls;
    }

    public void setTargetUrls(Set<String> targetUrls) {
        this.targetUrls = targetUrls;
    }
}
