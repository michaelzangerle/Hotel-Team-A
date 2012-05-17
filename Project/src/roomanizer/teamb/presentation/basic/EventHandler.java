/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.presentation.basic;

import java.util.LinkedList;

/**
 *
 * @author And
 */
public abstract class EventHandler {

    AbstractForm form;
    LinkedList<Action> actions;
    IActionResult result;

    /**
     * 
     * @param result
     */
    public EventHandler(IActionResult result) {
        this(null, result);
    }

    /**
     * 
     * @param form
     * @param result
     */
    public EventHandler(AbstractForm form, IActionResult result) {
        this.form = form;
        this.result = result;
        this.actions = new LinkedList<Action>();
    }

    /**
     * 
     * @param action
     */
    public void add(Action action) {
        this.actions.add(action);
    }

    /**
     * 
     * @param action
     */
    public void remove(Action action) {
        this.actions.remove(action);
    }

    /**
     * 
     * @return
     */
    public AbstractForm getForm() {
        return form;
    }

    /**
     * 
     */
    public void fail() {
        result.fail();
    }

    /**
     * 
     */
    public void success() {
        result.success();
    }

    /**
     * 
     */
    public void doAction() {
        Boolean ok = true;
        for (int i = 0; i < actions.size(); i++) {
            if (!actions.get(i).doAction()) {
                fail();
                ok = false;
                break;
            }
        }
        if (ok) {
            success();
        }
    }

    /**
     * 
     */
    public void undo() {
        throw new UnsupportedOperationException("Not implemented Yet");
    }
}
