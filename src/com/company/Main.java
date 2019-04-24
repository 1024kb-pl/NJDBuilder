package com.company;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        Camel camel = Camel.builder()
                .id(1L)
                .name("Wielblad")
                .age(12)
                .gender(Gender.FEMALE)
                .furColor("KOLOREK")
                .build();

        Article article = Article.builder()
                .id(1L)
                .title("Tytuł")
                .text("TRESC")
                .publishedDate(LocalDateTime.now())
                .tag("TAG_1")
                .tag("TAG_2")
                .and()
                .author("AUTOR")
                .build();

        System.out.println(camel);
        System.out.println(article);

    }
}
