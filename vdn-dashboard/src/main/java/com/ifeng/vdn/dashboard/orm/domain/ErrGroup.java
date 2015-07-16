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
package com.ifeng.vdn.dashboard.orm.domain;

import java.util.Date;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jun 23, 2015
 */
public class ErrGroup {

	
	public final long getId() {
		return id;
	}
	public final void setId(long id) {
		this.id = id;
	}
	public final String getErr() {
		return err;
	}
	public final void setErr(String err) {
		this.err = err;
	}
	public final String getLoc() {
		return loc;
	}
	public final void setLoc(String loc) {
		this.loc = loc;
	}
	public final int getTotal() {
		return total;
	}
	public final void setTotal(int total) {
		this.total = total;
	}
	public final Date getDataTime() {
		return dataTime;
	}
	public final void setDataTime(Date dataTime) {
		this.dataTime = dataTime;
	}
	public final Date getCreateTime() {
		return createTime;
	}
	public final void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	private long id;
	private String err;			//ERR 代码
	private String loc;			//节点名称
	private int total;			//分组后汇总数
	private Date dataTime;		//日志文件生成时间
	private Date createTime;	//数据统计时间
}
