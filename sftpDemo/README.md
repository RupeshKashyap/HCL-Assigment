# FTP java application ocument 
1 . download MFT server jscap server
	Link : https://www.jscape.com/solutions/sftp-server
2. install the downloaded file jscape server
	a. mangament host IP should be for local 172.0.0.1
	b. give the user name and password (this is not instance) it is root user(username : root, password : root)
	c. log in ulr : http://127.0.0.1:11880/settings/login 
	d use the same username and password while install you set
	
3. after login click on domain and add new instance
	a. e.g. testUser , => protocal => sftp , host : local (172.0.0.1) and select password (if you select password you need to manully disable the other authentication)
	b. all default 
	c. double click on default 
	d. add user => input login user and password rest will be default
4. download filizila client and login  with same added user
	User Credential : port : 127.0.0.1, Username: test_user, password: test, port:22
	
5. download from remote server and save into the database

6. if in download path is empty (1st time ) all file we download and store in the database.

7. after every 15 min ,new added file in srver will download if that file is not exist in local download file

8. and read all file from the local download diretory and store in the database
	

	
 
 
	