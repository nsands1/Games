package CodeAMonFactory;
import java.util.ArrayList;
/**
  * TypesChart.java
  * Description: File for the CodeAMon types and their points for attackBonus of Type vs. Type.
  * Author: nsands1@asu.edu
  * Created: 11/21/22
  * Modified: 11/23/22
  */
public class TypesChart {

    public static final ArrayList<Types> codeAmonTypes = new ArrayList<>(18);
    public static final Double[][] attackBonusList = new Double[18][18];

    public TypesChart() {
        codeAmonTypes.add(Types.NORMAL);
        codeAmonTypes.add(Types.FIRE);
        codeAmonTypes.add(Types.WATER);
        codeAmonTypes.add(Types.GRASS);
        codeAmonTypes.add(Types.ELECTRIC);
        codeAmonTypes.add(Types.ICE);
        codeAmonTypes.add(Types.FIGHTING);
        codeAmonTypes.add(Types.POISON);
        codeAmonTypes.add(Types.GROUND);
        codeAmonTypes.add(Types.FLYING);
        codeAmonTypes.add(Types.PSYCHIC);
        codeAmonTypes.add(Types.BUG);
        codeAmonTypes.add(Types.ROCK);
        codeAmonTypes.add(Types.GHOST);
        codeAmonTypes.add(Types.DRAGON);
        codeAmonTypes.add(Types.DARK);
        codeAmonTypes.add(Types.STEEL);
        codeAmonTypes.add(Types.FAIRY);

        int tI = 0; //typeIndex
        System.out.println("Adding: Normal Attack Bonuses to the CodeAMonFactory.TypesChart.");
        attackBonusList[tI][0] = Types.NORMAL.getNormalAB();
        attackBonusList[tI][1] = Types.NORMAL.getFireAB();
        attackBonusList[tI][2] = Types.NORMAL.getWaterAB();
        attackBonusList[tI][3] = Types.NORMAL.getGrassAB();
        attackBonusList[tI][4] = Types.NORMAL.getElectricAB();
        attackBonusList[tI][5] = Types.NORMAL.getIceAB();
        attackBonusList[tI][6] = Types.NORMAL.getFightingAB();
        attackBonusList[tI][7] = Types.NORMAL.getPoisonAB();
        attackBonusList[tI][8] = Types.NORMAL.getGroundAB();
        attackBonusList[tI][9] = Types.NORMAL.getFlyingAB();
        attackBonusList[tI][10] = Types.NORMAL.getPsychicAB();
        attackBonusList[tI][11] = Types.NORMAL.getBugAB();
        attackBonusList[tI][12] = Types.NORMAL.getRockAB();
        attackBonusList[tI][13] = Types.NORMAL.getGhostAB();
        attackBonusList[tI][14] = Types.NORMAL.getDragonAB();
        attackBonusList[tI][15] = Types.NORMAL.getDarkAB();
        attackBonusList[tI][16] = Types.NORMAL.getSteelAB();
        attackBonusList[tI][17] = Types.NORMAL.getFairyAB();
        tI++;
        System.out.println("Adding: FIRE Attack Bonuses to the CodeAMonFactory.TypesChart.");
        attackBonusList[tI][0] = Types.FIRE.getNormalAB();
        attackBonusList[tI][1] = Types.FIRE.getFireAB();
        attackBonusList[tI][2] = Types.FIRE.getWaterAB();
        attackBonusList[tI][3] = Types.FIRE.getGrassAB();
        attackBonusList[tI][4] = Types.FIRE.getElectricAB();
        attackBonusList[tI][5] = Types.FIRE.getIceAB();
        attackBonusList[tI][6] = Types.FIRE.getFightingAB();
        attackBonusList[tI][7] = Types.FIRE.getPoisonAB();
        attackBonusList[tI][8] = Types.FIRE.getGroundAB();
        attackBonusList[tI][9] = Types.FIRE.getFlyingAB();
        attackBonusList[tI][10] = Types.FIRE.getPsychicAB();
        attackBonusList[tI][11] = Types.FIRE.getBugAB();
        attackBonusList[tI][12] = Types.FIRE.getRockAB();
        attackBonusList[tI][13] = Types.FIRE.getGhostAB();
        attackBonusList[tI][14] = Types.FIRE.getDragonAB();
        attackBonusList[tI][15] = Types.FIRE.getDarkAB();
        attackBonusList[tI][16] = Types.FIRE.getSteelAB();
        attackBonusList[tI][17] = Types.FIRE.getFairyAB();
        tI++;
        System.out.println("Adding: WATER Attack Bonuses to the CodeAMonFactory.TypesChart.");
        attackBonusList[tI][0] = Types.WATER.getNormalAB();
        attackBonusList[tI][1] = Types.WATER.getFireAB();
        attackBonusList[tI][2] = Types.WATER.getWaterAB();
        attackBonusList[tI][3] = Types.WATER.getGrassAB();
        attackBonusList[tI][4] = Types.WATER.getElectricAB();
        attackBonusList[tI][5] = Types.WATER.getIceAB();
        attackBonusList[tI][6] = Types.WATER.getFightingAB();
        attackBonusList[tI][7] = Types.WATER.getPoisonAB();
        attackBonusList[tI][8] = Types.WATER.getGroundAB();
        attackBonusList[tI][9] = Types.WATER.getFlyingAB();
        attackBonusList[tI][10] = Types.WATER.getPsychicAB();
        attackBonusList[tI][11] = Types.WATER.getBugAB();
        attackBonusList[tI][12] = Types.WATER.getRockAB();
        attackBonusList[tI][13] = Types.WATER.getGhostAB();
        attackBonusList[tI][14] = Types.WATER.getDragonAB();
        attackBonusList[tI][15] = Types.WATER.getDarkAB();
        attackBonusList[tI][16] = Types.WATER.getSteelAB();
        attackBonusList[tI][17] = Types.WATER.getFairyAB();
        tI++;
        System.out.println("Adding: Grass Attack Bonuses to the CodeAMonFactory.TypesChart.");
        attackBonusList[tI][0] = Types.GRASS.getNormalAB();
        attackBonusList[tI][1] = Types.GRASS.getFireAB();
        attackBonusList[tI][2] = Types.GRASS.getWaterAB();
        attackBonusList[tI][3] = Types.GRASS.getGrassAB();
        attackBonusList[tI][4] = Types.GRASS.getElectricAB();
        attackBonusList[tI][5] = Types.GRASS.getIceAB();
        attackBonusList[tI][6] = Types.GRASS.getFightingAB();
        attackBonusList[tI][7] = Types.GRASS.getPoisonAB();
        attackBonusList[tI][8] = Types.GRASS.getGroundAB();
        attackBonusList[tI][9] = Types.GRASS.getFlyingAB();
        attackBonusList[tI][10] = Types.GRASS.getPsychicAB();
        attackBonusList[tI][11] = Types.GRASS.getBugAB();
        attackBonusList[tI][12] = Types.GRASS.getRockAB();
        attackBonusList[tI][13] = Types.GRASS.getGhostAB();
        attackBonusList[tI][14] = Types.GRASS.getDragonAB();
        attackBonusList[tI][15] = Types.GRASS.getDarkAB();
        attackBonusList[tI][16] = Types.GRASS.getSteelAB();
        attackBonusList[tI][17] = Types.GRASS.getFairyAB();
        tI++;
        System.out.println("Adding: ELECTRIC Attack Bonuses to the CodeAMonFactory.TypesChart.");
        attackBonusList[tI][0] = Types.ELECTRIC.getNormalAB();
        attackBonusList[tI][1] = Types.ELECTRIC.getFireAB();
        attackBonusList[tI][2] = Types.ELECTRIC.getWaterAB();
        attackBonusList[tI][3] = Types.ELECTRIC.getGrassAB();
        attackBonusList[tI][4] = Types.ELECTRIC.getElectricAB();
        attackBonusList[tI][5] = Types.ELECTRIC.getIceAB();
        attackBonusList[tI][6] = Types.ELECTRIC.getFightingAB();
        attackBonusList[tI][7] = Types.ELECTRIC.getPoisonAB();
        attackBonusList[tI][8] = Types.ELECTRIC.getGroundAB();
        attackBonusList[tI][9] = Types.ELECTRIC.getFlyingAB();
        attackBonusList[tI][10] = Types.ELECTRIC.getPsychicAB();
        attackBonusList[tI][11] = Types.ELECTRIC.getBugAB();
        attackBonusList[tI][12] = Types.ELECTRIC.getRockAB();
        attackBonusList[tI][13] = Types.ELECTRIC.getGhostAB();
        attackBonusList[tI][14] = Types.ELECTRIC.getDragonAB();
        attackBonusList[tI][15] = Types.ELECTRIC.getDarkAB();
        attackBonusList[tI][16] = Types.ELECTRIC.getSteelAB();
        attackBonusList[tI][17] = Types.ELECTRIC.getFairyAB();
        tI++;
        System.out.println("Adding: ICE Attack Bonuses to the CodeAMonFactory.TypesChart.");
        attackBonusList[tI][0] = Types.ICE.getNormalAB();
        attackBonusList[tI][1] = Types.ICE.getFireAB();
        attackBonusList[tI][2] = Types.ICE.getWaterAB();
        attackBonusList[tI][3] = Types.ICE.getGrassAB();
        attackBonusList[tI][4] = Types.ICE.getElectricAB();
        attackBonusList[tI][5] = Types.ICE.getIceAB();
        attackBonusList[tI][6] = Types.ICE.getFightingAB();
        attackBonusList[tI][7] = Types.ICE.getPoisonAB();
        attackBonusList[tI][8] = Types.ICE.getGroundAB();
        attackBonusList[tI][9] = Types.ICE.getFlyingAB();
        attackBonusList[tI][10] = Types.ICE.getPsychicAB();
        attackBonusList[tI][11] = Types.ICE.getBugAB();
        attackBonusList[tI][12] = Types.ICE.getRockAB();
        attackBonusList[tI][13] = Types.ICE.getGhostAB();
        attackBonusList[tI][14] = Types.ICE.getDragonAB();
        attackBonusList[tI][15] = Types.ICE.getDarkAB();
        attackBonusList[tI][16] = Types.ICE.getSteelAB();
        attackBonusList[tI][17] = Types.ICE.getFairyAB();
        tI++;
        System.out.println("Adding: FIGHTING Attack Bonuses to the CodeAMonFactory.TypesChart.");
        attackBonusList[tI][0] = Types.FIGHTING.getNormalAB();
        attackBonusList[tI][1] = Types.FIGHTING.getFireAB();
        attackBonusList[tI][2] = Types.FIGHTING.getWaterAB();
        attackBonusList[tI][3] = Types.FIGHTING.getGrassAB();
        attackBonusList[tI][4] = Types.FIGHTING.getElectricAB();
        attackBonusList[tI][5] = Types.FIGHTING.getIceAB();
        attackBonusList[tI][6] = Types.FIGHTING.getFightingAB();
        attackBonusList[tI][7] = Types.FIGHTING.getPoisonAB();
        attackBonusList[tI][8] = Types.FIGHTING.getGroundAB();
        attackBonusList[tI][9] = Types.FIGHTING.getFlyingAB();
        attackBonusList[tI][10] = Types.FIGHTING.getPsychicAB();
        attackBonusList[tI][11] = Types.FIGHTING.getBugAB();
        attackBonusList[tI][12] = Types.FIGHTING.getRockAB();
        attackBonusList[tI][13] = Types.FIGHTING.getGhostAB();
        attackBonusList[tI][14] = Types.FIGHTING.getDragonAB();
        attackBonusList[tI][15] = Types.FIGHTING.getDarkAB();
        attackBonusList[tI][16] = Types.FIGHTING.getSteelAB();
        attackBonusList[tI][17] = Types.FIGHTING.getFairyAB();
        tI++;
        System.out.println("Adding: POISON Attack Bonuses to the CodeAMonFactory.TypesChart.");
        attackBonusList[tI][0] = Types.POISON.getNormalAB();
        attackBonusList[tI][1] = Types.POISON.getFireAB();
        attackBonusList[tI][2] = Types.POISON.getWaterAB();
        attackBonusList[tI][3] = Types.POISON.getGrassAB();
        attackBonusList[tI][4] = Types.POISON.getElectricAB();
        attackBonusList[tI][5] = Types.POISON.getIceAB();
        attackBonusList[tI][6] = Types.POISON.getFightingAB();
        attackBonusList[tI][7] = Types.POISON.getPoisonAB();
        attackBonusList[tI][8] = Types.POISON.getGroundAB();
        attackBonusList[tI][9] = Types.POISON.getFlyingAB();
        attackBonusList[tI][10] = Types.POISON.getPsychicAB();
        attackBonusList[tI][11] = Types.POISON.getBugAB();
        attackBonusList[tI][12] = Types.POISON.getRockAB();
        attackBonusList[tI][13] = Types.POISON.getGhostAB();
        attackBonusList[tI][14] = Types.POISON.getDragonAB();
        attackBonusList[tI][15] = Types.POISON.getDarkAB();
        attackBonusList[tI][16] = Types.POISON.getSteelAB();
        attackBonusList[tI][17] = Types.POISON.getFairyAB();
        tI++;
        System.out.println("Adding: GROUND Attack Bonuses to the CodeAMonFactory.TypesChart.");
        attackBonusList[tI][0] = Types.GROUND.getNormalAB();
        attackBonusList[tI][1] = Types.GROUND.getFireAB();
        attackBonusList[tI][2] = Types.GROUND.getWaterAB();
        attackBonusList[tI][3] = Types.GROUND.getGrassAB();
        attackBonusList[tI][4] = Types.GROUND.getElectricAB();
        attackBonusList[tI][5] = Types.GROUND.getIceAB();
        attackBonusList[tI][6] = Types.GROUND.getFightingAB();
        attackBonusList[tI][7] = Types.GROUND.getPoisonAB();
        attackBonusList[tI][8] = Types.GROUND.getGroundAB();
        attackBonusList[tI][9] = Types.GROUND.getFlyingAB();
        attackBonusList[tI][10] = Types.GROUND.getPsychicAB();
        attackBonusList[tI][11] = Types.GROUND.getBugAB();
        attackBonusList[tI][12] = Types.GROUND.getRockAB();
        attackBonusList[tI][13] = Types.GROUND.getGhostAB();
        attackBonusList[tI][14] = Types.GROUND.getDragonAB();
        attackBonusList[tI][15] = Types.GROUND.getDarkAB();
        attackBonusList[tI][16] = Types.GROUND.getSteelAB();
        attackBonusList[tI][17] = Types.GROUND.getFairyAB();
        tI++;
        System.out.println("Adding: FLYING Attack Bonuses to the CodeAMonFactory.TypesChart.");
        attackBonusList[tI][0] = Types.FLYING.getNormalAB();
        attackBonusList[tI][1] = Types.FLYING.getFireAB();
        attackBonusList[tI][2] = Types.FLYING.getWaterAB();
        attackBonusList[tI][3] = Types.FLYING.getGrassAB();
        attackBonusList[tI][4] = Types.FLYING.getElectricAB();
        attackBonusList[tI][5] = Types.FLYING.getIceAB();
        attackBonusList[tI][6] = Types.FLYING.getFightingAB();
        attackBonusList[tI][7] = Types.FLYING.getPoisonAB();
        attackBonusList[tI][8] = Types.FLYING.getGroundAB();
        attackBonusList[tI][9] = Types.FLYING.getFlyingAB();
        attackBonusList[tI][10] = Types.FLYING.getPsychicAB();
        attackBonusList[tI][11] = Types.FLYING.getBugAB();
        attackBonusList[tI][12] = Types.FLYING.getRockAB();
        attackBonusList[tI][13] = Types.FLYING.getGhostAB();
        attackBonusList[tI][14] = Types.FLYING.getDragonAB();
        attackBonusList[tI][15] = Types.FLYING.getDarkAB();
        attackBonusList[tI][16] = Types.FLYING.getSteelAB();
        attackBonusList[tI][17] = Types.FLYING.getFairyAB();
        tI++;
        System.out.println("Adding: PSYCHIC Attack Bonuses to the CodeAMonFactory.TypesChart.");
        attackBonusList[tI][0] = Types.PSYCHIC.getNormalAB();
        attackBonusList[tI][1] = Types.PSYCHIC.getFireAB();
        attackBonusList[tI][2] = Types.PSYCHIC.getWaterAB();
        attackBonusList[tI][3] = Types.PSYCHIC.getGrassAB();
        attackBonusList[tI][4] = Types.PSYCHIC.getElectricAB();
        attackBonusList[tI][5] = Types.PSYCHIC.getIceAB();
        attackBonusList[tI][6] = Types.PSYCHIC.getFightingAB();
        attackBonusList[tI][7] = Types.PSYCHIC.getPoisonAB();
        attackBonusList[tI][8] = Types.PSYCHIC.getGroundAB();
        attackBonusList[tI][9] = Types.PSYCHIC.getFlyingAB();
        attackBonusList[tI][10] = Types.PSYCHIC.getPsychicAB();
        attackBonusList[tI][11] = Types.PSYCHIC.getBugAB();
        attackBonusList[tI][12] = Types.PSYCHIC.getRockAB();
        attackBonusList[tI][13] = Types.PSYCHIC.getGhostAB();
        attackBonusList[tI][14] = Types.PSYCHIC.getDragonAB();
        attackBonusList[tI][15] = Types.PSYCHIC.getDarkAB();
        attackBonusList[tI][16] = Types.PSYCHIC.getSteelAB();
        attackBonusList[tI][17] = Types.PSYCHIC.getFairyAB();
        tI++;
        System.out.println("Adding: BUG Attack Bonuses to the CodeAMonFactory.TypesChart.");
        attackBonusList[tI][0] = Types.BUG.getNormalAB();
        attackBonusList[tI][1] = Types.BUG.getFireAB();
        attackBonusList[tI][2] = Types.BUG.getWaterAB();
        attackBonusList[tI][3] = Types.BUG.getGrassAB();
        attackBonusList[tI][4] = Types.BUG.getElectricAB();
        attackBonusList[tI][5] = Types.BUG.getIceAB();
        attackBonusList[tI][6] = Types.BUG.getFightingAB();
        attackBonusList[tI][7] = Types.BUG.getPoisonAB();
        attackBonusList[tI][8] = Types.BUG.getGroundAB();
        attackBonusList[tI][9] = Types.BUG.getFlyingAB();
        attackBonusList[tI][10] = Types.BUG.getPsychicAB();
        attackBonusList[tI][11] = Types.BUG.getBugAB();
        attackBonusList[tI][12] = Types.BUG.getRockAB();
        attackBonusList[tI][13] = Types.BUG.getGhostAB();
        attackBonusList[tI][14] = Types.BUG.getDragonAB();
        attackBonusList[tI][15] = Types.BUG.getDarkAB();
        attackBonusList[tI][16] = Types.BUG.getSteelAB();
        attackBonusList[tI][17] = Types.BUG.getFairyAB();
        tI++;
        System.out.println("Adding: ROCK Attack Bonuses to the CodeAMonFactory.TypesChart.");
        attackBonusList[tI][0] = Types.ROCK.getNormalAB();
        attackBonusList[tI][1] = Types.ROCK.getFireAB();
        attackBonusList[tI][2] = Types.ROCK.getWaterAB();
        attackBonusList[tI][3] = Types.ROCK.getGrassAB();
        attackBonusList[tI][4] = Types.ROCK.getElectricAB();
        attackBonusList[tI][5] = Types.ROCK.getIceAB();
        attackBonusList[tI][6] = Types.ROCK.getFightingAB();
        attackBonusList[tI][7] = Types.ROCK.getPoisonAB();
        attackBonusList[tI][8] = Types.ROCK.getGroundAB();
        attackBonusList[tI][9] = Types.ROCK.getFlyingAB();
        attackBonusList[tI][10] = Types.ROCK.getPsychicAB();
        attackBonusList[tI][11] = Types.ROCK.getBugAB();
        attackBonusList[tI][12] = Types.ROCK.getRockAB();
        attackBonusList[tI][13] = Types.ROCK.getGhostAB();
        attackBonusList[tI][14] = Types.ROCK.getDragonAB();
        attackBonusList[tI][15] = Types.ROCK.getDarkAB();
        attackBonusList[tI][16] = Types.ROCK.getSteelAB();
        attackBonusList[tI][17] = Types.ROCK.getFairyAB();
        tI++;
        System.out.println("Adding: GHOST Attack Bonuses to the CodeAMonFactory.TypesChart.");
        attackBonusList[tI][0] = Types.GHOST.getNormalAB();
        attackBonusList[tI][1] = Types.GHOST.getFireAB();
        attackBonusList[tI][2] = Types.GHOST.getWaterAB();
        attackBonusList[tI][3] = Types.GHOST.getGrassAB();
        attackBonusList[tI][4] = Types.GHOST.getElectricAB();
        attackBonusList[tI][5] = Types.GHOST.getIceAB();
        attackBonusList[tI][6] = Types.GHOST.getFightingAB();
        attackBonusList[tI][7] = Types.GHOST.getPoisonAB();
        attackBonusList[tI][8] = Types.GHOST.getGroundAB();
        attackBonusList[tI][9] = Types.GHOST.getFlyingAB();
        attackBonusList[tI][10] = Types.GHOST.getPsychicAB();
        attackBonusList[tI][11] = Types.GHOST.getBugAB();
        attackBonusList[tI][12] = Types.GHOST.getRockAB();
        attackBonusList[tI][13] = Types.GHOST.getGhostAB();
        attackBonusList[tI][14] = Types.GHOST.getDragonAB();
        attackBonusList[tI][15] = Types.GHOST.getDarkAB();
        attackBonusList[tI][16] = Types.GHOST.getSteelAB();
        attackBonusList[tI][17] = Types.GHOST.getFairyAB();
        tI++;
        System.out.println("Adding: DRAGON Attack Bonuses to the CodeAMonFactory.TypesChart.");
        attackBonusList[tI][0] = Types.DRAGON.getNormalAB();
        attackBonusList[tI][1] = Types.DRAGON.getFireAB();
        attackBonusList[tI][2] = Types.DRAGON.getWaterAB();
        attackBonusList[tI][3] = Types.DRAGON.getGrassAB();
        attackBonusList[tI][4] = Types.DRAGON.getElectricAB();
        attackBonusList[tI][5] = Types.DRAGON.getIceAB();
        attackBonusList[tI][6] = Types.DRAGON.getFightingAB();
        attackBonusList[tI][7] = Types.DRAGON.getPoisonAB();
        attackBonusList[tI][8] = Types.DRAGON.getGroundAB();
        attackBonusList[tI][9] = Types.DRAGON.getFlyingAB();
        attackBonusList[tI][10] = Types.DRAGON.getPsychicAB();
        attackBonusList[tI][11] = Types.DRAGON.getBugAB();
        attackBonusList[tI][12] = Types.DRAGON.getRockAB();
        attackBonusList[tI][13] = Types.DRAGON.getGhostAB();
        attackBonusList[tI][14] = Types.DRAGON.getDragonAB();
        attackBonusList[tI][15] = Types.DRAGON.getDarkAB();
        attackBonusList[tI][16] = Types.DRAGON.getSteelAB();
        attackBonusList[tI][17] = Types.DRAGON.getFairyAB();
        tI++;
        System.out.println("Adding: DARK Attack Bonuses to the CodeAMonFactory.TypesChart.");
        attackBonusList[tI][0] = Types.DARK.getNormalAB();
        attackBonusList[tI][1] = Types.DARK.getFireAB();
        attackBonusList[tI][2] = Types.DARK.getWaterAB();
        attackBonusList[tI][3] = Types.DARK.getGrassAB();
        attackBonusList[tI][4] = Types.DARK.getElectricAB();
        attackBonusList[tI][5] = Types.DARK.getIceAB();
        attackBonusList[tI][6] = Types.DARK.getFightingAB();
        attackBonusList[tI][7] = Types.DARK.getPoisonAB();
        attackBonusList[tI][8] = Types.DARK.getGroundAB();
        attackBonusList[tI][9] = Types.DARK.getFlyingAB();
        attackBonusList[tI][10] = Types.DARK.getPsychicAB();
        attackBonusList[tI][11] = Types.DARK.getBugAB();
        attackBonusList[tI][12] = Types.DARK.getRockAB();
        attackBonusList[tI][13] = Types.DARK.getGhostAB();
        attackBonusList[tI][14] = Types.DARK.getDragonAB();
        attackBonusList[tI][15] = Types.DARK.getDarkAB();
        attackBonusList[tI][16] = Types.DARK.getSteelAB();
        attackBonusList[tI][17] = Types.DARK.getFairyAB();
        tI++;
        System.out.println("Adding: STEEL Attack Bonuses to the CodeAMonFactory.TypesChart.");
        attackBonusList[tI][0] = Types.STEEL.getNormalAB();
        attackBonusList[tI][1] = Types.STEEL.getFireAB();
        attackBonusList[tI][2] = Types.STEEL.getWaterAB();
        attackBonusList[tI][3] = Types.STEEL.getGrassAB();
        attackBonusList[tI][4] = Types.STEEL.getElectricAB();
        attackBonusList[tI][5] = Types.STEEL.getIceAB();
        attackBonusList[tI][6] = Types.STEEL.getFightingAB();
        attackBonusList[tI][7] = Types.STEEL.getPoisonAB();
        attackBonusList[tI][8] = Types.STEEL.getGroundAB();
        attackBonusList[tI][9] = Types.STEEL.getFlyingAB();
        attackBonusList[tI][10] = Types.STEEL.getPsychicAB();
        attackBonusList[tI][11] = Types.STEEL.getBugAB();
        attackBonusList[tI][12] = Types.STEEL.getRockAB();
        attackBonusList[tI][13] = Types.STEEL.getGhostAB();
        attackBonusList[tI][14] = Types.STEEL.getDragonAB();
        attackBonusList[tI][15] = Types.STEEL.getDarkAB();
        attackBonusList[tI][16] = Types.STEEL.getSteelAB();
        attackBonusList[tI][17] = Types.STEEL.getFairyAB();
        tI++;
        System.out.println("Adding: FAIRY Attack Bonuses to the CodeAMonFactory.TypesChart.");
        attackBonusList[tI][0] = Types.FAIRY.getNormalAB();
        attackBonusList[tI][1] = Types.FAIRY.getFireAB();
        attackBonusList[tI][2] = Types.FAIRY.getWaterAB();
        attackBonusList[tI][3] = Types.FAIRY.getGrassAB();
        attackBonusList[tI][4] = Types.FAIRY.getElectricAB();
        attackBonusList[tI][5] = Types.FAIRY.getIceAB();
        attackBonusList[tI][6] = Types.FAIRY.getFightingAB();
        attackBonusList[tI][7] = Types.FAIRY.getPoisonAB();
        attackBonusList[tI][8] = Types.FAIRY.getGroundAB();
        attackBonusList[tI][9] = Types.FAIRY.getFlyingAB();
        attackBonusList[tI][10] = Types.FAIRY.getPsychicAB();
        attackBonusList[tI][11] = Types.FAIRY.getBugAB();
        attackBonusList[tI][12] = Types.FAIRY.getRockAB();
        attackBonusList[tI][13] = Types.FAIRY.getGhostAB();
        attackBonusList[tI][14] = Types.FAIRY.getDragonAB();
        attackBonusList[tI][15] = Types.FAIRY.getDarkAB();
        attackBonusList[tI][16] = Types.FAIRY.getSteelAB();
        attackBonusList[tI][17] = Types.FAIRY.getFairyAB();
        tI++;
        System.out.println("\n");
    }

    /**
     * Method for printing the assigned CodeAMonFactory.Types data.
     */
    public void printTypesChartData() {
        System.out.println("Printing the generated Types_Chart data:\n");
        for (int row = 0; row < 18; row++) {
            System.out.println(codeAmonTypes.get(row));
            for (int col = 0; col < 18; col++) {
                System.out.print(attackBonusList[row][col] + ", ");
            }
            System.out.println("\n");
        }
        System.out.println();
    }

    /**
     * Method for acquiring the attackBonus of a CodeAMon.
     * @param codeAmonTypes Types List.
     * @param attackBonusList AttackBonus List.
     * @param attacker Attacking CodeAMon.
     * @param defender Defending CodeAMon.
     * @return attackBonus Double value.
     */
    public static double getAttackBonus(ArrayList codeAmonTypes,
                                        Double[][] attackBonusList, Types attacker, Types defender) {
        int atkID = 0;
        int defID = 0;
        for (int i = 0; i < 18; i++) {
            if (codeAmonTypes.get(i) == attacker) {
                atkID = i;
            }
            if (codeAmonTypes.get(i) == defender) {
                defID = i;
            }
        }
        double attackBonus = attackBonusList[atkID][defID];
        return attackBonus;
    }

}
