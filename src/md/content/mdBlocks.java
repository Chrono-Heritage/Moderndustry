package md.content;

import md.content.Blocks.mdCrafting;
import md.content.Blocks.mdDefence;
import md.content.Blocks.mdDistribution;
import md.content.Blocks.mdEnvironment;
import md.content.Blocks.mdMisc;
import md.content.Blocks.mdPower;
import md.content.Blocks.mdProduction;
import md.content.Blocks.mdTurrets;
import md.content.Blocks.mdUnits;


public class mdBlocks{
    public static void load() {
        mdCrafting.load();
        mdDefence.load();
        mdDistribution.load();
        mdEnvironment.load();
        mdMisc.load();
        mdPower.load();
        mdProduction.load();
        mdTurrets.load();
        mdUnits.load();
    }
};