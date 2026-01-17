package md.content.Blocks;

import arc.graphics.*;
import arc.math.*;
import arc.struct.*;
import mindustry.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.DrawPart.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.game.*;
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
import multicraft.*;


import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;
import static mindustry.content.Items.*;
import static mindustry.content.Liquids.*;
import static mindustry.content.StatusEffects.*;
import static md.content.mdLiquids.*;
import static md.content.mdItems.*;

public class mdDistribution {
    public static Block 
    aluminiumConduit, nuclearMassDriver,tinDuct, tinDuctBridge;

    public static void load() {
        aluminiumConduit = new Conduit("aluminium-conduit"){{
            requirements(Category.liquid, with(aluminium,1, titanium,1, metaglass,1));
            researchCost = with(tin,200, metaglass,200, aluminium,200);
            health = 120;
            liquidCapacity = 30f;
            liquidPressure = 1.5f;
        }};
        nuclearMassDriver = new MassDriver("nuclear-mass-driver"){{
            requirements(Category.distribution, with(copper, 300, graphite, 200, silicon, 125, uranium, 55));
            researchCost = with(copper,1500,graphite,750,silicon,550,uranium,400);
            itemCapacity = 240;
            liquidCapacity = 120;
            health = 750;
            size = 3;
            buildCostMultiplier = 0.4f;
            hasPower = true;
            hasItems = true;
            range = 880;
            rotateSpeed = 20;
            bulletSpeed = 11.0f;
            bulletLifetime = 300;
            shake = 1.0f;
            minDistribute = 1;

            consumePower(6.0f);
        }};
        tinDuct = new Duct("tin-duct"){{
            requirements(Category.distribution, with(copper,1, metaglass,1, tin,1));
            researchCost = with(copper,200, metaglass,200, tin,200);
            health = 120;
            speed = 3.5f;
            itemCapacity = 5;
        }};
        tinDuctBridge = new DuctBridge("tin-duct-bridge"){{
            requirements(Category.distribution, with(copper,20, tin,20, constantan,10, aluminium,10));
            researchCost = with(copper,200, metaglass,200, tin,200);
            health = 160;
            speed = 3.5f;
            range = 20;
        }};
    }
}
