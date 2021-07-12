package com.max.library.repositories;

import com.max.library.entities.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectionRepository extends JpaRepository<Collection, Long> {
}
