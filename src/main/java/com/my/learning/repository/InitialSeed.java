package com.my.learning.repository;

import com.my.learning.controller.CustomerController;
import com.my.learning.entity.Role;
import com.my.learning.entity.User;
import com.my.learning.service.IEntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class InitialSeed implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(InitialSeed.class);

    @Autowired
    IEntityService<User> userRepository;

    @Autowired
    IRoleRepo roleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void run(String... args) throws Exception {
        loadRoleData();
        loadUserData();
    }

    private void loadUserData() {
        try{
            if (userRepository.count() == 0) {
                userRepository.add(new User(1l, "Admin", "User", "iadmin", bCryptPasswordEncoder.encode("iadmin"), "iadmin@email.com", new ArrayList<Role>(){{ add(new Role(1l, null, null,null, null)); }}, 31, null, null));
            }
        }
        catch (Exception ex)
        {
            logger.error("load user data error", ex);
        }
    }

    private void loadRoleData() {
        try{
            if (roleRepository.count() == 0) {
                roleRepository.save(new Role(1l, "ADMIN", null, null, null));
                roleRepository.save(new Role(2l, "USER", null, null, null));
                roleRepository.save(new Role(3l, "VIEW", null, null, null));

            }
        }
        catch (Exception ex)
        {
            logger.error("load role data error", ex);
        }
    }
}
