import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests for the all the methods in MarbleSolitaireModelImpl class.
 */
public class MarbleSolitaireModelImplTest {

  /**
   * Checks for an Illegal Argument Exception if player is moving marble more than 2 spaces.
   */
  @Test(expected = IllegalArgumentException.class)
  public void moveException1() {
    MarbleSolitaireModel exampleBoard = new MarbleSolitaireModelImpl();
    exampleBoard.move(0, 3, 3, 3);
  }

  /**
   * Checks for an Illegal Argument Exception if player is moving marble less than 2 spaces.
   */
  @Test(expected = IllegalArgumentException.class)
  public void moveException2() {
    MarbleSolitaireModel exampleBoard = new MarbleSolitaireModelImpl();
    exampleBoard.move(0, 3, 1, 3);
  }

  /**
   * Checks for an Illegal Argument Exception if player is not moving the marble.
   */
  @Test(expected = IllegalArgumentException.class)
  public void moveException3() {
    MarbleSolitaireModel exampleBoard = new MarbleSolitaireModelImpl();
    exampleBoard.move(0, 3, 0, 3);
  }

  /**
   * Checks for an Illegal Argument Exception if player is moving orthogonally.
   */
  @Test(expected = IllegalArgumentException.class)
  public void moveException4() {
    MarbleSolitaireModel exampleBoard = new MarbleSolitaireModelImpl(4, 4);
    exampleBoard.move(2, 2, 4, 4);
  }

  /**
   * Checks for an Illegal Argument Exception if player is moving orthogonally.
   */
  @Test(expected = IllegalArgumentException.class)
  public void moveException5() {
    MarbleSolitaireModel exampleBoard = new MarbleSolitaireModelImpl(2, 4);
    exampleBoard.move(4, 2, 2, 4);
  }

  /**
   * Checks for an Illegal Argument Exception if player is trying to move the marble Out of Bounds.
   */
  @Test(expected = IllegalArgumentException.class)
  public void moveException6() {
    MarbleSolitaireModel exampleBoard = new MarbleSolitaireModelImpl();
    exampleBoard.move(2, 1, 0, 1);
  }

  /**
   * Checks for an Illegal Argument Exception if player is trying to move the marble Out of Bounds.
   */
  @Test(expected = IllegalArgumentException.class)
  public void moveException7() {
    MarbleSolitaireModel exampleBoard = new MarbleSolitaireModelImpl();
    exampleBoard.move(2, 0, -4, 0);
  }

  /**
   * Checks for an Illegal Argument Exception if player is trying to move the marble Out of Bounds.
   */
  @Test(expected = IllegalArgumentException.class)
  public void moveException8() {
    MarbleSolitaireModel exampleBoard = new MarbleSolitaireModelImpl();
    exampleBoard.move(6, 3, 8, 3);
  }

  /**
   * Checks for an Illegal Argument Exception if player is trying to move the marble Out of Bounds.
   */
  @Test(expected = IllegalArgumentException.class)
  public void moveException9() {
    MarbleSolitaireModel exampleBoard = new MarbleSolitaireModelImpl();
    exampleBoard.move(2, 6, 2, 8);
  }

  /**
   * Checks for an Illegal Argument Exception if player is trying to move the marble Out of Bounds.
   */
  @Test(expected = IllegalArgumentException.class)
  public void moveException10() {
    MarbleSolitaireModel exampleBoard = new MarbleSolitaireModelImpl();
    exampleBoard.move(2, 0, 2, -2);
  }

  /**
   * Checks for an Illegal Argument Exception if the player is trying to move into a slot that isn't
   * empty.
   */
  @Test(expected = IllegalArgumentException.class)
  public void moveException11() {
    MarbleSolitaireModel exampleBoard = new MarbleSolitaireModelImpl();
    exampleBoard.move(2, 2, 2, 4);
  }

  /**
   * Checks for an Illegal Argument Exception if the player is trying to move move something that
   * isn't a marble.
   */
  @Test(expected = IllegalArgumentException.class)
  public void moveException12() {
    MarbleSolitaireModel exampleBoard = new MarbleSolitaireModelImpl();
    exampleBoard.move(3, 3, 3, 5);
  }

