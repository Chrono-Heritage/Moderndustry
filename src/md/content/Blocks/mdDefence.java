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


import mindustry.world.Block;

public class mdDefence {
    public static Block
    bronzeWall, bronzeWallLarge, ironWall, ironWallLarge, radioalloyWall,radioalloyWallLarge, steelWall, steelWallLarge;

    public static void load() {
        bronzeWall = new Wall("bronze-wall"){{
            requirements(Category.defense, with(bronze, 10));
            health = 650;
            researchCostMultiplier = 20f;
        }};
        bronzeWallLarge = new Wall("bronze-wall-large"){{
            requirements(Category.defense, with(bronze, 40));
            health = 2925;
            size = 2;
            researchCostMultiplier = 20f;
        }};
        ironWall = new Wall("iron-wall"){{
            requirements(Category.defense, with(iron, 10));
            health = 500;
            researchCostMultiplier = 20f;
        }};
        ironWallLarge = new Wall("iron-wall-large"){{
            requirements(Category.defense, with(iron, 40));
            health = 2250;
            size = 2;
            researchCostMultiplier = 20f;
        }};
        radioalloyWall = new Wall("radioalloy-wall"){{
            requirements(Category.defense, with(radioalloy, 10, thorium, 4));
            health = 1250;
            lightningChance = 0.1f;
            lightningDamage = 40;
            lightningLength = 10;
            lightningColor = Color.valueOf("B5C103");
            absorbLasers = true;
            buildCostMultiplier = 1.25f;
            researchCostMultiplier = 150f;
        }};

        radioalloyWallLarge = new Wall("radioalloy-wall-large"){{
            requirements(Category.defense, ItemStack.mult(radioalloyWall.requirements, 4));
            health = 5000;
            size = 2;
            lightningChance = 0.25f;
            lightningDamage = 75;
            lightningLength = 20;
            lightningColor = Color.valueOf("B5C103");
            absorbLasers = true;
            buildCostMultiplier = 2.0f;
            researchCostMultiplier = 150f;
        }};
        steelWall = new Wall("steel-wall"){{
            requirements(Category.defense, with(steel, 10));
            health = 750;
            researchCostMultiplier = 20f;
        }};
        steelWallLarge = new Wall("steel-wall-large"){{
            requirements(Category.defense, with(steel, 40));
            health = 3375;
            size = 2;
            researchCostMultiplier = 20f;
        }};

    }
}
