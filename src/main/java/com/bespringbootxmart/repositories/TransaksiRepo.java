//TransaksiRepo.java
package com.bespringbootxmart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bespringbootxmart.model.TransaksiModel;

@Repository
public interface TransaksiRepo extends JpaRepository<TransaksiModel, String> {

}
