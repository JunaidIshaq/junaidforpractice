package com.des.site.service;

import com.des.site.domain.ContactUsInfo;
import com.des.site.repository.ContactUsInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactUsInfoService {


    private ContactUsInfoRepository contactUsInfoRepository;

    @Autowired
    public ContactUsInfoService(ContactUsInfoRepository contactUsInfoRepository){
        this.contactUsInfoRepository = contactUsInfoRepository;
    }

    public ContactUsInfo saveRecord(ContactUsInfo contactUsInfo){
        return contactUsInfoRepository.saveAndFlush(contactUsInfo);
    }
}
