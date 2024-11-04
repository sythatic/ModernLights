package com.sythatic.modernlights.block;

import com.sythatic.modernlights.state.shape.AndesiteFrame;
import com.sythatic.modernlights.state.shape.LuminousBlock;
import com.sythatic.modernlights.ModernLights;
import com.sythatic.modernlights.data.BlockBehavior;
import net.minecraft.block.Block;

import java.util.HashMap;
import java.util.Map;

import static com.sythatic.modernlights.data.CommonBlock.DEFAULT_ANDESITE_FRAME_SETTINGS;
import static com.sythatic.modernlights.data.CommonBlock.defaultLuminousBlockSettings;

public class LuminousBlocks {

    public static final Block ANDESITE_FRAME = BlockBehavior.registerBlocks("andesite_frame", new AndesiteFrame(DEFAULT_ANDESITE_FRAME_SETTINGS));

    // Map to store mini_blocks of different colors
    public static final Map<ModernLights.LuminousColors, Block> LUMINOUS_BLOCKS = new HashMap<>();
    public static final Map<ModernLights.LuminousColors, Block> LUMINOUS_FULL_BLOCKS = new HashMap<>();

    static {
        // Initialize luminous blocks for each color
        for (ModernLights.LuminousColors color : ModernLights.LuminousColors.values()) {
            // Create basic luminous blocks and add to map
            String blockName = color.name().equalsIgnoreCase("white") ? "luminous_block" : "luminous_block_" + color.name().toLowerCase();

            LUMINOUS_BLOCKS.put(color, createLuminousBlock(blockName, false, color));
        }

        for (ModernLights.LuminousColors color : ModernLights.LuminousColors.values()) {
            // Create full luminous blocks full and add to map

            String blockName = color.name().equalsIgnoreCase("white") ? "luminous_block_full" : "luminous_block_" + color.name().toLowerCase() + "_full";

            LUMINOUS_FULL_BLOCKS.put(color, createLuminousBlock(blockName, true, color));
        }
    }

    // Method to create mini_blocks
    private static Block createLuminousBlock(String name, boolean isFull, ModernLights.LuminousColors color) {
        return BlockBehavior.registerBlocks(name, isFull ? ModernLights.fullInfo : null, new LuminousBlock(defaultLuminousBlockSettings(color)));
    }

    public static Block getLuminousBLock(ModernLights.LuminousColors color) {
        return LUMINOUS_BLOCKS.get(color);
    }

    public static Block getLuminousBLockFull(ModernLights.LuminousColors color) {
        return LUMINOUS_FULL_BLOCKS.get(color);
    }

    public static void registerBlocks() {
        com.sythatic.modernlights.ModernLights.LOGGER.info(com.sythatic.modernlights.ModernLights.MOD_ID + " - Registered block:luminous_block");
    }
}
