/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.presentation.basic;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import roomanizer.teamb.presentation.eventhandler.WindowEventHandler;

/**
 *
 * @author And
 */
public abstract class AbstractForm extends JFrame {

    private class WindowActionResult implements IActionResult {

        @Override
        public void fail() {
            loadFailed();
        }

        @Override
        public void success() {
            loadSuccess();
        }
    }

    public void loadFailed() {
    }

    public void loadSuccess() {
    }
    AbstractForm parent;
    WindowEventHandler windowHandler;

    /**
     *
     */
    public AbstractForm() {
        this(null);
    }

    /**
     *
     * @param parent
     */
    public AbstractForm(AbstractForm parent) {
        this.parent = parent;
        initControls();
    }

    /**
     *
     */
    public void showForm() {
        this.setVisible(true);
        this.setTitle("Roomanizer");
    }

    /**
     *
     */
    public void refresh() {
        if (parent != null) {
            parent.refresh();
        }
    }

    /**
     *
     * @param action
     */
    protected void addAction(Action<?> action) {
        this.windowHandler.add(action);
    }

    private void initControls() {
        this.windowHandler = new WindowEventHandler(this, new WindowActionResult());
        this.addWindowListener(windowHandler);
    }
}
