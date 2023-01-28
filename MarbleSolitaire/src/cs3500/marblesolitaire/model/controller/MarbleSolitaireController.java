package cs3500.marblesolitaire.model.controller;

import java.io.IOException;

/**
 * Communicates between the view and the model.
 */
public interface MarbleSolitaireController {


  /**
   * Plays a new game of MarbleSolitaire.
   *
   * @throws IOException if unable to read input or transmit output.
   */
  void playGame() throws IllegalStateException;


}
