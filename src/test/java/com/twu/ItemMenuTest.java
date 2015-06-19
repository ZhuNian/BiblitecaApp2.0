package com.twu;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemMenuTest {

    @Test
    public void testShowAllTheItems() throws Exception {
        ItemMenu itemMenu = new ItemMenu();
        assertThat(itemMenu.getItemArrayList().size(),is(0));
        assertThat(itemMenu.showAllTheItems(),is(true));
    }

    @Test
    public void testCheckOut() throws Exception {
        Item item1 = new Item();
        User user1 = new User("jill","123","zh@gmail.com","1233");
        ItemMenu itemMenu = new ItemMenu();
        assertThat(itemMenu.getItemArrayList().size(),is(0));
        assertThat(itemMenu.checkOut(user1,item1),is(false));//check out fail

        itemMenu.addItem(item1);//item1 now exiting
        assertThat(itemMenu.getItemArrayList().size(), is(1));
        assertThat(itemMenu.getCheckedout_itemArrayList().size(),is(0));
        assertThat(user1.getItems().size(),is(0));

        assertThat(itemMenu.checkOut(user1,item1), is(true));//check out succeed
        assertThat(itemMenu.getItemArrayList().size(), is(0));
        assertThat(itemMenu.getCheckedout_itemArrayList().size(),is(1));
        assertThat(user1.getItems().size(),is(1));
    }
}