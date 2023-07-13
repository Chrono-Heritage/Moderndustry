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
import mindustry.world.blocks.power.SolarGenerator;
import mindustry.world.blocks.storage.Unloader;
import mindustry.world.blocks.units.UnitFactory;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.part.RegionPart;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ItemTurret;

import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;
import static mindustry.content.Items.*;
import static mindustry.content.Liquids.*;
import static md.content.mdItems.*;
import static md.content.mdLiquids.*;

public class mdProduction {
    public static Block 
    /* Production */
    heavyWaterExtractor, nuclearDrill, nuclearPump;
    ;
    public static void load() {
        /* Production */
        heavyWaterExtractor = new SolidPump("heavy-water-extractor"){{
            requirements(Category.production, with(copper, 40, metaglass, 25, graphite, 10, titanium, 10));
            researchCost = with(copper,550,metaglass,300,graphite,200,titanium,150);
            result = heavyWater;
            pumpAmount = 0.11f;
            size = 2;
            liquidCapacity = 60f;
            rotateSpeed = 1.4f;

            consumePower(1.75f);
        }};
        nuclearDrill = new Drill("nuclear-drill"){{
            requirements(Category.production, with(copper, 125, silicon, 75, titanium, 50, uranium, 35));
            researchCost = with(copper,1500,silicon,550,titanium,450,uranium,350);
            itemCapacity = 60;
            liquidCapacity = 120;
            health = 850;
            size = 4;
            hasPower = true;
            hasItems = true;
            hasLiquids = true;
            drillTime = 220;
            tier = 5;
            buildCostMultiplier = 0.8f;
            liquidBoostIntensity = 1.75f;
            drawMineItem = false;
            liquidBoostIntensity = 1.8f;

            consumePower(3f);
            consumeLiquid(radioactiveSolution, 0.1f).boost();
        }};
        nuclearPump = new Pump("nuclear-pump"){{
            requirements(Category.liquid, with(copper, 75, metaglass, 50, silicon, 30, titanium, 30, uranium, 20));
            researchCost = with(copper,1250,metaglass,850,silicon,550,titanium,400,uranium,250);
            itemCapacity = 60;
            liquidCapacity = 120;
            health = 650;
            size = 3;
            buildCostMultiplier = 0.75f;
            hasPower = true;
            hasLiquids = true;
            pumpAmount = 0.4f;
            consumeTime = 180;

            consumePower(3f);
            consume(new ConsumeItemRadioactive());
        }};
    }
}
