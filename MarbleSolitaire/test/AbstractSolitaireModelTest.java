import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


/**
 * Tests constructing solitaire models and running their methods.
 */
public abstract class AbstractSolitaireModelTest {

  protected abstract MarbleSolitaireModel createThreeThickness();

  protected abstract MarbleSolitaireModel createFiveThickness();

  protected abstract MarbleSolitaireModel createSevenThickness();


  @Test
  public void moveExceptionsTest() {

    // moving to the same place
    try {
      this.createThreeThickness().move(5, 3, 5, 3);
      fail("Moving to the same place should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Must move a marble that is on the board to an empty slot " +
              "that is on the board.", e.getMessage());
    }

    // moving off the board
    try {
      this.createThreeThickness().move(3, 6, 3, 8);
      fail("Moving off the board should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Must move a marble that is on the board to an empty slot " +
              "that is on the board.", e.getMessage());
    }

    // moving from off the board
    try {
      this.createThreeThickness().move(3, 5, 3, 3);
      this.createThreeThickness().move(3, 7, 3, 5);
      fail("Moving from off the board should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Must move a marble that is on the board to an empty slot " +
              "that is on the board.", e.getMessage());
    }
  }

  @Test
  public void moveDiagonallyTwoSpacesAwayTest() {

    try {
      this.createThreeThickness().move(3, 5, 3, 3);
      this.createThreeThickness().move(5, 3, 3, 5);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Must move a marble that is on the board to an empty slot " +
              "that is on the board.", e.getMessage());
    }
  }

  @Test
  public void moveDiagonallyRandomlyTest() {

    try {
      this.createThreeThickness().move(3, 5, 3, 3);
      this.createThreeThickness().move(6, 2, 3, 5);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Must move a marble that is on the board to an empty slot " +
              "that is on the board.", e.getMessage());
    }
  }


  @Test
  public void validMoveLeftTest() {
    MarbleSolitaireModel valid = this.createThreeThickness();
    assertEquals(valid.getSlotAt(3, 5), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(valid.getSlotAt(3, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(valid.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);

    valid.move(3, 5, 3, 3);

    assertEquals(valid.getSlotAt(3, 5), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(valid.getSlotAt(3, 4), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(valid.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Marble);

  }

  @Test
  public void validMoveRightTest() {
    MarbleSolitaireModel valid = this.createThreeThickness();
    assertEquals(valid.getSlotAt(3, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(valid.getSlotAt(3, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(valid.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);

    valid.move(3, 1, 3, 3);

    assertEquals(valid.getSlotAt(3, 1), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(valid.getSlotAt(3, 2), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(valid.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Marble);

  }

  @Test
  public void validMoveUpTest() {
    MarbleSolitaireModel valid = this.createThreeThickness();
    assertEquals(valid.getSlotAt(5, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(valid.getSlotAt(4, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(valid.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);

    valid.move(5, 3, 3, 3);

    assertEquals(valid.getSlotAt(5, 3), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(valid.getSlotAt(4, 3), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(valid.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Marble);

  }

  @Test
  public void validMoveDownTest() {
    MarbleSolitaireModel valid = this.createThreeThickness();
    assertEquals(valid.getSlotAt(1, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(valid.getSlotAt(2, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(valid.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);

    valid.move(1, 3, 3, 3);

    assertEquals(valid.getSlotAt(1, 3), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(valid.getSlotAt(2, 3), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(valid.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Marble);

  }

  @Test
  public void moveMarbleMarbleMarbleTest() {
    try {
      this.createThreeThickness().move(2, 2, 4, 2);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Must move a marble that is on the board to an empty slot " +
              "that is on the board.", e.getMessage());
    }
  }

  @Test
  public void moveMarbleMarbleInvalidTest() {
    try {
      MarbleSolitaireModel invalid = this.createThreeThickness();
      invalid.move(0, 3, 0, 1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Must move a marble that is on the board to an empty slot " +
              "that is on the board.", e.getMessage());
    }
  }

  @Test
  public void moveMarbleEmptyMarbleTest() {
    try {
      this.createThreeThickness().move(3, 2, 3, 4);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Must move a marble that is on the board to an empty slot " +
              "that is on the board.", e.getMessage());
    }
  }

  @Test
  public void moveMarbleEmptyInvalidTest() {
    try {
      MarbleSolitaireModel invalid = this.createThreeThickness();
      invalid.move(3, 5, 3, 3);
      invalid.move(1, 4, 3, 4);
      invalid.move(2, 6, 2, 4);
      invalid.move(3, 6, 1, 6);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Must move a marble that is on the board to an empty slot " +
              "that is on the board.", e.getMessage());
    }
  }

  @Test
  public void moveMarbleEmptyEmptyTest() {
    try {
      this.createThreeThickness().move(5, 3, 3, 3);
      this.createThreeThickness().move(6, 3, 4, 3);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Must move a marble that is on the board to an empty slot " +
              "that is on the board.", e.getMessage());
    }
  }

  @Test
  public void moveEmptyMarbleMarbleTest() {

    try {
      this.createThreeThickness().move(3, 3, 3, 5);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Must move a marble that is on the board to an empty slot " +
              "that is on the board.", e.getMessage());
    }
  }

  @Test
  public void moveEmptyMarbleEmptyTest() {

    try {
      this.createThreeThickness().move(1, 3, 3, 3);
      this.createThreeThickness().move(4, 3, 2, 3);
      this.createThreeThickness().move(3, 3, 1, 3);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Must move a marble that is on the board to an empty slot " +
              "that is on the board.", e.getMessage());
    }
  }

  @Test
  public void moveEmptyMarbleInvalidTest() {

    try {
      this.createThreeThickness().move(3, 5, 3, 3);
      this.createThreeThickness().move(3, 5, 3, 7);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Must move a marble that is on the board to an empty slot " +
              "that is on the board.", e.getMessage());
    }
  }

  @Test
  public void moveEmptyEmptyMarbleTest() {

    try {
      this.createThreeThickness().move(3, 5, 3, 3);
      this.createThreeThickness().move(3, 3, 3, 5);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Must move a marble that is on the board to an empty slot " +
              "that is on the board.", e.getMessage());
    }
  }

  @Test
  public void moveEmptyEmptyEmptyTest() {

    try {
      this.createThreeThickness().move(3, 5, 3, 3);
      this.createThreeThickness().move(1, 4, 3, 4);
      this.createThreeThickness().move(3, 3, 3, 5);
      this.createThreeThickness().move(1, 4, 3, 4);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Must move a marble that is on the board to an empty slot " +
              "that is on the board.", e.getMessage());
    }
  }

  @Test
  public void moveEmptyEmptyInvalidTest() {

    try {
      this.createThreeThickness().move(5, 3, 3, 3);
      this.createThreeThickness().move(4, 5, 4, 3);
      this.createThreeThickness().move(3, 3, 5, 3);
      this.createThreeThickness().move(6, 3, 4, 3);
      this.createThreeThickness().move(5, 3, 7, 3);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Must move a marble that is on the board to an empty slot " +
              "that is on the board.", e.getMessage());
    }
  }


  @Test
  public void getBoardSize() {

    MarbleSolitaireModel valid = this.createThreeThickness();

    assertEquals(valid.getBoardSize(), 7);
    assertEquals(this.createFiveThickness().getBoardSize(), 13);
    assertEquals(this.createSevenThickness().getBoardSize(), 19);

    valid.move(3, 5, 3, 3);

    assertEquals(valid.getBoardSize(), 7);
  }


  @Test
  public void getSlotAtTest() {

    try {
      this.createThreeThickness().getSlotAt(-1, 2);
      fail("Should throw an Illegal Argument Exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Cannot get slot out of bounds", e.getMessage());
    }

    try {
      this.createThreeThickness().getSlotAt(2, -1);
      fail("Should throw an Illegal Argument Exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Cannot get slot out of bounds", e.getMessage());
    }

    try {
      this.createThreeThickness().getSlotAt(7, 2);
      fail("Should throw an Illegal Argument Exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Cannot get slot out of bounds", e.getMessage());
    }

    try {
      this.createThreeThickness().getSlotAt(2, 7);
      fail("Should throw an Illegal Argument Exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Cannot get slot out of bounds", e.getMessage());
    }

    try {
      this.createThreeThickness().getSlotAt(10, 2);
      fail("Should throw an Illegal Argument Exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Cannot get slot out of bounds", e.getMessage());
    }

    try {
      this.createThreeThickness().getSlotAt(2, 10);
      fail("Should throw an Illegal Argument Exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Cannot get slot out of bounds", e.getMessage());
    }

    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
            this.createThreeThickness().getSlotAt(0, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            this.createThreeThickness().getSlotAt(0, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            this.createThreeThickness().getSlotAt(3, 3));


    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
            this.createFiveThickness().getSlotAt(2, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            this.createFiveThickness().getSlotAt(0, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            this.createFiveThickness().getSlotAt(6, 6));


    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
            this.createSevenThickness().getSlotAt(14, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            this.createSevenThickness().getSlotAt(7, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            this.createSevenThickness().getSlotAt(9, 9));
  }

  @Test
  public void isGameOverFalseTest() {
    assertEquals(false, this.createThreeThickness().isGameOver());
    assertEquals(false, this.createFiveThickness().isGameOver());
    assertEquals(false, this.createSevenThickness().isGameOver());

    MarbleSolitaireModel valid = this.createThreeThickness();

    valid.move(3, 5, 3, 3);
    valid.move(1, 4, 3, 4);

    assertEquals(false, valid.isGameOver());
  }

  @Test
  public void isGameOverLostTrue() {

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


    assertEquals(false, valid.isGameOver());

    valid.move(2, 3, 0, 3);

    assertEquals(true, valid.isGameOver());


  }

}