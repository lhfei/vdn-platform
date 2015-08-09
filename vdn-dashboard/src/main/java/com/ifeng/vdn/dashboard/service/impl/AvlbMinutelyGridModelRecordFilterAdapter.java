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

import java.io.IOException;
import java.util.Iterator;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifeng.vdn.dashboard.service.RecordFilterAdapter;
import com.ifeng.vdn.dashboard.web.model.AvlbMinutelyGridModel;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Aug 7, 2015
 */
@Component("avlbFilterAdapter")
public class AvlbMinutelyGridModelRecordFilterAdapter implements
		RecordFilterAdapter<AvlbMinutelyGridModel> {

	@Override
	public AvlbMinutelyGridModel adapter(String json) {
		AvlbMinutelyGridModel model = new AvlbMinutelyGridModel();
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			if (null != json) {
				JsonNode node = mapper.readTree(json);

				if (node != null && node.isArray()) {
					Iterator<JsonNode> iter = node.iterator();
					while (iter.hasNext()) {
						JsonNode item = iter.next();
						String prop = item.get("field").asText();
						String comparison = item.get("comparison").asText();

						switch (comparison) {
						case "lt":
							comparison = "lt";
							break;
						case "eq":
							comparison = "eq";
							break;
						case "gt":
							comparison = "gt";
							break;
						}

						switch (prop) {

						case "ka":
							double ka = item.get("value").asDouble();
							model.setKa(ka);
							model.setKaFilter(comparison);
							break;

						case "kb":
							double kb = item.get("value").asDouble();
							model.setKb(kb);
							model.setKbFilter(comparison);
							break;
						case "kc":
							double kc = item.get("value").asDouble();
							model.setKc(kc);
							model.setKcFilter(comparison);
							break;

						default:
							break;
						}
					}
				}
			}

		} catch (IOException e) {

		}
		return model;
	}

}
