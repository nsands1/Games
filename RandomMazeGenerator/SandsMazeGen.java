import java.util.Random;

/**
 * @author nsands1@asu.edu
 */
public class SandsMazeGen {
	
	private static final int LEVEL_HEIGHT = 25;
	private static final int LEVEL_WIDTH = 80;

	private static final char MAZE_START = 'S';
	private static final char MAZE_FINISH = 'F';
	private static boolean DRAW_START_FINISH_CHECK = false;

	private static final char ICON_WALL = '\u2588';
	private static final char ICON_BLANK = ' ';
	private static Random Randy = new Random();

	/**
	 * Creates a random maze in a 2D array.
	 *
	 * @see <a href=
	 *      "http://en.wikipedia.org/wiki/Maze_generation_algorithm\u2588Recursive_division_method">Recursive_division_method</a>
	 * @return 2D array containing a maze
	 */
	private static char[][] makeMaze() {
		char level[][] = createBlankLevel();

		makeMazeRecursive(level, 1, 1, LEVEL_WIDTH - 2, LEVEL_HEIGHT - 2);

		return level;
	}

	/**
	 * Creates an empty level of standard level height and width. Level will be
	 * blank but bordered with wall characters.
	 *
	 * @return 2D array containing a maze
	 */
	private static char[][] createBlankLevel() {
		char level[][] = new char[LEVEL_HEIGHT][LEVEL_WIDTH];

		// reset level to be entirely blank
		for (int y = 0; y < LEVEL_HEIGHT; y++)
			for (int x = 0; x < LEVEL_WIDTH; x++)
				level[y][x] = ' ';

		// top barrier
		for (int x = 0; x < LEVEL_WIDTH; x++)
			level[0][x] = ICON_WALL;

		// bottom barrier
		for (int x = 0; x < LEVEL_WIDTH; x++)
			level[LEVEL_HEIGHT - 1][x] = ICON_WALL;

		// left barrier
		for (int y = 0; y < LEVEL_HEIGHT; y++)
			level[y][0] = ICON_WALL;

		// left barrier
		for (int y = 0; y < LEVEL_HEIGHT; y++)
			level[y][LEVEL_WIDTH - 1] = ICON_WALL;

		return level;
	}

	// Implementing Fisher–Yates shuffle
	/**
	 * @param array
	 */
	static void shuffleArray(int[] array) {
		for (int i = array.length - 1; i > 0; i--) {
			int index = Randy.nextInt(i + 1);
			int a = array[index];
			array[index] = array[i];
			array[i] = a;
		}
	}

