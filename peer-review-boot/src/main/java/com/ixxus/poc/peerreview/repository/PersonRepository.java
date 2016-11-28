package com.ixxus.poc.peerreview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ixxus.poc.peerreview.domain.Person;

@RepositoryRestResource(collectionResourceRel = "person", path = "person")
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByUsername(String username);

}