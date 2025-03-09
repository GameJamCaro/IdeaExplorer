package com.caro.IdeaExplorer.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AuthorDto {
    private Integer id;
    private String name;

    public AuthorDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}