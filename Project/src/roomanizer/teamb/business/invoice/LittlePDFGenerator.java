/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.business.invoice;

import roomanizer.teamb.service.integrate.IBRechnung;

/**
 *
 * @author Johannes
 */
public class LittlePDFGenerator extends AbstractPDFGenerator implements IPDFGenerator {

    @Override
    public void create(String filename, IBRechnung rechnung) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void createPreview(String filename, IBRechnung rechnung) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
