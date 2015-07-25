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
/**
 * 
 */
package com.ifeng.vdn.dashboard.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifeng.vdn.dashboard.orm.mybatis.mapper.VideoReportMapper;
import com.ifeng.vdn.dashboard.service.VideoReportService;
import com.ifeng.vdn.dashboard.web.model.AvlbDailyModel;
import com.ifeng.vdn.dashboard.web.model.AvlbMinutelyModel;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jul 22, 2015
 */
@Service("videoReportService")
public class VideoReportServiceImpl implements VideoReportService {

	@Override
	public List<AvlbDailyModel> getAvlbDaily(AvlbDailyModel model) {
		
		return videoReportMapper.getAvlbDaily(model);
	}
	
	@Override
	public List<AvlbMinutelyModel> getAvlbMinutely(AvlbMinutelyModel model) {
		
		return videoReportMapper.getAvlbMinutely(model);
	}
	
	@Autowired
	private VideoReportMapper videoReportMapper;
	
}
