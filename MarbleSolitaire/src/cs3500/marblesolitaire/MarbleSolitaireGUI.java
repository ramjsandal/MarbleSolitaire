package cs3500.marblesolitaire;

import cs3500.marblesolitaire.model.controller.Features;
import cs3500.marblesolitaire.model.controller.MarbleSolitaireGUIController;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireGuiView;
import cs3500.marblesolitaire.view.SwingGuiView;

/**
 * Gui.
 */
public class MarbleSolitaireGUI {

  /**
   * Main.
   * @param args yep
   */
  public static void main(String[] args) {
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireGuiView view = new SwingGuiView(model);
    Features controller = new MarbleSolitaireGUIController(model, view);
    view.refresh();


  }
}
