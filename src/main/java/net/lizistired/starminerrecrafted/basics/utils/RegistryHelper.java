package net.lizistired.starminerrecrafted.basics.utils;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.lizistired.starminerrecrafted.basics.blockentities.GravityCoreBlockEntity;
//import net.lizistired.starminerrecrafted.basics.structures.test.MyFeature;
//import net.lizistired.starminerrecrafted.basics.structures.test.MyGenerator;
import net.lizistired.starminerrecrafted.basics.blockentities.SphereGenBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;

import net.lizistired.starminerrecrafted.basics.blocks.*;
import net.lizistired.starminerrecrafted.basics.blocks.bed.*;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

import static net.lizistired.starminerrecrafted.MainInit.namespace;


public class RegistryHelper {

    public static Block OuterCoreBlock = new OuterCoreBlock(FabricBlockSettings.of(Material.STONE).hardness(4.0f).resistance(2000.0F).luminance(1));

    public static final ItemGroup STARMINER_GROUP = FabricItemGroupBuilder.create(new Identifier(namespace, "starminer")).stacksForDisplay(itemStacks -> Registry.ITEM.forEach(item -> {
        if (Registry.ITEM.getId(item).getNamespace().equals(namespace)) {
            itemStacks.add(new ItemStack(item));
        }
    })).icon(() -> new ItemStack(OuterCoreBlock)).build();

    //items
    public static Item GravityControllerItem = new Item(new FabricItemSettings().group(STARMINER_GROUP).maxCount(1));
    public static Item StarControllerItem = new Item(new FabricItemSettings().group(STARMINER_GROUP).maxCount(1));
    public static Item SolarWindFanItem = new Item(new FabricItemSettings().group(STARMINER_GROUP).maxCount(1).maxDamage(500));
    public static Item StarBedItem = new Item(new FabricItemSettings().group(STARMINER_GROUP).maxCount(1));
    public static Item StardustItem = new Item(new FabricItemSettings().group(STARMINER_GROUP).maxCount(64));
    public static Item GrappleGunItem = new Item(new FabricItemSettings().group(STARMINER_GROUP).maxCount(1).maxDamage(512));
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
    public static Block StarBedBodyBlock = new StarBedBodyBlock(FabricBlockSettings.of(Material.WOOL).hardness(0.2f));
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

    public static Block SphereGenBlock = new SphereGenBlock(FabricBlockSettings.of(Material.STONE).hardness(1.0f).nonOpaque());

    //block entities
    public static BlockEntityType<GravityCoreBlockEntity> GravityCoreBlockEntity;
    public static BlockEntityType<SphereGenBlockEntity> SphereGenBlockEntity;

    //structures
    //public static final StructurePieceType MY_PIECE = MyGenerator.MyPiece::new;
    //private static final StructureFeature<DefaultFeatureConfig> MY_STRUCTURE = new MyFeature(DefaultFeatureConfig.CODEC);
    //private static final ConfiguredStructureFeature<?, ?> MY_CONFIGURED = MY_STRUCTURE.configure(DefaultFeatureConfig.DEFAULT);

    public void registerEverything() {
        registerItemsAndBlocksClass();
        registerOtherThings();
        registerStructures();
        registerPortals();
    }

