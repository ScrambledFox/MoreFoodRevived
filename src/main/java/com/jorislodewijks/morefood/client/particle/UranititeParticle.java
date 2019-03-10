package com.jorislodewijks.morefood.client.particle;

import net.minecraft.client.particle.ParticleRedstone;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class UranititeParticle extends ParticleRedstone {

	public UranititeParticle(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn, RedstoneParticleData redstoneParticleData) {
		super(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, zSpeedIn, redstoneParticleData);
	}
	
	@Override
	public boolean shouldDisableDepth() {
		return false;
	}
	
	public static UranititeParticle createParticle(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn, RedstoneParticleData redstoneParticleData) {
		UranititeParticle particle = new UranititeParticle(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, zSpeedIn, redstoneParticleData);
		((ParticleRedstone)particle).setParticleTextureIndex(0);
		float f1 = worldIn.rand.nextFloat() * 0.05f + 0.95f;
		particle.setColor(1.0f * f1, 0.91f * f1,  0.46f * f1);
		return particle;
	}
	
}