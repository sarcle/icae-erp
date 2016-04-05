package com.uttec.icae.service.encoder.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.uttec.icae.service.encoder.PasswordEncoderService;

@Service
public class PasswordEncoderServiceImpl implements PasswordEncoderService {

	@Override
	public String getPasswordEncoded(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(password);
		return encodedPassword;
	}

	public static void main(String[] args) {
		if (args.length == 1) {
			String password = args[0];
			PasswordEncoderService passwordEncoderService = new PasswordEncoderServiceImpl();
			String encodedPassword = passwordEncoderService.getPasswordEncoded(password);
			System.out.println("Password: " + encodedPassword);
		} else {
//			throw new PortalNominaException("Debe proporcionar el password a encriptar.");
			try {
				throw new Exception("Debe proporcionar el password a encriptar.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
