package Husniddin.controller;

import Husniddin.entity.TulovQilish;
import Husniddin.service.TulovQilishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("api/tulov-qilish")
@CrossOrigin(origins = "*",maxAge = 3600)
public class TulovQilishController{
    @Autowired
    private TulovQilishService ps;
    @GetMapping(value = "/")
    public ResponseEntity<?> getAll() throws Exception{
        return new ResponseEntity(ps.getAll(), HttpStatus.OK);
    }
    @PostMapping(value = "/")
    public ResponseEntity save(@RequestBody TulovQilish tulovQilish) throws Exception{
        tulovQilish.setTulovVaqti(LocalDateTime.now());
        return  new ResponseEntity(ps.add(tulovQilish),HttpStatus.ACCEPTED);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) throws Exception{
        return new ResponseEntity( ps.getById(id),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePoliya(@RequestBody TulovQilish tulovQilish, @PathVariable long id) throws Exception {

        Optional<TulovQilish> TulovQilishOptional = ps.getById(id);

        if (!TulovQilishOptional.isPresent())
            return ResponseEntity.notFound().build();

        tulovQilish.setId(id);
        ps.update(tulovQilish);
        return ResponseEntity.noContent().build();
    }
    @GetMapping(value = "/buyurtma/{id}")
    public ResponseEntity<?> getByBuyurtmaId(@PathVariable Long id) throws Exception{
        return new ResponseEntity( ps.getAllByBuyurtmaId(id),HttpStatus.OK);
    }
}
