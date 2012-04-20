package projekt.fhv.teama.hibernate.dao;

import java.util.Set;

import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

public interface IGenericDao<T> {
	
	public T getById(int id);
	public void remove(T obj);
	public void create(T obj);
	public void update(T obj);
	public Set<T> getAll() throws NoDatabaseEntryFoundException;
	
}
