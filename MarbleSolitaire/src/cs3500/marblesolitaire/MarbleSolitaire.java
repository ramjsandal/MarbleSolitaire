package cs3500.marblesolitaire;

import java.io.InputStreamReader;

import cs3500.marblesolitaire.model.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.model.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

/**
 * Runs a game of Marble Solitaire.
 */
public final class MarbleSolitaire {

  /**
   * Based on the given arguments, creates a board of a certain style, size, and empty square
   * location and runs a game of Marble Solitaire with it.
   *
   * @param args the parameters to build the board by.
   */
  public static void main(String[] args) {

    int size;
    int sRow;
    int sCol;
    MarbleSolitaireModel model;
    MarbleSolitaireView view;
    MarbleSolitaireController controller;
    Readable reader = new InputStreamReader(System.in);

    switch (args[0]) {
      case "european":
      case "english":
        size = 3;
        sRow = 4;
        sCol = 4;
        break;
      case "triangular":
        size = 5;
        sRow = 1;
        sCol = 1;
        break;
      default:
        throw new IllegalArgumentException("Hey! That's not a supported board type!");
    }


    for (int i = 1; i < args.length; i++) {
      switch (args[i]) {
        case "-size":
          size = Integer.parseInt(args[i + 1]);
          break;
        case "-hole":
          sRow = Integer.parseInt(args[i + 1]);
          sCol = Integer.parseInt(args[i + 2]);
          break;
        default:
          break;
      }
    }

    switch (args[0]) {
      case "european":
        model = new EuropeanSolitaireModel(size, sRow - 1, sCol - 1);
        view = new MarbleSolitaireTextView(model, System.out);
        break;
      case "english":
        model = new EnglishSolitaireModel(size, sRow - 1, sCol - 1);
        view = new MarbleSolitaireTextView(model, System.out);
        break;
      case "triangular":
        model = new TriangleSolitaireModel(size, sRow - 1, sCol - 1);
        view = new TriangleSolitaireTextView(model, System.out);
        break;
      default:
        throw new IllegalArgumentException("Hey! That's not a supported board type!");
    }

    controller = new MarbleSolitaireControllerImpl(model, view, reader);
    controller.playGame();


  }
}
