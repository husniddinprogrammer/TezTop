package Husniddin.controller;

import Husniddin.entity.SportZal;
import Husniddin.service.SportZalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/sport-zal")
@CrossOrigin(origins = "*",maxAge = 3600)
public class SportZalController {
    @Autowired
    private SportZalService ps;
    @GetMapping(value = "/")
    public ResponseEntity<?> getAll() throws Exception{
        return new ResponseEntity(ps.getAll(), HttpStatus.OK);
    }
    @PostMapping(value = "/")
    public ResponseEntity save(@RequestBody SportZal tulovTuri) throws Exception{
        return  new ResponseEntity(ps.add(tulovTuri),HttpStatus.ACCEPTED);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) throws Exception{
        return new ResponseEntity( ps.getById(id),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePoliya(@RequestBody SportZal tulovTuri, @PathVariable long id) throws Exception {

        Optional<SportZal> SportZalOptional = ps.getById(id);

        if (!SportZalOptional.isPresent())
            return ResponseEntity.notFound().build();

        tulovTuri.setId(id);
        ps.update(tulovTuri);
        return ResponseEntity.noContent().build();
    }
}
