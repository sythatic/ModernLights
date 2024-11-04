package com.sythatic.modernlights.block;

import com.sythatic.modernlights.state.shape.LuminousVerticalSlabBlock;
import com.sythatic.modernlights.ModernLights;
import com.sythatic.modernlights.ModernLights.LuminousColors;
import com.sythatic.modernlights.data.BlockBehavior;
import net.minecraft.block.Block;

import java.util.HashMap;
import java.util.Map;

import static com.sythatic.modernlights.data.CommonBlock.defaultLuminousVerticalSlabSettings;

public class LuminousVerticalSlabs {


    // Map to store vertical slabs of different colors
    public static final Map<LuminousColors, Block> LUMINOUS_VERTICAL_SLABS = new HashMap<>();
    public static final Map<LuminousColors, Block> LUMINOUS_VERTICAL_SLABS_FULL = new HashMap<>();

    static {
        // Initialize luminous slabs for each color
        for (LuminousColors color : LuminousColors.values()) {
            // Create basic luminous slab and add to map
            String blockName = color.name().equalsIgnoreCase("white") ? "luminous_vertical_slab" : "luminous_vertical_slab_" + color.name().toLowerCase();

            LUMINOUS_VERTICAL_SLABS.put(color, createLuminousSlab(blockName, false, color));
        }

        for (LuminousColors color : LuminousColors.values()) {
            // Create full luminous slab and add to map

            String blockName = color.name().equalsIgnoreCase("white") ? "luminous_vertical_slab_full" : "luminous_vertical_slab_" + color.name().toLowerCase() + "_full";

            LUMINOUS_VERTICAL_SLABS_FULL.put(color, createLuminousSlab(blockName, true, color));
        }
    }

    // Method to create luminous slab block
    private static Block createLuminousSlab(String name, boolean isFull, LuminousColors color) {
        return BlockBehavior.registerBlocks(name, isFull ? ModernLights.fullInfo : null, new LuminousVerticalSlabBlock(defaultLuminousVerticalSlabSettings(color)));
    }

    // Access Mini Luminous Blocks [just in case]
    public static Block getLuminousVerticalSlab(LuminousColors color) {
        return LUMINOUS_VERTICAL_SLABS.get(color);
    }

    public static Block getLuminousVerticalSlabFull(LuminousColors color) {
        return LUMINOUS_VERTICAL_SLABS_FULL.get(color);
    }

    public static void registerBlocks() {
        com.sythatic.modernlights.ModernLights.LOGGER.info(com.sythatic.modernlights.ModernLights.MOD_ID + " - Registered block:luminous_vertical_slab");
    }


}

