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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jun 11, 2015
 */
@Controller
@RequestMapping("system")
public class SystemController extends AbstractController {

	@RequestMapping("forward")
	public ModelAndView forward() {
		ModelAndView view = new ModelAndView("system/login");

		return view;
	}
	
	@RequestMapping("login")
	public ModelAndView login(@RequestParam("userName") String userName,
			@RequestParam("passWord") String passWord) {
		ModelAndView view = new ModelAndView("system/main");

		return view;
	}
	
	
	@RequestMapping("loadMenu")
	public ModelAndView loadMenu() {
		ModelAndView view = new ModelAndView("system/menuPanel");

		log.info("menu loading ...");
		
		return view;
	}
	
	@RequestMapping("loadBench")
	public ModelAndView loadBench() {
		ModelAndView view = new ModelAndView("system/benchPanel");
		
		log.info("workstation loading ...");
		
		return view;
	}
	
}
