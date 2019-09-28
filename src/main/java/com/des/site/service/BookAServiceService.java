package com.des.site.service;

import com.des.site.domain.BookAService;
import com.des.site.repository.BookAServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookAServiceService {


    private BookAServiceRepository bookAServiceRepository;

    @Autowired
    public BookAServiceService(BookAServiceRepository bookAServiceRepository){
        this.bookAServiceRepository = bookAServiceRepository;
    }

    public BookAService saveRecord(BookAService bookAService){
        return bookAServiceRepository.saveAndFlush(bookAService);
    }
}
