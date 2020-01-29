package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw04.AbstractSolitaireModel;

/**
 * Creates a representation of the Marble Solitaire game.
 */
public class MarbleSolitaireModelImpl extends AbstractSolitaireModel {

  /**
   * Default Constructor that creates a game board without taking in any parameters (armThickness of
   * 3 and empty slot at (3,3)).
   */
  public MarbleSolitaireModelImpl() {
    this(3, 3, 3);
  }

  /**
   * Construct a game board with an arm thickness of 3 - takes in two parameters (sRow, sCol).
   *
   * @param sRow Row at which the empty slot is in
   * @param sCol Column at which the empty slot is in
   */
  public MarbleSolitaireModelImpl(int sRow, int sCol) {
    this(3, sRow, sCol);
  }

  /**
   * Constructs a game board with a given arm thickness and the empty slot at the center.
   *
   * @param armThickness The number of marbles in the top/bottom row and left/right column
   */
  public MarbleSolitaireModelImpl(int armThickness) {
    this(armThickness, (armThickness * 3 - 2) / 2, (armThickness * 3 - 2) / 2);
  }

  /**
   * Constructs a game board with the given arm thickness, row and column of the empty slot.
   *
   * @param armThickness The number of marbles in the top/bottom row and left/right column
   * @param sRow         Row at which the empty slot is in
   * @param sCol         Column at which the empty slot is in
   */
  public MarbleSolitaireModelImpl(int armThickness, int sRow, int sCol) {
    super(armThickness, sRow, sCol);
  }

  /**
   * Initializes the English Peg Solitaire board.
   *
   * @param armThickness The number of marbles in the top/bottom row and left/right column
   * @param sRow         Row at which the empty slot is in
   * @param sCol         Column at which the empty slot is in
   */
  @Override
  protected void initialize(int armThickness, int sRow, int sCol) {
    this.board = new GamePiece[3 * armThickness - 2][3 * armThickness - 2];

    int boundary = (board.length - armThickness) / 2;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if ((i < boundary || i >= board.length - boundary)
                && (j < boundary || j >= board.length - boundary)) {
          board[i][j] = GamePiece.OutOfBounds;
        } else {
          board[i][j] = GamePiece.Marble;
        }
      }
    }
  }
}