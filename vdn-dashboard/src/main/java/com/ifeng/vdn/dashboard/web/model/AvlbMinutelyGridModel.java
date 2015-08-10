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

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Aug 6, 2015
 */
public class AvlbMinutelyGridModel extends AbstractPaginationModel implements Serializable {
	private static final long serialVersionUID = 7552318548739096442L;
	
	public void adaptDaily(Date start, Date end) {
		List<String> days = new ArrayList<String>();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");	
		
		if(start != null && end != null){
			Calendar cal = GregorianCalendar.getInstance();
			cal.setTime(start);
			
			while(start.before(end)){

				days.add(sf.format(start));
				
				cal.add(Calendar.DAY_OF_MONTH, 1);
				start = cal.getTime();
			}
			
			days.add(sf.format(end));
		}
		
		daily = days;
	}
	
	public String getIsp() {
		return isp;
	}
	public void setIsp(String isp) {
		this.isp = isp;
	}
	public String getIspAlias() {
		return ispAlias;
	}
	public void setIspAlias(String ispAlias) {
		this.ispAlias = ispAlias;
	}
	public String getCt() {
		return ct;
	}
	public void setCt(String ct) {
		this.ct = ct;
	}
	public String getTr() {
		return tr;
	}
	public void setTr(String tr) {
		this.tr = tr;
	}
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
	
	public List<String> getDaily() {
		return daily;
	}
	public void setDaily(List<String> daily) {
		this.daily = daily;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public int getC2() {
		return c2;
	}
	public void setC2(int c2) {
		this.c2 = c2;
	}
	public int getC3() {
		return c3;
	}
	public void setC3(int c3) {
		this.c3 = c3;
	}
	public int getC4() {
		return c4;
	}
	public void setC4(int c4) {
		this.c4 = c4;
	}
	public int getD() {
		return d;
	}
	public void setD(int d) {
		this.d = d;
	}
	public int getD2() {
		return d2;
	}
	public void setD2(int d2) {
		this.d2 = d2;
	}
	public int getD3() {
		return d3;
	}
	public void setD3(int d3) {
		this.d3 = d3;
	}
	public int getE() {
		return e;
	}
	public void setE(int e) {
		this.e = e;
	}
	public int getF() {
		return f;
	}
	public void setF(int f) {
		this.f = f;
	}
	public int getF2() {
		return f2;
	}
	public void setF2(int f2) {
		this.f2 = f2;
	}
	public int getG() {
		return g;
	}
	public void setG(int g) {
		this.g = g;
	}
	public int getG2() {
		return g2;
	}
	public void setG2(int g2) {
		this.g2 = g2;
	}
	public double getKa() {
		return ka;
	}
	public void setKa(double ka) {
		this.ka = ka;
	}
	public double getKb() {
		return kb;
	}
	public void setKb(double kb) {
		this.kb = kb;
	}
	public double getKc() {
		return kc;
	}
	public void setKc(double kc) {
		this.kc = kc;
	}
	public double getKc2() {
		return kc2;
	}
	public void setKc2(double kc2) {
		this.kc2 = kc2;
	}
	public double getKc3() {
		return kc3;
	}
	public void setKc3(double kc3) {
		this.kc3 = kc3;
	}
	public double getKc4() {
		return kc4;
	}
	public void setKc4(double kc4) {
		this.kc4 = kc4;
	}
	public double getKd() {
		return kd;
	}
	public void setKd(double kd) {
		this.kd = kd;
	}
	public double getKd2() {
		return kd2;
	}
	public void setKd2(double kd2) {
		this.kd2 = kd2;
	}
	public double getKd3() {
		return kd3;
	}
	public void setKd3(double kd3) {
		this.kd3 = kd3;
	}
	public double getKe() {
		return ke;
	}
	public void setKe(double ke) {
		this.ke = ke;
	}
	public double getKf() {
		return kf;
	}
	public void setKf(double kf) {
		this.kf = kf;
	}
	public double getKf2() {
		return kf2;
	}
	public void setKf2(double kf2) {
		this.kf2 = kf2;
	}
	public double getKf3() {
		return kf3;
	}
	public void setKf3(double kf3) {
		this.kf3 = kf3;
	}
	private String ispAlias;
	private String isp;
	private String ct;
	private String tr;
	private String cat;
	
	@JsonIgnore
	private List<String> daily;
	
	private int a;		//total of 208000
	private int b;		//total of 303000
	private int c;		//total of 304001
	private int c2;		//total of 304002
	private int c3;		//total of 304003
	private int c4;		//total of 304004
	private int d;		//total of 301010	
	private int d2;		//total of 301020
	private int d3;		//total of 301040
	private int e;		//total of 301030_X
	private int f;		//total of 100000
	private int f2;		//total of 110000
	
	private int g;		//total of 601000
	private int g2;		//total of 602000
	
	private double ka;		//per of 303000 / 208000 * 100%
	private double kb;		// 1- kc
	private double kc;		//per of 304001 / 303000 * 100%
	private double kc2;		//per of 304002 / 303000 * 100%
	private double kc3;		//per of 304003 / 303000 * 100%
	private double kc4;		//per of 304004 / 303000 * 100%
	
	private double kd;		//per of 301010 / 303000 * 100%	
	private double kd2;		//per of 301020 / 303000 * 100%
	private double kd3;		//per of 301040 / 100000 * 100%
	private double ke;		//per of 301030_X / 303000 * 100%
	
	private double kf;		//1 - 303000/100000
	private double kf2;		//per of 110000	/ 100000 * 100%-
	private double kf3;  	//(100000 - 303000 - 110000 - 301040) / 100000 * 100%
	
	
	// Filter expression
	private String kaFilter;
	private String kbFilter;
	private String kcFilter;

	public String getKaFilter() {
		return kaFilter;
	}
	public void setKaFilter(String kaFilter) {
		this.kaFilter = kaFilter;
	}
	public String getKbFilter() {
		return kbFilter;
	}
	public void setKbFilter(String kbFilter) {
		this.kbFilter = kbFilter;
	}
	public String getKcFilter() {
		return kcFilter;
	}
	public void setKcFilter(String kcFilter) {
		this.kcFilter = kcFilter;
	}
	
} 
