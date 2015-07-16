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
package com.ifeng.vdn.test.support;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifeng.vdn.dashboard.orm.domain.ServerRoom;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jul 13, 2015
 */
public class TimeTest {

	public static void main(String[] args) {
		String json = "[{\"id\":5,\"room_name\":\"\u6d4b\u8bd5\u673a\u623f1\",\"room_code\":\"Test1\",\"room_status\":0,\"data_status\":0,\"latest_time\":\"2015-07-13 16:25:14\",\"create_time\":\"2015-07-13 16:25:14\"},{\"id\":4,\"room_name\":\"\u6d4b\u8bd5\u673a\u623f\",\"room_code\":\"123\",\"room_status\":0,\"data_status\":0,\"latest_time\":\"2015-07-13 16:01:42\",\"create_time\":\"2015-07-13 16:01:42\"},{\"id\":3,\"room_name\":\"\u6d77\u822a\u673a\u623f\",\"room_code\":\"HHJF\",\"room_status\":0,\"data_status\":0,\"latest_time\":\"2015-07-13 15:14:14\",\"create_time\":\"2015-07-13 15:14:14\"}]";
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {

			
			
			List<ServerRoom> rooms = mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, ServerRoom.class));

			//List<ServerRoom> rooms = mapper.readValue(json, mapper.getTypeFactory().constructCollectionLikeType(List.class, ServerRoom.class));
			
			for(ServerRoom room : rooms){
				
				System.out.println(room.getId());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
