package com.uttec.icae.utils;

import java.util.Comparator;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class MultipartFileComparator implements Comparator<MultipartFile> {
	@Override
	public int compare(MultipartFile file1, MultipartFile file2) {
		return file1.getOriginalFilename().compareTo(file2.getOriginalFilename());
	}
}
