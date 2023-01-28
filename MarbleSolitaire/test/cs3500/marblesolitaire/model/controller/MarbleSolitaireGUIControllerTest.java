package cs3500.marblesolitaire.model.controller;

import org.junit.Before;
import org.junit.Test;

import java.io.StringWriter;

import cs3500.marblesolitaire.MockView;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.view.MarbleSolitaireGuiView;

import static org.junit.Assert.assertEquals;

/**
 * test.
 */
public class MarbleSolitaireGUIControllerTest {

  MarbleSolitaireModel model;
  MarbleSolitaireGuiView view;
  Features controller;

  StringWriter log;

  @Before
  public void init() {
    this.log = new StringWriter();
    this.model = new EnglishSolitaireModel();
    this.view = new MockView(log);
    this.controller = new MarbleSolitaireGUIController(this.model, this.view);
  }

  @Test
  public void moveInput() {
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(3, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(3, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(3, 3));
    assertEquals(32, this.model.getScore());
    assertEquals("", this.log.toString());


    this.controller.moveInput(3, 1);
    this.controller.moveInput(3, 3);

    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(3, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(3, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(3, 3));
    assertEquals(31, this.model.getScore());
    assertEquals("I just refreshed", this.log.toString());
  }
}