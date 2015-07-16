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
package com.ifeng.vdn.dashboard.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ifeng.vdn.dashboard.orm.domain.ServerRoom;
import com.ifeng.vdn.dashboard.service.CdnService;
import com.ifeng.vdn.dashboard.web.model.ExtJSReturn;
import com.ifeng.vdn.dashboard.web.model.ServerBaseModel;
import com.ifeng.vdn.dashboard.web.model.ServerRoomModel;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jul 8, 2015
 */
@Controller
@RequestMapping("cdn")
public class CdnController extends AbstractController {
	
	@RequestMapping("/{view}/forward")
	public ModelAndView forward(@PathVariable("view")String view) {
		ModelAndView mv = new ModelAndView("/cdn/" +view);
		
		return mv;
	}
	
	
	@RequestMapping("/createServerRoom")
	public @ResponseBody Map<String, Object> createServerRoom(
			@RequestBody ServerRoom serverRoom) {

		try {

			cdnServiceImpl.createServerRoom(serverRoom);

			return ExtJSReturn.mapOK(SUCCESS);

		} catch (Exception e) {
			log.error(e.getMessage(), e);

			return ExtJSReturn.mapError(FAILUE);
		}
	}
	
	@RequestMapping(value = "/getServerRoom")
	public @ResponseBody Map<String, Object> getServerRoom(
			@RequestParam(value = "room_name", required = false) String room_name){
		
		ServerRoomModel serverRoomModel = new ServerRoomModel();
		serverRoomModel.setRoom_name(room_name);
		
		List<ServerRoom> list = cdnServiceImpl.getServerRoom(serverRoomModel);
		
		int total = cdnServiceImpl.countServerRoom(serverRoomModel);
		
		return ExtJSReturn.mapOK(list, total);
	}
	
	@RequestMapping(value = "/removeServerRoom", method=RequestMethod.POST, produces = "application/json")
	public @ResponseBody Map<String, Object> removeServerRoom(@RequestBody List<Long> ids){
		
		try {
			cdnServiceImpl.batchRemoveServerRoom(ids);
			
			return ExtJSReturn.mapOK(SUCCESS);
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			
			return ExtJSReturn.mapError(FAILUE);
		}
	}
	
	// ======== Operations for Server.
	
	@RequestMapping("/createServer")
	public @ResponseBody Map<String, Object> createServer(
			@RequestBody ServerBaseModel serverBaseModel) {

		try {

			cdnServiceImpl.createServer(serverBaseModel);

			return ExtJSReturn.mapOK(SUCCESS);

		} catch (Exception e) {
			log.error(e.getMessage(), e);

			return ExtJSReturn.mapError(FAILUE);
		}
	}
	
	@RequestMapping(value = "/getServer")
	public @ResponseBody Map<String, Object> getServer(
			@RequestParam(value = "start", required = false) int start,
			@RequestParam(value = "limit", required = false) int limit,
			@RequestParam(value = "ip", required = false) String ip,
			@RequestParam(value = "innser_ip", required = false) String innser_ip,
			@RequestParam(value = "room_id", required = false) Long room_id){
		
		ServerBaseModel serverBaseModel = new ServerBaseModel();
		serverBaseModel.setIp(ip);
		serverBaseModel.setInner_ip(innser_ip);
		serverBaseModel.setRoom_id(room_id);
		serverBaseModel.setStart(start);
		serverBaseModel.setLimit(limit);
		
		List<ServerBaseModel> list = cdnServiceImpl.getServers(serverBaseModel);
		int total = cdnServiceImpl.countServers(serverBaseModel);
		
		return ExtJSReturn.mapOK(list, total);
	}
	
	@RequestMapping(value = "/removeServer", method=RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Map<String, Object> removeServer(@RequestBody List<Long> ids){
		
		try {
			cdnServiceImpl.batchRemoveServers(ids);
			
			return ExtJSReturn.mapOK(SUCCESS);
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			
			return ExtJSReturn.mapError(FAILUE);
		}
	}
	
	@Autowired
	private CdnService cdnServiceImpl;
}
