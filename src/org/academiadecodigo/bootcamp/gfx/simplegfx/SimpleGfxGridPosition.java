package org.academiadecodigo.bootcamp.gfx.simplegfx;

import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.GridColor;
import org.academiadecodigo.bootcamp.grid.GridDirection;
import org.academiadecodigo.bootcamp.grid.position.AbstractGridPosition;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Simple graphics position
 */
public class SimpleGfxGridPosition extends AbstractGridPosition {

    private Rectangle rectangle;
    private SimpleGfxGrid simpleGfxGrid;

    /**
     * Simple graphics position constructor
     * @param grid Simple graphics grid
     */

    public SimpleGfxGridPosition(SimpleGfxGrid grid){
        super((int) (Math.random() * grid.getCols()), (int) (Math.random() * grid.getRows()), grid);
        simpleGfxGrid = grid;
        rectangle = new Rectangle(super.getCol()*10 +10, super.getCol()*10 +10,10,10);
        show();
    }

    /**
     * Simple graphics position constructor
     * @param col position column
     * @param row position row
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid grid){
        super(col, row, grid);
        simpleGfxGrid = grid;
        rectangle = new Rectangle(col*10+10, row*10+10,10,10);
        show();
    }

    /**
     * @see GridPosition#show()
     */
    @Override
    public void show() {
        rectangle.fill();
    }

    /**
     * @see GridPosition#hide()
     */
    @Override
    public void hide() {

        rectangle.delete();
    }

    /**
     * @see GridPosition#moveInDirection(GridDirection, int)
     */
    @Override
    public void moveInDirection(GridDirection direction, int distance) {

        int theOneCol;
        int theOneRow;
        int currentCol = getCol();
        int currentRow = getRow();
        super.moveInDirection(direction,distance);
        int newCol = getCol();
        int newRow = getRow();
        if(newCol > currentCol) {
            theOneCol = newCol - currentCol;
            rectangle.translate(+theOneCol*10, 0);
        }
        if (currentCol > newCol){
            theOneCol = currentCol - newCol;
            rectangle.translate(-theOneCol*10, 0);
        }
        if (currentRow > newRow){
            theOneRow = currentRow - newRow;
            rectangle.translate(0, -theOneRow*10);
        }
        if (newRow > currentRow){
            theOneRow = newRow - currentRow;
            rectangle.translate(0, +theOneRow*10);
        }

        /*

            switch(direction) {
                case UP:
                    rectangle.translate(0, +10);
                    break;
                case DOWN:
                    rectangle.translate(0, -10);
                    break;
                case RIGHT:
                    rectangle.translate(+10, 0);
                    break;
                case LEFT:
                    rectangle.translate(-10, 0);
                    break;
            }
        }*/
    }

    /**
     * @see AbstractGridPosition#setColor(GridColor)
     */
    @Override
    public void setColor(GridColor color) {
        rectangle.setColor(SimpleGfxColorMapper.getColor(color));
        super.setColor(color);
    }
}
