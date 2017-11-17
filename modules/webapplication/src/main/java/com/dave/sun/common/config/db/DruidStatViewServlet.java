package com.dave.sun.common.config.db;

import com.alibaba.druid.support.http.StatViewServlet;

/**
 * Created by Super.Sun on 2017/11/17.
 */
@Deprecated
/*@ConfigurationProperties(prefix="spring.datasource")
@WebServlet(urlPatterns = "/druid/*",
        initParams={
                @WebInitParam(name="allow",value="${allow}"),// IP白名单 (没有配置或者为空，则允许所有访问)
                @WebInitParam(name="deny",value="${deny}"),// IP黑名单 (存在共同时，deny优先于allow)
                @WebInitParam(name="loginUsername",value="${loginUsername}"),// 用户名
                @WebInitParam(name="loginPassword",value="${loginPassword}"),// 密码
                @WebInitParam(name="resetEnable",value="false")// 禁用HTML页面上的“Reset All”功能
        })*/
public class DruidStatViewServlet extends StatViewServlet {
}
