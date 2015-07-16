/*
 * Copyright 2010-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ifeng.vdn.ip.repository.service.impl;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifeng.vdn.ip.repository.bean.IPAddress;
import com.ifeng.vdn.ip.repository.bean.baidu.BaiduIPBean;
import com.ifeng.vdn.ip.repository.service.IPAddressChecker;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since Apr 10, 2015
 */
public class IPAddressBaiduChecker implements IPAddressChecker {

	private static final Logger log = LoggerFactory
			.getLogger(IPAddressBaiduChecker.class);

	@Override
	public IPAddress ipcheck(String ip) {

		IPAddress ipaddress = null;
		String url = "https://sp0.baidu.com/8aQDcjqpAAV3otqbppnN2DJv/api.php?query="
				+ ip
				+ "&co=&resource_id=6006&t=1428632527853&ie=utf8&oe=gbk&cb=op_aladdin_callback&format=json&tn=baidu&cb=jQuery110204891062709502876_1428631554303&_=1428631554305";

		// Create an instance of HttpClient.
		CloseableHttpClient client = HttpClients.createDefault();
		// Create a method instance.
		HttpGet getMethod = new HttpGet(url);
		
		try {
			// Execute the method.
			CloseableHttpResponse response = client.execute(getMethod);
			// Get hold of the response entity
			HttpEntity entity = response.getEntity();
			
			if (entity != null) {
				String responseStr = IOUtils.toString(entity.getContent(), "GBK");
				responseStr = responseStr.substring(
						responseStr.indexOf("(") + 1, responseStr.indexOf(")"));
				ObjectMapper mapper = new ObjectMapper();
				
				ipaddress = mapper.readValue(responseStr, BaiduIPBean.class);
			} 
			
		} catch (JsonParseException | JsonMappingException e) {
			log.error(e.getMessage(), e);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}

		return ipaddress;
	}

}
