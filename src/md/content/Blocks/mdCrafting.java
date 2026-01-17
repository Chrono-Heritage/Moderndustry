package md.content.Blocks;

import arc.graphics.*;
import arc.math.*;
import arc.struct.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.type.StatusEffect.*;
import mindustry.content.StatusEffects.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.DrawPart.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.unit.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.campaign.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.heat.*;
import mindustry.world.blocks.legacy.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.sandbox.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;
import mindustry.world.blocks.defense.Wall;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.part.RegionPart;
import mindustry.gen.Sounds;
import mindustry.world.Block;
import multicraft.*;


import static mindustry.Vars.*;
import static mindustry.content.Items.*;
import static mindustry.content.Liquids.*;
import static mindustry.content.StatusEffects.*;
import static md.content.mdLiquids.*;
import static md.content.mdItems.*;
import static mindustry.type.ItemStack.*;

public class mdCrafting {
    public static Block 
    alloyFurnance, ammoCrafter, duAmmoConstructer, electrolyzer, enrichedUraniumCrafter, fissionFuelInfuser, isotopeSeparator, lavaHeater, metalFormer, metalSeparator, 
    oreMelter, plasticRefinery, plutonium239Producer, saltExtractor, slagMixer, stoneMelter, radioactiveLiquefier, radioactiveSeparator, radioactiveSmelter;
    
