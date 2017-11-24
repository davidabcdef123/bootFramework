package com.dave.sun.common.utils;

/**
 * httpclient工具类
 * @author fengjifei
 *
 */
@Deprecated
public class HttpClientUtil {

	/*public static String post(String url, Map<String, String> params) {
	    CloseableHttpClient httpClient =PoolManager.getHttpClient();
		String body = null;
		
		HttpPost post = postForm(url, params);
		body = invoke(httpClient, post);
		return body;
	}

	public static String get(String url) {
	    CloseableHttpClient httpClient =PoolManager.getHttpClient();
		String body = null;
		HttpGet get = new HttpGet(url);
		body = invoke(httpClient, get);
		return body;
	}

	private static String invoke(CloseableHttpClient httpclient,HttpUriRequest httpost) {
		HttpResponse response = sendRequest(httpclient, httpost);
		String body = paseResponse(response);
		return body;
	}

	private static String paseResponse(HttpResponse response) {

		HttpEntity entity = response.getEntity();

		String charset = EntityUtils.getContentCharSet(entity);

		String body = null;
		try {
			body = EntityUtils.toString(entity);
	
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return body;
	}

	private static HttpResponse sendRequest(HttpClient httpclient,
			HttpUriRequest httpost) {

		HttpResponse response = null;

		try {
			response = httpclient.execute(httpost);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}

	private static HttpPost postForm(String url, Map<String, String> params) {
		HttpPost httpost = new HttpPost(url);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		Set<String> keySet = params.keySet();
		for (String key : keySet) {
			nvps.add(new BasicNameValuePair(key, params.get(key)));
			httpost.addHeader(key, params.get(key));
		}
		try {
			//log.info("set utf-8 form entity to httppost");
			httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return httpost;
	}
	public static void main(String[] args) {
	   String sss= post("http://10.88.106.32:8081/kass/openapi/FileTranModel/doFiletran",new HashMap());
	   System.out.println(sss);
	}*/
}