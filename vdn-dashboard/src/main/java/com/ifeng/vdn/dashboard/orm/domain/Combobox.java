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

import com.ifeng.vdn.dashboard.commons.constant.ComboboxCategoryEnum;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jul 29, 2015
 */
public class Combobox extends AbstractRepository {
	private static final long serialVersionUID = -5366118727227211940L;
	
	public Combobox(ComboboxCategoryEnum type){
		this.comboKey = type.getCode();
	}
	
	public Combobox(){}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getComboLabel() {
		return comboLabel;
	}

	public void setComboLabel(String comboLabel) {
		this.comboLabel = comboLabel;
	}

	public String getComboCode() {
		return comboCode;
	}

	public void setComboCode(String comboCode) {
		this.comboCode = comboCode;
	}

	public String getComboKey() {
		return comboKey;
	}

	public void setComboKey(String comboKey) {
		this.comboKey = comboKey;
	}

	public String getComboDesc() {
		return comboDesc;
	}
	public void setComboDesc(String comboDesc) {
		this.comboDesc = comboDesc;
	}


	private Integer id;
	private Integer pId;
	private String comboLabel;
	private String comboCode;
	private String comboKey;
	private String comboDesc;
}
