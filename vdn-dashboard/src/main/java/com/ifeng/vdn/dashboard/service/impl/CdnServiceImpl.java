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
package com.ifeng.vdn.dashboard.service.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifeng.vdn.dashboard.orm.domain.ServerRoom;
import com.ifeng.vdn.dashboard.orm.mybatis.mapper.CdnMapper;
import com.ifeng.vdn.dashboard.service.CdnService;
import com.ifeng.vdn.dashboard.web.model.ServerBaseModel;
import com.ifeng.vdn.dashboard.web.model.ServerRoomModel;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jul 8, 2015
 */
@Service("cdnServiceImpl")
public class CdnServiceImpl implements CdnService {

	@Override
	public void createServerRoom(ServerRoom serverRoom)  throws SQLException {
		Date date = new Date();
		serverRoom.setCreate_time(date);
		serverRoom.setLatest_time(date);
		
		cdnMapper.createServerRoom(serverRoom);
	}

	@Override
	public List<ServerRoom> getServerRoom(ServerRoomModel serverRoomModel) {
		return cdnMapper.getServerRoom(serverRoomModel);
	}
	
	@Override
	public int countServerRoom(ServerRoomModel serverRoomModel) {
		return cdnMapper.countServerRoom(serverRoomModel);
	}
	
	@Override
	public boolean removeServerRoom(ServerRoom serverRoom) throws SQLException {
		boolean result = false;
		
		try {
			cdnMapper.removeServerRoom(serverRoom);
			
			result = true;
		} catch (Exception e) {
			throw new SQLException(e);
		}
		
		return result;
	}
	
	@Override
	public boolean batchRemoveServerRoom(List<Long> ids) {
		return cdnMapper.batchRemoveServerRoom(ids);
	}

	
	@Override
	public void createServer(ServerBaseModel serverBase) {
		Date date = new Date();
		serverBase.setCreate_time(date);
		serverBase.setLatest_time(date);
		
		cdnMapper.createServer(serverBase);
	}

	@Override
	public List<ServerBaseModel> getServers(ServerBaseModel serverBaseModel) {
		return cdnMapper.getServers(serverBaseModel);
	}
	
	@Override
	public int countServers(ServerBaseModel serverBaseModel) {
		return cdnMapper.countServers(serverBaseModel);
	}

	@Override
	public void batchRemoveServers(List<Long> ids) {
		cdnMapper.batchRemoveServers(ids);
	}
	
	@Autowired
	private CdnMapper cdnMapper;

}
