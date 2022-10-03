package net.skydragon.vitaminc.entity.client;

import net.minecraft.util.Identifier;
import net.skydragon.vitaminc.VitaminC;
import net.skydragon.vitaminc.entity.custom.OrangeDudeEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class OrangeDudeModel extends AnimatedGeoModel<OrangeDudeEntity> {


        @Override
        public Identifier getModelResource(OrangeDudeEntity object) {
            return new Identifier(VitaminC.MOD_ID, "geo/orangedude.geo.json");
        }

        @Override
        public Identifier getTextureResource(OrangeDudeEntity object) {
            return new Identifier(VitaminC.MOD_ID, "textures/entity/orangedude_texture.png");
        }

        @Override
        public Identifier getAnimationResource(OrangeDudeEntity animatable) {
            return new Identifier(VitaminC.MOD_ID, "animations/orangedude.animation.json");
        }

}
