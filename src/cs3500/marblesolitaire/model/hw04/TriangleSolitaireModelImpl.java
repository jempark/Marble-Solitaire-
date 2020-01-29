package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.GamePiece;

/**
 * Creates a representation of the Triangle Peg Solitaire board.
 */
public class TriangleSolitaireModelImpl extends AbstractSolitaireModel {
  /**
   * Default constructor (no parameters) that creates a 5-row game with the empty slot at (0,0).
   */
  public TriangleSolitaireModelImpl() {
    this(5, 0, 0);
  }

  /**
   * Constructor with the parameter dimensions that creates a game with the specified dimension and
   * the empty slot at (0,0).
   *
   * @param dimensions number of slots in the bottom-most row
   */
  public TriangleSolitaireModelImpl(int dimensions) {
    this(dimensions, 0, 0);
  }

  /**
   * Constructor with two parameters (row,col) that creates a 5-row game with the empty slot at the
   * specified position.
   *
   * @param row Row at which the empty slot is in
   * @param col Column at which the empty slot is in
   */
  public TriangleSolitaireModelImpl(int row, int col) {
    this(5, row, col);
  }

  /**
   * Constructor with three parameters (dimensions,row,col) that creates a game with the specified
   * dimension and an empty slot at the specified row and column.
   *
   * @param dimensions number of slots in the bottom-most
   * @param row        Row at which the empty slot is in
   * @param col        Column at which the empty slot is in
   */
  public TriangleSolitaireModelImpl(int dimensions, int row, int col) {
    super(dimensions, row, col);
  }

  /**
   * Initializes the pegs in the game in the triangle solitaire model.
   */
  @Override
  protected void initialize(int dimensions, int row, int col) {
    this.board = new GamePiece[dimensions][dimensions];

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (i >= j) {
          this.board[i][j] = GamePiece.Marble;
        } else {
          this.board[i][j] = GamePiece.OutOfBounds;
        }
      }
    }
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
      /**
       * First finds the amount preceding spaces before the first marble to make the triangular
       * format then adds it to the board.
       */
      int precedingSpaces = board.length - 1 - i;
      while (precedingSpaces != 0) {
        gameState += " ";
        precedingSpaces--;
      }
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == GamePiece.Marble ||
                board[i][j] == GamePiece.Empty) {
          gameState += board[i][j].toString();
        } else if (board[i][j] == GamePiece.OutOfBounds) {
          break;
        }

        /**
         * If the next game piece is not an Out of Bounds, add a space.
         * If it is an Out of Bounds, only add a space if it's from the first half of the board.
         */
        if (j < board.length - 1 && board[i][j + 1] != GamePiece.OutOfBounds) {
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
   * Helper method that checks to see if the arm thickness is even or if it's greater than 1 -
   * throws an exception if it is. Overrides the method in the Abstract class.
   *
   * @param dimensions The number of marbles in the top/bottom row and left/right column
   * @throws IllegalArgumentException if the arm thickness is not a positive odd number
   */
  @Override
  protected void isValidArmThickness(int dimensions) throws IllegalArgumentException {
    if (dimensions <= 0) {
      throw new IllegalArgumentException("The specified Dimension is invalid (non-positive).");
    }
  }

  /**
   * Helper method that checks to see if the given center is invalid (out of bounds). is even or if
   * it's greater than 1 - throws an exception if it is. Overrides the method in the Abstract
   * class.
   *
   * @param row Row at which the empty slot is in
   * @param col Column at which the empty slot is in
   * @throws IllegalArgumentException if the specified position is invalid
   */
  @Override
  protected void isValidEmptySlot(int row, int col) throws IllegalArgumentException {
    if (col > row
            || row < 0
            || col < 0
            || board[row][col] == GamePiece.OutOfBounds) {
      throw new IllegalArgumentException(
              String.format("Invalid empty cell position "
                      + "(" + Integer.toString(row) + "," + Integer.toString(col) + ")"));
    }
  }

  /**
   * Helper method that checks to see if the given move is a valid move. Overrides the method in the
   * Abstract class.
   */
  @Override
  protected boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
    return isOrthogonal(fromRow, fromCol, toRow, toCol) && isNotOutOfBounds(toRow, toCol) &&
            isEmpty(toRow, toCol) && isMoveMarble(fromRow, fromCol) &&
            isOverMarble(fromRow, fromCol, toRow, toCol);
  }

  /**
   * Helper methods that checks if the marble is moved two spaces. Overrides the method in the
   * abstract method + doesn't actually check if it's orthogonal in the triangle solitaire case.
   */
  @Override
  protected boolean isOrthogonal(int fromRow, int fromCol, int toRow, int toCol) {
    return (Math.abs(toRow - fromRow) == 2 && Math.abs(toCol - fromCol) == 0)
            || (Math.abs(toRow - fromRow) == 0 && Math.abs(toCol - fromCol) == 2)
            || (Math.abs(toRow - fromRow) == 2 && Math.abs(toCol - fromCol) == 2);
  }

  /**
   * Helper methods that checks if trying to move a marble over a non-marble. Overrides the method
   * in the Abstract class.
   */
  @Override
  protected boolean isOverMarble(int fromRow, int fromCol, int toRow, int toCol) {
    if (Math.abs(toRow - fromRow) == 2 && Math.abs(toCol - fromCol) == 0) {
      if (fromRow < toRow && board[fromRow + 1][fromCol] == GamePiece.Marble) {
        return true;
      } else if (fromRow > toRow && board[fromRow - 1][fromCol] == GamePiece.Marble) {
        return true;
      }
    } else if (Math.abs(toRow - fromRow) == 0 && Math.abs(toCol - fromCol) == 2) {
      if (fromCol < toCol && board[fromRow][fromCol + 1] == GamePiece.Marble) {
        return true;
      } else if (fromCol > toCol && board[fromRow][fromCol - 1] == GamePiece.Marble) {
        return true;
      }
    } else if (Math.abs(toRow - fromRow) == 2 && Math.abs(toCol - fromCol) == 2) {
      if (fromRow < toRow && fromCol < toCol
              && board[fromRow + 1][fromCol + 1] == GamePiece.Marble) {
        return true;
      } else if (fromRow > toRow && fromCol > toCol
              && board[fromRow - 1][fromCol - 1] == GamePiece.Marble) {
        return true;
      }
    }
    return false;
  }

  /**
   * Checks to see if the given fromRow and fromCol has any valid moves left. Overrides the method
   * in the Abstract class.
   */
  @Override
  protected boolean hasValidMoves(int fromRow, int fromCol) {
    boolean leftCol = this.isValidMove(fromRow, fromCol, fromRow, fromCol - 2);
    boolean rightCol = this.isValidMove(fromRow, fromCol, fromRow, fromCol + 2);
    boolean topRow = this.isValidMove(fromRow, fromCol, fromRow - 2, fromCol);
    boolean botRow = this.isValidMove(fromRow, fromCol, fromRow + 2, fromCol);

    boolean lftDiagUp = this.isValidMove(fromRow, fromCol, fromRow - 2, fromCol - 2);
    boolean rgtDiagDown = this.isValidMove(fromRow, fromCol, fromRow + 2, fromCol + 2);

    return topRow || botRow || leftCol || rightCol || lftDiagUp || rgtDiagDown;
  }
}
