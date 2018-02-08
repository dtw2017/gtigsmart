package com.gtigsmart.mis.common;
import org.springframework.web.multipart.MultipartFile;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UploadModel {
	 private MultipartFile[] uploadfiles;
}
