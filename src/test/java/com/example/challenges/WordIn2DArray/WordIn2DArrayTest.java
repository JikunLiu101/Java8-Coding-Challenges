package com.example.challenges.WordIn2DArray;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordIn2DArrayTest {

    private WordIn2DArray wordIn2DArray;

    @BeforeEach
    void setup(){
        wordIn2DArray = new WordIn2DArray();
    }

    @Test
    void testNotExist1() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCDE";
        assertFalse(wordIn2DArray.exist(board, word));
    }

    @Test
    void testExist1() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        assertTrue(wordIn2DArray.exist(board, word));
    }

    @Test
    void testExist2() {
        char[][] board = {
            {'A'}
        };
        String word = "A";
        assertTrue(wordIn2DArray.exist(board, word));
    }

    @Test
    void testNotExist2() {
        char[][] board = {
                {}
        };
        String word = "A";
        assertFalse(wordIn2DArray.exist(board, word));
    }
}