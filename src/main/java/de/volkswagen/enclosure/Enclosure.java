package de.volkswagen.enclosure;

import de.volkswagen.animal.Animal;
import de.volkswagen.animal.AnimalType;
import de.volkswagen.models.Cost;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Enclosure {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Getter
    @Column(name = "enclosure_id")
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    @ElementCollection(targetClass = AnimalType.class)
    @Enumerated(EnumType.STRING)
    @JoinTable(name = "enclosure_animaltypes",
    joinColumns = @JoinColumn(name = "enclosure_id"))
    private List<AnimalType> animalTypes;

    @Getter
    @Setter
    private List<Animal> animals;

 //   @Getter
 //   @Setter
//    private Cost cost;

 //   public Cost getCostWithAnimals() {
 //       if(this.cost == null){
 //           this.cost = new Cost();
  //      }
  //      if (this.animals == null){
 //           return this.cost;
  //      }
   //              .map(Animal::getCost)
 //               .reduce(this.cost, Cost::add);
  //  }

}
