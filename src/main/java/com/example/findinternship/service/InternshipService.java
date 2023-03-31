package com.example.findinternship.service;

import com.example.findinternship.model.Internship;
import org.springframework.stereotype.Service;

import java.util.List;

public interface InternshipService {
    List<Internship> getAllInternships();

    void saveInternship(Internship internship);

    Internship getInternshipById(long id);

    void deleteInternshipById(long id);
}
