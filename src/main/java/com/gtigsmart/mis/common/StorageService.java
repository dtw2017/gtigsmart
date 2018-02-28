package com.gtigsmart.mis.common;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public interface StorageService {

	public static boolean saveFile(List<MultipartFile> files) throws IOException {
		for (MultipartFile file : files) {
			if (file.isEmpty()) {

				continue; // next pls
			}

			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);
		}
	};

	public static boolean deleteFile(String fileFullPath) throws IOException {
		File toDeleteFile = new File(fileFullPath);
		return toDeleteFile.delete();
	}

}
