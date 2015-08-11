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
package com.ifeng.vdn.dashboard.service;

import java.util.List;

import com.ifeng.vdn.dashboard.web.model.AvlbDailyModel;
import com.ifeng.vdn.dashboard.web.model.AvlbMinutelyGridModel;
import com.ifeng.vdn.dashboard.web.model.AvlbMinutelyModel;
import com.ifeng.vdn.dashboard.web.model.FluentMinutelyModel;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jul 22, 2015
 */
public interface VideoReportService {

	List<AvlbDailyModel> getAvlb(AvlbMinutelyModel model);
	
	List<AvlbDailyModel> getAvlbDaily(AvlbDailyModel model);
	
	long getAvlbMinutelyTotal(AvlbMinutelyModel model);
	
	int getAvlbMinutelyForGridTotal(AvlbMinutelyGridModel model);
	List<AvlbMinutelyGridModel> getAvlbMinutelyForGrid(AvlbMinutelyGridModel model);
	
	List<AvlbMinutelyGridModel> getAvlbSummary(AvlbMinutelyGridModel model);
	
	List<AvlbMinutelyModel> getAvlbMinutely(AvlbMinutelyModel model);
	
	List<FluentMinutelyModel> getFluentMinutely(FluentMinutelyModel model);
}
