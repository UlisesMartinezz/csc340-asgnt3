package csc340.Naruto;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;





@Service 
public class NarutoService {
    private final NarutoRepository repository;

     private static final String UPLOAD_DIR = "src/main/resources/static/thumbnails/";

    public NarutoService(NarutoRepository repository){
        this.repository = repository;
    }

    public List<NarutoCharacter> findAll(){
        return repository.findAll();
    }
    
    public List<NarutoCharacter> findByVillage(Village village){
        return repository.findByVillage(village); 
    }

    public List<NarutoCharacter> search(String name, Village village){
        boolean hasName = name != null && !name.isBlank();

        if (hasName && village != null) {
            return repository.findByNameContainingIgnoreCaseAndVillage(name.trim(), village);
        }
        if (hasName) {
            return repository.findByNameContainingIgnoreCase(name.trim());
        }
        if (village != null) {
            return repository.findByVillage(village);
        }
        return repository.findAll();

    }

    public NarutoCharacter findById(Long id){
        return repository.findById(id).orElseThrow(() -> new CharacterNotFoundException(id));
    }

    public NarutoCharacter create(NarutoCharacter character){
        return repository.save(character); 
    }

    public NarutoCharacter update(Long id, NarutoCharacter updated){
        NarutoCharacter existing = findById(id);
        existing.setName(updated.getName());
        existing.setDescription(updated.getDescription());
        existing.setVillage(updated.getVillage());
        existing.setRank(updated.getRank());
        return repository.save(existing);
    }

    public void delete(Long id){
        findById(id);
        repository.deleteById(id);
    }

      public void saveThumbnail(NarutoCharacter character, MultipartFile file) {
      
        String originalFileName = file.getOriginalFilename();
        try {
            String fileExtension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
            String newFileName = "plant_" + character.getId() + "." + fileExtension;
            Path path = Paths.get(UPLOAD_DIR + newFileName);
            InputStream inputStream = file.getInputStream();
            Files.createDirectories(Paths.get(UPLOAD_DIR)); // Ensure the directory exists
            Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);
            character.setThumbnailUrl( newFileName);
            repository.save(character);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
