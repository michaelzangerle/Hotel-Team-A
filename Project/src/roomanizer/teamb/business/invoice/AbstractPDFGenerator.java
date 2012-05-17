/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.business.invoice;

/**
 *
 * @author Johannes
 */
public abstract class AbstractPDFGenerator implements IPDFGenerator {

    public static IPDFGenerator getGenerator() {
        return new PdfCreator();
    }
}
