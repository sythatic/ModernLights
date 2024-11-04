package com.sythatic.modernlights.block;

import com.sythatic.modernlights.state.shape.MiniBlock;
import com.sythatic.modernlights.ModernLights;
import com.sythatic.modernlights.data.BlockBehavior;
import net.minecraft.block.Block;

import java.util.HashMap;
import java.util.Map;

import static com.sythatic.modernlights.data.CommonBlock.DEFAULT_MINI_BLOCK_SETTINGS;

public class LuminousMiniBlocks {
    // Map to store mini_blocks of different colors
    public static final Map<ModernLights.LuminousColors, Block> MINI_BLOCKS = new HashMap<>();
    public static final Map<ModernLights.LuminousColors, Block> MINI_FULL_BLOCKS = new HashMap<>();

    static {
        // Initialize luminous slabs for each color
        for (ModernLights.LuminousColors color : ModernLights.LuminousColors.values()) {
            // Create basic luminous slab and add to map
            String blockName = color.name().equalsIgnoreCase("white") ? "mini_luminous_block" : "mini_luminous_block_" + color.name().toLowerCase();

            MINI_BLOCKS.put(color, createMiniBlock(blockName, false));
        }

        for (ModernLights.LuminousColors color : ModernLights.LuminousColors.values()) {
            // Create full luminous slab and add to map

            String blockName = color.name().equalsIgnoreCase("white") ? "mini_luminous_block_full" : "mini_luminous_block_" + color.name().toLowerCase() + "_full";

            MINI_FULL_BLOCKS.put(color, createMiniBlock(blockName, true));
        }
    }

    // Method to create mini_blocks
    private static Block createMiniBlock(String name, boolean isFull) {
        return BlockBehavior.registerBlocks(name, isFull ? ModernLights.fullInfo : null, new MiniBlock(DEFAULT_MINI_BLOCK_SETTINGS));
    }

    // Access Mini Luminous Blocks [just in case]
    public static Block getMiniBLock(ModernLights.LuminousColors color) {
        return MINI_BLOCKS.get(color);
    }

    public static Block getMiniBlockFull(ModernLights.LuminousColors color) {
        return MINI_FULL_BLOCKS.get(color);
    }

    public static void registerBlocks() {
        com.sythatic.modernlights.ModernLights.LOGGER.info(com.sythatic.modernlights.ModernLights.MOD_ID + " - Registered block:mini_luminous_block");

    }
}
