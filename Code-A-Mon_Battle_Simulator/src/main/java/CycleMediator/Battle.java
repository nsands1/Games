package CycleMediator;

import CodeAMonFactory.CodeAMon;
import CodeAMonFactory.Moves;
import CodeAMonFactory.TypesChart;
import TrainerFactory.Trainer;
import java.util.List;
import java.util.Random;

public class Battle extends Cycle {

    /**
     * Function to add experience points for attacking CodeAMon and returning the damage the
     * CodeAMon tries to deal.
     * Experience is only gained if the CodeAMon still has more than 0 health, damage is
     * also only dealt when health > 0.
     * If the health of a CodeAMon is less than 10 they deal critical damage.
     *
     * @param codeAMon that is dealing damage
     * @return int blowDamage stat of codeAMon as (int) double
     */
    public int dealDamage(CodeAMon codeAMon, Weather CURRENT_WEATHER, double typeAttackBonus) {
        double blowDamage = 0;
        String attackMoveName = "";
        String codeAMonName = CodeAMon.getCodeAMonName(codeAMon);
        WEATHER_BONUS = Cycle.getWeatherBonus(codeAMon, CURRENT_WEATHER);
        if (CodeAMon.getHP(codeAMon) > 0) {
            Random random = new Random();
            Moves attackMove = codeAMon.Moves_List.get(random.nextInt(0,3));
            blowDamage = Moves.getMoveDamage(attackMove);
            attackMoveName = Moves.getMoveName(attackMove);
            if (WEATHER_BONUS == true) {
                blowDamage = blowDamage * 1.25;
                System.out.println("The " + CURRENT_WEATHER.toString() + " weather has made "
                            + codeAMonName + " stronger!");
            }
            if (CodeAMon.getHP(codeAMon) < 10) {
                System.out.println(codeAMonName + " used " + attackMoveName
                        + "! It was a critical hit!");
                blowDamage = blowDamage * 1.5;
            } else {
                System.out.println(codeAMonName + " used " + attackMoveName + "!");
            }
            CodeAMon.setExp(codeAMon, (CodeAMon.getExp(codeAMon) + (int) Math.floor(blowDamage)));
            System.out.println(codeAMonName + " has earned "
                    + (int) Math.floor(blowDamage) + " more experience!");
        }
        return (int) Math.floor(blowDamage * typeAttackBonus);
    }
    /**
     * Function to add experience points for attacked codeAMon as well as update their
     * health based on the attack and their defence.
     *
     * If their defence is higher than the blowDamage then the codeAMon will take half
     * of the blowDamage, and they will also gain the full difference as experience.
     *
     * If their protection is lower or equal than the blowDamage then the codeAMon will take
     * half the difference as experience and the health will be reduced by the full difference.
     *
     * Health cannot go below 0.
     *
     * @param codeAMon that is being attacked
     * @param blowDamage full force of attack without protection factored in
     * @return amount of damage actually taken by the codeAMon as int
     */
    public int takeDamage(CodeAMon codeAMon, int blowDamage, Weather CURRENT_WEATHER) {
        int exp, damageReceived = 0;
        String codeAMonName = CodeAMon.getCodeAMonName(codeAMon);
        int def = CodeAMon.getDef(codeAMon);
        WEATHER_BONUS = Cycle.getWeatherBonus(codeAMon, CURRENT_WEATHER);
        if (WEATHER_BONUS == true) {
            def = (int) (def * 1.25);
            System.out.println("The " + CURRENT_WEATHER.toString() + " weather has made "
                    + codeAMonName + " stronger!");
        }
        if (def > blowDamage) {
            System.out.println(codeAMonName
                    + " was protected from " + blowDamage + " damage!");
            exp = def - blowDamage;
            damageReceived = blowDamage / 2;
            CodeAMon.setHP(codeAMon, CodeAMon.getHP(codeAMon) - damageReceived);
            System.out.println(codeAMonName
                    + " was hit with " + damageReceived + " instead!");
        } else {
            damageReceived = blowDamage - def;
            exp = damageReceived / 2;
            CodeAMon.setHP(codeAMon, CodeAMon.getHP(codeAMon) - damageReceived);
            System.out.println(codeAMonName
                    + " was hit with " + damageReceived + " damage!");
        }
        if (CodeAMon.getHP(codeAMon) > 0) {
            CodeAMon.setExp(codeAMon, CodeAMon.getExp(codeAMon) + exp);
            System.out.println(codeAMonName
                    + " has earned " + exp + " more experience while defending!");
        } else {
            CodeAMon.setHP(codeAMon, 0);
            System.out.println(codeAMonName + " has fainted...");
        }
        exp = 0;
        return damageReceived;
    }
    /**
     * Function that facilitates the attacker dealing damage to their opponent
     * and then the opposite.
     * A codeAMon can only attack if both still have health greater than 0.
     * This method uses dealDamage and takeDamage from above.
     * The first codeAMon attacks first, by using dealsDamage and the opponent takesDamage.
     * Then the other codeAMon attacks, same procedure as above.
     *
     * @param codeAMon that is attacking
     * @param opponent that is being attacked
     */
    public void attack(CodeAMon codeAMon, CodeAMon opponent, Weather CURRENT_WEATHER) {
        double typeAttackBonus = TypesChart.getAttackBonus(
                TypesChart.codeAmonTypes,
                TypesChart.attackBonusList,
                CodeAMon.getType(codeAMon),
                CodeAMon.getType(opponent));
        if (CodeAMon.getHP(codeAMon) > 0 && CodeAMon.getHP(opponent) > 0) {
            System.out.println("Health of Attacker & Defender is > 0");
            int damageReceived = takeDamage(opponent,
                    dealDamage(codeAMon, CURRENT_WEATHER, typeAttackBonus), CURRENT_WEATHER);
            CodeAMon.setHP(opponent, (CodeAMon.getHP(opponent) - damageReceived));
            attack(opponent, codeAMon, CURRENT_WEATHER);
        } else {
            System.out.println("Health is not > 0 for " + CodeAMon.getCodeAMonName(codeAMon)
                    + " and/or " + CodeAMon.getCodeAMonName(opponent) + "!");
            if (CodeAMon.getHP(codeAMon) < 0) {
                CodeAMon.setHP(codeAMon, 0);
            }

            return;
        }
    }

