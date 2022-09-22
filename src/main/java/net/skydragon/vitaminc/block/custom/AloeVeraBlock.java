package net.skydragon.vitaminc.block.custom;

import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.skydragon.vitaminc.Item.ModItems;
import net.skydragon.vitaminc.block.ModBlock;

public class AloeVeraBlock extends CropBlock {

    public AloeVeraBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ItemConvertible getSeedsItem() {
        return ModItems.ALOEVERA;
    }

}
