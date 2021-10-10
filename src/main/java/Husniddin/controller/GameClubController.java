package Husniddin.controller;

import Husniddin.entity.GameClub;
import Husniddin.service.GameClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/game-club")
@CrossOrigin(origins = "*",maxAge = 3600)
public class GameClubController {
    @Autowired
    private GameClubService ps;
    @GetMapping(value = "/")
    public ResponseEntity<?> getAll() throws Exception{
        return new ResponseEntity(ps.getAll(), HttpStatus.OK);
    }
    @PostMapping(value = "/")
    public ResponseEntity save(@RequestBody GameClub tulovTuri) throws Exception{
        return  new ResponseEntity(ps.add(tulovTuri),HttpStatus.ACCEPTED);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) throws Exception{
        return new ResponseEntity( ps.getById(id),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePoliya(@RequestBody GameClub tulovTuri, @PathVariable long id) throws Exception {

        Optional<GameClub> GameClubOptional = ps.getById(id);

        if (!GameClubOptional.isPresent())
            return ResponseEntity.notFound().build();

        tulovTuri.setId(id);
        ps.update(tulovTuri);
        return ResponseEntity.noContent().build();
    }
}
