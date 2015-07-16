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
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifeng.vdn.dashboard.orm.domain.IPServerJournal;
import com.ifeng.vdn.dashboard.orm.mybatis.mapper.IPServerMapper;
import com.ifeng.vdn.dashboard.service.IPServerService;
import com.ifeng.vdn.dashboard.web.model.IPServerJournalModel;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jul 8, 2015
 */
@Service("ipServerService")
public class IPServerServiceImpl implements IPServerService {

	@Override
	public void create(IPServerJournal serverJournal) {
		ipServerMapper.create(serverJournal);
	}

	@Override
	public List<IPServerJournal> read(IPServerJournalModel serverJournalModel) {
		if(serverJournalModel != null){
			if(serverJournalModel.getStart_time() == null){
				Calendar cal = GregorianCalendar.getInstance();
				cal.set(Calendar.HOUR_OF_DAY, 0);
				cal.set(Calendar.MINUTE, 0);
				cal.set(Calendar.SECOND, 0);
				cal.set(Calendar.MILLISECOND, 0);
				
				serverJournalModel.setStart_time(cal.getTime());
			}
			
			return ipServerMapper.read(serverJournalModel);
		}else {
			return new ArrayList<IPServerJournal>();
		}
		
	}
	
	@Autowired
	private IPServerMapper ipServerMapper;
}
