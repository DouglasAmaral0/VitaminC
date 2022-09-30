package net.skydragon.vitaminc;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.ShieldEntityModel;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.util.Identifier;
import net.skydragon.vitaminc.block.ModBlock;
import net.skydragon.vitaminc.util.ModModelPredicateProvider;

public class VitamincClientMod implements ClientModInitializer {

    public static final EntityModelLayer LEMON_SHIELD_MODEL_LAYER = new EntityModelLayer(new Identifier("vitaminc", "lemon_shield"),"main");


    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlock.ORANGE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlock.ORANGE_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlock.ALOEVERA_CROP, RenderLayer.getCutout());
        EntityModelLayerRegistry.registerModelLayer(LEMON_SHIELD_MODEL_LAYER, ShieldEntityModel::getTexturedModelData);
        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(new Identifier("vitaminc", "entity/lemon_shield_base"));
            registry.register(new Identifier("vitaminc", "entity/lemon_shield_base_nopattern"));
        });
    }
}
