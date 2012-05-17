/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.presentation.basic;

import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author And
 */
public abstract class AbstractFormDialog extends AbstractForm {

    /**
     * 
     */
    public AbstractFormDialog() {
        this(null);
    }

    /**
     * 
     * @param parent
     */
    public AbstractFormDialog(AbstractForm parent) {
        super(parent);
        initControls(600, 670);
    }

    /**
     * 
     * @param parent
     * @param x
     * @param y
     */
    public AbstractFormDialog(AbstractForm parent, int x, int y) {
        super(parent);
        initControls(x, y);
    }


    private void initControls(int x, int y) {
        setSize(x, y);
        
        UIManager.put("Label.font", Stylesheet.getStandard());
        UIManager.put("TextField.font", Stylesheet.getStandard());
        UIManager.put("Table.font", Stylesheet.getStandard());
        UIManager.put("TableHeader.font", Stylesheet.getStandard());
        UIManager.put("ComboBox.font", Stylesheet.getStandard());
        UIManager.put("Panel.background", Stylesheet.getBackground());
        UIManager.put("TitledBorder.font", Stylesheet.getHeadline());
        UIManager.put("TitledBorder.titleColor", Stylesheet.getButtonBG());
        UIManager.put("ComboBox.background", Color.white);
        UIManager.put("Button.background", Stylesheet.getButtonBG());
        UIManager.put("Button.foreground", Stylesheet.getButtonFG());
        UIManager.put("CheckBox.background", Stylesheet.getBackground());
        SwingUtilities.updateComponentTreeUI(this);

        this.getContentPane().setBackground(Stylesheet.getBackground());
        setResizable(false);
        setLocationRelativeTo(null);
    }
}
