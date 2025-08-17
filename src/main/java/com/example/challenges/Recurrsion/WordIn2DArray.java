package com.example.challenges.Recurrsion;

public class WordIn2DArray {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }

        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (search(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }

        visited[i][j] = true;

        boolean found = search(board, word, i + 1, j, index + 1, visited) ||
                        search(board, word, i - 1, j, index + 1, visited) ||
                        search(board, word, i, j + 1, index + 1, visited) ||
                        search(board, word, i, j - 1, index + 1, visited);

        visited[i][j] = false; // backtrack
        return found;
    }
}
