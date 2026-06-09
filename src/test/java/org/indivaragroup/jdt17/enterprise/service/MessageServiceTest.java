package org.indivaragroup.jdt17.enterprise.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MessageServiceTest {

    @Autowired
    private MessageService messageService;

    @Test
    public void shouldReturnEnglishMessage(){
        String message = messageService.getMessage("welcome.message", Locale.ENGLISH);

        assertEquals("Welcome to Multi Usaha Hebat", message);
    }

    @Test
    public void shouldReturnIndonesianMessage(){
        String message = messageService.getMessage("welcome.message", new Locale("id"));

        assertEquals("Selamat datang di Multi Usaha Hebat", message);
    }

}
