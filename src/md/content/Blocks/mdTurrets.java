package md.content.Blocks;

import arc.graphics.*;
import arc.math.*;
import arc.struct.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.type.StatusEffect.*;
import mindustry.content.StatusEffects.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.DrawPart.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
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
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.liquid.Conduit;
import mindustry.world.blocks.power.SolarGenerator;
import mindustry.world.blocks.storage.Unloader;
import mindustry.world.blocks.units.UnitFactory;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.part.RegionPart;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.world.Block;

import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;
import static mindustry.content.Items.*;
import static mindustry.content.Liquids.*;
import static md.content.mdItems.*;
import static md.content.mdLiquids.*;
import static md.content.mdStatusEffects.*;

public class mdTurrets {
    public static Block 
    antiMaterielSniper, depletedUraniumRifle, heatwave, machineGun, nuclearLaserEmitter, nuclearWeaponLauncher;
    public static void load() {
        antiMaterielSniper = new ItemTurret("anti-materiel-sniper"){{
            requirements(Category.turret, with(copper,175, lead,150, aluminium,125, tin,125, steel,75, constantan,75));
            researchCost = with(copper,2750, lead,2500, aluminium,1750, tin,1750, steel,1250, constantan,1250);
            health = 1250;
            size = 4;
            liquidCapacity = 120;
            buildCostMultiplier = 0.75f;
            reload = 300f;
            maxAmmo = 10;
            range = 600;
            rotateSpeed = 10f;
            recoil = 5f;
            shootSound = Sounds.shootSmite;
            shootCone = 30f;
            shoot = new ShootSpread(2,0);
            coolant = consumeCoolant(0.5f);
            coolantMultiplier = 0.4f;
            ammo(
                bmg,  new PointLaserBulletType(){{
                    speed = 100;
                    scaleLife = true;
                    smokeEffect = Fx.shootBigSmoke;
                    buildingDamageMultiplier = 0.3f;
                    damage = 2750;
                    pierceArmor = true;
                    ammoMultiplier = 1.0f;
                }},
                bmgHE,  new PointLaserBulletType(){{
                    speed = 100;
                    scaleLife = true;
                    smokeEffect = Fx.shootBigSmoke;
                    hitEffect = Fx.explosion;
                    status = StatusEffects.burning;
                    statusDuration = 600;
                    buildingDamageMultiplier = 0.3f;
                    damage = 2000;
                    splashDamage = 2000;
                    splashDamageRadius = 40;
                    pierceArmor = true;
                    ammoMultiplier = 1.0f;
                }},
                bmgNuclear,  new PointLaserBulletType(){{
                    speed = 100;
                    scaleLife = true;
                    smokeEffect = Fx.shootBigSmoke;
                    hitEffect = Fx.blastExplosion;
                    buildingDamageMultiplier = 0.3f;
                    status = radiation;
                    statusDuration = 600;
                    damage = 2000;
                    splashDamage = 1875;
                    splashDamageRadius = 56;
                    pierceArmor = true;
                    ammoMultiplier = 1.0f;
                }}
            );
        }};
        depletedUraniumRifle = new ItemTurret("depleted-uranium-rifle"){{
            requirements(Category.turret, with(copper, 45, lead, 35, metaglass, 20, uranium, 10));
            researchCost = with(copper,850,lead,450,metaglass,300,uranium,175);
            health = 450;
            size = 2;
            reload = 8f;
            maxAmmo = 100;
            range = 240;
            rotateSpeed = 10f;
            inaccuracy = 2f;
            recoil = 2.5f;
            shootSound = Sounds.shootBreach;
            shootCone = 30f;
            shoot = new ShootSpread(1,0);
            ammo(
                lead,  new BasicBulletType(30f, 20){{
                    width = 7f;
                    height = 15f;
                    reloadMultiplier = 1.15f;
                    knockback = 0.5f;
                    lifetime = 60f;
                    ammoMultiplier = 4;
                }},
                metaglass, new BasicBulletType(30f, 30){{
                    width = 10f;
                    height = 18f;
                    ammoMultiplier = 4;
                    lifetime = 60f;
                    fragBullets = 12;
                    fragBullet = new BasicBulletType(30f, 1){{
                        width = 5f;
                        height = 12f;
                        shrinkY = 1f;
                        lifetime = 1f;
                        backColor = Pal.gray;
                        frontColor = Color.white;
                        despawnEffect = Fx.none;
                        collidesGround = true;
                    }};
                }},
                uraniumDepleted, new BasicBulletType(30f, 40){{
                    width = 7f;
                    height = 15f;
                    ammoMultiplier = 6;
                    lifetime = 60f;
                }},
                uraniumDepletedAmmo, new BasicBulletType(30f, 50){{
                    width = 7f;
                    height = 15f;
                    ammoMultiplier = 8;
                    lifetime = 60f;
                    pierceArmor = true;
                    status = radiation;
                    statusDuration = 300;
                }}
            );
            limitRange();
        }};
        heatwave = new LiquidTurret("heatwave"){{
            requirements(Category.turret, with(copper,95, aluminium,55, tin,55, steel,35));
            researchCost = with(copper,1050, aluminium,650, tin,550, steel,450);
            liquidCapacity = 120f;
            buildCostMultiplier = 1.35f;
            size = 3;
            recoil = 0f;
            reload = 2f;
            inaccuracy = 5f;
            shootCone = 70f;
            shootEffect = Fx.shootLiquid;
            range = 128f;
            ammo(
                slag, new LiquidBulletType(Liquids.slag){{
                    damage = 10;
                    speed = 4f;
                    knockback = 1.3f;
                    puddleSize = 8f;
                    orbSize = 4f;
                    drag = 0.001f;
                    statusDuration = 60f * 4f;
                }},
                lava, new LiquidBulletType(lava){{
                    damage = 20;
                    speed = 4f;
                    knockback = 1.3f;
                    puddleSize = 8f;
                    orbSize = 4f;
                    drag = 0.001f;
                    statusDuration = 60f * 4f;
                }}
            );
        }};
        machineGun = new ItemTurret("machine-gun"){{
            requirements(Category.turret, with(copper,105, lead,75, aluminium,55, tin,45, steel,35, constantan,35));
            researchCost = with(copper,1550, lead,1250, aluminium,750, tin,550, steel,450, constantan,450);
            health = 850;
            size = 3;
            liquidCapacity = 120;
            buildCostMultiplier = 0.75f;
            reload = 1f;
            maxAmmo = 200;
            range = 150;
            rotateSpeed = 20f;
            recoil = 3f;
            shootSound = Sounds.shootBreach;
            shootCone = 30f;
            shoot = new ShootSpread(1,0);
            minWarmup = 0.8f;
            coolant = consumeCoolant(0.5f);
            coolantMultiplier = 0.15f;            
            drawer = new DrawTurret(){{
                for(int i = 3; i > 0; i--){
                    parts.add(new RegionPart("-barrel-" + i){{
                        progress = PartProgress.recoil;
                        under = true;
                        moveY = -2f;
                    }});
                }
            }};
            ammo(
                steel, new BasicBulletType(20f,5){{
                    width = 3f;
                    height = 11f;
                    lifetime = 10f;
                    ammoMultiplier = 5;
                }},
                machGunAmmo, new BasicBulletType(20f,10){{
                    width = 3f;
                    height = 11f;
                    lifetime = 10f;
                    ammoMultiplier = 3;
                }}
            );
        }};
        nuclearLaserEmitter = new ItemTurret("nuclear-laser-emitter"){{
            requirements(Category.turret, with(copper, 55, lead, 55, graphite, 35, thorium, 20, uranium, 20, plutonium,20));
            researchCost = with(copper,1150,lead,950,graphite,650,thorium,400,uranium,300,plutonium,200);
            health = 450;
            size = 2;
            reload = 80f;
            maxAmmo = 20;
            range = 256;
            rotateSpeed = 10f;
            recoil = 5f;
            shootSound = Sounds.shootLancer;
            shootCone = 30f;
            shoot = new ShootSpread(1,0);
            ammo(
                thorium,  new LaserBulletType(150){{
                    colors = new Color[]{Color.valueOf("CB8EBF"), Color.valueOf("F8A3C7"), Color.white};
                    length = 342;
                    width = 17;
                    ammoMultiplier = 1.0f;
                    knockback = 0.5f;
                    status = radiation;
                    statusDuration = 600;
                    pierceCap = 2;
                }},
                uranium, new LaserBulletType(200){{
                    colors = new Color[]{Color.valueOf("218A21"), Color.valueOf("32CD32"), Color.white};
                    length = 342;
                    width = 17;
                    ammoMultiplier = 2.0f;
                    knockback = 0.75f;
                    status = radiation;
                    statusDuration = 600;
                    pierceCap = 3;
                }},
                plutonium, new LaserBulletType(250){{
                    colors = new Color[]{Color.valueOf("B22222"), Color.valueOf("DC143C"), Color.white};
                    length = 342;
                    width = 17;
                    ammoMultiplier = 2.0f;
                    knockback = 1.0f;
                    status = radiation;
                    statusDuration = 600;
                    pierceCap = 3;
                }}
            );
        }};
    }
}
