/**
 * 
 */
package jmp.yury.kiryla.spring_mvc.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Files controller
 * 
 * @author Yury_Kiryla
 *
 */
@Controller
@RequestMapping("/files")
public class FilesController {
	/**
	 * Path fo files
	 */
	private static final String PATH = System.getProperty("catalina.home") + File.separator + "tmpFiles";

	/**
	 * Files page
	 */
	@RequestMapping
	public String filesPage() {
		return "files";
	}

	/**
	 * upload file
	 * 
	 * @param file
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(@RequestParam("file") MultipartFile file, Model model) {
		if (!file.isEmpty()) {
			byte[] bytes;
			try {
				bytes = file.getBytes();
				File dir = new File(PATH);
				if (!dir.exists()) {
					dir.mkdirs();
				}

				File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
				try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile))) {
					stream.write(bytes);
				}
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage());
			}

			model.addAttribute("filename", file.getOriginalFilename());
		}

		return "files";
	}

	/**
	 * download file
	 * 
	 * @param filename
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public String downloadDocument(String filename, HttpServletResponse response) throws IOException {

		try (InputStream inputStream = new FileInputStream(new File(PATH + File.separator + filename))) {
			FileCopyUtils.copy(inputStream, response.getOutputStream());
		}

		return "files";
	}

}