	/**
	 * Recursive method to make maze chambers, maze walls, and maze doors at random
	 * @param level
	 * @param startX
	 * @param startY
	 * @param endX
	 * @param endY
	 */
	private static void makeMazeRecursive(char level[][], int startX, int startY, int endX, int endY) {

		if (endX - startX >= 1 && endY - startY >= 1) {

			// Find an acceptable dividing point within the chamber
			int randY = startY + Randy.nextInt(endY - (startY));
			int randX = startX + Randy.nextInt(endX - (startX));

			// Prevents build of double walls due to randY, randX position
			if (randY == startY)
				randY = randY + 1;
			if (randX == startX)
				randX = randX + 1;
			if (randY == endY)
				randY = randY - 1;
			if (randX == endX)
				randX = randX - 1;

			// Builds Horizontal Walls
			if (randY != startY && randY != endY) {
				// IF #1 prevents doubling of walls
				// IF #2 prevents adding wall before door
				// IF #3 prevents adding wall after door
				for (int i = startX; i <= endX; i++) {
					if ((level[randY - 1][i] == ICON_BLANK && level[randY + 1][i] == ICON_BLANK)
							|| level[randY][i] == level[randY][randX])
						level[randY][i] = ICON_WALL;
					if ((level[randY][i] == level[randY][endX]) && (level[randY][endX + 1] == ICON_BLANK))
						level[randY][i] = ICON_BLANK;
					if ((level[randY][i] == level[randY][startX]) && (level[randY][startX - 1] == ICON_BLANK))
						level[randY][i] = ICON_BLANK;
					// drawLevel(level);// Uncomment to see maze drawn step by step
				}
			}

			// Builds Vertical Walls
			if (randX != startX && randX != endX) {
				// IF #1 prevents doubling of walls
				// IF #2 prevents adding wall before door
				// IF #3 prevents adding wall after door
				for (int i = startY; i <= endY; i++) {
					if ((level[i][randX - 1] == ICON_BLANK && level[i][randX + 1] == ICON_BLANK)
							|| level[i][randX] == level[randY][randX])
						level[i][randX] = ICON_WALL;
					if ((level[i][randX] == level[endY][randX]) && (level[endY + 1][randX] == ICON_BLANK))
						level[i][randX] = ICON_BLANK;
					if ((level[i][randX] == level[startY][randX]) && (level[startY - 1][randX] == ICON_BLANK))
						level[i][randX] = ICON_BLANK;
					// drawLevel(level);// Uncomment to see maze drawn step by step
				}
			}

			// Three doors randomly chosen at random locations
			// Fisher–Yates shuffle call
			int numDoors = 3;
			int[] doorsToPick = { 0, 1, 2, 3 };
			shuffleArray(doorsToPick);
			for (int i = 0; i < numDoors; i++) {

				switch (doorsToPick[i]) {

				case 0:
					// Make a Door on WEST side of [randY][randX]
					if ((randX) == (startX))
						level[randY][startX] = ICON_BLANK;
					if ((randX - 1) - (startX - 1) == 0)
						level[randY][startX + 1] = ICON_BLANK;
					else
						level[randY][startX + (Randy.nextInt(randX - 1) - (startX - 1))] = ICON_BLANK;

					break;

				case 1:

					// Make a Door on EAST side of [randY][randX]
					level[randY][(randX + 1 + Randy.nextInt(endX - randX))] = ICON_BLANK;

					break;

				case 2:

					// Make a Door on NORTH side of [randY][randX]
					if ((randY) == (startY))
						level[startY][randX] = ICON_BLANK;
					if ((randY - 1) - (startY - 1) == 0)
						level[randY + 1][startX] = ICON_BLANK;
					else
						level[startY + (Randy.nextInt((randY - 1) - (startY - 1)))][randX] = ICON_BLANK;

					break;

				case 3:

					// Make a Door on SOUTH side of [randY][randX]
					level[randY + 1 + Randy.nextInt(endY - randY)][randX] = ICON_BLANK;

					break;

				}
			}

			/// TOP LEFT QUADRANT ///
			makeMazeRecursive(level, startX, startY, randX - 1, randY - 1);

			/// TOP RIGHT QUADRANT ///
			makeMazeRecursive(level, randX, startY, endX, randY - 1);

			/// BOTTOM RIGHT QUADRANT ///
			makeMazeRecursive(level, randX + 1, randY + 1, endX, endY);

			/// BOTTOM LEFT QUADRANT ///
			makeMazeRecursive(level, startX, randY + 1, randX - 1, endY);

		}
	}

	/**
	 * 
	 * @param level
	 * @return level
	 */
	private static char[][] drawStartFinish(char level[][]) {
		int a = 1, b = 1;

		a = Randy.nextInt(a, LEVEL_WIDTH - 1);
		b = Randy.nextInt(b, LEVEL_WIDTH - 1);

		if (a != 0 && b != 0) {

			level[0][a] = MAZE_START;
			level[LEVEL_HEIGHT - 1][b] = MAZE_FINISH;
			return level;
		} else
			return level;
	}

	/**
	 * Displays a level in the console.
	 *
	 * @param level 2D array containing a maze
	 */
	private static void drawLevel(char level[][]) {
		if (DRAW_START_FINISH_CHECK == false) {
			level = drawStartFinish(level);
			DRAW_START_FINISH_CHECK = true;
		}

		int y, x;

		for (y = 0; y < LEVEL_HEIGHT; y++) {
			for (x = 0; x < LEVEL_WIDTH; x++)
				System.out.print(level[y][x]);
			System.out.println();
		}
	}

	/**
	 * Entry point.
	 *
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		System.out.println();
		// show recursive maze
		drawLevel(makeMaze());

	}
}// End SandsMazeGen.java
