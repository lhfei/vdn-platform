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
package com.ifeng.vdn.dashboard.orm.domain;
/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jul 2, 2015
 */
public class GlobalVariables extends AbstractRepository {
	private static final long serialVersionUID = -2569578917949685494L;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVar_name() {
		return var_name;
	}
	public void setVar_name(String var_name) {
		this.var_name = var_name;
	}
	public String getVar_val() {
		return var_val;
	}
	public void setVar_val(String var_val) {
		this.var_val = var_val;
	}
	public String getVar_ref() {
		return var_ref;
	}
	public void setVar_ref(String var_ref) {
		this.var_ref = var_ref;
	}
	public String getVar_label() {
		return var_label;
	}
	public void setVar_label(String var_label) {
		this.var_label = var_label;
	}
	public String getVar_desc() {
		return var_desc;
	}
	public void setVar_desc(String var_desc) {
		this.var_desc = var_desc;
	}
	
	
	private Integer id;
	private String var_name;
	private String var_val;
	private String var_ref;
	private String var_label;
	private String var_desc;
	
}
