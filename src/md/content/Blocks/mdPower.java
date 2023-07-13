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
import mindustry.world.blocks.liquid.Conduit;
import mindustry.world.blocks.storage.Unloader;
import mindustry.world.blocks.units.UnitFactory;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.part.RegionPart;
import mindustry.gen.Sounds;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import md.content.*;

import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;
import static mindustry.content.Items.*;
import static mindustry.content.Liquids.*;
import static md.content.mdItems.*;
import static md.content.mdLiquids.*;

public class mdPower {
    public static Block 
    fissionReactor, fusionReactor, heatGenerator, lithiumBattery, lithiumBatteryLarge, nuclearFurnace, pressurizedHeavyWaterReactor;

    public static void load() {
        fissionReactor = new NuclearReactor("fission-reactor"){{
            requirements(Category.power, with(copper, 400, lead, 350, metaglass, 275, silicon, 200, thorium, 150, uranium, 150));
            researchCost = with(copper,5000,lead,4000,metaglass,3550,silicon,2750,thorium,1750, uranium,1750);
            ambientSound = Vars.tree.loadSound("power/FissionReactor");
            ambientSoundVolume = 0.25f;
            buildCostMultiplier = 0.5f;
            fuelItem = uraniumFuel;
            itemCapacity = 1;
            size = 5;
            health = 1600;
            itemDuration = 1800;
            powerProduction = 100f;
            heating = 0.05f;
            explosionRadius = 30;
            explosionDamage = 5192;
            explodeSound = Vars.tree.loadSound("power/ReactorExplode");
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawDefault() , new DrawRegion("-top"));

            consumeItem(uraniumFuel,1);
            consumeLiquid(Liquids.cryofluid, heating / coolantPower).update(false);
        }};
        fusionReactor = new ImpactReactor("fusion-reactor"){{
            requirements(Category.power, with(copper, 500, lead, 450, silicon, 350, graphite, 350, titanium, 350, metaglass, 250, thorium, 150));
            researchCost = with(copper,5000,lead,4500,titanium,3750,metaglass,3550,silicon,2750,graphite,2750,thorium,1750);
            liquidCapacity = 120;
            health = 1600;
            size = 4;
            hasPower = true;
            hasLiquids = true;
            itemDuration = 180;
            buildCostMultiplier = 0.35f;
            warmupSpeed = 0.01f;
            ambientSound = Sounds.pulse;
            ambientSoundVolume = 0.2f;
            powerProduction = 440.0f;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawPlasma(), new DrawDefault() );

            consumePower(200f);
            consumeLiquids(LiquidStack.with(deuterium, 3f / 60f, tritium, 3f / 60f));
        }};
        heatGenerator = new HeaterGenerator("heat-generator"){{
            requirements(Category.power, with(copper,75, tin,55, aluminium,25, lithium,20));
            researchCost = with(copper,1500, tin,950, aluminium,450, lithium,450);
            liquidCapacity = 120;
            buildCostMultiplier = 1.45f;
            health = 750;
            size = 3;
            hasPower = true;
            hasLiquids = true;
            powerProduction = 2.5f;
            heatOutput = 4f;
            itemDuration = 1080f;
            ambientSoundVolume = 0.1f;
    
            consume(new ConsumeLiquidFlammable(0.1f));
            drawer = new DrawMulti(new DrawDefault(), new DrawWarmupRegion(), new DrawLiquidRegion());
        }};
        lithiumBattery = new Battery("lithium-battery"){{
            requirements(Category.power, with(copper,150, lead,75, aluminium,55, tin,55, lithium,35));
            researchCost = with(copper,3000, lead, 1250, aluminium,1500, tin,1500, lithium,750);
            health = 625;
            size = 2;
            consumePowerBuffered(17250f);
        }};
        lithiumBatteryLarge = new Battery("lithium-battery-large"){{
            requirements(Category.power, with(copper,150, lead,100, graphite,75, aluminium,65, tin,65, lithium,50));
            researchCost = with(copper,3000, lead,2500, graphite,2000, aluminium,1500, tin,1500, lithium,750);
            health = 2500;
            size = 4;
            buildCostMultiplier = 0.75f;
            consumePowerBuffered(87500f);
        }};
        nuclearFurnace = new ConsumeGenerator("nuclear-furnace"){{
            requirements(Category.power, with(copper, 65, lead, 45, silicon, 25, titanium, 15, uranium,10));
            researchCost = with(copper,1250,lead,700,silicon,550,metaglass,500,titanium,300,uranium,150);
            health = 450;
            size = 2;
            buildCostMultiplier = 1.15f;
            powerProduction = 6.5f;
            itemDuration = 1080f;
            ambientSound = Vars.tree.loadSound("power/GeigerCounter");
            ambientSoundVolume = 0.1f;

            consume(new ConsumeItemRadioactive());

            drawer = new DrawMulti(new DrawDefault(), new DrawRegion("-top"), new DrawWarmupRegion());
        }};
        pressurizedHeavyWaterReactor = new ConsumeGenerator("pressurized-heavy-water-reactor"){{
            requirements(Category.power, with(copper, 150, lead, 75, silicon, 45, metaglass, 45, titanium, 25, uranium,15));
            researchCost = with(copper, 1500,lead,850,silicon,550,metaglass,500,titanium,350,uranium,250);
            itemCapacity = 60;
            liquidCapacity = 120;
            health = 750;
            size = 3;
            hasPower = true;
            hasItems = true;
            hasLiquids = true;
            buildCostMultiplier = 0.7f;
            powerProduction = 3.5f;
            itemDuration = 150f;
            ambientSound = Vars.tree.loadSound("power/GeigerCounter");
            ambientSoundVolume = 0.1f;
            outputLiquid = new LiquidStack(tritium, 0.1f);

            consume(new ConsumeItemRadioactive());
            consumeLiquid(heavyWater,0.1f);

            drawer = new DrawMulti(new DrawDefault(), new DrawRegion("-top"), new DrawFlame());
        }};
    }    
}
