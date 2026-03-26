package com.apex.renderer;

import net.fabricmc.api.ClientModInitializer;
import jdk.incubator.vector.FloatVector;
import jdk.incubator.vector.VectorSpecies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main Client Entrypoint for Apex Renderer
 * Developed by Exoduscoder9
 */
public class ApexRenderer implements ClientModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("apex-renderer");
	private static final VectorSpecies<Float> SPECIES = FloatVector.SPECIES_PREFERRED;

	@Override
	public void onInitializeClient() {
		// This is the method Fabric looks for on line 20 of your JSON
		LOGGER.info("§6[Apex Engine]§f Initializing High-Performance Renderer...");
		LOGGER.info("§6[Apex Engine]§f SIMD Math Core Online (Java 26).");
		LOGGER.info("§6[Apex Engine]§f Vector Bit-Size: {} bits", SPECIES.vectorBitSize());

		// Run your internal init logic
		init();
	}

	public static void init() {
		// Any extra startup logic goes here
	}

	public static void vectorSlam32(float x, float y, float z) {
		// High-speed parallel processing on CPU lanes
		FloatVector v = FloatVector.zero(SPECIES)
				.withLane(0, x)
				.withLane(1, y)
				.withLane(2, z);
	}
}