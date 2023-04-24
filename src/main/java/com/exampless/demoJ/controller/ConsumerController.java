package com.exampless.demoJ.controller;

import com.exampless.demoJ.exception.ConsumerNotFoundException;
import com.exampless.demoJ.model.Consumer;
import com.exampless.demoJ.repository.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@RestController
public class ConsumerController {
    @Autowired
    private ConsumerRepository consumerRepository;

    @PostMapping("/consumers")
    Consumer newConsumer(@RequestBody Consumer newConsumer){
        return  consumerRepository.save(newConsumer);
    }

    @GetMapping("/consumers")
    List<Consumer>  getAllConsumers(){
        return consumerRepository.findAll();
    }
    @GetMapping("/consumers/{id}")
    Consumer getUserById(@PathVariable Long id) {
        return consumerRepository.findById(id)
                .orElseThrow(() -> new ConsumerNotFoundException(id));
    }
    @PutMapping("/consumers/{id}")
    Consumer updateConsumer(@RequestBody Consumer newConsumer,@PathVariable Long id){
        return consumerRepository.findById(id)
                .map(consumer -> {
                    consumer.setFnam(newConsumer.getFnam());
                    consumer.setLnam(newConsumer.getLnam());
                    consumer.setEmail(newConsumer.getEmail());
                    return  consumerRepository.save(consumer);
                }).orElseThrow(() -> new ConsumerNotFoundException(id));
    }

    @DeleteMapping("/consumers/{id}")
    String deleteUser(@PathVariable Long id){
        if(!consumerRepository.existsById(id)){
            throw new ConsumerNotFoundException(id);
        }
        consumerRepository.deleteById(id);
        return  "User with id "+id+" has been deleted ";
    }
}
