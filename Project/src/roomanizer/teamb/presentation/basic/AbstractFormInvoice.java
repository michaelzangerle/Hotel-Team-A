/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.presentation.basic;

import java.awt.Color;
import java.awt.Insets;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Amann
 */
public abstract class AbstractFormInvoice extends AbstractForm {
    public AbstractFormInvoice() {
        this(null);
    }

    /**
     * 
     * @param parent
     */
    public AbstractFormInvoice(AbstractForm parent) {
        super(parent);
        initControls(891, 612);
    }

    /**
     * 
     * @param parent
     * @param x
     * @param y
     */
    public AbstractFormInvoice(AbstractForm parent, int x, int y) {
        super(parent);
        initControls(x, y);
    }


    private void initControls(int x, int y) {
        setSize(x, y);
        
        this.setBackground(Stylesheet.getButtonBG());
        UIManager.put("Label.font", Stylesheet.getStandard());
        UIManager.put("TextField.font", Stylesheet.getStandard());
        UIManager.put("Table.font", Stylesheet.getStandard());
        UIManager.put("TableHeader.font", Stylesheet.getStandard());
        UIManager.put("ComboBox.font", Stylesheet.getStandard());
        UIManager.put("ComboBox.background", Color.white);
        UIManager.put("Panel.background", Stylesheet.getBackground());
        UIManager.put("TitledBorder.font", Stylesheet.getHeadline());
        UIManager.put("TitledBorder.titleColor", Stylesheet.getButtonBG());        
        UIManager.put("Button.background", Stylesheet.getButtonBG());
        UIManager.put("Button.foreground", Stylesheet.getButtonFG());
        UIManager.put("CheckBox.background", Stylesheet.getBackground());
        UIManager.put("Viewport.background", Stylesheet.getBackground());
        SwingUtilities.updateComponentTreeUI(this);

        this.getContentPane().setBackground(Stylesheet.getBackground());
        setResizable(false);
        setLocationRelativeTo(null);
    }
}
