/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.presentation.eventhandler;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import roomanizer.teamb.presentation.basic.AbstractForm;
import roomanizer.teamb.presentation.basic.EventHandler;
import roomanizer.teamb.presentation.basic.IActionResult;

/**
 *
 * @author And
 */
public class WindowEventHandler extends EventHandler implements WindowListener {

    /**
     * 
     * @param form
     * @param detail
     */
    public WindowEventHandler(AbstractForm form, IActionResult detail) {
        super(form, detail);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        doAction();
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}
