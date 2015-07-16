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
package com.ifeng.vdn.report.rest.data.mongodb.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jul 7, 2015
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context.xml")
public class MongodbIPRepositoryTest {
	private static final Logger log = LoggerFactory.getLogger(MongodbIPRepositoryTest.class);
	@Test
	public void create() {
		IPDocument ipDocument = new IPDocument();
		ipDocument.setIp("114.80.177.146");
		ipDocument.setRegion("中国");
		ipDocument.setCountry("上海");
		ipDocument.setIsp("中国电信");
		
		//mongoOperation.save(ipDocument);
		
		ipReporitory.save(ipDocument);
	}
	
	@Test
	public void findByip() {
		IPDocument doc = ipReporitory.findByip("114.80.177.146");
		
		log.info("IP: {}, Region: {}, Country: {}, ISP: {}", doc.getIp(), doc.getRegion(), doc.getCountry(), doc.getIsp());
	}
	
	@Autowired
	private IPRepository ipReporitory;
	
	
}
