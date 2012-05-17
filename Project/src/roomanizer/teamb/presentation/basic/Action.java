/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.presentation.basic;

/**
 *
 * @param <V> 
 * @author And
 */
public abstract class Action<V extends IActionDetails> {

    V details;

    /**
     * 
     */
    public Action() {
        this(null);
    }

    /**
     * 
     * @param detail
     */
    public Action(V detail) {
        this.details = detail;
    }

    /**
     * 
     * @return
     */
    public V getDetails() {
        return details;
    }

    /**
     * 
     * @return
     */
    public abstract Boolean doAction();

    /**
     * 
     * @return
     */
    public abstract Boolean undo();
}
