package com.exampless.demoJ.repository;

import com.exampless.demoJ.model.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumerRepository extends JpaRepository<Consumer,Long> {
}