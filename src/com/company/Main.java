package com.company;

public class Main {

    public static void main(String[] args) {
        Camel camel = Camel.builder()
                .id(1L)
                .name("Wielblad")
                .age(12)
                .gender(Gender.FEMALE)
                .furColor("KOLOREK")
                .height(10)
                .weight(5)
                .build();


    }
}
