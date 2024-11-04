package com.sythatic.modernlights.block;

import com.sythatic.modernlights.state.shape.CeilingLightBlock;
import com.sythatic.modernlights.state.shape.MiniLightBlock;
import com.sythatic.modernlights.ModernLights;
import com.sythatic.modernlights.data.CommonBlock;
import com.sythatic.modernlights.data.BlockBehavior;
import net.minecraft.block.Block;

import java.util.HashMap;
import java.util.Map;

public class LuminousLights {

    // Map to store mini_lights and ceiling_lights of different colors
    public static final Map<ModernLights.LuminousColors, Block> CEILING_LIGHTS = new HashMap<>();
    public static final Map<ModernLights.LuminousColors, Block> MINI_LIGHTS = new HashMap<>();

    static {
        // Initialize blocks for each color
        for (ModernLights.LuminousColors color : ModernLights.LuminousColors.values()) {
            // Create ceiling_light and add to map
            String blockName = color.name().equalsIgnoreCase("white") ? "ceiling_light" : "ceiling_light_" + color.name().toLowerCase();

            CEILING_LIGHTS.put(color, createBlock(blockName, false));
        }

        for (ModernLights.LuminousColors color : ModernLights.LuminousColors.values()) {
            // Create mini_light and add to map

            String blockName = color.name().equalsIgnoreCase("white") ? "mini_light" : "mini_light_" + color.name().toLowerCase();

            MINI_LIGHTS.put(color, createBlock(blockName, true));
        }
    }

    // Method to create panels
    private static Block createBlock(String name, boolean isMiniLight) {
        return BlockBehavior.registerBlocks(name, isMiniLight ? new MiniLightBlock(CommonBlock.DEFAULT_MINI_LIGHT_SETTINGS) : new CeilingLightBlock(CommonBlock.DEFAULT_CEILING_LIGHT_SETTINGS));
    }

    // Access Ceiling Lights and Mini Lights by color [just in case]
    public static Block getCeilingLightBLock(ModernLights.LuminousColors color) {
        return CEILING_LIGHTS.get(color);
    }

    public static Block getMiniLightBLock(ModernLights.LuminousColors color) {
        return MINI_LIGHTS.get(color);
    }

    public static void registerBlocks() {
        com.sythatic.modernlights.ModernLights.LOGGER.info(com.sythatic.modernlights.ModernLights.MOD_ID + " - Registered block:luminous_lights");
    }
}
