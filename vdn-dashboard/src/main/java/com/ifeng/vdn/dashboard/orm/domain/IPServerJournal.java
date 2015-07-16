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
 * @since Jul 8, 2015
 */
public class IPServerJournal extends AbstractRepository {

	private static final long serialVersionUID = 8056990149960646494L;
	
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
		return this.live_total + this.request_total + this.video_total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPlay_way() {
		return play_way;
	}
	public void setPlay_way(int play_way) {
		this.play_way = play_way;
	}
	
	private Long id;
	private String ip;
	private int live_total;
	private int request_total;
	private int video_total;
	private int total;
	private int play_way;
}
