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

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jul 7, 2015
 */
@Repository
@Profile("mongodb")
public class MongodbIPRepository implements IPRepository {
	
	@Autowired
	public MongodbIPRepository(MongoOperations operations) {
		this.operations = operations;
	}

	/*@Override
	public IPDocument getIPDocument(String ip) {
		Query query = query(where("ip").is(ip));
		
		IPDocument ipDocument = (IPDocument)operations.find(query, IPDocument.class);
		
		return ipDocument;
	}*/
	
	@Override
	public IPDocument findByip(String ip) {
		Query query = query(where("id").is(ip));
		return operations.findOne(query, IPDocument.class);
	}
	
	@Override
	public IPDocument save(IPDocument ipDocument) {
		//operations.save(ipDocument);
		
		mongoTemplate.save(ipDocument);
		
		return ipDocument;
	}

	@Autowired
	private final MongoOperations operations;
	
	@Autowired
	private MongoTemplate mongoTemplate;

}
