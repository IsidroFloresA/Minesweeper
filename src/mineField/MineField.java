package mineField;

import mvc.Model;
import mvc.Publisher;
import mvc.SimplePublisher;

import java.io.Serializable;
import java.util.Random;

public class MineField extends Model {
	private static final long serialVersionUID = 1L;

	private final int SIZE = 10;
	private final int MINES = 10;
	private boolean[][] mines;
	private int[][] neighborMines;
	private boolean[][] revealed;
	private boolean[][] flagged;
	private boolean gameOver;
	private int safePatches;

	// Track unsaved changes.
	private boolean unsavedChanges = false;

	public MineField() {
		mines = new boolean[SIZE][SIZE];
		neighborMines = new int[SIZE][SIZE];
		revealed = new boolean[SIZE][SIZE];
		flagged = new boolean[SIZE][SIZE];
		gameOver = false;
		safePatches = SIZE * SIZE - MINES;
		placeMines();
		calculateNeighbors();
	}

	private void placeMines() {
		Random rand = new Random();
		int count = 0;
		while (count < MINES) {
			int r = rand.nextInt(SIZE);
			int c = rand.nextInt(SIZE);
			if (!mines[r][c]) {
				mines[r][c] = true;
				count++;
			}
		}
	}

	private void calculateNeighbors() {
		for (int r = 0; r < SIZE; r++) {
			for (int c = 0; c < SIZE; c++) {
				if (!mines[r][c]) {
					int count = 0;
					for (int i = -1; i <= 1; i++) {
						for (int j = -1; j <= 1; j++) {
							int nr = r + i, nc = c + j;
							if (nr >= 0 && nr < SIZE && nc >= 0 && nc < SIZE
									&& mines[nr][nc]) {
								count++;
							}
						}
					}
					neighborMines[r][c] = count;
				}
			}
		}
	}

	/**
	 * Probes the patch at (r, c).
	 * If the patch is mined, the game ends and an exception is thrown.
	 * Otherwise, the patch is marked as revealed and the number of neighboring
	 * mines is returned.
	 */
	public int probe(int r, int c) throws Exception {
		if (gameOver) {
			throw new Exception("Game is over. Restart to play again.");
		}
		if (revealed[r][c]) {
			throw new Exception("Patch already revealed.");
		}
		if (mines[r][c]) {
			gameOver = true;
			revealed[r][c] = true;
			changed();
			// Per specification, probing a mined patch returns -1.
			throw new Exception("Mine hit! Game over.");
		}
		revealed[r][c] = true;
		safePatches--;
		if (safePatches == 0) {
			gameOver = true;
			changed();
			throw new Exception("Victory! All safe patches revealed.");
		}
		changed();
		return neighborMines[r][c];
	}

	/**
	 * Toggles a flag on the patch at (r, c).
	 */
	public void toggleFlag(int r, int c) {
		if (gameOver || revealed[r][c]) {
			return;
		}
		flagged[r][c] = !flagged[r][c];
		changed();
	}

	// Getter methods for the view.
	public boolean isRevealed(int r, int c) {
		return revealed[r][c];
	}

	public boolean isFlagged(int r, int c) {
		return flagged[r][c];
	}

	public boolean isMined(int r, int c) {
		return mines[r][c];
	}

	public int getNeighborMines(int r, int c) {
		return neighborMines[r][c];
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public int getRemainingSafe() {
		return safePatches;
	}
}
