import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests the textual view of solitaire models.
 */
public abstract class AbstractSolitaireTextViewTest {

  protected abstract MarbleSolitaireView createThreeByThreeView(Appendable output);

  protected abstract MarbleSolitaireView createThreeByThreeViewOneArg();

  protected abstract MarbleSolitaireView createBadThreeByThreeView();

  protected abstract MarbleSolitaireView createWithNullModelOneArgView();

  protected abstract MarbleSolitaireView createWithNullModelTwoArgView();

  protected abstract MarbleSolitaireView createWithNullAppendableTwoArgView();

  protected abstract MarbleSolitaireModel createThreeByThreeModel();


  @Test
  public void constructorTest() {

    // 1 argument constructor throws error when given a null state
    try {
      this.createWithNullModelOneArgView();
      Assert.fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    // 1 argument constructor does not throw error when given a valid model
    try {
      this.createThreeByThreeViewOneArg();
    } catch (IllegalArgumentException e) {
      Assert.fail("Should not have thrown an IllegalArgumentException");
    }


    // 2 argument constructor throws an error when given a null model
    try {
      this.createWithNullModelTwoArgView();
      Assert.fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    // 2 argument constructor throws an error when given a null appendable
    try {
      this.createWithNullAppendableTwoArgView();
      Assert.fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    // 2 argument constructor does not throw an error when given valid arguments
    try {
      this.createThreeByThreeView(new StringWriter());
    } catch (IllegalArgumentException e) {
      Assert.fail("Should not have thrown an IllegalArgumentException");
    }

  }


  @Test
  public void renderMessageTest() {

    // throws IO exception given an incorrect appendable
    try {
      MarbleSolitaireView error = this.createBadThreeByThreeView();
      error.renderMessage("This should not work.");
      fail("Should have thrown an IOException.");
    } catch (IOException e) {
      // do nothing
    }

    // renderMessage does not throw an error when used correctly
    Appendable output = new StringWriter();
    try {
      this.createThreeByThreeView(output).renderMessage("This should work.");
    } catch (IOException e) {
      Assert.fail("Should not have thrown an exception");
    }

    // renderMessage renders the message correctly
    assertEquals("This should work.", output.toString());

    StringWriter output2 = new StringWriter();
    MarbleSolitaireView fiveModel = this.createThreeByThreeView(output2);

    // renderMessage does not throw an error when used correctly
    try {
      fiveModel.renderMessage("1 more string with 3 numbers, many letters, and  3 symbols.");
    } catch (IOException e) {
      Assert.fail("Should not have thrown an exception");
    }

    // renderMessage renders the message correctly
    assertEquals("1 more string with 3 numbers, many letters, and  3 symbols.",
            output2.toString());

  }
}
