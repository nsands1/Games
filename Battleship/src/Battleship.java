public class Battleship {

    public static void main(String[] args) {
        Player player = new Player();
        Computer c = new Computer();

        System.out.println("Welcome Admiral!");
        player.playerSetUp();
        c.compSetUp();

        while (!player.verifyPlayerWin(c) && !c.verifyCompW(player)) {

            Coordinate attackComputer = player.playerGuessAttack();
            player.fireAndAttackComp(c, attackComputer);

            Coordinate attackPlayer = c.getPredictedCoord(player);
            c.attackPlayer(player, attackPlayer);

            System.out.println("Your Fleet:");
            player.printBoard(player.getBoardA());
            System.out.println("The advisary Fleet:");
            player.printBoard(player.getBoardB());

        }

        if (player.verifyPlayerWin(c)) {
            System.out.println("Congratulations Admiral! You have sunk the enemies' Fleet!");
        } else if (c.verifyCompW(player)) {
            System.out.println("Admiral, our last ship has been sunk...\nWe have lost the battle...");
        }

    }
    
}
