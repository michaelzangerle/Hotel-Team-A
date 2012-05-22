/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.presentation.forms.invoice;

import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import roomanizer.teamb.presentation.action.AbortControllerAction;
import roomanizer.teamb.presentation.action.RedirectAction;
import roomanizer.teamb.presentation.action.StartControllerAction;
import roomanizer.teamb.presentation.basic.AbstractForm;
import roomanizer.teamb.presentation.basic.AbstractFormInvoice;
import roomanizer.teamb.presentation.basic.IActionResult;
import roomanizer.teamb.presentation.basic.Stylesheet;
import roomanizer.teamb.presentation.detail.IStartControllerDetail;
import roomanizer.teamb.presentation.eventhandler.ActionEventHandler;
import roomanizer.teamb.presentation.forms.invoice.action.EditInvoicePersonAction;
import roomanizer.teamb.presentation.forms.invoice.action.EditInvoicePersonAction.IEditInvoicePersonDetail;
import roomanizer.teamb.presentation.forms.invoice.action.HasOpenPositionAction;
import roomanizer.teamb.presentation.forms.invoice.action.LoadLaenderBAction;
import roomanizer.teamb.presentation.forms.invoice.action.LoadLaenderBAction.ILoadLaenderBDetail;
import roomanizer.teamb.presentation.forms.invoice.action.Step2Action;
import roomanizer.teamb.presentation.forms.overview.TableRowFilter;
import roomanizer.teamb.presentation.forms.overview.TableRowSorter;
import roomanizer.teamb.service.contract.controller.IInvoiceController;
import roomanizer.teamb.service.integrate.IBGast;
import roomanizer.teamb.service.integrate.IBLand;
import roomanizer.teamb.service.integrate.IBRechnungsPosition;
import roomanizer.teamb.service.integrate.IBZimmer;

/**
 * Invoice Step 1 ist der erste Screen und beinhaltet neben der Rechnungsadresse, alle Rechnungspositionen
 * @author Amann
 */
public class InvoiceStep1 extends AbstractFormInvoice implements IActionResult, Observer {

    private JCheckBox checkBoxAllItems;
    private JButton btnCancel;
    private JButton btnShowAll;
    private JComboBox comboBoxCountry;
    private JComboBox comboBoxGuests;
    private JComboBox comboBoxRoom;
    private JButton btnNext;
    private JScrollPane jScrollPane1;
    private JLabel labelAddress;
    private JLabel labelCountry;
    private JLabel labelFname;
    private JLabel labelLname;
    private JLabel labelLocation;
    private JLabel labelPLZ;
    private JPanel panelAddress;
    private JPanel panelInvoiceDetails;
    private JTable tableInvoice;
    private JTextField textFieldAddress;
    private JTextField textFieldFname;
    private JTextField textFieldLocation;
    private JTextField textFieldPLZ;
    private JTextField textFieldLname;
    private IInvoiceController controller;
    private Date fromFilter;
    private Date untilFilter;
    private TableRowSorter<AlleRechnungPostionenTableModel> sorter;
    
    /**
     * @param form
     * @param controller
     */
    public InvoiceStep1(AbstractForm form, IInvoiceController controller) {
        super(form);
        this.controller = controller;
        controller.addObserver(this);
        initControls();
    }

    private class StartController implements IStartControllerDetail {

        @Override
        public void started() {
            AlleRechnungPostionenTableModel model = new AlleRechnungPostionenTableModel(controller);
            sorter = new TableRowSorter<AlleRechnungPostionenTableModel>(model);
            tableInvoice.setModel(model);
            tableInvoice.setRowSorter(sorter);
            tableInvoice.setAutoCreateRowSorter(true);

            tableInvoice.getColumnModel().getColumn(0).setPreferredWidth(120);  //InvoiceLIne
            tableInvoice.getColumnModel().getColumn(2).setPreferredWidth(60);   //Amount
            tableInvoice.getColumnModel().getColumn(5).setPreferredWidth(120);  //Guest
            tableInvoice.getColumnModel().getColumn(6).setPreferredWidth(60);   //Room
            tableInvoice.getColumnModel().getColumn(7).setPreferredWidth(100);  //Options

            String[] g = new String[controller.getGaeste().size() + 1];
            g[0] = "";
            int i = 1;
            for (IBGast gast : controller.getGaeste()) {
                g[i] = gast.getSurname() + " " + gast.getFirstname();
                i++;
            }
            comboBoxGuests.setModel(new DefaultComboBoxModel(g));
            g = new String[controller.getZimmer().size() + 1];
            g[0] = "";
            i = 1;
            for (IBZimmer zimmer : controller.getZimmer()) {
                g[i] = zimmer.getNumber();
                i++;
            }
            comboBoxRoom.setModel(new DefaultComboBoxModel(g));
        }
    }

    private class LoadLaender implements ILoadLaenderBDetail {

        @Override
        public void setLaender(List<IBLand> laender) {
            comboBoxCountry.setModel(new DefaultComboBoxModel(laender.toArray()));
        }
    }

