package roomanizer.teamb.business;

import roomanizer.teamb.business.controller.InvoiceController;
import roomanizer.teamb.service.contract.controller.IInvoiceController;
import roomanizer.teamb.service.integrate.IBGast;
import roomanizer.teamb.service.integrate.IBKonsument;

/**
 * Erzeugt Objekte (oder gibt die Singleton-Objekte zurück) die für die
 * Presentation-Schicht notwendig sind
 *
 * @author Johannes
 */
public class BusinessFactory {

    /**
     * Erstellt ein neuer NewGuestController
     *
     * @return NewGuest-Controller
     */
    public static IInvoiceController newInvoiceController(IBKonsument reservierung, IBGast gast) {
        return new InvoiceController(reservierung, gast);
    }
}
