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
package com.ifeng.vdn.dashboard.web.model;
/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jul 2, 2015
 */
public class IPJournalModel extends AbstractPaginationModel {

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDigest() {
		return digest;
	}
	public void setDigest(String digest) {
		this.digest = digest;
	}
	public String getLastChecksum() {
		return lastChecksum;
	}
	public void setLastChecksum(String lastChecksum) {
		this.lastChecksum = lastChecksum;
	}
	public boolean isHasChanged() {
		return hasChanged;
	}
	public void setHasChanged(boolean hasChanged) {
		this.hasChanged = hasChanged;
	}

	private Long id;
	private String digest;
	private String lastChecksum;
	private boolean hasChanged;
}
