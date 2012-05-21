/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.presentation.forms.invoice;

import java.awt.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import roomanizer.teamb.presentation.action.AbortControllerAction;
import roomanizer.teamb.presentation.action.CommitControllerAction;
import roomanizer.teamb.presentation.forms.invoice.action.AddPaymentAction;
import roomanizer.teamb.presentation.forms.invoice.action.LoadZahlungsmethodeAction;
import roomanizer.teamb.presentation.action.RedirectAction;
import roomanizer.teamb.presentation.basic.AbstractForm;
import roomanizer.teamb.presentation.basic.AbstractFormInvoice;
import roomanizer.teamb.presentation.basic.IActionResult;
import roomanizer.teamb.presentation.basic.Stylesheet;
import roomanizer.teamb.presentation.eventhandler.ActionEventHandler;
import roomanizer.teamb.presentation.forms.invoice.action.AddPaymentAction.IAddPaymentActionDetail;
import roomanizer.teamb.presentation.forms.invoice.action.LoadZahlungsmethodeAction.ILoadZahlungsmethodeDetail;
import roomanizer.teamb.service.contract.controller.IInvoiceController;
import roomanizer.teamb.service.integrate.IBTeilzahlung;
import roomanizer.teamb.service.integrate.IBZahlungsmethode;

/**
 * Step 2, Auflistung aller ausgew√§hlten Rechnungspostionen und Bearbeitung der Zahlungsart
 * @author Andreas Lorenz
 */
public class InvoiceStep2 extends AbstractFormInvoice implements IActionResult, Observer {

    //<editor-fold defaultstate="collapsed" desc="InnerClasses">
    private class LoadZahlungsmehtode implements ILoadZahlungsmethodeDetail {

        @Override
        public void setZahlungsmethode(List<IBZahlungsmethode> zahlungsmethode) {
            comboBoxPaymentType.setModel(new DefaultComboBoxModel(zahlungsmethode.toArray()));
        }
    }

    private class AddPaymentAmount implements IAddPaymentActionDetail {

        @Override
        public BigDecimal getAmount() {
            BigDecimal bdAmount = new BigDecimal(Double.valueOf(textFieldAmount.getValue().toString()));
            return bdAmount;
        }

        @Override
        public IBZahlungsmethode getZahlungsmethode() {
            return (IBZahlungsmethode) comboBoxPaymentType.getSelectedItem();
        }
    }
    //</editor-fold>
    private JButton btnAddPayment;
    private JButton btnBack;
    private JButton btnCancel;
    private JButton btnNext;
    private JComboBox comboBoxPaymentType;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JLabel labelAddress;
    private JLabel labelCountry;
    private JLabel labelName;
    private JLabel labelInvoiceItems;
    private JLabel labelOpen;
    private JLabel labelPaymentAmount;
    private JLabel labelPaymentDetails;
    private JLabel labelLocation;
    private JLabel labelStreet;
    private JLabel labelTotalPrice;
    private JLabel labelTotalTaxes;
    private JLabel labelTypeOfPayment;
    private JPanel panelAddPayment;
    private JPanel panelInvoice;
    private JTable tableInvoiceDetails;
    private JTable tableTypePayment;
    private JFormattedTextField textFieldAmount;
    private IInvoiceController controller;
    private InvoiceStep1 invoice1;

    @Override
    public void fail() {
        JOptionPane.showMessageDialog(null, "The Guest paid to Less!", "Paid to Less", JOptionPane.OK_OPTION);
    }

    @Override
    public void success() {
        setVisible(false);
    }

    @Override
    public void update(Observable o, Object arg) {
        textFieldAmount.setValue(controller.getOpen());
        labelTotalPrice.setText("TOTAL " + controller.getTotal().setScale(2, RoundingMode.HALF_UP).toString() + " Ä");
        labelTotalTaxes.setText("Total Taxes " + controller.getTaxes().setScale(2, RoundingMode.HALF_UP).toString() + " Ä");
        labelOpen.setText("Open " + controller.getOpen().setScale(2, RoundingMode.HALF_UP) + " Ä");

        labelName.setText(controller.getRechnung().getFirstname() + " " + controller.getRechnung().getSurname());
        labelStreet.setText(controller.getRechnung().getAddress());
        labelLocation.setText(controller.getRechnung().getPostalCode() + " " + controller.getRechnung().getLocation());
        labelCountry.setText(controller.getRechnung().getCountry().toString());
    }

    /**
     * 
     * @param form
     * @param controller
     * @param invoice1
     */
    public InvoiceStep2(AbstractForm form, IInvoiceController controller, InvoiceStep1 invoice1) {
        super(form);
        this.controller = controller;
        this.invoice1 = invoice1;

        initControls();
    }

