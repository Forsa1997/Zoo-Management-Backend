package de.volkswagen.enclosure;

import de.volkswagen.animal.Animal;
import de.volkswagen.animal.AnimalType;
import de.volkswagen.models.Cost;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Enclosure {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id = -1L;

    private String name = "";

    private String description = "";

    @ElementCollection(targetClass = AnimalType.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable
    private List<AnimalType> animalTypes = new ArrayList<>();

    @ElementCollection(targetClass = Animal.class)
    @CollectionTable
    private List<Animal> animals = new ArrayList<>();

    @OneToOne
    private Cost cost;

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
