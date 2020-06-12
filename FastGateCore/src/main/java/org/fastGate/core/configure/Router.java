package org.fastGate.core.configure;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Router {

    private String sourceUrl;

    private Set<String> targetUrls;

    public static class Builder{
        private String sourceUrl;

        private Set<String> targetUrls;

        public Builder(String sourceUrl,String... targetUrls){
            Objects.requireNonNull(sourceUrl);
            Objects.requireNonNull(targetUrls);
            if (targetUrls.length==0) throw new IllegalArgumentException("At least one target URL");
            this.sourceUrl=sourceUrl;
            this.targetUrls=new HashSet<String>();
            Collections.addAll(this.targetUrls, targetUrls);

        }

        public Router build( ){
            return new Router(this);

        }

    }





    private Router(Builder builder){
        this.sourceUrl=builder.sourceUrl;
        this.targetUrls=builder.targetUrls;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public Set<String> getTargetUrls() {
        return targetUrls;
    }

    public void setTargetUrls(Set<String> targetUrls) {
        this.targetUrls = targetUrls;
    }
}
