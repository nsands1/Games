package CycleMediator;

import CodeAMonFactory.CodeAMon;
import TrainerFactory.Trainer;
import java.util.ArrayList;
import java.util.List;

import static CycleMediator.WeatherList.WEATHER_LIST;

public class Cycle {

    boolean DAY = true;
    boolean WEATHER_BONUS = false;
    int WEATHER_COUNTER = 0;
    int DAY_COUNTER = 0;
    WeatherList weather = new WeatherList();
    Weather CURRENT_WEATHER = Weather.CLEAR;
    int[] hPList = new int[6];
    boolean firstBattle = true;
    static Battle CODEAMON_ARENA = new Battle();


    public void Cycle() {
        this.DAY = true;
        this.WEATHER_BONUS = false;
        this.WEATHER_COUNTER = 0;
        this.DAY_COUNTER = 0;
        this.weather.makeWeatherList();
        this.CURRENT_WEATHER = WEATHER_LIST.get(0);
        this.hPList[0] = 0;
        this.hPList[1] = 0;
        this.hPList[2] = 0;
        this.hPList[3] = 0;
        this.hPList[4] = 0;
        this.hPList[5] = 0;

    }

    public void RunCycle(Trainer player, Trainer opponent, List<CodeAMon> playerCodeAMonList,
                         List<CodeAMon> oppCodeAMonList) {
        setCycle();
        CURRENT_WEATHER = getWeather(WEATHER_LIST);
        while (oppCodeAMonList.size() != 0) {
            while (DAY) {
                DAY_COUNTER++;
                System.out.println("Current Day: " + DAY_COUNTER);
                System.out.println("Current Weather: " + CURRENT_WEATHER);
                System.out.println("Tracking CodeAMon Original Health Points.");
                trackHealthPoints(playerCodeAMonList);
                CODEAMON_ARENA.play(player, opponent, playerCodeAMonList, oppCodeAMonList, CURRENT_WEATHER);
                DAY = false;
            }
            // NIGHT
            System.out.println("It is now nightfall, traveling to a CodeAMon Center.");
            System.out.println("Healing CodeAMon!");
            //Testing CodeAMon.setHP(playerCodeAMonList.get(0), 5);
            healCodeAMon(playerCodeAMonList);
            System.out.println("Player CodeAMon are now healed.");
            System.out.println("Checking for CodeAMon LevelUp!");
            //Testing CodeAMon.setExp(playerCodeAMonList.get(0), 140);
            levelUpCodeAMon(playerCodeAMonList);
            System.out.println("Checking how CodeAMon are feeling.");
            checkEvolve(playerCodeAMonList);
            //System.out.println("More Trainers are their way!");
            if (oppCodeAMonList.isEmpty()) {
                return;
            }
            System.out.println("CodeAMon are well rested. The sun starts to rise.");
            DAY = true;
        }
    }

    private void levelUpCodeAMon(List<CodeAMon> playerCodeAMonList) {
        for (int i = 0; i < playerCodeAMonList.size(); i++) {
            int currentEXP = CodeAMon.getExp(playerCodeAMonList.get(i));
            int requiredEXP = CodeAMon.getPPL(playerCodeAMonList.get(i));
            if (currentEXP >= requiredEXP) {
                CodeAMon.levelUp(playerCodeAMonList.get(i));
                CodeAMon.printInfo(playerCodeAMonList.get(i));
            }
        }
    }

    private void trackHealthPoints(List<CodeAMon> playerCodeAMonList) {
        for (int i = 0; i < playerCodeAMonList.size(); i++) {
            hPList[i] = 0;
        }
        for (int i = 0; i < playerCodeAMonList.size(); i++) {
            hPList[i] = CodeAMon.getHP(playerCodeAMonList.get(i));
        }
    }

    private void healCodeAMon(List<CodeAMon> playerCodeAMonList) {
        for (int i = 0; i < playerCodeAMonList.size(); i++) {
            System.out.println("CodeAMon " + CodeAMon.getCodeAMonName(playerCodeAMonList.get(i))
                            + " health was " + CodeAMon.getHP(playerCodeAMonList.get(i))
                            + ".");
            CodeAMon.setHP(playerCodeAMonList.get(i), hPList[i]);
            System.out.println("CodeAMon " + CodeAMon.getCodeAMonName(playerCodeAMonList.get(i))
                            + " is now healed to "
                            + CodeAMon.getHP(playerCodeAMonList.get(i))
                            + ".");
        }
    }

    private void checkEvolve(List<CodeAMon> playerCodeAMonList) {
        for (int i = 0; i < playerCodeAMonList.size(); i++) {
            CodeAMon.evolve(playerCodeAMonList.get(i));
        }

    }

    static boolean getWeatherBonus(CodeAMon codeAMon, Weather CURRENT_WEATHER) {
        return WeatherList.getWeatherBonus(codeAMon, CURRENT_WEATHER);
    }

    private Weather getWeather(ArrayList<Weather> WEATHER_LIST) {
        if (WEATHER_COUNTER >= WEATHER_LIST.size()) {
            WEATHER_COUNTER = 0;
        }
        CURRENT_WEATHER = WEATHER_LIST.get(WEATHER_COUNTER);
        WEATHER_COUNTER++;
        return  CURRENT_WEATHER;
    }

    private void setCycle() { DAY = true; }

}
