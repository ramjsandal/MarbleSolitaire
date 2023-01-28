import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests MarbleSolitaireTextView and its methods.
 */
public class MarbleSolitaireTextViewTest extends AbstractSolitaireTextViewTest {

  MarbleSolitaireModel three;
  MarbleSolitaireModel five;
  MarbleSolitaireModel seven;

  MarbleSolitaireTextView threeView;
  MarbleSolitaireTextView fiveView;
  MarbleSolitaireTextView sevenView;

  Appendable renderBoardOutput;

  MarbleSolitaireModel renderBoardThree;

  MarbleSolitaireTextView renderBoardTextView;

  MarbleSolitaireModel threeEuropean;
  MarbleSolitaireModel fiveEuropean;
  MarbleSolitaireModel sevenEuropean;

  MarbleSolitaireTextView threeViewEuropean;
  MarbleSolitaireTextView fiveViewEuropean;
  MarbleSolitaireTextView sevenViewEuropean;

  MarbleSolitaireTextView renderBoardTextViewEuropean;

  MarbleSolitaireModel renderBoardThreeEuropean;

  @Override
  protected MarbleSolitaireView createThreeByThreeView(Appendable output) {
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    return new MarbleSolitaireTextView(model, output);
  }

  @Override
  protected MarbleSolitaireView createThreeByThreeViewOneArg() {
    return new MarbleSolitaireTextView(this.createThreeByThreeModel());
  }

  @Override
  protected MarbleSolitaireView createBadThreeByThreeView() {
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    return new MarbleSolitaireTextView(model, new BadAppendable());
  }

  @Override
  protected MarbleSolitaireView createWithNullModelOneArgView() {
    return new MarbleSolitaireTextView(null);
  }

  @Override
  protected MarbleSolitaireView createWithNullModelTwoArgView() {
    return new MarbleSolitaireTextView(null, new StringWriter());
  }

  @Override
  protected MarbleSolitaireView createWithNullAppendableTwoArgView() {
    return new MarbleSolitaireTextView(this.createThreeByThreeModel(), null);
  }

  @Override
  protected MarbleSolitaireModel createThreeByThreeModel() {
    return new EnglishSolitaireModel();
  }


  @Before
  public void init() {
    this.three = new EnglishSolitaireModel();
    this.threeView = new MarbleSolitaireTextView(this.three);
    this.five = new EnglishSolitaireModel(5);
    this.fiveView = new MarbleSolitaireTextView(this.five);
    this.seven = new EnglishSolitaireModel(7);
    this.sevenView = new MarbleSolitaireTextView(this.seven);
    this.renderBoardOutput = new StringWriter();
    this.renderBoardThree = new EnglishSolitaireModel();
    this.renderBoardThreeEuropean = new EuropeanSolitaireModel();
    this.renderBoardTextView =
            new MarbleSolitaireTextView(this.renderBoardThree, this.renderBoardOutput);
    this.renderBoardTextViewEuropean =
            new MarbleSolitaireTextView(this.renderBoardThreeEuropean, this.renderBoardOutput);


    this.threeEuropean = new EuropeanSolitaireModel();
    this.threeViewEuropean = new MarbleSolitaireTextView(this.threeEuropean);
    this.fiveEuropean = new EuropeanSolitaireModel(5);
    this.fiveViewEuropean = new MarbleSolitaireTextView(this.fiveEuropean);
    this.sevenEuropean = new EuropeanSolitaireModel(7);
    this.sevenViewEuropean = new MarbleSolitaireTextView(this.sevenEuropean);

  }

  @Test
  public void constructorTestEuropean() {
    try {
      MarbleSolitaireTextView ex = new MarbleSolitaireTextView(this.threeEuropean);
      assertEquals(threeViewEuropean.toString(), ex.toString());
    } catch (IllegalArgumentException e) {
      Assert.fail("Should not have thrown an IllegalArgumentException");
    }
  }

