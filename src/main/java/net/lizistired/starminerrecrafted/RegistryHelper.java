package net.lizistired.starminerrecrafted;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import net.lizistired.starminerrecrafted.basics.blocks.*;
import net.lizistired.starminerrecrafted.basics.blocks.bed.*;



public class RegistryHelper {

    public static Block OuterCoreBlock = new OuterCoreBlock(FabricBlockSettings.of(Material.STONE).hardness(4.0f).resistance(2000.0F).luminance(1));

    public static final ItemGroup STARMINER_GROUP = FabricItemGroupBuilder.create(new Identifier("starminerrecrafted", "starminer")).stacksForDisplay(itemStacks -> Registry.ITEM.forEach(item -> {
        if (Registry.ITEM.getId(item).getNamespace().equals("starminerrecrafted")) {
            itemStacks.add(new ItemStack(item));
        }
    })).icon(() -> new ItemStack(OuterCoreBlock)).build();

    //items
    public static Item GravityControllerItem = new Item(new FabricItemSettings().group(STARMINER_GROUP));
    public static Item StarControllerItem = new Item(new FabricItemSettings().group(STARMINER_GROUP));
    public static Item SolarWindFanItem = new Item(new FabricItemSettings().group(STARMINER_GROUP));
    public static Item StarBedItem = new Item(new FabricItemSettings().group(STARMINER_GROUP));
    public static Item StardustItem = new Item(new FabricItemSettings().group(STARMINER_GROUP));
    public static Item GrappleGunItem = new Item(new FabricItemSettings().group(STARMINER_GROUP));
    public static Item BlockGunItemNormal = new Item(new FabricItemSettings().group(STARMINER_GROUP));
    public static Item BlockGunItemShort = new Item(new FabricItemSettings().group(STARMINER_GROUP));
    public static Item BlockGunItemLong = new Item(new FabricItemSettings().group(STARMINER_GROUP));
    public static Item BlockGunItemSpread = new Item(new FabricItemSettings().group(STARMINER_GROUP));

    public static Item GArrowItem = new Item(new FabricItemSettings().group(STARMINER_GROUP));
    public static Item GHookItem = new Item(new FabricItemSettings().group(STARMINER_GROUP));
    public static Item SeedGravitizedItem = new Item(new FabricItemSettings().group(STARMINER_GROUP));
    public static Item CarrotGravitizedItem = new Item(new FabricItemSettings().group(STARMINER_GROUP));
    public static Item PotatoGravitizedItem = new Item(new FabricItemSettings().group(STARMINER_GROUP));
    //blocks
    public static Block GravityCoreBlock = new GravityCoreBlock(FabricBlockSettings.of(Material.STONE).hardness(1.0f).nonOpaque());

    public static Block InnerCoreBlock = new InnerCoreBlock(FabricBlockSettings.of(Material.STONE).nonOpaque().hardness(45.0f).resistance(2000.0f).luminance(1));

    public static Block ManBazookaBlock = new BlockManBazooka(FabricBlockSettings.of(Material.STONE).hardness(2.0f).resistance(50.0f).nonOpaque());

    public static Block NavigatorBlock = new NavigatorBlock(FabricBlockSettings.of(Material.STONE).hardness(1.0f).resistance(1.0f).luminance(1));

    public static TransparentBlock GravityWallBlock = new GravityWallBlock(FabricBlockSettings.of(Material.STONE).hardness(9.0f).resistance(2.0f).nonOpaque());

    public static Block AirExBlock = new BlockAirEx(FabricBlockSettings.of(Material.AIR).nonOpaque());

    public static Block DirtGrassExBlock = new DirtGrassExBlock(FabricBlockSettings.of(Material.SOIL).hardness(0.5f).sounds(BlockSoundGroup.GRAVEL));

    public static Block StarBedBodyBlock = new StarBedBodyBlock(FabricBlockSettings.copy(Blocks.RED_BED).hardness(0.2f));

    public static Block StarBedHeadBlock = new StarBedHeadBlock(FabricBlockSettings.of(Material.WOOL).hardness(0.2f));

    public static Block BlockRotatorBlock = new BlockRotatorBlock(FabricBlockSettings.of(Material.GLASS).nonOpaque().hardness(1.0f).resistance(1.0f).luminance(1).sounds(BlockSoundGroup.GLASS));

    public static Block BlockChestEx = new BlockChestEx(FabricBlockSettings.of(Material.WOOD).nonOpaque());

    public static Block CropGravitizedBlock = new CropGravitizedBlock(FabricBlockSettings.of(Material.PLANT).hardness(0.0f));

    public static Block PlantYelGravitizedBlock = new PlantYelGravitizedBlock(FabricBlockSettings.of(Material.PLANT).hardness(0.0f));

    public static Block PlantRedGravitizedBlock = new PlantRedGravitizedBlock(FabricBlockSettings.of(Material.PLANT).hardness(0.0f));

    public static Block SaplingGravitizedBlock = new SaplingGravitizedBlock(FabricBlockSettings.of(Material.PLANT).hardness(0.0f));

