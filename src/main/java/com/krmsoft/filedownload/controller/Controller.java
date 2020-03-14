package com.krmsoft.filedownload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krmsoft.filedownload.service.FileDownloadService;

@CrossOrigin
@RestController
public class Controller {

	@Autowired
	private FileDownloadService service;
	
	@GetMapping("/download")
	public ResponseEntity<?> downloadFile()throws Exception {
		return service.createDownloadableFile();
	}
}
