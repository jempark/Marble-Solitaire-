import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests for the all the methods in TriangleSolitaireModelImpl class.
 */
public class TriangleSolitaireModelImplTest {
  /**
   * Checks for an Illegal Argument Exception if player is moving marble more than 2 spaces.
   */
  @Test(expected = IllegalArgumentException.class)
  public void moveException1() {
    MarbleSolitaireModel exampleBoard = new TriangleSolitaireModelImpl();
    exampleBoard.move(1, 1, 4, 4);
  }

  /**
   * Checks for an Illegal Argument Exception if player is moving marble less than 2 spaces.
   */
  @Test(expected = IllegalArgumentException.class)
  public void moveException2() {
    MarbleSolitaireModel exampleBoard = new TriangleSolitaireModelImpl();
    exampleBoard.move(1, 1, 0, 0);
  }

  /**
   * Checks for an Illegal Argument Exception if player is not moving the marble.
   */
  @Test(expected = IllegalArgumentException.class)
  public void moveException3() {
    MarbleSolitaireModel exampleBoard = new TriangleSolitaireModelImpl();
    exampleBoard.move(1, 1, 1, 1);
  }

  /**
   * Checks for an Illegal Argument Exception if player is trying to move the marble Out of Bounds.
   */
  @Test(expected = IllegalArgumentException.class)
  public void moveException4() {
    MarbleSolitaireModel exampleBoard = new TriangleSolitaireModelImpl();
    exampleBoard.move(2, 1, 0, 1);
  }

  /**
   * Checks for an Illegal Argument Exception if player is trying to move the marble Out of Bounds.
   */
  @Test(expected = IllegalArgumentException.class)
  public void moveException5() {
    MarbleSolitaireModel exampleBoard = new TriangleSolitaireModelImpl();
    exampleBoard.move(2, 0, -4, 0);
  }

  /**
   * Checks for an Illegal Argument Exception if player is trying to move the marble Out of Bounds.
   */
  @Test(expected = IllegalArgumentException.class)
  public void moveException6() {
    MarbleSolitaireModel exampleBoard = new TriangleSolitaireModelImpl();
    exampleBoard.move(1, 1, 1, 3);
  }

  /**
   * Checks for an Illegal Argument Exception if player is trying to move the marble Out of Bounds.
   */
  @Test(expected = IllegalArgumentException.class)
  public void moveException7() {
    MarbleSolitaireModel exampleBoard = new TriangleSolitaireModelImpl();
    exampleBoard.move(1, 0, 1, -2);
  }

  /**
   * Checks for an Illegal Argument Exception if the player is trying to move into a slot that isn't
   * empty.
   */
  @Test(expected = IllegalArgumentException.class)
  public void moveException8() {
    MarbleSolitaireModel exampleBoard = new TriangleSolitaireModelImpl();
    exampleBoard.move(1, 1, 3, 1);
  }

  /**
   * Checks for an Illegal Argument Exception if the player is trying to move move something that
   * isn't a marble.
   */
  @Test(expected = IllegalArgumentException.class)
  public void moveException9() {
    MarbleSolitaireModel exampleBoard = new TriangleSolitaireModelImpl();
    exampleBoard.move(0, 0, 2, 0);
  }

  /**
   * Checks for an Illegal Argument Exception if the player is trying to move move something that
   * isn't a marble.
   */
  @Test(expected = IllegalArgumentException.class)
  public void moveException11() {
    MarbleSolitaireModel exampleBoard = new TriangleSolitaireModelImpl();
    exampleBoard.move(1, 3, 1, 1);
  }

  /**
   * Checks for an Illegal Argument Exception if the middle position does not contain a marble.
   */
  @Test(expected = IllegalArgumentException.class)
  public void moveException12() {
    MarbleSolitaireModel exampleBoard = new TriangleSolitaireModelImpl();
    exampleBoard.move(2, 0, 0, 0);
    exampleBoard.move(4, 0, 2, 0);
    exampleBoard.move(3, 2, 3, 0);
    exampleBoard.move(3, 0, 1, 0);
    exampleBoard.move(0, 0, 2, 0);
    exampleBoard.move(3, 3, 3, 1);
  }

  /**
   * Tests to see if Exception is thrown when given an invalid empty slot.
   */
  @Test
  public void constExample1() {
    try {
      MarbleSolitaireModel exampleBoard = new TriangleSolitaireModelImpl(0, 1);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid empty cell position (0,1)", e.getMessage());
    }
  }

  /**
   * Tests to see if Exception is thrown when given an invalid empty slot.
   */
  @Test
  public void constExample2() {
    try {
      MarbleSolitaireModel exampleBoard = new TriangleSolitaireModelImpl(-2, 4);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid empty cell position (-2,4)", e.getMessage());
    }
  }

