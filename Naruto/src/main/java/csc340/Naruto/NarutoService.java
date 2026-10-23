package csc340.Naruto;

import java.util.List;

import org.springframework.stereotype.Service;


@Service 
public class NarutoService {
    private final NarutoRepository repository;

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

}
