package com.rakoi.webapp.classeye.classeye;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClasseyeApplicationTests {

    @Autowired
    BCryptPasswordEncoder encoder;

    @Test
    public void testEncoder(){
        String password="admin";
        System.out.println(encoder.encode(password));
    }

    @Test
    public void contextLoads() {
    }

}
