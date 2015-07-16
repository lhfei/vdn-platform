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
package com.ifeng.vdn.conf;
/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jul 2, 2015
 */
public final class GlobalConstant {
	
	public enum HDFSConfiguration{
		HDFS_URL("HDFS_URL"),
		
		WEBHDFS_DEFAULT_URL("WEBHDFS_DEFAULT_URL");
		
		HDFSConfiguration(String key){
			this.key = key;
		}
		
		public String getKey(){
			return key;
		}
		
		private String key;
	}
	public enum IPServerConfiguration{
		IPSERVER_URL("IPSERVER_URL"),
		
		IPAREA_FILE_NAME("IPAREA_FILE_NAME"),
		
		IPAREA_FILE_DISTINCT_NAME("IPAREA_FILE_DISTINCT_NAME"),
		
		IPAREA_FILE_LOCATION("IPAREA_FILE_LOCATION"),
		
		IPAREA_FILE_BATCH_SIZE("IPAREA_FILE_BATCH_SIZE");
		
		IPServerConfiguration(String key){
			this.key = key;
		}
		
		public String getKey(){
			return key;
		}
		
		private String key;
	}
	
	public enum GlobalCoreCategoryKey {
		
		/**
		 * Dashboard global variables category key.
		 */
		DASHBOARD_CONF_KEY("_DASHBOARD_KEY"),
		
		/**
		 * Dashboard global variables category key.
		 */
		IPSERVER_CONF_KEY("_IPSERVER_KEY"),
		
		/**
		 * Dashboard global variables category key.
		 */
		HDFS_CONF_KEY("_HDFS_KEY");
		
		
		GlobalCoreCategoryKey(String key){
			this.key = key;
		}
		
		public String getKey(){
			return key;
		}
		
		private String key;
	}
}
