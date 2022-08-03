package fr.eni.stationaryShop.dal;

import fr.eni.stationaryShop.bo.Item;
import fr.eni.stationaryShop.bo.Pen;
import fr.eni.stationaryShop.bo.Ream;
import fr.eni.stationaryShop.dal.jdbc.JdbcTools;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {

    void insert(Item i) throws SQLException, IOException {
        Connection con = JdbcTools.getConnection();

        PreparedStatement stmt = con.prepareStatement("INSERT INTO Item (itemID, reference, brand, designation, unitaryPrice, stockQty, weight) VALUES (?, ?, ?, ?, ?, ?, ?)");
        stmt.setInt(1, i.getItemID());
        stmt.setString(2, i.getRef());
        stmt.setString(3, i.getBrand());
        stmt.setString(4, i.getDesignation());
        stmt.setFloat(5, i.getUnitaryPrice());
        stmt.setInt(6, i.getStockQty());
        if (i instanceof Ream) {
            Ream iR = (Ream) i;
            stmt.setInt(7, iR.getWeight());
        } else if (i instanceof Pen) {
            Pen iP = (Pen) i;
            stmt.setString(7, iP.getColor());
        }
        stmt.close();
        con.close();
    }

    void update(Item i) throws SQLException, IOException {
        Connection con = JdbcTools.getConnection();

        PreparedStatement stmt = con.prepareStatement("UPDATE Item SET itemID = ?, reference = ?, brand = ?, designation = ?, unitaryPrice = ?, stockQty = ?, weight = ?");
        stmt.setInt(1, i.getItemID());
        stmt.setString(2, i.getRef());
        stmt.setString(3, i.getBrand());
        stmt.setString(4, i.getDesignation());
        stmt.setFloat(5, i.getUnitaryPrice());
        stmt.setInt(6, i.getStockQty());
        if (i instanceof Ream) {
            Ream iR = (Ream) i;
            stmt.setInt(7, iR.getWeight());
        }
        if (i instanceof Pen) {
            Pen iP = (Pen) i;
            stmt.setString(7, iP.getColor());
        }
        stmt.close();
        con.close();
    }

    void deleteById(int id) throws SQLException, IOException {
        Connection con = JdbcTools.getConnection();

        Statement stmt = con.createStatement();

        ResultSet result = stmt.executeQuery("DELETE FROM Items WHERE itemID = id");

        result.close();
        stmt.close();
        con.close();
    }

    Item selectById(int id) throws SQLException, IOException {
        Item item = null;

        Connection con = JdbcTools.getConnection();

        Statement stmt = con.createStatement();

        ResultSet result = stmt.executeQuery("SELECT itemID, reference, brand, designation, unitaryPrice, stockQty, weight, color FROM Items WHERE itemID = id");

        if (result.getInt(weight)) {
            item = new Ream(result.getInt(itemID), result.getString(reference), result.getString(brand), result.getString(designation), result.getFloat(unitaryPrice), result.getInt(stockQty), result.getInt(weight));
        } else if (result.getString(color)) {
            item = new Pen(result.getInt(itemID), result.getString(reference), result.getString(brand), result.getString(designation), result.getFloat(unitaryPrice), result.getInt(stockQty), result.getString(color));
        }

        result.close();
        stmt.close();
        con.close();

        return item;
    }

    List<Item> selectAll() throws SQLException, IOException {
        List<Item> itemsList = new ArrayList<>();

        Connection con = JdbcTools.getConnection();

        Statement stmt = con.createStatement();

        ResultSet result = stmt.executeQuery("SELECT itemID, reference, brand, designation, unitaryPrice, stockQty, weight, color FROM Items");

        while (result.next()) {
            if (result.getInt(weight)) {
                Item i = new Ream(result.getInt(itemID), result.getString(reference), result.getString(brand), result.getString(designation), result.getFloat(unitaryPrice), result.getInt(stockQty), result.getInt(weight));
                itemsList.add(i);
            } else if (result.getString(color)) {
                Item i = new Pen(result.getInt(itemID), result.getString(reference), result.getString(brand), result.getString(designation), result.getFloat(unitaryPrice), result.getInt(stockQty), result.getString(color));
                itemsList.add(i);
            }
        }

        result.close();
        stmt.close();
        con.close();

        return itemsList;
    }

}