    private void initControls() {

        controller.addObserver(this);
        addAction(new LoadZahlungsmethodeAction(new LoadZahlungsmehtode(), controller));

        panelInvoice = new JPanel();
        labelName = new JLabel();
        labelStreet = new JLabel();
        labelLocation = new JLabel();
        labelCountry = new JLabel();
        jScrollPane1 = new JScrollPane();        
        labelTotalTaxes = new JLabel();
        labelTotalPrice = new JLabel();
        jScrollPane2 = new JScrollPane();        
        labelOpen = new JLabel();
        labelAddress = new JLabel();
        labelInvoiceItems = new JLabel();
        labelPaymentDetails = new JLabel();
        panelAddPayment = new JPanel();
        labelTypeOfPayment = new JLabel();
        comboBoxPaymentType = new JComboBox();
        labelPaymentAmount = new JLabel();
        textFieldAmount = new JFormattedTextField(java.text.NumberFormat.getCurrencyInstance(Locale.GERMANY));
        btnAddPayment = new JButton();
        btnNext = new JButton();
        btnCancel = new JButton();
        btnBack = new JButton();
        tableInvoiceDetails = new JTable(){
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                final Component c = super.prepareRenderer(renderer, row, column);
                if (c instanceof JComponent){
                    ((JComponent) c).setOpaque(true);  

                    if(row %2 == 0){
                        c.setBackground(Color.WHITE);
                    }
                    else{
                        c.setBackground(new Color(0xC9, 0xE2, 0xE9));
                    }
                }
                return c;
            }
        };
        tableInvoiceDetails.setOpaque(true);
        tableInvoiceDetails.setGridColor(new Color(0,0,0,0));
        tableInvoiceDetails.setShowVerticalLines(false);
        JTableHeader header = tableInvoiceDetails.getTableHeader();
        header.setBackground(Stylesheet.getButtonBG());
        header.setForeground(Color.WHITE);
        
