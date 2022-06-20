import javax.swing.*;
import java.awt.*;
public class kochsnowflake extends JPanel{
    int level = 3;
    int height;
    int width;
    public kochsnowflake(){
        String l = JOptionPane.showInputDialog(null, "Enter the level of the koch snowflake you wanna see.");
        level = Integer.parseInt(l);
    }
    public void paint(Graphics g){
        height = this.getHeight() - this.getHeight()/4;
        width = this.getWidth();
        int xStart = width/2 - height/2;
        drawsnowflake(g, level, xStart + 20, height - 20, xStart + height - 20, height - 20);
        drawsnowflake(g, level, xStart + height - 20, height - 20, xStart + height/2, 20);
        drawsnowflake(g, level, xStart + height/2, 20, xStart + 20, height - 20); 
    }
    private void drawsnowflake (Graphics g, int lev, int x1, int y1, int x5, int y5){
        int deltaX, deltaY, x2, y2, x3, y3, x4, y4;
        if (lev == 0){
            g.drawLine(x1, y1, x5, y5);
        }
        else
        {
            deltaX = x5 - x1;
            deltaY = y5 - y1;
            x2 = x1 + deltaX / 3;
            y2 = y1 + deltaY / 3;
            x3 = (int) (0.5 * (x1+x5) + Math.sqrt(3) * (y1-y5)/6);
            y3 = (int) (0.5 * (y1+y5) + Math.sqrt(3) * (x5-x1)/6);
            x4 = x1 + 2 * deltaX /3;
            y4 = y1 + 2 * deltaY /3;
            drawsnowflake(g,lev-1, x1, y1, x2, y2);
            drawsnowflake (g,lev-1, x2, y2, x3, y3);
            drawsnowflake (g,lev-1, x3, y3, x4, y4);
            drawsnowflake (g,lev-1, x4, y4, x5, y5);
        }
    }
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.add(new kochsnowflake());
        jf.setSize(1024, 1024);
        jf.setVisible(true);
    }
}
