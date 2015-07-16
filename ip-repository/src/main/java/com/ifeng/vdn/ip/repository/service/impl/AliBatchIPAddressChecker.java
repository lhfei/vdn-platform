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
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifeng.vdn.ip.repository.bean.ali.AliIPBean;
import com.ifeng.vdn.ip.repository.service.BatchIPAddressChecker;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since  Apr 15, 2015
 */
@Component("aliBatchIPAddressChecker")
public class AliBatchIPAddressChecker implements
		BatchIPAddressChecker<AliIPBean> {
	
	private static final Logger log = LoggerFactory.getLogger(AliBatchIPAddressChecker.class);

	@Override
	public List<AliIPBean> check(List<String> ips) {
		
		List<AliIPBean> list = new ArrayList<AliIPBean>();
		
		AliIPBean ipaddress = null;
		String url = "http://ip.taobao.com/service/getIpInfo2.php";
		// Create an instance of HttpClient.
		CloseableHttpClient client = HttpClients.createDefault();
		
		// Create a method instance.
		//PostMethod postMethod = new PostMethod(url);
		HttpPost postMethod = new HttpPost(url);
		
		for(String ip : ips){
			// Execute the method.
			try {
				ip = ip.trim().replaceAll("\r", "");
				
				ArrayList<NameValuePair> postParameters =  new ArrayList<NameValuePair>();
				postParameters.add(new BasicNameValuePair("ip", ip));
				
				postMethod.setEntity(new UrlEncodedFormEntity(postParameters));
				CloseableHttpResponse response = client.execute(postMethod);
				
				// Get hold of the response entity
				HttpEntity entity = response.getEntity();
				
				ObjectMapper mapper = new ObjectMapper();
				ipaddress = mapper.readValue(entity.getContent(), AliIPBean.class);
				list.add(ipaddress);
			} catch (JsonParseException | JsonMappingException e) {
				list.add(new AliIPBean());
				log.error(e.getMessage(), e);
			} catch (IOException e) {
				list.add(new AliIPBean());
				log.error(e.getMessage(), e);
			}			
		}
		
		try {
			client.close();
		} catch (IOException e) {
		}
		
		return list;
	}

}
