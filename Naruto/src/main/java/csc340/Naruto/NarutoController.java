package csc340.Naruto;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController 
@RequestMapping("/api/characters")
public class NarutoController {
    private final NarutoService service; 

    public NarutoController(NarutoService service){
        this.service = service;
    }

    @GetMapping 
    public List<NarutoCharacter> list(@RequestParam(required = false) String name,
                                      @RequestParam(required = false) Village village){
        return service.search(name, village); 
    }
    
    @GetMapping("/{id}")
    public NarutoCharacter get(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NarutoCharacter create(@Valid @RequestBody NarutoCharacter character){
        return service.create(character);
    }
  
    @PutMapping("/{id}")
    public NarutoCharacter update(@PathVariable Long id, @Valid @RequestBody NarutoCharacter character) {
        return service.update(id, character);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/pulse")
    public ResponseEntity<String> checkPulse() {
        return ResponseEntity.ok("Pulse check successful");
    }
}
