package com.myproject.controller;

import com.myproject.Util.ResponseUtil;
import com.myproject.model.common.CONSTANT;
import com.myproject.model.common.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("api/dms")
public class DMSController {
	private final String UPLOAD_FOLDER = "/resources/static/upload/";
	private final String RESULT_FOLDER = "/statics/upload/";

	@Autowired
	ServletContext _servletContext;

	@Autowired
	private ResponseUtil _responseUtil;

	@PostMapping("upload")
	@ResponseBody
	public ResponseEntity UploadDocument(@RequestParam MultipartFile file) {
		//String path = _sevletContext.getRealPath(UPLOAD_FOLDER);
		String path = "/Users/krisvu/Desktop/KrisProject/java-cinema-project/BookingTicket_SpringBoot/src/main" + UPLOAD_FOLDER;
		ResponseModel response;

		try {
			createDirectory(path);
			writeFile(path, file);
			String filePathName = "/upload/" + file.getOriginalFilename();

			response = new ResponseModel(CONSTANT.API_RESPONSE_STATUS_CODE_OK, filePathName);
			return _responseUtil.createResponse(HttpStatus.OK, response);

		} catch (Exception e) {
			e.printStackTrace();
			return _responseUtil.createResponse(HttpStatus.EXPECTATION_FAILED, null);
		}
	}

	@GetMapping(value = "load")
	@ResponseBody
	public Object GetDocument(String fileName) {
		if (!fileName.isEmpty()) {
			String pathSource = _servletContext.getContextPath() + RESULT_FOLDER + fileName;

			Map<String, String> result = new HashMap<String, String>();
			result.put("name", fileName);
			result.put("url", pathSource);
			return result;
		}
		return null;
	}

	private void createDirectory(String path) throws IOException {
		File dir = new File(path);

		if (!dir.exists()) {
			if (!dir.mkdirs()) {
				throw new IOException("Directory cannot be created");
			}
		}
	}

	private void writeFile(String path, MultipartFile file) throws IOException {
		File pathFile = new File(path + file.getOriginalFilename());

		FileOutputStream stream = new FileOutputStream(pathFile);
		stream.write(file.getBytes());
		stream.close();
	}
}
