package com.des.site.controller;

import com.des.site.domain.ContactUsInfo;
import com.des.site.repository.ContactUsInfoRepository;
import com.des.site.service.ContactUsInfoService;
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
public class ContactUsInfoController {


    @Autowired
    private ContactUsInfoRepository contactUsInfoRepository;

    @Autowired
    private ContactUsInfoService contactUsInfoService;


    public ContactUsInfoController (ContactUsInfoService contactUsInfoService){
        this.contactUsInfoService = contactUsInfoService;
    }


    @RequestMapping(value = "/contactUs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ContactUsInfo> getAllContactUsInfo(){
        return contactUsInfoRepository.findAll();
    }


    @RequestMapping(value = "/contactUs", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContactUsInfo> insertContactUsInfo(@RequestBody ContactUsInfo contactUsInfo) throws URISyntaxException {
        try{
           ContactUsInfo result =  contactUsInfoService.saveRecord(contactUsInfo);
           return (ResponseEntity<ContactUsInfo>) ResponseEntity.created(new URI("/api/contactUs" + result.getId())).body(result);
        }catch (Exception ex){
            return new ResponseEntity<ContactUsInfo>(HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/contactUs", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContactUsInfo> updateContactUsInfo(@RequestBody ContactUsInfo contactUsInfo) throws URISyntaxException {
        if(contactUsInfo.getId() == null){
            return new ResponseEntity<ContactUsInfo>(HttpStatus.NOT_FOUND);
        }
        try{
            ContactUsInfo result =  contactUsInfoService.saveRecord(contactUsInfo);
            return (ResponseEntity<ContactUsInfo>) ResponseEntity.created(new URI("/api/contactUs" + result.getId())).body(result);
        }catch (Exception ex){
            return new ResponseEntity<ContactUsInfo>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/contactUs/{id", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteContactUsInfo(@PathVariable Integer id){
        contactUsInfoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
