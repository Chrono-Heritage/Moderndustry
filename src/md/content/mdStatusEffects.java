package md.content;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.util.*;
import mindustry.content.*;
import mindustry.entities.abilities.*;
import mindustry.entities.units.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.meta.*;

import static mindustry.Vars.*;

import static mindustry.Vars.*;
import static mindustry.type.StatusEffect.*;

public class mdStatusEffects {
    public static StatusEffect 
    radiation
    ;
    public static void load(){
        radiation = new StatusEffect("radiation"){{
            color = Color.valueOf("29FF29");
            speedMultiplier = 0.65f;
            damageMultiplier = 0.6f;
            reloadMultiplier = 0.65f;
            damage = 0.4f;
            healthMultiplier = 0.75f;
            effect = Fx.burning;
            color = Pal.heal;
            
        }};
    };
}
