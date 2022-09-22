package net.skydragon.vitaminc.paintings;

import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.skydragon.vitaminc.VitaminC;

public class ModPaintings {

    public static final PaintingVariant ORANGE_PAINTING = registerPainting("orange_painting", new PaintingVariant(32,32));
    public static final PaintingVariant SLiMY_ALOE = registerPainting("slimy_painting", new PaintingVariant(32,32));

    private static PaintingVariant registerPainting(String name, PaintingVariant paintingVariant){
        return Registry.register(Registry.PAINTING_VARIANT, new Identifier(VitaminC.MOD_ID, name), paintingVariant);
    }
    public static void registerPaintings() {
        VitaminC.LOGGER.debug("Register Paintings");
    }
}
