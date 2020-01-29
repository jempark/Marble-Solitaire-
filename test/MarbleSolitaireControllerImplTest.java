import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;

import org.junit.Test;

import java.io.StringReader;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the all the methods in MarbleSolitaireControllerImpl class.
 */
public class MarbleSolitaireControllerImplTest {

  String testRun(MarbleSolitaireModel model, String inputs) {
    StringBuilder stringBuilderIn = new StringBuilder();
    StringBuilder stringBuilderOut = new StringBuilder();

    stringBuilderIn.append(inputs);

    StringReader input = new StringReader(stringBuilderIn.toString());

    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(input, stringBuilderOut);
    controller.playGame(model);

    return stringBuilderOut.toString();
  }

  /**
   * Tests to see if an IllegalArgumentException is thrown in the ControllerImpl constructer if the
   * ap is null and rd is "valid."
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCtrlConstructor1() {
    StringBuilder stringBuilderIn = new StringBuilder();

    StringReader input = new StringReader(stringBuilderIn.toString());

    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(input, null);
  }

  /**
   * Tests to see if an IllegalArgumentException is thrown in the ControllerImpl constructer if the
   * rd is null and the ap is "valid."
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCtrlConstructor2() {
    StringBuilder stringBuilderOut = new StringBuilder();

    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(null, stringBuilderOut);
  }

  /**
   * Tests to see if an IllegalArgumentException is thrown in the ControllerImpl constructer if the
   * rd/ap are both null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCtrlConstructor3() {
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(null, null);
  }

  /**
   * Tests the output of the game if the user inputs "q" right away (on a default board w/ a
   * specified center).
   */
  @Test
  public void testGameState1() {
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl(0, 3);

    String out = testRun(model, "q");
    assertEquals("    O _ O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", out);
  }

  /**
   * Tests the output of the game if the user moves correctly and quits after one move (default
   * board with a specified sRow and SCol).
   */
  @Test
  public void testGameState2() {
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl(3, 0, 3);

    String out = testRun(model, "3 4 1 4 q");

    assertEquals(true, out.contains("Score: 31\n"));
    assertEquals(true, out.contains("State of game when quit:\n"));
  }

  /**
   * Tests the output of the game if the user makes 9 valid moves and puts q before other valid
   * inputs halfway through (default board).
   */
  @Test
  public void testGameState3() {
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();

    String out = testRun(model, "2 4 4 4 " +
            "3 2 3 4 " +
            "3 5 3 3 " +
            "3 7 3 5 " +
            "5 7 3 7 " +
            "4 5 4 7 " +
            "5 5 5 7 " +
            "4 3 4 5 " +
            "3 5 5 5 Q " +
            "5 4 5 6 ");

    assertEquals(true, out.contains("Score: 23"));
    assertEquals(true, out.contains("State of game when quit:\n"));
  }

