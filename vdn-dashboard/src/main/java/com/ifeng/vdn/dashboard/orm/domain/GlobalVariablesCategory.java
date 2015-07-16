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
public class GlobalVariablesCategory extends AbstractRepository {
	private static final long serialVersionUID = 1950856674734673523L;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getItem_label() {
		return item_label;
	}
	public void setItem_label(String item_label) {
		this.item_label = item_label;
	}
	public String getItem_code() {
		return item_code;
	}
	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}
	public String getItem_key() {
		return item_key;
	}
	public void setItem_key(String item_key) {
		this.item_key = item_key;
	}
	public String getItem_desc() {
		return item_desc;
	}
	public void setItem_desc(String item_desc) {
		this.item_desc = item_desc;
	}
	
	private Integer id;
	private String item_label;
	private String item_code;
	private String item_key;
	private String item_desc;
}
