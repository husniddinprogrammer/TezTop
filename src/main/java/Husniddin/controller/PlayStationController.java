package Husniddin.controller;

import Husniddin.entity.PlayStation;
import Husniddin.service.PlayStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/play-station")
@CrossOrigin(origins = "*",maxAge = 3600)
public class PlayStationController {
    @Autowired
    private PlayStationService ps;
    @GetMapping(value = "/")
    public ResponseEntity<?> getAll() throws Exception{
        return new ResponseEntity(ps.getAll(), HttpStatus.OK);
    }
    @PostMapping(value = "/")
    public ResponseEntity save(@RequestBody PlayStation tulovTuri) throws Exception{
        return  new ResponseEntity(ps.add(tulovTuri),HttpStatus.ACCEPTED);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) throws Exception{
        return new ResponseEntity( ps.getById(id),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePoliya(@RequestBody PlayStation tulovTuri, @PathVariable long id) throws Exception {

        Optional<PlayStation> PlayStationOptional = ps.getById(id);

        if (!PlayStationOptional.isPresent())
            return ResponseEntity.notFound().build();

        tulovTuri.setId(id);
        ps.update(tulovTuri);
        return ResponseEntity.noContent().build();
    }
}