  /**
   * Tests the output of the game if the user moves correctly and quits after one move (armThickness
   * of 5 and non-specified empty space).
   */
  @Test
  public void testGameState4() {
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl(5);

    String out = testRun(model, "7 5 7 7 q");

    assertEquals("        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "Score: 104\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O _ _ O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "Score: 103\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O _ _ O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "Score: 103\n", out);
  }

  /**
   * Tests the output of the game if the user plays an entire game out until there are no more valid
   * moves left (Specified amrThickness) (checks it it terminates correctly even if the user inputs
   * more stuff after game ends.
   */
  @Test
  public void testGameState5() {
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();

    String out = testRun(model, "2 4 4 4 " +
            "3 2 3 4 " +
            "3 5 3 3 " +
            "3 7 3 5 " +
            "5 7 3 7 " +
            "4 5 4 7 " +
            "5 5 5 7 " +
            "4 3 4 5 " +
            "3 5 5 5 " +
            "5 4 5 6 " +
            "5 7 5 5 " +
            "5 2 5 4 " +
            "6 4 4 4 " +
            "4 1 4 3 " +
            "3 3 5 3 " +
            "1 3 3 3 " +
            "1 5 3 5 " +
            "6 3 4 3 " +
            "6 5 4 5 " +
            "4 3 2 3 " +
            "4 5 2 5 " +
            "3 7 5 7 " +
            "hello this shouldn't be evaluated.");

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O _ O _ _ O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 29\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O _ O _ O _ _\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 28\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O _ O _ O _ O\n" +
            "O O O O O O _\n" +
            "O O O O O O _\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 27\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O _ O _ O _ O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O _\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 26\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O _ O _ O _ O\n" +
            "O O O O _ _ O\n" +
            "O O O O _ _ O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 25\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O _ O _ O _ O\n" +
            "O O _ _ O _ O\n" +
            "O O O O _ _ O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 24\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O _ O _ _ _ O\n" +
            "O O _ _ _ _ O\n" +
            "O O O O O _ O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 23\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O _ O _ _ _ O\n" +
            "O O _ _ _ _ O\n" +
            "O O O _ _ O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 22\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O _ O _ _ _ O\n" +
            "O O _ _ _ _ O\n" +
            "O O O _ O _ _\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 21\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O _ O _ _ _ O\n" +
            "O O _ _ _ _ O\n" +
            "O _ _ O O _ _\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 20\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O _ O _ _ _ O\n" +
            "O O _ O _ _ O\n" +
            "O _ _ _ O _ _\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 19\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O _ O _ _ _ O\n" +
            "_ _ O O _ _ O\n" +
            "O _ _ _ O _ _\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 18\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O _ _ _ _ _ O\n" +
            "_ _ _ O _ _ O\n" +
            "O _ O _ O _ _\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 17\n" +
            "    _ O O\n" +
            "    _ _ O\n" +
            "O _ O _ _ _ O\n" +
            "_ _ _ O _ _ O\n" +
            "O _ O _ O _ _\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 16\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "O _ O _ O _ O\n" +
            "_ _ _ O _ _ O\n" +
            "O _ O _ O _ _\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 15\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "O _ O _ O _ O\n" +
            "_ _ O O _ _ O\n" +
            "O _ _ _ O _ _\n" +
            "    _ _ O\n" +
            "    O O O\n" +
            "Score: 14\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "O _ O _ O _ O\n" +
            "_ _ O O O _ O\n" +
            "O _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    O O O\n" +
            "Score: 13\n" +
            "    _ O _\n" +
            "    O _ _\n" +
            "O _ _ _ O _ O\n" +
            "_ _ _ O O _ O\n" +
            "O _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    O O O\n" +
            "Score: 12\n" +
            "    _ O _\n" +
            "    O _ O\n" +
            "O _ _ _ _ _ O\n" +
            "_ _ _ O _ _ O\n" +
            "O _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    O O O\n" +
            "Score: 11\n" +
            "    _ O _\n" +
            "    O _ O\n" +
            "O _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "O _ _ _ _ _ O\n" +
            "    _ _ _\n" +
            "    O O O\n" +
            "Score: 10\n" +
            "Game over!\n" +
            "    _ O _\n" +
            "    O _ O\n" +
            "O _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "O _ _ _ _ _ O\n" +
            "    _ _ _\n" +
            "    O O O\n" +
            "Score: 10\n", out);
  }

  /**
   * Tests the output of the game if the user makes valid moves and occasionally gives negative
   * inputs. The game should continue asking for input until a valid move is made and quits when the
   * player inputs "q."
   */
  @Test
  public void testGameState6() {
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();

    String out = testRun(model, "2 4 4 4 " +
            "3 2 3 4 " +
            "3 5 3 3 " +
            "3 7 3 5 " +
            "5 7 3 7 " +
            "4 5 4 7 " +
            "5 5 -5 5 7 " +
            "4 3 4 5 " +
            "3 5 5 -5 5 q");

    assertEquals(true, out.contains("Invalid input: Negative Number"));
    assertEquals(true, out.contains("State of game when quit:\n"));
    assertEquals(true, out.contains("Score: 23"));
  }

  /**
   * Tests the output of the game if the user makes 7 valid moves and gives a negative outRow for
   * and input and our program asks for another valid input. The user would give a valid input and
   * proceed to make 2 more moves and quit the game.
   */
  @Test
  public void testGameState7() {
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();

    String out = testRun(model, "2 4 4 4 " +
            "3 2 3 4 " +
            "3 5 3 3 " +
            "3 7 3 5 " +
            "5 7 3 7 " +
            "4 5 4 7 " +
            "5 5 5 7 " +
            "4 3 -5 -5 q");

    assertEquals(true, out.contains("Invalid input: Negative Number"));
    assertEquals(true, out.contains("State of game when quit:\n"));
    assertEquals(true, out.contains("Score: 25\n"));
  }

  /**
   * Tests the output of the game if the user makes an invalid move and proceeds to quit. The
   * invalid move is a move that tries to move a marble out of bounds.
   */
  @Test
  public void testGameState8() {
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();

    String out = testRun(model, "3 2 1 2 q");

    assertEquals(true, out.contains("Invalid move. Play again. "));
    assertEquals(true, out.contains("Please input a valid move."));
    assertEquals(true, out.contains("State of game when quit:\n"));
    assertEquals(true, out.contains("Score: 32\n"));
  }

  /**
   * Tests the output of the game if the user makes an invalid move and proceeds to quit. The
   * invalid move is a move that tried to move a marble into something other than an empty space.
   */
  @Test
  public void testGameState9() {
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();

    String out = testRun(model, "3 3 3 5 q");

    assertEquals(true, out.contains("Invalid move. Play again. "));
    assertEquals(true, out.contains("Please input a valid move."));
    assertEquals(true, out.contains("State of game when quit:\n"));
    assertEquals(true, out.contains("Score: 32\n"));
  }

