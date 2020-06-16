package org.fastGate.core.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface GateWayFilter {

    public String urlPattern();

    public int order() default org.fastGate.core.server.GateWayFilter.MIN_ORDER;
}
