package de.volkswagen.enclosure;

import de.volkswagen.animal.Animal;
import de.volkswagen.animal.AnimalType;
import de.volkswagen.models.Cost;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
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
    @CollectionTable
    private List<AnimalType> animalTypes;

    @Getter
    @Setter
    @ElementCollection(targetClass = Animal.class)
    @CollectionTable
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
