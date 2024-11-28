package com.web.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.web.dto.LoginRequest;
import com.web.dto.UsersRequestDTO;
import com.web.entity.Users;
import com.web.repository.UsersRepository;
import com.web.utils.FileUtils;

@Service
public class UserService {
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public Object createUser(Users users) {
		Optional<Users> existingUser = usersRepository.findById(users.getEmail());
		if (existingUser.isPresent()) {
			return "Email đã tồn tại.";
		}
		String encryptPassword = passwordEncoder.encode(users.getMatKhau());
		Users user = new Users(users.getEmail(), users.getHoTen(), encryptPassword);
		return usersRepository.save(user);
	}

	public Object login(LoginRequest loginRequest) {
		Optional<Users> userOptional = usersRepository.findById(loginRequest.getEmail());
		if (userOptional.isEmpty()) {
			return "Mật khẩu hoặc tài khoản không chính xác.";
		}

		Users user = userOptional.get();
		if (!passwordEncoder.matches(loginRequest.getMatKhau(), user.getMatKhau())) {
			return "Mật khẩu hoặc tài khoản không chính xác.";
		}

		return user;
	}

	public Object updateUser(String email, UsersRequestDTO updatedUser) {
		Optional<Users> existingUser = usersRepository.findById(email);
		if (existingUser.isEmpty()) {
			return "Người dùng không tồn tại.";
		}
		try {
			String url = existingUser.get().getAnh();
			if (Objects.nonNull(updatedUser.getFile())) {
				if(Objects.nonNull(url)) {
					FileUtils.deleteFile(url);
				}
				url = FileUtils.writeFile(updatedUser.getFile());
			}
			Users user = existingUser.get();
			user.setHoTen(updatedUser.getHoTen());
			String encryptPassword = passwordEncoder.encode(updatedUser.getMatKhau());
			user.setMatKhau(encryptPassword);
			if (Objects.nonNull(user.getAnh())) {
				FileUtils.deleteFile(user.getAnh().replace("uploads/", ""));
			}
			user.setAnh(url);
			usersRepository.save(user);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return "Kích thước file ảnh quá lớn.";
		}

	}

	public Object findByEmail(String email) {
		Optional<Users> existingUser = usersRepository.findById(email);
		if (existingUser.isEmpty()) {
			return "Người dùng không tồn tại.";
		}
		return existingUser.get();

	}
}
