package com.tihic.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    private void testCreateUser() {
        User user = new User();
        user.setEmail("kemo@mail.ba");
        user.setPassword("Selma.111");
        user.setFirstName("Kemal");
        user.setLastName("Tihic");
        user.setPhoneNumber("061171177");
        user.setUsername("Moke");

        User savedUser = repo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());
        Assertions.assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
    }
    
   /* @Test
    public void findUserByEmail(){
        String email = "tihick@hotmail.com";
        
        User user = repo.findByEmail(email);
        Assertions.assertThat(user).isNotNull();
    }*/

}
