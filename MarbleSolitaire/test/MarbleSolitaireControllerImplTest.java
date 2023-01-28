import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.StringReader;
import java.io.StringWriter;

import cs3500.marblesolitaire.model.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.model.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static org.junit.Assert.assertEquals;

/**
 * Tests Marble Solitaire Controller.
 */
public class MarbleSolitaireControllerImplTest {

  MarbleSolitaireModel engModel;

  MarbleSolitaireModel euModel;

  MarbleSolitaireModel gameIsOver;

  MarbleSolitaireModel gameIsOverEuropean;

  Readable engInput;

  Readable quitOne;

  Readable quitTwo;

  Appendable engOutput;

  MarbleSolitaireView engView;

  MarbleSolitaireView euView;

  MarbleSolitaireView gameOverView;

  MarbleSolitaireView gameOverViewEuropean;

  Readable badReadable;

  Appendable badAppendable;


  @Before
  public void init() {

    this.engModel = new EnglishSolitaireModel();
    this.euModel = new EuropeanSolitaireModel(0, 2);

    this.gameIsOver = new EnglishSolitaireModel();
    this.gameIsOver.move(5, 3, 3, 3);
    this.gameIsOver.move(4, 5, 4, 3);
    this.gameIsOver.move(6, 4, 4, 4);
    this.gameIsOver.move(6, 2, 6, 4);
    this.gameIsOver.move(3, 4, 5, 4);
    this.gameIsOver.move(6, 4, 4, 4);
    this.gameIsOver.move(1, 4, 3, 4);
    this.gameIsOver.move(2, 6, 2, 4);
    this.gameIsOver.move(4, 6, 2, 6);
    this.gameIsOver.move(2, 3, 2, 5);
    this.gameIsOver.move(2, 6, 2, 4);
    this.gameIsOver.move(2, 1, 2, 3);
    this.gameIsOver.move(0, 2, 2, 2);
    this.gameIsOver.move(0, 4, 0, 2);
    this.gameIsOver.move(3, 2, 1, 2);
    this.gameIsOver.move(0, 2, 2, 2);
    this.gameIsOver.move(5, 2, 3, 2);
    this.gameIsOver.move(4, 0, 4, 2);
    this.gameIsOver.move(2, 0, 4, 0);
    this.gameIsOver.move(4, 3, 4, 1);
    this.gameIsOver.move(4, 0, 4, 2);
    this.gameIsOver.move(2, 3, 2, 1);
    this.gameIsOver.move(2, 1, 4, 1);
    this.gameIsOver.move(4, 1, 4, 3);
    this.gameIsOver.move(4, 3, 4, 5);
    this.gameIsOver.move(4, 5, 2, 5);
    this.gameIsOver.move(2, 5, 2, 3);
    this.gameIsOver.move(3, 3, 3, 5);
    this.gameIsOver.move(1, 3, 3, 3);
    this.gameIsOver.move(3, 2, 3, 4);
    this.gameIsOver.move(3, 5, 3, 3);

    this.gameIsOverEuropean = new EuropeanSolitaireModel(0, 2);
    this.gameIsOverEuropean.move(0, 4, 0, 2);
    this.gameIsOverEuropean.move(2, 3, 0, 3);
    this.gameIsOverEuropean.move(1, 5, 1, 3);
    this.gameIsOverEuropean.move(0, 3, 2, 3);
    this.gameIsOverEuropean.move(3, 3, 1, 3);
    this.gameIsOverEuropean.move(5, 3, 3, 3);
    this.gameIsOverEuropean.move(5, 1, 5, 3);
    this.gameIsOverEuropean.move(6, 3, 4, 3);
    this.gameIsOverEuropean.move(1, 2, 1, 4);
    this.gameIsOverEuropean.move(3, 2, 1, 2);
    this.gameIsOverEuropean.move(3, 4, 3, 2);
    this.gameIsOverEuropean.move(5, 4, 3, 4);
    this.gameIsOverEuropean.move(0, 2, 2, 2);
    this.gameIsOverEuropean.move(3, 2, 1, 2);
    this.gameIsOverEuropean.move(1, 1, 1, 3);
    this.gameIsOverEuropean.move(1, 4, 1, 2);
    this.gameIsOverEuropean.move(3, 4, 1, 4);
    this.gameIsOverEuropean.move(2, 0, 2, 2);
    this.gameIsOverEuropean.move(3, 0, 3, 2);
    this.gameIsOverEuropean.move(2, 6, 2, 4);
    this.gameIsOverEuropean.move(3, 6, 3, 4);
    this.gameIsOverEuropean.move(4, 6, 4, 4);
    this.gameIsOverEuropean.move(3, 2, 5, 2);
    this.gameIsOverEuropean.move(1, 2, 3, 2);
    this.gameIsOverEuropean.move(6, 2, 4, 2);
    this.gameIsOverEuropean.move(3, 2, 5, 2);
    this.gameIsOverEuropean.move(3, 4, 5, 4);
    this.gameIsOverEuropean.move(1, 4, 3, 4);
    this.gameIsOverEuropean.move(6, 4, 4, 4);
    this.gameIsOverEuropean.move(3, 4, 5, 4);
    this.gameIsOverEuropean.move(5, 5, 5, 3);
    this.gameIsOverEuropean.move(4, 0, 4, 2);
    this.gameIsOverEuropean.move(4, 2, 6, 2);
    this.gameIsOverEuropean.move(4, 3, 6, 3);
    this.gameIsOverEuropean.move(6, 2, 6, 4);

    this.engInput = new StringReader("");

    this.quitOne = new StringReader("q");

    this.quitTwo = new StringReader("Q");

    this.engOutput = new StringWriter();

    this.engView = new MarbleSolitaireTextView(this.engModel, this.engOutput);

    this.euView = new MarbleSolitaireTextView(this.euModel, this.engOutput);

    this.gameOverView = new MarbleSolitaireTextView(this.gameIsOver, this.engOutput);

    this.gameOverViewEuropean = new MarbleSolitaireTextView(this.gameIsOverEuropean,
            this.engOutput);

    this.badReadable = new BadReadable();

    this.badAppendable = new BadAppendable();

  }

