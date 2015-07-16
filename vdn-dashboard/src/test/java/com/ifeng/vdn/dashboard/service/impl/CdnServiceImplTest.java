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

import com.ifeng.vdn.dashboard.service.CdnService;
import com.ifeng.vdn.dashboard.web.model.ServerBaseModel;
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
public class CdnServiceImplTest extends BasicTestSuit {
	
	@Test
	public void createServer(){
		Date date = new Date();
		ServerBaseModel model = new ServerBaseModel();
		
		model.setIp("220.181.35.111");
		model.setInner_ip("192.168.1.1");
		model.setCreate_time(date);
		model.setLatest_time(date);
		
		
		cdnService.createServer(model);
	}
	
	@Test
	public void getServers() {
		ServerBaseModel serverBaseModel = new ServerBaseModel();
		serverBaseModel.setIp("220.181.35.111");
		
		List<ServerBaseModel> list = cdnService.getServers(serverBaseModel);
		
		log.info("Result: {}", list.size());
		
		for(ServerBaseModel serverBase : list){
			log.info("IP: {}, Created: {}", serverBase.getIp(), serverBase.getCreate_time());
		}
	}
	
	@Autowired
	private CdnService cdnService;
}
