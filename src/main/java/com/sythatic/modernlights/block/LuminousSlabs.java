package com.sythatic.modernlights.block;

import com.sythatic.modernlights.state.shape.LuminousSlabBlock;
import com.sythatic.modernlights.ModernLights;
import com.sythatic.modernlights.data.CommonBlock;
import com.sythatic.modernlights.data.BlockBehavior;
import net.minecraft.block.Block;

import java.util.HashMap;
import java.util.Map;

public class LuminousSlabs {

    // Map to store luminous slabs of different colors
    public static final Map<ModernLights.LuminousColors, Block> LUMINOUS_SLABS = new HashMap<>();
    public static final Map<ModernLights.LuminousColors, Block> LUMINOUS_SLABS_FULL = new HashMap<>();

    static {
        // Initialize luminous slabs for each color
        for (ModernLights.LuminousColors color : ModernLights.LuminousColors.values()) {
            // Create basic luminous slab and add to map
            String blockName = color.name().equalsIgnoreCase("white") ? "luminous_slab" : "luminous_slab_" + color.name().toLowerCase();

            LUMINOUS_SLABS.put(color, createLuminousSlab(blockName, false, color));
        }

        for (ModernLights.LuminousColors color : ModernLights.LuminousColors.values()) {
            // Create full luminous slab and add to map

            String blockName = color.name().equalsIgnoreCase("white") ? "luminous_slab_full" : "luminous_slab_" + color.name().toLowerCase() + "_full";

            LUMINOUS_SLABS_FULL.put(color, createLuminousSlab(blockName, true, color));
        }
    }

    // Method to create luminous slab block
    private static Block createLuminousSlab(String name, boolean isFull, ModernLights.LuminousColors color) {
        return BlockBehavior.registerBlocks(name, isFull ? ModernLights.fullInfo : null, new LuminousSlabBlock(CommonBlock.defaultLuminousSlabSettings(color)));
    }

    // Access Mini Luminous Blocks [just in case]
    public static Block getLuminousSlab(ModernLights.LuminousColors color) {
        return LUMINOUS_SLABS.get(color);
    }

    public static Block getLuminousSlabFull(ModernLights.LuminousColors color) {
        return LUMINOUS_SLABS_FULL.get(color);
    }

    public static void registerBlocks() {
        com.sythatic.modernlights.ModernLights.LOGGER.info(com.sythatic.modernlights.ModernLights.MOD_ID + " - Registered block:luminous_slab");
    }
}

