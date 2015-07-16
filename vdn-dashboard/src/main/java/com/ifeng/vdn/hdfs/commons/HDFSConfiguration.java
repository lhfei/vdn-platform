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
package com.ifeng.vdn.hdfs.commons;
/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jun 21, 2015
 */
public final class HDFSConfiguration {

	public static String hdfsURL = "http://114.80.177.144:50070/";
	public static final String WEBHDFS_DEFAULT_URL= "webhdfs/v1/?op=LISTSTATUS";
	
	public static String buildURL(String url) {
		StringBuilder sb = new StringBuilder(hdfsURL);
		sb.append("webhdfs/v1/");
		if(null != url){
			sb.append(url);
			sb.append("/");
		}
		sb.append("?op=LISTSTATUS");
		
		return sb.toString();
	}
}
