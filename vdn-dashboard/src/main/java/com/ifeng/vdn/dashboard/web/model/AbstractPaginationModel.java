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

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ifeng.vdn.commons.convert.JsonDateSerializer;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jun 30, 2015
 */
public abstract class AbstractPaginationModel {
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getData_status() {
		return data_status;
	}
	public void setData_status(int data_status) {
		this.data_status = data_status;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getLatest_time() {
		return latest_time;
	}
	public void setLatest_time(Date latest_time) {
		this.latest_time = latest_time;
	}
	
	private int start;
	private int page;
	private int limit = 10;
	private int data_status;
	@JsonSerialize(using=JsonDateSerializer.class)
	private Date create_time;
	@JsonSerialize(using=JsonDateSerializer.class)
	private Date latest_time;
}
