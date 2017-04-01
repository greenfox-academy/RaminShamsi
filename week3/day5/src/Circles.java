import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Circles {
  public static void mainDraw(Graphics graphics) {

//    graphics.drawOval(100, 100, 500, 500);
    circle(graphics, 300, 300, 400);


  }

  public static void circle(Graphics graphics, int xCenter, int yCenter, int d) {


    if (d < 10) {

    } else {
      graphics.drawOval(xCenter - d / 2, yCenter - d / 2, d, d); /// Drawing Circle with Java box corner as center

      circle(graphics, xCenter, yCenter - d / 4, d / 2);   
      circle(graphics, xCenter - (int) (d / 4 * Math.cos(Math.toRadians(30))),
              yCenter + (int) (d / 4 * Math.sin(Math.toRadians(30))), d / 2);
      circle(graphics, xCenter + (int) (d / 4 * Math.cos(Math.toRadians(30))),
              yCenter + (int) (d / 4 * Math.sin(Math.toRadians(30))), d / 2);
    }
  }


  //    Don't touch the code below

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Drawing");
    jFrame.setSize(new Dimension(700, 700));
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    jFrame.add(new ImagePanel());
    jFrame.setLocationRelativeTo(null);
    jFrame.setVisible(true);
  }

  static class ImagePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      mainDraw(graphics);
    }
  }
}
