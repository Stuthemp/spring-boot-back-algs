package com.example.final_proj.models;

import javax.persistence.*;

@Entity
@Table(	name = "likes",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "name")
        })
public class AlgsRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer likes;

    public AlgsRate(String name, int likes) {
        this.name = name;
        this.likes = likes;
    }
    public AlgsRate(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
