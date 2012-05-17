
package roomanizer.teamb.data;

import javax.transaction.Synchronization;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.engine.transaction.spi.LocalStatus;

import projekt.fhv.teama.hibernate.HibernateHelper;
import roomanizer.teamb.service.contract.Hibernate.IHibernateTransaction;

/**
 *
 * @author Johannes
 */
public class HibernateTransaction implements IHibernateTransaction {

    /**
     * 
     * @return
     */
    public static HibernateTransaction beginn() {
        Session s = HibernateHelper.getSession();
        return new HibernateTransaction(s.beginTransaction());
    }
    private Transaction tx;

    /**
     * 
     * @param transaction
     */
    public HibernateTransaction(Transaction transaction) {
        this.tx = transaction;
    }

    @Override
    public void begin() throws HibernateException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void commit() throws HibernateException {
        tx.commit();
    }

    @Override
    public void rollback() throws HibernateException {
        tx.rollback();
    }

    @Override
    public boolean wasRolledBack() throws HibernateException {
        return tx.wasRolledBack();
    }

    @Override
    public boolean wasCommitted() throws HibernateException {
        return tx.wasCommitted();
    }

    @Override
    public boolean isActive() throws HibernateException {
        return tx.isActive();
    }

    @Override
    public void registerSynchronization(Synchronization s) throws HibernateException {
        tx.registerSynchronization(s);
    }

    @Override
    public void setTimeout(int i) {
        tx.setTimeout(i);
    }

    @Override
    public void saveOrUpdate(Object m) {
        Session s = HibernateHelper.getSession();
        s.saveOrUpdate(m);
    }

	@Override
	public LocalStatus getLocalStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTimeout() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isInitiator() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isParticipating() {
		// TODO Auto-generated method stub
		return false;
	}
}
