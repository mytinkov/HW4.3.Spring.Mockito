package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {
    UserRepository out = new UserRepository();
    User user1 = new User("Vasy", "123445gf");
    User user2 = new User("Vasy2", "21312312l");
    User user3 = new User("Vasy3", "2421421r");
    User user4 = new User("Vasy4", "2352534f");


    @BeforeEach
    void setUp() {
        out.add(user1);
        out.add(user2);
    }

    @Test
    void getEmptyListOfUsers() {
        UserRepository out = new UserRepository();
        assertTrue(out.getAll().isEmpty());
    }

    @Test
    void getFilledListOfUsers() {
        assertTrue(out.getAll().contains(user1));
        assertTrue(out.getAll().contains(user2));
    }

    @Test
    void findByLoginIfUserExist() {
        assertTrue(out.findByLogin(user1.getLogin()).isPresent());
        assertTrue(out.findByLogin(user2.getLogin()).isPresent());
    }

    @Test
    void findByLoginIfUserNotExist(){
        assertFalse(out.findByLogin(user3.getLogin()).isPresent());
        assertFalse(out.findByLogin(user4.getLogin()).isPresent());
    }

    @Test
    void findByLoginAndPasswordIfUserExist(){
        assertTrue(out.findByLoginAndPassword(user1.getLogin(), user1.getPassword()).isPresent());
        assertTrue(out.findByLoginAndPassword(user2.getLogin(), user2.getPassword()).isPresent());
    }

    @Test
    void findByLoginAndPasswordIfUserNotExist() {
        assertFalse(out.findByLoginAndPassword(user3.getLogin(), user3.getPassword()).isPresent());
        assertFalse(out.findByLoginAndPassword(user4.getLogin(), user4.getPassword()).isPresent());
    }

    @Test
    void findByLoginAndPasswordIfPasswordNotMatch(){
        assertFalse(out.findByLoginAndPassword(user1.getLogin(), user3.getPassword()).isPresent());
        assertFalse(out.findByLoginAndPassword(user2.getLogin(), user4.getPassword()).isPresent());
    }
}
