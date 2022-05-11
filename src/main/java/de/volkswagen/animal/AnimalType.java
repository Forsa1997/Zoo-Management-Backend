package de.volkswagen.animal;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum AnimalType {
    UNDEFINED,
    KANGAROO,
    MONKEY,
    TIGER,
    PANDA,
    ALLIGATOR,
    BEAR,
    LION,
    ZEBRA,
    ELEPHANT,
    GIRAFFE,
    GORILLA,
    CHEETAH,
    TURTLE,
    PARROT,
    IGUANA,
    SLOTH,
    SNAKE,
    FLAMINGO,
    WALRUS,
    HIPPO,
    PENGUIN,
    HYENA,
    CAMEL,
    KOALA;

    @JsonCreator
    public AnimalType encode(String name){
        return Stream.of(AnimalType.values()).filter(e -> e.name().equals(name)).findAny().orElse(null);
    }

    @JsonValue
    public String getValue(){
        return this.name();
    }

}