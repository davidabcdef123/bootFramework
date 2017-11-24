package com.dave.sun.common.utils;


import org.apache.catalina.Host;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;

public class PoolManager {
    //连接池管理
    private static PoolingHttpClientConnectionManager clientConnectionManager = null;
    //重试handler
    private static HttpRequestRetryHandler httpRequestRetryHandler = null;
    //对外工具
    private static PoolManager poolManager = null;

    private static final int MAX_SOKET_TIMEOUT = 12000;

    private static final int MAX_CONNECTION_TIMEOUT = 12000;

    private static RequestConfig reqConfig = null;
    // 将最大连接数
    private int maxTotal = 100;
    // 将每个路由基础的连接
    private int defaultMaxPerRoute = 20;
    //连接失败重试次数
    private int retaryCount = 3;


    private PoolManager(int retaryCount) {
        clientConnectionManager.setMaxTotal(maxTotal);
        clientConnectionManager.setDefaultMaxPerRoute(defaultMaxPerRoute);
        if (retaryCount != -1) {
            httpRequestRetryHandler = retryHandler();
        }
    }

    /*private PoolManager() {
        clientConnectionManager.setMaxTotal(maxTotal);
        clientConnectionManager.setDefaultMaxPerRoute(defaultMaxPerRoute);
        //httpRequestRetryHandler = retryHandler();
    }*/

    /**
     * Author: Super.Sun
     * Since: 2017/11/24
     * Describe:配置RequestConfig
     * Update: [变更日期YYYY-MM-DD][更改人姓名][变更描述]
     */
    private static RequestConfig requestConfig() {
        RequestConfig reqConfig = RequestConfig.custom()
                .setSocketTimeout(MAX_SOKET_TIMEOUT)
                .setConnectTimeout(MAX_CONNECTION_TIMEOUT)
                .setStaleConnectionCheckEnabled(true).build();
        return reqConfig;
    }
    private static RequestConfig requestConfig(int timeOut) {
        RequestConfig reqConfig = RequestConfig.custom()
                .setSocketTimeout(timeOut)
                .setConnectTimeout(timeOut)
                .setStaleConnectionCheckEnabled(true).build();
        return reqConfig;
    }

    private static RequestConfig requestConfig(String proxyIp, int proxyPort,int timeOut) {
        RequestConfig reqConfig = RequestConfig.custom().setProxy(new HttpHost(proxyIp, proxyPort))
                .setSocketTimeout(timeOut)
                .setConnectTimeout(timeOut)
                .setStaleConnectionCheckEnabled(true).build();
        return reqConfig;
    }

    /**
     * Author: Super.Sun
     * Since: 2017/11/24
     * Describe:重新处理
     * Update: [变更日期YYYY-MM-DD][更改人姓名][变更描述]
     */
    private HttpRequestRetryHandler retryHandler() {
        HttpRequestRetryHandler requestRetryHandler = new HttpRequestRetryHandler() {
            @Override
            public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
                if (executionCount >= retaryCount) {// 如果已经重试了3次，就放弃
                    return false;
                }
                if (exception instanceof NoHttpResponseException) {// 如果服务器丢掉了连接，那么就重试
                    return true;
                }
                if (exception instanceof SSLHandshakeException) {// 不要重试SSL握手异常
                    return false;
                }
                if (exception instanceof InterruptedIOException) {// 超时
                    return false;
                }
                if (exception instanceof UnknownHostException) {// 目标服务器不可达
                    return false;
                }
                if (exception instanceof ConnectTimeoutException) {// 连接被拒绝
                    return false;
                }
                if (exception instanceof SSLException) {// SSL握手异常
                    return false;
                }

                HttpClientContext clientContext = HttpClientContext
                        .adapt(context);
                HttpRequest request = clientContext.getRequest();
                // 如果请求是幂等的，就再次尝试
                if (!(request instanceof HttpEntityEnclosingRequest)) {
                    return true;
                }
                return false;
            }
        };
        return requestRetryHandler;
    }

    /**
     * `
     * Author: Super.Sun
     * Since: 2017/11/24
     * Describe:获取连接池对象
     * Update: [变更日期YYYY-MM-DD][更改人姓名][变更描述]
     */
    private synchronized static PoolManager getInstance(int retaryCount) {
        if (poolManager == null) {
            poolManager = new PoolManager(retaryCount);
        }
        return poolManager;
    }


    /**
     * Author: Super.Sun
     * Since: 2017/11/24
     * Describe:获取http对象
     * Update: [变更日期YYYY-MM-DD][更改人姓名][变更描述]
     */
    /*public static CloseableHttpClient getHttpClient() {
        if (clientConnectionManager == null) {
            clientConnectionManager = new PoolingHttpClientConnectionManager();
            getInstance(-1);
        }
        return HttpClients.custom()
                .setConnectionManager(clientConnectionManager)
                .setRetryHandler(httpRequestRetryHandler).setDefaultRequestConfig(requestConfig()).build();
    }*/

    /**
     * Author: Super.Sun
     * Since: 2017/11/24
     * Describe:获取http对象
     * Update: [变更日期YYYY-MM-DD][更改人姓名][变更描述]
     */
    public static CloseableHttpClient getHttpClient(int retaryCount, String proxyIp, int proxuPort, int timeOut) {
        if (clientConnectionManager == null) {
            clientConnectionManager = new PoolingHttpClientConnectionManager();
            getInstance(retaryCount);
        }
        if(timeOut==-1){
            timeOut=MAX_SOKET_TIMEOUT;
        }
        RequestConfig requestConfig=null;
        if(proxyIp==null){
            requestConfig=requestConfig(timeOut);
        }else{
            requestConfig=requestConfig(proxyIp, proxuPort,timeOut);
        }
        return HttpClients.custom()
                .setConnectionManager(clientConnectionManager)
                .setRetryHandler(httpRequestRetryHandler).setDefaultRequestConfig(requestConfig).build();
    }


}