        tableTypePayment = new JTable(){
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                final Component c = super.prepareRenderer(renderer, row, column);
                if (c instanceof JComponent){
                    ((JComponent) c).setOpaque(true);  

                    if(row %2 == 0){
                        c.setBackground(Color.WHITE);
                    }
                    else{
                        c.setBackground(new Color(0xC9, 0xE2, 0xE9));
                    }
                }
                return c;
            }
        };
        tableTypePayment.setOpaque(true);
        tableTypePayment.setGridColor(new Color(0,0,0,0));
        tableTypePayment.setShowVerticalLines(false);
        JTableHeader header1 = tableTypePayment.getTableHeader();
        header1.setBackground(Stylesheet.getButtonBG());
        header1.setForeground(Color.WHITE);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        
        Image img = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("logo_96.png"));
        this.setIconImage(img);

        panelInvoice.setBorder(BorderFactory.createTitledBorder("Invoice"));
        tableInvoiceDetails.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableInvoiceDetails);

        labelName.setText("InvoiceFirstname");
        labelStreet.setText("InvoiceStreet");
        labelLocation.setText("PostalCode");
        labelCountry.setText("InvoiceCountry");

        labelTotalTaxes.setText("Total Taxes 123,45 ‚Ç¨");
        labelTotalPrice.setText("TOTAL 12345,67‚Ç¨");

        jScrollPane2.setViewportView(tableTypePayment);

        labelOpen.setText("Open 41,09‚Ç¨");
        labelAddress.setText("Invoice Address:");
        labelInvoiceItems.setText("Invoice Items");
        labelPaymentDetails.setText("Payment Details");

        GroupLayout panelInvoiceLayout = new GroupLayout(panelInvoice);
        panelInvoice.setLayout(panelInvoiceLayout);
        panelInvoiceLayout.setHorizontalGroup(
                panelInvoiceLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelInvoiceLayout.createSequentialGroup().addContainerGap().addGroup(panelInvoiceLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jScrollPane2).addComponent(jScrollPane1).addGroup(GroupLayout.Alignment.TRAILING, panelInvoiceLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addGroup(panelInvoiceLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(labelTotalTaxes, GroupLayout.Alignment.TRAILING).addComponent(labelOpen, GroupLayout.Alignment.TRAILING).addComponent(labelTotalPrice, GroupLayout.Alignment.TRAILING))).addGroup(GroupLayout.Alignment.TRAILING, panelInvoiceLayout.createSequentialGroup().addGroup(panelInvoiceLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(panelInvoiceLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(labelAddress)).addGroup(GroupLayout.Alignment.LEADING, panelInvoiceLayout.createSequentialGroup().addComponent(labelInvoiceItems).addGap(0, 0, Short.MAX_VALUE))).addGap(18, 18, 18).addGroup(panelInvoiceLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelInvoiceLayout.createSequentialGroup().addGroup(panelInvoiceLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(labelLocation).addComponent(labelName)).addGap(32, 32, 32).addGroup(panelInvoiceLayout.createParallelGroup(GroupLayout.Alignment.LEADING))).addComponent(labelStreet).addComponent(labelCountry))).addGroup(panelInvoiceLayout.createSequentialGroup().addComponent(labelPaymentDetails).addGap(0, 0, Short.MAX_VALUE))).addContainerGap()));
        panelInvoiceLayout.setVerticalGroup(
                panelInvoiceLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelInvoiceLayout.createSequentialGroup().addGroup(panelInvoiceLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, panelInvoiceLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(labelName).addComponent(labelAddress))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(labelStreet).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(panelInvoiceLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(labelLocation)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(panelInvoiceLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(labelCountry).addComponent(labelInvoiceItems)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(panelInvoiceLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelInvoiceLayout.createSequentialGroup().addComponent(labelTotalTaxes).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(labelTotalPrice).addGap(23, 23, 23)).addGroup(GroupLayout.Alignment.TRAILING, panelInvoiceLayout.createSequentialGroup().addComponent(labelPaymentDetails).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))).addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(labelOpen).addGap(6, 6, 6)));

        panelAddPayment.setBorder(BorderFactory.createTitledBorder("Further Payments"));
        labelTypeOfPayment.setText("Type of Payment");
        comboBoxPaymentType.setModel(new DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        labelPaymentAmount.setText("Amount of Payment");
        btnAddPayment.setText("Add Payment");

        GroupLayout panelAddPaymentLayout = new GroupLayout(panelAddPayment);
        panelAddPayment.setLayout(panelAddPaymentLayout);
        panelAddPaymentLayout.setHorizontalGroup(
                panelAddPaymentLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelAddPaymentLayout.createSequentialGroup().addContainerGap().addComponent(labelTypeOfPayment).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(comboBoxPaymentType, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE).addGap(55, 55, 55).addComponent(labelPaymentAmount).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(textFieldAmount, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 213, Short.MAX_VALUE).addComponent(btnAddPayment).addContainerGap()));
        panelAddPaymentLayout.setVerticalGroup(
                panelAddPaymentLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelAddPaymentLayout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(panelAddPaymentLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelAddPaymentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(labelPaymentAmount).addComponent(textFieldAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(btnAddPayment)).addGroup(panelAddPaymentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(comboBoxPaymentType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(labelTypeOfPayment)))));

        btnNext.setText("Next");
        btnCancel.setText("Cancel");
        btnBack.setText("Back");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(panelInvoice, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(panelAddPayment, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))).addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(panelInvoice, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(panelAddPayment, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(btnBack).addComponent(btnCancel).addComponent(btnNext)).addGap(6, 6, 6)));


        ActionEventHandler handlerCancel = new ActionEventHandler(this);
        handlerCancel.add(new AbortControllerAction(controller));
        btnCancel.addActionListener(handlerCancel);

        ActionEventHandler handlerBack = new ActionEventHandler(this);
        handlerBack.add(new RedirectAction(invoice1));
        btnBack.addActionListener(handlerBack);

        ActionEventHandler handlerNext = new ActionEventHandler(this);
        handlerNext.add(new CommitControllerAction(controller));
        handlerNext.add(new RedirectAction(new InvoiceStep3(controller)));
        btnNext.addActionListener(handlerNext);

        ActionEventHandler handlePayment = new ActionEventHandler(new IActionResult() {

            @Override
            public void fail() {
                JOptionPane.showMessageDialog(null, "The Guest paid to Much!", "Paid to much", JOptionPane.OK_OPTION);
                textFieldAmount.setValue(controller.getOpen());
            }

            @Override
            public void success() {
            }
        });
        handlePayment.add(new AddPaymentAction(new AddPaymentAmount(), controller));
        btnAddPayment.addActionListener(handlePayment);

        PaymentCellEditor ed = new PaymentCellEditor(controller);
        tableTypePayment.setDefaultEditor(IBTeilzahlung.class, ed);
        tableTypePayment.setDefaultRenderer(IBTeilzahlung.class, ed);
        tableTypePayment.setRowHeight(30);

        pack();
    }

    @Override
    public void showForm() {
        super.showForm();
        tableInvoiceDetails.setModel(new AusgewaehlteRechnungPostionenTableModel(controller));
        tableTypePayment.setModel(new PaymentTableModel(controller));
    }
}
