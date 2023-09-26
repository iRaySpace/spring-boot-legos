package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.DemoAlreadyExistsException;
import com.example.demo.exception.DemoNotFoundException;
import com.example.demo.exception.DemoUnableToDeleteException;
import com.example.demo.exception.DemoUnableToUpdateException;

@Service
public class DemoService {
    @Autowired
    private DemoRepository demoRepository;

    public Demo findById(String id) throws DemoNotFoundException {
        return demoRepository.findById(id).orElseThrow(() -> new DemoNotFoundException(id));
    }

    public Demo create(Demo demo) throws DemoAlreadyExistsException {
        demoRepository.findByTitle(demo.getTitle())
                .ifPresent((existingDemo) -> {
                    throw new DemoAlreadyExistsException(existingDemo.getTitle());
                });
        return demoRepository.save(demo);
    }

    public Demo update(Demo demo) throws RuntimeException {
        Demo existingDemo = findById(demo.getId()); // for validating not found
        if (existingDemo.getId() == "1") {
            throw new DemoUnableToUpdateException(existingDemo.getId());
        }
        return demoRepository.save(demo);
    }

    public void deleteById(String id) throws RuntimeException {
        Demo existingDemo = findById(id);
        if (existingDemo.getId() == "1") {
            throw new DemoUnableToDeleteException(existingDemo.getId());
        }
        demoRepository.deleteById(id);
    }
}
