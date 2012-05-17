/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.presentation.forms.overview;

import javax.swing.RowFilter;

/**
 *
 * @author Michael
 */
public class TableRowFilter extends RowFilter<Object, Object> {

    /**
     * 
     */
    public String filter;
    /**
     * 
     * @param filter
     */
    public TableRowFilter(String filter) {
        this.filter = filter;
    }
    
    @Override
    public boolean include(Entry<? extends Object, ? extends Object> entry) {
        
        for(int i = 0; i < entry.getValueCount(); i++) {
            if(entry.getValue(i).toString().toLowerCase().matches(filter.toLowerCase())) {
                return true;
            }
        }
        
        return false;
    }
}
