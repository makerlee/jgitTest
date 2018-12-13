package com.example.demo.utils;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.net.URI;

/**
 * Created by WANPENG726 on 2018/9/5.
 */
public class HttpClientUtil {

    // CONNECT_TIMEOUT
    public static final int HTTP_CONNECT_TIMEOUT_10S = 10 * 1000;
    // READ_TIMEOUT
    public static final int HTTP_READ_TIMEOUT_30S = 30 * 1000;

    public static String doPost(URI uri, String reqJson) throws Exception {
        String result = null;
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            httpClient = HttpClients.createDefault();
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(HTTP_CONNECT_TIMEOUT_10S).setConnectionRequestTimeout(HTTP_CONNECT_TIMEOUT_10S).setSocketTimeout(HTTP_READ_TIMEOUT_30S).build();
            StringEntity entity = new StringEntity(reqJson, "UTF-8");
            entity.setContentType("application/json");
            HttpPost httpPost = new HttpPost(uri);
            httpPost.setConfig(requestConfig);
            httpPost.setEntity(entity);
            response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == 200) {
                result = EntityUtils.toString(response.getEntity(), "UTF-8");
            }else {

            }
        } catch (Exception ex) {

        } finally {
            if (null != response) {
                response.close();
            }
            if (null != httpClient) {
                httpClient.close();
            }
        }
        return result;
    }
    public static String doPost(URI uri, String reqJson,int retryTimes) throws Exception {
          while (retryTimes>0){
              String result=doPost(uri,reqJson);
              if(null==result){
                  retryTimes--;
                  continue;
              }else {
                  return result;
              }
          }
          return null;
    }

    public static String doGet(URI uri) throws Exception {
        String result = null;
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            httpClient = HttpClients.createDefault();
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(HTTP_CONNECT_TIMEOUT_10S).setConnectionRequestTimeout(HTTP_CONNECT_TIMEOUT_10S).setSocketTimeout(HTTP_READ_TIMEOUT_30S).build();
            HttpGet httpGet = new HttpGet(uri);
            httpGet.setConfig(requestConfig);
            response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                result = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
            else {

            }
        }
        catch (Exception ex) {

        }
        finally {
            if (null != response) {
                response.close();
            }
            if (null != httpClient) {
                httpClient.close();
            }
        }
        return result;
    }
}
