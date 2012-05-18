/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.data;

import java.util.ArrayList;
import java.util.List;

import projekt.fhv.teama.classes.rechnung.Rechnung;
import projekt.fhv.teama.hibernate.dao.personen.LandDao;
import projekt.fhv.teama.hibernate.dao.rechnung.ZahlungsmethodeDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import roomanizer.teamb.data.model.Hotel;
import roomanizer.teamb.service.contract.Hibernate.IHibernateTransaction;
import roomanizer.teamb.service.integrate.IBHotel;
import roomanizer.teamb.service.integrate.IBLand;
import roomanizer.teamb.service.integrate.IBRechnung;
import roomanizer.teamb.service.integrate.IBZahlungsmethode;
import roomanizer.teamb.service.integrate.IMapper;

/**
 *
 * @author Johannes
 */
public class IntegrateFacade {

    private static IBHotel hotel;

    public static IBHotel getHotel() {
        if (hotel == null) {
            hotel = new Hotel(new Integer(1), "Hotelstrasse 12", "8118", "Lech", "Österreich", "DE68 2105 0170 0012 3456 78", "RVVGAT2B474", "37474", "5879385", "Hotel Madlein", "05573/33168", "05573/33169", "GÃ¼nther Alois", "ATU12345678", "6830923", "guenther@alois.com");
        }
        return hotel;
    }

    public static IBRechnung getNewRechnung() {
        Rechnung rechnung = new Rechnung();
        //rechnung.setBezahlerAdresse(new Adresse());
        return rechnung;
    }

    public static List<IBZahlungsmethode> getAllZahlungsmethoden() {
        try {
			return new ArrayList<IBZahlungsmethode>(ZahlungsmethodeDao.getInstance().getAll());
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
        return  new ArrayList<IBZahlungsmethode>();
    }

    public static IHibernateTransaction getTransaction() {
        return HibernateTransaction.beginn();
    }

	public static List<IBLand> getAllLaender() {
		try {
			return new ArrayList<IBLand>(LandDao.getInstance().getAll());
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
        return  new ArrayList<IBLand>();
	}
}
