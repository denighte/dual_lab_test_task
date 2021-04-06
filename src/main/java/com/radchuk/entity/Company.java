package com.radchuk.entity;

/**
 * Bus companies list
 */
public enum Company {
    POSH("Posh"), GROTTY("Grotty");

    private String name;

    Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
