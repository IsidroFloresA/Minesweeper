/**
 * MineFieldView.java
 *
 * @author Isidro Flores
 * @author Rustico De la Cruz
 * @author Ryan Nikopour
 *
 * Edits:
 *      Isidro     03/10/2025: Created File
 *      All        03/14/2025: Edit the file
 *      Isidro     03/20/2025: Finished editing the file
 */

package mineField;

import mvc.*;
import javax.swing.*;
import java.awt.*;

public class MineFieldView extends View {
    private static final int CELL_SIZE = 30;
    private static final int SIZE = 10;

    public MineFieldView(Model model) {
        super(model);
        this.setPreferredSize(new Dimension(SIZE * CELL_SIZE, SIZE * CELL_SIZE));
        initView();
    }

    public void initView() {
        repaint();
    }

    @Override
    public void setModel(Model newModel) {
        super.setModel(newModel);
        initView();
        repaint();
    }

    @Override
    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Graphics2D g2 = (Graphics2D) gc;
        MineField mineField = (MineField) model;

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                int x = c * CELL_SIZE;
                int y = r * CELL_SIZE;
                g2.setColor(Color.LIGHT_GRAY);
                g2.fillRect(x, y, CELL_SIZE, CELL_SIZE);
                g2.setColor(Color.BLACK);
                g2.drawRect(x, y, CELL_SIZE, CELL_SIZE);
                if (r == SIZE - 1 && c == SIZE - 1) {
                    g2.setColor(Color.GREEN);
                    g2.fillRect(x, y, CELL_SIZE, CELL_SIZE);
                } else if (mineField.isRevealed(r, c)) {
                    if (mineField.isMined(r, c)) {
                        g2.setColor(Color.RED);
                        g2.fillOval(x + 5, y + 5, CELL_SIZE - 10, CELL_SIZE - 10);
                    } else {
                        int neighborMines = mineField.getNeighborMines(r, c);
                        g2.setColor(Color.BLUE);
                        g2.drawString(String.valueOf(neighborMines), x + 10, y + 20);
                    }
                } else if (mineField.isFlagged(r, c)) {
                    g2.setColor(Color.GREEN);
                    g2.drawString("F", x + 10, y + 20);
                }
            }
        }

        int playerRow = mineField.getPlayerRow();
        int playerCol = mineField.getPlayerCol();
        int playerX = playerCol * CELL_SIZE;
        int playerY = playerRow * CELL_SIZE;
        g2.setColor(Color.ORANGE);
        g2.fillOval(playerX + 5, playerY + 5, CELL_SIZE - 10, CELL_SIZE - 10);
    }
}
