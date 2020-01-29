package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.GamePiece;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Abstract Class for the different model implementations for the Marble Solitaire game.
 */
public abstract class AbstractSolitaireModel implements MarbleSolitaireModel {
  protected GamePiece[][] board;

  /**
   * Constructs a game board with the given arm thickness, row and column of the empty slot.
   *
   * @param armThickness The number of marbles in the top/bottom row and left/right column
   * @param sRow         Row at which the empty slot is in
   * @param sCol         Column at which the empty slot is in
   */
  public AbstractSolitaireModel(int armThickness, int sRow, int sCol) {
    /**
     * Checks if the armThickness is valid then proceeds to initialize the board before checking if
     * the empty slot is valid. If it is valid, then set the given slot to an empty slot.
     */
    isValidArmThickness(armThickness);
    initialize(armThickness, sRow, sCol);
    isValidEmptySlot(sRow, sCol);
    board[sRow][sCol] = GamePiece.Empty;
  }

  /**
   * Initializes the game board.
   *
   * @param armThickness The number of marbles in the top/bottom row and left/right column
   * @param sRow         Row at which the empty slot is in
   * @param sCol         Column at which the empty slot is in
   */
  protected void initialize(int armThickness, int sRow, int sCol) {
    /**
     * Nothing to do in the abstract class because it will be overridden in the sub class of the
     * specific game boards.
     */
  }

  /**
   * Move a single marble from a given position to another given position. A move is valid only if
   * the from and to positions are valid. Specific implementations may place additional constraints
   * on the validity of a move.
   *
   * @param fromRow the row number of the position to be moved from (starts at 0)
   * @param fromCol the column number of the position to be moved from (starts at 0)
   * @param toRow   the row number of the position to be moved to (starts at 0)
   * @param toCol   the column number of the position to be moved to (starts at 0)
   * @throws IllegalArgumentException if the move is not possible
   */
  public void move(int fromRow, int fromCol, int toRow, int toCol)
          throws IllegalArgumentException {
    if (isValidMove(fromRow, fromCol, toRow, toCol)) {
      board[fromRow][fromCol] = GamePiece.Empty;
      board[toRow][toCol] = GamePiece.Marble;
      board[(fromRow + toRow) / 2][(fromCol + toCol) / 2] = GamePiece.Empty;
    } else {
      throw new IllegalArgumentException("Please input a valid move.");
    }
  }

