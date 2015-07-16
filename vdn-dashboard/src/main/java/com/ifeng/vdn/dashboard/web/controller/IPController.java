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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ifeng.vdn.dashboard.orm.domain.IPImportReport;
import com.ifeng.vdn.dashboard.orm.domain.IPJournal;
import com.ifeng.vdn.dashboard.service.IPAreaService;
import com.ifeng.vdn.dashboard.service.IPReportService;
import com.ifeng.vdn.dashboard.web.model.ExtJSReturn;
import com.ifeng.vdn.dashboard.web.model.IPImportReportModel;
import com.ifeng.vdn.dashboard.web.model.IPJournalModel;
import com.ifeng.vdn.ip.repository.bean.ali.AliIPBean;
import com.ifeng.vdn.ip.repository.bean.ali.AliIPWrapper;
import com.ifeng.vdn.ip.repository.service.BatchIPAddressChecker;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jun 26, 2015
 */
@Controller
@RequestMapping("ipController")
public class IPController extends AbstractController {
	
	@RequestMapping("aliIPCheck")
	public ModelAndView aliIPCheck() {
		ModelAndView view = new ModelAndView("iprepository/aliIPCheck");
		
		return view;
	}
	
	@RequestMapping("aliIPMerge")
	public ModelAndView aliIPMerge() {
		ModelAndView view = new ModelAndView("iprepository/aliIPMerge");
		
		return view;
	}

	@RequestMapping("getIpInfo")
	public @ResponseBody Map<String, Object> getIpInfo(@RequestParam("ips") String ips) {
		
		List<String> list = new ArrayList<String>();
		
		list = Arrays.asList(ips.split(","));
		
		List<AliIPBean> ipList = aliBatchIPAddressChecker.check(list);
		
		List<AliIPWrapper> result = new ArrayList<AliIPWrapper>();
		
		for(AliIPBean ipBean : ipList){
			result.add(ipBean.getData());
		}
		
		/*Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("current", 1);
		map.put("rowCount", result.size());
		map.put("rows", result);
		map.put("total", result.size());
		
		return ExtJSReturn.mapWarp(map);*/
		
		return ExtJSReturn.mapOK(result);
	}
	
	
	@RequestMapping("ipImportReport")
	public ModelAndView ipImportReport() {
		
		ModelAndView view = new ModelAndView("ipserver/reportIndex");
		
		return view;
	}
	
	@RequestMapping("getIPImportReport")
	public @ResponseBody Map<String, Object> getIPImportReport(HttpSession session,
			@RequestParam("start")int start,
			@RequestParam("limit")int limit) {
		List<IPImportReport> list = new ArrayList<IPImportReport>();
		
		IPImportReportModel model = new IPImportReportModel();
		model.setStart(start);
		model.setLimit(limit);
		
		list = ipAreaService.getIPImportReport(model);
		
		return ExtJSReturn.mapOK(list);
	} 
	
	@RequestMapping("ipJournal")
	public ModelAndView ipJournal() {
		
		ModelAndView view = new ModelAndView("ipserver/ipJournalIndex");
		
		return view;
	}
	
	@RequestMapping("getIPJournal")
	public @ResponseBody Map<String, Object> getIPJournal(HttpSession session,
			@RequestParam("start")int start,
			@RequestParam("limit")int limit) {
		
		List<IPJournal> list = new ArrayList<IPJournal>();
		IPJournalModel model = new IPJournalModel();
		model.setStart(start);
		model.setLimit(limit);
		
		list = ipAreaService.getIPJournal(model);

		return ExtJSReturn.mapOK(list);
	}
	
	@RequestMapping("importIPFromIPAreaFile")
	public @ResponseBody Map<String, Object> importIPFromIPAreaFile() {
		
		Runnable task = () -> {
		    log.info("New thread[{}] running ......", Thread.currentThread().getName());
		    ipAreaService.importIPFromIPAreaFile();
		};
		
		Thread thread = new Thread(task);
		thread.start();
		
		return ExtJSReturn.mapOK("\u670d\u52a1\u542f\u52a8\u6210\u529f!");
	}
	
	
	@Autowired
	private IPReportService ipReportService;
	
	@Autowired
	private IPAreaService ipAreaService;
	
	@Autowired
	private BatchIPAddressChecker aliBatchIPAddressChecker;
}
