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
package com.ifeng.vdn.dashboard.web.model;

import java.util.Map;


/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jul 6, 2015
 */
public class GlobalConstantModel {

	public Map<String, String> getDashboard() {
		return dashboard;
	}
	public void setDashboard(Map<String, String> dashboard) {
		this.dashboard = dashboard;
	}
	public Map<String, String> getHdfs() {
		return hdfs;
	}
	public void setHdfs(Map<String, String> hdfs) {
		this.hdfs = hdfs;
	}
	public Map<String, String> getIpServer() {
		return ipServer;
	}
	public void setIpServer(Map<String, String> ipServer) {
		this.ipServer = ipServer;
	}
	
	
	
	private Map<String, String> dashboard;
	private Map<String,String> hdfs;
	private Map<String,String> ipServer;
	
	
	
	/*public GlobalConstantModel getGlobal() {
		return global;
	}
	public void setGlobal(GlobalConstantModel global) {
		this.global = global;
	}
	public HDFSConstantModel getHdfs() {
		return hdfs;
	}
	public void setHdfs(HDFSConstantModel hdfs) {
		this.hdfs = hdfs;
	}
	public IPServerConstantModel getIpServer() {
		return ipServer;
	}
	public void setIpServer(IPServerConstantModel ipServer) {
		this.ipServer = ipServer;
	}
	
	private GlobalConstantModel global;
	private HDFSConstantModel hdfs;
	private IPServerConstantModel ipServer;*/
}
