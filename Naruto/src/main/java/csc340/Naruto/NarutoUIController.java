package csc340.Naruto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
public class NarutoUIController {
    private final NarutoService service;

    public NarutoUIController(NarutoService service) {
        this.service = service; 
    }

// Gallery with search
@GetMapping({"/", "/plants"  })
public String gallery(@RequestParam(required = false) String name,
                      @RequestParam(required = false) Village village, Model model ){
                        
model.addAttribute("characters", service.search(name, village));
model.addAttribute("name", name == null ? "" : name);
model.addAttribute("selectedVillage", village == null ? "" : village);
return "index";
}









}