  /**
   * Tests to see if Exception is thrown when given an dimension of 0.
   */
  @Test(expected = IllegalArgumentException.class)
  public void constExample3() {
    MarbleSolitaireModel exampleBoard = new TriangleSolitaireModelImpl(0);
    exampleBoard.getGameState();
  }

  /**
   * Tests to see if Exception is thrown when given a negative dimension.
   */
  @Test(expected = IllegalArgumentException.class)
  public void constExample4() {
    MarbleSolitaireModel exampleBoard = new TriangleSolitaireModelImpl(-3);
    exampleBoard.getGameState();
  }

  /**
   * Tests to see if Exception is thrown when given an invalid position for the empty slot and a
   * valid dimension.
   */
  @Test
  public void constExample6() {
    try {
      MarbleSolitaireModel exampleBoard =
              new TriangleSolitaireModelImpl(3, -2, 4);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid empty cell position (-2,4)", e.getMessage());
    }
  }

  /**
   * Tests to see if Exception is thrown when given a negative dimension and a valid empty slot.
   */
  @Test(expected = IllegalArgumentException.class)
  public void constExample7() {
    MarbleSolitaireModel exampleBoard =
            new TriangleSolitaireModelImpl(-3, 3, 3);
    exampleBoard.getGameState();
  }

  /**
   * Checks for correct output when trying to move marble into an empty space of a board of
   * dimension 6.
   */
  @Test
  public void moveExample1() {
    MarbleSolitaireModel exampleBoard = new TriangleSolitaireModelImpl(6);
    exampleBoard.move(2, 0, 0, 0);

    assertEquals("     O\n" +
            "    _ O\n" +
            "   _ O O\n" +
            "  O O O O\n" +
            " O O O O O\n" +
            "O O O O O O", exampleBoard.getGameState());
  }

  /**
   * Checks for correct output when trying to move marble into an empty space (dimension = 7 and
   * empty slot is located at (6,6).
   */
  @Test
  public void moveExample2() {
    MarbleSolitaireModel exampleBoard = new TriangleSolitaireModelImpl(7, 6, 6);
    exampleBoard.move(4, 4, 6, 6);
    assertEquals("      O\n" +
            "     O O\n" +
            "    O O O\n" +
            "   O O O O\n" +
            "  O O O O _\n" +
            " O O O O O _\n" +
            "O O O O O O O", exampleBoard.getGameState());
  }

  /**
   * Checks for correct output when trying to move marble into an empty space. The total amount of
   * move is 2 times.
   */
  @Test
  public void moveExample3() {
    MarbleSolitaireModel exampleBoard = new TriangleSolitaireModelImpl();
    exampleBoard.move(2, 0, 0, 0);
    exampleBoard.move(4, 0, 2, 0);

    assertEquals("    O\n" +
            "   _ O\n" +
            "  O O O\n" +
            " _ O O O\n" +
            "_ O O O O", exampleBoard.getGameState());
  }

  /**
   * Checks for correct output when trying to move marble into an empty space. The total amount of
   * moves made is 7.
   */
  @Test
  public void moveExample4() {
    MarbleSolitaireModel exampleBoard = new TriangleSolitaireModelImpl();
    exampleBoard.move(2, 0, 0, 0);
    exampleBoard.move(4, 0, 2, 0);
    exampleBoard.move(3, 2, 3, 0);
    exampleBoard.move(3, 0, 1, 0);
    exampleBoard.move(0, 0, 2, 0);
    exampleBoard.move(1, 1, 3, 1);
    exampleBoard.move(4, 2, 4, 0);

    assertEquals(false, exampleBoard.isGameOver());
    assertEquals("    _\n" +
            "   _ _\n" +
            "  O _ O\n" +
            " _ O _ O\n" +
            "O _ _ O O", exampleBoard.getGameState());
  }

  /**
   * Checks for correct output when trying to move marble into an empty space. The game is
   * completed/ fully played through.
   */
  @Test
  public void moveExample5() {
    MarbleSolitaireModel exampleBoard = new TriangleSolitaireModelImpl();
    exampleBoard.move(2, 0, 0, 0);
    exampleBoard.move(4, 0, 2, 0);
    exampleBoard.move(3, 2, 3, 0);
    exampleBoard.move(3, 0, 1, 0);
    exampleBoard.move(0, 0, 2, 0);
    exampleBoard.move(1, 1, 3, 1);
    exampleBoard.move(4, 2, 4, 0);
    exampleBoard.move(4, 4, 4, 2);
    exampleBoard.move(2, 2, 4, 4);

    assertEquals(true, exampleBoard.isGameOver());
    assertEquals("    _\n" +
            "   _ _\n" +
            "  O _ _\n" +
            " _ O _ _\n" +
            "O _ O _ O", exampleBoard.getGameState());
  }

