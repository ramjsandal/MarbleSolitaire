package cs3500.marblesolitaire.model.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * Represents a controller that communicates between the model and the view and takes in input.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {

  private final MarbleSolitaireModel model;

  private final Readable input;

  private final MarbleSolitaireView view;

  /**
   * Constructs an {@code MarbleSolitaireControllerImpl} object.
   *
   * @param model the solitare model which the controller communites with
   * @param input determines what changes in the model and view
   * @param view  represents the model
   * @throws IllegalArgumentException if any fields are null
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model,
                                       MarbleSolitaireView view, Readable input)
          throws IllegalArgumentException {

    if (model == null || input == null || view == null) {
      throw new IllegalArgumentException("Cannot have null fields");
    }

    this.model = model;
    this.input = input;
    this.view = view;
  }

  /**
   * Plays the game, scanning for user input and moving or quitting when given valid inputs,
   * and sending messages telling the user their input is invalid upon invalid inputs.
   *
   * @throws IllegalStateException if any transmission to the view fails, OR any attempt to read
   *                               the Readable fails
   */
  @Override
  public void playGame() throws IllegalStateException {
    String userInput;
    Scanner scan = new Scanner(this.input);
    boolean gameOver = this.gameOverCheck();


    ArrayList<Integer> inputList = new ArrayList<>();
    int noElements = 0;


    // if the game is not over at the start of the game, return the board and score.
    if (!gameOver) {
      this.boardAndScore();
    }

    while (!gameOver) {
      // check if the game is over
      gameOver = this.gameOverCheck();

      // if the game is not over, scan for user input
      if (gameOver) {
        break;
      } else {
        try {
          userInput = scan.next();
        } catch (NoSuchElementException | IllegalStateException e) {
          throw new IllegalStateException("Cannot read Readable");
        }
      }

      try {
        // see if the input is a number
        int num = Integer.parseInt(userInput);

        // if the number is positive, add it to the list of inputs and increase noElements by 1,
        // and if noElements is divisible by 4, grab the 4 most recent entries to inputList and
        // move with them
        if (num > 0) {

          inputList.add(num);
          noElements += 1;

          if (noElements > 0 && noElements % 4 == 0) {
            try {
              this.model.move(inputList.get(noElements - 4) - 1,
                      inputList.get(noElements - 3) - 1,
                      inputList.get(noElements - 2) - 1,
                      inputList.get(noElements - 1) - 1);
              this.boardAndScore();
            } catch (IllegalArgumentException e) {
              try {
                this.view.renderMessage("Invalid move. Play again. \n");
              } catch (IOException io1) {
                throw new IllegalStateException("Could not transmit to Appendable");
              }
            }
          }
        }
        // if the number is 0 or negative, tell the user that the input was invalid.
        else {
          try {
            this.view.renderMessage("Invalid input, please re-enter\n");
          } catch (IOException io1) {
            throw new IllegalStateException("Could not transmit to Appendable");
          }
        }


      } catch (NumberFormatException e) {

        // if the input is not a number, it is a string, so we deal with them

        String input = userInput.toLowerCase();

        try {
          if (input.equals("q")) {
            this.view.renderMessage("Game quit!\n");
            this.view.renderMessage("State of game when quit:\n");
            this.view.renderBoard();
            this.view.renderMessage("\nScore: " + this.model.getScore() + "\n");
            gameOver = true;
          } else {
            this.view.renderMessage("Invalid input, please re-enter\n");
          }
        } catch (IOException io1) {
          throw new IllegalStateException("Could not transmit to Appendable");
        }

      }
    }

  }


  // if the game is over returns true and prints out the game over message, if the game is not
  // over it returns false. Throws an IllegalStateException if it cannot transmit to the appendable.
  private boolean gameOverCheck() throws IllegalStateException {
    if (this.model.isGameOver()) {
      try {
        this.view.renderMessage("Game over!\n");
        this.view.renderBoard();
        this.view.renderMessage("\nScore: " + this.model.getScore() + "\n");
      } catch (IOException e) {
        throw new IllegalStateException("Could not transmit to Appendable");
      }
      return true;
    } else {
      return false;
    }
  }

  // returns the board and score of the game, or throws and IllegalStateException if it cannot
  // transmit to the appendable.
  private void boardAndScore() throws IllegalStateException {
    try {
      this.view.renderBoard();
      this.view.renderMessage("\nScore: " + model.getScore() + "\n");
    } catch (IOException io1) {
      throw new IllegalStateException("Could not transmit to Appendable");
    }
  }

}
