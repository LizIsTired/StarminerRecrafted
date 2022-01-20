package net.lizistired.starminerrecrafted;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.lizistired.starminerrecrafted.basics.blocks.*;
import net.lizistired.starminerrecrafted.basics.blocks.bed.*;



public class RegistryHelper {
    //items
    public static Item GravityControllerItem;
    public static Item StarControlerItem;
    public static Item SolarWindFanItem;
    public static Item StarBedItem;
    public static Item StardustItem;
    public static Item GrappleGunItem;
    public static Item BlockGunItem;
    public static Item GArrowItem;
    public static Item GHookItem;
    public static Item SeedGravizedItem;
    public static Item CarrotGravizedItem;
    public static Item PotatoGravizedItem;
    //blocks
    public static Block GravityCoreBlock = new GravityCoreBlock(FabricBlockSettings.of(Material.STONE).hardness(1.0f).nonOpaque());
    public static Block InnerCoreBlock = new InnerCoreBlock(FabricBlockSettings.of(Material.STONE).nonOpaque().hardness(45.0f).resistance(2000.0f).luminance(1));
    public static Block OuterCoreBlock = new OuterCoreBlock(FabricBlockSettings.of(Material.STONE).hardness(4.0f).resistance(2000.0F).luminance(1));
    public static Block ManBazookaBlock;
    public static Block NavigatorBlock;
    public static Block GravityWallBlock = new GravityWallBlock(FabricBlockSettings.of(Material.STONE).hardness(9.0f).resistance(2.0f));
    public static Block AirExBlock = new BlockAirEx(FabricBlockSettings.of(Material.AIR));
    public static Block DirtGrassExBlock = new DirtGrassExBlock(FabricBlockSettings.of(Material.AGGREGATE));
    public static Block StarBedBodyBlock = new StarBedBodyBlock(FabricBlockSettings.of(Material.WOOL).hardness(0.2f));
    public static Block StarBedHeadBlock = new StarBedHeadBlock(FabricBlockSettings.of(Material.WOOL).hardness(0.2f));
    public static Block BlockRotatorBlock;
    public static Block BlockChestEx;
    public static Block CropGravitizedBlock;
    public static Block PlantYelGravitizedBlock;
    public static Block PlantRedGravitizedBlock;
    public static Block SaplingGravitizedBlock;
    public static Block CarrotGravitizedBlock;
    public static Block PotatoGravitizedBlock;
    public static Block TallGrassGravitizedBlock;

    public static final ItemGroup STARMINER_GROUP = FabricItemGroupBuilder.create(new Identifier("starminerrecrafted", "starminer")).stacksForDisplay(itemStacks -> Registry.ITEM.forEach(item -> {
        if (Registry.ITEM.getId(item).getNamespace().equals("starminerrecrafted")) {
            itemStacks.add(new ItemStack(item));
        }
    })).icon(() -> new ItemStack(OuterCoreBlock)).build();

   public void registerItemsAndBlocksClass() {
        //todo add all items and blocks, add logic for each thing later
        Registry.register(Registry.BLOCK, new Identifier("starminerrecrafted", "g_core"), GravityCoreBlock);
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "g_core"), new BlockItem(GravityCoreBlock, new FabricItemSettings().group(STARMINER_GROUP)));
        BlockRenderLayerMap.INSTANCE.putBlock(GravityCoreBlock, RenderLayer.getCutout());

        Registry.register(Registry.BLOCK, new Identifier("starminerrecrafted", "gravitywall"), GravityWallBlock);
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "gravitywall"), new BlockItem(GravityWallBlock, new FabricItemSettings().group(STARMINER_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier("starminerrecrafted", "innercore"), InnerCoreBlock);
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "innercore"), new BlockItem(InnerCoreBlock, new FabricItemSettings().group(STARMINER_GROUP)));
        BlockRenderLayerMap.INSTANCE.putBlock(InnerCoreBlock, RenderLayer.getCutout());

        Registry.register(Registry.BLOCK, new Identifier("starminerrecrafted", "outercore"), OuterCoreBlock);
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "outercore"), new BlockItem(OuterCoreBlock, new FabricItemSettings().group(STARMINER_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier("starminerrecrafted", "dirtgrassex"), DirtGrassExBlock);
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "dirtgrassex"), new BlockItem(DirtGrassExBlock, new FabricItemSettings().group(STARMINER_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier("starminerrecrafted", "bedstar"), StarBedBodyBlock);
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "bedstar"), new BlockItem(StarBedBodyBlock, new FabricItemSettings().group(STARMINER_GROUP)));

        /*Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "gravitywall"), new BlockItem(GravityWallBlock, new FabricItemSettings().group(STARMINER_GROUP)));

        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "gravitywall"), new BlockItem(GravityWallBlock, new FabricItemSettings().group(STARMINER_GROUP)));

        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "gravitywall"), new BlockItem(GravityWallBlock, new FabricItemSettings().group(STARMINER_GROUP)));

        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "gravitywall"), new BlockItem(GravityWallBlock, new FabricItemSettings().group(STARMINER_GROUP)));

        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "gravitywall"), new BlockItem(GravityWallBlock, new FabricItemSettings().group(STARMINER_GROUP)));

        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "gravitywall"), new BlockItem(GravityWallBlock, new FabricItemSettings().group(STARMINER_GROUP)));

        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "gravitywall"), new BlockItem(GravityWallBlock, new FabricItemSettings().group(STARMINER_GROUP)));
*/
    }
}
