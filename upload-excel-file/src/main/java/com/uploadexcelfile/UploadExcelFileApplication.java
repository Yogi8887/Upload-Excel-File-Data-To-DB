package com.uploadexcelfile;

import com.uploadexcelfile.config.AppConstants;
import com.uploadexcelfile.entities.Role;
import com.uploadexcelfile.repository.RoleRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class UploadExcelFileApplication implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepo roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(UploadExcelFileApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.passwordEncoder.encode("123ykp"));
		try{
			Role role =new Role();
			role.setRoleId(AppConstants.ADMIN_USER);
			role.setName("ADMIN_USER");

			Role role1 =new Role();
			role1.setRoleId(AppConstants.NORMAL_USER);
			role1.setName("NORMAL_USER");

			List<Role> roles = Arrays.asList(role,role1);


			List<Role> result = this.roleRepo.saveAll(roles);
			result.forEach(r->{
				System.out.println(r.getName());
			});
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