    public static void load() {
    /* Crafting */
    alloyFurnance = new MultiCrafter("alloy-furnace"){{
        requirements(Category.crafting, with(copper, 75, aluminium, 50, tin, 50, graphite,35, silicon,35));
        researchCost = with(copper, 750, aluminium, 500, tin, 500, graphite,200, silicon,200);
        itemCapacity = 60;
        health = 650;
        size = 3;
        buildCostMultiplier = 1.25f;
        hasPower = true;
        hasItems = true;
        drawer = new DrawMulti(new DrawDefault(),new DrawFlame());
        consumePower(1.15f);

        resolvedRecipes = Seq.with(
            new Recipe(
                new IOEntry(
                    Seq.with(ItemStack.with(iron,2, coal,3)),
                    Seq.with()
                ),

                new IOEntry(
                    Seq.with(ItemStack.with(steel, 2)),
                    Seq.with()
                ),
                60f
            ),
            new Recipe(
                new IOEntry(
                    Seq.with(ItemStack.with(copper, 3, tin, 1)),
                    Seq.with()
                ),
                new IOEntry(
                    Seq.with(ItemStack.with(bronze, 4)),
                    Seq.with()
                ),
                90f
            ),
            new Recipe(
                new IOEntry(
                    Seq.with(ItemStack.with(copper,1 , nickel,1)),
                    Seq.with()
                ),
                new IOEntry(
                    Seq.with(ItemStack.with(constantan, 1)),
                    Seq.with()
                ),
                60f
            )
        );
    }};
    ammoCrafter = new MultiCrafter("ammo-crafter"){{
        requirements(Category.crafting, with(copper, 75, aluminium, 50, tin, 50, constantan,35, silicon,35));
        researchCost = with(copper,750, aluminium,500, tin,500, constantan,200, silicon,200);
        itemCapacity = 60;
        health = 950;
        size = 3;
        buildCostMultiplier = 1.25f;
        hasPower = true;
        hasItems = true;
        drawer = new DrawMulti(new DrawDefault(),new DrawFlame());
        consumePower(2.5f);

        resolvedRecipes = Seq.with(
            new Recipe(
                new IOEntry(
                    Seq.with(ItemStack.with(copper,30, titanium,20, nickel,12, steel,8)),
                    Seq.with()
                ),

                new IOEntry(
                    Seq.with(ItemStack.with(bmg, 8)),
                    Seq.with()
                ),
                180f
            ),
            new Recipe(
                new IOEntry(
                    Seq.with(ItemStack.with(copper,30, titanium,20, blastCompound,12, nickel,12, steel,8)),
                    Seq.with()
                ),
                new IOEntry(
                    Seq.with(ItemStack.with(bmgHE, 8)),
                    Seq.with()
                ),
                240f
            ),
            new Recipe(
                new IOEntry(
                    Seq.with(ItemStack.with(copper,30, titanium,20, nickel,12, steel,8, blastCompound,8, thorium,8)),
                    Seq.with()
                ),
                new IOEntry(
                    Seq.with(ItemStack.with(bmgNuclear, 8)),
                    Seq.with()
                ),
                240f
            ),
            new Recipe(
                new IOEntry(
                    Seq.with(ItemStack.with(lead,20, steel,12, iron,12, bronze,10)),
                    Seq.with()
                ),
                new IOEntry(
                    Seq.with(ItemStack.with(machGunAmmo, 5)),
                    Seq.with()
                ),
                300f
            )
        );
    }};
    duAmmoConstructer = new GenericCrafter("du-ammo-constructer") {{
        requirements(Category.crafting, with(copper,125, graphite,45, metaglass,25, titanium,20, uraniumDepleted,10));
        researchCost = ItemStack.with(copper,1250,graphite,450, metaglass, 300,titanium,250,uraniumDepleted,150);
        itemCapacity = 60;
        health = 650;
        size = 3;
        hasPower = true;
        hasItems = true;
        craftTime = 120;
        buildCostMultiplier = 1.5f;
        outputItem = new ItemStack(uraniumDepletedAmmo,2);
        ambientSound = Vars.tree.loadSound("power/GeigerCounter");
        drawer = new DrawMulti(new DrawDefault() , new DrawRegion("-top"), new DrawFlame());

        consumePower(1.25f);
        consumeItems(with(uraniumDepleted,2, lead,6, titanium,8));
    }};
    electrolyzer = new GenericCrafter("electrolyzer") {{
        requirements(Category.crafting, with(copper,100,lead,85,graphite,55, metaglass,40, titanium,25));
        researchCost = with(copper,1750,lead,950,graphite,750,metaglass,550,titanium,350);
        itemCapacity = 60;
        liquidCapacity = 120;
        health = 650;
        size = 3;
        hasPower = true;
        hasItems = true;
        hasLiquids = true;
        craftTime = 90;
        outputLiquid = new LiquidStack(deuterium,0.1f);
        drawer = new DrawMulti( new DrawRegion("-bottom"), new DrawDefault() , new DrawRegion("-top"), new DrawFlame());

        consumePower(2.0f);
        consumeLiquid(heavyWater, 0.1f);
        consumeItem(salt,1);
    }};
    enrichedUraniumCrafter = new GenericCrafter("enriched-uranium-crafter") {{
        requirements(Category.crafting, with(copper,125, silicon,55, metaglass,30, titanium,20,thorium,15,uranium,15));
        researchCost = with(copper,1250, silicon,600, metaglass,450, titanium,300, thorium,200, uranium,200);
        itemCapacity = 60;
        health = 450;
        size = 2;
        hasPower = true;
        hasItems = true;
        craftTime = 120;
        outputItems = (with(uraniumEnriched,2,uraniumDepleted,1));
        ambientSound = Vars.tree.loadSound("power/GeigerCounter");
        drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawDefault() , new DrawRegion("-top"), new DrawFlame());

        consumePower(2.0f);
        consumeItems(with(uranium235,1, uranium238,4));
    }};
    fissionFuelInfuser = new GenericCrafter("fission-fuel-infuser") {{
        requirements(Category.crafting, with(copper,100, graphite,45, metaglass,30, titanium,25,uranium,15));
        researchCost = with(copper,1000,graphite,550,metaglass,400,titanium,250,uranium,200);
        itemCapacity = 60;
        health = 450;
        size = 2;
        hasPower = true;
        hasItems = true;
        craftTime = 120;
        buildCostMultiplier = 1.25f;
        outputItem = new ItemStack(uraniumFuel,1);
        ambientSound = Vars.tree.loadSound("power/GeigerCounter");
        drawer = new DrawMulti(new DrawDefault() , new DrawRegion("-top"), new DrawFlame());

        consumePower(1.1f);
        consumeItems(with(metaglass, 2, uraniumEnriched,4));
    }};
    isotopeSeparator = new Separator("isotope-separator") {{
        requirements(Category.crafting, with(copper,150, lead,85, graphite,55, metaglass,35, titanium,25, thorium,15, uranium, 15));
        researchCost = with(copper, 2000, lead, 1500, graphite,850,graphite,600,metaglass,500,titanium,325,thorium,200,uranium,200);
        itemCapacity = 60;
        health = 650;
        size = 3;
        hasPower = true;
        hasItems = true;
        hasLiquids = false;
        craftTime = 60;
        ambientSound = Vars.tree.loadSound("power/GeigerCounter");
        drawer = new DrawMulti(new DrawRegion("-bottom"),  new DrawRegion("-spinner", 3, true), new DrawDefault(), new DrawRegion("-top"));
        results = with(
            uranium235, 1,
            uranium238, 4
        );
        consumePower(3.0f);
        consumeItem(uranium, 1);
    }};
    lavaHeater = new HeatProducer("lava-heater"){{
        requirements(Category.crafting, with(copper,150, lead,90, aluminium,65, tin,45, iron,45));
        researchCost = with(copper,1500, lead,850, aluminium,750, tin,550, iron,550);
        itemCapacity = 60;
        liquidCapacity = 120;
        health = 750;
        size = 3;
        hasPower = true;
        hasItems = true;
        hasLiquids = true;
        consumeLiquid(lava, 4f / 60f);
        consumePower(1.0f);
        rotateDraw = false;
        drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidRegion(), new DrawDefault());
        ambientSound = Sounds.loopExtract;
        ambientSoundVolume = 0.08f;
        regionRotated1 = 2;
        craftTime = 60f * 2f;
        heatOutput = 12f;
    }};
    metalFormer = new MultiCrafter("metal-former"){{
        requirements(Category.crafting, with(copper, 85, titanium, 35, graphite,20, silicon,20));
        researchCost = with(copper,850, silicon,550, titanium,450, graphite,200, silicon,200);
        itemCapacity = 60;
        liquidCapacity = 120;
        buildCostMultiplier = 1.75f;
        health = 450;
        size = 2;
        hasPower = true;
        hasItems = true;
        hasLiquids = true;
        drawer = new DrawMulti(
            new DrawRegion("-bottom"),
            new DrawPistons(){{
                sinMag = 1f;
            }},
            new DrawDefault(),
            new DrawLiquidRegion(),
            new DrawRegion("-top")
            );
        consumePower(1.5f);
        resolvedRecipes = Seq.with(
            new Recipe(
                new IOEntry(
                    Seq.with(),
                    Seq.with(LiquidStack.with(moltenAluminium, 0.1f))
                ),

                new IOEntry(
                    Seq.with(ItemStack.with(aluminium, 2)),
                    Seq.with()
                ),
                90f
            ),
            new Recipe(
                new IOEntry(
                    Seq.with(),
                    Seq.with(LiquidStack.with(moltenIron, 0.1f))
                ),
                new IOEntry(
                    Seq.with(ItemStack.with(iron, 2)),
                    Seq.with()
                ),
                90f
            ),
            new Recipe(
                new IOEntry(
                    Seq.with(),
                    Seq.with(LiquidStack.with(moltenTin, 0.1f))
                ),
                new IOEntry(
                    Seq.with(ItemStack.with(tin, 2)),
                    Seq.with()
                ),
                90f
            )
        );
    }};
    metalSeparator = new Separator("metal-separator") {{
        requirements(Category.crafting, with(copper,350, silicon,125, graphite,125, metaglass,75));
        researchCost = with(copper,750, silicon,450, graphite,350, metaglass,150);
        itemCapacity = 60;
        liquidCapacity = 120;
        buildCostMultiplier = 0.55f;
        health = 750;
        size = 3;
        hasPower = true;
        hasItems = true;
        hasLiquids = true;
        craftTime = 15;
        drawer = new DrawMulti(new DrawRegion("-bottom"),  new DrawRegion("-spinner", 5, true), new DrawDefault());
        results = with(
            aluminium,2,
            iron,2,
            nickel,1,
            silver,1,
            tin,2,
            lithium,1
        );
        consumePower(2.5f);
        consumeLiquid(slag, 0.05f);
    }};
    oreMelter = new MultiCrafter("ore-melter"){{
        requirements(Category.crafting, with(copper, 55, lead, 40, silicon, 35, metaglass,25));
        researchCost = with(copper,750, lead,500, silicon,400, metaglass,200);
        itemCapacity = 60;
        liquidCapacity = 120;
        health = 450;
        size = 2;
        hasPower = true;
        hasItems = true;
        hasLiquids = true;
        drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidRegion(), new DrawDefault(), new DrawRegion("-top"), new DrawFlame());
        consumePower(1.5f);
        resolvedRecipes = Seq.with(
            new Recipe(
                new IOEntry(
                    Seq.with(ItemStack.with(rawAluminium, 2)),
                    Seq.with()
                ),
                new IOEntry(
                    Seq.with(),
                    Seq.with(LiquidStack.with(moltenAluminium, 0.1f))
                ),
                90f
            ),
            new Recipe(
                new IOEntry(
                    Seq.with(ItemStack.with(rawIron, 2)),
                    Seq.with()
                ),
                new IOEntry(
                    Seq.with(),
                    Seq.with(LiquidStack.with(moltenIron, 0.1f))
                ),
                90f
            ),
            new Recipe(
                new IOEntry(
                    Seq.with(ItemStack.with(rawTin, 2)),
                    Seq.with()
                ),
                new IOEntry(
                    Seq.with(),
                    Seq.with(LiquidStack.with(moltenTin, 0.1f))
                ),
                90f
            )
        );
    }};
    plasticRefinery = new GenericCrafter("plastic-refinery") {{
        requirements(Category.crafting, with(copper,75, lead,45, silicon,40, metaglass,30, iron,25));
        researchCost = with(copper,2250, lead,1250, silicon,600, metaglass,400, iron,300);
        itemCapacity = 60;
        liquidCapacity = 120;
        health = 650;
        size = 3;
        hasPower = true;
        hasItems = true;
        hasLiquids = true;
        craftTime = 120;
        buildCostMultiplier = 0.85f;
        outputItem = new ItemStack(plastic, 2);
        drawer = new DrawMulti(new DrawDefault() , new DrawFlame());

        consumePower(3.0f);
        consumeLiquid(oil, 0.2f);
    }};
    plutonium239Producer = new GenericCrafter("plutonium239-producer") {{
        requirements(Category.crafting, with(copper,125, graphite, 40, silicon,40, metaglass,30, titanium,20, plutonium,10));
        researchCost = with(copper,1000,graphite,600, silicon,600,metaglass,450,titanium,300,plutonium,200);
        itemCapacity = 60;
        health = 450;
        size = 2;
        hasPower = true;
        hasItems = true;
        craftTime = 180;
        buildCostMultiplier = 1.0f;
        outputItem = new ItemStack(plutonium239, 6);
        ambientSound = Vars.tree.loadSound("power/GeigerCounter");
        drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawDefault() , new DrawRegion("-top"), new DrawFlame());

        consumePower(1.1f);
        consumeItems(with(uranium235,2, uranium238,5));
    }};
    saltExtractor = new GenericCrafter("salt-extractor"){{
        requirements(Category.crafting, with(copper, 30, lead, 25, metaglass, 25, silicon, 10));
        researchCost = with(copper,450,lead,325,metaglass,325,silicon,250);
        itemCapacity = 60;
        health = 450;
        size = 2;
        hasPower = true;
        hasItems = true;
        hasLiquids = true;
        craftTime = 120;
        outputItem = new ItemStack(salt,2);
        drawer = new DrawMulti(new DrawRegion("-bottom"),  new DrawRegion("-spinner", 5, true), new DrawDefault(), new DrawRegion("-top"));
        consumeLiquid(Liquids.water, 0.1f);
        consumePower(1.5f);
    }};
    slagMixer = new GenericCrafter("slag-mixer") {{
        requirements(Category.crafting, with(copper,200, lead,125, silicon,75, graphite,75, metaglass,45));
        researchCost= with(copper,3000, lead,2500, silicon,1500, graphite,1500, metaglass,650);
        itemCapacity = 60;
        liquidCapacity = 120;
        health = 450;
        size = 2;
        hasPower = true;
        hasItems = true;
        hasLiquids = true;
        craftTime = 60;
        buildCostMultiplier = 0.5f;
        outputLiquid = new LiquidStack(slag, 0.1f);
        drawer = new DrawMulti(new DrawRegion("-bottom"),  new DrawRegion("-spinner", 5, true), new DrawDefault());

        consumePower(1.5f);
        consumeItems(with(copper,2, lead,2));
    }};
    stoneMelter = new GenericCrafter("stone-melter") {{
        requirements(Category.crafting, with(copper,110, graphite,75, iron,55, metaglass,45));
        researchCost= with(copper,1250, graphite,850, iron,650, metaglass,550);
        itemCapacity = 60;
        liquidCapacity = 120;
        buildCostMultiplier = 1.35f;
        health = 750;
        size = 3;
        hasPower = true;
        hasItems = true;
        hasLiquids = true;
        craftTime = 120;
        buildCostMultiplier = 0.5f;
        outputLiquid = new LiquidStack(lava, 0.15f);
        drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(lava), new DrawDefault(), new DrawFlame());

        consumePower(1.5f);
        consumeItems(with(stone,8));
    }};
    radioactiveLiquefier = new GenericCrafter("radioactive-liquefier") {{
        requirements(Category.crafting, with(copper,100, silicon,75, metaglass,50, titanium,30,thorium,20));
        researchCost = with(copper,1250,silicon,1000,metaglass,500,titanium,350,thorium,250);
        itemCapacity = 60;
        liquidCapacity = 120;
        health = 450;
        size = 2;
        hasPower = true;
        hasItems = true;
        hasLiquids = true;
        craftTime = 60;
        buildCostMultiplier = 0.85f;
        outputLiquid = new LiquidStack(radioactiveSolution, 6f / 60f);
        ambientSound = Vars.tree.loadSound("power/GeigerCounter");
        drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawDefault() , new DrawRegion("-top"), new DrawFlame());

        consumePower(1.1f);
        consumeItem(thorium, 2);
        consumeLiquid(Liquids.water, 0.1f);
    }};
    radioactiveSeparator = new Separator("radioactive-separator") {{
        requirements(Category.crafting, with(copper,125, silicon,55, graphite,55, metaglass,30, titanium,35, thorium,25));
        researchCost = with(copper,2500,silicon,750, graphite,750,metaglass,450, titanium,350);
        itemCapacity = 60;
        liquidCapacity = 120;
        health = 650;
        size = 3;
        hasPower = true;
        hasItems = true;
        hasLiquids = true;
        craftTime = 45;
        buildCostMultiplier = 0.85f;
        ambientSound = Vars.tree.loadSound("power/GeigerCounter");
        drawer = new DrawMulti(new DrawRegion("-bottom"),  new DrawRegion("-spinner", 3, true), new DrawDefault());
        results = with(
            thorium, 1,
            uranium, 4,
            plutonium, 4
        );
        consumePower(3.0f);
        consumeLiquid(radioactiveSolution,0.05f);
    }};
    radioactiveSmelter = new GenericCrafter("radioactive-smelter") {{
        requirements(Category.crafting, with(copper,100, silicon,45, metaglass,25, titanium,10,thorium,10));
        researchCost = with(copper, 1500, silicon,650, metaglass, 400, titanium,250,thorium,250);
        itemCapacity = 60;
        health = 650;
        size = 3;
        hasPower = true;
        hasItems = true;
        craftTime = 75;
        buildCostMultiplier = 1.15f;
        outputItem = new ItemStack(radioalloy, 2);
        ambientSound = Vars.tree.loadSound("power/GeigerCounter");
        drawer = new DrawMulti(new DrawDefault() , new DrawRegion("-top"), new DrawFlame());

        consumePower(1.75f);
        consumeItems(with(thorium, 1, uranium, 1, titanium, 3));
    }};
}
}
