package cs3500.marblesolitaire.model.hw04;

/**
 * Represents a Triangle solitaire model.
 */
public class TriangleSolitaireModel extends AbstractSolitaireModel {


  /**
   * Constructs an {@code TriangleSolitaireModel} object based on the given thickness,
   * and places the empty square at the indicated square.
   *
   * @param thickness determines the size of the board
   * @param sRow      row of the empty square
   * @param sCol      col of the empty square
   * @throws IllegalArgumentException if the thickness is too small or even, OR the invalid square
   *                                  is off the board or on an invalid square.
   */
  public TriangleSolitaireModel(int thickness, int sRow, int sCol) throws IllegalArgumentException {
    if (thickness < 1) {
      throw new IllegalArgumentException("Thickness cannot be negative or zero.");
    } else {
      this.thickness = thickness;
    }

    if (sRow < 0 || sCol < 0 || sRow >= thickness || sCol >= thickness) {
      throw new IllegalArgumentException("Empty square must be on the board.");
    }

    SlotState[][] board = new SlotState[thickness][thickness];
    for (int i = 0; i < thickness; i++) {
      for (int j = 0; j < thickness; j++) {
        if (j <= i) {
          board[i][j] = SlotState.Marble;
        } else {
          board[i][j] = SlotState.Invalid;
        }
      }
    }
    if (board[sRow][sCol] == SlotState.Invalid) {
      throw new IllegalArgumentException("Empty square must be on the board.");
    } else {
      board[sRow][sCol] = SlotState.Empty;
    }

    this.board = board;
  }

  /**
   * Constructs an {@code TriangleSolitaireModel} object with a board of thickness 5 and the
   * empty square at the indicated square.
   *
   * @param sRow the row of the empty square
   * @param sCol the col of the empty square
   * @throws IllegalArgumentException if the empty square is off the board or on an invalid square.
   */
  public TriangleSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    this(5, sRow, sCol);
  }

  /**
   * Constructs an {@code TriangleSolitaireModel} object with a given thickness and empty square
   * at (0,0).
   *
   * @param thickness determines the size of the board.
   * @throws IllegalArgumentException if the thickness is even or too small.
   */
  public TriangleSolitaireModel(int thickness) throws IllegalArgumentException {
    this(thickness, 0, 0);
  }

  /**
   * Constructs an {@code TriangleSolitaireModel} object with a thickness of 5 and the empty square
   * at (0,0).
   */
  public TriangleSolitaireModel() {
    this(5, 0, 0);
  }

  /**
   * Returns the size of the board.
   *
   * @return the size of the board.
   */
  @Override
  public int getBoardSize() {
    return this.thickness;
  }


  /**
   * Moves a marble from one square to another. A move is only valid
   * if the from square is a marble, the to sqaure is empty, and the square
   * in between is a marble.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @throws IllegalArgumentException if the from square or to square are off the board OR if the
   *                                  from square is not a marble OR if the to square is not empty
   *                                  OR the from square and to square are not exactly 2 spaces
   *                                  apart OR the sqaure in between the form square and to square
   *                                  is not a marble.
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (fromRow < 0
            || fromCol < 0
            || toRow < 0
            || toCol < 0
            || fromRow >= this.thickness
            || fromCol >= this.thickness
            || toRow >= this.thickness
            || toCol >= this.thickness
            || this.board[fromRow][fromCol] != SlotState.Marble
            || this.board[toRow][toCol] != SlotState.Empty) {
      throw new IllegalArgumentException("Must move a Marble that is on the board to an Empty " +
              "square on the board.");
    }


    if (Math.abs(fromCol - toCol) == 2) {

      if (fromRow == toRow
              && this.board[fromRow][Math.max(fromCol, toCol) - 1] == SlotState.Marble) {
        this.board[fromRow][fromCol] = SlotState.Empty;
        this.board[fromRow][Math.max(fromCol, toCol) - 1] = SlotState.Empty;
        this.board[toRow][toCol] = SlotState.Marble;
      } else if (Math.abs(fromRow - toRow) == 2
              && this.board[Math.max(fromRow, toRow) - 1][Math.max(fromCol, toCol) - 1]
              == SlotState.Marble) {
        this.board[fromRow][fromCol] = SlotState.Empty;
        this.board[Math.max(fromRow, toRow) - 1][Math.max(fromCol, toCol) - 1] = SlotState.Empty;
        this.board[toRow][toCol] = SlotState.Marble;
      } else {
        throw new IllegalArgumentException("Must move exactly two squares with the square in the " +
                "middle being a Marble.");
      }

    } else if (Math.abs(fromRow - toRow) == 2
            && fromCol == toCol
            && this.board[Math.max(fromRow, toRow) - 1][fromCol] == SlotState.Marble) {

      this.board[fromRow][fromCol] = SlotState.Empty;
      this.board[Math.max(fromRow, toRow) - 1][fromCol] = SlotState.Empty;
      this.board[toRow][toCol] = SlotState.Marble;

    } else {
      throw new IllegalArgumentException("Must move exactly two squares with the square in the " +
              "middle being a Marble.");
    }

  }

}