  @Test
  public void controllerConstructorTest() {

    // initializing a controller with a null model
    try {
      new MarbleSolitaireControllerImpl(null, this.engView, this.engInput);
      Assert.fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    // initializing a controller with a null readable
    try {
      new MarbleSolitaireControllerImpl(this.engModel, this.engView, null);
      Assert.fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    // initializing a controller with a null view
    try {
      new MarbleSolitaireControllerImpl(this.engModel, null, this.engInput);
      Assert.fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    // initializing a controller with a null model and readable
    try {
      new MarbleSolitaireControllerImpl(null, this.engView, null);
      Assert.fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    // initializing a controller with a null model and view
    try {
      new MarbleSolitaireControllerImpl(null, null, this.engInput);
      Assert.fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    // initializing a controller with a null readable and view
    try {
      new MarbleSolitaireControllerImpl(this.engModel, null, null);
      Assert.fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    // initializing a controller with a null model, readable, and view
    try {
      new MarbleSolitaireControllerImpl(null, null, null);
      Assert.fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
  }

  @Test
  public void playGameGameOverFullGameTest() {
    Readable moveToEndGame = new StringReader(
            "6 4 4 4 5 6 5 4 7 5 5 5 7 3 7 5 4 5 6 5 7 5 5 5 2 5 4 5 3 7 3 5 5 7 3 7 3 4 3 6 " +
                    "3 7 3 5 3 2 3 4 1 3 3 3 1 5 1 3 4 3 2 3 1 3 3 3 6 3 4 3 5 1 5 3 3 1 5 1 " +
                    "5 4 5 2 5 1 5 3 3 4 3 2 3 2 5 2 5 2 5 4 5 4 5 6 5 6 3 6 3 6 3 4 4 4 4 6 " +
                    "2 4 4 4 4 3 4 5 4 6 4 4 q");
    MarbleSolitaireControllerImpl impl = new MarbleSolitaireControllerImpl(this.engModel,
            this.engView, moveToEndGame);

    impl.playGame();


    String[] message = engOutput.toString().split("\n");

    //240 - 265
    assertEquals("    _ _ _", message[240]);
    assertEquals("    _ _ _", message[241]);
    assertEquals("_ _ _ _ _ _ _", message[242]);
    assertEquals("_ _ _ _ O O _", message[243]);
    assertEquals("_ _ _ _ _ _ _", message[244]);
    assertEquals("    _ _ _", message[245]);
    assertEquals("    _ _ _", message[246]);
    assertEquals("Score: 2", message[247]);
    assertEquals("    _ _ _", message[248]);
    assertEquals("    _ _ _", message[249]);
    assertEquals("_ _ _ _ _ _ _", message[250]);
    assertEquals("_ _ _ O _ _ _", message[251]);
    assertEquals("_ _ _ _ _ _ _", message[252]);
    assertEquals("    _ _ _", message[253]);
    assertEquals("    _ _ _", message[254]);
    assertEquals("Score: 1", message[255]);
    assertEquals("Game over!", message[256]);
    assertEquals("    _ _ _", message[257]);
    assertEquals("    _ _ _", message[258]);
    assertEquals("_ _ _ _ _ _ _", message[259]);
    assertEquals("_ _ _ O _ _ _", message[260]);
    assertEquals("_ _ _ _ _ _ _", message[261]);
    assertEquals("    _ _ _", message[262]);
    assertEquals("    _ _ _", message[263]);
    assertEquals("Score: 1", message[264]);

  }

  @Test
  public void playGameGameOverFullGameEuropeanTest() {
    Readable moveToEndGame = new StringReader("1 5 1 3 3 4 1 4 2 6 2 4 1 4 3 4 4 4 2 4 6 4 4 4 " +
            "6 2 6 4 7 4 5 4 2 3 2 5 4 3 2 3 4 5 4 3 6 5 4 5 1 3 3 3 4 3 2 3 2 2 2 4 2 5 2 3 " +
            "4 5 2 5 3 1 3 3 4 1 4 3 3 7 3 5 4 7 4 5 5 7 5 5 4 3 6 3 2 3 4 3 7 3 5 3 4 3 6 3 " +
            "4 5 6 5 2 5 4 5 7 5 5 5 4 5 6 5 6 6 6 4 5 1 5 3 5 3 7 3 5 4 7 4 7 3 7 5 q");

    MarbleSolitaireControllerImpl impl = new MarbleSolitaireControllerImpl(this.euModel,
            this.euView, moveToEndGame);

    impl.playGame();


    String[] message = engOutput.toString().split("\n");

    assertEquals("    _ _ _", message[272]);
    assertEquals("  _ _ _ _ _", message[273]);
    assertEquals("_ _ _ _ _ _ _", message[274]);
    assertEquals("_ _ _ _ _ _ _", message[275]);
    assertEquals("_ _ _ _ _ _ _", message[276]);
    assertEquals("  _ _ _ _ _", message[277]);
    assertEquals("    O O _", message[278]);
    assertEquals("Score: 2", message[279]);
    assertEquals("    _ _ _", message[280]);
    assertEquals("  _ _ _ _ _", message[281]);
    assertEquals("_ _ _ _ _ _ _", message[282]);
    assertEquals("_ _ _ _ _ _ _", message[283]);
    assertEquals("_ _ _ _ _ _ _", message[284]);
    assertEquals("  _ _ _ _ _", message[285]);
    assertEquals("    _ _ O", message[286]);
    assertEquals("Score: 1", message[287]);
    assertEquals("Game over!", message[288]);
    assertEquals("    _ _ _", message[289]);
    assertEquals("  _ _ _ _ _", message[290]);
    assertEquals("_ _ _ _ _ _ _", message[291]);
    assertEquals("_ _ _ _ _ _ _", message[292]);
    assertEquals("_ _ _ _ _ _ _", message[293]);
    assertEquals("  _ _ _ _ _", message[294]);
    assertEquals("    _ _ O", message[295]);
    assertEquals("Score: 1", message[296]);

  }


  @Test
  public void gameOverAtStartTryIllegalMoveControllerTest() {
    // the game is already over, so this illegal move should not throw an error, since the game
    // ends before it can go
    Readable gameOverAtStart = new StringReader("1 3 3 3");
    MarbleSolitaireController gameOver = new MarbleSolitaireControllerImpl(this.gameIsOver,
            this.gameOverView, gameOverAtStart);
    gameOver.playGame();

    String[] message = this.engOutput.toString().split("\n");

    assertEquals("Game over!\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 1\n", this.engOutput.toString());

    // check that each line of the game over message is the same
    assertEquals("Game over!", message[0]);
    assertEquals("    _ _ _", message[1]);
    assertEquals("    _ _ _", message[2]);
    assertEquals("_ _ _ _ _ _ _", message[3]);
    assertEquals("_ _ _ O _ _ _", message[4]);
    assertEquals("_ _ _ _ _ _ _", message[5]);
    assertEquals("    _ _ _", message[6]);
    assertEquals("    _ _ _", message[7]);
    assertEquals("Score: 1", message[8]);
  }

  @Test
  public void gameOverAtStartEuropeanTest() {
    // the game is already over, so this illegal move should not throw an error, since the game
    // ends before it can go
    Readable gameOverAtStart = new StringReader("1 3 3 3");
    MarbleSolitaireController gameOver = new MarbleSolitaireControllerImpl(this.gameIsOverEuropean,
            this.gameOverViewEuropean, gameOverAtStart);
    gameOver.playGame();

    String[] message = this.engOutput.toString().split("\n");

    assertEquals("Game over!\n" +
            "    _ _ _\n" +
            "  _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "  _ _ _ _ _\n" +
            "    _ _ O\n" +
            "Score: 1\n", this.engOutput.toString());

    // check that each line of the game over message is the same
    assertEquals("Game over!", message[0]);
    assertEquals("    _ _ _", message[1]);
    assertEquals("  _ _ _ _ _", message[2]);
    assertEquals("_ _ _ _ _ _ _", message[3]);
    assertEquals("_ _ _ _ _ _ _", message[4]);
    assertEquals("_ _ _ _ _ _ _", message[5]);
    assertEquals("  _ _ _ _ _", message[6]);
    assertEquals("    _ _ O", message[7]);
    assertEquals("Score: 1", message[8]);
  }

  @Test
  public void gameOverAtStartTryLowercaseQQuitControllerTest() {
    // the game is already over, so this quit should not bring up the quit message
    Readable gameOverAtStart = new StringReader("q");
    MarbleSolitaireController gameOver = new MarbleSolitaireControllerImpl(this.gameIsOver,
            this.gameOverView, gameOverAtStart);
    gameOver.playGame();

    String[] message = this.engOutput.toString().split("\n");

    assertEquals("Game over!\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 1\n", this.engOutput.toString());

    // check that each line of the game over message is the same
    assertEquals("Game over!", message[0]);
    assertEquals("    _ _ _", message[1]);
    assertEquals("    _ _ _", message[2]);
    assertEquals("_ _ _ _ _ _ _", message[3]);
    assertEquals("_ _ _ O _ _ _", message[4]);
    assertEquals("_ _ _ _ _ _ _", message[5]);
    assertEquals("    _ _ _", message[6]);
    assertEquals("    _ _ _", message[7]);
    assertEquals("Score: 1", message[8]);
  }

  @Test
  public void gameOverAtStartTryUppercaseQQuitControllerTest() {
    // the game is already over, so this quit should not bring up the quit message
    Readable gameOverAtStart = new StringReader("Q");
    MarbleSolitaireController gameOver = new MarbleSolitaireControllerImpl(this.gameIsOver,
            this.gameOverView, gameOverAtStart);
    gameOver.playGame();

    String[] message = this.engOutput.toString().split("\n");

    assertEquals("Game over!\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 1\n", this.engOutput.toString());

    // check that each line of the game over message is the same
    assertEquals("Game over!", message[0]);
    assertEquals("    _ _ _", message[1]);
    assertEquals("    _ _ _", message[2]);
    assertEquals("_ _ _ _ _ _ _", message[3]);
    assertEquals("_ _ _ O _ _ _", message[4]);
    assertEquals("_ _ _ _ _ _ _", message[5]);
    assertEquals("    _ _ _", message[6]);
    assertEquals("    _ _ _", message[7]);
    assertEquals("Score: 1", message[8]);
  }

  @Test
  public void gameOverAtStartTryInvalidStringControllerTest() {
    // the game is already over, so this invalid input should not bring up the error message
    Readable gameOverAtStart = new StringReader("ham");
    MarbleSolitaireController gameOver = new MarbleSolitaireControllerImpl(this.gameIsOver,
            this.gameOverView, gameOverAtStart);
    gameOver.playGame();

    String[] message = this.engOutput.toString().split("\n");

    assertEquals("Game over!\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 1\n", this.engOutput.toString());

    // check that each line of the game over message is the same
    assertEquals("Game over!", message[0]);
    assertEquals("    _ _ _", message[1]);
    assertEquals("    _ _ _", message[2]);
    assertEquals("_ _ _ _ _ _ _", message[3]);
    assertEquals("_ _ _ O _ _ _", message[4]);
    assertEquals("_ _ _ _ _ _ _", message[5]);
    assertEquals("    _ _ _", message[6]);
    assertEquals("    _ _ _", message[7]);
    assertEquals("Score: 1", message[8]);
  }

  @Test
  public void gameOverAtStartTryInvalidNumberControllerTest() {
    // the game is already over, so this invalid input should not bring up the error message
    Readable gameOverAtStart = new StringReader("-44");
    MarbleSolitaireController gameOver = new MarbleSolitaireControllerImpl(this.gameIsOver,
            this.gameOverView, gameOverAtStart);
    gameOver.playGame();

    String[] message = this.engOutput.toString().split("\n");

    assertEquals("Game over!\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 1\n", this.engOutput.toString());

    // check that each line of the game over message is the same
    assertEquals("Game over!", message[0]);
    assertEquals("    _ _ _", message[1]);
    assertEquals("    _ _ _", message[2]);
    assertEquals("_ _ _ _ _ _ _", message[3]);
    assertEquals("_ _ _ O _ _ _", message[4]);
    assertEquals("_ _ _ _ _ _ _", message[5]);
    assertEquals("    _ _ _", message[6]);
    assertEquals("    _ _ _", message[7]);
    assertEquals("Score: 1", message[8]);
  }

  @Test
  public void playGameLowercaseQTest() {

    MarbleSolitaireControllerImpl quit =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, this.quitOne);

    quit.playGame();
    String[] message = this.engOutput.toString().split("\n");


    // check that each line of the quit message is the same
    assertEquals("Game quit!", message[8]);
    assertEquals("State of game when quit:", message[9]);
    assertEquals("    O O O", message[10]);
    assertEquals("    O O O", message[11]);
    assertEquals("O O O O O O O", message[12]);
    assertEquals("O O O _ O O O", message[13]);
    assertEquals("O O O O O O O", message[14]);
    assertEquals("    O O O", message[15]);
    assertEquals("    O O O", message[16]);
    assertEquals("Score: 32", message[17]);

    // remove the opening message from the output, in order to check if the quit message is correct.
    String message2 = this.engOutput.toString().replaceFirst("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\nScore: 32\n", "");

    // checking if the quit message is correct, including indentation
    assertEquals("Game quit!\n" + "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", message2);

  }

  @Test
  public void playGameLowercaseQEuropeanTest() {

    MarbleSolitaireControllerImpl quit =
            new MarbleSolitaireControllerImpl(this.euModel, this.euView, this.quitOne);

    quit.playGame();
    String[] message = this.engOutput.toString().split("\n");


    // check that each line of the quit message is the same
    assertEquals("Game quit!", message[8]);
    assertEquals("State of game when quit:", message[9]);
    assertEquals("    _ O O", message[10]);
    assertEquals("  O O O O O", message[11]);
    assertEquals("O O O O O O O", message[12]);
    assertEquals("O O O O O O O", message[13]);
    assertEquals("O O O O O O O", message[14]);
    assertEquals("  O O O O O", message[15]);
    assertEquals("    O O O", message[16]);
    assertEquals("Score: 36", message[17]);

  }

  @Test
  public void playGameMultipleLowercaseQTest() {

    // should only return the quit message once
    Readable doubleQuit = new StringReader("q q");
    MarbleSolitaireControllerImpl quit =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, doubleQuit);

    quit.playGame();
    String[] message = this.engOutput.toString().split("\n");


    // check that each line of the quit message is the same
    assertEquals("Game quit!", message[8]);
    assertEquals("State of game when quit:", message[9]);
    assertEquals("    O O O", message[10]);
    assertEquals("    O O O", message[11]);
    assertEquals("O O O O O O O", message[12]);
    assertEquals("O O O _ O O O", message[13]);
    assertEquals("O O O O O O O", message[14]);
    assertEquals("    O O O", message[15]);
    assertEquals("    O O O", message[16]);
    assertEquals("Score: 32", message[17]);

    // remove the opening message from the output, in order to check if the quit message is correct.
    String message2 = this.engOutput.toString().replaceFirst("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\nScore: 32\n", "");

    // checking if the quit message is correct, including indentation
    assertEquals("Game quit!\n" + "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", message2);

  }

  @Test
  public void playGameLowercaseQQuitThenMoveTest() {
    // make sure that no move happens, and the game quits with the correct message
    Readable quitThenMove = new StringReader("q 2 4 4 4");
    MarbleSolitaireController quitAndThenMove =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, quitThenMove);

    quitAndThenMove.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that each line of the quit message is the same
    assertEquals("Game quit!", message[8]);
    assertEquals("State of game when quit:", message[9]);
    assertEquals("    O O O", message[10]);
    assertEquals("    O O O", message[11]);
    assertEquals("O O O O O O O", message[12]);
    assertEquals("O O O _ O O O", message[13]);
    assertEquals("O O O O O O O", message[14]);
    assertEquals("    O O O", message[15]);
    assertEquals("    O O O", message[16]);
    assertEquals("Score: 32", message[17]);

    // remove the opening message from the output, in order to check if the quit message is correct.
    String message2 = engOutput.toString().replaceFirst("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\nScore: 32\n", "");

    // checking if the quit message is correct, including indentation
    assertEquals("Game quit!\n" + "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", message2);

  }

  @Test
  public void playGameLowercaseQQuitThenMoveEuropeanTest() {
    // make sure that no move happens, and the game quits with the correct message
    Readable quitThenMove = new StringReader("q 2 4 4 4");
    MarbleSolitaireController quitAndThenMove =
            new MarbleSolitaireControllerImpl(this.euModel, this.euView, quitThenMove);

    quitAndThenMove.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that each line of the quit message is the same
    assertEquals("Game quit!", message[8]);
    assertEquals("State of game when quit:", message[9]);
    assertEquals("    _ O O", message[10]);
    assertEquals("  O O O O O", message[11]);
    assertEquals("O O O O O O O", message[12]);
    assertEquals("O O O O O O O", message[13]);
    assertEquals("O O O O O O O", message[14]);
    assertEquals("  O O O O O", message[15]);
    assertEquals("    O O O", message[16]);
    assertEquals("Score: 36", message[17]);

  }


  @Test
  public void playGameLowercaseQPartialMoveQuitTest() {
    // make sure that no move happens, and the game quits with the correct message
    Readable partialMoveQuit = new StringReader("2 q 4 4 4");
    MarbleSolitaireController partialMoveThenQuit =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, partialMoveQuit);

    partialMoveThenQuit.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that each line of the quit message is the same
    assertEquals("Game quit!", message[8]);
    assertEquals("State of game when quit:", message[9]);
    assertEquals("    O O O", message[10]);
    assertEquals("    O O O", message[11]);
    assertEquals("O O O O O O O", message[12]);
    assertEquals("O O O _ O O O", message[13]);
    assertEquals("O O O O O O O", message[14]);
    assertEquals("    O O O", message[15]);
    assertEquals("    O O O", message[16]);
    assertEquals("Score: 32", message[17]);

    // remove the opening message from the output, in order to check if the quit message is correct.
    String message2 = engOutput.toString().replaceFirst("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\nScore: 32\n", "");

    // checking if the quit message is correct, including indentation
    assertEquals("Game quit!\n" + "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", message2);

  }

  @Test
  public void playGameLowercaseQPartialMoveQuitEuropeanTest() {
    // make sure that no move happens, and the game quits with the correct message
    Readable quitThenMove = new StringReader("1 q 5 1 3");
    MarbleSolitaireController quitAndThenMove =
            new MarbleSolitaireControllerImpl(this.euModel, this.euView, quitThenMove);

    quitAndThenMove.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that each line of the quit message is the same
    assertEquals("Game quit!", message[8]);
    assertEquals("State of game when quit:", message[9]);
    assertEquals("    _ O O", message[10]);
    assertEquals("  O O O O O", message[11]);
    assertEquals("O O O O O O O", message[12]);
    assertEquals("O O O O O O O", message[13]);
    assertEquals("O O O O O O O", message[14]);
    assertEquals("  O O O O O", message[15]);
    assertEquals("    O O O", message[16]);
    assertEquals("Score: 36", message[17]);

  }

  @Test
  public void playGameLowercaseQPartialMoveQuitTest2() {
    // make sure that no move happens, and the game quits with the correct message
    Readable partialMoveQuit = new StringReader("2 4 q 4 4");
    MarbleSolitaireController partialMoveThenQuit =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, partialMoveQuit);

    partialMoveThenQuit.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that each line of the quit message is the same
    assertEquals("Game quit!", message[8]);
    assertEquals("State of game when quit:", message[9]);
    assertEquals("    O O O", message[10]);
    assertEquals("    O O O", message[11]);
    assertEquals("O O O O O O O", message[12]);
    assertEquals("O O O _ O O O", message[13]);
    assertEquals("O O O O O O O", message[14]);
    assertEquals("    O O O", message[15]);
    assertEquals("    O O O", message[16]);
    assertEquals("Score: 32", message[17]);

    // remove the opening message from the output, in order to check if the quit message is correct.
    String message2 = engOutput.toString().replaceFirst("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\nScore: 32\n", "");

    // checking if the quit message is correct, including indentation
    assertEquals("Game quit!\n" + "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", message2);

  }

  @Test
  public void playGameLowercaseQPartialMoveQuitEuropeanTest2() {
    // make sure that no move happens, and the game quits with the correct message
    Readable quitThenMove = new StringReader("1 5 q 1 3");
    MarbleSolitaireController quitAndThenMove =
            new MarbleSolitaireControllerImpl(this.euModel, this.euView, quitThenMove);

    quitAndThenMove.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that each line of the quit message is the same
    assertEquals("Game quit!", message[8]);
    assertEquals("State of game when quit:", message[9]);
    assertEquals("    _ O O", message[10]);
    assertEquals("  O O O O O", message[11]);
    assertEquals("O O O O O O O", message[12]);
    assertEquals("O O O O O O O", message[13]);
    assertEquals("O O O O O O O", message[14]);
    assertEquals("  O O O O O", message[15]);
    assertEquals("    O O O", message[16]);
    assertEquals("Score: 36", message[17]);

  }

  @Test
  public void playGameLowercaseQPartialMoveQuitTest3() {
    // make sure that no move happens, and the game quits with the correct message
    Readable partialMoveQuit = new StringReader("2 4 4 q 4");
    MarbleSolitaireController partialMoveThenQuit =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, partialMoveQuit);

    partialMoveThenQuit.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that each line of the quit message is the same
    assertEquals("Game quit!", message[8]);
    assertEquals("State of game when quit:", message[9]);
    assertEquals("    O O O", message[10]);
    assertEquals("    O O O", message[11]);
    assertEquals("O O O O O O O", message[12]);
    assertEquals("O O O _ O O O", message[13]);
    assertEquals("O O O O O O O", message[14]);
    assertEquals("    O O O", message[15]);
    assertEquals("    O O O", message[16]);
    assertEquals("Score: 32", message[17]);

    // remove the opening message from the output, in order to check if the quit message is correct.
    String message2 = engOutput.toString().replaceFirst("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\nScore: 32\n", "");

    // checking if the quit message is correct, including indentation
    assertEquals("Game quit!\n" + "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", message2);

  }

  @Test
  public void playGameLowercaseQPartialMoveQuitEuropeanTest3() {
    // make sure that no move happens, and the game quits with the correct message
    Readable quitThenMove = new StringReader("1 5 1 q 3");
    MarbleSolitaireController quitAndThenMove =
            new MarbleSolitaireControllerImpl(this.euModel, this.euView, quitThenMove);

    quitAndThenMove.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that each line of the quit message is the same
    assertEquals("Game quit!", message[8]);
    assertEquals("State of game when quit:", message[9]);
    assertEquals("    _ O O", message[10]);
    assertEquals("  O O O O O", message[11]);
    assertEquals("O O O O O O O", message[12]);
    assertEquals("O O O O O O O", message[13]);
    assertEquals("O O O O O O O", message[14]);
    assertEquals("  O O O O O", message[15]);
    assertEquals("    O O O", message[16]);
    assertEquals("Score: 36", message[17]);

  }

  @Test
  public void playGameLowercaseQMoveQuitTest() {
    Readable moveQuit = new StringReader("2 4 4 4 q");
    MarbleSolitaireController moveThenQuit =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, moveQuit);

    moveThenQuit.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that each line of the quit message is the same
    assertEquals("Game quit!", message[16]);
    assertEquals("State of game when quit:", message[17]);
    assertEquals("    O O O", message[18]);
    assertEquals("    O _ O", message[19]);
    assertEquals("O O O _ O O O", message[20]);
    assertEquals("O O O O O O O", message[21]);
    assertEquals("O O O O O O O", message[22]);
    assertEquals("    O O O", message[23]);
    assertEquals("    O O O", message[24]);
    assertEquals("Score: 31", message[25]);

  }

