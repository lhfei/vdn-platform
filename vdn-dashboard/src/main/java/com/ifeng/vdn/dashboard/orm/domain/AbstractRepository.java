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

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ifeng.vdn.commons.convert.JsonDateSerializer;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jun 30, 2015
 */
@JsonAutoDetect
public abstract class AbstractRepository implements Serializable {
	
	private static final long serialVersionUID = -4801508529518618330L;
	
	
	public int getData_status() {
		return data_status;
	}
	public void setData_status(int data_status) {
		this.data_status = data_status;
	}
	public Date getLatest_time() {
		return latest_time;
	}
	public void setLatest_time(Date latest_time) {
		this.latest_time = latest_time;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	private int data_status;
	
	@JsonSerialize(using=JsonDateSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	
	private Date latest_time;
	
	@JsonSerialize(using=JsonDateSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	private Date create_time;
}
