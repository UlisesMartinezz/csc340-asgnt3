//Entity Class
package csc340.Naruto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity 
@Table(name = "characters")
public class NarutoCharacter {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank 
    private String name;

    @NotBlank 
    private String description;

    @NotNull 
    @Enumerated(EnumType.STRING)
    private Village village; 

    private String rank; 

    public NarutoCharacter(){
        
    }

    //id
    public Long getId() {
        return id;
    }

    //name 
    public String getName() {
        return name; 
    }

    public void setName(String name) {
        this.name = name;
    }

    //description
    public String description(){
        return description;
    }

    public void setDescription(String description){
        this.description = description; 
    }

    //village
    public Village getVillage(){
        return village; 
    }

    public void setVillage(Village village){
        this.village = village; 
    }

    //rank 
    public String getRank(){
        return rank;
    }

    public void setRank(String rank){
        this.rank = rank; 
    }
}
