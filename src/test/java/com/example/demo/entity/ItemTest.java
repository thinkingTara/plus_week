package com.example.demo.entity;

import com.example.demo.repository.ItemRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
class ItemTest  {

    @Autowired
    private ItemRepository itemRepository;

    @DisplayName("itemEntity 테스트")
    @Test
    void savedItem(){
        User owner = new User("user","oo@oo.com", "oo","oo");
        User manager = new User("admin", "mm@mm.com","mm","mm");
        Item item = new Item("item_100", "descripion",owner,manager);

        Item savedItem = itemRepository.save(item);
        System.out.println("저장된 item 값의 이름은 : " + savedItem.getName());
    }

}