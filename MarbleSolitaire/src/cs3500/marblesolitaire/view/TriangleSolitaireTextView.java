package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;

/**
 * A visual representation of a triangle solitaire model.
 */
public class TriangleSolitaireTextView extends MarbleSolitaireTextView {

  /**
   * Constructs an {@code TriangleSolitaireModel} object.
   *
   * @param modelState the state of the model to display
   * @param output     where to display the view
   * @throws IllegalArgumentException if the modelState or output are null
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState modelState, Appendable output)
          throws IllegalArgumentException {
    super(modelState, output);
  }

  /**
   * Constructs an {@code TriangleSolitaireModel} object with a default output of System.out.
   *
   * @param modelState the state of the model to display
   * @throws IllegalArgumentException if the modelState is null
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState modelState)
          throws IllegalArgumentException {
    super(modelState);
  }

  @Override
  public String toString() {
    String output = "";

    for (int i = 0; i < this.modelState.getBoardSize(); i++) {
      for (int j = 0; j < this.modelState.getBoardSize(); j++) {

        // add spaces before first of the row
        if (j == 0) {
          for (int l = i + 1; l < this.modelState.getBoardSize(); l++) {
            output = output.concat(" ");
          }
        }

        // add Os for marbles and _s for empties
        switch (modelState.getSlotAt(i, j)) {
          case Marble:
            output = output.concat("O ");
            break;
          case Empty:
            output = output.concat("_ ");
            break;
          default:
            break;
        }

        // end of the line
        if (i == j) {
          output = output.stripTrailing();
          // if we've reached the end of the board
          if (i != modelState.getBoardSize() - 1) {
            output = output.concat("\n");
          }
        }

      }
    }
    return output;
  }


}