  /**
   * Checks for an Illegal Argument Exception if the player is trying to move move something that
   * isn't a marble.
   */
  @Test(expected = IllegalArgumentException.class)
  public void moveException13() {
    MarbleSolitaireModel exampleBoard = new MarbleSolitaireModelImpl();
    exampleBoard.move(0, 0, 0, 2);
  }

  /**
   * Checks for an Illegal Argument Exception if the middle position does not contain a marble.
   *
   * <p> I understand that this case would get caught for the exception of trying to move a marble
   * into another marble before it even reaches this case, but this was the only thing I could do
   * without changing my code. </p>
   */
  @Test(expected = IllegalArgumentException.class)
  public void moveException14() {
    MarbleSolitaireModel exampleBoard = new MarbleSolitaireModelImpl();
    exampleBoard.move(2, 3, 4, 3);
  }

  /**
   * Tests to see if Exception is thrown when given an invalid empty slot.
   */
  @Test
  public void constExample1() {
    try {
      MarbleSolitaireModel exampleBoard = new MarbleSolitaireModelImpl(0, 0);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid empty cell position (0,0)", e.getMessage());
    }
  }

  /**
   * Tests to see if Exception is thrown when given an invalid empty slot.
   */
  @Test
  public void constExample2() {
    try {
      MarbleSolitaireModel exampleBoard = new MarbleSolitaireModelImpl(-2, 4);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid empty cell position (-2,4)", e.getMessage());
    }
  }

  /**
   * Tests to see if Exception is thrown when given an even armThickness.
   */
  @Test(expected = IllegalArgumentException.class)
  public void constExample3() {
    MarbleSolitaireModel exampleBoard = new MarbleSolitaireModelImpl(2);
    exampleBoard.getGameState();
  }

  /**
   * Tests to see if Exception is thrown when given an armThickness of 0.
   */
  @Test(expected = IllegalArgumentException.class)
  public void constExample4() {
    MarbleSolitaireModel exampleBoard = new MarbleSolitaireModelImpl(0);
    exampleBoard.getGameState();
  }

  /**
   * Tests to see if Exception is thrown when given a negative armThickness.
   */
  @Test(expected = IllegalArgumentException.class)
  public void constExample5() {
    MarbleSolitaireModel exampleBoard = new MarbleSolitaireModelImpl(-3);
    exampleBoard.getGameState();
  }

  /**
   * Tests to see if Exception is thrown when given an invalid position for the empty slot.
   */
  @Test
  public void constExample6() {
    try {
      MarbleSolitaireModel exampleBoard =
              new MarbleSolitaireModelImpl(3, -2, 4);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid empty cell position (-2,4)", e.getMessage());
    }
  }

  /**
   * Tests to see if Exception is thrown when given a negative armThickness.
   */
  @Test(expected = IllegalArgumentException.class)
  public void constExample7() {
    MarbleSolitaireModel exampleBoard =
            new MarbleSolitaireModelImpl(-3, 3, 3);
    exampleBoard.getGameState();
  }

  /**
   * Checks for correct output when trying to move marble into an empty space.
   */
  @Test
  public void moveExample1() {
    MarbleSolitaireModel exampleBoard = new MarbleSolitaireModelImpl();
    exampleBoard.move(1, 3, 3, 3);

    assertEquals("    O O O\n"
            + "    O _ O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", exampleBoard.getGameState());
  }

  /**
   * Checks for correct output when trying to move marble into an empty space (arm thickness = 5).
   */
  @Test
  public void moveExample2() {
    MarbleSolitaireModel exampleBoard = new MarbleSolitaireModelImpl(5);
    exampleBoard.move(6, 4, 6, 6);
    assertEquals("        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O _ _ O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O", exampleBoard.getGameState());
  }

  /**
   * Checks for correct output when trying to move marble into an empty space. The total amount of
   * move is 2 times.
   */
  @Test
  public void moveExample3() {
    MarbleSolitaireModel exampleBoard = new MarbleSolitaireModelImpl();
    exampleBoard.move(1, 3, 3, 3);
    exampleBoard.move(2, 1, 2, 3);

    assertEquals("    O O O\n"
            + "    O _ O\n"
            + "O _ _ O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", exampleBoard.getGameState());
  }

