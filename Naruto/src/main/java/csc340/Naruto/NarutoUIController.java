package csc340.Naruto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller 
public class NarutoUIController {
    private final NarutoService service;

    public NarutoUIController(NarutoService service) {
        this.service = service; 
    }

// Gallery with search
@GetMapping({"/", "/characters"  })
public String gallery(@RequestParam(required = false) String name,
                      @RequestParam(required = false) Village village, Model model ){
                        
model.addAttribute("characters", service.search(name, village));
model.addAttribute("name", name == null ? "" : name);
model.addAttribute("selectedVillage", village == null ? "" : village);
return "index";
}

// --- Details ---
@GetMapping("/characters/{id}")
public String details(@PathVariable Long id, Model model) {
    try {
        NarutoCharacter character = service.findById(id);
        model.addAttribute("character", character);
        return "details"; //returns details.ftlh
    } catch (RuntimeException exception) {
        model.addAttribute("errorMessage", exception.getMessage() == null ? "Plant not found" : exception.getMessage());
        return "error"; // templates/error.ftlh
    }
} 

// --- Add Character ---
@GetMapping("/characters/new")
public String newForm(Model model){
    NarutoCharacter character = new NarutoCharacter();
    model.addAttribute("character", character);
    model.addAttribute("formTitle", "Add a New Character");
    model.addAttribute("formAction", "/characters");
    return "new-character-form"; 
}

@PostMapping("/characters")
public String createCharacter(@Valid @ModelAttribute NarutoCharacter character){
    NarutoCharacter createdCharacter = service.create(character);
    return "redirect:/characters/" + createdCharacter.getId(); 
}

// --- Edit ---
@GetMapping("/characters/{id}/edit")
public String editForm(@PathVariable Long id, Model model){
    NarutoCharacter character = service.findById(id);
    model.addAttribute("character", character);
    model.addAttribute("formTitle", "Edit Character");
    model.addAttribute("formAction", "/characters/" + id);
    
    return "new-character-form"; 
}

 @PostMapping("/characters/{id}")
  public String updatePlant(@PathVariable Long id, @Valid @ModelAttribute NarutoCharacter character) {
    NarutoCharacter updatedCharacter = service.update(id, character);
    return "redirect:/characters/" + updatedCharacter.getId();
  }

  // ---- Delete ---
  @PostMapping("/characters/{id}/delete")
  public String deleteCharacter(@PathVariable Long id) {
    service.delete(id);
    return "redirect:/";
  }

  @GetMapping("/about")
  public String about() {
    return "about";
  }

}
