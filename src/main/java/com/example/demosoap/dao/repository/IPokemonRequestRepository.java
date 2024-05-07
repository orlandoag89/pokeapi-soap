package com.example.demosoap.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demosoap.dao.entites.RequestEntity;

@Repository
public interface IPokemonRequestRepository extends JpaRepository<RequestEntity, Integer> {

}
