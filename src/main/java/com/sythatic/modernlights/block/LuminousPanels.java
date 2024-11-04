package com.sythatic.modernlights.block;

import com.sythatic.modernlights.state.shape.PanelBlock;
import com.sythatic.modernlights.state.shape.PanelSmallBlock;
import com.sythatic.modernlights.ModernLights;
import com.sythatic.modernlights.data.BlockBehavior;
import net.minecraft.block.Block;

import java.util.HashMap;
import java.util.Map;

import static com.sythatic.modernlights.data.CommonBlock.DEFAULT_SMALL_PANEL_SETTINGS;
import static com.sythatic.modernlights.data.CommonBlock.defaultPanelSettings;

public class LuminousPanels {

    // Map to store panels and panel_small of different colors
    public static final Map<ModernLights.LuminousColors, Block> PANEL_BLOCKS = new HashMap<>();
    public static final Map<ModernLights.LuminousColors, Block> SMALL_PANEL_BLOCKS = new HashMap<>();

    static {
        // Initialize luminous slabs for each color
        for (ModernLights.LuminousColors color : ModernLights.LuminousColors.values()) {
            // Create basic luminous slab and add to map
            String blockName = color.name().equalsIgnoreCase("white") ? "panel" : "panel_" + color.name().toLowerCase();

            PANEL_BLOCKS.put(color, createPanel(blockName, false, color));
        }

        for (ModernLights.LuminousColors color : ModernLights.LuminousColors.values()) {
            // Create full luminous slab and add to map

            String blockName = color.name().equalsIgnoreCase("white") ? "panel_small" : "panel_small_" + color.name().toLowerCase();

            SMALL_PANEL_BLOCKS.put(color, createPanel(blockName, true, color));
        }
    }

    // Method to create panels
    private static Block createPanel(String name, boolean isSmall, ModernLights.LuminousColors color) {
        return BlockBehavior.registerBlocks(name, isSmall ? new PanelSmallBlock(DEFAULT_SMALL_PANEL_SETTINGS) : new PanelBlock(defaultPanelSettings(color)));
    }

    // Access Mini Luminous Blocks [just in case]
    public static Block getPanelBLock(ModernLights.LuminousColors color) {
        return PANEL_BLOCKS.get(color);
    }

    public static Block getSmallPanelBLock(ModernLights.LuminousColors color) {
        return SMALL_PANEL_BLOCKS.get(color);
    }

    public static void registerBlocks() {
        com.sythatic.modernlights.ModernLights.LOGGER.info(com.sythatic.modernlights.ModernLights.MOD_ID + " - Registered block:luminous_panel");
    }
}

