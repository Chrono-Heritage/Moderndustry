package md.content.Blocks;

import arc.graphics.*;
import mindustry.type.*;
import mindustry.world.blocks.defense.*;

import static mindustry.type.ItemStack.*;
import static mindustry.content.Items.*;
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
