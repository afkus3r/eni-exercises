package fr.eni.stationaryShop.dal;

import java.io.IOException;
import java.sql.*;
import java.util.List;

public interface DAO<T> {

    void insert(T i) throws SQLException, IOException;

    void update(T i) throws SQLException, IOException;

    void deleteById(int id) throws SQLException, IOException;

    T selectById(int id) throws SQLException, IOException;

    List<T> selectAll() throws SQLException, IOException;

}
