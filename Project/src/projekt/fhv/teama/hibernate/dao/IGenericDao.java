package projekt.fhv.teama.hibernate.dao;

import java.util.Set;

import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

public interface IGenericDao<T> {
	
	public T getById(int id)  throws DatabaseException;
	public void remove(T obj) throws DatabaseException;
	public void create(T obj) throws DatabaseException;
	public void update(T obj) throws DatabaseException;
	public Set<T> getAll() throws DatabaseException;
	
}
