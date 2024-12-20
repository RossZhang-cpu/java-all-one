package com.rosszhang.javaallinone.string;

public class FindWord {
    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0) return true;
        boolean flag = false;
        boolean[][] visited = new boolean[board.length][board[0].length];

        char[] chars = word.toCharArray();
        for(int i = 0; i < board.length; ++i){
            for(int j = 0; j < board[0].length; ++j){
               if(chars[0] == board[i][j]){
                    visited[i][j] = true;
                    flag = findWord(board, chars, 1, i, j, flag, visited);
               }
               if(flag) break;
               else visited[i][j] = false;
            }
        }
        return flag;

    }

    public boolean findWord(char[][] board, char[] chars, int index,  int i, int j, boolean flag, boolean[][] visited){
        if(index == chars.length) return true;

        if(!flag && i - 1 >= 0 && board[i - 1][j] == chars[index] && !visited[i - 1][j]) {
            visited[i - 1][j] = true;
            flag = findWord(board, chars, index + 1, i - 1, j, flag, visited);
            visited[i - 1][j] = flag;
        }
        if(!flag && i + 1 < board.length && board[i + 1][j] == chars[index] && !visited[i + 1][j]) {
            visited[i + 1][j] = true;
            flag = findWord(board, chars, index + 1, i + 1, j, flag, visited);
            visited[i + 1][j] = flag;
        }
        if(!flag && j - 1 >= 0 && board[i][j - 1] == chars[index]  && !visited[i][j - 1]) {
            visited[i][j - 1] = true;
            flag = findWord(board, chars, index + 1, i, j - 1, flag, visited);
            visited[i][j - 1] = flag;
        }
        if(!flag && j + 1 < board[0].length && board[i][j + 1] == chars[index] && !visited[i][j + 1]) {
            visited[i][j + 1] = true;
            flag = findWord(board, chars, index + 1, i, j + 1, flag, visited);
            visited[i][j + 1] = flag;
        }

        return flag;
    }

    public static void main(String[] args) {
        FindWord findWord = new FindWord();
        char[][] board = {{'a','b'}};   //{'S','F','C','S'},{'A','D','E','E'}};
        String s = "ab";
        System.out.println(findWord.exist(board, s));
    }
}
