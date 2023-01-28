import org.junit.Test;

import java.io.StringWriter;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@code TriangleSolitiareTextView} and its methods.
 */
public class TriangleSolitaireTextViewTest extends AbstractSolitaireTextViewTest {

  @Override
  protected MarbleSolitaireView createThreeByThreeView(Appendable output) {
    MarbleSolitaireModel model = new TriangleSolitaireModel();
    return new TriangleSolitaireTextView(model, output);
  }

  @Override
  protected MarbleSolitaireView createThreeByThreeViewOneArg() {
    return new TriangleSolitaireTextView(this.createThreeByThreeModel());
  }

  @Override
  protected MarbleSolitaireView createBadThreeByThreeView() {
    MarbleSolitaireModel model = new TriangleSolitaireModel();
    Appendable output = new BadAppendable();
    return new TriangleSolitaireTextView(model, output);
  }

  @Override
  protected MarbleSolitaireView createWithNullModelOneArgView() {
    return new TriangleSolitaireTextView(null);
  }

  @Override
  protected MarbleSolitaireView createWithNullModelTwoArgView() {
    return new TriangleSolitaireTextView(null, new StringWriter());
  }

  @Override
  protected MarbleSolitaireView createWithNullAppendableTwoArgView() {
    return new TriangleSolitaireTextView(this.createThreeByThreeModel(), null);
  }

  @Override
  protected MarbleSolitaireModel createThreeByThreeModel() {
    return new TriangleSolitaireModel();
  }

  @Test
  public void toStringTest() {
    Appendable output = new StringWriter();
    MarbleSolitaireModel model = new TriangleSolitaireModel();
    MarbleSolitaireView view = new TriangleSolitaireTextView(model, output);
    assertEquals(
            "    _\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O", view.toString());

    model.move(2, 0, 0, 0);

    assertEquals(
            "    O\n" +
                    "   _ O\n" +
                    "  _ O O\n" +
                    " O O O O\n" +
                    "O O O O O", view.toString());

    Appendable output2 = new StringWriter();
    MarbleSolitaireModel model2 = new TriangleSolitaireModel(7, 3, 3);
    MarbleSolitaireView view2 = new TriangleSolitaireTextView(model2, output2);

    assertEquals(
            "      O\n" +
                    "     O O\n" +
                    "    O O O\n" +
                    "   O O O _\n" +
                    "  O O O O O\n" +
                    " O O O O O O\n" +
                    "O O O O O O O", view2.toString());

    model2.move(1, 1, 3, 3);

    assertEquals(
            "      O\n" +
                    "     O _\n" +
                    "    O O _\n" +
                    "   O O O O\n" +
                    "  O O O O O\n" +
                    " O O O O O O\n" +
                    "O O O O O O O", view2.toString());

    Appendable output3 = new StringWriter();
    MarbleSolitaireModel model3 = new TriangleSolitaireModel(2, 0, 0);
    MarbleSolitaireView view3 = new TriangleSolitaireTextView(model3, output3);


    assertEquals(
            " _\n" +
                    "O O", view3.toString());
  }


}
