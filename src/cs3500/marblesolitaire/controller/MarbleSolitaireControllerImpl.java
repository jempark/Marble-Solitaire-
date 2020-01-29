package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Implements the "controller" that will run a game of Marble Solitaire using the model that has
 * been implemented in MarbleSolitaireModel.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
  private final Readable rd;
  private final Appendable ap;

  /**
   * Controller that accepts and stores objects for doing input and output.
   *
   * @param rd Readable object.
   * @param ap Appendable object.
   * @throws IllegalArgumentException if either rd or ap is null.
   */
  public MarbleSolitaireControllerImpl(Readable rd, Appendable ap)
          throws IllegalArgumentException {
    if (rd == null || ap == null) {
      throw new IllegalArgumentException("Invalid input");
    }
    this.ap = ap;
    this.rd = rd;
  }

  /**
   * Helper that checks if the given String is an Integer.
   *
   * @param str String input.
   * @return true if it is a number - else false.
   */
  private boolean isNumeric(String str) {
    try {
      Integer.parseInt(str);
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * Plays a new game of Marble Solitaire using the provided model.
   *
   * @param model represents the game state that the method would play the game on.
   * @throws IllegalArgumentException if the provided model is null.
   * @throws IllegalStateException    if the controller is unable to successfully receive input or
   *                                  transmit output.
   */
  @Override
  public void playGame(MarbleSolitaireModel model)
          throws IllegalArgumentException, IllegalStateException {
    /**
     * Throws an IllegalArgumentException if the provided model is null.
     */
    if (model == null) {
      throw new IllegalArgumentException("Provided model is null");
    }

    Scanner sc = new Scanner(rd);
    String input;
    int value;
    ArrayList<Integer> moveInputs = new ArrayList<>();

    /**
     * Prints the current board state and the score.
     */
    try {
      ap.append(model.getGameState() + "\n");
      ap.append("Score: " + model.getScore() + "\n");
    } catch (IOException e) {
      throw new IllegalStateException("Error with the given Readable/Appendable");
    }

    while (!model.isGameOver()) {

      /**
       * If there's no input.
       */
      if (!sc.hasNext()) {
        throw new IllegalStateException("Readable no input");
      }

      /**
       * First checks to see if the user inputted a "q" or a "Q."
       */
      input = sc.next();
      if (input.equals("q") || input.equals("Q")) {
        try {
          this.ap.append("Game quit!" + "\n" + "State of game when quit:"
                  + "\n" + model.getGameState() + "\n" + "Score: " + model.getScore() + "\n");
          return;
        } catch (IOException e) {
          throw new IllegalStateException("Error with the given Readable/Appendable");
        }
      }

      /**
       * If not "q" or "Q," reads int and adds to array list if positive.
       */
      else if (isNumeric(input)) {
        value = Integer.parseInt(input);
        if (value <= 0) {
          try {
            this.ap.append("Invalid input: Negative Number" + "\n");
          } catch (IOException e) {
            throw new IllegalStateException("Error with the given Readable/Appendable");
          }
        } else {
          moveInputs.add(value - 1);
        }

        if (moveInputs.size() == 4) {
          try {
            model.move(moveInputs.get(0), moveInputs.get(1), moveInputs.get(2), moveInputs.get(3));
          } catch (IllegalArgumentException e) {
            try {
              this.ap.append("Invalid move. Play again. " + e.getMessage() + "\n");
            } catch (IOException f) {
              throw new IllegalStateException("Error with the given Readable/Appendable");
            }
          }
          moveInputs.clear();
          /**
           * Prints the current board state and the score.
           */
          try {
            ap.append(model.getGameState() + "\n");
            ap.append("Score: " + model.getScore() + "\n");
          } catch (IOException e) {
            throw new IllegalStateException("Error with the given Readable/Appendable");
          }
        }
      }

      /**
       * If not quitting or number input, than it's an invalid input.
       */
      else {
        try {
          this.ap.append("Invalid input: Unrecognized value \n");
        } catch (IOException e) {
          throw new IllegalStateException("Error with the given Readable/Appendable");
        }
      }
    }

    try {
      this.ap.append("Game over!" + "\n" + model.getGameState()
              + "\n" + "Score: " + model.getScore() + "\n");
      return;
    } catch (IOException e) {
      throw new IllegalStateException("Error with the given Readable/Appendable");
    }
  }
}