  /**
   * Tests the output of the game if the user makes an invalid move and proceeds to quit. The
   * invalid move is if player is moving a marble more than 2 spaces.
   */
  @Test
  public void testGameState10() {
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();

    String out = testRun(model, "1 4 4 4 q");

    assertEquals(true, out.contains("Invalid move. Play again. "));
    assertEquals(true, out.contains("Please input a valid move."));
    assertEquals(true, out.contains("State of game when quit:\n"));
    assertEquals(true, out.contains("Score: 32\n"));
  }

  /**
   * Tests the output of the game if the user makes an invalid move and proceeds to quit. The
   * invalid move is if player is moving orthogonally.
   */
  @Test
  public void testGameState11() {
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl(4, 4);

    String out = testRun(model, "3 3 5 5 q");

    assertEquals(true, out.contains("Invalid move. Play again. "));
    assertEquals(true, out.contains("Please input a valid move."));
    assertEquals(true, out.contains("State of game when quit:\n"));
    assertEquals(true, out.contains("Score: 32\n"));
  }

  /**
   * Tests the output of the game if the user makes an invalid move and proceeds to quit. The
   * invalid move is if the player is trying to move move something that isn't a marble.
   */
  @Test
  public void testGameState12() {
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();

    String out = testRun(model, "2 4 4 4 " +
            "3 2 3 4 " +
            "3 5 3 3 " +
            "3 7 3 5 " +
            "5 7 3 7 " +
            "4 5 4 7 " +
            "5 5 5 7 " +
            "4 3 4 5 " +
            "3 5 5 5 " +
            "5 4 5 6 " +
            "5 7 5 5 " +
            "5 2 5 4 " +
            "6 4 4 4 " +
            "4 1 4 3 " +
            "3 3 5 3 " +
            "1 3 3 3 " +
            "1 5 3 5 " +
            "2 5 2 3 q");

    assertEquals(true, out.contains("Invalid move. Play again. "));
    assertEquals(true, out.contains("Please input a valid move."));
    assertEquals(true, out.contains("State of game when quit:\n"));
    assertEquals(true, out.contains("Score: 32\n"));
  }

  /**
   * Tests the output of the game if the user makes an invalid move and proceeds to quit. The
   * invalid move is if the player is trying to move move something that isn't a marble.
   */
  @Test
  public void testGameState13() {
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();

    String out = testRun(model, "2 4 4 4 " +
            "3 2 3 4 " +
            "3 5 3 3 " +
            "3 7 3 5 " +
            "5 7 3 7 " +
            "4 5 4 7 " +
            "5 5 5 7 " +
            "4 3 4 5 " +
            "3 5 5 5 " +
            "5 4 5 6 " +
            "5 7 5 5 " +
            "5 2 5 4 " +
            "6 4 4 4 " +
            "4 1 4 3 " +
            "3 3 5 3 " +
            "1 3 3 3 " +
            "1 5 3 5 " +
            "1 4 3 4 q");

    assertEquals(true, out.contains("Invalid move. Play again. "));
    assertEquals(true, out.contains("Please input a valid move."));
    assertEquals(true, out.contains("State of game when quit:\n"));
    assertEquals(true, out.contains("Score: 32\n"));
  }

  /**
   * Tests the output of the game if the user inputs unrecognized characters and proceeds to quit.
   */
  @Test
  public void testGameState14() {
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();

    String out = testRun(model, "a s d f q");

    assertEquals(true, out.contains("Invalid input: Unrecognized value "));
    assertEquals(true, out.contains("State of game when quit:\n"));
    assertEquals(true, out.contains("Score: 32\n"));
  }

  /**
   * Checks for an IllegalArgumentException if playGame is given a null model.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullException1() {
    MarbleSolitaireModel model = null;
    testRun(model, "2 4 4 4");
  }

  /**
   * Tests the output of the game if the model is an invalid armThickness.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testModelConstructorExample1() {
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl(-1);
    String out = testRun(model, "a s d f q");
  }

  /**
   * Tests the output of the game if the model is an invalid empty space.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testModelConstructorExample2() {
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl(0, 0);
    String out = testRun(model, "a s d f q");
  }

  /**
   * Checks for an IllegalStateException if there's no input given at all.
   */
  @Test(expected = IllegalStateException.class)
  public void testStateException1() {
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();
    testRun(model, " ");
  }

  /**
   * Checks for an IllegalStateException if there's no more readable inputs after playing a couple
   * of rounds (while loop hasn't ended nor did the user end the game with q).
   */
  @Test(expected = IllegalStateException.class)
  public void testStateException2() {
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();
    testRun(model, "2 4 4 4 " +
            "3 2 3 4 " +
            "3 5 3 3 " +
            "3 7 3 5 " +
            "5 7 3 7 " +
            "4 5 4 7 " +
            "5 5 5 7 " +
            "4 3 4 5 " +
            "3 5 5 5 " +
            "5 4 5 6 ");
  }

  /**
   * Checks for an IllegalStateException if there's no valid inputs at all.
   */
  @Test(expected = IllegalStateException.class)
  public void testStateException3() {
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();
    testRun(model, "a s d f " +
            "a s d f " +
            "a s d f " +
            "a s d f " +
            "a s d f ");
  }
}