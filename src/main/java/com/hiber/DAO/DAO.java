package com.hiber.DAO;

import java.io.Closeable;

public interface DAO extends Closeable
{
    void create(Object obj);

    <T> T read(T obj);

    void update(Object obj);

    void delete(Object obj);
}
