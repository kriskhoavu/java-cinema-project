package com.myproject.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("file")
public class DMSController {
	private final String UPLOAD_FOLDER = "/resources/upload/";
	private final String RESULT_FOLDER = "/statics/upload/";

	@Autowired
	ServletContext _sevletContext;

	@PostMapping("upload")
	@ResponseBody
	public Object UploadDocument(@RequestParam MultipartFile file) {
		String path = _sevletContext.getRealPath(UPLOAD_FOLDER);

		File dir = new File(path);
		if (!dir.exists())
			dir.mkdir();

		File pathFile = new File(path + file.getOriginalFilename());
		FileOutputStream stream;

		try {
			stream = new FileOutputStream(pathFile);
			stream.write(file.getBytes());
			stream.close();

			Map<String, String> result = new HashMap<String, String>();
			result.put("url", file.getOriginalFilename());

			return result;

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@GetMapping(value = "load")
	@ResponseBody
	public Object GetDocument(String fileName) {
		if (!fileName.isEmpty()) {
			String pathSource = _sevletContext.getContextPath() + RESULT_FOLDER + fileName;

			Map<String, String> result = new HashMap<String, String>();
			result.put("name", fileName);
			result.put("url", pathSource);
			return result;
		}
		return null;
	}
}
