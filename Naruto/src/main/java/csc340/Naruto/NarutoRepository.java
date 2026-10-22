package csc340.Naruto;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NarutoRepository extends JpaRepository<NarutoCharacter, Long> {
    List<NarutoCharacter> findByNameContainingIgnoreCase(String name);

    List<NarutoCharacter> findByVillage(Village village);

    List<NarutoCharacter> findByNameContainingIgnoreCaseAndVillage(String name, Village village);
    
}
