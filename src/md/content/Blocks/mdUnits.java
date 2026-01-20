package md.content.Blocks;

import arc.struct.*;
import mindustry.type.*;
import mindustry.world.blocks.units.*;
import mindustry.world.Block;

import static mindustry.type.ItemStack.*;
import static mindustry.content.Items.*;
import static md.content.mdItems.*;
import static md.content.mdUnitTypes.*;

public class mdUnits {
    public static Block 
    metalUnitFactory, metalT2Reconstructor, metalT3Reconstructor, nuclearUnitFactory;
    public static void load() {
        metalUnitFactory = new UnitFactory("metal-unit-factory"){{
            requirements(Category.units, with(copper, 105, lead, 55, iron,30, tin,30));
            researchCost = with(copper, 850, lead, 650, iron,500, tin,500);
            plans = Seq.with(
                new UnitPlan(pistoler, 60f * 10, with(lead,10, iron,5, aluminium,3))
            );
            size = 3;
            health = 750;
            consumePower(0.5f);
        }};
        metalT2Reconstructor = new Reconstructor("metal-t2-reconstructor"){{
            requirements(Category.units, with(copper, 145, silicon, 75, tin,75, steel,45));
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
            requirements(Category.units, with(copper, 255, lead, 245, silicon, 135, tin,95, steel,75, lithium,75));
            researchCost = with(copper, 2150, lead, 1750, silicon, 1250, tin,850, steel,650, lithium,650);
            size = 5;
            consumePower(3f);
            consumeItems(with(silicon,40, constantan, 35, tin, 25, steel,20));
            health = 1250;
            constructTime = 60f * 20f;
            upgrades.addAll(
                new UnitType[]{twinPistoler, multiPistoler}
            );
        }};
        nuclearUnitFactory = new UnitFactory("nuclear-unit-factory"){{
            requirements(Category.units, with(copper, 300, lead, 250, silicon,150, thorium,100));
            plans = Seq.with(
                new UnitPlan(nuclearTank, 60f * 45, with(copper,500,lead,400,graphite,350,titanium,350, radioalloy,400, uranium,400))
            );
            size = 5;
            health = 1200;
            consumePower(3f);
        }};
    }
}
