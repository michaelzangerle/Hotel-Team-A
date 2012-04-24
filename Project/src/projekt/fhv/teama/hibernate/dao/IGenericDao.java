package projekt.fhv.teama.hibernate.dao;

import java.util.Set;

import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

/**
 * Interface f�r GenericDao-Klasse
 * 
 * @author Team A
 * @version 1.9
 * @param <T>
 *            Typ von IModel
 */
public interface IGenericDao<T> {

	/**
	 * Holt einen Eintrag aus der Datenbank bei dem die ID mit dem �bergebenen Parameter �bereinstimmt
	 * @param id int
	 * @return Typ von IModel
	 * @throws DatabaseException
	 */
	public T getById(int id) throws DatabaseException;

	/**
	 * Entfernt das �bergebene Objekt aus der Datenbank wenn es vorhanden ist
	 * @param obj Typ von IModel
	 * @throws DatabaseException
	 */
	public void remove(T obj) throws DatabaseException;

	/**
	 * Erstellt oder updated einen Eintrag in der Datenbank
	 * @param obj Typ von IModel
	 * @throws DatabaseException
	 */
	public void create(T obj) throws DatabaseException;

	/**
	 * Updated einen Eintrag in der Datenbank
	 * @param obj Typ von IModel
	 * @throws DatabaseException
	 */
	public void update(T obj) throws DatabaseException;

	/**
	 * Holt alle Datens�tze einer Tabelle aus der Datenbank
	 * @return Set<Typ von IModel>
	 * @throws DatabaseException
	 */
	public Set<T> getAll() throws DatabaseException;

}
