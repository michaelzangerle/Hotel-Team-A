package projekt.fhv.teama.hibernate.dao;

import java.util.List;

public interface IGenericDao<T> {
	
	public T getById(int id);
	public void removeById(int id);
	public void create(T obj);
	public void update(T obj);
	public List<T> getAll();
	
}
