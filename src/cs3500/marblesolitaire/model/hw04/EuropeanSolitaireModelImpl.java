package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.GamePiece;

/**
 * Creates a representation of the European Peg Solitaire board.
 */
public class EuropeanSolitaireModelImpl extends AbstractSolitaireModel {
  /**
   * Calls the 4th Constructor to create a game board whose sides have length 3, with the empty slot
   * in the center of the board (3, 3).
   */
  public EuropeanSolitaireModelImpl() {
    this(3, 3, 3);
  }

  /**
   * Calls the 4th Constructor to construct a game board with a side length of 3 takes in two
   * parameters (row, col).
   *
   * @param row Row at which the empty slot is in
   * @param col Column at which the empty slot is in
   */
  public EuropeanSolitaireModelImpl(int row, int col) {
    this(3, row, col);
  }

  /**
   * Calls the 4th Constructor to constructs a game board with a given side length and the empty
   * slot at the center.
   *
   * @param sideLength The number of marbles in the top/bottom row and left/right column
   */
  public EuropeanSolitaireModelImpl(int sideLength) {
    this(sideLength, (sideLength * 3 - 2) / 2, (sideLength * 3 - 2) / 2);
  }

  /**
   * Constructs a game board with the given side length, row and column of the empty slot.
   *
   * @param sideLength The number of marbles in the top/bottom row and left/right column
   * @param row        Row at which the empty slot is in
   * @param col        Column at which the empty slot is in
   */
  public EuropeanSolitaireModelImpl(int sideLength, int row, int col) {
    super(sideLength, row, col);
  }

  /**
   * Initializes the European Peg Solitaire board.
   *
   * @param sideLength The number of marbles in the top/bottom row and left/right column
   * @param row        Row at which the empty slot is in
   * @param col        Column at which the empty slot is in
   */
  protected void initialize(int sideLength, int row, int col) {
    this.board = new GamePiece[3 * sideLength - 2][3 * sideLength - 2];

    int centerPoint = (sideLength * 3 - 2) / 2;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (manDistance(i, j, centerPoint, centerPoint) < 2 * sideLength - 1) {
          board[i][j] = GamePiece.Marble;
        } else {
          board[i][j] = GamePiece.OutOfBounds;
        }
      }
    }
  }

  /**
   * Helper method that calculates and returns that Manhattan Distance between the given point and
   * the center point of the board. This will help determine which spots are the marble and which
   * spots are out of bounds.
   *
   * @param currentRow   the current row at which the point is at
   * @param currentCol   the current column at which the point is at
   * @param centerPoint1 the row of the center point
   * @param centerPoint2 the column of the center
   */
  private int manDistance(int currentRow, int currentCol, int centerPoint1, int centerPoint2) {
    return Math.abs(currentRow - centerPoint1) + Math.abs(currentCol - centerPoint2);
  }
}

