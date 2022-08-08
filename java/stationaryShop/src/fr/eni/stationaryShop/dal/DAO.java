package fr.eni.stationaryShop.dal;

import fr.eni.stationaryShop.bo.Item;

import java.io.IOException;
import java.sql.*;
import java.util.List;

public interface ItemDAO {

    void insert(Item i) throws SQLException, IOException;

    void update(Item i) throws SQLException, IOException;

    void deleteById(int id) throws SQLException, IOException;

    Item selectById(int id) throws SQLException, IOException;

    List<Item> selectAll() throws SQLException, IOException;

}
