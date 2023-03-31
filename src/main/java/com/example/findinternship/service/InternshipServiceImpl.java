package com.example.findinternship.service;

import com.example.findinternship.model.Internship;
import com.example.findinternship.repository.InternshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class InternshipServiceImpl implements InternshipService{

    @Autowired
    private InternshipRepository internshipRepository;

    @Override
    public List<Internship> getAllInternships() {
        return internshipRepository.findAll();
    }

    @Override
    public void saveInternship(Internship internship) {
        this.internshipRepository.save(internship);
    }

    @Override
    public Internship getInternshipById(long id) {
        Optional<Internship> optional = internshipRepository.findById(id);
        Internship internship = null;
        if(optional.isPresent()){
            internship=optional.get();
        }else{
            throw new RuntimeException(" Internship not found!");
        }
        return internship;
    }

    @Override
    public void deleteInternshipById(long id) {
        this.internshipRepository.deleteById(id);
    }
}
