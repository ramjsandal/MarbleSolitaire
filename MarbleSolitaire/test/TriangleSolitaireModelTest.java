import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests {@code TriangleSolitaireModel} and its methods.
 */
public class TriangleSolitaireModelTest {

  MarbleSolitaireModel fiveByFive;


  @Before
  public void init() {
    this.fiveByFive = new TriangleSolitaireModel();
  }

  @Test
  public void constructorNoInputTest() {
    for (int i = 0; i < this.fiveByFive.getBoardSize(); i++) {
      for (int j = 0; j < this.fiveByFive.getBoardSize(); j++) {

        if (i == 0 && j == 0) {
          assertEquals(this.fiveByFive.getSlotAt(i, j), MarbleSolitaireModelState.SlotState.Empty);
        } else if (j > i) {
          assertEquals(this.fiveByFive.getSlotAt(i, j),
                  MarbleSolitaireModelState.SlotState.Invalid);
        } else {
          assertEquals(this.fiveByFive.getSlotAt(i, j), MarbleSolitaireModelState.SlotState.Marble);
        }

      }
    }
  }

  @Test
  public void constructorOneInputTest() {

    // negative thickness
    try {
      MarbleSolitaireModel invalid = new TriangleSolitaireModel(-1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Thickness cannot be negative or zero.", e.getMessage());
    }

    // zero thickness
    try {
      MarbleSolitaireModel invalid = new TriangleSolitaireModel(0);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Thickness cannot be negative or zero.", e.getMessage());
    }

    for (int i = 0; i < this.fiveByFive.getBoardSize(); i++) {
      for (int j = 0; j < this.fiveByFive.getBoardSize(); j++) {

        if (i == 0 && j == 0) {
          assertEquals(this.fiveByFive.getSlotAt(i, j), MarbleSolitaireModelState.SlotState.Empty);
        } else if (j > i) {
          assertEquals(this.fiveByFive.getSlotAt(i, j),
                  MarbleSolitaireModelState.SlotState.Invalid);
        } else {
          assertEquals(this.fiveByFive.getSlotAt(i, j), MarbleSolitaireModelState.SlotState.Marble);
        }

      }
    }

  }

  @Test
  public void constructorTwoInputTest() {

    // negative empty row
    try {
      MarbleSolitaireModel invalid = new TriangleSolitaireModel(-1, 1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Empty square must be on the board.", e.getMessage());
    }

    // negative empty col
    try {
      MarbleSolitaireModel invalid = new TriangleSolitaireModel(1, -1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Empty square must be on the board.", e.getMessage());
    }

    // too big empty row
    try {
      MarbleSolitaireModel invalid = new TriangleSolitaireModel(6, 1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Empty square must be on the board.", e.getMessage());
    }

    // too big empty col
    try {
      MarbleSolitaireModel invalid = new TriangleSolitaireModel(1, 6);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Empty square must be on the board.", e.getMessage());
    }

    // empty on invalid
    try {
      MarbleSolitaireModel invalid = new TriangleSolitaireModel(0, 1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Empty square must be on the board.", e.getMessage());
    }

    for (int i = 0; i < this.fiveByFive.getBoardSize(); i++) {
      for (int j = 0; j < this.fiveByFive.getBoardSize(); j++) {

        if (i == 0 && j == 0) {
          assertEquals(this.fiveByFive.getSlotAt(i, j), MarbleSolitaireModelState.SlotState.Empty);
        } else if (j > i) {
          assertEquals(this.fiveByFive.getSlotAt(i, j),
                  MarbleSolitaireModelState.SlotState.Invalid);
        } else {
          assertEquals(this.fiveByFive.getSlotAt(i, j), MarbleSolitaireModelState.SlotState.Marble);
        }

      }
    }

  }

  @Test
  public void constructorThreeInputTest() {

    // negative thickness
    try {
      MarbleSolitaireModel invalid = new TriangleSolitaireModel(-5, 1, 1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Thickness cannot be negative or zero.", e.getMessage());
    }

    // zero thickness
    try {
      MarbleSolitaireModel invalid = new TriangleSolitaireModel(0, 1, 1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Thickness cannot be negative or zero.", e.getMessage());
    }

    // negative empty row
    try {
      MarbleSolitaireModel invalid = new TriangleSolitaireModel(5, -1, 1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Empty square must be on the board.", e.getMessage());
    }

    // negative empty col
    try {
      MarbleSolitaireModel invalid = new TriangleSolitaireModel(5, 1, -1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Empty square must be on the board.", e.getMessage());
    }

    // too big empty row
    try {
      MarbleSolitaireModel invalid = new TriangleSolitaireModel(5, 6, 1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Empty square must be on the board.", e.getMessage());
    }

    // too big empty col
    try {
      MarbleSolitaireModel invalid = new TriangleSolitaireModel(5, 1, 6);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Empty square must be on the board.", e.getMessage());
    }

    // empty on invalid
    try {
      MarbleSolitaireModel invalid = new TriangleSolitaireModel(5, 4, 5);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Empty square must be on the board.", e.getMessage());
    }

    for (int i = 0; i < this.fiveByFive.getBoardSize(); i++) {
      for (int j = 0; j < this.fiveByFive.getBoardSize(); j++) {

        if (i == 0 && j == 0) {
          assertEquals(this.fiveByFive.getSlotAt(i, j), MarbleSolitaireModelState.SlotState.Empty);
        } else if (j > i) {
          assertEquals(this.fiveByFive.getSlotAt(i, j),
                  MarbleSolitaireModelState.SlotState.Invalid);
        } else {
          assertEquals(this.fiveByFive.getSlotAt(i, j), MarbleSolitaireModelState.SlotState.Marble);
        }

      }
    }

  }

  @Test
  public void moveDirectionsTest() {


    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.fiveByFive.getSlotAt(2, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.fiveByFive.getSlotAt(1, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.fiveByFive.getSlotAt(0, 0));

    // move up/right
    this.fiveByFive.move(2, 0, 0, 0);

    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.fiveByFive.getSlotAt(2, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.fiveByFive.getSlotAt(1, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.fiveByFive.getSlotAt(0, 0));

    // move up/left
    this.fiveByFive.move(3, 2, 1, 0);

    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.fiveByFive.getSlotAt(3, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.fiveByFive.getSlotAt(2, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.fiveByFive.getSlotAt(1, 0));

    // move right
    this.fiveByFive.move(3, 0, 3, 2);

    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.fiveByFive.getSlotAt(3, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.fiveByFive.getSlotAt(3, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.fiveByFive.getSlotAt(3, 2));

    // move left
    this.fiveByFive.move(3, 3, 3, 1);

    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.fiveByFive.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.fiveByFive.getSlotAt(3, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.fiveByFive.getSlotAt(3, 1));

    // move down/left
    this.fiveByFive.move(0, 0, 2, 0);

    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.fiveByFive.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.fiveByFive.getSlotAt(1, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.fiveByFive.getSlotAt(2, 0));

    // move down/right
    this.fiveByFive.move(1, 1, 3, 3);

    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.fiveByFive.getSlotAt(1, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.fiveByFive.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.fiveByFive.getSlotAt(3, 3));

  }

  @Test
  public void moveRandomlyTest() {
    try {
      this.fiveByFive.move(3, 2, 0, 0);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Must move exactly two squares with the square in the middle being" +
              " a Marble.", e.getMessage());
    }
  }

  @Test
  public void moveExceptionsTest() {

    // moving to the same place
    try {
      this.fiveByFive.move(2, 0, 2, 0);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Must move a Marble that is on the board " +
              "to an Empty square on the board.", e.getMessage());
    }

    // moving off the board
    try {
      this.fiveByFive.move(2, 1, 2, 3);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Must move a Marble that is on the board " +
              "to an Empty square on the board.", e.getMessage());
    }

    // moving from off the board
    try {
      this.fiveByFive.move(2, 2, 2, 0);
      this.fiveByFive.move(3, 2, 1, 0);
      this.fiveByFive.move(0, 1, 2, 1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Must move a Marble that is on the board " +
              "to an Empty square on the board.", e.getMessage());
    }


    // moving from one place on the board to another that is far away and not a valid move.
    try {
      this.fiveByFive.move(2, 3, 2, 0);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Must move a Marble that is on the board " +
              "to an Empty square on the board.", e.getMessage());
    }

  }

  @Test
  public void moveMarbleMarbleMarbleTest() {

    try {
      this.fiveByFive.move(3, 3, 3, 1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Must move a Marble that is on the board " +
              "to an Empty square on the board.", e.getMessage());
    }

  }

  @Test
  public void moveMarbleEmptyMarbleTest() {

    try {
      this.fiveByFive.move(2, 0, 0, 0);
      this.fiveByFive.move(4, 0, 2, 0);
      this.fiveByFive.move(2, 0, 0, 0);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Must move a Marble that is on the board " +
              "to an Empty square on the board.", e.getMessage());
    }
  }

  @Test
  public void moveMarbleEmptyEmptyTest() {

    try {
      this.fiveByFive.move(2, 0, 0, 0);
      this.fiveByFive.move(0, 0, 2, 0);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Must move exactly two squares " +
              "with the square in the middle being a Marble.", e.getMessage());
    }
  }

  @Test
  public void moveMarbleEmptyInvalidTest() {

    try {
      this.fiveByFive.move(2, 2, 0, 0);
      this.fiveByFive.move(2, 1, 2, 3);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Must move a Marble that is on the board " +
              "to an Empty square on the board.", e.getMessage());
    }
  }

  @Test
  public void moveEmptyMarbleMarbleTest() {
    try {
      this.fiveByFive.move(0, 0, 0, 2);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Must move a Marble that is on the board " +
              "to an Empty square on the board.", e.getMessage());
    }
  }

  @Test
  public void moveEmptyMarbleEmptyTest() {
    try {
      this.fiveByFive.move(0, 2, 0, 0);
      this.fiveByFive.move(0, 4, 0, 2);
      this.fiveByFive.move(0, 3, 0, 1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Must move a Marble that is on the board " +
              "to an Empty square on the board.", e.getMessage());
    }
  }

  @Test
  public void moveEmptyEmptyMarbleTest() {
    try {
      this.fiveByFive.move(0, 2, 0, 0);
      this.fiveByFive.move(0, 2, 0, 0);

      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Must move a Marble that is on the board " +
              "to an Empty square on the board.", e.getMessage());
    }
  }

  @Test
  public void moveEmptyEmptyEmptyTest() {
    try {
      this.fiveByFive.move(2, 0, 0, 0);
      this.fiveByFive.move(2, 2, 2, 0);
      this.fiveByFive.move(0, 0, 2, 2);
      this.fiveByFive.move(3, 0, 1, 0);
      this.fiveByFive.move(3, 3, 1, 1);
      this.fiveByFive.move(4, 1, 2, 1);
      this.fiveByFive.move(4, 3, 4, 1);
      this.fiveByFive.move(4, 0, 4, 2);
      this.fiveByFive.move(4, 2, 2, 2);
      this.fiveByFive.move(1, 1, 3, 3);
      this.fiveByFive.move(4, 4, 2, 2);
      this.fiveByFive.move(2, 2, 2, 0);
      this.fiveByFive.move(4, 4, 4, 2);

      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Must move a Marble that is on the board " +
              "to an Empty square on the board.", e.getMessage());
    }
  }


  @Test
  public void isGameOverTrueTest() {

    assertEquals(false, this.fiveByFive.isGameOver());

    this.fiveByFive.move(2, 0, 0, 0);
    this.fiveByFive.move(2, 2, 2, 0);
    this.fiveByFive.move(0, 0, 2, 2);
    this.fiveByFive.move(3, 0, 1, 0);
    this.fiveByFive.move(3, 3, 1, 1);
    this.fiveByFive.move(4, 1, 2, 1);
    this.fiveByFive.move(4, 3, 4, 1);
    this.fiveByFive.move(4, 0, 4, 2);
    this.fiveByFive.move(4, 2, 2, 2);
    this.fiveByFive.move(1, 1, 3, 3);
    this.fiveByFive.move(4, 4, 2, 2);
    this.fiveByFive.move(2, 2, 2, 0);

    assertEquals(false, this.fiveByFive.isGameOver());

    this.fiveByFive.move(2, 0, 0, 0);

    assertEquals(true, this.fiveByFive.isGameOver());

  }

  @Test
  public void getScoreTest() {

    assertEquals(14, this.fiveByFive.getScore());

    this.fiveByFive.move(2, 0, 0, 0);

    assertEquals(13, this.fiveByFive.getScore());

    this.fiveByFive.move(2, 2, 2, 0);
    this.fiveByFive.move(0, 0, 2, 2);
    this.fiveByFive.move(3, 0, 1, 0);
    this.fiveByFive.move(3, 3, 1, 1);
    this.fiveByFive.move(4, 1, 2, 1);
    this.fiveByFive.move(4, 3, 4, 1);
    this.fiveByFive.move(4, 0, 4, 2);
    this.fiveByFive.move(4, 2, 2, 2);
    this.fiveByFive.move(1, 1, 3, 3);
    this.fiveByFive.move(4, 4, 2, 2);
    this.fiveByFive.move(2, 2, 2, 0);

    assertEquals(2, this.fiveByFive.getScore());

    this.fiveByFive.move(2, 0, 0, 0);

    assertEquals(1, this.fiveByFive.getScore());

  }

}