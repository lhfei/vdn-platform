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

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ifeng.vdn.dashboard.orm.domain.IPServerJournal;
import com.ifeng.vdn.dashboard.service.IPServerService;
import com.ifeng.vdn.dashboard.web.model.IPServerJournalModel;
import com.ifeng.vdn.test.support.BasicTestSuit;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jul 8, 2015
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context-test.xml")
public class IPServerServiceImplTest extends BasicTestSuit {

	@Test
	public void create() {
		IPServerJournal journal = new IPServerJournal();
		Date date = new Date();
		journal.setData_status(0);
		journal.setIp("114.80.177.144");
		journal.setTotal(12000);
		journal.setCreate_time(date);
		journal.setLatest_time(date);
		
		ipServerService.create(journal);
	}
	
	
	@Test
	public void read() {
		IPServerJournalModel serverJournalModel = new IPServerJournalModel();
		serverJournalModel.setIp("220.181.35.111");
		serverJournalModel.setEnd_time(new Date());
		
		
		List<IPServerJournal> list = ipServerService.read(serverJournalModel);
		
		log.info("Result: {}", list.size());
		
		for(IPServerJournal journal : list){
			log.info("IP: {}, Created: {}", journal.getIp(), journal.getCreate_time());
		}
	}
	
	@Autowired
	private IPServerService ipServerService;
}
