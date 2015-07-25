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

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ifeng.vdn.commons.convert.EnumConverter;
import com.ifeng.vdn.dashboard.commons.constant.VideoPlaywayEnum;
import com.ifeng.vdn.dashboard.orm.domain.IPServerJournal;
import com.ifeng.vdn.dashboard.service.IPServerService;
import com.ifeng.vdn.dashboard.web.model.ExtJSReturn;
import com.ifeng.vdn.dashboard.web.model.IPServerJournalModel;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jul 8, 2015
 */
@Controller
@RequestMapping("ipserver")
public class IPServerController extends AbstractController {
	

	@RequestMapping("/{ip}/create")
	public @ResponseBody Map<String, Object> create(@PathVariable("ip") String ip, 
			@RequestParam("live") int live,
			@RequestParam("request") int request,
			@RequestParam("video") int video,
			@RequestParam("ctime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") Date ctime) {
		Date date = new Date();
		
		IPServerJournal journal = new IPServerJournal();
		journal.setIp(ip);
		journal.setLive_total(live);
		journal.setRequest_total(request);
		journal.setVideo_total(video);
		journal.setCreate_time(ctime);
		journal.setLatest_time(date);
		
		ipServerService.create(journal);
		
		return ExtJSReturn.mapOK("\u64cd\u4f5c\u6210\u529f!");
	}
	
	@RequestMapping("/{ip}/read")
	public @ResponseBody Map<String, Object> read(@PathVariable("ip") String ip, 
			@RequestParam(value = "inner_ip", required = false) String inner_ip,
			@RequestParam(value = "startdt", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startdt,
			@RequestParam(value = "enddt", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date enddt) {
		try {
			IPServerJournalModel serverJournalModel = new IPServerJournalModel();
			serverJournalModel.setIp(ip);
			serverJournalModel.setInner_ip(inner_ip);
			serverJournalModel.setStart_time(startdt);
			serverJournalModel.setEnd_time(enddt);
			
			List<IPServerJournal> list = ipServerService.read(serverJournalModel);
			
			return ExtJSReturn.mapOK(list);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ExtJSReturn.mapError(FAILURE);
		}
	}
	
	@RequestMapping("getJournalSummary")
	public @ResponseBody Map<String, Object> getJournalSummary(
			@RequestParam(value = "startdt", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startdt,
			@RequestParam(value = "enddt", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date enddt) {
		
		try {
			IPServerJournalModel serverJournalModel = new IPServerJournalModel();
			serverJournalModel.setStart_time(startdt);
			serverJournalModel.setEnd_time(enddt);
			
			List<IPServerJournal> list = ipServerService.getJournalSummary(serverJournalModel);
			
			return ExtJSReturn.mapOK(list);
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ExtJSReturn.mapError(FAILURE);
		}
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {  
	    dataBinder.registerCustomEditor(VideoPlaywayEnum.class, new EnumConverter());
	}
	
	@Autowired
	private IPServerService ipServerService;
}
