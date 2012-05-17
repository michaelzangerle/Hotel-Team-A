/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.data;

import java.util.HashMap;

import projekt.fhv.teama.classes.rechnung.Rechnung;
import projekt.fhv.teama.classes.rechnung.Rechnungsposition;
import projekt.fhv.teama.classes.rechnung.Teilzahlung;
import projekt.fhv.teama.hibernate.dao.rechnung.RechnungDao;
import projekt.fhv.teama.hibernate.dao.rechnung.RechnungspositionDao;
import projekt.fhv.teama.hibernate.dao.rechnung.TeilzahlungDao;
import roomanizer.teamb.service.integrate.IMapper;

/**
 *
 * @author Johannes
 */
public class PersistanceFacade {
    
    private static PersistanceFacade instance;
    
    public static PersistanceFacade getInstance() {
        if (instance == null) {
            instance = new PersistanceFacade();
        }
        return instance;
    }
    HashMap<Class, IMapper> mappers = new HashMap<>();
    
    private PersistanceFacade() {
        mappers.put(Rechnungsposition.class, RechnungspositionDao.getInstance());
        mappers.put(Rechnung.class, RechnungDao.getInstance());
        mappers.put(Teilzahlung.class, TeilzahlungDao.getInstance());
    }
    
    public IMapper getMapper(Class cl) {
        return mappers.get(cl);
    }
}
