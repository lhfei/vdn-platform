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

import java.io.Serializable;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jul 10, 2015
 */
public class ServerBaseModel extends AbstractPaginationModel implements Serializable {
	private static final long serialVersionUID = 6455835152205337159L;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRoom_id() {
		return room_id;
	}
	public void setRoom_id(Long room_id) {
		this.room_id = room_id;
	}
	public String getInner_ip() {
		return inner_ip;
	}
	public void setInner_ip(String inner_ip) {
		this.inner_ip = inner_ip;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getServer_status() {
		return server_status;
	}
	public void setServer_status(int server_status) {
		this.server_status = server_status;
	}
	
	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	private Long id;
	private Long room_id;	//server room pk.
	private String room_name;
	private String inner_ip;
	private String ip;
	private int server_status;
}
