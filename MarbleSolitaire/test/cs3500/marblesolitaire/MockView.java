package cs3500.marblesolitaire;

import java.io.StringWriter;

import cs3500.marblesolitaire.model.controller.Features;
import cs3500.marblesolitaire.view.MarbleSolitaireGuiView;

/**
 * fokdjis.
 */
public class MockView implements MarbleSolitaireGuiView {
  StringWriter log;

  public MockView(StringWriter log) {
    this.log = log;
  }

  @Override
  public void refresh() {
    this.log.append("I just refreshed");
  }

  @Override
  public void renderMessage(String message) {
    //comment
  }

  @Override
  public void acceptFeatures(Features c) {
    //comment
  }
}