    private class EditInvoicePerson implements IEditInvoicePersonDetail {

        @Override
        public String getFirstname() {
            return textFieldFname.getText();
        }

        @Override
        public String getSurname() {
            return textFieldLname.getText();
        }

        @Override
        public String getPostalCode() {
            return textFieldPLZ.getText();
        }

        @Override
        public String getAddress() {
            return textFieldAddress.getText();
        }

        @Override
        public String getLocation() {
            return textFieldLocation.getText();
        }

        @Override
        public IBLand getCountry() {
            return (IBLand) comboBoxCountry.getSelectedItem();
        }
    }

    private void initControls() {
        addAction(new StartControllerAction(new StartController(), controller));
        addAction(new LoadLaenderBAction(new LoadLaender(), controller));
        addAction(new HasOpenPositionAction(controller));

        panelAddress = new JPanel();
        labelFname = new JLabel();
        labelAddress = new JLabel();
        labelLocation = new JLabel();
        textFieldFname = new JTextField();
        textFieldAddress = new JTextField();
        textFieldLocation = new JTextField();
        labelLname = new JLabel();
        labelPLZ = new JLabel();
        labelCountry = new JLabel();
        textFieldLname = new JTextField();
        textFieldPLZ = new JTextField();
        comboBoxCountry = new JComboBox();
        panelInvoiceDetails = new JPanel();
        btnShowAll = new JButton();
        jScrollPane1 = new JScrollPane();
        comboBoxRoom = new JComboBox();
        comboBoxGuests = new JComboBox();
        btnNext = new JButton();
        btnCancel = new JButton();
        checkBoxAllItems = new JCheckBox();
        tableInvoice = new JTable() {

            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                final Component c = super.prepareRenderer(renderer, row, column);
                if (c instanceof JComponent) {
                    ((JComponent) c).setOpaque(true);

                    if (row % 2 == 0) {
                        c.setBackground(Color.WHITE);
                    } else {
                        c.setBackground(new Color(0xC9, 0xE2, 0xE9));
                    }
                }
                return c;
            }
        };
        tableInvoice.setOpaque(true);
        tableInvoice.setGridColor(new Color(0, 0, 0, 0));
        tableInvoice.setShowVerticalLines(false);
        JTableHeader header = tableInvoice.getTableHeader();
        header.setBackground(Stylesheet.getButtonBG());
        header.setForeground(Color.WHITE);

        setSize(new Dimension(891, 612));
        setPreferredSize(new Dimension(891, 612));
        setResizable(false);
        
