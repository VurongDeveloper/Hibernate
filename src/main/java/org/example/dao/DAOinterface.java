package org.example.dao;

import org.hibernate.SessionFactory;

import java.util.ArrayList;

public interface DAOinterface <T>{
    public int insert (T t, SessionFactory factory);

    public int update (T t, SessionFactory factory);

    public int delete (T t, SessionFactory factory);

    public ArrayList<T> selectAll (SessionFactory factory);

    public T selectById (int idSelect, SessionFactory factory);

    public ArrayList<T> selectByCondition (String condition, SessionFactory factory);


}
