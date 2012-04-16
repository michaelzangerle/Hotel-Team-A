package projekt.fhv.teama.hibernate.dao;

import java.util.List;

import projekt.fhv.teama.hibernate.exceptions.DatabaseNotFoundException;

public interface IGenericDao<T> {
	
	public T getById(int id);
	public void removeById(int id);
	public void create(T obj);
	public void update(T obj);
	public List<T> getAll() throws DatabaseNotFoundException;
	
}
