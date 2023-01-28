package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * A visual representation of a marble solitaire state.
 */
public class MarbleSolitaireTextView implements MarbleSolitaireView {
  // these fields are protected because triangleview extends this class
  protected MarbleSolitaireModelState modelState;

  protected Appendable output;


  /**
   * Constructs an {@code MarbleSolitaireTextView} object.
   *
   * @param modelState the model state being represented.
   * @param output     the location to display the model.
   * @throws IllegalArgumentException if the model state or output are null
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState modelState, Appendable output)
          throws IllegalArgumentException {
    if (modelState == null || output == null) {
      throw new IllegalArgumentException("Cannot have a null model or output");
    }
    this.modelState = modelState;
    this.output = output;

  }

  /**
   * Constructs a {@code MarbleSolitaireTextView} object.
   *
   * @param modelState is the model which the view represents.
   * @throws IllegalArgumentException if the model state is null
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState modelState)
          throws IllegalArgumentException {
    if (modelState == null) {
      throw new IllegalArgumentException("Cannot have a null model");
    }

    this.modelState = modelState;
    this.output = System.out;
  }

  @Override
  public String toString() {
    String output = new String("");
    for (int i = 0; i < modelState.getBoardSize(); i++) {
      for (int j = 0; j < modelState.getBoardSize(); j++) {

        switch (modelState.getSlotAt(i, j)) {
          case Marble:
            output = output.concat("O ");
            break;

          case Empty:
            output = output.concat("_ ");
            break;

          default:
            output = output.concat("  ");
            break;
        }

        if (j == modelState.getBoardSize() - 1) {
          if (i != modelState.getBoardSize() - 1) {
            output = output.stripTrailing().concat("\n");
          } else {
            output = output.stripTrailing();
          }
        }
      }
    }
    return output;
  }

  // might need to do \n here
  // should I be catching the IOException or letting it happen?
  @Override
  public void renderBoard() throws IOException {
    this.output.append(this.toString());
  }

  @Override
  public void renderMessage(String message) throws IOException {
    this.output.append(message);
  }
}
