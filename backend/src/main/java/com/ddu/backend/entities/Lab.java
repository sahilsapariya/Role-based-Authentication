/*
 * Author: Kevin Tamakuwala (21ITUBS120) 
 * Modified: 1st March 2024 2:12 PM
 * Purpose: Lab is used to store the lab data
 */

package com.ddu.backend.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "labs")
public class Lab {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "lab", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<User> faculties = new ArrayList<>();

    @JsonBackReference
    @OneToMany(mappedBy = "lab", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LabResource> resources = new ArrayList<>();

    // Setters for chaining purpose
    public Lab setId(Long id) {
        this.id = id;
        return this;
    }

    public Lab setName(String name) {
        this.name = name;
        return this;
    }

    public Lab setFaculties(List<User> faculties) {
        this.faculties = faculties;
        return this;
    }

    public Lab setResources(List<LabResource> resources) {
        this.resources = resources;
        return this;
    }
}