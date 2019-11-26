package com.example.demo.repository;


import com.example.demo.model.*;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProcesoRepository extends CrudRepository<Proceso, Long> {

	Optional<Proceso> findById(Long id);
	
}