  @Test
  public void playGameLowercaseQMoveQuitEuropeanTest() {
    // make sure that no move happens, and the game quits with the correct message
    Readable quitThenMove = new StringReader("1 5 1 3 q");
    MarbleSolitaireController quitAndThenMove =
            new MarbleSolitaireControllerImpl(this.euModel, this.euView, quitThenMove);

    quitAndThenMove.playGame();

    String[] message = this.engOutput.toString().split("\n");

    // check that each line of the quit message is the same
    assertEquals("Game quit!", message[16]);
    assertEquals("State of game when quit:", message[17]);
    assertEquals("    O _ _", message[18]);
    assertEquals("  O O O O O", message[19]);
    assertEquals("O O O O O O O", message[20]);
    assertEquals("O O O O O O O", message[21]);
    assertEquals("O O O O O O O", message[22]);
    assertEquals("  O O O O O", message[23]);
    assertEquals("    O O O", message[24]);
    assertEquals("Score: 35", message[25]);

  }

  @Test
  public void playGameLowercaseQQuitThenInvalidMoveTest() {
    // make sure that no move happens, and the game quits with the correct message
    Readable quitThenMove = new StringReader("q 3 3 4 4");
    MarbleSolitaireController quitAndThenMove =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, quitThenMove);

    quitAndThenMove.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that each line of the quit message is the same
    assertEquals("Game quit!", message[8]);
    assertEquals("State of game when quit:", message[9]);
    assertEquals("    O O O", message[10]);
    assertEquals("    O O O", message[11]);
    assertEquals("O O O O O O O", message[12]);
    assertEquals("O O O _ O O O", message[13]);
    assertEquals("O O O O O O O", message[14]);
    assertEquals("    O O O", message[15]);
    assertEquals("    O O O", message[16]);
    assertEquals("Score: 32", message[17]);

