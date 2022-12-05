package com.javainfinite.security.feignclient;

import com.javainfinite.security.model.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@FeignClient(name = "person", url = "http://localhost:8085/v2/person", configuration = FeignConfig.class)
public interface PersonClient {

    @GetMapping
    List<Person> listAll();

    @GetMapping("/id/{id}")
    Person listById(@PathVariable Long id);
}