  /**
   * Determine and return if the game is over or not. A game is over if no more moves can be made.
   *
   * @return true if the game is over, false otherwise
   */
  @Override
  public boolean isGameOver() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == GamePiece.Marble) {
          if (hasValidMoves(i, j)) {
            return false;
          }
        }
      }
    }
    return true;
  }

  /**
   * Return a string that represents the current state of the board. The string should have one line
   * per row of the game board. Each slot on the game board is a single character (O, X or space for
   * a marble, empty and invalid position respectively). Slots in a row should be separated by a
   * space. Each row has no space before the first slot and after the last slot.
   *
   * @return the game state as a string
   */
  @Override
  public String getGameState() {
    /**
     * Iterates through the board and adds the toString of the pieces to gameState.
     */
    String gameState = "";
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        /**
         * First splits the board in half and checks if the latter part of the board have
         * Out of bounds.
         */
        if (!(board[i][j] == GamePiece.OutOfBounds && j > board.length / 2)) {
          gameState += board[i][j].toString();
        }

        /**
         * If the next game piece is not an Out of Bounds, add a space.
         * If it is an Out of Bounds, only add a space if it's from the first half of the board.
         */
        if (j < board.length - 1 && board[i][j + 1] != GamePiece.OutOfBounds) {
          gameState += " ";
        } else if (board[i][j] == GamePiece.OutOfBounds && j < board.length / 2) {
          gameState += " ";
        }
      }
      /**
       * Only add a new line if it isn't the last row
       */
      if (i < board.length - 1) {
        gameState += "\n";
      }
    }
    return gameState;
  }

  /**
   * Return the number of marbles currently on the board.
   *
   * @return the number of marbles currently on the board
   */
  @Override
  public int getScore() {
    /**
     * Iterates through the board and adds one to score whenever there is a marble.
     */
    int score = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == GamePiece.Marble) {
          score += 1;
        }
      }
    }
    return score;
  }

  /**
   * Helper method that checks to see if the arm thickness is even or if it's greater than 1 -
   * throws an exception if it is.
   *
   * @param armThickness The number of marbles in the top/bottom row and left/right column
   * @throws IllegalArgumentException if the arm thickness is not a positive odd number
   */
  protected void isValidArmThickness(int armThickness) throws IllegalArgumentException {
    if ((armThickness % 2) == 0 || armThickness <= 1) {
      throw new IllegalArgumentException("Arm Thickness is not a positive odd number "
              + "greater than 1");
    }
  }

  /**
   * Helper method that checks to see if the given center is invalid (out of bounds). is even or if
   * it's greater than 1 - throws an exception if it is.
   *
   * @param sRow Row at which the empty slot is in
   * @param sCol Column at which the empty slot is in
   * @throws IllegalArgumentException if the specified position is invalid
   */
  protected void isValidEmptySlot(int sRow, int sCol) throws IllegalArgumentException {
    if (sRow >= board.length
            || sCol >= board.length
            || sRow < 0
            || sCol < 0
            || board[sRow][sCol] == GamePiece.OutOfBounds) {
      throw new IllegalArgumentException(
              String.format("Invalid empty cell position "
                      + "(" + Integer.toString(sRow) + "," + Integer.toString(sCol) + ")"));
    }
  }

  /**
   * Helper method that checks to see if the given move is a valid move.
   */
  protected boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
    return isOrthogonal(fromRow, fromCol, toRow, toCol) && isNotOutOfBounds(toRow, toCol) &&
            isEmpty(toRow, toCol) && isMoveMarble(fromRow, fromCol) &&
            isOverMarble(fromRow, fromCol, toRow, toCol);
  }

  /**
   * Helper methods that checks if the given move is not orthogonal or more than two.
   */
  protected boolean isOrthogonal(int fromRow, int fromCol, int toRow, int toCol) {
    return (Math.abs(toRow - fromRow) == 2 && toCol == fromCol)
            || (Math.abs(toCol - fromCol) == 2 && toRow == fromRow);
  }

  /**
   * Helper methods that checks if player is trying to move Out of Bounds.
   */
  protected boolean isNotOutOfBounds(int toRow, int toCol) {
    return !(toRow >= board.length
            || toCol >= board.length
            || toRow < 0
            || toCol < 0
            || board[toRow][toCol] == GamePiece.OutOfBounds);
  }

  /**
   * Helper methods that checks if the player is trying to move into a slot that isn't empty.
   */
  protected boolean isEmpty(int toRow, int toCol) {
    return board[toRow][toCol] == GamePiece.Empty;
  }

  /**
   * Helper methods that checks if the player is trying to move something that isn't a marble.
   */
  protected boolean isMoveMarble(int fromRow, int fromCol) {
    return board[fromRow][fromCol] == GamePiece.Marble;
  }

  /**
   * Helper methods that checks if trying to move a marble over a non-marble.
   */
  protected boolean isOverMarble(int fromRow, int fromCol, int toRow, int toCol) {
    if (Math.abs(toRow - fromRow) == 2) {
      if (fromRow < toRow && board[fromRow + 1][fromCol] == GamePiece.Marble) {
        return true;
      } else if (fromRow > toRow && board[fromRow - 1][fromCol] == GamePiece.Marble) {
        return true;
      }
    } else if (Math.abs(toCol - fromCol) == 2) {
      if (fromCol < toCol && board[fromRow][fromCol + 1] == GamePiece.Marble) {
        return true;
      } else if (fromCol > toCol && board[fromRow][fromCol - 1] == GamePiece.Marble) {
        return true;
      }
    }
    return false;
  }

  /**
   * Checks to see if the given fromRow and fromCol has any valid moves left.
   */
  protected boolean hasValidMoves(int fromRow, int fromCol) {
    boolean topRow = this.isValidMove(fromRow, fromCol, fromRow - 2, fromCol);
    boolean botRow = this.isValidMove(fromRow, fromCol, fromRow + 2, fromCol);
    boolean leftCol = this.isValidMove(fromRow, fromCol, fromRow, fromCol - 2);
    boolean rightCol = this.isValidMove(fromRow, fromCol, fromRow, fromCol + 2);

    return topRow || botRow || leftCol || rightCol;
  }
}