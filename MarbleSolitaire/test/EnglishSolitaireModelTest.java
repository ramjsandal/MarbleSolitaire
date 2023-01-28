import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

import static org.junit.Assert.assertEquals;

/**
 * Tests EnglishSolitaireModel and its methods.
 */
public class EnglishSolitaireModelTest extends AbstractSolitaireModelTest {

  EnglishSolitaireModel basic;
  EnglishSolitaireModel five;
  EnglishSolitaireModel seven;

  @Override
  protected MarbleSolitaireModel createThreeThickness() {
    return new EnglishSolitaireModel();
  }

  @Override
  protected MarbleSolitaireModel createFiveThickness() {
    return new EnglishSolitaireModel(5);
  }

  @Override
  protected MarbleSolitaireModel createSevenThickness() {
    return new EnglishSolitaireModel(7);
  }

  @Before
  public void init() {
    this.basic = new EnglishSolitaireModel();
    this.five = new EnglishSolitaireModel(5);
    this.seven = new EnglishSolitaireModel(7);
  }


  @Test
  public void constructorOneInputTest() {
    // negative thickness
    try {
      EnglishSolitaireModel negativeThickness = new EnglishSolitaireModel(-2);
      Assert.fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    // even thickness
    try {
      EnglishSolitaireModel evenThickness = new EnglishSolitaireModel(2);
      Assert.fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    // test that each cell initializes correctly in the constructor with one field.
    for (int i = 0; i < five.getBoardSize(); i++) {
      for (int j = 0; j < five.getBoardSize(); j++) {
        if (i < 4) {
          if (j < 4 || j > 8) {
            assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
                    five.getSlotAt(i, j));
          }
        } else if (i > 8) {
          if (j < 4 || j > 8) {
            assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
                    five.getSlotAt(i, j));
          }
        } else if (i == 6 && j == 6) {
          assertEquals(MarbleSolitaireModelState.SlotState.Empty, five.getSlotAt(i, j));
        } else {
          assertEquals(MarbleSolitaireModelState.SlotState.Marble, five.getSlotAt(i, j));
        }

      }
    }

  }

  @Test
  public void constructorTwoInputTest() {

    // empty is offscreen
    try {
      EnglishSolitaireModel emptyOffScreen = new EnglishSolitaireModel(7, 4);
      Assert.fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    // empty is offscreen
    try {
      EnglishSolitaireModel emptyOffScreen = new EnglishSolitaireModel(4, 7);
      Assert.fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    // empty is negative
    try {
      EnglishSolitaireModel emptyNegative = new EnglishSolitaireModel(-3, -3);
      Assert.fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }


    // empty is on an invalid square
    try {
      EnglishSolitaireModel emptyInInvalid = new EnglishSolitaireModel(0, 0);
      Assert.fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }


    // tests that the board initializes correctly with the constructor with two fields.
    EnglishSolitaireModel testTwoInputs = new EnglishSolitaireModel(3, 2);

    for (int i = 0; i < 7; i++) {
      for (int j = 0; j < 7; j++) {
        if (i < 2) {
          if (j < 2 || j > 4) {
            assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
                    testTwoInputs.getSlotAt(i, j));
          }
        } else if (i > 4) {
          if (j < 2 || j > 4) {
            assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
                    testTwoInputs.getSlotAt(i, j));
          }
        } else if (i == 3 && j == 2) {
          assertEquals(MarbleSolitaireModelState.SlotState.Empty, testTwoInputs.getSlotAt(i, j));
        } else {
          assertEquals(MarbleSolitaireModelState.SlotState.Marble, testTwoInputs.getSlotAt(i, j));
        }

      }
    }
  }

