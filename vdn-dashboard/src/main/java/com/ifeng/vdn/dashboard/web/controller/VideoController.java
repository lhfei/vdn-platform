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
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ifeng.vdn.dashboard.service.VideoReportService;
import com.ifeng.vdn.dashboard.service.impl.VideoFilterAdapter;
import com.ifeng.vdn.dashboard.service.impl.VideoFilterAdapter.VideoReportType;
import com.ifeng.vdn.dashboard.web.model.AvlbDailyModel;
import com.ifeng.vdn.dashboard.web.model.AvlbMinutelyModel;
import com.ifeng.vdn.dashboard.web.model.ExtJSReturn;

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
			@RequestParam(value = "type", required = false) int type,
			@RequestParam(value = "range", required = false) int range) {

		AvlbMinutelyModel model = VideoFilterAdapter.create(VideoReportType.SPGK, range);
		model.setType(type);
		model.setRange(range);
		
		List<AvlbMinutelyModel> list = new ArrayList<AvlbMinutelyModel>();

		list = videoReportService.getAvlbMinutely(model);

		return ExtJSReturn.mapOK(list);
	}
	
	@Autowired
	private VideoReportService videoReportService;
}
