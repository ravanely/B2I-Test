package com.b2i.b2itestproject;

import com.b2i.b2itestproject.entity.Role;
import com.b2i.b2itestproject.entity.User;
import com.b2i.b2itestproject.repository.RoleRepository;
import com.b2i.b2itestproject.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.transaction.Transactional;
import java.util.Set;

@SpringBootApplication
public class B2ITestProjectApplication implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public B2ITestProjectApplication(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(B2ITestProjectApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {

        if (userRepository.findAll().size() == 0) {
            roleRepository.saveAll(Set.of(new Role("ROLE_ADMIN"), new Role("ROLE_USER")));
            roleRepository.findAll().forEach(role -> System.out.println(role.getName()));
            userRepository.save(new User("toto", "toto", "toto@toto.cm", passwordEncoder.encode("Toto1234"), Set.of(roleRepository.findByName("ROLE_ADMIN").get())));
        }
    }
}
