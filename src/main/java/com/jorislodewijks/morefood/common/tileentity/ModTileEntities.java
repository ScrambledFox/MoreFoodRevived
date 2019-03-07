package com.jorislodewijks.morefood.common.tileentity;

import com.jorislodewijks.morefood.common.tileentity.machine.TileEntityMill;
import com.jorislodewijks.morefood.core.Reference;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;

public class ModTileEntities {

	
	public static TileEntityType<TileEntityMill> tileEntityMill;
	
	
	public static void register(final RegistryEvent.Register<TileEntityType<?>> event) {
		tileEntityMill = TileEntityType.register(Reference.MOD_ID + ":mill_tile_entity", TileEntityType.Builder.create(TileEntityMill::new));
	}
	
}