        Image img = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("logo_96.png"));
        this.setIconImage(img);

        panelAddress.setBorder(javax.swing.BorderFactory.createTitledBorder("Invoice Address"));
        labelFname.setText("Firstname");
        labelAddress.setText("Address");
        labelLocation.setText("Location");
        labelLname.setText("Surname");
        labelPLZ.setText("Postal Code");
        labelCountry.setText("Country");


        GroupLayout panelAddressLayout = new GroupLayout(panelAddress);
        panelAddress.setLayout(panelAddressLayout);
        panelAddressLayout.setHorizontalGroup(
                panelAddressLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelAddressLayout.createSequentialGroup().addContainerGap().addGroup(panelAddressLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(labelFname).addComponent(labelAddress).addComponent(labelLocation)).addGap(28, 28, 28).addGroup(panelAddressLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(textFieldAddress, GroupLayout.DEFAULT_SIZE, 200, GroupLayout.PREFERRED_SIZE).addComponent(textFieldFname, GroupLayout.DEFAULT_SIZE, 200, GroupLayout.PREFERRED_SIZE).addComponent(textFieldLocation, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE).addGroup(panelAddressLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(labelPLZ).addComponent(labelLname).addComponent(labelCountry)).addGap(18, 18, 18).addGroup(panelAddressLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(comboBoxCountry, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE).addComponent(textFieldLname, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE).addComponent(textFieldPLZ, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)).addContainerGap()));
        panelAddressLayout.setVerticalGroup(
                panelAddressLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelAddressLayout.createSequentialGroup().addContainerGap().addGroup(panelAddressLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(labelFname).addComponent(textFieldFname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(labelLname).addComponent(textFieldLname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(panelAddressLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(textFieldAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(labelAddress).addComponent(labelPLZ).addComponent(textFieldPLZ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(panelAddressLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(textFieldLocation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(labelLocation).addComponent(labelCountry).addComponent(comboBoxCountry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        panelInvoiceDetails.setBorder(BorderFactory.createTitledBorder("Invoice Detail"));
        panelInvoiceDetails.setName("Invoice Detail");

        btnShowAll.setText("ShowAll");


        tableInvoice.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableInvoice);

        checkBoxAllItems.setText("All Invoice Items");

        GroupLayout panelInvoiceDetailsLayout = new GroupLayout(panelInvoiceDetails);
        panelInvoiceDetails.setLayout(panelInvoiceDetailsLayout);
         panelInvoiceDetailsLayout.setHorizontalGroup(
            panelInvoiceDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInvoiceDetailsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelInvoiceDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInvoiceDetailsLayout.createSequentialGroup()
                        .addComponent(comboBoxGuests, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnShowAll))
                    .addComponent(checkBoxAllItems, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        panelInvoiceDetailsLayout.setVerticalGroup(
            panelInvoiceDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInvoiceDetailsLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelInvoiceDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnShowAll)
                    .addComponent(comboBoxRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxGuests, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(checkBoxAllItems))
        );

        btnNext.setText("Next");

        btnCancel.setText("Cancel");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(panelInvoiceDetails, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)).addGroup(layout.createSequentialGroup().addComponent(panelAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGap(0, 136, Short.MAX_VALUE))).addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(panelAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(panelInvoiceDetails, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(btnCancel).addComponent(btnNext)).addContainerGap()));

        panelInvoiceDetails.getAccessibleContext().setAccessibleName("");

        //Listener fÃ¼r all Invoice Items
        ActionListener allItemsListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.chooseAll(checkBoxAllItems.isSelected());
            }
        };
        checkBoxAllItems.addActionListener(allItemsListener);
        
        //Filter Guests
        ActionListener guestListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String expr = comboBoxGuests.getSelectedItem().toString();
                TableRowFilter filter = null;

                if (comboBoxGuests.getSelectedIndex() != 0) {
                    filter = new TableRowFilter("[a-zA-Z_0-9@öäüÖÄÜ-]*" + expr + "[a-zA-Z_0-9@öäüÖÄÜ-]*");

                }

                sorter.setRowFilter(filter);
                tableInvoice.setRowSorter(sorter);
            }
        };

        comboBoxGuests.addActionListener(guestListener);
        
        //Filter Zimmernummer
        ActionListener roomListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String expr = comboBoxRoom.getSelectedItem().toString();
                TableRowFilter filter = null;

                if (comboBoxRoom.getSelectedIndex() != 0) {
                    filter = new TableRowFilter("[a-zA-Z_0-9@öäüÖÄÜ-]*" + expr + "[a-zA-Z_0-9@öäüÖÄÜ-]*");
//                    expr = "[a-zA-z0-9]*";
                }

                sorter.setRowFilter(RowFilter.regexFilter(expr));
                tableInvoice.setRowSorter(sorter);
            }
        };

        comboBoxRoom.addActionListener(roomListener);
        //Remove Filter
        ActionListener removeFilterListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String expr = "[a-zA-z0-9]*";

                sorter.setRowFilter(RowFilter.regexFilter(expr));
                tableInvoice.setRowSorter(sorter);

                comboBoxGuests.setSelectedIndex(0);
                comboBoxRoom.setSelectedIndex(0);
            }
        };

        btnShowAll.addActionListener(removeFilterListener);
        ActionEventHandler handlerCancel = new ActionEventHandler(this);

        handlerCancel.add(
                new AbortControllerAction(controller));
        btnCancel.addActionListener(handlerCancel);
        //Redirect Action
        ActionEventHandler handlerNext = new ActionEventHandler(this);

        handlerNext.add(
                new Step2Action(new Step2Action.IStep2Details() {

            @Override
            public void isFailed() {
                JOptionPane.showMessageDialog(null, "Nothing is choosed!", "Choose something", JOptionPane.OK_OPTION);
            }
        }, controller));
        handlerNext.add(
                new EditInvoicePersonAction(new EditInvoicePerson(), controller));
        handlerNext.add(
                new RedirectAction(new InvoiceStep2(null, controller, this)));
        btnNext.addActionListener(handlerNext);
        RechnungsPositionCellEditor ed = new RechnungsPositionCellEditor(controller);
        DateCellEditor dEditor = new DateCellEditor();
        BigDecimalCellEditor bEditor = new BigDecimalCellEditor();
        
        tableInvoice.setDefaultEditor(Date.class, dEditor);
        tableInvoice.setDefaultEditor(BigDecimal.class, bEditor);
        
        tableInvoice.setDefaultEditor(IBRechnungsPosition.class, ed);
        tableInvoice.setDefaultRenderer(IBRechnungsPosition.class, ed);
        tableInvoice.setRowHeight(30);
        pack();
    }

    @Override
    public void fail() {
    }

    @Override
    public void success() {
        setVisible(false);
    }

    @Override
    public void update(Observable o, Object arg) {
        textFieldFname.setText(controller.getRechnung().getFirstname());
        textFieldLname.setText(controller.getRechnung().getSurname());
        textFieldAddress.setText(controller.getRechnung().getAddress());
        textFieldLocation.setText(controller.getRechnung().getLocation());
        textFieldPLZ.setText(controller.getRechnung().getPostalCode());
        comboBoxCountry.setSelectedItem(controller.getRechnung().getCountry());
    }

    @Override
    public void loadFailed() {
        JOptionPane.showMessageDialog(null, "No Open Invoice Positions", "No Open Positions", JOptionPane.ERROR_MESSAGE);
        setVisible(false);
    }

    @Override
    public void showForm() {
        super.showForm();
        controller.reload();
    }
}
