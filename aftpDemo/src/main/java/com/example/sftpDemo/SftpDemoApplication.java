package com.example.sftpDemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.example.sftpDemo.model.CSVData;
import com.example.sftpDemo.service.CSVDataService;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

@SpringBootApplication
@EnableScheduling
public class SftpDemoApplication {
	@Autowired
	static CSVDataService csvDataService;

	public static void main(String[] args) {
		SpringApplication.run(SftpDemoApplication.class, args);

		
	}
	
	@Scheduled(cron = "0 */15 * ? * *")
	public void scheduled() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

	      Date now = new Date();
	      String strDate = sdf.format(now);
	      System.out.println("Fixed Rate scheduler:: " + strDate);
	      JSch jSch = new JSch();
	      Session session = null;
	      ChannelSftp channelSftp = null;
	      
	      try {
				String user = "test_user";
				String pass = "test";
				Properties config = new Properties();
				config.put("StrictHostKeyChecking","no");
				String host = "127.0.0.1";
				String download = "C:\\desktop\\download\\";

				
				 session = jSch.getSession(user,host);
				session.setPassword(pass);
				session.setConfig(config);
				session.connect();
				 channelSftp = (ChannelSftp) session.openChannel("sftp");
				channelSftp.connect();

				// read all remote file 
				Vector fileList = channelSftp.ls("inbound/");
				for (int i = 0; i < fileList.size(); i++) {
					ChannelSftp.LsEntry lsEntry = (ChannelSftp.LsEntry) fileList.get(i);
					//                System.out.println(lsEntry.getFilename());

					String svrPath = "inbound/"+lsEntry.getFilename();
					String loclPath = download+lsEntry.getFilename();



					File directory = new File(download);
					//get all the files from a directory
					File[] list = directory.listFiles();
					List<File> fList = Arrays.asList(list);

					Boolean isFileExist = false;
					if(fList.size() > 0) {
						for (File file : fList){
							if (file.isFile()){
								if(file.getName().equalsIgnoreCase(lsEntry.getFilename())) {
									isFileExist = true;
									break;
								} 
							}
						}
						if(!isFileExist) {
							channelSftp.get("inbound/"+lsEntry.getFilename(), download+lsEntry.getFilename());
							csvDataService.save(download+lsEntry.getFilename());
						}
					}else {
						channelSftp.get("inbound/"+lsEntry.getFilename(), download+lsEntry.getFilename());
					}
				}
				System.out.println("Session connected: "+session.isConnected());
				
			} catch (Exception e) {
				e.printStackTrace();
				channelSftp.disconnect();
				session.disconnect();
			}
	      finally {
			
		}
	      
	      
	}

}
