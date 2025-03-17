public class MineField {
	private int[][] board;
	private int percentMined;

	private int[] playerPosition = { 0, 0 };

	public static void main(String[] args) {

	}

	public void MineField(int rowCount, int columnCount, int percentMined) {
		this.playerPosition[0] = 0;
		this.playerPosition[1] = 0;
		this.board = new int[rowCount][columnCount];
		this.percentMined = percentMined;
		for (int i = 0; i < columnCount; i++) { // column
			for (int j = 0; j < rowCount; j++) { // row
				board[i][j] = 0;
			}
		}
	}

	public int[] getPlayerPosition() {
		return playerPosition;
	}

	public int[] movePlayer(String heading) {
		switch (heading) {
			case "N":
				this.playerPosition[1] -= 1;
				return this.playerPosition;
			case "NE":
				this.playerPosition[1] -= 1;
				this.playerPosition[0] += 1;
				return this.playerPosition;
			case "E":
				this.playerPosition[0] += 1;
				return this.playerPosition;
			case "SE":
				this.playerPosition[0] += 1;
				this.playerPosition[1] -= 1;
				return this.playerPosition;
			case "S":
				this.playerPosition[1] += 1;
				return this.playerPosition;
			case "SW":
				this.playerPosition[0] -= 1;
				this.playerPosition[1] += 1;
				return this.playerPosition;
			case "W":
				this.playerPosition[0] -= 1;
				return this.playerPosition;
			case "NW":
				this.playerPosition[0] -= 1;
				this.playerPosition[1] -= 1;
				return this.playerPosition;
		}
	}
}
