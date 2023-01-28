package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw04.AbstractSolitaireModel;

/**
 * Represents an English Solitaire Model.
 */
public class EnglishSolitaireModel extends AbstractSolitaireModel {

  
  /**
   * Constructs an {@code EnglishSolitaireModel} object.
   *
   * @param thickness determines size of the board based on a plus shape.
   *                  The thickness determines the length of the sides of
   *                  the plus, and the middle of the plus is also determined
   *                  by the thickness.
   * @param sRow      the row of the empty slot.
   * @param sCol      the column of the empty square.
   * @throws IllegalArgumentException if thickness is less than 1,
   */
  public EnglishSolitaireModel(int thickness, int sRow, int sCol) throws IllegalArgumentException {
    if (thickness <= 1 || thickness % 2 == 0) {
      throw new IllegalArgumentException("Invalid Thickness");
    } else {
      this.thickness = thickness;
    }

    // constructs the board
    SlotState[][] board = new SlotState[(thickness * 3) - 2][(thickness * 3) - 2];

    // assigns each slot to either invalid, empty, or marble
    for (int i = 0; i <= (thickness * 3) - 3; i++) {
      for (int j = 0; j <= (thickness * 3) - 3; j++) {

        if ((i < thickness - 1 && ((j < thickness - 1) || (j >= (thickness * 2) - 1)))
                || (i >= (thickness * 2) - 1
                && ((j < thickness - 1) || (j >= (thickness * 2) - 1)))) {

          if (i == sRow && j == sCol) {
            throw new IllegalArgumentException("Invalid empty cell position "
                    + "(" + sRow + "," + sCol + ")");
          }
          board[i][j] = SlotState.Invalid;

        } else if (i == sRow && j == sCol) {
          board[i][j] = SlotState.Empty;
        } else {
          board[i][j] = SlotState.Marble;
        }
      }
    }

    this.board = board;

    if (sRow < 0 || sRow >= (thickness * 3) - 2 || sCol < 0 || sCol >= (thickness * 3) - 2) {
      throw new IllegalArgumentException("Invalid empty cell position: "
              + "(" + sRow + "," + sCol + ")");
    }

  }

  /**
   * Constructs an {@code EnglishSolitaireModel} with a thickness of 3 and
   * an empty slot at the position indicated by the row and column.
   *
   * @param sRow the row of the empty slot.
   * @param sCol the column of the empty slot.
   */
  public EnglishSolitaireModel(int sRow, int sCol) {
    this(3, sRow, sCol);
  }

  /**
   * Constructs an {@code EnglishSolitaireModel} with the provided thickness, and places
   * the empty slot at the middle of the board.
   *
   * @param thickness determines the size of the board.
   */
  public EnglishSolitaireModel(int thickness) {
    this(thickness, ((thickness * 3) - 2) / 2, ((thickness * 3) - 2) / 2);
  }

  /**
   * Constructs an {@code EnglishSolitaireModel} with a thickness of three
   * and an empty slot at (3,3), the middle of the board.
   */
  public EnglishSolitaireModel() {
    this(3, 3, 3);
  }

}
