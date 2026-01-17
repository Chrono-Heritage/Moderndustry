package md.content;

import arc.math.geom.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.*;
import mindustry.entities.part.DrawPart.PartProgress;
import mindustry.entities.pattern.*;
import mindustry.content.Fx;
import mindustry.gen.*;
import mindustry.type.unit.*;
import arc.graphics.Blending;
import arc.graphics.Color;
import mindustry.ai.types.BuilderAI;
import mindustry.ai.types.GroundAI;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import arc.Core;
import arc.graphics.Blending;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Angles;
import arc.math.Mathf;
import arc.scene.ui.layout.Table;
import arc.struct.ObjectSet;
import arc.struct.Seq;
import arc.util.Time;
import arc.util.Tmp;
import md.mdLoader.*;
import mindustry.*;
import mindustry.ai.UnitCommand;
import mindustry.ai.types.FlyingFollowAI;
import mindustry.content.*;
import mindustry.entities.Effect;
import mindustry.entities.Lightning;
import mindustry.entities.Mover;
import mindustry.entities.Units;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.ExplosionEffect;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.*;
import mindustry.graphics.Drawf;
import mindustry.maps.*;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.ammo.ItemAmmoType;
import mindustry.type.ammo.PowerAmmoType;
import mindustry.type.unit.TankUnitType;
import mindustry.type.weapons.PointDefenseWeapon;
import mindustry.type.weapons.RepairBeamWeapon;
import mindustry.world.blocks.defense.MendProjector;
import mindustry.world.blocks.defense.RegenProjector;
import mindustry.world.meta.Env;
import mindustry.Category.*;

import static mindustry.content.Fx.rand;
import static mindustry.content.Fx.turbinegenerate;

import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.*;
import static mindustry.Vars.*;
import static md.content.mdStatusEffects.*;
import static md.mdLoader.*;

public class mdUnitTypes {
    static {
        EntityMapping.nameMap.put("chrono-moderndustry-nuclear-tank", EntityMapping.idMap[43]);
        EntityMapping.nameMap.put("chrono-moderndustry-pistoler", EntityMapping.idMap[4]);
        EntityMapping.nameMap.put("chrono-moderndustry-twin-pistoler", EntityMapping.idMap[4]);
        EntityMapping.nameMap.put("chrono-moderndustry-multi-pistoler", EntityMapping.idMap[4]);
    }

