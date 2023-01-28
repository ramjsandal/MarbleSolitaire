import java.io.StringWriter;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;

/**
 * Testing class for {@code EnglishSolitaireModel} that records inputs.
 */
public class ConfirmInputsSolitaireModel extends EnglishSolitaireModel {

  StringWriter log;

  /**
   * Constructs an {@code ConfirmInputsEnglishSolitaireModel} object.
   * @param log records inputs
   */
  public ConfirmInputsSolitaireModel(StringWriter log) {
    this.log = log;
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    log.append("fromRow: " + fromRow + " fromCol: "
            + fromCol + " toRow: " + toRow + " toCol: " + toCol);
  }
}
