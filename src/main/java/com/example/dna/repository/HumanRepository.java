package com.example.dna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dna.entity.Human;

@Repository
public interface HumanRepository extends JpaRepository<Human, Long>{

}
