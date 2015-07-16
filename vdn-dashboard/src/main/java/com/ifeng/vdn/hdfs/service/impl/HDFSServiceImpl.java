/*
 * Copyright 2010-2011 the original author or authors.
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
package com.ifeng.vdn.hdfs.service.impl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifeng.vdn.hdfs.commons.HDFSConfiguration;
import com.ifeng.vdn.hdfs.model.ListStatus;
import com.ifeng.vdn.hdfs.service.HDFSService;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jun 19, 2015
 */
@Service("hdfsService")
public class HDFSServiceImpl implements HDFSService {
	private static final Logger log = LoggerFactory.getLogger(HDFSServiceImpl.class);
	

	@Value("${HDFS_URL}")
	private String hdfsURL;

	@Override
	public ListStatus getListStatus(String operations) {
		ListStatus statuses = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		
		try {
			operations = HDFSConfiguration.buildURL(operations);
			
			HttpGet httpget = new HttpGet(operations);

			log.info("Executing request " + httpget.getRequestLine());
			CloseableHttpResponse response = httpclient.execute(httpget);
			try {
				
				// Get hold of the response entity
				HttpEntity entity = response.getEntity();

				// If the response does not enclose an entity, there is no need
				// to bother about connection release
				if (entity != null) {
					
					InputStream instream = entity.getContent();
					
					try {
						String json = IOUtils.toString(instream, "UTF-8");
						
						json = json.replaceAll("FileStatuses", "fileStatuses");
						json = json.replaceAll("FileStatus", "fileStatus");
						
						ObjectMapper map = new ObjectMapper();
						
						statuses = map.readValue(json, ListStatus.class);
						
					} catch (IOException ex) {
						log.error(ex.getMessage(), ex);
						
					} finally {
						// Closing the input stream will trigger connection
						// release
						instream.close();
					}
				}
			} finally {
				response.close();
			}
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
		}
		
		return statuses;
	}

	@Override
	public String getListStatusJson(String operations) {
		String json = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		
		try {
			operations = HDFSConfiguration.buildURL(operations);
			
			HttpGet httpget = new HttpGet(operations);

			log.info("Executing request " + httpget.getRequestLine());
			CloseableHttpResponse response = httpclient.execute(httpget);
			try {
				
				// Get hold of the response entity
				HttpEntity entity = response.getEntity();

				// If the response does not enclose an entity, there is no need
				// to bother about connection release
				if (entity != null) {
					
					InputStream instream = entity.getContent();
					try {
						
						json = IOUtils.toString(instream, "UTF-8");
						
						/*json = json.replaceAll("FileStatuses", "fileStatuses");
						json = json.replaceAll("FileStatus", "fileStatus");*/
						
					} catch (UnsupportedOperationException e) {
						log.error(e.getMessage(), e);
					} finally {
						instream.close();
					}
				}
			} finally {
				response.close();
			}
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
		}
		
		return json;
	}
}