    // remove the opening message from the output, in order to check if the quit message is correct.
    String message2 = engOutput.toString().replaceFirst("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\nScore: 32\n", "");

    // checking if the quit message is correct, including indentation
    assertEquals("Game quit!\n" + "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", message2);

  }


  @Test
  public void playGameLowercaseQPartialInvalidMoveQuitTest() {
    // make sure that no move happens, and the game quits with the correct message
    Readable partialMoveQuit = new StringReader("3 q 3 4 4");
    MarbleSolitaireController partialMoveThenQuit =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, partialMoveQuit);

    partialMoveThenQuit.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that each line of the quit message is the same
    assertEquals("Game quit!", message[8]);
    assertEquals("State of game when quit:", message[9]);
    assertEquals("    O O O", message[10]);
    assertEquals("    O O O", message[11]);
    assertEquals("O O O O O O O", message[12]);
    assertEquals("O O O _ O O O", message[13]);
    assertEquals("O O O O O O O", message[14]);
    assertEquals("    O O O", message[15]);
    assertEquals("    O O O", message[16]);
    assertEquals("Score: 32", message[17]);

    // remove the opening message from the output, in order to check if the quit message is correct.
    String message2 = engOutput.toString().replaceFirst("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\nScore: 32\n", "");

    // checking if the quit message is correct, including indentation
    assertEquals("Game quit!\n" + "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", message2);

  }

  @Test
  public void playGameLowercaseQPartialInvalidMoveQuitTest2() {
    // make sure that no move happens, and the game quits with the correct message
    Readable partialMoveQuit = new StringReader("3 3 q 4 4");
    MarbleSolitaireController partialMoveThenQuit =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, partialMoveQuit);

    partialMoveThenQuit.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that each line of the quit message is the same
    assertEquals("Game quit!", message[8]);
    assertEquals("State of game when quit:", message[9]);
    assertEquals("    O O O", message[10]);
    assertEquals("    O O O", message[11]);
    assertEquals("O O O O O O O", message[12]);
    assertEquals("O O O _ O O O", message[13]);
    assertEquals("O O O O O O O", message[14]);
    assertEquals("    O O O", message[15]);
    assertEquals("    O O O", message[16]);
    assertEquals("Score: 32", message[17]);

    // remove the opening message from the output, in order to check if the quit message is correct.
    String message2 = engOutput.toString().replaceFirst("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\nScore: 32\n", "");

    // checking if the quit message is correct, including indentation
    assertEquals("Game quit!\n" + "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", message2);

  }

  @Test
  public void playGameLowercaseQPartialInvalidMoveQuitTest3() {
    // make sure that no move happens, and the game quits with the correct message
    Readable partialMoveQuit = new StringReader("3 3 4 q 4");
    MarbleSolitaireController partialMoveThenQuit =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, partialMoveQuit);

    partialMoveThenQuit.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that each line of the quit message is the same
    assertEquals("Game quit!", message[8]);
    assertEquals("State of game when quit:", message[9]);
    assertEquals("    O O O", message[10]);
    assertEquals("    O O O", message[11]);
    assertEquals("O O O O O O O", message[12]);
    assertEquals("O O O _ O O O", message[13]);
    assertEquals("O O O O O O O", message[14]);
    assertEquals("    O O O", message[15]);
    assertEquals("    O O O", message[16]);
    assertEquals("Score: 32", message[17]);

    // remove the opening message from the output, in order to check if the quit message is correct.
    String message2 = engOutput.toString().replaceFirst("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\nScore: 32\n", "");

    // checking if the quit message is correct, including indentation
    assertEquals("Game quit!\n" + "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", message2);

  }

  @Test
  public void playGameLowercaseQInvalidMoveQuitTest() {
    // this is an invalid move, so the invalid move message should go, and then the quit message
    Readable moveQuit = new StringReader("3 3 4 4 q");
    MarbleSolitaireController moveThenQuit =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, moveQuit);

    moveThenQuit.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that each line of the quit message is the same
    assertEquals("Invalid move. Play again. ", message[8]);
    assertEquals("Game quit!", message[9]);
    assertEquals("State of game when quit:", message[10]);
    assertEquals("    O O O", message[11]);
    assertEquals("    O O O", message[12]);
    assertEquals("O O O O O O O", message[13]);
    assertEquals("O O O _ O O O", message[14]);
    assertEquals("O O O O O O O", message[15]);
    assertEquals("    O O O", message[16]);
    assertEquals("    O O O", message[17]);
    assertEquals("Score: 32", message[18]);

    // remove the opening message from the output, in order to check if the quit message is correct.
    String message2 = engOutput.toString().replaceFirst("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\nScore: 32\n", "");

    // checking if the quit message is correct, including indentation
    assertEquals(
            "Invalid move. Play again. \n" +
                    "Game quit!\n"
                    + "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n", message2);

  }

  @Test
  public void playGameTypeUppercaseQTest() {

    MarbleSolitaireControllerImpl quit =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, this.quitTwo);

    quit.playGame();
    String[] message = this.engOutput.toString().split("\n");


    // check that each line of the quit message is the same
    assertEquals("Game quit!", message[8]);
    assertEquals("State of game when quit:", message[9]);
    assertEquals("    O O O", message[10]);
    assertEquals("    O O O", message[11]);
    assertEquals("O O O O O O O", message[12]);
    assertEquals("O O O _ O O O", message[13]);
    assertEquals("O O O O O O O", message[14]);
    assertEquals("    O O O", message[15]);
    assertEquals("    O O O", message[16]);
    assertEquals("Score: 32", message[17]);

    // remove the opening message from the output, in order to check if the quit message is correct.
    String message2 = this.engOutput.toString().replaceFirst("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\nScore: 32\n", "");

    // checking if the quit message is correct, including indentation
    assertEquals("Game quit!\n" + "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", message2);

  }

  @Test
  public void playGameMultipleUppercaseQTest() {

    // should only return the quit message once
    Readable doubleQuit = new StringReader("Q Q");
    MarbleSolitaireControllerImpl quit =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, doubleQuit);

    quit.playGame();
    String[] message = this.engOutput.toString().split("\n");


    // check that each line of the quit message is the same
    assertEquals("Game quit!", message[8]);
    assertEquals("State of game when quit:", message[9]);
    assertEquals("    O O O", message[10]);
    assertEquals("    O O O", message[11]);
    assertEquals("O O O O O O O", message[12]);
    assertEquals("O O O _ O O O", message[13]);
    assertEquals("O O O O O O O", message[14]);
    assertEquals("    O O O", message[15]);
    assertEquals("    O O O", message[16]);
    assertEquals("Score: 32", message[17]);

    // remove the opening message from the output, in order to check if the quit message is correct.
    String message2 = this.engOutput.toString().replaceFirst("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\nScore: 32\n", "");

    // checking if the quit message is correct, including indentation
    assertEquals("Game quit!\n" + "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", message2);

  }

  @Test
  public void playGameUppercaseQQuitThenMoveTest() {
    // make sure that no move happens, and the game quits with the correct message
    Readable quitThenMove = new StringReader("Q 2 4 4 4");
    MarbleSolitaireController quitAndThenMove =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, quitThenMove);

    quitAndThenMove.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that each line of the quit message is the same
    assertEquals("Game quit!", message[8]);
    assertEquals("State of game when quit:", message[9]);
    assertEquals("    O O O", message[10]);
    assertEquals("    O O O", message[11]);
    assertEquals("O O O O O O O", message[12]);
    assertEquals("O O O _ O O O", message[13]);
    assertEquals("O O O O O O O", message[14]);
    assertEquals("    O O O", message[15]);
    assertEquals("    O O O", message[16]);
    assertEquals("Score: 32", message[17]);

    // remove the opening message from the output, in order to check if the quit message is correct.
    String message2 = engOutput.toString().replaceFirst("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\nScore: 32\n", "");

    // checking if the quit message is correct, including indentation
    assertEquals("Game quit!\n" + "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", message2);

  }


  @Test
  public void playGameUppercaseQPartialMoveQuitTest() {
    // make sure that no move happens, and the game quits with the correct message
    Readable partialMoveQuit = new StringReader("2 Q 4 4 4");
    MarbleSolitaireController partialMoveThenQuit =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, partialMoveQuit);

    partialMoveThenQuit.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that each line of the quit message is the same
    assertEquals("Game quit!", message[8]);
    assertEquals("State of game when quit:", message[9]);
    assertEquals("    O O O", message[10]);
    assertEquals("    O O O", message[11]);
    assertEquals("O O O O O O O", message[12]);
    assertEquals("O O O _ O O O", message[13]);
    assertEquals("O O O O O O O", message[14]);
    assertEquals("    O O O", message[15]);
    assertEquals("    O O O", message[16]);
    assertEquals("Score: 32", message[17]);

    // remove the opening message from the output, in order to check if the quit message is correct.
    String message2 = engOutput.toString().replaceFirst("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\nScore: 32\n", "");

    // checking if the quit message is correct, including indentation
    assertEquals("Game quit!\n" + "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", message2);

  }

  @Test
  public void playGameUppercaseQPartialMoveQuitTest2() {
    // make sure that no move happens, and the game quits with the correct message
    Readable partialMoveQuit = new StringReader("2 4 Q 4 4");
    MarbleSolitaireController partialMoveThenQuit =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, partialMoveQuit);

    partialMoveThenQuit.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that each line of the quit message is the same
    assertEquals("Game quit!", message[8]);
    assertEquals("State of game when quit:", message[9]);
    assertEquals("    O O O", message[10]);
    assertEquals("    O O O", message[11]);
    assertEquals("O O O O O O O", message[12]);
    assertEquals("O O O _ O O O", message[13]);
    assertEquals("O O O O O O O", message[14]);
    assertEquals("    O O O", message[15]);
    assertEquals("    O O O", message[16]);
    assertEquals("Score: 32", message[17]);

    // remove the opening message from the output, in order to check if the quit message is correct.
    String message2 = engOutput.toString().replaceFirst("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\nScore: 32\n", "");

    // checking if the quit message is correct, including indentation
    assertEquals("Game quit!\n" + "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", message2);

  }

  @Test
  public void playGameUppercaseQPartialMoveQuitTest3() {
    // make sure that no move happens, and the game quits with the correct message
    Readable partialMoveQuit = new StringReader("2 4 4 Q 4");
    MarbleSolitaireController partialMoveThenQuit =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, partialMoveQuit);

    partialMoveThenQuit.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that each line of the quit message is the same
    assertEquals("Game quit!", message[8]);
    assertEquals("State of game when quit:", message[9]);
    assertEquals("    O O O", message[10]);
    assertEquals("    O O O", message[11]);
    assertEquals("O O O O O O O", message[12]);
    assertEquals("O O O _ O O O", message[13]);
    assertEquals("O O O O O O O", message[14]);
    assertEquals("    O O O", message[15]);
    assertEquals("    O O O", message[16]);
    assertEquals("Score: 32", message[17]);

    // remove the opening message from the output, in order to check if the quit message is correct.
    String message2 = engOutput.toString().replaceFirst("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\nScore: 32\n", "");

    // checking if the quit message is correct, including indentation
    assertEquals("Game quit!\n" + "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", message2);

  }

  @Test
  public void playGameUppercaseQMoveQuitTest() {
    Readable moveQuit = new StringReader("2 4 4 4 Q");
    MarbleSolitaireController moveThenQuit =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, moveQuit);

    moveThenQuit.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that each line of the quit message is the same
    assertEquals("Game quit!", message[16]);
    assertEquals("State of game when quit:", message[17]);
    assertEquals("    O O O", message[18]);
    assertEquals("    O _ O", message[19]);
    assertEquals("O O O _ O O O", message[20]);
    assertEquals("O O O O O O O", message[21]);
    assertEquals("O O O O O O O", message[22]);
    assertEquals("    O O O", message[23]);
    assertEquals("    O O O", message[24]);
    assertEquals("Score: 31", message[25]);

  }

  @Test
  public void playGameUppercaseQQuitThenInvalidMoveTest() {
    // make sure that no move happens, and the game quits with the correct message
    Readable quitThenMove = new StringReader("Q 3 3 4 4");
    MarbleSolitaireController quitAndThenMove =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, quitThenMove);

    quitAndThenMove.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that each line of the quit message is the same
    assertEquals("Game quit!", message[8]);
    assertEquals("State of game when quit:", message[9]);
    assertEquals("    O O O", message[10]);
    assertEquals("    O O O", message[11]);
    assertEquals("O O O O O O O", message[12]);
    assertEquals("O O O _ O O O", message[13]);
    assertEquals("O O O O O O O", message[14]);
    assertEquals("    O O O", message[15]);
    assertEquals("    O O O", message[16]);
    assertEquals("Score: 32", message[17]);

    // remove the opening message from the output, in order to check if the quit message is correct.
    String message2 = engOutput.toString().replaceFirst("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\nScore: 32\n", "");

    // checking if the quit message is correct, including indentation
    assertEquals("Game quit!\n" + "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", message2);

  }


  @Test
  public void playGameUppercaseQPartialInvalidMoveQuitTest() {
    // make sure that no move happens, and the game quits with the correct message
    Readable partialMoveQuit = new StringReader("3 Q 3 4 4");
    MarbleSolitaireController partialMoveThenQuit =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, partialMoveQuit);

    partialMoveThenQuit.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that each line of the quit message is the same
    assertEquals("Game quit!", message[8]);
    assertEquals("State of game when quit:", message[9]);
    assertEquals("    O O O", message[10]);
    assertEquals("    O O O", message[11]);
    assertEquals("O O O O O O O", message[12]);
    assertEquals("O O O _ O O O", message[13]);
    assertEquals("O O O O O O O", message[14]);
    assertEquals("    O O O", message[15]);
    assertEquals("    O O O", message[16]);
    assertEquals("Score: 32", message[17]);

    // remove the opening message from the output, in order to check if the quit message is correct.
    String message2 = engOutput.toString().replaceFirst("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\nScore: 32\n", "");

    // checking if the quit message is correct, including indentation
    assertEquals("Game quit!\n" + "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", message2);

  }

  @Test
  public void playGameUppercaseQPartialInvalidMoveQuitTest2() {
    // make sure that no move happens, and the game quits with the correct message
    Readable partialMoveQuit = new StringReader("3 3 Q 4 4");
    MarbleSolitaireController partialMoveThenQuit =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, partialMoveQuit);

    partialMoveThenQuit.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that each line of the quit message is the same
    assertEquals("Game quit!", message[8]);
    assertEquals("State of game when quit:", message[9]);
    assertEquals("    O O O", message[10]);
    assertEquals("    O O O", message[11]);
    assertEquals("O O O O O O O", message[12]);
    assertEquals("O O O _ O O O", message[13]);
    assertEquals("O O O O O O O", message[14]);
    assertEquals("    O O O", message[15]);
    assertEquals("    O O O", message[16]);
    assertEquals("Score: 32", message[17]);

    // remove the opening message from the output, in order to check if the quit message is correct.
    String message2 = engOutput.toString().replaceFirst("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\nScore: 32\n", "");

    // checking if the quit message is correct, including indentation
    assertEquals("Game quit!\n" + "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", message2);

  }

  @Test
  public void playGameUppercaseQPartialInvalidMoveQuitTest3() {
    // make sure that no move happens, and the game quits with the correct message
    Readable partialMoveQuit = new StringReader("3 3 4 q 4");
    MarbleSolitaireController partialMoveThenQuit =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, partialMoveQuit);

    partialMoveThenQuit.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that each line of the quit message is the same
    assertEquals("Game quit!", message[8]);
    assertEquals("State of game when quit:", message[9]);
    assertEquals("    O O O", message[10]);
    assertEquals("    O O O", message[11]);
    assertEquals("O O O O O O O", message[12]);
    assertEquals("O O O _ O O O", message[13]);
    assertEquals("O O O O O O O", message[14]);
    assertEquals("    O O O", message[15]);
    assertEquals("    O O O", message[16]);
    assertEquals("Score: 32", message[17]);

    // remove the opening message from the output, in order to check if the quit message is correct.
    String message2 = engOutput.toString().replaceFirst("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\nScore: 32\n", "");

    // checking if the quit message is correct, including indentation
    assertEquals("Game quit!\n" + "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", message2);

  }

  @Test
  public void playGameUppercaseQInvalidMoveQuitTest() {
    // this is an invalid move, so the invalid move message should go, and then the quit message
    Readable moveQuit = new StringReader("3 3 4 4 Q");
    MarbleSolitaireController moveThenQuit =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, moveQuit);

    moveThenQuit.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that each line of the quit message is the same
    assertEquals("Invalid move. Play again. ", message[8]);
    assertEquals("Game quit!", message[9]);
    assertEquals("State of game when quit:", message[10]);
    assertEquals("    O O O", message[11]);
    assertEquals("    O O O", message[12]);
    assertEquals("O O O O O O O", message[13]);
    assertEquals("O O O _ O O O", message[14]);
    assertEquals("O O O O O O O", message[15]);
    assertEquals("    O O O", message[16]);
    assertEquals("    O O O", message[17]);
    assertEquals("Score: 32", message[18]);

    // remove the opening message from the output, in order to check if the quit message is correct.
    String message2 = engOutput.toString().replaceFirst("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\nScore: 32\n", "");

    // checking if the quit message is correct, including indentation
    assertEquals(
            "Invalid move. Play again. \n" +
                    "Game quit!\n"
                    + "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n", message2);
  }


  @Test
  public void playGameMoveUpMarbleMarbleEmpty() {
    // valid move
    Readable move = new StringReader("6 4 4 4 q");
    MarbleSolitaireController moveValid =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, move);

    moveValid.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that each line of the quit message is the same
    assertEquals("Game quit!", message[16]);
    assertEquals("State of game when quit:", message[17]);
    assertEquals("    O O O", message[18]);
    assertEquals("    O O O", message[19]);
    assertEquals("O O O O O O O", message[20]);
    assertEquals("O O O O O O O", message[21]);
    assertEquals("O O O _ O O O", message[22]);
    assertEquals("    O _ O", message[23]);
    assertEquals("    O O O", message[24]);
    assertEquals("Score: 31", message[25]);

  }

  @Test
  public void playGameMoveUpMarbleMarbleMarble() {
    // invalid move
    Readable move = new StringReader("7 4 5 4 q");
    MarbleSolitaireController moveInvalid =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, move);

    moveInvalid.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that invalid message appears correctly, and that the final gamestate is unchanged
    assertEquals("Invalid move. Play again. ", message[8]);
    assertEquals("Game quit!", message[9]);
    assertEquals("State of game when quit:", message[10]);
    assertEquals("    O O O", message[11]);
    assertEquals("    O O O", message[12]);
    assertEquals("O O O O O O O", message[13]);
    assertEquals("O O O _ O O O", message[14]);
    assertEquals("O O O O O O O", message[15]);
    assertEquals("    O O O", message[16]);
    assertEquals("    O O O", message[17]);
    assertEquals("Score: 32", message[18]);

    // remove the opening message from the output in order to check that the invalid message
    // is correct and the final board state is unchanged.
    String message2 = engOutput.toString().replaceFirst(
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\nScore: 32\n", "");

    // checking if the invalid message is correct, including indentation
    assertEquals("Invalid move. Play again. \n"
            + "Game quit!\n" + "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", message2);
  }

  @Test
  public void playGameMoveUpMarbleMarbleInvalid() {
    // invalid move
    Readable move = new StringReader("4 1 2 1 q");
    MarbleSolitaireController moveInvalid =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, move);

    moveInvalid.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that invalid message appears correctly, and that the final gamestate is unchanged
    assertEquals("Invalid move. Play again. ", message[8]);
    assertEquals("Game quit!", message[9]);
    assertEquals("State of game when quit:", message[10]);
    assertEquals("    O O O", message[11]);
    assertEquals("    O O O", message[12]);
    assertEquals("O O O O O O O", message[13]);
    assertEquals("O O O _ O O O", message[14]);
    assertEquals("O O O O O O O", message[15]);
    assertEquals("    O O O", message[16]);
    assertEquals("    O O O", message[17]);
    assertEquals("Score: 32", message[18]);

    // remove the opening message from the output in order to check that the invalid message
    // is correct and the final board state is unchanged.
    String message2 = engOutput.toString().replaceFirst(
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\nScore: 32\n", "");

    // checking if the invalid message is correct, including indentation
    assertEquals("Invalid move. Play again. \n"
            + "Game quit!\n" + "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", message2);
  }

  @Test
  public void playGameMoveUpMarbleEmptyEmpty() {
    // invalid move
    Readable move = new StringReader("2 4 4 4 4 4 2 4 q");
    MarbleSolitaireController moveInvalid =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, move);

    moveInvalid.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that invalid message appears correctly, and that the final gamestate is correct
    assertEquals("Invalid move. Play again. ", message[16]);
    assertEquals("Game quit!", message[17]);
    assertEquals("State of game when quit:", message[18]);
    assertEquals("    O O O", message[19]);
    assertEquals("    O _ O", message[20]);
    assertEquals("O O O _ O O O", message[21]);
    assertEquals("O O O O O O O", message[22]);
    assertEquals("O O O O O O O", message[23]);
    assertEquals("    O O O", message[24]);
    assertEquals("    O O O", message[25]);
    assertEquals("Score: 31", message[26]);

  }

  @Test
  public void playGameMoveUpMarbleEmptyMarble() {
    // invalid move
    Readable move = new StringReader("5 4 3 4 q");
    MarbleSolitaireController moveInvalid =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, move);

    moveInvalid.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that invalid message appears correctly, and that the final gamestate is unchanged
    assertEquals("Invalid move. Play again. ", message[8]);
    assertEquals("Game quit!", message[9]);
    assertEquals("State of game when quit:", message[10]);
    assertEquals("    O O O", message[11]);
    assertEquals("    O O O", message[12]);
    assertEquals("O O O O O O O", message[13]);
    assertEquals("O O O _ O O O", message[14]);
    assertEquals("O O O O O O O", message[15]);
    assertEquals("    O O O", message[16]);
    assertEquals("    O O O", message[17]);
    assertEquals("Score: 32", message[18]);

    // remove the opening message from the output in order to check that the invalid message
    // is correct and the final board state is unchanged.
    String message2 = engOutput.toString().replaceFirst(
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\nScore: 32\n", "");

    // checking if the invalid message is correct, including indentation
    assertEquals("Invalid move. Play again. \n"
            + "Game quit!\n" + "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", message2);
  }

  @Test
  public void playGameMoveUpMarbleEmptyInvalid() {
    // invalid move
    Readable move = new StringReader("2 4 4 4 3 2 3 4 4 2 2 2 q");
    MarbleSolitaireController moveInvalid =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, move);

    moveInvalid.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that invalid message appears correctly, and that the final gamestate is correct
    assertEquals("Invalid move. Play again. ", message[24]);
    assertEquals("Game quit!", message[25]);
    assertEquals("State of game when quit:", message[26]);
    assertEquals("    O O O", message[27]);
    assertEquals("    O _ O", message[28]);
    assertEquals("O _ _ O O O O", message[29]);
    assertEquals("O O O O O O O", message[30]);
    assertEquals("O O O O O O O", message[31]);
    assertEquals("    O O O", message[32]);
    assertEquals("    O O O", message[33]);
    assertEquals("Score: 30", message[34]);
  }

  @Test
  public void playGameMoveUpEmptyEmptyMarble() {
    // invalid move
    Readable move = new StringReader("2 4 4 4 3 4 1 4 q");
    MarbleSolitaireController moveInvalid =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, move);

    moveInvalid.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that invalid message appears correctly, and that the final gamestate is correct
    assertEquals("Invalid move. Play again. ", message[16]);
    assertEquals("Game quit!", message[17]);
    assertEquals("State of game when quit:", message[18]);
    assertEquals("    O O O", message[19]);
    assertEquals("    O _ O", message[20]);
    assertEquals("O O O _ O O O", message[21]);
    assertEquals("O O O O O O O", message[22]);
    assertEquals("O O O O O O O", message[23]);
    assertEquals("    O O O", message[24]);
    assertEquals("    O O O", message[25]);
    assertEquals("Score: 31", message[26]);

  }

  @Test
  public void playGameMoveUpEmptyEmptyEmpty() {
    // invalid move
    Readable move = new StringReader("2 4 4 4 5 4 3 4 4 6 4 4 3 4 5 4 4 4 2 4 q");
    MarbleSolitaireController moveInvalid =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, move);

    moveInvalid.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that invalid message appears correctly, and that the final gamestate is correct
    assertEquals("Invalid move. Play again. ", message[40]);
    assertEquals("Game quit!", message[41]);
    assertEquals("State of game when quit:", message[42]);
    assertEquals("    O O O", message[43]);
    assertEquals("    O _ O", message[44]);
    assertEquals("O O O _ O O O", message[45]);
    assertEquals("O O O _ _ _ O", message[46]);
    assertEquals("O O O O O O O", message[47]);
    assertEquals("    O O O", message[48]);
    assertEquals("    O O O", message[49]);
    assertEquals("Score: 28", message[50]);

  }

  @Test
  public void playGameMoveUpEmptyEmptyInvalid() {
    // invalid move
    Readable move = new StringReader("2 4 4 4 3 6 3 4 5 6 3 6 3 7 3 5 4 6 2 6 q");
    MarbleSolitaireController moveInvalid =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, move);

    moveInvalid.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that invalid message appears correctly, and that the final gamestate is correct
    assertEquals("Invalid move. Play again. ", message[40]);
    assertEquals("Game quit!", message[41]);
    assertEquals("State of game when quit:", message[42]);
    assertEquals("    O O O", message[43]);
    assertEquals("    O _ O", message[44]);
    assertEquals("O O O O O _ _", message[45]);
    assertEquals("O O O O O _ O", message[46]);
    assertEquals("O O O O O _ O", message[47]);
    assertEquals("    O O O", message[48]);
    assertEquals("    O O O", message[49]);
    assertEquals("Score: 28", message[50]);

  }

  @Test
  public void playGameMoveUpEmptyMarbleMarble() {
    // invalid move
    Readable move = new StringReader("4 4 2 4 q");
    MarbleSolitaireController moveInvalid =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, move);

    moveInvalid.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that invalid message appears correctly, and that the final gamestate is unchanged
    assertEquals("Invalid move. Play again. ", message[8]);
    assertEquals("Game quit!", message[9]);
    assertEquals("State of game when quit:", message[10]);
    assertEquals("    O O O", message[11]);
    assertEquals("    O O O", message[12]);
    assertEquals("O O O O O O O", message[13]);
    assertEquals("O O O _ O O O", message[14]);
    assertEquals("O O O O O O O", message[15]);
    assertEquals("    O O O", message[16]);
    assertEquals("    O O O", message[17]);
    assertEquals("Score: 32", message[18]);

  }

  @Test
  public void playGameMoveUpEmptyMarbleEmpty() {
    // invalid move
    Readable move = new StringReader("2 4 4 4 5 4 3 4 4 4 2 4 q");
    MarbleSolitaireController moveInvalid =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, move);

    moveInvalid.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that invalid message appears correctly, and that the final gamestate is correct
    assertEquals("Invalid move. Play again. ", message[24]);
    assertEquals("Game quit!", message[25]);
    assertEquals("State of game when quit:", message[26]);
    assertEquals("    O O O", message[27]);
    assertEquals("    O _ O", message[28]);
    assertEquals("O O O O O O O", message[29]);
    assertEquals("O O O _ O O O", message[30]);
    assertEquals("O O O _ O O O", message[31]);
    assertEquals("    O O O", message[32]);
    assertEquals("    O O O", message[33]);
    assertEquals("Score: 30", message[34]);

  }

  @Test
  public void playGameMoveUpEmptyMarbleInvalid() {
    // invalid move
    Readable move = new StringReader("4 2 4 4 4 2 2 2 q");
    MarbleSolitaireController moveInvalid =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, move);

    moveInvalid.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that invalid message appears correctly, and that the final gamestate is correct
    assertEquals("Invalid move. Play again. ", message[16]);
    assertEquals("Game quit!", message[17]);
    assertEquals("State of game when quit:", message[18]);
    assertEquals("    O O O", message[19]);
    assertEquals("    O O O", message[20]);
    assertEquals("O O O O O O O", message[21]);
    assertEquals("O _ _ O O O O", message[22]);
    assertEquals("O O O O O O O", message[23]);
    assertEquals("    O O O", message[24]);
    assertEquals("    O O O", message[25]);
    assertEquals("Score: 31", message[26]);

  }

  @Test
  public void playGameMoveUpInvalidEmptyMarble() {
    // invalid move
    Readable move = new StringReader("6 4 4 4 5 2 5 4 2 6 2 4 q");
    MarbleSolitaireController moveInvalid =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, move);

    moveInvalid.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that invalid message appears correctly, and that the final gamestate is correct
    assertEquals("Invalid move. Play again. ", message[24]);
    assertEquals("Game quit!", message[25]);
    assertEquals("State of game when quit:", message[26]);
    assertEquals("    O O O", message[27]);
    assertEquals("    O O O", message[28]);
    assertEquals("O O O O O O O", message[29]);
    assertEquals("O O O O O O O", message[30]);
    assertEquals("O _ _ O O O O", message[31]);
    assertEquals("    O _ O", message[32]);
    assertEquals("    O O O", message[33]);
    assertEquals("Score: 30", message[34]);

  }

  @Test
  public void playGameMoveUpInvalidEmptyEmpty() {
    // invalid move
    Readable move = new StringReader("2 4 4 4 3 2 3 4 5 2 3 2 6 2 4 2 q");
    MarbleSolitaireController moveInvalid =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, move);

    moveInvalid.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that invalid message appears correctly, and that the final gamestate is correct
    assertEquals("Invalid move. Play again. ", message[32]);
    assertEquals("Game quit!", message[33]);
    assertEquals("State of game when quit:", message[34]);
    assertEquals("    O O O", message[35]);
    assertEquals("    O _ O", message[36]);
    assertEquals("O O _ O O O O", message[37]);
    assertEquals("O _ O O O O O", message[38]);
    assertEquals("O _ O O O O O", message[39]);
    assertEquals("    O O O", message[40]);
    assertEquals("    O O O", message[41]);
    assertEquals("Score: 29", message[42]);

  }


  @Test
  public void playGameMoveUpInvalidMarbleMarble() {
    // invalid move
    Readable move = new StringReader("6 2 4 2 q");
    MarbleSolitaireController moveInvalid =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, move);

    moveInvalid.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that invalid message appears correctly, and that the final gamestate is correct
    assertEquals("Invalid move. Play again. ", message[8]);
    assertEquals("Game quit!", message[9]);
    assertEquals("State of game when quit:", message[10]);
    assertEquals("    O O O", message[11]);
    assertEquals("    O O O", message[12]);
    assertEquals("O O O O O O O", message[13]);
    assertEquals("O O O _ O O O", message[14]);
    assertEquals("O O O O O O O", message[15]);
    assertEquals("    O O O", message[16]);
    assertEquals("    O O O", message[17]);
    assertEquals("Score: 32", message[18]);

  }

  @Test
  public void playGameMoveUpInvalidMarbleEmpty() {
    // invalid move
    Readable move = new StringReader("4 2 4 4 6 2 4 2 q");
    MarbleSolitaireController moveInvalid =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, move);

    moveInvalid.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that invalid message appears correctly, and that the final gamestate is correct
    assertEquals("Invalid move. Play again. ", message[16]);
    assertEquals("Game quit!", message[17]);
    assertEquals("State of game when quit:", message[18]);
    assertEquals("    O O O", message[19]);
    assertEquals("    O O O", message[20]);
    assertEquals("O O O O O O O", message[21]);
    assertEquals("O _ _ O O O O", message[22]);
    assertEquals("O O O O O O O", message[23]);
    assertEquals("    O O O", message[24]);
    assertEquals("    O O O", message[25]);
    assertEquals("Score: 31", message[26]);

  }

  @Test
  public void playGameMoveDownMarbleMarbleEmpty() {
    // valid move
    Readable move = new StringReader("2 4 4 4 q");
    MarbleSolitaireController moveValid =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, move);

    moveValid.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that each line of the quit message is the same
    assertEquals("Game quit!", message[16]);
    assertEquals("State of game when quit:", message[17]);
    assertEquals("    O O O", message[18]);
    assertEquals("    O _ O", message[19]);
    assertEquals("O O O _ O O O", message[20]);
    assertEquals("O O O O O O O", message[21]);
    assertEquals("O O O O O O O", message[22]);
    assertEquals("    O O O", message[23]);
    assertEquals("    O O O", message[24]);
    assertEquals("Score: 31", message[25]);

  }

  @Test
  public void playGameMoveRightMarbleMarbleEmpty() {
    // valid move
    Readable move = new StringReader("4 2 4 4 q");
    MarbleSolitaireController moveValid =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, move);

    moveValid.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that each line of the quit message is the same
    assertEquals("Game quit!", message[16]);
    assertEquals("State of game when quit:", message[17]);
    assertEquals("    O O O", message[18]);
    assertEquals("    O O O", message[19]);
    assertEquals("O O O O O O O", message[20]);
    assertEquals("O _ _ O O O O", message[21]);
    assertEquals("O O O O O O O", message[22]);
    assertEquals("    O O O", message[23]);
    assertEquals("    O O O", message[24]);
    assertEquals("Score: 31", message[25]);

  }

  @Test
  public void playGameMoveLeftMarbleMarbleEmpty() {
    // valid move
    Readable move = new StringReader("4 6 4 4 q");
    MarbleSolitaireController moveValid =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, move);

    moveValid.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that each line of the quit message is the same
    assertEquals("Game quit!", message[16]);
    assertEquals("State of game when quit:", message[17]);
    assertEquals("    O O O", message[18]);
    assertEquals("    O O O", message[19]);
    assertEquals("O O O O O O O", message[20]);
    assertEquals("O O O O _ _ O", message[21]);
    assertEquals("O O O O O O O", message[22]);
    assertEquals("    O O O", message[23]);
    assertEquals("    O O O", message[24]);
    assertEquals("Score: 31", message[25]);

  }

  @Test
  public void playGameMoveUpDiagonalTwoSpacesApart() {
    // invalid move
    Readable move = new StringReader("4 6 4 4 6 4 4 6 q");
    MarbleSolitaireController moveInvalid =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, move);

    moveInvalid.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that invalid message appears correctly, and that the final gamestate is correct
    assertEquals("Invalid move. Play again. ", message[16]);
    assertEquals("Game quit!", message[17]);
    assertEquals("State of game when quit:", message[18]);
    assertEquals("    O O O", message[19]);
    assertEquals("    O O O", message[20]);
    assertEquals("O O O O O O O", message[21]);
    assertEquals("O O O O _ _ O", message[22]);
    assertEquals("O O O O O O O", message[23]);
    assertEquals("    O O O", message[24]);
    assertEquals("    O O O", message[25]);
    assertEquals("Score: 31", message[26]);

  }

  @Test
  public void playGameMoveRandomly() {
    // invalid move
    Readable move = new StringReader("1 3 4 6 q");
    MarbleSolitaireController moveInvalid =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, move);

    moveInvalid.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that invalid message appears correctly, and that the final gamestate is unchanged
    assertEquals("Invalid move. Play again. ", message[8]);
    assertEquals("Game quit!", message[9]);
    assertEquals("State of game when quit:", message[10]);
    assertEquals("    O O O", message[11]);
    assertEquals("    O O O", message[12]);
    assertEquals("O O O O O O O", message[13]);
    assertEquals("O O O _ O O O", message[14]);
    assertEquals("O O O O O O O", message[15]);
    assertEquals("    O O O", message[16]);
    assertEquals("    O O O", message[17]);
    assertEquals("Score: 32", message[18]);

  }

  @Test
  public void playGameNegativeInput() {
    // invalid move
    Readable move = new StringReader("-10 q");
    MarbleSolitaireController moveInvalid =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, move);

    moveInvalid.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that invalid message appears correctly, and that the final gamestate is unchanged
    assertEquals("Invalid input, please re-enter", message[8]);
    assertEquals("Game quit!", message[9]);
    assertEquals("State of game when quit:", message[10]);
    assertEquals("    O O O", message[11]);
    assertEquals("    O O O", message[12]);
    assertEquals("O O O O O O O", message[13]);
    assertEquals("O O O _ O O O", message[14]);
    assertEquals("O O O O O O O", message[15]);
    assertEquals("    O O O", message[16]);
    assertEquals("    O O O", message[17]);
    assertEquals("Score: 32", message[18]);

  }

  @Test
  public void playGameTwoNegativeInputs() {
    // invalid move
    Readable move = new StringReader("-10 -48 q");
    MarbleSolitaireController moveInvalid =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, move);

    moveInvalid.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that invalid message appears correctly, and that the final gamestate is unchanged
    assertEquals("Invalid input, please re-enter", message[8]);
    assertEquals("Invalid input, please re-enter", message[9]);
    assertEquals("Game quit!", message[10]);
    assertEquals("State of game when quit:", message[11]);
    assertEquals("    O O O", message[12]);
    assertEquals("    O O O", message[13]);
    assertEquals("O O O O O O O", message[14]);
    assertEquals("O O O _ O O O", message[15]);
    assertEquals("O O O O O O O", message[16]);
    assertEquals("    O O O", message[17]);
    assertEquals("    O O O", message[18]);
    assertEquals("Score: 32", message[19]);

  }

  @Test
  public void playGameNegativeInputThenValidMove() {
    // valid move
    Readable move = new StringReader("-10 2 4 4 4 q");
    MarbleSolitaireController moveInvalid =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, move);

    moveInvalid.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that invalid message appears correctly, and that the final gamestate is correct
    assertEquals("Invalid input, please re-enter", message[8]);
    assertEquals("Game quit!", message[17]);
    assertEquals("State of game when quit:", message[18]);
    assertEquals("    O O O", message[19]);
    assertEquals("    O _ O", message[20]);
    assertEquals("O O O _ O O O", message[21]);
    assertEquals("O O O O O O O", message[22]);
    assertEquals("O O O O O O O", message[23]);
    assertEquals("    O O O", message[24]);
    assertEquals("    O O O", message[25]);
    assertEquals("Score: 31", message[26]);

  }

  @Test
  public void playGameNegativeInputInMiddleOfValidMove() {
    // valid move
    Readable move = new StringReader("2 -8 4 4 4 q");
    MarbleSolitaireController moveInvalid =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, move);

    moveInvalid.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that invalid message appears correctly, and that the final gamestate is correct
    assertEquals("Invalid input, please re-enter", message[8]);
    assertEquals("Game quit!", message[17]);
    assertEquals("State of game when quit:", message[18]);
    assertEquals("    O O O", message[19]);
    assertEquals("    O _ O", message[20]);
    assertEquals("O O O _ O O O", message[21]);
    assertEquals("O O O O O O O", message[22]);
    assertEquals("O O O O O O O", message[23]);
    assertEquals("    O O O", message[24]);
    assertEquals("    O O O", message[25]);
    assertEquals("Score: 31", message[26]);

  }

  @Test
  public void playGameNegativeInputInMiddleOfValidMoveTwo() {
    // valid move
    Readable move = new StringReader("2 4 -8 4 4 q");
    MarbleSolitaireController moveInvalid =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, move);

    moveInvalid.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that invalid message appears correctly, and that the final gamestate is correct
    assertEquals("Invalid input, please re-enter", message[8]);
    assertEquals("Game quit!", message[17]);
    assertEquals("State of game when quit:", message[18]);
    assertEquals("    O O O", message[19]);
    assertEquals("    O _ O", message[20]);
    assertEquals("O O O _ O O O", message[21]);
    assertEquals("O O O O O O O", message[22]);
    assertEquals("O O O O O O O", message[23]);
    assertEquals("    O O O", message[24]);
    assertEquals("    O O O", message[25]);
    assertEquals("Score: 31", message[26]);

  }

  @Test
  public void playGameNegativeInputInMiddleOfValidMoveThree() {
    // valid move
    Readable move = new StringReader("2 4 4 -6 4 q");
    MarbleSolitaireController moveInvalid =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, move);

    moveInvalid.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that invalid message appears correctly, and that the final gamestate is correct
    assertEquals("Invalid input, please re-enter", message[8]);
    assertEquals("Game quit!", message[17]);
    assertEquals("State of game when quit:", message[18]);
    assertEquals("    O O O", message[19]);
    assertEquals("    O _ O", message[20]);
    assertEquals("O O O _ O O O", message[21]);
    assertEquals("O O O O O O O", message[22]);
    assertEquals("O O O O O O O", message[23]);
    assertEquals("    O O O", message[24]);
    assertEquals("    O O O", message[25]);
    assertEquals("Score: 31", message[26]);

  }

  @Test
  public void playGameNegativeInputAfterValidMove() {
    // valid move
    Readable move = new StringReader("2 4 4 4 0 q");
    MarbleSolitaireController moveInvalid =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, move);

    moveInvalid.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that invalid message appears correctly, and that the final gamestate is correct
    assertEquals("    O O O", message[8]);
    assertEquals("    O _ O", message[9]);
    assertEquals("O O O _ O O O", message[10]);
    assertEquals("O O O O O O O", message[11]);
    assertEquals("O O O O O O O", message[12]);
    assertEquals("    O O O", message[13]);
    assertEquals("    O O O", message[14]);
    assertEquals("Score: 31", message[15]);
    assertEquals("Invalid input, please re-enter", message[16]);
    assertEquals("Game quit!", message[17]);
    assertEquals("State of game when quit:", message[18]);
    assertEquals("    O O O", message[19]);
    assertEquals("    O _ O", message[20]);
    assertEquals("O O O _ O O O", message[21]);
    assertEquals("O O O O O O O", message[22]);
    assertEquals("O O O O O O O", message[23]);
    assertEquals("    O O O", message[24]);
    assertEquals("    O O O", message[25]);
    assertEquals("Score: 31", message[26]);

  }

  @Test
  public void playGameNegativeInputBetweenValidMoves() {
    // valid move
    Readable move = new StringReader("2 4 4 4 0 3 2 3 4 q");
    MarbleSolitaireController moveInvalid =
            new MarbleSolitaireControllerImpl(this.engModel, this.engView, move);

    moveInvalid.playGame();

    String[] message = this.engOutput.toString().split("\n");


    // check that invalid message appears correctly, and that the final gamestate is correct
    assertEquals("    O O O", message[8]);
    assertEquals("    O _ O", message[9]);
    assertEquals("O O O _ O O O", message[10]);
    assertEquals("O O O O O O O", message[11]);
    assertEquals("O O O O O O O", message[12]);
    assertEquals("    O O O", message[13]);
    assertEquals("    O O O", message[14]);
    assertEquals("Score: 31", message[15]);
    assertEquals("Invalid input, please re-enter", message[16]);
    assertEquals("    O O O", message[17]);
    assertEquals("    O _ O", message[18]);
    assertEquals("O _ _ O O O O", message[19]);
    assertEquals("O O O O O O O", message[20]);
    assertEquals("O O O O O O O", message[21]);
    assertEquals("    O O O", message[22]);
    assertEquals("    O O O", message[23]);
    assertEquals("Score: 30", message[24]);
    assertEquals("Game quit!", message[25]);
    assertEquals("State of game when quit:", message[26]);
    assertEquals("    O O O", message[27]);
    assertEquals("    O _ O", message[28]);
    assertEquals("O _ _ O O O O", message[29]);
    assertEquals("O O O O O O O", message[30]);
    assertEquals("O O O O O O O", message[31]);
    assertEquals("    O O O", message[32]);
    assertEquals("    O O O", message[33]);
    assertEquals("Score: 30", message[34]);

  }

  @Test
  public void moveInputsTest() {
    StringWriter log = new StringWriter();
    StringReader inputsInput = new StringReader("2 4 4 4 q");
    ConfirmInputsSolitaireModel confModel = new ConfirmInputsSolitaireModel(log);
    MarbleSolitaireTextView inputView = new MarbleSolitaireTextView(confModel, log);

    MarbleSolitaireControllerImpl inputController = new MarbleSolitaireControllerImpl(
            confModel, inputView, inputsInput);

    inputController.playGame();

    String inputs = log.toString().split("   O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n")[1].stripTrailing();

    assertEquals("fromRow: 1 fromCol: 3 toRow: 3 toCol: 3", inputs);
  }

  @Test
  public void moveInputsTestTwo() {
    StringWriter log = new StringWriter();
    StringReader inputsInput = new StringReader("1 8 2 11 q");
    ConfirmInputsSolitaireModel confModel = new ConfirmInputsSolitaireModel(log);
    MarbleSolitaireTextView inputView = new MarbleSolitaireTextView(confModel, log);

    MarbleSolitaireControllerImpl inputController = new MarbleSolitaireControllerImpl(
            confModel, inputView, inputsInput);

    inputController.playGame();

    String inputs = log.toString().split("   O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n")[1].stripTrailing();

    assertEquals("fromRow: 0 fromCol: 7 toRow: 1 toCol: 10", inputs);
  }

  @Test
  public void moveInputsInvalidTest() {
    StringWriter log = new StringWriter();
    StringReader inputsInput = new StringReader("-4 2 3 5 6 q");
    ConfirmInputsSolitaireModel confModel = new ConfirmInputsSolitaireModel(log);
    MarbleSolitaireTextView inputView = new MarbleSolitaireTextView(confModel, log);

    MarbleSolitaireControllerImpl inputController = new MarbleSolitaireControllerImpl(
            confModel, inputView, inputsInput);

    inputController.playGame();

    String inputs = log.toString().split("   O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n")[1].stripTrailing();

    assertEquals("Invalid input, please re-enter\nfromRow: 1 fromCol: 2 toRow: 4 toCol: 5", inputs);
  }

  @Test
  public void moveInputsInvalidTestTwo() {
    StringWriter log = new StringWriter();
    StringReader inputsInput = new StringReader("-carpet 2 3 5 6 q");
    ConfirmInputsSolitaireModel confModel = new ConfirmInputsSolitaireModel(log);
    MarbleSolitaireTextView inputView = new MarbleSolitaireTextView(confModel, log);

    MarbleSolitaireControllerImpl inputController = new MarbleSolitaireControllerImpl(
            confModel, inputView, inputsInput);

    inputController.playGame();

    String inputs = log.toString().split("   O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n")[1].stripTrailing();

    assertEquals("Invalid input, please re-enter\nfromRow: 1 fromCol: 2 toRow: 4 toCol: 5", inputs);
  }

  @Test
  public void moveInputsInvalidTestThree() {
    StringWriter log = new StringWriter();
    StringReader inputsInput = new StringReader("-1 2 3 floor 6 q");
    ConfirmInputsSolitaireModel confModel = new ConfirmInputsSolitaireModel(log);
    MarbleSolitaireTextView inputView = new MarbleSolitaireTextView(confModel, log);

    MarbleSolitaireControllerImpl inputController = new MarbleSolitaireControllerImpl(
            confModel, inputView, inputsInput);

    inputController.playGame();

    String inputs = log.toString().split("   O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n")[1].stripTrailing();

    assertEquals("Invalid input, please re-enter\nInvalid input, please re-enter\nGame quit!\n" +
            "State of game when quit:", inputs);
  }

  @Test
  public void playGameIOExceptionReadableTest() {

    MarbleSolitaireControllerImpl impl = new MarbleSolitaireControllerImpl(
            this.engModel, this.engView, this.badReadable);
    try {
      impl.playGame();
    } catch (IllegalStateException e) {
      assertEquals("Cannot read Readable", e.getMessage());
    }

  }

  @Test
  public void playGameIOExceptionAppendableTest() {

    MarbleSolitaireView badView = new MarbleSolitaireTextView(this.engModel, this.badAppendable);

    MarbleSolitaireControllerImpl impl = new MarbleSolitaireControllerImpl(
            this.engModel, badView, this.engInput);
    try {
      impl.playGame();
    } catch (IllegalStateException e) {
      assertEquals("Could not transmit to Appendable", e.getMessage());
    }

  }

  @Test
  public void playGameIOExceptionAppendableAndReadableTest() {

    MarbleSolitaireView badView = new MarbleSolitaireTextView(this.engModel, this.badAppendable);

    MarbleSolitaireControllerImpl impl = new MarbleSolitaireControllerImpl(
            this.engModel, badView, this.badReadable);
    try {
      impl.playGame();
    } catch (IllegalStateException e) {
      assertEquals("Could not transmit to Appendable", e.getMessage());
    }

  }

  @Test
  public void triangleModelAndViewTest() {
    // just a little sanity check to make sure the controller works with a triangle model
    // and view

    Appendable output = new StringWriter();
    Readable input = new StringReader("3 1 1 1 3 3 3 1 1 1 3 3 4 1 2 1 4 " +
            "4 2 2 5 2 3 2 5 4 5 2 5 1 5 3 5 3 3 3 2 2 4 4 5 5 3 3 3 3 3 1 3 1 1 1 q");
    MarbleSolitaireModel model = new TriangleSolitaireModel();
    MarbleSolitaireView view = new TriangleSolitaireTextView(model, output);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, input);

    controller.playGame();

    assertEquals(
            "    _\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "Score: 14\n" +
                    "    O\n" +
                    "   _ O\n" +
                    "  _ O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "Score: 13\n" +
                    "    O\n" +
                    "   _ O\n" +
                    "  O _ _\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "Score: 12\n" +
                    "    _\n" +
                    "   _ _\n" +
                    "  O _ O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "Score: 11\n" +
                    "    _\n" +
                    "   O _\n" +
                    "  _ _ O\n" +
                    " _ O O O\n" +
                    "O O O O O\n" +
                    "Score: 10\n" +
                    "    _\n" +
                    "   O O\n" +
                    "  _ _ _\n" +
                    " _ O O _\n" +
                    "O O O O O\n" +
                    "Score: 9\n" +
                    "    _\n" +
                    "   O O\n" +
                    "  _ O _\n" +
                    " _ _ O _\n" +
                    "O _ O O O\n" +
                    "Score: 8\n" +
                    "    _\n" +
                    "   O O\n" +
                    "  _ O _\n" +
                    " _ _ O _\n" +
                    "O O _ _ O\n" +
                    "Score: 7\n" +
                    "    _\n" +
                    "   O O\n" +
                    "  _ O _\n" +
                    " _ _ O _\n" +
                    "_ _ O _ O\n" +
                    "Score: 6\n" +
                    "    _\n" +
                    "   O O\n" +
                    "  _ O O\n" +
                    " _ _ _ _\n" +
                    "_ _ _ _ O\n" +
                    "Score: 5\n" +
                    "    _\n" +
                    "   O _\n" +
                    "  _ O _\n" +
                    " _ _ _ O\n" +
                    "_ _ _ _ O\n" +
                    "Score: 4\n" +
                    "    _\n" +
                    "   O _\n" +
                    "  _ O O\n" +
                    " _ _ _ _\n" +
                    "_ _ _ _ _\n" +
                    "Score: 3\n" +
                    "    _\n" +
                    "   O _\n" +
                    "  O _ _\n" +
                    " _ _ _ _\n" +
                    "_ _ _ _ _\n" +
                    "Score: 2\n" +
                    "    O\n" +
                    "   _ _\n" +
                    "  _ _ _\n" +
                    " _ _ _ _\n" +
                    "_ _ _ _ _\n" +
                    "Score: 1\n" +
                    "Game over!\n" +
                    "    O\n" +
                    "   _ _\n" +
                    "  _ _ _\n" +
                    " _ _ _ _\n" +
                    "_ _ _ _ _\n" +
                    "Score: 1\n", output.toString());

  }

}