  /**
   * Checks for correct output when trying to set up a default board with no inputs.
   */
  @Test
  public void stateExample1() {
    MarbleSolitaireModel exampleBoard = new TriangleSolitaireModelImpl();
    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", exampleBoard.getGameState());
  }

  /**
   * Checks for correct output when trying to set up a board with a given dimension.
   */
  @Test
  public void stateExample2() {
    MarbleSolitaireModel exampleBoard = new TriangleSolitaireModelImpl(7);
    assertEquals("      _\n" +
            "     O O\n" +
            "    O O O\n" +
            "   O O O O\n" +
            "  O O O O O\n" +
            " O O O O O O\n" +
            "O O O O O O O", exampleBoard.getGameState());
  }

  /**
   * Checks for correct output when trying to set up a default board with specified empty slot.
   */
  @Test
  public void stateExample3() {
    MarbleSolitaireModel exampleBoard = new TriangleSolitaireModelImpl(3, 1);
    assertEquals("    O\n" +
            "   O O\n" +
            "  O O O\n" +
            " O _ O O\n" +
            "O O O O O", exampleBoard.getGameState());
  }

  /**
   * Checks for correct output when trying to set up a board with specified empty slot and
   * dimension.
   */
  @Test
  public void stateExample4() {
    MarbleSolitaireModel exampleBoard =
            new TriangleSolitaireModelImpl(7, 6, 6);
    assertEquals("      O\n" +
            "     O O\n" +
            "    O O O\n" +
            "   O O O O\n" +
            "  O O O O O\n" +
            " O O O O O O\n" +
            "O O O O O O _", exampleBoard.getGameState());
  }

  /**
   * Checks the score of a default board.
   */
  @Test
  public void scoreExample1() {
    MarbleSolitaireModel exampleBoard = new TriangleSolitaireModelImpl();
    assertEquals(14, exampleBoard.getScore());
  }

  /**
   * Checks the score of a default with one move made.
   */
  @Test
  public void scoreExample2() {
    MarbleSolitaireModel exampleBoard = new TriangleSolitaireModelImpl();
    exampleBoard.move(2, 0, 0, 0);
    assertEquals(13, exampleBoard.getScore());
  }

  /**
   * Checks the score of a board w/ dimension of 7.
   */
  @Test
  public void scoreExample3() {
    MarbleSolitaireModel exampleBoard = new TriangleSolitaireModelImpl(7);
    assertEquals(27, exampleBoard.getScore());
  }

  /**
   * Checks the score of a board w/ dimension of 7 and one move made.
   */
  @Test
  public void scoreExample4() {
    MarbleSolitaireModel exampleBoard = new TriangleSolitaireModelImpl(7);
    exampleBoard.move(2, 0, 0, 0);
    assertEquals(26, exampleBoard.getScore());
  }

  /**
   * Checks the score of a default board that is a completed game (no more moves left).
   */
  @Test
  public void scoreExample5() {
    MarbleSolitaireModel exampleBoard = new TriangleSolitaireModelImpl();
    exampleBoard.move(2, 0, 0, 0);
    exampleBoard.move(4, 0, 2, 0);
    exampleBoard.move(3, 2, 3, 0);
    exampleBoard.move(3, 0, 1, 0);
    exampleBoard.move(0, 0, 2, 0);
    exampleBoard.move(1, 1, 3, 1);
    exampleBoard.move(4, 2, 4, 0);
    exampleBoard.move(4, 4, 4, 2);
    exampleBoard.move(2, 2, 4, 4);

    assertEquals("" +
            "    _\n" +
            "   _ _\n" +
            "  O _ _\n" +
            " _ O _ _\n" +
            "O _ O _ O", exampleBoard.getGameState());

    assertEquals(true, exampleBoard.isGameOver());
    assertEquals(5, exampleBoard.getScore());
  }

  /**
   * Checks to see if a game is over on a default board.
   */
  @Test
  public void overExample1() {
    MarbleSolitaireModel exampleBoard = new TriangleSolitaireModelImpl();
    assertEquals(false, exampleBoard.isGameOver());
  }

  /**
   * Checks to see if a game is over on a board w/ dimension of 1.
   */
  @Test
  public void overExample2() {
    MarbleSolitaireModel exampleBoard = new TriangleSolitaireModelImpl(1);
    assertEquals(true, exampleBoard.isGameOver());
  }

  /**
   * Checks to see if a game is over on a default board and one move made.
   */
  @Test
  public void overExample3() {
    MarbleSolitaireModel exampleBoard = new TriangleSolitaireModelImpl();
    exampleBoard.move(2, 0, 0, 0);
    assertEquals(false, exampleBoard.isGameOver());
  }
}