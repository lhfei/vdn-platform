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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifeng.vdn.commons.util.FileChecksumGenerator;
import com.ifeng.vdn.conf.DashboardApplicationContext;
import com.ifeng.vdn.conf.GlobalConstant;
import com.ifeng.vdn.dashboard.orm.domain.IPImportReport;
import com.ifeng.vdn.dashboard.orm.domain.IPJournal;
import com.ifeng.vdn.dashboard.orm.mybatis.mapper.IPAreaMapper;
import com.ifeng.vdn.dashboard.service.IPAddressHandler;
import com.ifeng.vdn.dashboard.service.IPAreaService;
import com.ifeng.vdn.dashboard.web.model.IPImportReportModel;
import com.ifeng.vdn.dashboard.web.model.IPJournalModel;
import com.ifeng.vdn.dashboard.web.model.IPModel;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jun 30, 2015
 */
@Service("ipAreaService")
public class IPAreaServiceImpl implements IPAreaService {
	
	private static final Logger log = LoggerFactory.getLogger(IPAreaServiceImpl.class);
	
	//private static final String url = "http://123.103.58.182/ipbase/ipserver/ipArea";
	//private static final String localFile = "E:\\Webapp_workspace\\webapps_IFeng\\vdn-platform\\vdn-dashboard\\src\\test\\resources\\ipArea.txt";
	//private static final String localFile = "/home/cloudland/app_data/ipArea.txt";

	@Override
	public InputStream getIPAreaFile() {
		String ipServerURL = dashboardApplicationContext.getIPserverConfiguration().get(GlobalConstant.IPServerConfiguration.IPSERVER_URL.getKey());
		InputStream in = null;
		CloseableHttpResponse response = null;
		// Create an instance of HttpClient.
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(ipServerURL);
		
		log.info("Executing request " + httpget.getRequestLine());
		
		try {
			response = httpclient.execute(httpget);
			
			// Get hold of the response entity
			HttpEntity entity = response.getEntity();
			if(entity != null){
				in = entity.getContent();
			}
			
		} catch (UnsupportedOperationException | IOException e) {
			log.error(e.getMessage(), e);
		} /*finally {
			if(httpclient != null){
				try {
					httpclient.close();
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				}
			}
		}*/
		
		return in;
	}

