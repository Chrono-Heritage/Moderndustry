package md;

import md.content.*;
import mindustry.mod.Mod;
import mindustry.content.Blocks;

public class mdLoader extends Mod{
    public mdLoader(){
    }

    @Override
    public void loadContent(){
        mdItems.load();
        mdLiquids.load();
        mdStatusEffects.load();
        mdUnitTypes.load();
        mdBlocks.load();
       /* mdTechTree.load(); */

        //Make stone and related blocks unmineable and drop Stone
        (Blocks.stone).itemDrop = mdItems.stone;
        (Blocks.stone).playerUnmineable = true;
        (Blocks.craters).itemDrop = mdItems.stone;
        (Blocks.craters).playerUnmineable = true;
        (Blocks.charr).itemDrop = mdItems.stone;
        (Blocks.charr).playerUnmineable = true;
        (Blocks.basalt).itemDrop = mdItems.stone;
        (Blocks.basalt).playerUnmineable = true;
    };
}