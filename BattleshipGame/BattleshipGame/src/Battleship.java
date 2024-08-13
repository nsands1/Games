/*************************************************************************************************
 * File: Battleship.java
 * 
 * Description: This file contains the main entry point for a Battleship game.
 *              It handles the setup for the player and computer, manages the
 *              game loop where players take turns attacking each other, and 
 *              determines the winner.
 *
 * Author: Neil S.
 * Date Created: August 2nd 2024
 * Date Last Edited: August 11th 2024
 ************************************************************************************************/

public class Battleship {

    public static void main(String[] args) {
        Player player = new Player();
        Computer comp = new Computer();

        System.out.println("Welcome Admiral!");
        player.playerSetUp();
        comp.compSetUp();

        while (!player.verifyPlayerWin() && !comp.verifyCompWin()) {

            player.printBoard();
            Coordinate attackComputer = player.playerGuessAttack();
            player.fireAndAttackComp(comp, attackComputer);

            Coordinate attackPlayer = comp.getPredictedCoord(player);
            comp.attackPlayer(player, attackPlayer);

        }

        if (player.verifyPlayerWin()) {
            System.out.println("Congratulations Admiral! You have sunk the enemies' Fleet!");
        } else if (comp.verifyCompWin()) {
            System.out.println("Admiral, our last ship has been sunk...\nWe have lost the battle...");
        }
    }

}
