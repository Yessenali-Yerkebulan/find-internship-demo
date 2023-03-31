package com.example.findinternship.repository;

import com.example.findinternship.model.Internship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InternshipRepository extends JpaRepository<Internship, Long> {
}