    /**
     * What this method does:
     * - The player will attack the opponent once, and the opponent will attack the player once.
     * - The player will just iterate through the list of opponents in the order they are in.
     * - If the player defeats an opponent CodeAMon, that CodeAMon is removed from opponents list.
     * - The order in which the attacks happen are based on the speed of the opponent and player.
     * - The faster of the two attacks first, then the slower. If equal the player attacks first.
     * @param player The player.
     * @param opponent The opponent.
     * @param playerCodeAMonList The players list of CodeAMon to battle.
     * @param oppCodeAMonList The opponents list of CodeAMon to battle.
     * @param CURRENT_WEATHER The current weather of the battle.
     */
    public void play(Trainer player, Trainer opponent, List<CodeAMon> playerCodeAMonList,
                    List<CodeAMon> oppCodeAMonList, Weather CURRENT_WEATHER) {
        //determine order of attack
        while (ableToBattle(playerCodeAMonList)) {
            while (ableToBattle(oppCodeAMonList)) {
                int playerCodeAMonID = ableToBattleID(playerCodeAMonList);
                int oppCodeAMonID = ableToBattleID(oppCodeAMonList);
                if (playerCodeAMonID == 10 || oppCodeAMonID == 10) {
                    return;
                }
                double playerSPD = CodeAMon.getSpd(playerCodeAMonList.get(playerCodeAMonID));
                double oppSPD = CodeAMon.getSpd(oppCodeAMonList.get(oppCodeAMonID));
                CodeAMon[] orderOfAttack = new CodeAMon[2];

                if (playerSPD > oppSPD) {
                    orderOfAttack[0] = playerCodeAMonList.get(playerCodeAMonID);
                    orderOfAttack[1] = oppCodeAMonList.get(oppCodeAMonID);
                    System.out.println(CodeAMon.getCodeAMonName(
                            playerCodeAMonList.get(playerCodeAMonID))
                            + " is attacking first!");
                } else {
                    orderOfAttack[0] = oppCodeAMonList.get(oppCodeAMonID);
                    orderOfAttack[1] = playerCodeAMonList.get(playerCodeAMonID);
                    System.out.println(CodeAMon.getCodeAMonName(oppCodeAMonList.get(oppCodeAMonID))
                            + " is attacking first!");
                }
                // attack in order
                attack(orderOfAttack[0], orderOfAttack[1], CURRENT_WEATHER);

                // remove opponents that have <= 0 health
                for (int isDeadz = 0; isDeadz < oppCodeAMonList.size(); isDeadz++) {
                    if (CodeAMon.getHP(oppCodeAMonList.get(isDeadz)) <= 0) {
                        removeOppCodeAMon(oppCodeAMonList, oppCodeAMonList.get(isDeadz));
                    }
                }
            }

            if (oppCodeAMonList.size() == 0) {
                System.out.println("You have defeated all of "
                        + opponent.getPlayerName(opponent)
                        + "'s CodeAMon! You WIN the battle!");
                return;
            } else {
                System.out.println("All of your CodeAMon have fainted! Retreat!");
                return;
            }
        }
    }// End play()

    /**
     * removes an opponent CodeAMon from that list of codeAMon.
     * @param oppCodeAMonList list of opp generated codeAMon.
     * @param codeAMon the codeAMon to be removed due to HP <= 0.
     */
    public void removeOppCodeAMon(List<CodeAMon> oppCodeAMonList, CodeAMon codeAMon) {
        oppCodeAMonList.remove(codeAMon);
        System.out.println("\n\nF\n\n");
        System.out.println(CodeAMon.getCodeAMonName(codeAMon) + " was defeated in battle!");
    }

    /**
     * Returns a boolean if the codeAMon health is sufficient or > 0.
     * @param codeAMonList list of generated codeAMon
     * @return Boolean
     */
    private boolean ableToBattle(List<CodeAMon> codeAMonList) {
        for (int i = 0; i < codeAMonList.size(); i++) {
            if (CodeAMon.getHP(codeAMonList.get(i)) <= 0) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * determine if the list is empty and returns next battle ready codeAMon.
     * @param codeAMonList list of generated codeAMon
     * @return ArrayList id number of a codeAMon
     */
    private int ableToBattleID(List<CodeAMon> codeAMonList) {
        int codeAMonID = 0;
        for (int i = 0; i < codeAMonList.size(); i++) {
            if (CodeAMon.getHP(codeAMonList.get(i)) > 0) {
                codeAMonID = i;
                return codeAMonID;
            }
        }
        System.out.println("No available codeAMon to battle!");
        return 10;
    }

}// End Battle.java
