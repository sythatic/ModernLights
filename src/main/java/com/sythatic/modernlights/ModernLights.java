package com.sythatic.modernlights;

import   com.sythatic.modernlights.block.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModernLights implements ModInitializer {

	public static final String MOD_ID = "modernlights";

	public static final Logger LOGGER = LoggerFactory.getLogger("modernlights");

	public static final RegistryKey<ItemGroup> ITEM_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(MOD_ID, MOD_ID));
	public static final String fullInfo = "full.info"; // Provides tooltip for the block, can be changed in the lang file

	@Override
	public void onInitialize() {

		Registry.register(Registries.ITEM_GROUP, ITEM_GROUP, FabricItemGroup.builder()
				.icon(() -> new ItemStack(LuminousBlocks.getLuminousBLock(LuminousColors.WHITE)))
				.displayName(Text.translatable("itemGroup.modernlights"))
				.build());

		LuminousBlocks.registerBlocks();
		LuminousSlabs.registerBlocks();
		LuminousVerticalSlabs.registerBlocks();
		LuminousMiniBlocks.registerBlocks();
		LuminousPanels.registerBlocks();
		LuminousLights.registerBlocks();
	}

	public enum LuminousColors { //All the colors for all the blocks
		WHITE, LIGHT_GRAY, GRAY, BLACK, BROWN, RED, ORANGE, YELLOW, LIME, GREEN, CYAN, LIGHT_BLUE, BLUE, PURPLE, MAGENTA, PINK
	}

}