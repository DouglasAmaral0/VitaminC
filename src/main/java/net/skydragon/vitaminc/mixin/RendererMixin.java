package net.skydragon.vitaminc.mixin;

import com.github.crimsondawn45.fabricshieldlib.initializers.FabricShieldLibClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.entity.model.ShieldEntityModel;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.skydragon.vitaminc.Item.ModItems;
import net.skydragon.vitaminc.VitamincClientMod;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BuiltinModelItemRenderer.class)
public class RendererMixin {
    private ShieldEntityModel modelLemonShield;
    private static final SpriteIdentifier LEMON_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("vitaminc","entity/lemon_shield_base"));
    private static final SpriteIdentifier LEMON_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("vitaminc","entity/lemon_shield_base_nopattern"));
    @Final
    @Shadow
    private EntityModelLoader entityModelLoader;

    @Inject(method = "reload", at = @At("HEAD"))
    private void setModelLemonShield(CallbackInfo ci){
        modelLemonShield = new ShieldEntityModel(this.entityModelLoader.getModelPart(VitamincClientMod.LEMON_SHIELD_MODEL_LAYER));
    }
    @Inject(method = "render", at = @At("HEAD"))
    private void mainRender(ItemStack stack, ModelTransformation.Mode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, CallbackInfo ci) {
        if (stack.isOf(ModItems.LEMON_SHIELD)) {
            FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, modelLemonShield, LEMON_SHIELD_BASE, LEMON_SHIELD_BASE_NO_PATTERN);
            //The first five parameters are taken from the method, while the last 3 you provide yourself. You will provide the model, and then your 2 sprite identifiers in the order of ''//SHIELD_NAME//_BASE'' and then ''//SHIELD_NAME//_BASE_NOPATTERN.
        }
    }

}
