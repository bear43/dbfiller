package com.hiber;

import com.hiber.dbclasses.Department;

import java.util.List;

public interface DAO
{
    int save(Object obj) throws Exception;
    void update(Object obj) throws Exception;
    void delete(Object obj) throws Exception;
    <T> T findById(Class clazz, int id) throws Exception;
    List<Object> findAll(Class clazz, String tablename) throws Exception;
}
