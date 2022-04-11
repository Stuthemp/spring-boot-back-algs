package com.example.final_proj.payload.request;

import javax.validation.constraints.NotBlank;

public class LikesRequest {

    @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
