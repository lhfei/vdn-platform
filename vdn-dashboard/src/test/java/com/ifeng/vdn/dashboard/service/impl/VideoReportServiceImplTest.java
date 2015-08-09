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
package com.ifeng.vdn.dashboard.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ifeng.vdn.dashboard.service.RecordFilterAdapter;
import com.ifeng.vdn.dashboard.service.VideoReportService;
import com.ifeng.vdn.dashboard.service.impl.VideoFilterAdapter.VideoReportType;
import com.ifeng.vdn.dashboard.web.model.AvlbDailyModel;
import com.ifeng.vdn.dashboard.web.model.AvlbMinutelyGridModel;
import com.ifeng.vdn.dashboard.web.model.AvlbMinutelyModel;
import com.ifeng.vdn.test.support.BasicTestSuit;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Aug 4, 2015
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context-test.xml")
public class VideoReportServiceImplTest extends BasicTestSuit {

	@Test
	public void getAvlb() {
		AvlbMinutelyModel model = VideoFilterAdapter.create(VideoReportType.SPGK, 3);
		model.setCategory("LG01");
		model.setRange(3);
		model.setIsp("移动");
		
		List<AvlbDailyModel> list = new ArrayList<AvlbDailyModel>();
		
		list = videoReportService.getAvlb(model);
		
		log.info("Size: {}", list.size());
	}
	
	@Test
	public void get() {
		List<AvlbMinutelyGridModel> list = new ArrayList<AvlbMinutelyGridModel>();
		String json = "[{\"type\":\"numeric\",\"comparison\":\"eq\",\"value\":0.8,\"field\":\"ka\"}]";
		
		AvlbMinutelyGridModel model = avlbFilterAdapter.adapter(json);
		
		model.setStart(1);
		model.setLimit(20);
		
		list = videoReportService.getAvlbMinutelyForGrid(model);
		
		for(AvlbMinutelyGridModel grid : list){
			log.info("ka: {}, kb: {}, kc:{}, kc2: {}, kc3: {}", grid.getKa(), grid.getKb(), grid.getKc(), grid.getKc2(), grid.getKc3() );
		}
	}
	
	@Autowired
	private VideoReportService videoReportService;
	
	@Autowired
	private RecordFilterAdapter<AvlbMinutelyGridModel> avlbFilterAdapter;
}
