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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ifeng.vdn.dashboard.service.IPAreaService;
import com.ifeng.vdn.dashboard.web.model.IPJournalModel;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jun 26, 2015
 */
@Controller
@RequestMapping("iparea")
public class IPAreaController extends AbstractController {
	
	@RequestMapping("checkIPAreaFile")
	public @ResponseBody IPJournalModel checkIPAreaFile() {
		IPJournalModel result = ipAreaService.checkIPAreaFile();
		
		/*IPJournalModel result = new IPJournalModel();
		
		Date date = new Date();
		result.setCreate_time(date);
		result.setLatest_time(date);
		result.setHasChanged(true);
		result.setLastChecksum("0101");
		result.setDigest("0202");*/
		
		return result;
	}
	
	@Autowired
	private IPAreaService ipAreaService;
}