    public static Block CarrotGravitizedBlock = new CarrotGravitizedBlock(FabricBlockSettings.of(Material.PLANT).hardness(0.0f));

    public static Block PotatoGravitizedBlock = new PotatoGravitizedBlock(FabricBlockSettings.of(Material.PLANT).hardness(0.0f));

    public static Block TallGrassGravitizedBlock = new TallGrassGravitizedBlock(FabricBlockSettings.of(Material.PLANT).hardness(0.0f));



   public void registerItemsAndBlocksClass() {
        //todo add all items and blocks, add logic for each thing later, also add recipes and trading options
        Registry.register(Registry.BLOCK, new Identifier("starminerrecrafted", "g_core"), GravityCoreBlock);
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "g_core"), new BlockItem(GravityCoreBlock, new FabricItemSettings().group(STARMINER_GROUP)));
        //BlockRenderLayerMap.INSTANCE.putBlock(GravityCoreBlock, RenderLayer.getCutout());

        Registry.register(Registry.BLOCK, new Identifier("starminerrecrafted", "gravitywall"), GravityWallBlock);
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "gravitywall"), new BlockItem(GravityWallBlock, new FabricItemSettings().group(STARMINER_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier("starminerrecrafted", "innercore"), InnerCoreBlock);
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "innercore"), new BlockItem(InnerCoreBlock, new FabricItemSettings().group(STARMINER_GROUP)));
        //BlockRenderLayerMap.INSTANCE.putBlock(InnerCoreBlock, RenderLayer.getCutout());

        Registry.register(Registry.BLOCK, new Identifier("starminerrecrafted", "outercore"), OuterCoreBlock);
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "outercore"), new BlockItem(OuterCoreBlock, new FabricItemSettings().group(STARMINER_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier("starminerrecrafted", "dirtgrassex"), DirtGrassExBlock);
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "dirtgrassex"), new BlockItem(DirtGrassExBlock, new FabricItemSettings().group(STARMINER_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier("starminerrecrafted", "bedstar"), StarBedBodyBlock);
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "bedstar"), new BlockItem(StarBedBodyBlock, new FabricItemSettings().group(STARMINER_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier("starminerrecrafted", "manbazooka"), ManBazookaBlock);
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "manbazooka"), new BlockItem(ManBazookaBlock, new FabricItemSettings().group(STARMINER_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier("starminerrecrafted", "navigator"), NavigatorBlock);
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "navigator"), new BlockItem(NavigatorBlock, new FabricItemSettings().group(STARMINER_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier("starminerrecrafted", "blockrotator"), BlockRotatorBlock);
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "blockrotator"), new BlockItem(BlockRotatorBlock, new FabricItemSettings().group(STARMINER_GROUP)));
        //BlockRenderLayerMap.INSTANCE.putBlock(BlockRotatorBlock, RenderLayer.getCutout());

        Registry.register(Registry.BLOCK, new Identifier("starminerrecrafted", "airex"), AirExBlock);

        Registry.register(Registry.BLOCK, new Identifier("starminerrecrafted", "chestgravitized"), BlockChestEx);
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "chestgravitized"), new BlockItem(BlockChestEx, new FabricItemSettings().group(STARMINER_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier("starminerrecrafted", "cropgravitized"), CropGravitizedBlock);
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "cropgravitized"), new BlockItem(CropGravitizedBlock, new FabricItemSettings().group(STARMINER_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier("starminerrecrafted", "yflowergravitized.dandelion"), PlantYelGravitizedBlock);
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "yflowergravitized.dandelion"), new BlockItem(PlantYelGravitizedBlock, new FabricItemSettings().group(STARMINER_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier("starminerrecrafted", "rflowergravitized.poppy"), PlantRedGravitizedBlock);
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "rflowergravitized.poppy"), new BlockItem(PlantRedGravitizedBlock, new FabricItemSettings().group(STARMINER_GROUP)));


        //just items
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "gravitycontroller"), GravityControllerItem);
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "starcontroller"), StarControllerItem);
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "solarwindfan"), SolarWindFanItem);
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "starbed"), StarBedItem);
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "starcore_dust"), StardustItem);
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "g_rapplegun"), GrappleGunItem);
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "blockgun_long"), BlockGunItemLong);
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "blockgun_normal"), BlockGunItemNormal);
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "blockgun_short"), BlockGunItemShort);
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "blockgun_spread"), BlockGunItemSpread);
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "g_arrow"), GArrowItem);
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "g_hook"), GHookItem);
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "seedsgravitized"), SeedGravitizedItem);
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "carrotgravitizeditem"), CarrotGravitizedItem);
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "potatogravitizeditem"), PotatoGravitizedItem);

       ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x92BD59, DirtGrassExBlock);


       /*Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "gravitywall"), new BlockItem(PlantYelGravitizedBlock, new FabricItemSettings().group(STARMINER_GROUP)));

       Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "gravitywall"), new BlockItem(PlantYelGravitizedBlock, new FabricItemSettings().group(STARMINER_GROUP)));

       Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "gravitywall"), new BlockItem(PlantYelGravitizedBlock, new FabricItemSettings().group(STARMINER_GROUP)));


        */


    }
}