	@Override
	public IPImportReport importIPFromIPServer() {
		IPImportReport result = new IPImportReport();
		Date current = new Date();
		InputStream in = null;
		String line = null;
		InputStreamReader reader = null;
		BufferedReader br = null;
		
		long total = 0l;
		long valid = 0l;
		long skip = 0l;
		
		try {
			/*in = this.getIPAreaFile();*/
			in = getIPAreaFileFromLocal(false);
			
			reader = new InputStreamReader(in);
			br = new BufferedReader(reader);
			
			while((line = br.readLine()) != null){
				log.info("{}", line);
				
				total += 1;
				valid += 1;
			}
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				}
			}
			if(reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				}
			}
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				}
			}
			
			result.setCreate_time(current);
			result.setLatest_time(current);
			result.setTotal(total);
			result.setValid(valid);
			result.setSkip(skip);
		}
		
		return result;
	}

	@Override
	public String getIPAreaFileChecksum() {
		String digest = null;
		InputStream in = null;
		
		try {
			//in = getIPAreaFile();
			in = getIPAreaFileFromLocal(true);
			digest = FileChecksumGenerator.getChecksumByMD5(in);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			digest = null;
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				}
			}
		}
		
		return digest;
	}

	@Override
	public InputStream getIPAreaFileFromLocal(boolean isRepeated) {
		File file = new File(getIPAreaFileLoaction(isRepeated));
		InputStream in = null;
		try {
			in = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			log.error(e.getMessage(), e);
		}
		
		return in;
	}

	@Override
	public void downloadIPAreaFile() {
		int numBytes;
		InputStream in = null;
		CloseableHttpResponse response = null;
		
		FileOutputStream fo = null;
		BufferedWriter bw = null;
		
		String ipServerURL = dashboardApplicationContext.getIPserverConfiguration().get(GlobalConstant.IPServerConfiguration.IPSERVER_URL.getKey());
		// Create an instance of HttpClient.
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(ipServerURL);
		
		log.info("Executing request " + httpget.getRequestLine());
		
		try {
			response = httpclient.execute(httpget);
			
			char[] c = new char[1024 * 10];
			
			// Get hold of the response entity
			HttpEntity entity = response.getEntity();
			if(entity != null){
				in = entity.getContent();
				
				InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
				
				Reader reader = new BufferedReader(isr);
				
				fo = new FileOutputStream(new File(getIPAreaFileLoaction(true)));
				
				bw = new BufferedWriter(new OutputStreamWriter(fo, StandardCharsets.UTF_8));
				
				while((numBytes = reader.read(c)) != -1){
					bw.write(c, 0, numBytes);
				}
				bw.flush();
			}
			
		} catch (UnsupportedOperationException | IOException e) {
			log.error(e.getMessage(), e);
		} finally {
			if(httpclient != null){
				try {
					httpclient.close();
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				}
			}
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				}
			}
			if(fo != null){
				try {
					fo.flush();
					fo.close();
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				}
			}
		}
	}

	@Override
	public List<String> extractIPAreaFile() {
		List<String> lines = new ArrayList<String>();
		try {
			Path path = Paths.get(getIPAreaFileLoaction(true));
			lines = Files.readAllLines(path, StandardCharsets.UTF_8);
			
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
		
		return lines;
	}

	@Override
	public IPImportReport importIPFromIPAreaFile() {
		List<IPModel> ipList = new ArrayList<IPModel>();
		IPImportReport result = new IPImportReport();
		
		Date current = new Date();
		long total = 0l;
		long valid = 0l;
		long skip = 0l;
		
		try {
			Long batchSize = Long
					.parseLong(dashboardApplicationContext
							.getIPserverConfiguration()
							.get(GlobalConstant.IPServerConfiguration.IPAREA_FILE_BATCH_SIZE
									.getKey()));
			
			List<String> lines = new ArrayList<String>();
			
			lines = extractIPAreaFile();
			
			Iterator<String> iterator = lines.stream().distinct().iterator();
			while(iterator.hasNext()){
				String line = iterator.next();
				String[] items = line.split("\\|");
				if(items.length == 5){
					String start = items[0];
					String end = items[1];
					
					List<String> ips = ipV4Handler.getAllFromRange(start, end);
					
					for(String ip : ips){
						IPModel model = new IPModel();
						model.setIp(ip);
						model.setIsp(items[2]);
						model.setRegion(items[3]);
						model.setCity(items[4]);
						model.setCreate_time(current);
						model.setLatest_time(current);
						
						model.setArea("");
						model.setArea_id("");
						model.setCity_id("");
						model.setCountry("");
						model.setCountry_id("");
						model.setCounty("");
						model.setCounty_id("");
						
						ipList.add(model);
						
						total ++;
						valid ++;
						
						if(ipList.size() % batchSize == 0){
							ipAreaMapper.importIP(ipList);
							ipList = new ArrayList<IPModel>();
						}
					}
				}
			}
			
			if(ipList.size() > 0){
				ipAreaMapper.importIP(ipList);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			result.setCreate_time(current);
			result.setLatest_time(new Date());
			result.setTotal(total);
			result.setValid(valid);
			result.setSkip(skip);
			
			ipAreaMapper.createImportReport(result);
		}
		
		return result;
	}
	
	/**
	 * @param isRepeated
	 * 
	 * @return
	 */
	@Override
	public String getIPAreaFileLoaction(boolean isRepeated) {
		String fileName = "";
		String separator = File.separator;
		StringBuilder  location = new StringBuilder();
		String path = dashboardApplicationContext.getIPserverConfiguration().get(
				GlobalConstant.IPServerConfiguration.IPAREA_FILE_LOCATION
						.getKey());
		if(isRepeated){
			fileName = dashboardApplicationContext.getIPserverConfiguration().get(
					GlobalConstant.IPServerConfiguration.IPAREA_FILE_NAME
					.getKey());
		}else{
			fileName = dashboardApplicationContext.getIPserverConfiguration().get(
					GlobalConstant.IPServerConfiguration.IPAREA_FILE_DISTINCT_NAME
					.getKey());
		}

		location.append(path);
		
		if(!path.endsWith(separator)){
			location.append(separator);
		}
		
		location.append(fileName);
		
		return location.toString();
	}
	
	
	@Override
	public void distinctIPAreaFile() {
		String noRepeatFileURI = getIPAreaFileLoaction(false);
		String uri = getIPAreaFileLoaction(true);
		
		try {
			List<String> lines = Files.readAllLines(Paths.get(uri), StandardCharsets.UTF_8);
			
			BufferedWriter writer = Files.newBufferedWriter(Paths.get(noRepeatFileURI));
			
			lines.stream().distinct().forEach(new Consumer<String>(){
				@Override
				public void accept(String t) {
					try {
						writer.append(t);
						writer.append("\r");
					} catch (IOException e) {
						log.error(e.getMessage());
					}
				}
				
			});
			
			writer.close();
			
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}

	
	@Override
	public List<IPImportReport> getIPImportReport(IPImportReportModel model) {
		return ipAreaMapper.getIPImportReport(model);
	}

	@Override
	public void createImportReport(IPImportReport report) {
		ipAreaMapper.createImportReport(report);
	}	
	
	@Override
	public void createIPJournal(IPJournal journal) {
		ipAreaMapper.createIPJournal(journal);
	}

	@Override
	public List<IPJournal> getIPJournal(IPJournalModel model) {
		return ipAreaMapper.getIPJournal(model);
	}
	
	@Autowired
	private IPAreaMapper ipAreaMapper;
	
	@Autowired
	private IPAddressHandler ipV4Handler;
	
	@Autowired
	private DashboardApplicationContext dashboardApplicationContext;
}
