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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.ifeng.vdn.dashboard.web.model.AvlbMinutelyModel;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jul 24, 2015
 */
public final class VideoFilterAdapter {

	public static AvlbMinutelyModel create(VideoReportType reportType, int range) {
		AvlbMinutelyModel model = new AvlbMinutelyModel();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		
		
		String ct = "";
		List<String> daily = new ArrayList<String>();

		for (int i = 0; i <= range; i++) {
			Calendar cal = GregorianCalendar.getInstance();
			ct = sf.format(cal.getTime());
			cal.set(Calendar.DAY_OF_YEAR, cal.get(Calendar.DAY_OF_YEAR) - i);
			ct = sf.format(cal.getTime());
			
			daily.add(ct);
		}
		
		model.setRange(range);
		model.setdCode(reportType.getdCode());
		model.setnCode(reportType.getnCode());
		model.setDaily(daily);

		return model;
	}

	public enum VideoReportType {
		SPGK("208000", "303000"), CWXQ("", ""), ZYXX("", ""), QYXX("", ""), QQTJ(
				"", ""), IPTJ("", "");

		VideoReportType(String dCode, String nCode) {
			this.dCode = dCode;
			this.nCode = nCode;
		}

		/**
		 * get denominator code
		 * 
		 * @return
		 */
		public String getdCode() {
			return dCode;
		}

		/**
		 * get numerator code.
		 * 
		 * @return
		 */
		public String getnCode() {
			return nCode;
		}

		private String dCode;
		private String nCode;
	}
	
	public static void main(String[] args){
		AvlbMinutelyModel model = create(VideoReportType.SPGK, 1);
		
		System.out.println(model.getCt());
	}
}
