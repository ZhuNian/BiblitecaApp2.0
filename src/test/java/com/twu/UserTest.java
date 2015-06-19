package com.twu;

import static org.hamcrest.core.Is.is;

import jdk.nashorn.internal.ir.annotations.Ignore;
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

        user.addUser(new User("jane","111","123","321"));//same user
        assertThat(user.getUserArrayList().size(), is(1));

        user.addUser(new User("jane","111","13","31"));//same name and password
        assertThat(user.getUserArrayList().size(), is(1));

        user.addUser(new User("jack", "123", "12", "31"));//diff user
        assertThat(user.getUserArrayList().size(), is(2));

    }

    @Test
    public void should_check_out_a_movie() throws Exception {
        Movie m = new Movie("jack", "2998", "sjk", "2.0");
        User user = new User("jill", "123", "zh@gmail.com", "1233");
        MovieMenu movieMenu = new MovieMenu();

        assertThat(movieMenu.getItemArrayList().size(), is(2));
        assertThat(user.getItems().size(), is(0));
        Boolean b = user.checkout();
        assertThat(b, is(false));//m not existing

        movieMenu.addItem(m);//m now exiting
        assertThat(user.checkout(), is(true));
        assertThat(user.getItems().size(), is(1));
    }
}