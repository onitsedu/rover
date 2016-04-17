package com.suay.ofertia.server.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import com.suay.ofertia.exception.http.BadRequestException;
import com.suay.ofertia.exception.http.HttpException;
import com.suay.ofertia.utils.Constants;
import com.sun.net.httpserver.Filter;
import com.sun.net.httpserver.HttpExchange;

@SuppressWarnings("restriction")
public class HttpFilter extends Filter {

	@Override
	public String description() {
		return Constants.HTTP_FILTER_DESCRIPTION;
	}

	@Override
	public void doFilter(HttpExchange httpExchange, Chain chain) throws IOException {
		try {
			httpExchange.setAttribute(Constants.HTTP_ATT_BODY, getBody(httpExchange));
			httpExchange.setAttribute(Constants.HTTP_ATT_PATH, getPathParams(httpExchange));
			chain.doFilter(httpExchange);
		} catch (HttpException e) {
			e.printStackTrace();
			httpExchange.sendResponseHeaders(e.getHttpCode(), e.getHttpMessage().length());
			OutputStream os = httpExchange.getResponseBody();
			os.write(e.getHttpMessage().getBytes());
			os.close();
		}
	}

	private String getBody(HttpExchange httpExchange) throws IOException {
		String line;
		InputStreamReader inputStreamReader = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		StringBuffer sb = new StringBuffer();
		line = bufferedReader.readLine();
		try {
			while (line != null) {
				if (!"".equals(line)) {
					sb.append(line + Constants.EOL);
				}
				line = bufferedReader.readLine();
			}
		} finally {
			inputStreamReader.close();
			bufferedReader.close();
		}
		return sb.toString();
	}

	private Map<Integer, String> getPathParams(HttpExchange httpExchange) throws BadRequestException {
		Map<Integer, String> pathParams = new HashMap<Integer, String>();
		String uri = httpExchange.getRequestURI().toString();
		try {
			String[] pathParmArray = uri.split(Constants.HTTP_PATH_SEPARATOR);
			for (int i = 0; i < pathParmArray.length; i++) {
				pathParams.put(i, pathParmArray[i]);
			}
		} catch (Exception e) {
			throw new BadRequestException();
		}
		return pathParams;
	}

}
