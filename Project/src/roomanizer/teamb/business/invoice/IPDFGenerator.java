/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.business.invoice;

import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import roomanizer.teamb.service.integrate.IBRechnung;

/**
 *
 * @author Johannes
 */
public interface IPDFGenerator {

    void create(String filename, IBRechnung rechnung) throws FileNotFoundException, DocumentException;

    void createPreview(String filename, IBRechnung rechnung);
}
