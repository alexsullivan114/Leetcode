public class GameOfLife {
    public static void test() {
        int[][] array = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        new GameOfLife().gameOfLife(array);
    }

    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            int[] row = board[i];
            for (int j = 0; j < row.length; j++) {
                int cell = row[j];
                if (cellShouldLive(board, i, j)) {
                    if (cell != 1) {
                        // Previously dead cell turning alive
                        board[i][j] = 2;
                    }
                } else {
                    if (cell != 0) {
                        // Previously alive cell turning dead
                        board[i][j] = 3;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            int[] row = board[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 2) {
                    row[j] = 1;
                } else if (row[j] == 3) {
                    row[j] = 0;
                }
            }
        }
    }

    private boolean cellShouldLive(int[][] board, int cellY, int cellX) {
        int numLiveNeighbors = 0;
        if (validPosition(board, cellY - 1, cellX - 1)) {
            numLiveNeighbors += convertToBinaryLive(board, cellY - 1, cellX - 1);
        }
        if (validPosition(board, cellY - 1, cellX)) {
            numLiveNeighbors += convertToBinaryLive(board, cellY - 1, cellX);
        }
        if (validPosition(board, cellY - 1, cellX + 1)) {
            numLiveNeighbors += convertToBinaryLive(board, cellY - 1, cellX + 1);
        }
        if (validPosition(board, cellY, cellX - 1)) {
            numLiveNeighbors += convertToBinaryLive(board, cellY, cellX - 1);
        }
        if (validPosition(board, cellY, cellX + 1)) {
            numLiveNeighbors += convertToBinaryLive(board, cellY, cellX + 1);
        }
        if (validPosition(board, cellY + 1, cellX - 1)) {
            numLiveNeighbors += convertToBinaryLive(board, cellY + 1, cellX - 1);
        }
        if (validPosition(board, cellY + 1, cellX)) {
            numLiveNeighbors += convertToBinaryLive(board, cellY + 1, cellX);
        }
        if (validPosition(board, cellY + 1, cellX + 1)) {
            numLiveNeighbors += convertToBinaryLive(board, cellY + 1, cellX + 1);
        }
        int cell = board[cellY][cellX];
        if (cell == 0) {
            return numLiveNeighbors == 3;
        } else {
            return numLiveNeighbors == 2 || numLiveNeighbors == 3;
        }
    }

    private boolean validPosition(int[][] board, int y, int x) {
        return y >= 0 && y < board.length && x >= 0 && x < board[0].length;
    }

    private int convertToBinaryLive(int[][] board, int y, int x) {
        int cell = board[y][x];
        if (cell == 1 || cell == 3) {
            return 1;
        } else {
            return 0;
        }
    }
}
