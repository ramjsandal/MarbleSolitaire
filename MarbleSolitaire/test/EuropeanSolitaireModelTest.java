import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests {@code EuropeanSolitiareModel} and its methods.
 */
public class EuropeanSolitaireModelTest extends AbstractSolitaireModelTest {

  MarbleSolitaireModel three;


  @Before
  public void init() {
    this.three = new EuropeanSolitaireModel();
  }

  @Override
  protected MarbleSolitaireModel createThreeThickness() {
    return new EuropeanSolitaireModel();
  }

  @Override
  protected MarbleSolitaireModel createFiveThickness() {
    return new EuropeanSolitaireModel(5);
  }

  @Override
  protected MarbleSolitaireModel createSevenThickness() {
    return new EuropeanSolitaireModel(7);
  }


  @Test
  public void constructorTestThreeArgs() {

    // valid constructor
    try {
      EuropeanSolitaireModel valid = new EuropeanSolitaireModel(3, 3, 3);
      assertEquals(MarbleSolitaireModelState.SlotState.Empty, valid.getSlotAt(3, 3));
      for (int i = 0; i < 7; i++) {
        for (int j = 0; j < 7; j++) {
          if ((i == 0 && (j == 0 || j == 1 || j == 5 || j == 6)) ||
                  (i == 1 && (j == 0 || j == 6)) ||
                  (i == 6 && (j == 0 || j == 1 || j == 5 || j == 6)) ||
                  (i == 5 && (j == 0 || j == 6))) {
            assertEquals(MarbleSolitaireModelState.SlotState.Invalid, valid.getSlotAt(i, j));
          } else if (i == 3 && j == 3) {
            assertEquals(MarbleSolitaireModelState.SlotState.Empty, valid.getSlotAt(i, j));
          } else {
            assertEquals(MarbleSolitaireModelState.SlotState.Marble, valid.getSlotAt(i, j));
          }
        }
      }
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      fail("Should not have thrown an IllegalArgumentException.");
    }

    // valid constructor
    try {
      EuropeanSolitaireModel valid = new EuropeanSolitaireModel(5, 6, 6);
      assertEquals(MarbleSolitaireModelState.SlotState.Empty, valid.getSlotAt(6, 6));
    } catch (IllegalArgumentException e) {
      fail("Should not have thrown an IllegalArgumentException.");
    }

    // valid constructor, empty in top left corner
    try {
      EuropeanSolitaireModel valid = new EuropeanSolitaireModel(5, 1, 3);
      assertEquals(MarbleSolitaireModelState.SlotState.Empty, valid.getSlotAt(1, 3));
    } catch (IllegalArgumentException e) {
      fail("Should not have thrown an IllegalArgumentException.");
    }

    // valid constructor, empty in top left corner
    try {
      EuropeanSolitaireModel valid = new EuropeanSolitaireModel(5, 2, 2);
      assertEquals(MarbleSolitaireModelState.SlotState.Empty, valid.getSlotAt(2, 2));
    } catch (IllegalArgumentException e) {
      fail("Should not have thrown an IllegalArgumentException.");
    }

    // valid constructor, empty in top left corner
    try {
      EuropeanSolitaireModel valid = new EuropeanSolitaireModel(5, 3, 1);
      assertEquals(MarbleSolitaireModelState.SlotState.Empty, valid.getSlotAt(3, 1));
    } catch (IllegalArgumentException e) {
      fail("Should not have thrown an IllegalArgumentException.");
    }

    // valid constructor, empty in top right corner
    try {
      EuropeanSolitaireModel valid = new EuropeanSolitaireModel(5, 1, 9);
      assertEquals(MarbleSolitaireModelState.SlotState.Empty, valid.getSlotAt(1, 9));
    } catch (IllegalArgumentException e) {
      fail("Should not have thrown an IllegalArgumentException.");
    }

    // valid constructor, empty in bottom left corner
    try {
      EuropeanSolitaireModel valid = new EuropeanSolitaireModel(5, 9, 1);
      assertEquals(MarbleSolitaireModelState.SlotState.Empty, valid.getSlotAt(9, 1));
    } catch (IllegalArgumentException e) {
      fail("Should not have thrown an IllegalArgumentException.");
    }

    // valid constructor, empty in bottom right corner
    try {
      EuropeanSolitaireModel valid = new EuropeanSolitaireModel(5, 9, 8);
      assertEquals(MarbleSolitaireModelState.SlotState.Empty, valid.getSlotAt(9, 8));
    } catch (IllegalArgumentException e) {
      fail("Should not have thrown an IllegalArgumentException.");
    }

    // negative thickness
    try {
      EuropeanSolitaireModel invalid = new EuropeanSolitaireModel(-3, 3, 3);
      fail("Should have thrown an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid thickness.", e.getMessage());
    }

    // even thickness
    try {
      EuropeanSolitaireModel invalid = new EuropeanSolitaireModel(4, 3, 3);
      fail("Should have thrown an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid thickness.", e.getMessage());
    }

    // negative empty row
    try {
      EuropeanSolitaireModel invalid = new EuropeanSolitaireModel(3, -3, 3);
      fail("Should have thrown an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals("Empty square out of bounds.", e.getMessage());
    }

    // too large empty row
    try {
      EuropeanSolitaireModel invalid = new EuropeanSolitaireModel(3, 7, 3);
      fail("Should have thrown an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals("Empty square out of bounds.", e.getMessage());
    }

    // negative empty col
    try {
      EuropeanSolitaireModel invalid = new EuropeanSolitaireModel(3, 3, -3);
      fail("Should have thrown an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals("Empty square out of bounds.", e.getMessage());
    }

    // too large empty col
    try {
      EuropeanSolitaireModel invalid = new EuropeanSolitaireModel(3, 3, 7);
      fail("Should have thrown an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals("Empty square out of bounds.", e.getMessage());
    }

    // empty on invalid top left
    try {
      EuropeanSolitaireModel invalid = new EuropeanSolitaireModel(5, 0, 0);
      fail("Should have thrown an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals("Cannot put empty space on invalid square.", e.getMessage());
    }

    // empty on invalid top left
    try {
      EuropeanSolitaireModel invalid = new EuropeanSolitaireModel(5, 1, 2);
      fail("Should have thrown an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals("Cannot put empty space on invalid square.", e.getMessage());
    }

    // empty on invalid top right
    try {
      EuropeanSolitaireModel invalid = new EuropeanSolitaireModel(5, 2, 11);
      fail("Should have thrown an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals("Cannot put empty space on invalid square.", e.getMessage());
    }

    // empty on invalid bot left
    try {
      EuropeanSolitaireModel invalid = new EuropeanSolitaireModel(5, 11, 2);
      fail("Should have thrown an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals("Cannot put empty space on invalid square.", e.getMessage());
    }

    // empty on invalid bot right
    try {
      EuropeanSolitaireModel invalid = new EuropeanSolitaireModel(5, 11, 11);
      fail("Should have thrown an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals("Cannot put empty space on invalid square.", e.getMessage());
    }

  }

  @Test
  public void constructorTestTwoArgs() {

    try {
      EuropeanSolitaireModel valid = new EuropeanSolitaireModel(3, 3);
      assertEquals(valid.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);
      for (int i = 0; i < 7; i++) {
        for (int j = 0; j < 7; j++) {
          if ((i == 0 && (j == 0 || j == 1 || j == 5 || j == 6)) ||
                  (i == 1 && (j == 0 || j == 6)) ||
                  (i == 6 && (j == 0 || j == 1 || j == 5 || j == 6)) ||
                  (i == 5 && (j == 0 || j == 6))) {
            assertEquals(MarbleSolitaireModelState.SlotState.Invalid, valid.getSlotAt(i, j));
          } else if (i == 3 && j == 3) {
            assertEquals(MarbleSolitaireModelState.SlotState.Empty, valid.getSlotAt(i, j));
          } else {
            assertEquals(MarbleSolitaireModelState.SlotState.Marble, valid.getSlotAt(i, j));
          }
        }
      }
    } catch (IllegalArgumentException e) {
      fail("Should not have thrown an IllegalArgumentException.");
    }

    // valid constructor, empty in top left corner
    try {
      EuropeanSolitaireModel valid = new EuropeanSolitaireModel(1, 1);
      assertEquals(MarbleSolitaireModelState.SlotState.Empty, valid.getSlotAt(1, 1));
    } catch (IllegalArgumentException e) {
      fail("Should not have thrown an IllegalArgumentException.");
    }


    // valid constructor, empty in top right corner
    try {
      EuropeanSolitaireModel valid = new EuropeanSolitaireModel(1, 5);
      assertEquals(MarbleSolitaireModelState.SlotState.Empty, valid.getSlotAt(1, 5));
    } catch (IllegalArgumentException e) {
      fail("Should not have thrown an IllegalArgumentException.");
    }

    // valid constructor, empty in bottom left corner
    try {
      EuropeanSolitaireModel valid = new EuropeanSolitaireModel(5, 1);
      assertEquals(MarbleSolitaireModelState.SlotState.Empty, valid.getSlotAt(5, 1));
    } catch (IllegalArgumentException e) {
      fail("Should not have thrown an IllegalArgumentException.");
    }

    // valid constructor, empty in bottom right corner
    try {
      EuropeanSolitaireModel valid = new EuropeanSolitaireModel(5, 5);
      assertEquals(MarbleSolitaireModelState.SlotState.Empty, valid.getSlotAt(5, 5));
    } catch (IllegalArgumentException e) {
      fail("Should not have thrown an IllegalArgumentException.");
    }

    // negative empty row
    try {
      EuropeanSolitaireModel invalid = new EuropeanSolitaireModel(-3, 3);
      fail("Should have thrown an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals("Empty square out of bounds.", e.getMessage());
    }

    // too large empty row
    try {
      EuropeanSolitaireModel invalid = new EuropeanSolitaireModel(7, 3);
      fail("Should have thrown an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals("Empty square out of bounds.", e.getMessage());
    }

    // negative empty col
    try {
      EuropeanSolitaireModel invalid = new EuropeanSolitaireModel(3, -3);
      fail("Should have thrown an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals("Empty square out of bounds.", e.getMessage());
    }

    // too large empty col
    try {
      EuropeanSolitaireModel invalid = new EuropeanSolitaireModel(3, 7);
      fail("Should have thrown an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals("Empty square out of bounds.", e.getMessage());
    }

    // empty on invalid top left
    try {
      EuropeanSolitaireModel invalid = new EuropeanSolitaireModel(0, 0);
      fail("Should have thrown an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals("Cannot put empty space on invalid square.", e.getMessage());
    }

    // empty on invalid top left
    try {
      EuropeanSolitaireModel invalid = new EuropeanSolitaireModel(0, 1);
      fail("Should have thrown an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals("Cannot put empty space on invalid square.", e.getMessage());
    }

    // empty on invalid top left
    try {
      EuropeanSolitaireModel invalid = new EuropeanSolitaireModel(1, 0);
      fail("Should have thrown an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals("Cannot put empty space on invalid square.", e.getMessage());
    }

    // empty on invalid top right
    try {
      EuropeanSolitaireModel invalid = new EuropeanSolitaireModel(0, 5);
      fail("Should have thrown an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals("Cannot put empty space on invalid square.", e.getMessage());
    }

    // empty on invalid bot left
    try {
      EuropeanSolitaireModel invalid = new EuropeanSolitaireModel(5, 0);
      System.out.println(new MarbleSolitaireTextView(invalid).toString());
      fail("Should have thrown an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals("Cannot put empty space on invalid square.", e.getMessage());
    }

    // empty on invalid bot right
    try {
      EuropeanSolitaireModel invalid = new EuropeanSolitaireModel(5, 6);
      fail("Should have thrown an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals("Cannot put empty space on invalid square.", e.getMessage());
    }

  }

  @Test
  public void constructorTestOneArg() {

    // valid constructor
    try {
      EuropeanSolitaireModel valid = new EuropeanSolitaireModel(3);
      assertEquals(MarbleSolitaireModelState.SlotState.Empty, valid.getSlotAt(3, 3));
      for (int i = 0; i < 7; i++) {
        for (int j = 0; j < 7; j++) {
          if ((i == 0 && (j == 0 || j == 1 || j == 5 || j == 6)) ||
                  (i == 1 && (j == 0 || j == 6)) ||
                  (i == 6 && (j == 0 || j == 1 || j == 5 || j == 6)) ||
                  (i == 5 && (j == 0 || j == 6))) {
            assertEquals(MarbleSolitaireModelState.SlotState.Invalid, valid.getSlotAt(i, j));
          } else if (i == 3 && j == 3) {
            assertEquals(MarbleSolitaireModelState.SlotState.Empty, valid.getSlotAt(i, j));
          } else {
            assertEquals(MarbleSolitaireModelState.SlotState.Marble, valid.getSlotAt(i, j));
          }
        }
      }
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      fail("Should not have thrown an IllegalArgumentException.");
    }

    // valid constructor
    try {
      EuropeanSolitaireModel valid = new EuropeanSolitaireModel(5);
      assertEquals(MarbleSolitaireModelState.SlotState.Empty, valid.getSlotAt(6, 6));
    } catch (IllegalArgumentException e) {
      fail("Should not have thrown an IllegalArgumentException.");
    }

    // negative thickness
    try {
      EuropeanSolitaireModel invalid = new EuropeanSolitaireModel(-3);
      fail("Should have thrown an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid thickness.", e.getMessage());
    }

    // even thickness
    try {
      EuropeanSolitaireModel invalid = new EuropeanSolitaireModel(4);
      fail("Should have thrown an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid thickness.", e.getMessage());
    }
  }

  @Test
  public void constructorTestNoArgs() {
    // valid constructor
    try {
      EuropeanSolitaireModel valid = new EuropeanSolitaireModel();
      assertEquals(MarbleSolitaireModelState.SlotState.Empty, valid.getSlotAt(3, 3));

      for (int i = 0; i < 7; i++) {
        for (int j = 0; j < 7; j++) {
          if ((i == 0 && (j == 0 || j == 1 || j == 5 || j == 6)) ||
                  (i == 1 && (j == 0 || j == 6)) ||
                  (i == 6 && (j == 0 || j == 1 || j == 5 || j == 6)) ||
                  (i == 5 && (j == 0 || j == 6))) {
            assertEquals(MarbleSolitaireModelState.SlotState.Invalid, valid.getSlotAt(i, j));
          } else if (i == 3 && j == 3) {
            assertEquals(MarbleSolitaireModelState.SlotState.Empty, valid.getSlotAt(i, j));
          } else {
            assertEquals(MarbleSolitaireModelState.SlotState.Marble, valid.getSlotAt(i, j));
          }
        }
      }

    } catch (IllegalArgumentException e) {
      fail("Should not have thrown an IllegalArgumentException.");
    }
  }

  @Test
  public void moveToAndFromTopRightCornerTest() {
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.three.getSlotAt(1, 5));
    this.three.move(3, 5, 3, 3);
    this.three.move(1, 5, 3, 5);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.three.getSlotAt(1, 5));
    this.three.move(1, 3, 1, 5);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.three.getSlotAt(1, 5));
  }

  @Test
  public void moveToAndFromTopLeftCornerTest() {
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.three.getSlotAt(1, 1));
    this.three.move(3, 1, 3, 3);
    this.three.move(1, 1, 3, 1);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.three.getSlotAt(1, 1));
    this.three.move(1, 3, 1, 1);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.three.getSlotAt(1, 1));
  }

  @Test
  public void moveToAndFromBotRightCornerTest() {
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.three.getSlotAt(5, 5));
    this.three.move(3, 5, 3, 3);
    this.three.move(5, 5, 3, 5);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.three.getSlotAt(5, 5));
    this.three.move(5, 3, 5, 5);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.three.getSlotAt(5, 5));
  }

  @Test
  public void moveToAndFromBotLeftCornerTest() {
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.three.getSlotAt(5, 1));
    this.three.move(3, 1, 3, 3);
    this.three.move(5, 1, 3, 1);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.three.getSlotAt(5, 1));
    this.three.move(5, 3, 5, 1);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.three.getSlotAt(5, 1));
  }

  @Test
  public void isGameOverTrueTest() {
    MarbleSolitaireModel valid = new EuropeanSolitaireModel(3, 0, 2);

    valid.move(0, 4, 0, 2);
    valid.move(2, 3, 0, 3);
    valid.move(1, 5, 1, 3);
    valid.move(0, 3, 2, 3);
    valid.move(3, 3, 1, 3);
    valid.move(5, 3, 3, 3);
    valid.move(5, 1, 5, 3);
    valid.move(6, 3, 4, 3);
    valid.move(1, 2, 1, 4);
    valid.move(3, 2, 1, 2);
    valid.move(3, 4, 3, 2);
    valid.move(5, 4, 3, 4);
    valid.move(0, 2, 2, 2);
    valid.move(3, 2, 1, 2);
    valid.move(1, 1, 1, 3);
    valid.move(1, 4, 1, 2);
    valid.move(3, 4, 1, 4);
    valid.move(2, 0, 2, 2);
    valid.move(3, 0, 3, 2);
    valid.move(2, 6, 2, 4);
    valid.move(3, 6, 3, 4);
    valid.move(4, 6, 4, 4);
    valid.move(3, 2, 5, 2);
    valid.move(1, 2, 3, 2);
    valid.move(6, 2, 4, 2);
    valid.move(3, 2, 5, 2);
    valid.move(3, 4, 5, 4);
    valid.move(1, 4, 3, 4);
    valid.move(6, 4, 4, 4);
    valid.move(3, 4, 5, 4);
    valid.move(5, 5, 5, 3);
    valid.move(4, 0, 4, 2);
    valid.move(4, 2, 6, 2);
    valid.move(4, 3, 6, 3);

    assertEquals(false, valid.isGameOver());

    valid.move(6, 2, 6, 4);

    assertEquals(true, valid.isGameOver());

  }

  @Test
  public void getScoreTest() {
    MarbleSolitaireModel valid = new EuropeanSolitaireModel(3, 0, 2);

    assertEquals(36, valid.getScore());

    valid.move(0, 4, 0, 2);

    assertEquals(35, valid.getScore());

    valid.move(2, 3, 0, 3);

    assertEquals(34, valid.getScore());

    valid.move(1, 5, 1, 3);
    valid.move(0, 3, 2, 3);
    valid.move(3, 3, 1, 3);
    valid.move(5, 3, 3, 3);
    valid.move(5, 1, 5, 3);
    valid.move(6, 3, 4, 3);
    valid.move(1, 2, 1, 4);
    valid.move(3, 2, 1, 2);
    valid.move(3, 4, 3, 2);
    valid.move(5, 4, 3, 4);
    valid.move(0, 2, 2, 2);
    valid.move(3, 2, 1, 2);
    valid.move(1, 1, 1, 3);
    valid.move(1, 4, 1, 2);
    valid.move(3, 4, 1, 4);
    valid.move(2, 0, 2, 2);
    valid.move(3, 0, 3, 2);
    valid.move(2, 6, 2, 4);
    valid.move(3, 6, 3, 4);
    valid.move(4, 6, 4, 4);
    valid.move(3, 2, 5, 2);
    valid.move(1, 2, 3, 2);
    valid.move(6, 2, 4, 2);
    valid.move(3, 2, 5, 2);
    valid.move(3, 4, 5, 4);
    valid.move(1, 4, 3, 4);
    valid.move(6, 4, 4, 4);
    valid.move(3, 4, 5, 4);
    valid.move(5, 5, 5, 3);
    valid.move(4, 0, 4, 2);
    valid.move(4, 2, 6, 2);
    valid.move(4, 3, 6, 3);

    assertEquals(2, valid.getScore());

    valid.move(6, 2, 6, 4);

    assertEquals(1, valid.getScore());

  }

}