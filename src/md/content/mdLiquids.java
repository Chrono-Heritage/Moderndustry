package md.content;

import arc.graphics.*;
import mindustry.content.StatusEffects;
import mindustry.type.*;

public class mdLiquids {

    public static Liquid
    /* Gases */
    deuterium, heavyWater, tritium,
    /* Molten Metals */
    moltenAluminium, moltenIron, moltenTin,
    /* Others */
    lava, radioactiveSolution;

    public static void load(){
        /* Gases */
        deuterium = new Liquid("deuterium", Color.valueOf("1B3DA0")){{
            gas = true;
            viscosity = 0.65f;
        }};
        heavyWater = new Liquid("heavy-water", Color.valueOf("1B3DA0")){{
            coolant = false;
        }};
        tritium = new Liquid("tritium", Color.valueOf("617590")){{
            gas = true;
            viscosity = 0.65f;
        }};
        /*Molten Metals */
        moltenAluminium = new Liquid("molten-aluminium", Color.valueOf("BDC7CC")){{
            flammability = 4.0f;
            temperature = 4.0f;
            heatCapacity = 0f;
            viscosity = 0.5f;
            effect = StatusEffects.melting;
            lightColor = Color.valueOf("DEEAEF").a(0.5f);
        }};
        moltenIron = new Liquid("molten-iron", Color.valueOf("D8D8D8")){{
            flammability = 4.0f;
            temperature = 4.0f;
            heatCapacity = 0f;
            viscosity = 0.5f;
            effect = StatusEffects.melting;
            lightColor = Color.valueOf("E0E0E0").a(0.5f);
        }};
        moltenTin = new Liquid("molten-tin", Color.valueOf("CEE3E3")){{
            flammability = 4.0f;
            temperature = 4.0f;
            heatCapacity = 0f;
            viscosity = 0.5f;
            effect = StatusEffects.melting;
            lightColor = Color.valueOf("DAEFEF").a(0.6f);
        }};
        /* Others */
        lava = new Liquid("lava", Color.valueOf("BC3F11")){{
            flammability = 5.0f;
            temperature = 5.0f;
            heatCapacity = 0f;
            viscosity = 0.9f;
            effect = StatusEffects.melting;
            lightColor = Color.valueOf("ed760e").a(0.6f);
        }};
        radioactiveSolution = new Liquid("radioactive-solution", Color.valueOf("B5C103")){{
            explosiveness = 0.75f;
            temperature = 0.4f;
            viscosity = 0.4f;
            heatCapacity = 0.1f;
            coolant = false;
        }};
    };
};