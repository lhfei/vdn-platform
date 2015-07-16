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
/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jun 26, 2015
 */
public class ExtJSReturnConfiguration {
	
	public ExtJSReturnConfiguration(String totalNode, String successNode, String dataNode, String messageNode) {
		this.totalNode = totalNode;
		this.successNode = successNode;
		this.dataNode = dataNode;
		this.messageNode = messageNode;
	}
	
	
	public String getTotalNode() {
		return totalNode;
	}
	public void setTotalNode(String totalNode) {
		this.totalNode = totalNode;
	}
	public String getSuccessNode() {
		return successNode;
	}
	public void setSuccessNode(String successNode) {
		this.successNode = successNode;
	}
	public String getDataNode() {
		return dataNode;
	}
	public void setDataNode(String dataNode) {
		this.dataNode = dataNode;
	}
	public String getMessageNode() {
		return messageNode;
	}
	public void setMessageNode(String messageNode) {
		this.messageNode = messageNode;
	}



	private String totalNode;
	private String successNode;
	private String dataNode;
	private String messageNode;
}
