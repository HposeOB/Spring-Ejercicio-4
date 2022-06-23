package com.example.springEjercicio4.controllers;

import com.example.springEjercicio4.entities.Laptop;
import com.example.springEjercicio4.repositories.LaptopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;


@RestController
public class LaptopController {
    private final Logger log = LoggerFactory.getLogger(LaptopController.class);
    private LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {

        this.laptopRepository = laptopRepository;
    }

    @GetMapping("/api/laptops")
    public List<Laptop> findAll() {

        return laptopRepository.findAll();
    }


    @GetMapping("/api/laptop/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id) {

        Optional<Laptop> laptopOpt = laptopRepository.findById(id);

        if (laptopOpt.isPresent())
            return ResponseEntity.ok(laptopOpt.get());
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/laptops")
    public Laptop create(@RequestBody Laptop laptop){

        return laptopRepository.save(laptop);
    }

    @PutMapping("/api/books")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        if(laptop.getId() == null ){
            log.warn("Trying to update a non existent laptop");
            return ResponseEntity.badRequest().build();
        }
        if(!laptopRepository.existsById(laptop.getId())){
            log.warn("Trying to update a non existent laptop");
            return ResponseEntity.notFound().build();
        }


        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    @ApiIgnore
    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){

        if(!laptopRepository.existsById(id)){
            log.warn("Trying to delete a non existent laptop");
            return ResponseEntity.notFound().build();
        }

        laptopRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
    @ApiIgnore // ignorar este método para que no aparezca en la documentación de la api Swagger
    @DeleteMapping("/api/books")
    public ResponseEntity<Laptop> deleteAll(){
        log.info("REST Request for delete all books");
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

}