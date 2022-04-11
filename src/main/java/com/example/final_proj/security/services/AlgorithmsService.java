package com.example.final_proj.security.services;

import com.example.final_proj.exceptions.AlgorithmNotFoundException;
import com.example.final_proj.models.AlgsRate;
import com.example.final_proj.repository.AlgorithmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlgorithmsService {

    @Autowired
    AlgorithmsRepository repository;

    @Transactional
    public int getNumberOfLikes(String name) throws AlgorithmNotFoundException{
        AlgsRate alg = repository.findByName(name).
                orElseThrow(() -> new AlgorithmNotFoundException("Algorithm Not Found with name: " + name));
        return alg.getLikes();
    }

    @Transactional
    public AlgsRate getAlgorithmByName(String name) throws AlgorithmNotFoundException {
        return repository.findByName(name).
                orElseThrow(() -> new AlgorithmNotFoundException("Algorithm Not Found with name: " + name));
    }

    @Transactional
    public void setLikesQuantity(String name, Integer likes) {
        repository.updateAlgsRateInfoByName(name, likes);
    }

}
