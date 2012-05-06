package projekt.fhv.teama.view;

import java.awt.Color;
import java.net.URL;
import java.util.Locale;

import org.apache.pivot.beans.BXML;
import org.apache.pivot.beans.Bindable;
import org.apache.pivot.collections.*;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.Border;
import org.apache.pivot.wtk.Bounds;
import org.apache.pivot.wtk.BoxPane;
import org.apache.pivot.wtk.Label;
import org.apache.pivot.wtk.ListButton;
import org.apache.pivot.wtk.ListView;
import org.apache.pivot.wtk.PushButton;
import org.apache.pivot.wtk.Spinner;
import org.apache.pivot.wtk.TableView;
import org.apache.pivot.wtk.TableViewHeader;
import org.apache.pivot.wtk.TextInput;
import org.apache.pivot.wtk.Theme;
import org.apache.pivot.wtk.content.CalendarDateSpinnerData;
import org.apache.pivot.wtk.content.TableViewRowEditor;
import org.apache.pivot.wtk.skin.terra.TerraTableViewHeaderSkin;
import org.apache.pivot.wtk.skin.terra.TerraTheme;


import projekt.fhv.teama.view.support.CurrencyValidator;
import projekt.fhv.teama.view.support.ExpenseType;
import projekt.fhv.teama.view.support.Services;
import projekt.fhv.teama.view.tests.TestData;


/**
 * Übersicht über einen momentan im Hotel eingecheckten Gast.
 *
 * @author Team A
 * @version 1.1
 */
public class ViewAdditionalServices extends Border implements Bindable {
	
	/**
	 * Controls für das Fenster festlegen. Die Felder werden bei Deserialisierung
	 * automatisch initialisiert.
	 * 
	 */
	
	/* Container */
	@BXML BoxPane bpAdditionalServicesForm01; @BXML BoxPane bpAdditionalServicesForm02;
	
	/* Label */
	@BXML Label asf1LBBookedRooms;@BXML Label asf1LBAdditionalServices;	@BXML Label asf1TISelectedRoom;
	
	/* TextInputs */

	
	/* Buttons */
	@BXML PushButton asf1PBtnCancel;@BXML PushButton asf1PBtnBack;@BXML PushButton asf1PBtnNext;@BXML PushButton asf2PBtnBack;@BXML PushButton asf2PBtnFinish;
	
	/* ListViews */
	@BXML ListView asf1LVBookedRooms;
	
	/* TableViews */
	@BXML TableView asf1TVAdditionalServices;
	
	    @Override
		public void initialize(Map<String, Object> arg0, URL arg1, Resources arg2) {
	    	
	    	 TableViewRowEditor tableViewRowEditor = new TableViewRowEditor();
	    	 asf1TVAdditionalServices.setRowEditor(tableViewRowEditor);
	    	 TestData td = new TestData();
	    	 td.generateTestData();
	    	 
	    	 asf1TVAdditionalServices.setTableData(td.testDataServices);
	    	 
	    	 
	    	    // Quantity uses a TextInput
	    	    TextInput quantityTextInput = new TextInput();
	    	    quantityTextInput.setTextKey("quantity");
	    	    tableViewRowEditor.getCellEditors().put("quantity", quantityTextInput);	
	    	 
	    	    // Expense type uses a ListButton that presents the expense types
	    	    ListButton typeListButton = new ListButton
	    	        (new EnumList<Services>(Services.class));
	    	    typeListButton.setSelectedItemKey("type");
	    	    tableViewRowEditor.getCellEditors().put("type", typeListButton);

	    	    // Amount uses a TextInput with strict currency validation
	    	    TextInput amountTextInput = new TextInput();
	    	    amountTextInput.setValidator(new CurrencyValidator());
	    	    amountTextInput.setStrictValidation(true);
	    	    amountTextInput.setTextKey("amount");
	    	    tableViewRowEditor.getCellEditors().put("amount", amountTextInput);	    	    
	    	    
	    	    // Description uses a TextInput
	    	    TextInput descriptionTextInput = new TextInput();
	    	    descriptionTextInput.setTextKey("description");
	    	    tableViewRowEditor.getCellEditors().put("description", descriptionTextInput);	
	    		    		  			    	
	    }

  

}
