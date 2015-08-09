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
 * @since Jul 22, 2015
 */
public class AvlbMinutelyModel extends AbstractAvlbReport {
	private static final long serialVersionUID = -8565271492670119599L;

	public String getTr() {
		return tr;
	}
	public void setTr(String tr) {
		this.tr = tr;
	}
	public String getCt() {
		return ct;
	}
	public void setCt(String ct) {
		this.ct = ct;
	}
	
	/**
	 * @return
	 * @see com.ifeng.vdn.dashboard.commons.constant.VType
	 */
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	private String tr;
	private String ct;
	private String category;
}
