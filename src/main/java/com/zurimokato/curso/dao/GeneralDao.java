package com.zurimokato.curso.dao;

import java.util.Map;

public interface GeneralDao<T> {
    T create(T t);
    void delete(Object id);
    T find(Object id);
    T update(T t);
}
