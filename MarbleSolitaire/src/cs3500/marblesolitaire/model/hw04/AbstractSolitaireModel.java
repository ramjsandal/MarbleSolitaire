package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Abstract representation of a Solitaire Model.
 */
public abstract class AbstractSolitaireModel implements MarbleSolitaireModel {
  protected SlotState[][] board;
  protected int thickness;


  /**
   * Moves the player from one place to another if the from place is a marble, the to place
   * is an empty space, and the space in between is a marble. No diagonal jumps.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @throws IllegalArgumentException if the from or to positions are off the board, OR if the
   *                                  from position is not a marble, OR if the to position is not
   *                                  empty, OR the to position is not exactly two squares up,
   *                                  down, left, or right away.
   */
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {

    if ((fromRow < 0)
            || (fromCol < 0)
            || (toRow < 0)
            || (toCol < 0)
            || (fromRow >= ((this.thickness * 3) - 2))
            || (fromCol >= ((this.thickness * 3) - 2))
            || (toRow >= ((this.thickness * 3) - 2))
            || (toCol >= ((this.thickness * 3) - 2))
            || (this.board[fromRow][fromCol] != SlotState.Marble)
            || (this.board[toRow][toCol] != SlotState.Empty)) {
      throw new IllegalArgumentException("Must move a marble that is on the board to an empty slot "
              + "that is on the board.");
    }

    if (fromRow == toRow) {

      if ((this.board[toRow][Math.max(toCol, fromCol) - 1] != SlotState.Marble)
              || (Math.abs(toCol - fromCol) != 2)) {
        throw new IllegalArgumentException("Can only move exactly two slots vertically or " +
                "horizontally, and the slot jumped over must be a marble.");
      } else {
        this.board[fromRow][fromCol] = SlotState.Empty;
        this.board[toRow][Math.max(toCol, fromCol) - 1] = SlotState.Empty;
        this.board[toRow][toCol] = SlotState.Marble;
      }

    } else if (fromCol == toCol) {

      if ((this.board[Math.max(toRow, fromRow) - 1][toCol] != SlotState.Marble)
              || (Math.abs(toRow - fromRow) != 2)) {
        throw new IllegalArgumentException("Can only move exactly two slots vertically or " +
                "horizontally, and the slot jumped over must be a marble.");
      } else {
        this.board[fromRow][fromCol] = SlotState.Empty;
        this.board[Math.max(toRow, fromRow) - 1][toCol] = SlotState.Empty;
        this.board[toRow][toCol] = SlotState.Marble;
      }
    } else {
      throw new IllegalArgumentException("Not a horizontal or vertical jump");
    }

  }


  /**
   * Checks if the game is over, the game is over if no more valid moves can be played.
   *
   * @return true if the game is over, false if it is not over.
   */
  public boolean isGameOver() {
    for (int i = 0; i < this.getBoardSize(); i++) {
      for (int j = 0; j < this.getBoardSize(); j++) {

        if (i >= 2
                && this.board[i][j] == SlotState.Marble
                && this.board[i - 1][j] == SlotState.Marble
                && this.board[i - 2][j] == SlotState.Empty) {
          return false;
        }

        if (i < this.getBoardSize() - 2
                && this.board[i][j] == SlotState.Marble
                && this.board[i + 1][j] == SlotState.Marble
                && this.board[i + 2][j] == SlotState.Empty) {
          return false;
        }

        if (j >= 2
                && this.board[i][j] == SlotState.Marble
                && this.board[i][j - 1] == SlotState.Marble
                && this.board[i][j - 2] == SlotState.Empty) {
          return false;
        }

        if (j < this.getBoardSize() - 2
                && this.board[i][j] == SlotState.Marble
                && this.board[i][j + 1] == SlotState.Marble
                && this.board[i][j + 2] == SlotState.Empty) {
          return false;
        }

        // next two checks will only happen for triangle boards,
        // because they are the only board type where thickness = board size
        if (i >= 2
                && j >= 2
                && this.getBoardSize() == this.thickness
                && this.board[i][j] == SlotState.Marble
                && this.board[i - 1][j - 1] == SlotState.Marble
                && this.board[i - 2][j - 2] == SlotState.Empty) {
          return false;
        }

        if (i < this.getBoardSize() - 2
                && j < this.getBoardSize() - 2
                && this.getBoardSize() == this.thickness
                && this.board[i][j] == SlotState.Marble
                && this.board[i + 1][j + 1] == SlotState.Marble
                && this.board[i + 2][j + 1] == SlotState.Empty) {
          return false;
        }

      }
    }

    return true;
  }


  /**
   * Gets the size of the board in squares at its longest.
   *
   * @return the size of the board.
   */
  public int getBoardSize() {
    return this.thickness * 3 - 2;
  }


  /**
   * Gets the slot state of the board at the given square.
   *
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return the slot state of the board at the given square.
   * @throws IllegalArgumentException if the given square is not on the board.
   */
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if (row < 0 || col < 0 || col >= this.getBoardSize() || row >= this.getBoardSize()) {
      throw new IllegalArgumentException("Cannot get slot out of bounds");
    }
    return this.board[row][col];
  }


  /**
   * Gets the score of the game by counting all of the marbles on the board.
   *
   * @return the score of the game.
   */
  public int getScore() {
    int score = 0;

    for (int i = 0; i < this.getBoardSize(); i++) {
      for (int j = 0; j < this.getBoardSize(); j++) {
        if (this.board[i][j] == SlotState.Marble) {
          score++;
        }
      }
    }
    return score;
  }
}


