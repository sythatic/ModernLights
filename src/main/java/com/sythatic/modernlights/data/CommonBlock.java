package com.sythatic.modernlights.data;

import com.sythatic.modernlights.state.shape.*;
import com.sythatic.modernlights.ModernLights.LuminousColors;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.sound.BlockSoundGroup;

public class CommonBlock {



    public static AbstractBlock.Settings defaultLuminousBlockSettings(LuminousColors color) {
        return BlockBehavior.CREATE_BLOCK_SETTINGS(2.5f, 5.0f, LuminousBlock.LIT, 15, false, color);
    }
    public static AbstractBlock.Settings defaultPanelSettings(LuminousColors color) {
        return BlockBehavior.CREATE_BLOCK_SETTINGS(2.5f, 5.0f, PanelBlock.LIT, 14, true, color);
    }

    public static AbstractBlock.Settings defaultLuminousSlabSettings(LuminousColors color) {
        return BlockBehavior.CREATE_BLOCK_SETTINGS(2.5f, 5.0f, LuminousSlabBlock.LIT, 15, false, color);
    }
    public static AbstractBlock.Settings defaultLuminousVerticalSlabSettings(LuminousColors color) {
        return BlockBehavior.CREATE_BLOCK_SETTINGS(2.5f, 5.0f, LuminousVerticalSlabBlock.LIT, 15, false, color);
    }

    public static AbstractBlock.Settings DEFAULT_ANDESITE_FRAME_SETTINGS =
            AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.NORMAL).sounds(BlockSoundGroup.METAL).strength(5.0F, 5.0F);
    public static final AbstractBlock.Settings DEFAULT_CEILING_LIGHT_SETTINGS =
            BlockBehavior.CREATE_BLOCK_SETTINGS(2.0f, 4.0f, CeilingLightBlock.LIT, 10, true, null).noCollision();
    public static final AbstractBlock.Settings DEFAULT_MINI_LIGHT_SETTINGS =
            BlockBehavior.CREATE_BLOCK_SETTINGS(2.0f, 4.0f, MiniLightBlock.LIT, 8, true, null).noCollision();
    public static final AbstractBlock.Settings DEFAULT_MINI_BLOCK_SETTINGS =
            BlockBehavior.CREATE_BLOCK_SETTINGS(2.0f, 4.0f, MiniBlock.LIT, 12, true, null);
    public static final AbstractBlock.Settings DEFAULT_SMALL_PANEL_SETTINGS =
            BlockBehavior.CREATE_BLOCK_SETTINGS(2.5f, 5.0f, PanelSmallBlock.LIT, 12, true, null).noCollision();

}
