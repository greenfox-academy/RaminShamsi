import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;


public class Board extends JComponent implements KeyListener {
  // int heroPosX;
  // int heroPosY;
  int tileNumberX;
  int tileNumberY;
  WallArea newWallArea;
  Hero hero;
  Floor floor;

  public Board() {
    //   heroPosX = 0;
    //   heroPosY = 0;
    tileNumberX = 10;
    tileNumberY = 10;
    newWallArea = new WallArea();
    hero = new Hero();
    floor = new Floor();
    // floor = new GameObject();
    //   wall = new GameObject();

    // set the size of your draw board
    setPreferredSize(new Dimension(720, 720));
    setVisible(true);
  }

  @Override
  public void paint(Graphics graphics) {
    super.paint(graphics);
//    graphics.fillRect(heroPosX, heroPosY, 70, 70);
    // here you have a 720x720 canvas
    // you can create and draw an image using the class below e.g.
    for (int x = 0; x < tileNumberX; x++) {
      for (int y = 0; y < tileNumberY; y++) {
        floor.drawFloor(graphics, x * 72, y * 72);
      }
    }

    newWallArea.wallArea(graphics);
    hero.draw(graphics);


//    PositionedImage image = new PositionedImage("assets/boss.png", heroPosX, heroPosY);
//    image.draw(graphics);
  }

  public static void main(String[] args) {
    // Here is how you set up a new window and adding our board to it
    JFrame frame = new JFrame("RPG Game");
    Board board = new Board();
    frame.add(board);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.pack();
    // Here is how you can add a key event listener
    // The board object will be notified when hitting any key
    // with the system calling one of the below 3 methods
    frame.addKeyListener(board);
    // Notice (at the top) that we can only do this
    // because this Board class (the type of the board object) is also a KeyListener

  }

  // To be a KeyListener the class needs to have these 3 methods in it
  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {
//    if (e.getKeyCode() == KeyEvent.VK_RIGHT ) {
//      hero.movingRight(getGraphics());
//    }
//    repaint();
  }

  // But actually we can use just this one for our goals here
  @Override
  public void keyReleased(KeyEvent e) {
    // When the up or down keys hit, we change the position of our box

    if (e.getKeyCode() == KeyEvent.VK_UP && hero.posY > 0
            && !newWallArea.isWall(hero.posX, hero.posY - 72)) {
      hero.moveUp();
    } else if (e.getKeyCode() == KeyEvent.VK_DOWN && hero.posY < (720 - 72)
            && !newWallArea.isWall(hero.posX, hero.posY + 72)) {
      hero.moveDown();
    } else if (e.getKeyCode() == KeyEvent.VK_LEFT && hero.posX > 0
            && !newWallArea.isWall(hero.posX - 72, hero.posY)) {
      hero.moveLeft();
    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && hero.posX < (720 - 72)
            && newWallArea.isWall(hero.posX + 72, hero.posY) == false) {
      hero.moveRight();
    }

    // and redraw to have a new picture with the new coordinates
    //   invalidate();
    repaint();

  }
}