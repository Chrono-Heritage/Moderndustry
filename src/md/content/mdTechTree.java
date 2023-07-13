package md.content;

import arc.func.*;
import arc.struct.*;
import mindustry.content.*;
import mindustry.ctype.*;
import mindustry.game.Objectives.*;
import mindustry.type.*;
import mindustry.world.Block;
import md.content.Blocks.mdCrafting;

import static mindustry.content.Blocks.*;
import static mindustry.content.Items.*;
import static mindustry.content.TechTree.*;
import static mindustry.content.UnitTypes.*;
import static md.content.mdItems.*;
import static md.content.mdLiquids.*;
import static md.content.Blocks.mdCrafting.*;
import static md.content.Blocks.mdDefence.*;
import static md.content.Blocks.mdDistribution.*;
import static md.content.Blocks.mdMisc.*;
import static md.content.Blocks.mdPower.*;
import static md.content.Blocks.mdProduction.*;
import static md.content.Blocks.mdTurrets.*;
import static md.content.Blocks.mdUnits.*;

public class mdTechTree {

public static void load(){
    nodeRoot("Moderndustry", coreShard, false, () -> {
        node(radioactiveSolution, ItemStack.with(), () -> {
            node(plutonium, () -> {
                node(plutonium239);
            });
            node(uranium, () -> {
                node(uranium235, () -> {
                    node(uranium238, () -> {
                        node(uraniumEnriched, () -> {
                            node(uraniumFuel);
                            node(uraniumDepleted, () -> {
                                node(uraniumDepletedAmmo);
                            });
                        });
                    });
                });
            });
        });
            node(radioalloy);
        node(coreNuclear, () -> {});
        node(radioactiveLiquefier, () ->{
            node(radioactiveSeparator, () -> {
                node(radioactiveSmelter,() -> {});
                node(isotopeSeparator,() -> {
                    node(plutonium239Producer,() -> {});
                    node(enrichedUraniumCrafter, () -> {
                        node(fissionFuelInfuser,() -> {});
                        node(duAmmoConstructer,() -> {});
                });
                });
            });
        });
        node(nuclearFurnace, () -> {
            node(fissionReactor, () ->{});
            node(pressurizedHeavyWaterReactor, () -> {
                node(fusionReactor,() ->{});
        });
    });
        node(heavyWaterExtractor,() -> {
            node(saltExtractor,() -> {
                node(mdCrafting.electrolyzer,() ->{});
                node(heavyWater,() -> {
                    node(mdItems.salt);
                    node(deuterium,() -> {
                        node(tritium);
                    });
                });
            });
        });
        node(depletedUraniumRifle,() -> {
            node(nuclearLaserEmitter,() ->{});
        });
        node(radioalloyWall,() -> {
            node(radioalloyWallLarge);
        });
        node(nuclearMassDriver,() -> {});
        node(nuclearOverdriver,() -> {});
        node(nuclearDrill,() -> {});
        node(nuclearPump,() -> {});
        node(nuclearUnitFactory);
        node(rawAluminium, () ->{
            node(rawIron, ()-> {
                node(rawTin);
        });
        });
        node(aluminium, () -> {
            node(iron, () -> {
                node(lithium, () -> {
                    node(nickel, () -> {
                        node(constantan);
                        node(silver, () -> {
                            node(tin, () -> {
                                node(bronze);
                            });
                        });
                    });
                });
                node(steel);
            });
        });
        node(bmg, () ->{
            node(bmgHE, () -> {
                node(bmgNuclear);
            });
        });
        node(heatwave,() -> {
            node(antiMaterielSniper);
        });
        node(ironWall, () ->{
            node(ironWallLarge);
            node(bronzeWall, () -> {
                node(bronzeWallLarge);
                node(steelWall, () -> {
                    node(steelWallLarge);
                });
            });
        });
        node(aluminiumConduit);
        node(tinDuct, () ->{
            node(tinDuctBridge);
        });
        node(lithiumBattery,() ->{
            node(lithiumBatteryLarge);
        });
        node(slagMixer, () -> {
            node(metalSeparator, () -> {
                node(ammoCrafter);
                node(alloyFurnance);
            });
        });
        node(mdItems.stone, () -> {
            node(stoneMelter, () -> {
                node(lavaHeater);
                node(heatGenerator);
            });
        });
        node(oreMelter, () -> {
            node(metalFormer);
            node(moltenAluminium);
            node(moltenIron);
            node(moltenTin);
        });
        });
};
}

