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
package com.ifeng.vdn.dashboard.orm.mybatis.mapper;

import java.util.List;

import com.ifeng.vdn.dashboard.orm.domain.IPImportReport;
import com.ifeng.vdn.dashboard.orm.domain.IPJournal;
import com.ifeng.vdn.dashboard.web.model.IPImportReportModel;
import com.ifeng.vdn.dashboard.web.model.IPJournalModel;
import com.ifeng.vdn.dashboard.web.model.IPModel;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jun 30, 2015
 */
public interface IPAreaMapper {

	IPJournal getIPJournalLatest();
	
	void importIP(List<IPModel> ipList);
	
	List<IPImportReport> getIPImportReport(IPImportReportModel model);

	void createImportReport(IPImportReport ipImportReport);
	
	void createIPJournal(IPJournal journal);
	
	List<IPJournal> getIPJournal(IPJournalModel model);
}
