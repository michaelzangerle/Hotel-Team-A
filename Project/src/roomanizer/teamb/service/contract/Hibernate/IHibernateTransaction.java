package roomanizer.teamb.service.contract.Hibernate;

import javax.transaction.Synchronization;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

/**
 * Beschreibt einen Wrapper für eine Hibernate Transaction
 *
 * @author Johannes
 */
public interface IHibernateTransaction extends Transaction {

    /**
     * Speicher ein Objekt
     *
     * @param m Model-Objekt das gespeichert wird
     */
    public void saveOrUpdate(Object m);

    /**
     * Startet eine Transaction
     *
     * @throws HibernateException
     */
    @Override
    public void begin() throws HibernateException;

    /**
     * Beendet eine Transaction
     *
     * @throws HibernateException
     */
    @Override
    public void commit() throws HibernateException;

    /**
     * Bricht eine Transaction ab und stellt den vorherigen Zustand wieder her
     *
     * @throws HibernateException
     */
    @Override
    public void rollback() throws HibernateException;

    /**
     * Wurde die Transaction abgebrochen
     *
     * @return
     * @throws HibernateException
     */
    @Override
    public boolean wasRolledBack() throws HibernateException;

    /**
     * Wurde die Transaction Beendet
     *
     * @return
     * @throws HibernateException
     */
    @Override
    public boolean wasCommitted() throws HibernateException;

    /**
     * Ist die Transaction Aktiv
     *
     * @return
     * @throws HibernateException
     */
    @Override
    public boolean isActive() throws HibernateException;

    /**
     * ???
     *
     * @param s
     * @throws HibernateException
     */
    @Override
    public void registerSynchronization(Synchronization s) throws HibernateException;

    /**
     * Setzt das Hibernate Timeout für die Transaction
     *
     * @param i Zeit in Milisekunden
     */
    @Override
    public void setTimeout(int i);
}
