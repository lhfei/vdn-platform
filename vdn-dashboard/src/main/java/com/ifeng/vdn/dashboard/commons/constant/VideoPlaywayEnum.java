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
 * Ifeng Videos ways to play. </p>
 * 
 * <ul>
 * 	<li>\u76f4\u64ad, <em>0</em></li>
 * 	<li>\u70b9\u64ad, <em>1</em></li>
 * 	<li>\u957f\u89c6\u9891, <em>2</em></li>
 * </ul>
 * 
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jul 10, 2015
 */
public enum VideoPlaywayEnum implements AbstractDictEnum<Integer>{
	
	/**
	 * \u76f4\u64ad, <em>0</em>
	 */
	LIVE("\u76f4\u64ad", 0),
	
	/**
	 * \u70b9\u64ad, <em>1</em>
	 */
	REQUEST("\u70b9\u64ad", 1),
	
	/**
	 * \u957f\u89c6\u9891
	 */
	VIDEO("\u957f\u89c6\u9891", 2)
	;
	
	VideoPlaywayEnum(String label, Integer code){
		this.label = label;
		this.code  = code;
	}

	@Override
	public String getLabel(Integer code) {
		return label;
	}

	@Override
	public Integer getCode() {
		return code;
	}

	private String label;
	private Integer code;
}