  @Test
  public void testToString() {
    assertEquals(
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O"


            , threeView.toString());
    three.move(3, 5, 3, 3);

    assertEquals(
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O _ _ O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O", threeView.toString());

    assertEquals(
            "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O _ O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O", sevenView.toString());

    assertEquals(
            "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O _ O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O", fiveView.toString());
  }


  @Test
  public void renderBoardTest() {

    // throws IO exception given an incorrect appendable
    try {
      MarbleSolitaireTextView error = new MarbleSolitaireTextView(five, new FileWriter("test"));
      error.renderBoard();
      fail("Should have thrown an IOException.");
    } catch (IOException e) {
      // do nothing
    }

    // renderBoard does not throw an error when used correctly
    try {
      this.renderBoardTextView.renderBoard();
    } catch (IOException e) {
      Assert.fail("Should not have thrown an exception");
    }

    // renderBoard prints the board correctly
    assertEquals(
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O", this.renderBoardOutput.toString());

    MarbleSolitaireTextView fiveModel = new MarbleSolitaireTextView(this.five, new StringWriter());

    // renderBoard does not throw an error when used correctly
    try {
      fiveModel.renderBoard();
    } catch (IOException e) {
      Assert.fail("Should not have thrown an exception");
    }

    // renderBoard prints the board correctly
    assertEquals(
            "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O _ O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O", fiveModel.toString());


  }


  @Test
  public void testEuropeanToString() {
    assertEquals(
            "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O"


            , threeViewEuropean.toString());
    threeEuropean.move(3, 5, 3, 3);

    assertEquals(
            "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O _ _ O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O", threeViewEuropean.toString());

    assertEquals(
            "            O O O O O O O\n" +
                    "          O O O O O O O O O\n" +
                    "        O O O O O O O O O O O\n" +
                    "      O O O O O O O O O O O O O\n" +
                    "    O O O O O O O O O O O O O O O\n" +
                    "  O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O _ O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "  O O O O O O O O O O O O O O O O O\n" +
                    "    O O O O O O O O O O O O O O O\n" +
                    "      O O O O O O O O O O O O O\n" +
                    "        O O O O O O O O O O O\n" +
                    "          O O O O O O O O O\n" +
                    "            O O O O O O O", sevenViewEuropean.toString());

    assertEquals(
            "        O O O O O\n" +
                    "      O O O O O O O\n" +
                    "    O O O O O O O O O\n" +
                    "  O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O _ O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "  O O O O O O O O O O O\n" +
                    "    O O O O O O O O O\n" +
                    "      O O O O O O O\n" +
                    "        O O O O O", fiveViewEuropean.toString());
  }

  @Test
  public void renderBoardEuropeanTest() {

    // throws IO exception given an incorrect appendable
    try {
      MarbleSolitaireTextView error = new MarbleSolitaireTextView(fiveEuropean,
              new FileWriter("test"));
      error.renderBoard();
      fail("Should have thrown an IOException.");
    } catch (IOException e) {
      // do nothing
    }

    // renderBoard does not throw an error when used correctly
    try {
      this.renderBoardTextViewEuropean.renderBoard();
    } catch (IOException e) {
      Assert.fail("Should not have thrown an exception");
    }

    // renderBoard prints the board correctly
    assertEquals(
            "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O", this.renderBoardOutput.toString());

    MarbleSolitaireTextView fiveModel = new MarbleSolitaireTextView(this.fiveEuropean,
            new StringWriter());

    // renderBoard does not throw an error when used correctly
    try {
      fiveModel.renderBoard();
    } catch (IOException e) {
      Assert.fail("Should not have thrown an exception");
    }

    // renderBoard prints the board correctly
    assertEquals(
            "        O O O O O\n" +
                    "      O O O O O O O\n" +
                    "    O O O O O O O O O\n" +
                    "  O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O _ O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "  O O O O O O O O O O O\n" +
                    "    O O O O O O O O O\n" +
                    "      O O O O O O O\n" +
                    "        O O O O O", fiveModel.toString());


  }


}