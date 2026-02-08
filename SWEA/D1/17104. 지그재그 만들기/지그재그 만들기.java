public class Solution {
	private static final int SIZE = 10;
	private static final StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int[][] grid = new int[SIZE][SIZE];
		int now = 1;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (i % 2 == 0) {
					grid[i][j] = now++;
				} else {
					grid[i][SIZE - j - 1] = now++;
				}
			}
		}

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				sb.append(grid[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.print(sb);
	}
}
