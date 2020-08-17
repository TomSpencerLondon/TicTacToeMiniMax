package com.codurance;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Board {

  public static final int NO_PLAYER = 0;
  public static final int PLAYER_X = 1;
  public static final int PLAYER_O = 2;
  private int[][] board = new int[3][3];
  public Point computerMove;

  public boolean isGameOver(){
    return hasPlayerWon(PLAYER_X) || hasPlayerWon(PLAYER_O) || getAvailableCells().isEmpty();
  }

  private boolean hasPlayerWon(int player) {
    if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == player)
        ||
        (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == player)
    ){
      return true;
    }

    for (int i = 0; i < 3; i++){
      if ((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == player)
        ||
          (board[0][i] == board[0][i] && board[0][i] == board[2][i] && board[0][i] == player)
      ){
        return true;
      }
    }
    return false;
  }


  private List<Point> getAvailableCells() {
    List<Point> availableCells = new ArrayList<>();

    for (int i = 0; i < 3; i++){
      for (int j = 0; j < 3; j++){
        if (board[i][j] == NO_PLAYER)
          availableCells.add(new Point(i, j));
      }
    }

    return availableCells;
  }

  public boolean placeAMove(Point point, int player){
    if (board[point.x][point.y] != NO_PLAYER)
      return false;

    board[point.x][point.y] = player;

    return true;
  }
}
