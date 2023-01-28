package cs3500.marblesolitaire.view;

import java.awt.Image;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import cs3500.marblesolitaire.model.controller.Features;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Yep.
 */
public class BoardPanel extends JPanel implements PanelInterface {
  private final int cellDimension;
  private MarbleSolitaireModelState modelState;
  private Image emptySlot;
  private Image marbleSlot;
  private Image blankSlot;
  private int originX;
  private int originY;

  private Features features;

  /**
   * Yeah.
   *
   * @param state yup.
   * @throws IllegalStateException okie
   */
  public BoardPanel(MarbleSolitaireModelState state) throws IllegalStateException {
    super();
    this.modelState = state;
    this.setBackground(Color.WHITE);
    this.cellDimension = 50;
    try {
      emptySlot = ImageIO.read(new FileInputStream("res/empty.png"));
      emptySlot = emptySlot.getScaledInstance(cellDimension, cellDimension, Image.SCALE_DEFAULT);

      marbleSlot = ImageIO.read(new FileInputStream("res/marble.png"));
      marbleSlot = marbleSlot.getScaledInstance(cellDimension, cellDimension, Image.SCALE_DEFAULT);

      blankSlot = ImageIO.read(new FileInputStream("res/blank.png"));
      blankSlot = blankSlot.getScaledInstance(cellDimension, cellDimension, Image.SCALE_DEFAULT);

      this.setPreferredSize(
              new Dimension((this.modelState.getBoardSize() + 4) * cellDimension
                      , (this.modelState.getBoardSize() + 4) * cellDimension));
    } catch (IOException e) {
      throw new IllegalStateException("Icons not found!");
    }

  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    originX = (int) (this.getPreferredSize().getWidth() / 2 -
            this.modelState.getBoardSize() * cellDimension / 2);
    originY = (int) (this.getPreferredSize().getHeight() / 2 -
            this.modelState.getBoardSize() * cellDimension / 2);


    //your code to the draw the board should go here. 
    //The originX and originY is the top-left of where the cell (0,0) should start
    //cellDimension is the width (and height) occupied by every cell
    for (int i = 0; i < this.modelState.getBoardSize(); i++) {
      for (int j = 0; j < this.modelState.getBoardSize(); j++) {

        if (this.modelState.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Marble) {
          g.drawImage(this.marbleSlot, originX + j * cellDimension,
                  originY + i * cellDimension, this);
        } else if (this.modelState.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Empty) {
          g.drawImage(this.emptySlot, originX + j * cellDimension,
                  originY + i * cellDimension, this);
        } else {
          g.drawImage(this.blankSlot, originX + j * cellDimension,
                  originY + i * cellDimension, this);
        }

      }
    }

  }


  @Override
  public void acceptController(Features c) {
    this.features = c;

    this.addMouseListener(new MoveListener());

  }

  class MoveListener extends MouseAdapter {

    @Override
    public void mouseClicked(MouseEvent e) {
      int j = (e.getX() - originX) / cellDimension;
      int i = (e.getY() - originY) / cellDimension;

      features.moveInput(i, j);
    }
  }
}
