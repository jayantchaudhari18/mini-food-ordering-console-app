package com.aurionpro.model;

public enum CuisineType {
    INDIAN("Indian"),
    ITALIAN("Italian"),
    CHINESE("Chinese"),
    MEXICAN("Mexican");

    private final String displayName;

    CuisineType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static CuisineType fromIndex(int index) {
        return values()[index];
    }

    public static void showAllCuisines() {
        for (int i = 0; i < values().length; i++) {
            System.out.println((i + 1) + ". " + values()[i].getDisplayName());
        }
    }
}

