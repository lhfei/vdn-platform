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

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ifeng.vdn.hdfs.service.HDFSService;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jun 19, 2015
 */
@Controller()
@RequestMapping("hdfs")
public class HDFSController extends AbstractController {

	@RequestMapping("/{view}/forward")
	public ModelAndView forward(@PathVariable("view")String view) {
		ModelAndView mv = new ModelAndView("/hdfs/" +view);
		return mv;
	}
	
	@RequestMapping("/getListStatus")
	public @ResponseBody  String getListStatus(@RequestParam(value="ops", required=false) String ops,
			HttpSession session) {
		/*List<FileStatus> list = new ArrayList<FileStatus>();
		
		ListStatus statuses = hdfsService.getListStatus(ops);
		
		if(statuses != null && statuses.getFileStatuses() != null){
			
			list = statuses.getFileStatuses().getFileStatus();
		}*/
		
		String json = hdfsService.getListStatusJson(ops);
		
		return json;
	}
	
	
	
	@Autowired
	private HDFSService hdfsService;
}