  /**
   * Checks for correct output when trying to move marble into an empty space. The total amount of
   * moves made is 15 (until there is no more valid moves left.
   */
  @Test
  public void moveExample4() {
    MarbleSolitaireModel exampleBoard = new MarbleSolitaireModelImpl();
    exampleBoard.move(1, 3, 3, 3);
    exampleBoard.move(2, 1, 2, 3);
    exampleBoard.move(2, 4, 2, 2);
    exampleBoard.move(2, 6, 2, 4);
    exampleBoard.move(4, 6, 2, 6);
    exampleBoard.move(3, 4, 3, 6);
    exampleBoard.move(4, 4, 4, 6);
    exampleBoard.move(3, 2, 3, 4);
    exampleBoard.move(2, 4, 4, 4);
    exampleBoard.move(4, 3, 4, 5);
    exampleBoard.move(4, 6, 4, 4);
    exampleBoard.move(4, 1, 4, 3);
    exampleBoard.move(5, 3, 3, 3);
    exampleBoard.move(3, 0, 3, 2);
    exampleBoard.move(2, 2, 4, 2);

    assertEquals(false, exampleBoard.isGameOver());
    assertEquals("    O O O\n"
            + "    O _ O\n"
            + "O _ _ _ _ _ O\n"
            + "_ _ _ O _ _ O\n"
            + "O _ O _ O _ _\n"
            + "    O _ O\n"
            + "    O O O", exampleBoard.getGameState());
  }

  /**
   * Checks for correct output when trying to move marble into an empty space. The game is
   * completed/ fully played through.
   */
  @Test
  public void moveExample5() {
    MarbleSolitaireModel exampleBoard = new MarbleSolitaireModelImpl();
    exampleBoard.move(1, 3, 3, 3);
    exampleBoard.move(2, 1, 2, 3);
    exampleBoard.move(2, 4, 2, 2);
    exampleBoard.move(2, 6, 2, 4);
    exampleBoard.move(4, 6, 2, 6);
    exampleBoard.move(3, 4, 3, 6);
    exampleBoard.move(4, 4, 4, 6);
    exampleBoard.move(3, 2, 3, 4);
    exampleBoard.move(2, 4, 4, 4);
    exampleBoard.move(4, 3, 4, 5);
    exampleBoard.move(4, 6, 4, 4);
    exampleBoard.move(4, 1, 4, 3);
    exampleBoard.move(5, 3, 3, 3);
    exampleBoard.move(3, 0, 3, 2);
    exampleBoard.move(2, 2, 4, 2);
    exampleBoard.move(0, 2, 2, 2);
    exampleBoard.move(0, 4, 2, 4);
    exampleBoard.move(5, 2, 3, 2);
    exampleBoard.move(5, 4, 3, 4);
    exampleBoard.move(3, 2, 1, 2);
    exampleBoard.move(3, 4, 1, 4);
    exampleBoard.move(2, 6, 4, 6);

    assertEquals(true, exampleBoard.isGameOver());
    assertEquals("    _ O _\n"
            + "    O _ O\n"
            + "O _ _ _ _ _ _\n"
            + "_ _ _ O _ _ _\n"
            + "O _ _ _ _ _ O\n"
            + "    _ _ _\n"
            + "    O O O", exampleBoard.getGameState());
  }

  /**
   * Checks for correct output when trying to set up a board with arm thickness of 5.
   */
  @Test
  public void stateExample1() {
    MarbleSolitaireModel exampleBoard = new MarbleSolitaireModelImpl(5);
    assertEquals("        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O _ O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O", exampleBoard.getGameState());
  }

  /**
   * Checks for correct output when trying to set up a default board.
   */
  @Test
  public void stateExample2() {
    MarbleSolitaireModel exampleBoard = new MarbleSolitaireModelImpl();
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", exampleBoard.getGameState());
  }

