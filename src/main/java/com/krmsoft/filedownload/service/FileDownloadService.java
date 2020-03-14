package com.krmsoft.filedownload.service;

import java.io.InputStream;

import javax.annotation.Resource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FileDownloadService {

	public ResponseEntity<?> createDownloadableFile() throws Exception{
		 // Load file as Resource
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("test.xlsx");
		byte[] targetArray = new byte[inputStream.available()];
		inputStream.read(targetArray);
        // Try to determine file's content type
        String contentType = null;
        // Fallback to the default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
            .contentType(MediaType.parseMediaType(contentType))
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "test.xlsx" + "\"")
            .body(targetArray);

	}
}
