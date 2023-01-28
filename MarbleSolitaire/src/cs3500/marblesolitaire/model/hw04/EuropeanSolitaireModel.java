package cs3500.marblesolitaire.model.hw04;


/**
 * Represents a European Solitaire game.
 */
public class EuropeanSolitaireModel extends AbstractSolitaireModel {

  /**
   * Constructs an {@code EuropeanSolitaireModel} object.
   *
   * @param thickness determines the size of the board
   * @param sRow      the row of the empty square
   * @param sCol      the column of the empty square
   * @throws IllegalArgumentException if the thickness is negative or even OR if the empty square
   *                                  is placed out of bounds or on an invalid square.
   */
  public EuropeanSolitaireModel(int thickness, int sRow, int sCol) throws IllegalArgumentException {
    // check if the thickness is too small or even
    if (thickness <= 1 || thickness % 2 == 0) {
      throw new IllegalArgumentException("Invalid thickness.");
    } else {
      this.thickness = thickness;
    }

    // checks if the sRow and sCol are on the board
    if (sRow < 0 || sCol < 0 || sRow >= (thickness * 3) - 2 || sCol >= (thickness * 3) - 2) {
      throw new IllegalArgumentException("Empty square out of bounds.");
    }


    // constructs the board
    SlotState[][] board = new SlotState[(thickness * 3) - 2][(thickness * 3) - 2];

    for (int i = 0; i < (thickness * 3) - 2; i++) {
      for (int j = 0; j < (thickness * 3) - 2; j++) {

        if ((i < thickness - 1)) {

          // top half of the board corners

          if (j < thickness - 1) {

            // top left
            if (j > thickness - (2 + i)) {
              board[i][j] = SlotState.Marble;
            } else {
              board[i][j] = SlotState.Invalid;
            }
          }

          // top right
          else if (j > (thickness * 2) - 2) {

            if (j < (thickness * 2) - 1 + i) {
              board[i][j] = SlotState.Marble;
            } else {
              board[i][j] = SlotState.Invalid;
            }
          }
          // top middle
          else {
            board[i][j] = SlotState.Marble;
          }
        } else if (i > (thickness * 2) - 2) {

          // bottom half of the board corners

          if (j < thickness - 1) {

            // bottom left
            if (j > thickness - (2 + (((thickness * 3) - 3) - i))) {
              board[i][j] = SlotState.Marble;
            } else {
              board[i][j] = SlotState.Invalid;
            }
          }

          // bottom right
          else if (j > (thickness * 2) - 2) {

            if (j < (thickness * 2) - 1 + (((thickness * 3) - 3) - i)) {
              board[i][j] = SlotState.Marble;
            } else {
              board[i][j] = SlotState.Invalid;
            }
          }

          // bottom middle
          else {
            board[i][j] = SlotState.Marble;
          }

        } else {
          // if its not in one of the corners, its a marble
          board[i][j] = SlotState.Marble;
        }
      }
    }

    // check if the designated empty square is an invalid, otherwise make it empty.
    if (board[sRow][sCol] == SlotState.Invalid) {
      throw new IllegalArgumentException("Cannot put empty space on invalid square.");
    } else {
      board[sRow][sCol] = SlotState.Empty;
    }

    this.board = board;

  }

  /**
   * Constructs a {@code EuropeanSolitaireModel} object with a thickness of three and an
   * empty slot at the indicated position.
   * @param sRow the row of the empty square.
   * @param sCol the col of the empty square.
   * @throws IllegalArgumentException if the empty square is off the board or on an invalid square.
   */
  public EuropeanSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    this(3, sRow, sCol);
  }

  /**
   * Constructs an {@code EuropeanSolitaireModel} object with the given thickness and an
   * empty slot at the center.
   * @param thickness the thickness of the board.
   * @throws IllegalArgumentException if the thickness is even or negative.
   */
  public EuropeanSolitaireModel(int thickness) throws IllegalArgumentException {
    this(thickness, ((thickness * 3) - 2) / 2, ((thickness * 3) - 2) / 2);
  }

  /**
   * Constructs an {@code EuropeanSolitaireModel} object with a thickness of 3 and an
   * empty slot at (3,3).
   * */
  public EuropeanSolitaireModel() {
    this(3, 3, 3);
  }

}