    public static UnitType
        /* Core Unit */
        neutron,
        /* Normal Units */
        nuclearTank, pistoler, twinPistoler, multiPistoler;
    public static void load(){
        neutron = new UnitType("neutron"){{
            constructor = UnitEntity::create;
            aiController = BuilderAI::new;
            isEnemy = false;
            flying = true;
            mineSpeed = 12.0f;
            mineTier = 3;
            buildSpeed = 1.75f;
            drag = 0.1f;
            speed = 4f;
            rotateSpeed = 30f;
            accel = 0.3f;
            itemCapacity = 120;
            health = 300f;
            engineOffset = 9f;
            hitSize = 12f;

            weapons.add(new Weapon("basic-nuclear-laser"){{
                shoot = new ShootSpread(){{
                    shots = 1;
                    spread = 0f;
                }};
                reload = 60f;
                x = 0;
                y = 5;
                mirror = false;
                rotate = false;
                continuous = true;
                shootSound = Sounds.shootLancer;
                bullet = new ContinuousLaserBulletType(20){{
                    width = 3f;
                    length = 80f;
                    lifetime = 180f;
                    status = radiation;
                    colors = new Color[]{Color.valueOf("218A21"), Color.valueOf("32CD32"), Color.white};
                    collidesTeam = false;
                    buildingDamageMultiplier = 0.01f;
                }};
            }});
            loopSound = Sounds.none;
        }};
        nuclearTank = new TankUnitType("nuclear-tank"){{
            previewRegion = Core.atlas.find(name + "-preview");
            flying = false;
            hitSize = 46f;
            treadPullOffset = 1;
            speed = 0.75f;
            health = 23500;
            armor = 30f;
            crushDamage = 25f / 5f;
            rotateSpeed = 1.5f;

            float xo = 231f/2f, yo = 231f/2f;
            treadRects = new Rect[]{new Rect(27 - xo, 152 - yo, 56, 73), new Rect(24 - xo, 51 - 9 - yo, 29, 17), new Rect(59 - xo, 18 - 9 - yo, 39, 19)};

            weapons.add(new Weapon("chrono-moderndustry-main-cannon"){{
                shootSound = Sounds.shootConquer;
                layerOffset = 0.1f;
                reload = 100f;
                shootY = 32.5f;
                shake = 5f;
                recoil = 5f;
                rotate = true;
                rotateSpeed = 1f;
                mirror = false;
                x = 0f;
                y = -2f;
                shadow = 50f;
                heatColor = Color.valueOf("f9350f");
                shootWarmupSpeed = 0.06f;
                cooldownTime = 110f;
                heatColor = Color.valueOf("f9350f");
                minWarmup = 0.9f;

                parts.addAll(
                new RegionPart("-glow"){{
                    color = Color.red;
                    blending = Blending.additive;
                    outline = mirror = false;
                }},
                new RegionPart("-sides"){{
                    progress = PartProgress.warmup;
                    mirror = true;
                    under = true;
                    moveX = 0.75f;
                    moveY = 0.75f;
                    moveRot = 82f;
                    x = 37 / 4f;
                    y = 8 / 4f;
                }},
                new RegionPart("-sinks"){{
                    progress = PartProgress.warmup;
                    mirror = true;
                    under = true;
                    heatColor = new Color(1f, 0.1f, 0.1f);
                    moveX = 17f / 4f;
                    moveY = -15f / 4f;
                    x = 32 / 4f;
                    y = -34 / 4f;
                }},
                new RegionPart("-sinks-heat"){{
                    blending = Blending.additive;
                    progress = PartProgress.warmup;
                    mirror = true;
                    outline = false;
                    colorTo = new Color(1f, 0f, 0f, 0.5f);
                    color = colorTo.cpy().a(0f);
                    moveX = 17f / 4f;
                    moveY = -15f / 4f;
                    x = 32 / 4f;
                    y = -34 / 4f;
                }}
                );

                for(int i = 1; i <= 3; i++){
                    int fi = i;
                    parts.add(new RegionPart("-blade"){{
                        progress = PartProgress.warmup.delay((3 - fi) * 0.3f).blend(PartProgress.reload, 0.3f);
                        heatProgress = PartProgress.heat.add(0.3f).min(PartProgress.warmup);
                        heatColor = new Color(1f, 0.1f, 0.1f);
                        mirror = true;
                        under = true;
                        moveRot = -40f * fi;
                        moveX = 3f;
                        layerOffset = -0.002f;

                        x = 11 / 4f;
                    }});
                }

                bullet = new BasicBulletType(8f, 360f){{
                    sprite = "missile-large";
                    width = 12f;
                    height = 25f;
                    lifetime = 35f;
                    hitSize = 6f;

                    smokeEffect = Fx.shootSmokeTitan;
                    pierceCap = 3;
                    pierce = true;
                    pierceBuilding = true;
                    hitColor = backColor = trailColor = Color.valueOf("feb380");
                    frontColor = Color.white;
                    trailWidth = 4f;
                    trailLength = 9;
                    hitEffect = despawnEffect = Fx.massiveExplosion;
                    fragBullets = 12;
                    fragBullet = new BasicBulletType(30f, 150){{
                        width = 8f;
                        height = 15f;
                        shrinkY = 1f;
                        lifetime = 2f;
                        backColor = Pal.gray;
                        frontColor = Color.white;
                        despawnEffect = Fx.none;
                        collidesGround = true;
                    }};

                    shootEffect = new ExplosionEffect(){{
                        lifetime = 40f;
                        waveStroke = 4f;
                        waveColor = sparkColor = trailColor;
                        waveRad = 15f;
                        smokeSize = 5f;
                        smokes = 8;
                        smokeSizeBase = 0f;
                        smokeColor = trailColor;
                        sparks = 8;
                        sparkRad = 40f;
                        sparkLen = 4f;
                        sparkStroke = 3f;
                    }};
                }};
            }});
            weapons.add(new Weapon("chrono-moderndustry-secondary-machine-turret"){{
                shoot = new ShootSpread(){{
                    shots = 1;
                    spread = 1f;
                }};
                reload = 6f;
                x = 15;
                y = 0;
                mirror = true;
                rotate = true;
                rotateSpeed = 3f; 
                bullet = new BasicBulletType(25f,24){{
                    width = 8f;
                    height = 17f;
                    lifetime = 10f;
                    status = radiation;
                    frontColor = Color.valueOf("249624");
                    backColor = Color.valueOf("218A21");
                    lightColor = Color.valueOf("32CD32");
                    collidesTeam = false;
                    pierceArmor = true;
                }};
            }});
            weapons.add(new Weapon("chrono-moderndustry-secondary-machine-turret"){{
                shoot = new ShootSpread(){{
                    shots = 1;
                    spread = 1f;
                }};
                reload = 6f;
                x = 7;
                y = -7;
                mirror = true;
                rotate = true;
                rotateSpeed = 3f; 
                bullet = new BasicBulletType(25f,24){{
                    width = 8f;
                    height = 17f;
                    lifetime = 10f;
                    status = radiation;
                    frontColor = Color.valueOf("249624");
                    backColor = Color.valueOf("218A21");
                    lightColor = Color.valueOf("32CD32");
                    collidesTeam = false;
                    pierceArmor = true;
                }};
            }});
            parts.add(new RegionPart("-glow"){{
                color = Color.red;
                blending = Blending.additive;
                layer = -1f;
                outline = false;
            }});
        }};
        pistoler = new UnitType("pistoler"){{
            previewRegion = Core.atlas.find(name + "-preview");
            flying = false;
            speed = 0.6f;
            hitSize = 9f;
            health = 250;
            weapons.add(new Weapon("chrono-moderndustry-pistol"){{
                reload = 30f;
                x = 4f;
                y = 2f;
                top = false;
                rotate = false;
                mirror = false;
                ejectEffect = Fx.casing1;
                bullet = new BasicBulletType(3.25f, 15){{
                    width = 7f;
                    height = 9f;
                    lifetime = 50f;
                }};
            }});
        }};
        twinPistoler = new UnitType("twin-pistoler"){{
            previewRegion = Core.atlas.find(name + "-preview");
            speed = 0.5f;
            hitSize = 10f;
            health = 350;
            weapons.add(new Weapon("chrono-moderndustry-pistolBig"){{
                reload = 30f;
                x = 6f;
                y = 3f;
                top = false;
                rotate = false;
                mirror = true;
                ejectEffect = Fx.casing1;
                bullet = new BasicBulletType(3.25f, 15){{
                    width = 8f;
                    height = 10f;
                    lifetime = 50f;
                }};
            }});
        }};
        multiPistoler = new UnitType("multi-pistoler"){{
            previewRegion = Core.atlas.find(name + "-preview");
            speed = 0.45f;
            hitSize = 13f;
            rotateSpeed = 3f;
            health = 900;
            armor = 9f;
            mechFrontSway = 0.55f;
            weapons.add(new Weapon("chrono-moderndustry-pistolBigger"){{
                reload = 20f;
                y = 1f;
                x = 9f;
                top = false;
                rotate = false;
                recoil = 4f;
                shake = 2f;
                ejectEffect = Fx.casing2;
                bullet = new ArtilleryBulletType(3f, 40){{
                    width = 9f;
                    height = 11f;
                    lifetime = 60f;
                }};
            }});
            weapons.add(new Weapon("chrono-mordendustry-pistolBig"){{
                reload = 25f;
                x = 4f;
                y = 2f;
                top = false;
                rotate = false;
                ejectEffect = Fx.casing1;
                bullet = new BasicBulletType(3.25f, 30){{
                    width = 7f;
                    height = 9f;
                    lifetime = 50f;
                }};
            }});
        }};
    }
}
            
