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

public class mdEnvironment {
    public static Block
    oreIron, oreAluminium, oreTin;
    public static void load() {
        oreAluminium = new OreBlock("ore-aluminium"){{
            oreDefault = true;
            oreThreshold = 0.864f;
            oreScale = 24.904762f;
            itemDrop = rawAluminium;
            localizedName = itemDrop.localizedName;
        }};
        oreIron = new OreBlock("ore-iron"){{
            oreDefault = true;
            oreThreshold = 0.864f;
            oreScale = 24.904762f;
            itemDrop = rawIron;
            localizedName = itemDrop.localizedName;
        }};
        oreTin = new OreBlock("ore-tin"){{
            oreDefault = true;
            oreThreshold = 0.864f;
            oreScale = 24.904762f;
            itemDrop = rawTin;
            localizedName = itemDrop.localizedName;
        }};
    }
}
