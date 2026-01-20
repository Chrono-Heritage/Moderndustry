package md.content;

import arc.graphics.*;
import mindustry.content.*;
import mindustry.graphics.*;
import mindustry.type.*;

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
