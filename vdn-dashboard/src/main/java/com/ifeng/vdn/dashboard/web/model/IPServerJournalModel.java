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

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jul 9, 2015
 */
public class IPServerJournalModel extends AbstractPaginationModel {
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getLive_total() {
		return live_total;
	}
	public void setLive_total(int live_total) {
		this.live_total = live_total;
	}
	public int getRequest_total() {
		return request_total;
	}
	public void setRequest_total(int request_total) {
		this.request_total = request_total;
	}
	public int getVideo_total() {
		return video_total;
	}
	public void setVideo_total(int video_total) {
		this.video_total = video_total;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	
	private Long id;
	private String ip;
	private int live_total;
	private int request_total;
	private int video_total;
	private int total;
	private Date start_time;
	private Date end_time;
}