  @Test
  public void constructorThreeInputTest() {
    // even thickness
    try {
      EnglishSolitaireModel evenThickness = new EnglishSolitaireModel(4, 4, 4);
      Assert.fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    // negative thickness
    try {
      EnglishSolitaireModel negativeThickness = new EnglishSolitaireModel(-3, 3, 3);
      Assert.fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    // empty is offscreen
    try {
      EnglishSolitaireModel emptyOffScreen = new EnglishSolitaireModel(3, 7, 1);
      Assert.fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    // empty is offscreen
    try {
      EnglishSolitaireModel emptyOffScreen = new EnglishSolitaireModel(3, 1, 7);
      Assert.fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    // empty in on an invalid square
    try {
      EnglishSolitaireModel emptyInvalid = new EnglishSolitaireModel(3, 1, 1);
      Assert.fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    // empty is negative
    try {
      EnglishSolitaireModel emptyNegative = new EnglishSolitaireModel(3, -3, -3);
      Assert.fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    // tests that the board initializes correctly with the constructor with three fields.
    EnglishSolitaireModel testThreeInputs = new EnglishSolitaireModel(3, 3, 2);

    for (int i = 0; i < 7; i++) {
      for (int j = 0; j < 7; j++) {
        if (i < 2) {
          if (j < 2 || j > 4) {
            assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
                    testThreeInputs.getSlotAt(i, j));
          }
        } else if (i > 4) {
          if (j < 2 || j > 4) {
            assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
                    testThreeInputs.getSlotAt(i, j));
          }
        } else if (i == 3 && j == 2) {
          assertEquals(MarbleSolitaireModelState.SlotState.Empty, testThreeInputs.getSlotAt(i, j));
        } else {
          assertEquals(MarbleSolitaireModelState.SlotState.Marble, testThreeInputs.getSlotAt(i, j));
        }

      }
    }

  }


  @Test
  public void constructorNoInputTest() {

    for (int i = 0; i < 7; i++) {
      for (int j = 0; j < 7; j++) {
        if (i < 2) {
          if (j < 2 || j > 4) {
            assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
                    this.basic.getSlotAt(i, j));
          }
        } else if (i > 4) {
          if (j < 2 || j > 4) {
            assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
                    this.basic.getSlotAt(i, j));
          }
        } else if (i == 3 && j == 3) {
          assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.basic.getSlotAt(i, j));
        } else {
          assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.basic.getSlotAt(i, j));
        }

      }
    }


  }


  @Test
  public void isGameOverTrue() {

    MarbleSolitaireModel valid = this.createThreeThickness();

    valid.move(5, 3, 3, 3);
    valid.move(4, 5, 4, 3);
    valid.move(6, 4, 4, 4);
    valid.move(6, 2, 6, 4);
    valid.move(3, 4, 5, 4);
    valid.move(6, 4, 4, 4);
    valid.move(1, 4, 3, 4);
    valid.move(2, 6, 2, 4);
    valid.move(4, 6, 2, 6);
    valid.move(2, 3, 2, 5);
    valid.move(2, 6, 2, 4);
    valid.move(2, 1, 2, 3);
    valid.move(0, 2, 2, 2);
    valid.move(0, 4, 0, 2);
    valid.move(3, 2, 1, 2);
    valid.move(0, 2, 2, 2);
    valid.move(5, 2, 3, 2);
    valid.move(4, 0, 4, 2);
    valid.move(2, 0, 4, 0);
    valid.move(4, 3, 4, 1);
    valid.move(4, 0, 4, 2);
    valid.move(2, 3, 2, 1);
    valid.move(2, 1, 4, 1);
    valid.move(4, 1, 4, 3);
    valid.move(4, 3, 4, 5);
    valid.move(4, 5, 2, 5);
    valid.move(2, 5, 2, 3);
    valid.move(3, 3, 3, 5);
    valid.move(1, 3, 3, 3);
    valid.move(3, 2, 3, 4);

    assertEquals(false, valid.isGameOver());

    valid.move(3, 5, 3, 3);

    assertEquals(true, valid.isGameOver());


  }



  @org.junit.Test
  public void getScore() {

    MarbleSolitaireModel valid2 = this.createThreeThickness();

    assertEquals(32, valid2.getScore());

    valid2.move(3, 5, 3, 3);

    assertEquals(31, valid2.getScore());

    valid2.move(1, 4, 3, 4);

    assertEquals(30, valid2.getScore());


    MarbleSolitaireModel valid = this.createThreeThickness();

    valid.move(5, 3, 3, 3);
    valid.move(4, 5, 4, 3);
    valid.move(6, 4, 4, 4);
    valid.move(6, 2, 6, 4);
    valid.move(3, 4, 5, 4);
    valid.move(6, 4, 4, 4);
    valid.move(1, 4, 3, 4);
    valid.move(2, 6, 2, 4);
    valid.move(4, 6, 2, 6);
    valid.move(2, 3, 2, 5);
    valid.move(2, 6, 2, 4);
    valid.move(2, 1, 2, 3);
    valid.move(0, 2, 2, 2);
    valid.move(0, 4, 0, 2);
    valid.move(3, 2, 1, 2);
    valid.move(0, 2, 2, 2);
    valid.move(5, 2, 3, 2);
    valid.move(4, 0, 4, 2);
    valid.move(2, 0, 4, 0);
    valid.move(4, 3, 4, 1);
    valid.move(4, 0, 4, 2);
    valid.move(2, 3, 2, 1);
    valid.move(2, 1, 4, 1);
    valid.move(4, 1, 4, 3);
    valid.move(4, 3, 4, 5);
    valid.move(4, 5, 2, 5);
    valid.move(2, 5, 2, 3);
    valid.move(3, 3, 3, 5);
    valid.move(1, 3, 3, 3);

    assertEquals(3, valid.getScore());

    valid.move(3, 2, 3, 4);
    valid.move(3, 5, 3, 3);

    assertEquals(1, valid.getScore());

  }
}