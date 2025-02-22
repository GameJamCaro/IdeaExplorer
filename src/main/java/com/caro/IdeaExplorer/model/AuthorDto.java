package com.caro.IdeaExplorer.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AuthorDto {
    private Long id;
    private String name;

    public AuthorDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}