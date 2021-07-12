package com.max.library.repositories;

import com.max.library.entities.Book;
import com.max.library.entities.PublishingCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublishingCompanyRepository extends JpaRepository<PublishingCompany, Long> {
}
