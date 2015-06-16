package com.twu;

import static org.hamcrest.core.Is.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest{

    @Test
    public void testNewUser() throws Exception {
        User user = new User();
        assertThat(user.getUserArrayList().size(),is(1));

    }

    @Test
    public void should_log_in_user() throws Exception {
        User user = new User();
        assertThat(user.login("jane","111"),is(true));

        //wrong name
        assertThat(user.login("jack","111"),is(false));
        //wrong password
        assertThat(user.login("jane","123"),is(false));
    }

    @Test
    public void should_register_user() throws Exception {
        User user = new User();
        assertThat(user.getUserArrayList().size(),is(1));

        user.addUser(new User("jane","111","12","31"));//same user
        assertThat(user.getUserArrayList().size(), is(1));

        user.addUser(new User("jack", "123", "12", "31"));//diff user
        assertThat(user.getUserArrayList().size(), is(2));

    }
}