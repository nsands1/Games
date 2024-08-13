package CycleMediator;

import CodeAMonFactory.CodeAMon;
import CodeAMonFactory.Types;

import java.util.ArrayList;
import java.util.Random;

/**
 * WeatherList of possible weather types.
 * Stored in static array, and shuffled for randomness.
 */
public class WeatherList {

    public static ArrayList<Weather> WEATHER_LIST = new ArrayList<>(8);

    /**
     * shuffles the weather in a weatherlist.
     * @param WEATHER_LIST weatherlist
     * @return shuffled weatherlist
     */
    private ArrayList shuffleWeather( ArrayList WEATHER_LIST) {
        Random randy = new Random();
        for (int i = WEATHER_LIST.size() - 1; i > 0; i--) {
            int j = randy.nextInt(i + 1);
            Weather tempWeather = (Weather) WEATHER_LIST.get(i);
            WEATHER_LIST.set(i, WEATHER_LIST.get(j));
            WEATHER_LIST.set(j, tempWeather);
        }
        //printShuffledWeatherList(WEATHER_LIST);
        return WEATHER_LIST;
    }

    /**
     * Prints the weather list.
     * @param WEATHER_LIST list of weather conditions.
     */
    private void printShuffledWeatherList(ArrayList WEATHER_LIST) {
        System.out.println("The weather forecast is: ");
        for (int a = 0; a < WEATHER_LIST.size(); a++) {
            System.out.println("                    " + WEATHER_LIST.get(a));
        }
    }

    /**
     * constructor to make the weatherlist from weather conditions.
     */
    public void makeWeatherList() {
        WEATHER_LIST.add(Weather.SUNNY);         //Weather Bonus for GRASS, GROUND, FIRE
        WEATHER_LIST.add(Weather.CLEAR);         //Weather Bonus for GRASS, GROUND, FIRE
        WEATHER_LIST.add(Weather.RAINY);          //Weather Bonus for WATER, ELECTRIC, BUG
        WEATHER_LIST.add(Weather.PARTLY_CLOUDY); //Weather Bonus for NORMAL, ROCK
        WEATHER_LIST.add(Weather.CLOUDY);        //Weather Bonus for FAIRY, FIGHTING, POISON
        WEATHER_LIST.add(Weather.WINDY);         //Weather Bonus for FLYING, PSYCHIC, DRAGON
        WEATHER_LIST.add(Weather.SNOWY);         //Weather Bonus for ICE, STEEL
        WEATHER_LIST.add(Weather.FOGGY);           //Weather Bonus for GHOST, DARK

        WEATHER_LIST = shuffleWeather(WEATHER_LIST);
    }

    /**
     * returns a boolean if the weather condition is suitable for the attacking CodeAMon.
     * @param codeAMon attacking codeAMon
     * @param CURRENT_WEATHER current weather condition
     * @return Boolean, receive bonus
     */
    public static boolean getWeatherBonus(CodeAMon codeAMon, Weather CURRENT_WEATHER) {
        Types currentType = CodeAMon.getType(codeAMon);
        if (CURRENT_WEATHER == Weather.SUNNY) {
            return currentType == Types.GRASS ||
                    currentType == Types.GROUND ||
                    currentType == Types.FIRE;
        }
        if (CURRENT_WEATHER == Weather.CLEAR) {
            return currentType == Types.GRASS ||
                    currentType == Types.GROUND ||
                    currentType == Types.FIRE;
        }
        if (CURRENT_WEATHER == Weather.RAINY) {
            return currentType == Types.WATER ||
                    currentType == Types.ELECTRIC ||
                    currentType == Types.BUG;
        }
        if (CURRENT_WEATHER == Weather.PARTLY_CLOUDY) {
            return currentType == Types.NORMAL ||
                    currentType == Types.ROCK;
        }
        if (CURRENT_WEATHER == Weather.CLOUDY) {
            return currentType == Types.FAIRY ||
                    currentType == Types.FIGHTING ||
                    currentType == Types.POISON;
        }
        if (CURRENT_WEATHER == Weather.WINDY) {
            return currentType == Types.FLYING ||
                    currentType == Types.PSYCHIC ||
                    currentType == Types.DRAGON;
        }
        if (CURRENT_WEATHER == Weather.SNOWY) {
            return currentType == Types.ICE ||
                    currentType == Types.STEEL;
        }
        if (CURRENT_WEATHER == Weather.FOGGY) {
            return currentType == Types.GHOST ||
                    currentType == Types.DARK;
        }
        return false;
    } // End getWeatherBonus()

} // End Class
