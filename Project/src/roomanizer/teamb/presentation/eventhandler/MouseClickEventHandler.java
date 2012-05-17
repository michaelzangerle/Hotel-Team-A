/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.presentation.eventhandler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import roomanizer.teamb.presentation.basic.AbstractForm;
import roomanizer.teamb.presentation.basic.EventHandler;

/**
 *
 * @author And
 */
public class MouseClickEventHandler extends EventHandler implements MouseListener {

    Integer button;

    /**
     * 
     * @param button
     */
    public MouseClickEventHandler(Integer button) {
        this(null, button);
    }

    /**
     * 
     * @param form
     * @param button
     */
    public MouseClickEventHandler(AbstractForm form, Integer button) {
        super(form, null);
        this.button = button;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == button) {
            super.doAction();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
