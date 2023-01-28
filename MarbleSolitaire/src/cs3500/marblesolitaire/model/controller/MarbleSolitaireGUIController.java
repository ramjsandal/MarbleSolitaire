package cs3500.marblesolitaire.model.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireGuiView;

/**
 * Controller for the GUI marble solitaire game.
 */
public class MarbleSolitaireGUIController implements Features {
  MarbleSolitaireModel model;
  MarbleSolitaireGuiView view;
  boolean start;
  int fromRow;
  int fromCol;

  /**
   * Constructs an {@code MarbleSolitaireGUIController} object.
   *
   * @param model the model to display
   * @param view  where to display the model
   * @throws IllegalArgumentException if any fields are null
   */
  public MarbleSolitaireGUIController(MarbleSolitaireModel model, MarbleSolitaireGuiView view)
          throws IllegalArgumentException {
    if (model == null || view == null) {
      throw new IllegalArgumentException("Cannot have null fields.");
    }

    this.model = model;
    this.view = view;
    this.start = true;
    view.acceptFeatures(this);
  }

  @Override
  public void moveInput(int row, int col) {

    if (this.start) {

      this.fromRow = row;
      this.fromCol = col;
      this.start = false;

    } else {

      this.start = true;

      try {
        this.model.move(fromRow, fromCol, row, col);
        this.view.refresh();
      } catch (IllegalArgumentException e) {
        this.view.renderMessage("Invalid move lol");
      }

      if (this.model.isGameOver()) {
        this.view.renderMessage("Game over! \n Final Score: " + this.model.getScore());
      }

    }

  }
}
