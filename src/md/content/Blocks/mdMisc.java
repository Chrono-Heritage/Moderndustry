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
import mindustry.world.blocks.power.SolarGenerator;
import mindustry.world.blocks.units.UnitFactory;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.part.RegionPart;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import md.content.*;

import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;
import static mindustry.content.Items.*;
import static mindustry.content.Liquids.*;
import static md.content.mdItems.*;
import static md.content.mdLiquids.*;
import static md.content.mdUnitTypes.*;

public class mdMisc {
    public static Block
     coreNuclear, extendTank, extendStorage, nuclearOverdriver;

    public static void load() {
        coreNuclear = new CoreBlock("core-nuclear"){{
            requirements(Category.effect, with(copper,7500, lead, 7500, graphite, 4500, silicon,4500, thorium, 3500, uranium,2500));
            researchCost = with(copper,22500, lead,17500,graphite,12500,silicon,12500, thorium,7500, uranium,7500);
            unitType = neutron;
            health = 12000;
            itemCapacity = 20000;
            size = 7;
            unitCapModifier = 32;
        }};
        extendTank = new LiquidRouter("extend-tank"){{
        requirements(Category.liquid, with(copper, 200, tin,120, steel,80, aluminium,40, metaglass, 30));
        researchCost = with(copper, 2000, tin,1250, steel,850, aluminium,650, metaglass, 450);
        health = 1250;
        liquidCapacity = 5600f;
        size = 5;
        solid = true;
        buildCostMultiplier = 0.65f;
        }};
        extendStorage = new StorageBlock("extend-storage"){{
            requirements(Category.effect, with(copper,200, tin,150, lead,150, iron,125, nickel,125));
            researchCost = with(copper,2000, tin,950, lead,950, iron,650, nickel,650);
            health = 1250;
            size = 5;
            itemCapacity = 4000;
            buildCostMultiplier = 0.65f;
        }};
        nuclearOverdriver = new OverdriveProjector("nuclear-overdriver"){{
            requirements(Category.effect, with(copper, 200, lead, 150, titanium, 100, silicon, 100, uranium, 50, plutonium, 50 ));
            itemCapacity = 60;
            liquidCapacity = 120;
            size = 3;
            hasPower = true;
            hasItems = true;
            hasLiquids = true;
            phaseColor = Color.valueOf("46C44E");
            baseColor = Color.valueOf("46C44E");
            range = 240f;
            speedBoost = 2.5f;
            hasBoost = false;
            useTime = 300f;

            consume(new ConsumeItemRadioactive());
            consumeLiquid(radioactiveSolution, 0.1f);
            consumePower(6f);
        }};
    }
}
