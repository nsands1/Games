import java.util.Scanner;

public class Player {

    Boards board = new Boards();
    Scanner scanner = new Scanner(System.in);


    public Player() {
        board.initBoardA();
        board.initBoardB();
    }

    public void fireAndAttackComp(Computer opposition, Coordinate attack) {
        board.printResult(board.resultHitMissComp(attack, opposition));
    }

    public char[][] getBoardA() {
        return board.getBoardA();
    }

    public char[][] getBoardB() {
        return board.getBoardB();
    }

    public void playerSetUp() {
        System.out.println("Prepare your fleet for battle!");
        board.printBoardA();

        /* Position your Aircraft Carrier */
        System.out.println("Your Aircraft Carrier has arrived. (Size 5)");
        System.out.println("What coordinates would you like to position the Aircraft Carrier?");
        System.out.print("Enter the coordinate pair, letter than number: For example 'D6':    ");
        String input = scanner.nextLine();
        while (validateAttackInput(input)  == false) {
            input = "";
            System.out.println("The coordinate pair input you entered is invalid...");
            System.out.println("Enter a valid coordinate pair from the board...");
            input = scanner.nextLine();
        }
        char yCor = 48;
        int xCor = 0;
        int i = 1;
        while (yCor == 48 & xCor == 0) {
            yCor = input.charAt(0);
            xCor = input.charAt(1);
            try {
                i = input.charAt(2);
            } catch (Exception e) {
                /*No value at index 2, Move on*/
            }
        }
        if (xCor == 49) {
            try {
                if (i == 48) {
                    xCor = 10;
                } else {
                    xCor = xCor - 48;
                }
            } catch (Exception e) {}
        } else {
            xCor = xCor - 48;
        }
        Coordinate coord = new Coordinate(yCor, xCor);
        System.out.println("You entered:  " + yCor + xCor +"  ");

        System.out.println("What heading would you like to position the Aircraft Carrier?");
        System.out.println("Enter the Aircraft Carrier's heading: \nNorth : 'n'\nSouth : 's'\nEast : 'e'\nWest : 'w'");
        char direction = scanner.next().charAt(0);
        while (validateDirectionInput(direction) == false) {
            System.out.println("The direction input you entered is invalid...");
            System.out.println("Enter a valid heading: \nNorth : 'n'\nSouth : 's'\nEast : 'e'\nWest : 'w'");
            direction = scanner.next().charAt(0);
        }
        System.out.println("You entered:  '" + direction + "'  ");
        
        Ship aircraftCarrier = new Ship('A', direction, coord);

        while(board.isValidLocation(coord, aircraftCarrier) == false) {
            input = "";

            System.out.println("That is not a valid operating position or heading. Please order the Aircraft Carrier's position and heading again.");
            System.out.println("What coordinates would you like to position the Aircraft Carrier?");
            System.out.print("Enter the coordinate pair, letter than number: For example 'D6':    ");
            input = scanner.nextLine();
            while (validateAttackInput(input)  == false) {
                input = "";
                System.out.println("The coordinate pair input you entered is invalid...");
                System.out.println("Enter a valid coordinate pair from the board...");
                input = scanner.nextLine();
            }
            yCor = 48;
            xCor = 0;
            i = 1;
            while (yCor == 48 & xCor == 0) {
                yCor = input.charAt(0);
                xCor = input.charAt(1);
                try {
                    i = input.charAt(2);
                } catch (Exception e) {
                    /*No value at index 2, Move on*/
                }
            }
            if (xCor == 49) {
                try {
                    if (i == 48) {
                        xCor = 10;
                    } else {
                        xCor = xCor - 48;
                    }
                } catch (Exception e) {}
            } else {
                xCor = xCor - 48;
            }
            coord = new Coordinate(yCor, xCor);
            System.out.println("You entered:  " + yCor + xCor +"  ");
            
            System.out.println("What heading would you like to position the Aircraft Carrier?");
            System.out.println("Enter the Aircraft Carrier's heading: \nNorth : 'n'\nSouth : 's'\nEast : 'e'\nWest : 'w'");
            direction = scanner.next().charAt(0);
            while (validateDirectionInput(direction) == false) {
                System.out.println("The direction input you entered is invalid...");
                System.out.println("Enter a valid heading: \nNorth : 'n'\nSouth : 's'\nEast : 'e'\nWest : 'w'");
                direction = scanner.next().charAt(0);
            }
            System.out.println("You entered:  '" + direction + "'  ");
            
            aircraftCarrier = new Ship('A', direction, coord);
        }

        board.placeShips(coord, aircraftCarrier);
        board.printBoardA();
        scanner.nextLine();
        input = "";

        /* Position your Battleship */
        System.out.println("Your Battleship has arrived. (Size 4)");
        System.out.println("What coordinates would you like to position the Battleship?");
        System.out.println("Enter the coordinate pair: 'D6'");
        input = scanner.nextLine();
        while (validateAttackInput(input)  == false) {
            input = "";
            System.out.println("The coordinate pair input you entered is invalid...");
            System.out.println("Enter a valid coordinate pair from the board...");
            input = scanner.nextLine();
        }
        yCor = 48;
        xCor = 0;
        i = 1;
        while (yCor == 48 & xCor == 0) {
            yCor = input.charAt(0);
            xCor = input.charAt(1);
            try {
                i = input.charAt(2);
            } catch (Exception e) {
                /*No value at index 2, Move on*/
            }
        }
        if (xCor == 49) {
            try {
                if (i == 48) {
                    xCor = 10;
                } else {
                    xCor = xCor - 48;
                }
            } catch (Exception e) {}
        } else {
            xCor = xCor - 48;
        }
        coord = new Coordinate(yCor, xCor);
        System.out.println("You entered:  " + yCor + xCor +"  ");

        System.out.println("What heading would you like to position the Battleship?");
        System.out.println("Enter the Battleship's heading: \nNorth : 'n'\nSouth : 's'\nEast : 'e'\nWest : 'w'");
        direction = scanner.next().charAt(0);
        while (validateDirectionInput(direction) == false) {
            System.out.println("The direction input you entered is invalid...");
            System.out.println("Enter a valid heading: \nNorth : 'n'\nSouth : 's'\nEast : 'e'\nWest : 'w'");
            direction = scanner.next().charAt(0);
        }
        System.out.println("You entered:  '" + direction + "'  ");
        
        Ship battleship = new Ship('B', direction, coord);
        
        while(board.isValidLocation(coord, battleship) == false) {
            input = "";

            System.out.println("That is not a valid operating position or heading. Please order the Battleship's position and heading again.");
            System.out.println("What coordinates would you like to position the Battleship?");
            System.out.print("Enter the coordinate pair, letter than number: For example 'D6':    ");
            input = scanner.nextLine();
            while (validateAttackInput(input)  == false) {
                input = "";
                System.out.println("The coordinate pair input you entered is invalid...");
                System.out.println("Enter a valid coordinate pair from the board...");
                input = scanner.nextLine();
            }
            yCor = 48;
            xCor = 0;
            i = 1;
            while (yCor == 48 & xCor == 0) {
                yCor = input.charAt(0);
                xCor = input.charAt(1);
                try {
                    i = input.charAt(2);
                } catch (Exception e) {
                    /*No value at index 2, Move on*/
                }
            }
            if (xCor == 49) {
                try {
                    if (i == 48) {
                        xCor = 10;
                    } else {
                        xCor = xCor - 48;
                    }
                } catch (Exception e) {}
            } else {
                xCor = xCor - 48;
            }
            coord = new Coordinate(yCor, xCor);
            System.out.println("You entered:  " + yCor + xCor +"  ");
            
            System.out.println("What heading would you like to position the Battleship?");
            System.out.println("Enter the Battleship's heading: \nNorth : 'n'\nSouth : 's'\nEast : 'e'\nWest : 'w'");
            direction = scanner.next().charAt(0);
            while (validateDirectionInput(direction) == false) {
                System.out.println("The direction input you entered is invalid...");
                System.out.println("Enter a valid heading: \nNorth : 'n'\nSouth : 's'\nEast : 'e'\nWest : 'w'");
                direction = scanner.next().charAt(0);
            }
            System.out.println("You entered:  '" + direction + "'  ");
            
            battleship = new Ship('B', direction, coord);
        }

        board.placeShips(coord, battleship);
        board.printBoardA();
        scanner.nextLine();
        input = "";

        /* Position your Destroyer */
        System.out.println("Your Destroyer has arrived. (Size 3)");
        System.out.println("What coordinates would you like to position the Destroyer?");
        System.out.println("Enter the coordinate pair: 'D6'");
        input = scanner.nextLine();
        while (validateAttackInput(input)  == false) {
            input = "";
            System.out.println("The coordinate pair input you entered is invalid...");
            System.out.println("Enter a valid coordinate pair from the board...");
            input = scanner.nextLine();
        }
        yCor = 48;
        xCor = 0;
        i = 1;
        while (yCor == 48 & xCor == 0) {
            yCor = input.charAt(0);
            xCor = input.charAt(1);
            try {
                i = input.charAt(2);
            } catch (Exception e) {
                /*No value at index 2, Move on*/
            }
        }
        if (xCor == 49) {
            try {
                if (i == 48) {
                    xCor = 10;
                } else {
                    xCor = xCor - 48;
                }
            } catch (Exception e) {}
        } else {
            xCor = xCor - 48;
        }
        coord = new Coordinate(yCor, xCor);
        System.out.println("You entered:  " + yCor + xCor +"  ");

        System.out.println("What heading would you like to position the Destroyer?");
        System.out.println("Enter the Destroyer's heading: \nNorth : 'n'\nSouth : 's'\nEast : 'e'\nWest : 'w'");
        direction = scanner.next().charAt(0);
        while (validateDirectionInput(direction) == false) {
            System.out.println("The direction input you entered is invalid...");
            System.out.println("Enter a valid heading: \nNorth : 'n'\nSouth : 's'\nEast : 'e'\nWest : 'w'");
            direction = scanner.next().charAt(0);
        }
        System.out.println("You entered:  '" + direction + "'  ");
        
        Ship destroyer = new Ship('D', direction, coord);
        
        while(board.isValidLocation(coord, destroyer) == false) {
            input = "";

            System.out.println("That is not a valid operating position or heading. Please order the Destroyer's position and heading again.");
            System.out.println("What coordinates would you like to position the Destroyer?");
            System.out.print("Enter the coordinate pair, letter than number: For example 'D6':    ");
            input = scanner.nextLine();
            while (validateAttackInput(input)  == false) {
                input = "";
                System.out.println("The coordinate pair input you entered is invalid...");
                System.out.println("Enter a valid coordinate pair from the board...");
                input = scanner.nextLine();
            }
            yCor = 48;
            xCor = 0;
            i = 1;
            while (yCor == 48 & xCor == 0) {
                yCor = input.charAt(0);
                xCor = input.charAt(1);
                try {
                    i = input.charAt(2);
                } catch (Exception e) {
                    /*No value at index 2, Move on*/
                }
            }
            if (xCor == 49) {
                try {
                    if (i == 48) {
                        xCor = 10;
                    } else {
                        xCor = xCor - 48;
                    }
                } catch (Exception e) {}
            } else {
                xCor = xCor - 48;
            }
            coord = new Coordinate(yCor, xCor);
            System.out.println("You entered:  " + yCor + xCor +"  ");
            
            System.out.println("What heading would you like to position the Destroyer?");
            System.out.println("Enter the Destroyer's heading: \nNorth : 'n'\nSouth : 's'\nEast : 'e'\nWest : 'w'");
            direction = scanner.next().charAt(0);
            while (validateDirectionInput(direction) == false) {
                System.out.println("The direction input you entered is invalid...");
                System.out.println("Enter a valid heading: \nNorth : 'n'\nSouth : 's'\nEast : 'e'\nWest : 'w'");
                direction = scanner.next().charAt(0);
            }
            System.out.println("You entered:  '" + direction + "'  ");
            
            destroyer = new Ship('D', direction, coord);
        }

        board.placeShips(coord, destroyer);
        board.printBoardA();
        scanner.nextLine();
        input = "";

        /* Position your Submarine */
        System.out.println("Your Submarine has arrived. (Size 3)");
        System.out.println("What coordinates would you like to position the Submarine?");
        System.out.println("Enter the coordinate pair: 'D6'");
        input = scanner.nextLine();
        while (validateAttackInput(input)  == false) {
            
            input = "";
            System.out.println("The coordinate pair input you entered is invalid...");
            System.out.println("Enter a valid coordinate pair from the board...");
            input = scanner.nextLine();
        }
        yCor = 48;
        xCor = 0;
        i = 1;
        while (yCor == 48 & xCor == 0) {
            yCor = input.charAt(0);
            xCor = input.charAt(1);
            try {
                i = input.charAt(2);
            } catch (Exception e) {
                /*No value at index 2, Move on*/
            }
        }
        if (xCor == 49) {
            try {
                if (i == 48) {
                    xCor = 10;
                } else {
                    xCor = xCor - 48;
                }
            } catch (Exception e) {}
        } else {
            xCor = xCor - 48;
        }
        coord = new Coordinate(yCor, xCor);
        System.out.println("You entered:  " + yCor + xCor +"  ");

        System.out.println("What heading would you like to position the Submarine?");
        System.out.println("Enter the Submarine's heading: \nNorth : 'n'\nSouth : 's'\nEast : 'e'\nWest : 'w'");
        direction = scanner.next().charAt(0);
        while (validateDirectionInput(direction) == false) {
            System.out.println("The direction input you entered is invalid...");
            System.out.println("Enter a valid heading: \nNorth : 'n'\nSouth : 's'\nEast : 'e'\nWest : 'w'");
            direction = scanner.next().charAt(0);
        }
        System.out.println("You entered:  '" + direction + "'  ");
        
        Ship submarine = new Ship('S', direction, coord);
        
        while(board.isValidLocation(coord, submarine) == false) {
            
            input = "";

            System.out.println("That is not a valid operating position or heading. Please order the Submarine's position and heading again.");
            System.out.println("What coordinates would you like to position the Submarine?");
            System.out.print("Enter the coordinate pair, letter than number: For example 'D6':    ");
            input = scanner.nextLine();
            while (validateAttackInput(input)  == false) {
                
                input = "";
                System.out.println("The coordinate pair input you entered is invalid...");
                System.out.println("Enter a valid coordinate pair from the board...");
                input = scanner.nextLine();
            }
            yCor = 48;
            xCor = 0;
            i = 1;
            while (yCor == 48 & xCor == 0) {
                yCor = input.charAt(0);
                xCor = input.charAt(1);
                try {
                    i = input.charAt(2);
                } catch (Exception e) {
                    /*No value at index 2, Move on*/
                }
            }
            if (xCor == 49) {
                try {
                    if (i == 48) {
                        xCor = 10;
                    } else {
                        xCor = xCor - 48;
                    }
                } catch (Exception e) {}
            } else {
                xCor = xCor - 48;
            }
            coord = new Coordinate(yCor, xCor);
            System.out.println("You entered:  " + yCor + xCor +"  ");
            
            System.out.println("What heading would you like to position the Submarine?");
            System.out.println("Enter the Submarine's heading: \nNorth : 'n'\nSouth : 's'\nEast : 'e'\nWest : 'w'");
            direction = scanner.next().charAt(0);
            while (validateDirectionInput(direction) == false) {
                System.out.println("The direction input you entered is invalid...");
                System.out.println("Enter a valid heading: \nNorth : 'n'\nSouth : 's'\nEast : 'e'\nWest : 'w'");
                direction = scanner.next().charAt(0);
            }
            System.out.println("You entered:  '" + direction + "'  ");
            
            submarine = new Ship('S', direction, coord);
        }

        board.placeShips(coord, submarine);
        board.printBoardA();
        scanner.nextLine();
        input = "";

        /* Position your Patrol Boat */
        System.out.println("Your Patrol Boat has arrived. (Size 2)");
        System.out.println("What coordinates would you like to position the Patrol Boat?");
        System.out.println("Enter the coordinate pair: 'D6'");
        input = scanner.nextLine();
        while (validateAttackInput(input)  == false) {
            
            input = "";
            System.out.println("The coordinate pair input you entered is invalid...");
            System.out.println("Enter a valid coordinate pair from the board...");
            input = scanner.nextLine();
        }
        yCor = 48;
        xCor = 0;
        i = 1;
        while (yCor == 48 & xCor == 0) {
            yCor = input.charAt(0);
            xCor = input.charAt(1);
            try {
                i = input.charAt(2);
            } catch (Exception e) {
                /*No value at index 2, Move on*/
            }
        }
        if (xCor == 49) {
            try {
                if (i == 48) {
                    xCor = 10;
                } else {
                    xCor = xCor - 48;
                }
            } catch (Exception e) {}
        } else {
            xCor = xCor - 48;
        }
        coord = new Coordinate(yCor, xCor);
        System.out.println("You entered:  " + yCor + xCor +"  ");

        System.out.println("What heading would you like to position the Patrol Boat?");
        System.out.println("Enter the Patrol Boat's heading: \nNorth : 'n'\nSouth : 's'\nEast : 'e'\nWest : 'w'");
        direction = scanner.next().charAt(0);
        while (validateDirectionInput(direction) == false) {
            System.out.println("The direction input you entered is invalid...");
            System.out.println("Enter a valid heading: \nNorth : 'n'\nSouth : 's'\nEast : 'e'\nWest : 'w'");
            direction = scanner.next().charAt(0);
        }
        System.out.println("You entered:  '" + direction + "'  ");
        
        Ship patrolBoat = new Ship('P', direction, coord);
        
        while(board.isValidLocation(coord, patrolBoat) == false) {
            
            input = "";

            System.out.println("That is not a valid operating position or heading. Please order the Patrol Boat's position and heading again.");
            System.out.println("What coordinates would you like to position the Patrol Boat?");
            System.out.print("Enter the coordinate pair, letter than number: For example 'D6':    ");
            input = scanner.nextLine();
            while (validateAttackInput(input)  == false) {
                
                input = "";
                System.out.println("The coordinate pair input you entered is invalid...");
                System.out.println("Enter a valid coordinate pair from the board...");
                input = scanner.nextLine();
            }
            yCor = 48;
            xCor = 0;
            i = 1;
            while (yCor == 48 & xCor == 0) {
                yCor = input.charAt(0);
                xCor = input.charAt(1);
                try {
                    i = input.charAt(2);
                } catch (Exception e) {
                    /*No value at index 2, Move on*/
                }
            }
            if (xCor == 49) {
                try {
                    if (i == 48) {
                        xCor = 10;
                    } else {
                        xCor = xCor - 48;
                    }
                } catch (Exception e) {}
            } else {
                xCor = xCor - 48;
            }
            coord = new Coordinate(yCor, xCor);
            System.out.println("You entered:  " + yCor + xCor +"  ");
            
            System.out.println("What heading would you like to position the Patrol Boat?");
            System.out.println("Enter the Patrol Boat's heading: \nNorth : 'n'\nSouth : 's'\nEast : 'e'\nWest : 'w'");
            direction = scanner.next().charAt(0);
            while (validateDirectionInput(direction) == false) {
                System.out.println("The direction input you entered is invalid...");
                System.out.println("Enter a valid heading: \nNorth : 'n'\nSouth : 's'\nEast : 'e'\nWest : 'w'");
                direction = scanner.next().charAt(0);
            }

            System.out.println("You entered:  '" + direction + "'  ");
            patrolBoat = new Ship('P', direction, coord);
        }

        board.placeShips(coord, patrolBoat);
        board.printBoardA();
        scanner.nextLine();
        input = "";
        System.out.println("Your fleet is ready for battle!\n\n");

    }

