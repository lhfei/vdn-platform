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
package com.ifeng.vdn.conf;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ifeng.vdn.test.support.BasicTestSuit;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jul 3, 2015
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context.xml")
public class DashboardApplicationContextTest extends BasicTestSuit {

	@Test
	public void getHDFSConfiguration() {
		Map<String, String> hdfsMap = new HashMap<String, String>();
		
		hdfsMap = dashboardApplicationContext.getHDFSConfiguration();
		
		hdfsMap.forEach(new BiConsumer<String, String>(){

			@Override
			public void accept(String key, String value) {
				log.debug("Entry<{} , {}>", key, value);
			}
			
		});
		
		String hdfsURL = hdfsMap.get(GlobalConstant.HDFSConfiguration.HDFS_URL.getKey());
		
		log.info("HDFS URL: {}", hdfsURL);
	}
	
	@Autowired
	private DashboardApplicationContext dashboardApplicationContext;
}
