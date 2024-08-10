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
