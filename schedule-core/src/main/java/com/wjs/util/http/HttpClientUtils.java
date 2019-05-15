package com.wjs.util.http;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;  

/**
 * 
 * @author suzhenyin
 *
 */
public class HttpClientUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientUtils.class);

	// 默认连接超时时间，单位：毫秒
	private static final int DEFAULT_CONNECTION_TIMEOUT = 5000;
	// 默认请求超时时间，单位：毫秒
	private static final int DEFAULT_SOCKET_TIMEOUT = 10000;
	// 默认请求重试次数
	private static final int DEFAULT_RETRY_TIMES = 0;

	// 默认字符集
	private static final String DEFAULT_CHARSET = "UTF-8";

	private HttpClientUtils() {
	}

	private static HttpClient getHttpClient() {
		SocketConfig socketConfig = SocketConfig.custom().setTcpNoDelay(true)
						.build();
		PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
		connManager.setMaxTotal(360); // 将最大连接数增加到300
		connManager.setDefaultMaxPerRoute(60);// 将每个路由基础的连接增加到60
		connManager.setDefaultSocketConfig(socketConfig);
		HttpClient httpClient = HttpClients.custom()
						.setConnectionManager(connManager)
						.setRetryHandler(new HttpRequestRetryHandler() {
							@Override
							public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
								if (executionCount >= DEFAULT_RETRY_TIMES) {
									LOGGER.error(String.format("httprequest retry over %s times", DEFAULT_RETRY_TIMES));
									return false;
								}
								if (exception instanceof InterruptedIOException) {
									LOGGER.error("httprequest ioException");
									return true;
								}
								if (exception instanceof UnknownHostException) {
									LOGGER.error("httprequest UnknownHostException");
									return true;
								}
								if (exception instanceof ConnectTimeoutException) {
									// 连接被拒绝
									LOGGER.error("httprequest connection rejected!");
									return true;
								}
								if (exception instanceof SSLException) {
									LOGGER.error("httprequest ssl handshake rejected!");
									return true;
								}
								return false;
							}
						}).build();
		return httpClient;
	}

	private static HttpClient getSSLHttpClient() {
		SocketConfig socketConfig = SocketConfig.custom().setTcpNoDelay(true)
						.build();
		

		SSLContext sslContext = null;
		try {
			sslContext = HttpClientSslUtils.createIgnoreVerifySSL();  
		} catch (Exception e) {
			LOGGER.error(String.format("SSL HttpClient init error: %s", e.getMessage()), e);
		}
		Registry<ConnectionSocketFactory> socketFactoryRegistry   = RegistryBuilder.<ConnectionSocketFactory>create().register("http",  
                PlainConnectionSocketFactory.INSTANCE).register("https",  
                new SSLConnectionSocketFactory(sslContext,SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER)).build();  
		
		PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
		connManager.setMaxTotal(360); // 将最大连接数增加到300
		connManager.setDefaultMaxPerRoute(60);// 将每个路由基础的连接增加到60
		connManager.setDefaultSocketConfig(socketConfig);
		


		HttpClient httpClient = HttpClients.custom()
						.setConnectionManager(connManager)
						.setRetryHandler(new HttpRequestRetryHandler() {
							@Override
							public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
								if (executionCount >= DEFAULT_RETRY_TIMES) {
									LOGGER.error(String.format("httprequest retry over %s times", DEFAULT_RETRY_TIMES));
									return false;
								}
								if (exception instanceof InterruptedIOException) {
									LOGGER.error("httprequest ioException");
									return true;
								}
								if (exception instanceof UnknownHostException) {
									LOGGER.error("httprequest UnknownHostException");
									return true;
								}
								if (exception instanceof ConnectTimeoutException) {
									// 连接被拒绝
									LOGGER.error("httprequest connection rejected!");
									return true;
								}
								if (exception instanceof SSLException) {
									LOGGER.error("httprequest ssl handshake rejected!");
									return true;
								}
								return false;
							}
						}).build();
		return httpClient;
	}

	private static ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
		@Override
		public String handleResponse(final HttpResponse response) throws IOException {
			StatusLine statusLine = response.getStatusLine();
			HttpEntity entity = response.getEntity();
			if (statusLine.getStatusCode() >= 300) {
				throw new HttpResponseException(statusLine.getStatusCode(),
								statusLine.getReasonPhrase());
			}
			if (entity == null) {
				throw new ClientProtocolException(
								"Response contains no content");
			}
			ContentType contentType = ContentType.getOrDefault(entity);
			Charset charset = contentType.getCharset();
			String body = EntityUtils.toString(response.getEntity(), charset);
			return body;
		}
	};

	/**
	 * get 请求底层实现
	 * 
	 * @param httpClient -- 区分普通请求或者SSL请求
	 * @param url
	 * @param connectionTimeout
	 * @param socketTimeout
	 * @param charsetName
	 * @return
	 * @throws IOException
	 */
	private static String get(HttpClient httpClient, String url, Integer connectionTimeout, Integer socketTimeout, String charsetName) throws IOException {
		RequestConfig requestConfig = RequestConfig.custom()
						.setSocketTimeout(socketTimeout)
						.setConnectTimeout(connectionTimeout)
						.setConnectionRequestTimeout(connectionTimeout)
						.setCookieSpec(CookieSpecs.BROWSER_COMPATIBILITY).build();
		long tStart = System.currentTimeMillis();
		String result = null;
		HttpGet httpget = new HttpGet(url);
		httpget.setConfig(requestConfig);
		result = httpClient.execute(httpget, responseHandler);
		LOGGER.info(String.format("http get.cost:%s,url:%s,result:%s", System.currentTimeMillis() - tStart, url, result));
		return result;
	}

	/**
	 * post 请求底层实现
	 * 
	 * @param httpClient -- 区分普通请求或者SSL请求
	 * @param url
	 * @param data
	 * @param encodeCharset
	 * @param decodeCharset
	 * @param connectionTimeout
	 * @param socketTimeout
	 * @return
	 * @throws IOException
	 */
	private static String post(HttpClient httpClient, String url, Map<String, Object> data, String encodeCharset, String decodeCharset, Integer connectionTimeout, Integer socketTimeout) throws IOException {
		RequestConfig requestConfig = RequestConfig.custom()
						.setSocketTimeout(socketTimeout)
						.setConnectTimeout(connectionTimeout)
						.setConnectionRequestTimeout(connectionTimeout)
						.setCookieSpec(CookieSpecs.BROWSER_COMPATIBILITY).build();

		long t1 = System.currentTimeMillis();
		if (StringUtils.isEmpty(url)) {
			LOGGER.error("manual_error:post url is null");
			throw new NullPointerException();
		}
		HttpPost httpPost = new HttpPost(url);
		String result = null;

		UrlEncodedFormEntity entity = null;
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		if (!MapUtils.isEmpty(data)) {
			for (Map.Entry<String, Object> nameValuePair : data.entrySet()) {
				nvps.add(new BasicNameValuePair(nameValuePair.getKey(),
								String.valueOf(nameValuePair.getValue())));
			}
		}

		try {
			entity = new UrlEncodedFormEntity(nvps, encodeCharset);
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("UnsupportedEncoding:" + encodeCharset, e);
		}
		httpPost.setConfig(requestConfig);
		httpPost.setEntity(entity);
		try {
			result = httpClient.execute(httpPost, responseHandler);
			LOGGER.info(String.format("http post.succed.cost:%s, url:%s,params:%s,result:%s", (System.currentTimeMillis() - t1), url, String.valueOf(data), result));
			
		} catch (Exception e) {
			LOGGER.error(String.format("http post.error.cost:%s, url:%s,params:%s,result:%s", (System.currentTimeMillis() - t1), url, String.valueOf(data), result));
			throw new RuntimeException(e);
		}
		LOGGER.info(String.format("http post.cost:%s, url:%s,params:%s,result:%s", (System.currentTimeMillis() - t1), url, String.valueOf(data), result));
		return result;
	}

	/**
	 * 发送一个普通get请求, 连接超时时间、请求超时时间、编码字符集均可设置
	 * 
	 * @param url
	 * @param connectionTimeout
	 * @param socketTimeout
	 * @param charsetName
	 * @return
	 * @throws IOException
	 */
	public static String get(String url, Integer connectionTimeout, Integer socketTimeout, String charsetName) throws IOException {
		HttpClient httpClient = getHttpClient();
		return get(httpClient, url, connectionTimeout, socketTimeout, charsetName);
	}

	/**
	 * 发送一个普通get请求, 连接超时时间、请求超时时间、编码字符集均使用默认值
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static String get(String url) throws IOException {
		return get(url, DEFAULT_CONNECTION_TIMEOUT,
						DEFAULT_SOCKET_TIMEOUT, DEFAULT_CHARSET);
	}

	/**
	 * 发送一个普通get请求,返回HttpResponse, 连接超时时间、请求超时时间、编码字符集均使用默认值
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static HttpResponse doGet(String url) throws IOException {
		return doGet(url, DEFAULT_CONNECTION_TIMEOUT,
						DEFAULT_SOCKET_TIMEOUT, DEFAULT_CHARSET);
	}
	/**
	 * 发送一个普通get请求,返回HttpResponse
	 * @param url
	 * @param connectionTimeout
	 * @param socketTimeout
	 * @param charsetName
	 * @return
	 * @throws IOException
	 */
	public static HttpResponse doGet(String url, Integer connectionTimeout, Integer socketTimeout, String charsetName) throws IOException {
		HttpClient httpclient = getHttpClient();
		HttpGet httpget = new HttpGet(url);
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout)
				.setConnectTimeout(connectionTimeout).setConnectionRequestTimeout(connectionTimeout)
				.setCookieSpec(CookieSpecs.BROWSER_COMPATIBILITY).build();
		httpget.setConfig(requestConfig);

		HttpResponse response = httpclient.execute(httpget);
		return response;
	}
	
	/**
	 * 发送一个普通get请求, 连接超时时间、请求超时时间、编码字符集均可设置。该请求屏蔽异常，异常时返回null
	 * 
	 * @param url
	 * @param connectionTimeout
	 * @param socketTimeout
	 * @param charsetName
	 * @return
	 */
	public static String getWithoutException(String url, Integer connectionTimeout, Integer socketTimeout, String charsetName) {
		try {

			return get(url, connectionTimeout, socketTimeout,
							charsetName);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}
	}

	/**
	 * 发送一个普通get请求, 连接超时时间、请求超时时间、编码字符集均使用默认值。该请求屏蔽异常，异常时返回null
	 * 
	 * @param url
	 * @return
	 */
	public static String getWithoutException(String url) {
		try {
			return get(url);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}
	}

	/**
	 * 发送一个普通post请求, 连接超时时间、请求超时时间、编码字符集均可定制
	 * 
	 * @param url
	 * @param data
	 * @param encodeCharset
	 * @param decodeCharset
	 * @param connectionTimeout
	 * @param socketTimeout
	 * @return
	 * @throws IOException
	 */
	public static String post(String url, Map<String, Object> data, String encodeCharset, String decodeCharset, Integer connectionTimeout, Integer socketTimeout) throws IOException {
		HttpClient httpClient = getHttpClient();
		return post(httpClient, url, data, encodeCharset,
						decodeCharset, connectionTimeout,
						socketTimeout);
	}

	/**
	 * 发送一个普通post请求，编解码字符集、超时时间均使用默认值
	 * 
	 * @param url
	 * @param data
	 * @return
	 * @throws IOException
	 */
	public static String post(String url, Map<String, Object> data) throws IOException {
		return post(url, data, DEFAULT_CHARSET,
						DEFAULT_CHARSET, DEFAULT_CONNECTION_TIMEOUT,
						DEFAULT_SOCKET_TIMEOUT);
	}

	/**
	 * 发送一个普通post请求，编解码字符集、超时时间均可定制，屏蔽异常，异常时返回null
	 * 
	 * @param url
	 * @param data
	 * @param encodeCharset
	 * @param decodeCharset
	 * @param connectionTimeout
	 * @param socketTimeout
	 * @return
	 */
	public static String postWithoutException(String url, Map<String, Object> data, String encodeCharset, String decodeCharset, Integer connectionTimeout, Integer socketTimeout) {
		try {
			return post(url, data, encodeCharset,
							decodeCharset, connectionTimeout, socketTimeout);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);

			return null;
		}
	}

	/**
	 * 发送一个普通post请求，编解码字符集、超时时间均使用默认值，屏蔽异常，异常时返回null
	 * 
	 * @param url
	 * @param data
	 * @return
	 */
	public static String postWithoutException(String url, Map<String, Object> data) {
		try {
			return post(url, data);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}
	}

	/**
	 * 发送一个SSL get请求, 连接超时时间、请求超时时间、编码字符集均可设置
	 * 
	 * @param url
	 * @param connectionTimeout
	 * @param socketTimeout
	 * @param charsetName
	 * @return
	 * @throws IOException
	 */
	public static String getSSL(String url, Integer connectionTimeout, Integer socketTimeout, String charsetName) throws IOException {
		HttpClient httpClient = getSSLHttpClient();
		return get(httpClient, url, connectionTimeout, socketTimeout, charsetName);
	}

	/**
	 * 发送一个SSL get请求, 连接超时时间、请求超时时间、编码字符集均使用默认值
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static String getSSL(String url) throws IOException {
		return getSSL(url, DEFAULT_CONNECTION_TIMEOUT,
						DEFAULT_SOCKET_TIMEOUT, DEFAULT_CHARSET);
	}

	/**
	 * 发送一个SSL get请求, 连接超时时间、请求超时时间、编码字符集均可设置。该请求屏蔽异常，异常时返回null
	 * 
	 * @param url
	 * @param connectionTimeout
	 * @param socketTimeout
	 * @param charsetName
	 * @return
	 */
	public static String getSSLWithoutException(String url, Integer connectionTimeout, Integer socketTimeout, String charsetName) {
		try {

			return getSSL(url, connectionTimeout, socketTimeout,
							charsetName);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}
	}

	/**
	 * 发送一个SSL get请求, 连接超时时间、请求超时时间、编码字符集均使用默认值。该请求屏蔽异常，异常时返回null
	 * 
	 * @param url
	 * @return
	 */
	public static String getSSLWithoutException(String url) {
		try {
			return getSSL(url);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}
	}

	/**
	 * 发送一个SSLpost请求, 连接超时时间、请求超时时间、编码字符集均可定制
	 * 
	 * @param url
	 * @param data
	 * @param encodeCharset
	 * @param decodeCharset
	 * @param connectionTimeout
	 * @param socketTimeout
	 * @return
	 * @throws IOException
	 */
	public static String postSSL(String url, Map<String, Object> data, String encodeCharset, String decodeCharset, Integer connectionTimeout, Integer socketTimeout) throws IOException {
		HttpClient httpClient = getSSLHttpClient();
		return post(httpClient, url, data, encodeCharset,
						decodeCharset, connectionTimeout,
						socketTimeout);
	}

	/**
	 * 发送一个SSL post请求，编解码字符集、超时时间均使用默认值
	 * 
	 * @param url
	 * @param data
	 * @return
	 * @throws IOException
	 */
	public static String postSSL(String url, Map<String, Object> data) throws IOException {
		return postSSL(url, data, DEFAULT_CHARSET,
						DEFAULT_CHARSET, DEFAULT_CONNECTION_TIMEOUT,
						DEFAULT_SOCKET_TIMEOUT);
	}

	/**
	 * 发送一个SSL post请求，编解码字符集、超时时间均可定制，屏蔽异常，异常时返回null
	 * 
	 * @param url
	 * @param data
	 * @param encodeCharset
	 * @param decodeCharset
	 * @param connectionTimeout
	 * @param socketTimeout
	 * @return
	 */
	public static String postSSLWithoutException(String url, Map<String, Object> data, String encodeCharset, String decodeCharset, Integer connectionTimeout, Integer socketTimeout) {
		try {
			return postSSL(url, data, encodeCharset,
							decodeCharset, connectionTimeout, socketTimeout);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);

			return null;
		}
	}

	/**
	 * 发送一个普通post请求，编解码字符集、超时时间均使用默认值，屏蔽异常，异常时返回null
	 * 
	 * @param url
	 * @param data
	 * @return
	 */
	public static String postSSLWithoutException(String url, Map<String, Object> data) {
		try {
			return postSSL(url, data);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}
	}

	public static void main(String[] args) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sessionId", "8a7599be-5cf9-4aea-b5ca-0a9f6290ef0d");
		params.put("funNo", "100201");
		params.put("jsonParams", "test");
		String url = "https://mis.dev.trunk.wjs-test.com/logon/operateCheck.json";
		
		String json  =  HttpClientUtils.postSSLWithoutException(url, params,null,null, 300, 300);
		
		System.out.println(json);
	}
}
