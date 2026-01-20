package md.content.Blocks;

import mindustry.world.*;
import mindustry.world.blocks.environment.*;

import static md.content.mdItems.*;

public class mdEnvironment {
    public static Block
    oreIron, oreAluminium, oreTin;
    public static void load() {
        oreAluminium = new OreBlock("ore-aluminium"){{
            oreDefault = true;
            oreThreshold = 0.864f;
            oreScale = 24.904762f;
            itemDrop = aluminium;
            localizedName = itemDrop.localizedName;
        }};
        oreIron = new OreBlock("ore-iron"){{
            oreDefault = true;
            oreThreshold = 0.864f;
            oreScale = 24.904762f;
            itemDrop = iron;
            localizedName = itemDrop.localizedName;
        }};
        oreTin = new OreBlock("ore-tin"){{
            oreDefault = true;
            oreThreshold = 0.864f;
            oreScale = 24.904762f;
            itemDrop = tin;
            localizedName = itemDrop.localizedName;
        }};
    }
}
