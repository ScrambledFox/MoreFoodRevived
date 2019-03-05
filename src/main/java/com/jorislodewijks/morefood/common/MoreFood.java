package com.jorislodewijks.morefood.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jorislodewijks.morefood.common.block.ModBlocks;
import com.jorislodewijks.morefood.common.item.ModItems;
import com.jorislodewijks.morefood.core.Reference;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Reference.MOD_ID)
public class MoreFood {

	public static MoreFood instance;
	private static final Logger LOGGER = LogManager.getLogger(Reference.MOD_ID);

	public static ItemGroup creativeTab;
	
	
	public MoreFood() {
		instance = this;
		
		creativeTab = new ItemGroup("more_food") {
			@Override
			public ItemStack createIcon() {
				return new ItemStack(ModItems.flour);
			}
		};
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup (final FMLCommonSetupEvent event) {
		LOGGER.info("Setup method running..");
	}
	
	private void clientRegistries (final FMLClientSetupEvent event) {
		LOGGER.info("Client Registries method running..");
	}
	
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) {
			ModBlocks.register(event);
			
			LOGGER.info("Blocks registered.");
		}
		
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			ModItems.register(event);
		
			LOGGER.info("Items registered.");
		}
		
	} 
	
}