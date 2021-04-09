package com.mobiledocker.mobiledocker.Dao;





import java.util.List;
import java.util.Map;


import com.mobiledocker.mobiledocker.entity.Pagination;

public interface GenericRepository<T> {

	public void setEntity(Class<T> clazz);

    public T get(Long id);

    public List<T> findAllByColumn(String column, Object value);

    public List<T> findAllByColumn(Pagination pagination, String column, Object value);

    public T findByColumn(String column, Object value);

    public T save(T object);

    public void setDeleted(Long id);

    public void update(Map<String, Object> object, Long id);

    public List<T> list();

    public void sort(List<T> data, String column);

    public List<T> list(int offset, int limit);

    
}