    public Coordinate playerGuessAttack() {
        System.out.println("Enter the coordinate pair for your targeted attack: 'D6'");
        String input = scanner.nextLine();
        while (validateAttackInput(input)  == false) {
            
            input = "";
            System.out.println("The coordinate pair input you entered is invalid...");
            System.out.println("Enter a valid coordinate pair from the board...");
            input = scanner.nextLine();
        }
        char yCor = 48;
        int xCor = 0;
        int i = 1;
        while (yCor == 48 & xCor == 0) {
            yCor = input.charAt(0);
            xCor = input.charAt(1);
            try {
                i = input.charAt(2);
            } catch (Exception e) {
                /*No value at index 2, Move on*/
            }
        }
        if (xCor == 49) {
            try {
                if (i == 48) {
                    xCor = 10;
                } else {
                    xCor = xCor - 48;
                }
            } catch (Exception e) {}
        } else {
            xCor = xCor - 48;
        }
        Coordinate attack = new Coordinate(yCor, xCor);

        while (board.isValidAttack(attack) == false) {
            input = "";
            System.out.println("That is not a valid target coordinate! Try again: ");
            System.out.println("Enter the coordinate pair for your targeted attack: 'D6'");
            input = scanner.nextLine();

            while (validateAttackInput(input)  == false) {
                
                input = "";
                System.out.println("The coordinate pair input you entered is invalid...");
                System.out.println("Enter a valid coordinate pair from the board...");
                input = scanner.nextLine();
            }
            yCor = 48;
            xCor = 0;
            i = 1;
            while (yCor == 48 & xCor == 0) {
                yCor = input.charAt(0);
                xCor = input.charAt(1);
                try {
                    i = input.charAt(2);
                } catch (Exception e) {
                    /*No value at index 2, Move on*/
                }
            }
            if (xCor == 49) {
                try {
                    if (i == 48) {
                        xCor = 10;
                    } else {
                        xCor = xCor - 48;
                    }
                } catch (Exception e) {}
            } else {
                xCor = xCor - 48;
            }
            attack = new Coordinate(yCor, xCor);
        }

        return attack;
    }

