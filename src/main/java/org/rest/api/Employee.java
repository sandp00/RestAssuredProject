package org.rest.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {
    @JsonProperty("name")
    private String name;
    @JsonProperty("rank")
    private int rank;
    @JsonProperty("Score")
    private int score;

    // Constructor, getters, and setters
    public Employee() {}

    public Employee(String name, int rank, int score) {
        this.name = name;
        this.rank = rank;
        this.score = score;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", rank=" + rank +
                ", score=" + score +
                '}';
    }
}
