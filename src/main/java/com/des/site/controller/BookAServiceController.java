package com.des.site.controller;

import com.des.site.domain.BookAService;
import com.des.site.repository.BookAServiceRepository;
import com.des.site.service.BookAServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookAServiceController {


    @Autowired
    private BookAServiceRepository bookAServiceRepository;

    @Autowired
    private BookAServiceService bookAServiceService;


    public BookAServiceController (BookAServiceService bookAServiceService){
        this.bookAServiceService = bookAServiceService;
    }


    @RequestMapping(value = "/bookAService", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookAService> getAllContactUsInfo(){
        return bookAServiceRepository.findAll();
    }


    @RequestMapping(value = "/bookAService", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookAService> insertContactUsInfo(@RequestBody BookAService bookAService) throws URISyntaxException {
        try{
            BookAService result =  bookAServiceService.saveRecord(bookAService);
            return (ResponseEntity<BookAService>) ResponseEntity.created(new URI("/api/bookAService" + result.getId())).body(result);
        }catch (Exception ex){
            return new ResponseEntity<BookAService>(HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/bookAService", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookAService> updateContactUsInfo(@RequestBody BookAService bookAService) throws URISyntaxException {
        if(bookAService.getId() == null){
            return new ResponseEntity<BookAService>(HttpStatus.NOT_FOUND);
        }
        try{
            BookAService result =  bookAServiceService.saveRecord(bookAService);
            return (ResponseEntity<BookAService>) ResponseEntity.created(new URI("/api/bookAService" + result.getId())).body(result);
        }catch (Exception ex){
            return new ResponseEntity<BookAService>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/bookAService/{id", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteContactUsInfo(@PathVariable Integer id){
        bookAServiceRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