    public void printBoard() {
        System.out.println("The Advisary Fleet:");
        this.board.printBoardB();
        System.out.println("Your Fleet:");
        this.board.printBoardA();
    }

    public boolean verifyPlayerWin() {
        if (board.getNumAircraftComp() == 5 && board.getNumBattleshipComp() == 4 && board.getNumDestroyerComp() == 3 && board.getNumSubmarineComp() == 3 && board.getNumPatrolBoatComp() == 2) {
            return true;
        }
        return false;
    }

    public static boolean validateAttackInput(String input) {
        input = input.replaceAll("[\\s\\p{Punct}]", "");
    
        if (input.length() < 2 || input.length() > 3) {
            return false;
        }
    
        if (!Character.isLetter(input.charAt(0))) {
            return false;
        }
        char yCor = Character.toUpperCase(input.charAt(0));
        if (yCor < 'A' || yCor > 'J') {
            return false;
        }
    
        if (input.length() < 2 || !Character.isDigit(input.charAt(1))) {
            return false;
        }
        char secondChar = input.charAt(1);
        if (secondChar < '1' || secondChar > '9') {
            return false;
        }
        int xCor = Character.getNumericValue(secondChar);
    
        if (xCor == 1 && input.length() == 3) {
            if (input.charAt(2) != '0') {
                return false;
            }
        }
    
        return true;
    }
    
    

    public static boolean validateDirectionInput(char direction) {
        // Convert to lowercase if the input is capitalized
        direction = Character.toLowerCase(direction);
    
        // Check if the direction is one of the valid options
        switch (direction) {
            case 'n':
            case 's':
            case 'e':
            case 'w':
                return true;
            default:
                return false;
        }
    }    
    
}
