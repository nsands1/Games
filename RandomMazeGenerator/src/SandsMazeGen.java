/*************************************************************************************************
 * File: SandsMazeGen.java
 * 
 * Description: This file generates a solvable maze using a depth-first search (DFS) algorithm 
 *              with a stack for backtracking. The maze is created by randomly choosing directions 
 *              to move and backtracking when no unvisited cells are available. The result is a 
 *              fully utilized maze grid with a single path from start (S) to finish (F).
 * 				Best ran in external terminal window for visibility.
 *
 * Author: Neil S.
 * Date Created: August 11th, 2024
 * Date Last Edited: August 12th, 2024
 ************************************************************************************************/

import java.util.Random;
import java.util.Stack;

public class SandsMazeGen {

	private static final int LEVEL_HEIGHT = 25;
	private static final int LEVEL_WIDTH = 80;

	private static final char MAZE_START = 'S';
	private static final char MAZE_FINISH = 'F';

	private static final char ICON_WALL = '\u2588';
	private static final char ICON_BLANK = ' ';
	private static Random random = new Random();

	private static class Cell {
		int x, y;
		Cell(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static char[][] createMaze() {
		char[][] maze = new char[LEVEL_HEIGHT][LEVEL_WIDTH];
		for (int y = 0; y < LEVEL_HEIGHT; y++) {
			for (int x = 0; x < LEVEL_WIDTH; x++) {
				maze[y][x] = ICON_WALL;
			}
		}

		Stack<Cell> stack = new Stack<>();
		int startX = 1, startY = 1;
		maze[startY][startX] = ICON_BLANK;
		stack.push(new Cell(startX, startY));

		while (!stack.isEmpty()) {
			Cell current = stack.peek();
			int x = current.x, y = current.y;

			int[][] directions = {{0, -2}, {0, 2}, {-2, 0}, {2, 0}};
			shuffleArray(directions);

			boolean moved = false;

			for (int[] direction : directions) {
				int newX = x + direction[0];
				int newY = y + direction[1];

				if (isInBounds(newX, newY) && maze[newY][newX] == ICON_WALL) {
					maze[newY][newX] = ICON_BLANK;
					maze[y + direction[1] / 2][x + direction[0] / 2] = ICON_BLANK; // Knock down the wall between cells
					stack.push(new Cell(newX, newY));
					moved = true;
					break;
				}
			}

			if (!moved) {
				stack.pop();
			}
		}

		return maze;
	}

	private static void shuffleArray(int[][] array) {
		for (int i = array.length - 1; i > 0; i--) {
			int index = random.nextInt(i + 1);
			int[] temp = array[index];
			array[index] = array[i];
			array[i] = temp;
		}
	}

	private static boolean isInBounds(int x, int y) {
		return x > 0 && x < LEVEL_WIDTH - 1 && y > 0 && y < LEVEL_HEIGHT - 1;
	}

	private static char[][] drawStartFinish(char[][] maze) {
		maze[1][1] = MAZE_START;
		maze[LEVEL_HEIGHT - 2][LEVEL_WIDTH - 2] = MAZE_FINISH;
		return maze;
	}

	private static void drawLevel(char[][] level) {
		for (int y = 0; y < LEVEL_HEIGHT; y++) {
			for (int x = 0; x < LEVEL_WIDTH; x++) {
				System.out.print(level[y][x]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		char[][] maze = createMaze();
		maze = drawStartFinish(maze);
		drawLevel(maze);
	}
}