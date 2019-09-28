package com.des.site.repository;

import com.des.site.domain.ContactUsInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactUsInfoRepository extends JpaRepository<ContactUsInfo, Integer> {


}
