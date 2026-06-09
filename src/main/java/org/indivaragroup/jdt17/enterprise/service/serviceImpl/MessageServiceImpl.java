package org.indivaragroup.jdt17.enterprise.service.serviceImpl;


import lombok.RequiredArgsConstructor;
import org.indivaragroup.jdt17.enterprise.service.MessageService;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageSource messageSource;

    @Override
    public String getMessage(String key, Locale locale){
        return messageSource.getMessage(key, null, locale);
    }
}
