package md.content;

import arc.graphics.*;
import mindustry.type.*;

public class mdItems {

    public static Item
    /* Base Metals */
    aluminium, iron, lithium, nickel, silver, tin, plutonium, uranium,
    /* Alloys */
    bronze, constantan, steel, radioalloy,
    /* Ammo */
    bmgHE, bmgNuclear, bmg, machGunAmmo,
    /* Nuclear Products */
    plutonium239, uranium235, uranium238, uraniumEnriched, uraniumDepleted, uraniumDepletedAmmo, uraniumFuel,
    /* Others */
    stone, salt,
    /* Ores */
    rawAluminium, rawIron, rawTin;
    public static void load() {
        /* Base Metals */
        aluminium  = new Item("aluminium", Color.valueOf("BDC7CC")){{
            charge = 0.5f;
            cost = 0.7f;
            hardness = 2;
        }};    
        iron  = new Item("iron", Color.valueOf("D8D8D8")){{
            charge = 1.0f;
            hardness = 2;
        }};       
        lithium  = new Item("lithium", Color.valueOf("FFFFFF")){{
            charge = 0.65f;
            cost = 0.85f;
            hardness = 2;
        }};    
        nickel  = new Item("nickel", Color.valueOf("C6C38B")){{
            charge = 0.1f;
            cost = 1.1f;
            hardness = 3;
        }};      
        silver  = new Item("silver", Color.valueOf("DBF0F3")){{
            charge = 0.1f;
            cost = 1.0f;
            hardness = 3;
        }};   
        tin  = new Item("tin", Color.valueOf("CEE3E3")){{
            charge = 0.1f;
            cost = 0.5f;
            hardness = 1;
        }};     
        plutonium = new Item("plutonium", Color.valueOf("FF0000")){{
            radioactivity = 0.9f;
            hardness = 4;
        }};
        uranium  = new Item("uranium", Color.valueOf("32CD32")){{
            radioactivity = 0.75f;
            hardness = 4;
        }};       
        /* Alloys */
        bronze  = new Item("bronze", Color.valueOf("FFC478")){{
            charge = 0.2f;
            cost = 1.1f;
        }};     
        constantan  = new Item("constantan", Color.valueOf("FAD37C")){{
            charge = 0.75f;
            cost = 1.2f;
        }};     
        steel  = new Item("steel", Color.valueOf("A6A6A6")){{
            charge = 0.5f;
            cost = 1.5f;
        }};  
        radioalloy = new Item("radioalloy", Color.valueOf("B5C103")){{
        }};
        /* Ammo */
        bmg  = new Item(".50-bmg", Color.valueOf("3F3F3F")){{
            explosiveness = 0.1f;
            flammability = 0.1f;
            buildable = false;
        }};
        bmgHE  = new Item(".50-bmg-he", Color.valueOf("FF0F33")){{
            explosiveness = 1.0f;
            flammability = 0.5f;
            buildable = false;
        }};  
        bmgNuclear  = new Item(".50-bmg-nuclear", Color.valueOf("33BF31")){{
            explosiveness = 1.0f;
            flammability = 1.0f;
            radioactivity = 1.0f;
            buildable = false;
        }};  
        machGunAmmo = new Item("machine-gun-ammo", Color.valueOf("3F3F3F")){{
            explosiveness = 0.1f;
            flammability = 0.1f;
            buildable = false;
        }};
        /* Nuclear Products */
        plutonium239 = new Item("plutonium239", Color.valueOf("FF0000")){{
            radioactivity = 0.9f;
        }};
        uranium235 = new Item("uranium235", Color.valueOf("32CD32")){{
            radioactivity = 1.0f;
            explosiveness = 0.5f;
        }};
        uranium238 = new Item("uranium238", Color.valueOf("32CD32")){{
            radioactivity = 0.9f;
        }};
        uraniumEnriched = new Item("uranium-enriched", Color.valueOf("29FF29")){{
            radioactivity = 1.5f;
        }};
        uraniumDepleted = new Item("uranium-depleted", Color.valueOf("218A21")){{
            radioactivity = 0.25f;
        }};
        uraniumDepletedAmmo = new Item("uranium-depleted-ammo", Color.valueOf("218A21")){{
            explosiveness = 0.2f;
            flammability = 0.75f;
        }};
        uraniumFuel = new Item("uranium-fuel", Color.valueOf("29FF29")){{
            explosiveness = 0.1f;
            radioactivity = 1.15f;
        }};
        /* Others */
        stone  = new Item("stone", Color.valueOf("8C8C8C")){{
            cost = 0.1f;
            lowPriority = true;
            buildable = false;
        }};   
        salt = new Item("salt", Color.valueOf("FFFFFF")){{
        }};
        /* Ores */ 
        rawAluminium = new Item("raw-aluminium", Color.valueOf("BDC7CC")){{
            hardness = 2;
            buildable = false;
        }};
        rawIron = new Item("raw-iron", Color.valueOf("D8D8D8")){{
            hardness = 2;
            buildable = false;
        }};
        rawTin = new Item("raw-tin", Color.valueOf("CEE3E3")){{
            hardness = 1;
            buildable = false;
        }};
    };
};