    public void registerItemsAndBlocksClass() {
        //todo add all items and blocks, add logic for each thing later, also add recipes and trading options
        Registry.register(Registry.BLOCK, new Identifier(namespace, "g_core"), GravityCoreBlock);
        Registry.register(Registry.ITEM, new Identifier(namespace, "g_core"), new BlockItem(GravityCoreBlock, new FabricItemSettings().group(STARMINER_GROUP)));
        //BlockRenderLayerMap.INSTANCE.putBlock(GravityCoreBlock, RenderLayer.getCutout());

        Registry.register(Registry.BLOCK, new Identifier(namespace, "gravitywall"), GravityWallBlock);
        Registry.register(Registry.ITEM, new Identifier(namespace, "gravitywall"), new BlockItem(GravityWallBlock, new FabricItemSettings().group(STARMINER_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier(namespace, "innercore"), InnerCoreBlock);
        Registry.register(Registry.ITEM, new Identifier(namespace, "innercore"), new BlockItem(InnerCoreBlock, new FabricItemSettings().group(STARMINER_GROUP)));
        //BlockRenderLayerMap.INSTANCE.putBlock(InnerCoreBlock, RenderLayer.getCutout());

        Registry.register(Registry.BLOCK, new Identifier(namespace, "outercore"), OuterCoreBlock);
        Registry.register(Registry.ITEM, new Identifier(namespace, "outercore"), new BlockItem(OuterCoreBlock, new FabricItemSettings().group(STARMINER_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier(namespace, "dirtgrassex"), DirtGrassExBlock);
        Registry.register(Registry.ITEM, new Identifier(namespace, "dirtgrassex"), new BlockItem(DirtGrassExBlock, new FabricItemSettings().group(STARMINER_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier(namespace, "bedstar"), StarBedBodyBlock);
        Registry.register(Registry.ITEM, new Identifier(namespace, "bedstar"), new BlockItem(StarBedBodyBlock, new FabricItemSettings().group(STARMINER_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier(namespace, "manbazooka"), ManBazookaBlock);
        Registry.register(Registry.ITEM, new Identifier(namespace, "manbazooka"), new BlockItem(ManBazookaBlock, new FabricItemSettings().group(STARMINER_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier(namespace, "navigator"), NavigatorBlock);
        Registry.register(Registry.ITEM, new Identifier(namespace, "navigator"), new BlockItem(NavigatorBlock, new FabricItemSettings().group(STARMINER_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier(namespace, "blockrotator"), BlockRotatorBlock);
        Registry.register(Registry.ITEM, new Identifier(namespace, "blockrotator"), new BlockItem(BlockRotatorBlock, new FabricItemSettings().group(STARMINER_GROUP)));
        //BlockRenderLayerMap.INSTANCE.putBlock(BlockRotatorBlock, RenderLayer.getCutout());

        Registry.register(Registry.BLOCK, new Identifier(namespace, "airex"), AirExBlock);

        Registry.register(Registry.BLOCK, new Identifier(namespace, "chestgravitized"), BlockChestEx);
        Registry.register(Registry.ITEM, new Identifier(namespace, "chestgravitized"), new BlockItem(BlockChestEx, new FabricItemSettings().group(STARMINER_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier(namespace, "cropgravitized"), CropGravitizedBlock);
        Registry.register(Registry.ITEM, new Identifier(namespace, "cropgravitized"), new BlockItem(CropGravitizedBlock, new FabricItemSettings().group(STARMINER_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier(namespace, "yflowergravitized.dandelion"), PlantYelGravitizedBlock);
        Registry.register(Registry.ITEM, new Identifier(namespace, "yflowergravitized.dandelion"), new BlockItem(PlantYelGravitizedBlock, new FabricItemSettings().group(STARMINER_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier(namespace, "rflowergravitized.poppy"), PlantRedGravitizedBlock);
        Registry.register(Registry.ITEM, new Identifier(namespace, "rflowergravitized.poppy"), new BlockItem(PlantRedGravitizedBlock, new FabricItemSettings().group(STARMINER_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier(namespace, "spheregenblock"), SphereGenBlock);
        Registry.register(Registry.ITEM, new Identifier(namespace, "spheregenblock"), new BlockItem(SphereGenBlock, new FabricItemSettings().group(STARMINER_GROUP)));


        //just items
        Registry.register(Registry.ITEM, new Identifier(namespace, "gravitycontroller"), GravityControllerItem);
        Registry.register(Registry.ITEM, new Identifier(namespace, "starcontroller"), StarControllerItem);
        Registry.register(Registry.ITEM, new Identifier(namespace, "solarwindfan"), SolarWindFanItem);
        Registry.register(Registry.ITEM, new Identifier(namespace, "starbed"), StarBedItem);
        Registry.register(Registry.ITEM, new Identifier(namespace, "starcore_dust"), StardustItem);
        Registry.register(Registry.ITEM, new Identifier(namespace, "g_rapplegun"), GrappleGunItem);
        Registry.register(Registry.ITEM, new Identifier(namespace, "blockgun_long"), BlockGunItemLong);
        Registry.register(Registry.ITEM, new Identifier(namespace, "blockgun_normal"), BlockGunItemNormal);
        Registry.register(Registry.ITEM, new Identifier(namespace, "blockgun_short"), BlockGunItemShort);
        Registry.register(Registry.ITEM, new Identifier(namespace, "blockgun_spread"), BlockGunItemSpread);
        Registry.register(Registry.ITEM, new Identifier(namespace, "g_arrow"), GArrowItem);
        Registry.register(Registry.ITEM, new Identifier(namespace, "g_hook"), GHookItem);
        Registry.register(Registry.ITEM, new Identifier(namespace, "seedsgravitized"), SeedGravitizedItem);
        Registry.register(Registry.ITEM, new Identifier(namespace, "carrotgravitizeditem"), CarrotGravitizedItem);
        Registry.register(Registry.ITEM, new Identifier(namespace, "potatogravitizeditem"), PotatoGravitizedItem);




       /*Registry.register(Registry.ITEM, new Identifier(namespace, "gravitywall"), new BlockItem(PlantYelGravitizedBlock, new FabricItemSettings().group(STARMINER_GROUP)));

       Registry.register(Registry.ITEM, new Identifier(namespace, "gravitywall"), new BlockItem(PlantYelGravitizedBlock, new FabricItemSettings().group(STARMINER_GROUP)));

       Registry.register(Registry.ITEM, new Identifier(namespace, "gravitywall"), new BlockItem(PlantYelGravitizedBlock, new FabricItemSettings().group(STARMINER_GROUP)));*/
    }

    public void registerOtherThings() {

        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x92BD59, DirtGrassExBlock);

        GravityCoreBlockEntity = Registry.register(Registry.BLOCK_ENTITY_TYPE, namespace + ":gravity_core_block_entity", FabricBlockEntityTypeBuilder.create(GravityCoreBlockEntity::new, GravityCoreBlock).build(null));
        SphereGenBlockEntity = Registry.register(Registry.BLOCK_ENTITY_TYPE, namespace + ":sphere_gen_block_entity", FabricBlockEntityTypeBuilder.create(SphereGenBlockEntity::new, SphereGenBlock).build(null));
    }

    public void registerStructures(){
        //Registry.register(Registry.STRUCTURE_PIECE, new Identifier(namespace, "my_piece"), MY_PIECE);
        //FabricStructureBuilder.create(new Identifier(namespace, "my_structure"), MY_STRUCTURE)
        //        .step(GenerationStep.Feature.SURFACE_STRUCTURES)
        //        .defaultConfig(32, 8, 12345)
        //        .adjustsSurface()
        //        .register();
        //RegistryKey<ConfiguredStructureFeature<?, ?>> myConfigured = RegistryKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_WORLDGEN,
        //        new Identifier(namespace, "my_structure"));
        //BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, myConfigured.getValue(), MY_CONFIGURED);
        //BiomeModifications.addStructure(BiomeSelectors.all(), myConfigured);
    }

    public void registerPortals(){
        CustomPortalBuilder.beginPortal()
                .frameBlock(Blocks.DIAMOND_BLOCK)
                .lightWithItem(Items.ENDER_EYE)
                .destDimID(new Identifier("starminerrecrafted:space"))
                .tintColor(45,65,101)
                .registerPortal();
    }
}
