package src.levelbuilder.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class BetterScrollBar extends BasicScrollBarUI {

   /*@Override
   protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
    	 g.setColor(Color.decode("#D8D8D8"));
         g.fillRect(0, 0, 700, 20);
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
    	 if(thumbBounds.isEmpty() || !scrollbar.isEnabled())     {
             return;
         }

         int w = thumbBounds.width;
         int h = thumbBounds.height;

         g.translate(thumbBounds.x, thumbBounds.y);

         g.setColor(Color.decode("#A38F85"));
         g.drawRect(0, 0, w-1, h-1);
         g.setColor(thumbColor);
         g.fillRoundRect(0, 0, w-1, h-1, 15, 15);

         g.setColor(Color.decode("#A38F85"));
         g.drawLine(1, 1, 1, h-2);
         g.drawLine(2, 1, w-3, 1);

         g.setColor(Color.decode("#A38F85"));
         g.drawLine(2, h-2, w-2, h-2);
         g.drawLine(w-2, 1, w-2, h-3);

         g.translate(-thumbBounds.x, -thumbBounds.y);
    }*/
    
	protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds)
    {
        if(thumbBounds.isEmpty() || !scrollbar.isEnabled())     {
            return;
        }

        int w = thumbBounds.width;
        int h = thumbBounds.height;

        g.translate(thumbBounds.x, thumbBounds.y);

        g.setColor(Color.decode("#A38F85"));
        g.drawRoundRect(0, 0, w-1, h-1, 20, 20);
        g.setColor(Color.decode("#A38F85"));
        g.fillRoundRect(0, 0, w-1, h-1, 20, 20);

        g.translate(-thumbBounds.x, -thumbBounds.y);
    }
    
    protected void configureScrollBarColors(){
    	this.thumbColor = Color.decode("#A38F85");
    	this.trackColor = Color.decode("#E5E3E3");
    	
    }
    
    protected JButton createZeroButton() {
        JButton button = new JButton("zero button");
        Dimension zeroDim = new Dimension(0,0);
        button.setPreferredSize(zeroDim);
        button.setMinimumSize(zeroDim);
        button.setMaximumSize(zeroDim);
        return button;
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return createZeroButton();
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return createZeroButton();
    }
}