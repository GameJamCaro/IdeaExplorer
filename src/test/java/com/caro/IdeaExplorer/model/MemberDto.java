package com.caro.IdeaExplorer.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MemberDto {
    private Long id;
    private String name;

    public MemberDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}