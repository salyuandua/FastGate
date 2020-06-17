package org.fastGate.core.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * Some validators used in gateway
 *
 * @author Xuejian Li
 */
public class GateWayValidator {

    public static boolean validateUrlPattern(String urlPattern){
        if (StringUtils.isBlank(urlPattern)) return false;
        urlPattern=StringUtils.trim(urlPattern);
        if (urlPattern.length()<2) return false;
        char[] urlPatternArr=urlPattern.toCharArray();
        if (urlPatternArr[0]!='/') return false;

        return true;
    }
}
