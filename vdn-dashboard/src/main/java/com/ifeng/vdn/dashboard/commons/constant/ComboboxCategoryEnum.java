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
package com.ifeng.vdn.dashboard.commons.constant;
/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jul 29, 2015
 */
public enum ComboboxCategoryEnum implements AbstractDictEnum<String> {
	
	ISP("运营商", "ISP");
	
	ComboboxCategoryEnum(String label, String code){
		this.label = label;
		this.code  = code;
	}
	
	@Override
	public String getLabel(String code) {
		return label;
	}

	@Override
	public String getCode() {
		return code;
	}

	private String label;
	private String code;
}
