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

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ifeng.vdn.conf.DashboardApplicationContext;
import com.ifeng.vdn.dashboard.web.model.ExtJSReturn;
import com.ifeng.vdn.dashboard.web.model.GlobalConstantModel;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jul 3, 2015
 */
@Controller()
@RequestMapping("configure")
public class ConfigureController extends AbstractController {

	@RequestMapping("globalConf")
	public ModelAndView globalConf() {
		ModelAndView view = new ModelAndView("configure/globalConf");
		
		GlobalConstantModel global = new GlobalConstantModel();
		
		Map<String,String> dashboard = dashboardApplicationContext.getDashboardConfiguration();
		Map<String,String> hdfs = dashboardApplicationContext.getHDFSConfiguration();
		Map<String,String> ipServer = dashboardApplicationContext.getIPserverConfiguration();
		
		global.setDashboard(dashboard);
		global.setHdfs(hdfs);
		global.setIpServer(ipServer);
		
		/*view.addObject("dashboard", dashboard);
		view.addObject("hdfs", hdfs);
		view.addObject("ipServer", ipServer);*/
		
		view.addObject("global", global);
		
		return view;
	}
	
	@RequestMapping("loadGlobal")
	public @ResponseBody Map<String, Object> loadGlobal() {
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String,Object> map = new HashMap<String,Object>();
		
		Map<String,String> dashboard = dashboardApplicationContext.getDashboardConfiguration();
		Map<String,String> hdfs = dashboardApplicationContext.getHDFSConfiguration();
		Map<String,String> ipServer = dashboardApplicationContext.getIPserverConfiguration();
		
		map.put("dashboard", dashboard);
		map.put("hdfs", hdfs);
		map.put("ipServer", ipServer);
		
		result.put(ExtJSReturn.DEFAULT_DATA_NODE, map);
		result.put(ExtJSReturn.DEFAULT_SUCCESS_NODE, ExtJSReturn.DEFAULT_SUCCESS_NODE);
		
		return ExtJSReturn.mapWarp(result);
	}
	
	@Autowired
	private DashboardApplicationContext dashboardApplicationContext;
	
}
