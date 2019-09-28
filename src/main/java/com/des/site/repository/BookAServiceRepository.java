package com.des.site.repository;

import com.des.site.domain.BookAService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookAServiceRepository extends JpaRepository<BookAService, Integer> {

}
