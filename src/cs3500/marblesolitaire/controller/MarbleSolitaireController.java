package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * This interface represents the "controller" that will run a game of Marble Solitaire using the
 * model that has been implemented in MarbleSolitaireModel.
 */
public interface MarbleSolitaireController {
  /**
   * Plays a new game of Marble Solitaire using the provided model.
   *
   * @param model represents the game state that the method would play the game on.
   * @throws IllegalArgumentException if the provided model is null.
   * @throws IllegalStateException    if the controller is unable to successfully receive input or
   *                                  transmit output.
   */
  void playGame(MarbleSolitaireModel model)
          throws IllegalArgumentException, IllegalStateException;
}
