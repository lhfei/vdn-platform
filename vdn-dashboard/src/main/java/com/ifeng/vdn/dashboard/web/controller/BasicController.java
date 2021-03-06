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
import org.springframework.web.bind.annotation.ResponseBody;

import com.ifeng.vdn.dashboard.orm.domain.Combobox;
import com.ifeng.vdn.dashboard.service.BasicService;
import com.ifeng.vdn.dashboard.web.model.ExtJSReturn;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jul 29, 2015
 */
@Controller
@RequestMapping("basic")
public class BasicController extends AbstractController {

	@RequestMapping("readISP")
	public @ResponseBody Map<String, Object> readISP() {
		List<Combobox> list = new ArrayList<Combobox>();
		
		list = basicService.readISP();
		
		return ExtJSReturn.mapOK(list);
	}
	
	@RequestMapping("/{pId}/getRegion")
	public @ResponseBody Map<String, Object> getRegion(@PathVariable("pId") Integer pId) {
		List<Combobox> list = new ArrayList<Combobox>();
		
		list = basicService.getRegion(pId);
		
		return ExtJSReturn.mapOK(list);
	}
	
	@Autowired
	private BasicService basicService;
}
