package design;

public class Valid_Tic_Tac_Toe_State_794 {

  public boolean validTicTacToe(String[] board) {

    int n = board.length;
    char player1 = 'X';
    char player2 = 'O';
    int player1Moves = 0;
    int player2Moves = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int cell = board[i].charAt(j);
        if (player1 == (cell)) player1Moves++;
        else if (player2 == (cell)) player2Moves++;
      }
    }
    System.out.println("player1Moves=" + player1Moves + ", player2Moves=" + player2Moves);
    if (player2Moves > player1Moves) return false;
    if (player1Moves > player2Moves + 1) return false;

    // check multiple winner's conditions
    int rowWinnerCount = 0;
    int colWinnerCount = 0;
    for (int i = 0; i < n; i++) {
      int tmpPlayer1RowWinner = 0;
      int tmpPlayer2RowWinner = 0;
      int tmpPlayer1ColWinner = 0;
      int tmpPlayer2ColWinner = 0;
      for (int j = 0; j < n; j++) {
        int row_cell = board[i].charAt(j);
        int col_cell = board[j].charAt(i);

        if (player1 == (row_cell)) tmpPlayer1RowWinner++;
        else if (player2 == (row_cell)) tmpPlayer2RowWinner++;

        if (player1 == (col_cell)) tmpPlayer1ColWinner++;
        else if (player2 == (col_cell)) tmpPlayer2ColWinner++;

      }
      if (tmpPlayer1RowWinner == n) rowWinnerCount++;
      if (tmpPlayer2RowWinner == n) rowWinnerCount++;

      if (tmpPlayer1ColWinner == n) colWinnerCount++;
      if (tmpPlayer2ColWinner == n) colWinnerCount++;
    }

    if (rowWinnerCount + colWinnerCount > 1) return false;

    return true;

  }

}
