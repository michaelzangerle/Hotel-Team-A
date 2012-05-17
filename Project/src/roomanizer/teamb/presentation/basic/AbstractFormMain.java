/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.presentation.basic;

import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

/**
 *
 * @author And
 */
public abstract class AbstractFormMain extends AbstractForm {

    /**
     * 
     */
    public AbstractFormMain() {
        this(null);
    }

    /**
     * 
     * @param parent
     */
    public AbstractFormMain(AbstractForm parent) {
        super(parent);
        initControls();
    }

    /**
     * 
     */
    public void initControls() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
        setExtendedState(this.getExtendedState() | MAXIMIZED_BOTH);
                
        this.setBackground(Stylesheet.getButtonBG());
        UIManager.put("TabbedPane.selected", Stylesheet.getActiveButtonBG());
        UIManager.put("TabbedPane.contentBorderInsets", new Insets(0, 0, 0, 0));
        UIManager.put("TabbedPane.tabsOverlapBorder", true);
        UIManager.put("TabbedPane.contentAreaColor", Stylesheet.getBackground());
        UIManager.put("TabbedPane.background", Stylesheet.getButtonBG());
        UIManager.put("Panel.background", Stylesheet.getBackground());
        UIManager.put("Viewport.background", Stylesheet.getBackground());
//        UIManager.put("Container.background", Stylesheet.getBackground());
        UIManager.put("MenuBar.background", Stylesheet.getButtonBG());
        UIManager.put("MenuBar.font", Stylesheet.getStandard());
        UIManager.put("Menu.foreground", Stylesheet.getButtonFG());
        UIManager.put("TableHeader.font", Stylesheet.getStandard());
        UIManager.put("Table.font", Stylesheet.getStandard());
        SwingUtilities.updateComponentTreeUI(this);
    }
}
