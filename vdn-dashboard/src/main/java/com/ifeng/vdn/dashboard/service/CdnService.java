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
package com.ifeng.vdn.dashboard.service;

import java.sql.SQLException;
import java.util.List;

import com.ifeng.vdn.dashboard.orm.domain.ServerRoom;
import com.ifeng.vdn.dashboard.web.model.ServerBaseModel;
import com.ifeng.vdn.dashboard.web.model.ServerRoomModel;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jul 8, 2015
 */
public interface CdnService {
	
	void createServerRoom(ServerRoom serverRoom)  throws SQLException ;
	
	List<ServerRoom> getServerRoom(ServerRoomModel serverRoomModel);
	
	int countServerRoom(ServerRoomModel serverRoomModel);
	
	boolean removeServerRoom(ServerRoom serverRoom)  throws SQLException ;
	
	boolean batchRemoveServerRoom(List<Long> ids);
	
	
	// SERVER OPERATIONS
	
	void createServer(ServerBaseModel serverBaseModel);
	
	List<ServerBaseModel> getServers(ServerBaseModel serverBaseModel);
	
	int countServers(ServerBaseModel serverBaseModel);
	
	void batchRemoveServers(List<Long> ids);
}
