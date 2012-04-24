package projekt.fhv.teama.model.Actions;

import org.apache.pivot.collections.ArrayList;
import org.apache.pivot.wtk.Action;
import org.apache.pivot.wtk.Alert;
import org.apache.pivot.wtk.Component;
import org.apache.pivot.wtk.Dialog;
import org.apache.pivot.wtk.MessageType;

import projekt.fhv.teama.view.support.BlockingDialog;

public class ActionHandler {
	
	Action cancel = new Action(true) {
	    @Override
	    public void perform(Component source) {
	     	
	    BlockingDialog bd = new BlockingDialog();
	    bd.setContent(new Alert(MessageType.WARNING, "Cancel the Check-In Process?" +
	        		" Inputs will not be saved!", new ArrayList<String>("Yes","No")));
	    Dialog erg = bd.open(source.getDisplay());
	    int i = ((Alert)erg).getSelectedOptionIndex();
	    
	    if( erg.getResult() && i ==0 ) {
	    	
//		    checkInForm01.repaint();
//		    checkInForm02.repaint();
//		    checkInForm03.repaint();
//		    checkInForm04.repaint();		    
//		    checkInForm01.setVisible(false);
//		    checkInForm02.setVisible(false);
//		    checkInForm03.setVisible(false);
//		    checkInForm04.setVisible(false);
//		    progress.setVisible(false);
//			meter.setPercentage(0.25);
//			reservationForm01.setVisible(true);
	    }		    
	        
	    }
	};
}
