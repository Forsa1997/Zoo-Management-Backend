package de.volkswagen.enclosure;

import de.volkswagen.animal.Animal;
import de.volkswagen.animal.AnimalType;
import de.volkswagen.models.Cost;
import de.volkswagen.staff.Staff;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class Enclosure {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Builder.Default
    private String name = "";

    @Builder.Default
    private String description = "";

    @ElementCollection(targetClass = AnimalType.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable
    @Builder.Default
    private List<AnimalType> animalTypes = new ArrayList<>();

    @ElementCollection(targetClass = Animal.class)
    @CollectionTable
    @Builder.Default
    private List<Animal> animals = new ArrayList<>();

    @ElementCollection(targetClass = Staff.class)
    @CollectionTable
    @Builder.Default
    private List<Staff> staff = new ArrayList<>();

    @Embedded
    @Builder.Default
    private Cost cost = new Cost();

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
