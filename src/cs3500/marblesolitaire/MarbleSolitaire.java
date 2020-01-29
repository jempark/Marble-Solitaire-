package cs3500.marblesolitaire;

import java.io.InputStreamReader;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;
import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;

/**
 * Entry point for the program to play a game of Marble Solitaire depending on the given inputs and
 * board choice.
 */
public final class MarbleSolitaire {

  /**
   * Plays a game of Marble Solitaire.
   */
  public static void main(String[] args) {
    String boardInput = "";
    if (args.length > 0) {
      boardInput = args[0];
    }

    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(new InputStreamReader(System.in), System.out);

    /**
     * Checks the inputs for an English Marble Solitaire Board and sets up the board as appropriate.
     */
    if (boardInput.equals("english")) {
      if (args.length == 1) {
        MarbleSolitaireModelImpl board = new MarbleSolitaireModelImpl();
        controller.playGame(board);
      } else if (args.length > 1) {
        String nextInput = args[1];
        if (nextInput.equals("-size")) {
          try {
            MarbleSolitaireModel board =
                    new MarbleSolitaireModelImpl(Integer.parseInt(args[2]));
            controller.playGame(board);
          } catch (NumberFormatException e) {
            System.err.println("Invalid input for the size.");
            System.exit(1);
          }
        } else if (nextInput.equals("-hole")) {
          try {
            MarbleSolitaireModel board =
                    new MarbleSolitaireModelImpl(Integer.parseInt(args[2]),
                            Integer.parseInt(args[3]));
            controller.playGame(board);
          } catch (NumberFormatException e) {
            System.err.println("Invalid input for the empty slot.");
            System.exit(1);
          }
        }
      }
    }

    /**
     * Checks the inputs for an European Marble Solitaire Board and sets up the board as
     * appropriate.
     */
    else if (boardInput.equals("european")) {
      if (args.length == 1) {
        EuropeanSolitaireModelImpl board = new EuropeanSolitaireModelImpl();
        controller.playGame(board);
      } else if (args.length > 1) {
        String nextInput = args[1];
        if (nextInput.equals("-size")) {
          try {
            MarbleSolitaireModel board =
                    new EuropeanSolitaireModelImpl(Integer.parseInt(args[2]));
            controller.playGame(board);
          } catch (NumberFormatException e) {
            System.err.println("Invalid input for the size.");
            System.exit(1);
          }
        } else if (nextInput.equals("-hole")) {
          try {
            MarbleSolitaireModel board =
                    new EuropeanSolitaireModelImpl(Integer.parseInt(args[2]),
                            Integer.parseInt(args[3]));
            controller.playGame(board);
          } catch (NumberFormatException e) {
            System.err.println("Invalid input for the empty slot.");
            System.exit(1);
          }
        }
      }
    }

    /**
     * Checks the inputs for a triangular Marble Solitaire Board and sets up the board as
     * appropriate.
     */
    else if (boardInput.equals("triangular")) {
      if (args.length == 1) {
        MarbleSolitaireModel board = new TriangleSolitaireModelImpl();
        controller.playGame(board);
      } else if (args.length > 1) {
        String nextInput = args[1];
        if (nextInput.equals("-size")) {
          try {
            MarbleSolitaireModel board =
                    new TriangleSolitaireModelImpl(Integer.parseInt(args[2]));
            controller.playGame(board);
          } catch (NumberFormatException e) {
            System.err.println("Invalid input for the size.");
            System.exit(1);
          }
        } else if (nextInput.equals("-hole")) {
          try {
            MarbleSolitaireModel board =
                    new TriangleSolitaireModelImpl(Integer.parseInt(args[2]),
                            Integer.parseInt(args[3]));
            controller.playGame(board);
          } catch (NumberFormatException e) {
            System.err.println("Invalid input for the empty slot.");
            System.exit(1);
          }
        }
      }
    }
  }
}