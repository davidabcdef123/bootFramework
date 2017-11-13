package com.dave.sun.common.utils;

import org.apache.commons.lang.StringUtils;

/**
 * Created by Super.Sun on 2017/11/11.
 */
public class Utils {

    /**
     * 去除字符窜尾字符
     *
     * @param str     字符串
     * @param charStr 尾字符
     * @return string
     */
    public static String TrimEnd(String str, String charStr) {
        if (!StringUtils.isEmpty(str) && !StringUtils.isEmpty(charStr)) {
            if (str.substring(str.length() - 1).equals(charStr)) {
                return str.substring(0, str.length() - 1);
            }
        }
        return str;
    }

}
