package com.dave.sun.common.config.db;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Created by Super.Sun on 2017/11/17.
 */
@Deprecated
/*@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",
        initParams={
                @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")// 忽略资源
        })*/
public class DruidStatFilter extends WebStatFilter {
}
