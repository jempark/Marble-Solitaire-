package cs3500.marblesolitaire.model.hw02;

/**
 * Enum class, Game piece, to represent all the pieces that can be found on the board.
 */
public enum GamePiece {
  Marble("O"), Empty("_"), OutOfBounds(" ");

  private final String symbol;

  /**
   * Constructs the symbol to be equal to the value assigned to it.
   *
   * @param value the symbolic representation of the different pieces
   */
  GamePiece(String value) {
    symbol = value;
  }

  /**
   * Returns the symbolic representation of the different pieces.
   */
  public String toString() {
    return symbol;
  }
}