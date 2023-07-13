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
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.part.RegionPart;
import mindustry.gen.Sounds;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ItemTurret;

import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;
import static mindustry.content.Items.*;
import static mindustry.content.Liquids.*;
import static md.content.mdItems.*;
import static md.content.mdUnitTypes.*;

public class mdUnits {
    public static Block 
    metalUnitFactory, metalT2Reconstructor, metalT3Reconstructor, nuclearUnitFactory;
    public static void load() {
        metalUnitFactory = new UnitFactory("metal-unit-factory"){{
            requirements(Category.units, with(copper, 225, lead, 155, iron,40, tin,40));
            researchCost = with(copper, 850, lead, 650, iron,500, tin,500);
            plans = Seq.with(
                new UnitPlan(pistoler, 60f * 10, with(lead,20, iron,10, aluminium,5))
            );
            size = 3;
            health = 750;
            consumePower(0.5f);
        }};
        metalT2Reconstructor = new Reconstructor("metal-t2-reconstructor"){{
            requirements(Category.units, with(copper, 325, silicon, 185, tin,165, steel,125));
            researchCost = with(copper, 1050, silicon, 750, tin,750, steel,550);
            size = 3;
            consumePower(1f);
            consumeItems(with(silicon,20, titanium, 10, steel,10));
            health = 750;
            constructTime = 60f * 10f;
            upgrades.addAll(
                new UnitType[]{pistoler, twinPistoler}
            );
        }};
        metalT3Reconstructor = new Reconstructor("metal-t3-reconstructor"){{
            requirements(Category.units, with(copper, 375, lead, 295, silicon, 225, constantan, 185, tin,185, steel,185, lithium,185));
            researchCost = with(copper, 2150, lead, 1750, silicon, 1250, constantan, 850, tin,850, steel,650, lithium,650);
            size = 5;
            consumePower(3f);
            consumeItems(with(silicon,40, constantan, 35, tin, 25, titanium, 20, steel,20));
            health = 1250;
            constructTime = 60f * 20f;
            upgrades.addAll(
                new UnitType[]{twinPistoler, multiPistoler}
            );
        }};
        nuclearUnitFactory = new UnitFactory("nuclear-unit-factory"){{
            requirements(Category.units, with(copper, 500, lead, 450, silicon,250, thorium,100));
            plans = Seq.with(
                new UnitPlan(nuclearTank, 60f * 45, with(copper,750,lead,550,graphite,450,titanium,450, radioalloy,400, uranium,400))
            );
            size = 5;
            health = 1200;
            consumePower(3.0f);
        }};
    }
}
