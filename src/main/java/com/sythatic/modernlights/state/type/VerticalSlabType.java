package com.sythatic.modernlights.state.type;

import net.minecraft.util.StringIdentifiable;

public enum VerticalSlabType implements StringIdentifiable {
    SINGLE("single"),
    DOUBLE("double");

    private final String name;

    private VerticalSlabType(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    @Override
    public String asString() {
        return this.name;
    }
}
