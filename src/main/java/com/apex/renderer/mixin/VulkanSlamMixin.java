package com.apex.renderer.mixin;

import com.apex.renderer.ApexRenderer;
import net.vulkanmod.render.vertex.TerrainBufferBuilder;
import com.mojang.blaze3d.vertex.VertexConsumer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TerrainBufferBuilder.class)
public class VulkanSlamMixin {

    // We target addVertex(FFF) because it's the head of the chain on line 102
    @Inject(method = "addVertex(FFF)Lcom/mojang/blaze3d/vertex/VertexConsumer;", at = @At("HEAD"), remap = false)
    private void onVulkanVertex(float x, float y, float z, CallbackInfoReturnable<VertexConsumer> cir) {
        // High-speed SIMD Math Core processing coordinates in parallel
        ApexRenderer.vectorSlam32(x, y, z);
    }
}