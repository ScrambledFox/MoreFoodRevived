package com.jorislodewijks.morefood.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jorislodewijks.morefood.client.gui.GuiMill;
import com.jorislodewijks.morefood.common.block.ModBlocks;
import com.jorislodewijks.morefood.common.item.ModItems;
import com.jorislodewijks.morefood.common.tileentity.ModTileEntities;
import com.jorislodewijks.morefood.common.tileentity.machine.TileEntityMill;
import com.jorislodewijks.morefood.common.world.generation.ModSaltOreGeneration;
import com.jorislodewijks.morefood.core.Reference;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Reference.MOD_ID)
public class MoreFood {

	public static MoreFood instance;
	private static final Logger LOGGER = LogManager.getLogger(Reference.MOD_ID);

	public static ItemGroup CREATIVE_TAB;
	
	
	public MoreFood() {
		instance = this;
		
		CREATIVE_TAB = new ItemGroup("more_food") {
			@Override
			public ItemStack createIcon() {
				return new ItemStack(ModItems.FLOUR);
			}
		};
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.GUIFACTORY, () -> {
			return (openContainer) -> {
				ResourceLocation location = openContainer.getId();
				if ( location.toString().equals(Reference.MOD_ID + Reference.GUI_MILL) ) {
					EntityPlayerSP player = Minecraft.getInstance().player;
					BlockPos pos = openContainer.getAdditionalData().readBlockPos();
					TileEntity tileentity = player.world.getTileEntity(pos);
					if (tileentity instanceof TileEntityMill) {
						return new GuiMill(player.inventory, (TileEntityMill)tileentity);
					}
				}
				return null;
			};
		});
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup (final FMLCommonSetupEvent event) {
		ModSaltOreGeneration.Init();
	}
	
	private void clientRegistries (final FMLClientSetupEvent event) {
		
	}
	
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {
		
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			ModItems.register(event);
		
			LOGGER.info("Items registered.");
		}
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) {
			ModBlocks.register(event);
			
			LOGGER.info("Blocks registered.");
		}
		
		@SubscribeEvent
		public static void registerTileEntities(final RegistryEvent.Register<TileEntityType<?>> event) {
			ModTileEntities.register(event);
			
			LOGGER.info("Tile Entities registered.");
		}
		
	} 
	
}