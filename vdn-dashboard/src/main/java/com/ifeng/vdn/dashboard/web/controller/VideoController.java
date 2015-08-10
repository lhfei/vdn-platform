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
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ifeng.vdn.dashboard.service.RecordFilterAdapter;
import com.ifeng.vdn.dashboard.service.VideoReportService;
import com.ifeng.vdn.dashboard.service.impl.VideoFilterAdapter;
import com.ifeng.vdn.dashboard.service.impl.VideoFilterAdapter.VideoReportType;
import com.ifeng.vdn.dashboard.web.model.AvlbDailyModel;
import com.ifeng.vdn.dashboard.web.model.AvlbMinutelyGridModel;
import com.ifeng.vdn.dashboard.web.model.AvlbMinutelyModel;
import com.ifeng.vdn.dashboard.web.model.ExtJSReturn;
import com.ifeng.vdn.dashboard.web.model.FluentMinutelyModel;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jul 22, 2015
 */
@Controller
@RequestMapping("video")
public class VideoController extends AbstractController {

	@RequestMapping("/{view}/forward")
	public ModelAndView forward(@PathVariable("view")String view) {
		ModelAndView mv = new ModelAndView("/video/" +view);
		return mv;
	}
	
	@RequestMapping("getAvlbDaily")
	public @ResponseBody Map<String, Object> getAvlbDaily() {
		AvlbDailyModel model = new AvlbDailyModel();
		List<AvlbDailyModel> list = new ArrayList<AvlbDailyModel>();
		
		list = videoReportService.getAvlbDaily(model);
		
		return ExtJSReturn.mapOK(list);
	}
	
	@RequestMapping("getAvlbMinutely")
	public @ResponseBody Map<String, Object> getAvlbMinutely(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "start", required = false) Integer start,
			@RequestParam(value = "limit", required = false) Integer limit,
			@RequestParam(value = "range", required = false) int range) {

		AvlbMinutelyModel model = VideoFilterAdapter.create(VideoReportType.SPGK, range);
		model.setRange(range);
		model.setPage(page);
		model.setStart(start);
		model.setLimit(limit);
		
		List<AvlbMinutelyModel> list = new ArrayList<AvlbMinutelyModel>();

		list = videoReportService.getAvlbMinutely(model);
		long total = videoReportService.getAvlbMinutelyTotal(model);

		return ExtJSReturn.mapOK(list, total);
	}
	
	@RequestMapping("getAvlbMinutelyForGrid")
	public @ResponseBody Map<String, Object> getAvlbMinutelyForGrid(
			@RequestParam(value = "isp", required = false) String isp,
			@RequestParam(value = "cat", required = false) String cat,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "start", required = false) Integer start,
			@RequestParam(value = "limit", required = false) Integer limit,
			@RequestParam(value = "range", required = false) int range,
			@RequestParam(value = "startDt", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDt,
			@RequestParam(value = "endDt", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDt,
			@RequestParam(value = "filter", required = false) String filters ) {

		//AvlbMinutelyModel model = VideoFilterAdapter.create(VideoReportType.SPGK, range);
		
		AvlbMinutelyGridModel model = avlbFilterAdapter.adapter(filters);
		model.adaptDaily(startDt, endDt);
		model.setIsp(isp);
		model.setCat(cat);
		model.setPage(page);
		model.setStart(start);
		model.setLimit(limit);
		
		List<AvlbMinutelyGridModel> list = new ArrayList<AvlbMinutelyGridModel>();

		list = videoReportService.getAvlbMinutelyForGrid(model);
		int total = videoReportService.getAvlbMinutelyForGridTotal(model);

		return ExtJSReturn.mapOK(list, total);
	}
	
	@RequestMapping("getFluentMinutely")
	public @ResponseBody Map<String, Object> getFluentMinutely(
			@RequestParam(value = "type", required = false) int type,
			@RequestParam(value = "range", required = false) int range) {

		FluentMinutelyModel model = new FluentMinutelyModel();
		model.setType(type);
		model.setRange(range);
		
		List<FluentMinutelyModel> list = new ArrayList<FluentMinutelyModel>();

		list = videoReportService.getFluentMinutely(model);

		return ExtJSReturn.mapOK(list);
	}
	
	@RequestMapping("getAvlb")
	public @ResponseBody Map<String, Object> getAvlb(
			@RequestParam(value = "isp", required = false) String isp,
			@RequestParam(value = "country", required = false) String country,
			@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "category", required = false) String category,
			@RequestParam(value = "range", required = false) int range) {
		
		AvlbMinutelyModel model = VideoFilterAdapter.create(VideoReportType.SPGK, range);
		model.setCategory(category);
		model.setRange(range);
		model.setIsp(isp);
		model.setCountry(country);
		model.setCity(city);
		
		List<AvlbDailyModel> list = new ArrayList<AvlbDailyModel>();
		
		list = videoReportService.getAvlb(model);
		
		return ExtJSReturn.mapOK(list);
	}
	
	@Autowired
	private VideoReportService videoReportService;
	
	@Autowired
	private RecordFilterAdapter<AvlbMinutelyGridModel> avlbFilterAdapter;

}
