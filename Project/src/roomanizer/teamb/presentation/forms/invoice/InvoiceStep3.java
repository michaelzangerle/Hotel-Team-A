/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.presentation.forms.invoice;

import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
import com.sun.pdfview.PDFPrintPage;
import com.sun.pdfview.PagePanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import roomanizer.teamb.business.BusinessFactory;
import roomanizer.teamb.presentation.action.RedirectAction;
import roomanizer.teamb.presentation.basic.AbstractFormInvoice;
import roomanizer.teamb.presentation.basic.IActionResult;
import roomanizer.teamb.presentation.eventhandler.ActionEventHandler;
import roomanizer.teamb.presentation.forms.invoice.action.HasOpenPositionAction;
import roomanizer.teamb.service.contract.controller.IInvoiceController;
import roomanizer.teamb.service.contract.controller.IInvoiceController.IInvoiceAddress;
import roomanizer.teamb.service.integrate.*;

/**
 *
 * @author Amann
 */
public class InvoiceStep3 extends AbstractFormInvoice implements IActionResult, Observer {

    private PagePanel pdfPanel;
    private PDFFile pdfFile;
    private JButton btnFinish;
    private JButton btnPrevPage;
    private JButton btnNextPage;
    private JButton btnPrint;
    private JButton btnNew;
    private JLabel labelPageXFromY;
    private static int pageNr;
    private static int totalPages = 0;
    private IInvoiceController controller;

    public InvoiceStep3(IInvoiceController controller) {
        this.controller = controller;
    }

    private void initControls() throws IOException {
        setName("Preview");
        setSize(new Dimension(891, 612));
        setPreferredSize(new Dimension(891, 612));
        setResizable(false);
        setLayout(new BorderLayout());
        pageNr = 0;
        showPDF(pageNr);
        
        labelPageXFromY = new JLabel("Page "+(pageNr+1) + " from "+ totalPages);

        btnNextPage = new JButton(">");
        if(totalPages > 1){      
            btnNextPage.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //setzt zähler hinauf um auf nächste seite zu gelangen
                    if (pageNr < totalPages - 1) {
                        pageNr++;
                        try {
                            showPDF(pageNr);
                            labelPageXFromY.repaint();
                        } catch (IOException ex) {
                            Logger.getLogger(InvoiceStep3.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });
        }
        else{
            btnNextPage.setEnabled(false);
        }

        btnPrevPage = new JButton("<");
        if(pageNr != 0){    
            btnPrevPage.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    //setzt zähler hinab um auf vorige seite zu gelangen
                    if (pageNr > 0) {
                        pageNr--;
                        try {
                            showPDF(pageNr);
                            labelPageXFromY.repaint();
                        } catch (IOException ex) {
                            Logger.getLogger(InvoiceStep3.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });
        }
        else{
            btnPrevPage.setEnabled(false);
        }

        btnNew = new JButton("New");
        ActionEventHandler newhandler = new ActionEventHandler(new IActionResult() {

            @Override
            public void fail() {
                JOptionPane.showMessageDialog(null, "No Open Invoice Positions", "No Open Positions", JOptionPane.ERROR_MESSAGE);
            }

            @Override
            public void success() {
                setVisible(false);
            }
        });
        newhandler.add(new HasOpenPositionAction(controller));
        newhandler.add(new RedirectAction(new InvoiceStep1(null, BusinessFactory.newInvoiceController(controller.getReservierung(), controller.getGast()))));
        btnNew.addActionListener(newhandler);

        btnPrint = new JButton("Print");
        btnPrint.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    printPDF();
                } catch (PrinterException ex) {
                    Logger.getLogger(InvoiceStep3.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Could not print this file", "Printing Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnFinish = new JButton("Finish");
        btnFinish.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                success();
            }
        });

        JPanel btnPanel = new JPanel();
        btnPanel.add(btnPrevPage);
        btnPanel.add(labelPageXFromY);
        btnPanel.add(btnNextPage);
        btnPanel.add(btnPrint);
        btnPanel.add(btnNew);
        btnPanel.add(btnFinish);
        this.add(btnPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public void printPDF() throws PrinterException {
        PDFPrintPage pages = new PDFPrintPage(pdfFile);

        // Create Print Job
        PrinterJob pjob = PrinterJob.getPrinterJob();
        PageFormat pf = PrinterJob.getPrinterJob().defaultPage();
        pjob.setJobName("Invoice");
        Book book = new Book();
        book.append(pages, pf, pdfFile.getNumPages());
        pjob.setPageable(book);

        // Send print job to default printer
        pjob.print();
    }

    @Override
    public void showForm() {
        super.showForm();
        try {
            initControls();
        } catch (IOException ex) {
            Logger.getLogger(InvoiceStep3.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Opening PDF-File failed!", "Nothing to open, go back and try again", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void showPDF(int pageNr) throws IOException {
        pdfPanel = new PagePanel();

        //load a pdf from a byte buffer
        RandomAccessFile raf = new RandomAccessFile(new File(controller.getFileName()), "r");
        FileChannel channel = raf.getChannel();
        ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
        pdfFile = new PDFFile(buf);

        if (totalPages == 0) {
            totalPages = pdfFile.getNumPages();
        }

        this.add(pdfPanel, BorderLayout.CENTER);
        setVisible(true);

        // show the first page
        PDFPage page = pdfFile.getPage(pageNr);
        pdfPanel.showPage(page);
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
    }
}