  /**
   * Checks for correct output when trying to set up a default board with specified empty slot.
   */
  @Test
  public void stateExample3() {
    MarbleSolitaireModel exampleBoard = new MarbleSolitaireModelImpl(2, 4);
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O _ O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", exampleBoard.getGameState());
  }

  /**
   * Checks for correct output when trying to set up a board with specified empty slot and
   * armThickness.
   */
  @Test
  public void stateExample4() {
    MarbleSolitaireModel exampleBoard =
            new MarbleSolitaireModelImpl(3, 2, 4);
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O _ O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", exampleBoard.getGameState());
  }

  /**
   * Checks the score of a default board.
   */
  @Test
  public void scoreExample1() {
    MarbleSolitaireModel exampleBoard = new MarbleSolitaireModelImpl();
    assertEquals(32, exampleBoard.getScore());
  }

  /**
   * Checks the score of a default with one move made.
   */
  @Test
  public void scoreExample2() {
    MarbleSolitaireModel exampleBoard = new MarbleSolitaireModelImpl();
    exampleBoard.move(1, 3, 3, 3);
    assertEquals(31, exampleBoard.getScore());
  }

  /**
   * Checks the score of a board w/ armThickness of 5.
   */
  @Test
  public void scoreExample3() {
    MarbleSolitaireModel exampleBoard = new MarbleSolitaireModelImpl(5);
    assertEquals(104, exampleBoard.getScore());
  }

  /**
   * Checks the score of a board w/ armThickness of 5 and one move made.
   */
  @Test
  public void scoreExample4() {
    MarbleSolitaireModel exampleBoard = new MarbleSolitaireModelImpl(5);
    exampleBoard.move(6, 4, 6, 6);
    assertEquals(103, exampleBoard.getScore());
  }

  /**
   * Checks the score of a default board that is a completed game (no more moves left).
   */
  @Test
  public void scoreExample5() {
    MarbleSolitaireModel exampleBoard = new MarbleSolitaireModelImpl();
    exampleBoard.move(1, 3, 3, 3);
    exampleBoard.move(2, 1, 2, 3);
    exampleBoard.move(2, 4, 2, 2);
    exampleBoard.move(2, 6, 2, 4);
    exampleBoard.move(4, 6, 2, 6);
    exampleBoard.move(3, 4, 3, 6);
    exampleBoard.move(4, 4, 4, 6);
    exampleBoard.move(3, 2, 3, 4);
    exampleBoard.move(2, 4, 4, 4);
    exampleBoard.move(4, 3, 4, 5);
    exampleBoard.move(4, 6, 4, 4);
    exampleBoard.move(4, 1, 4, 3);
    exampleBoard.move(5, 3, 3, 3);
    exampleBoard.move(3, 0, 3, 2);
    exampleBoard.move(2, 2, 4, 2);
    exampleBoard.move(0, 2, 2, 2);
    exampleBoard.move(0, 4, 2, 4);
    exampleBoard.move(5, 2, 3, 2);
    exampleBoard.move(5, 4, 3, 4);
    exampleBoard.move(3, 2, 1, 2);
    exampleBoard.move(3, 4, 1, 4);
    exampleBoard.move(2, 6, 4, 6);

    assertEquals(true, exampleBoard.isGameOver());
    assertEquals(10, exampleBoard.getScore());
  }

  /**
   * Checks to see if a game is over on a default board.
   */
  @Test
  public void overExample1() {
    MarbleSolitaireModel exampleBoard = new MarbleSolitaireModelImpl();
    assertEquals(false, exampleBoard.isGameOver());
  }

  /**
   * Checks to see if a game is over on a board w/ armThickness of 5.
   */
  @Test
  public void overExample2() {
    MarbleSolitaireModel exampleBoard = new MarbleSolitaireModelImpl(5);
    assertEquals(false, exampleBoard.isGameOver());
  }

  /**
   * Checks to see if a game is over on a board w/ armThickness of 3 and one move made.
   */
  @Test
  public void overExample3() {
    MarbleSolitaireModel exampleBoard = new MarbleSolitaireModelImpl();
    exampleBoard.move(1, 3, 3, 3);
    assertEquals(false, exampleBoard.isGameOver());
  }
}