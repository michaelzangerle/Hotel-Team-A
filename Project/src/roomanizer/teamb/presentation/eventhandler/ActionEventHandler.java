/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.presentation.eventhandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import roomanizer.teamb.presentation.basic.AbstractForm;
import roomanizer.teamb.presentation.basic.EventHandler;
import roomanizer.teamb.presentation.basic.IActionResult;

/**
 *
 * @author And
 */
public class ActionEventHandler extends EventHandler implements ActionListener {

    /**
     * 
     * @param result
     */
    public ActionEventHandler(IActionResult result){
        super(result);
    }
    
    /**
     * 
     * @param form
     * @param detail
     */
    public ActionEventHandler(AbstractForm form, IActionResult detail){
        super(form, detail);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        super.doAction();
    }
    
}
