package com.tdtu.lihitiShop;

import com.tdtu.lihitiShop.controller.AuthController;
import com.tdtu.lihitiShop.dto.ReqResDto;
import com.tdtu.lihitiShop.dto.UserDto;
import com.tdtu.lihitiShop.entity.User;
import com.tdtu.lihitiShop.mapper.UserMapper;
import com.tdtu.lihitiShop.repository.UserRepository;
import com.tdtu.lihitiShop.security.JWTutils;
import com.tdtu.lihitiShop.service.UserService;
import com.tdtu.lihitiShop.service.impl.AuthServiceImpl;
import com.tdtu.lihitiShop.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.verification.VerificationMode;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class LihitiShopApplicationTests {

	@MockBean
	private UserRepository userRepository;

	@InjectMocks
	private UserServiceImpl userService;

	@Mock
	private UserMapper userMapper;



	@Test
	void testRegister() {
		// Prepare test data
		User userRegister = new User();
		userRegister.setUsername("lehaitien42");
		userRegister.setPassword("422003tT");
		userRegister.setRole("USER");
		userRegister.setAddress("Dong nai");
		userRegister.setFullName("Le Hai Tien");

		User userSaved = new User();
		userSaved.setUsername("lehaitien42");




		// Mock the dependencies
		when(userRepository.save(any(User.class))).thenReturn(userSaved);

		// Call the method under test
		UserDto saveUser = userService.createUser(UserMapper.mapToUserDto(userRegister));

		// Mock the dependencies
		//when(userRepository.save(userRegister)).thenReturn(userRegister);

		assertEquals(saveUser.getUsername(),userSaved.getUsername());
	}

	@Test
	void testLogin() {
		// Prepare test data
		User userRegister = new User();
		userRegister.setUsername("lehaitien");
		userRegister.setPassword("422003tT");

		List<UserDto> service = userService.getAllUsers().stream()
				.filter(e->e.getUsername().equals(userRegister.getUsername())).toList();

		// Mock the dependencies
		when(userRepository.findByUsername(userRegister.getUsername()))
				.thenReturn(Optional.of(userRegister));

		assertEquals(1,service.size());
	}







}
