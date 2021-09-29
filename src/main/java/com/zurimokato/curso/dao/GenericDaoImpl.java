package com.zurimokato.curso.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

public class GenericDaoImpl<T>  implements GeneralDao<T>{
    @PersistenceContext
    protected EntityManager em;
    private Class<T> type;

    public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }



    @Override
    public T create(T t) {
        this.em.persist(t);

        return t;
    }

    @Override
    public void delete(Object id) {
        this.em.remove(id);
    }

    @Override
    public T find(Object id) {

        return (T) this.em.find(type,id);
    }

    @Override
    public T update(T t) {
        return this.em.merge(t);
    }
}
