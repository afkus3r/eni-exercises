package fr.eni.stationaryShop.dal.jdbc;

import fr.eni.stationaryShop.bo.Item;
import fr.eni.stationaryShop.bo.Pen;
import fr.eni.stationaryShop.bo.Ream;
import fr.eni.stationaryShop.dal.ItemDAO;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ItemDAOJdbcImpl implements ItemDAO {

    @Override
    public void insert(Item i) throws SQLException, IOException {
        Connection con = JdbcTools.getConnection();

        PreparedStatement stmt = con.prepareStatement("INSERT INTO Items (reference, brand, designation, unitaryPrice, stockQty, weight, color, type) VALUES (?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, i.getRef());
        stmt.setString(2, i.getBrand());
        stmt.setString(3, i.getDesignation());
        stmt.setFloat(4, i.getUnitaryPrice());
        stmt.setInt(5, i.getStockQty());
        if (i instanceof Ream) {
            Ream iR = (Ream) i;
            stmt.setInt(6, iR.getWeight());
            stmt.setNull(7, Types.INTEGER);
            stmt.setString(8, "Ream");
        } else if (i instanceof Pen) {
            Pen iP = (Pen) i;
            stmt.setString(7, iP.getColor());
            stmt.setNull(6, Types.VARCHAR);
            stmt.setString(8, "Pen");
        }

        stmt.execute();

        ResultSet lastItem = stmt.getGeneratedKeys();
        lastItem.next();
        i.setItemID(lastItem.getInt(1));

        stmt.close();
        con.close();
    }

    @Override
    public void update(Item i) throws SQLException, IOException {
        Connection con = JdbcTools.getConnection();

        PreparedStatement stmt = con.prepareStatement("UPDATE Items SET reference = ?, brand = ?, designation = ?, unitaryPrice = ?, stockQty = ?, weight = ?, color = ?, type = ?");
        stmt.setString(1, i.getRef());
        stmt.setString(2, i.getBrand());
        stmt.setString(3, i.getDesignation());
        stmt.setFloat(4, i.getUnitaryPrice());
        stmt.setInt(5, i.getStockQty());
        if (i instanceof Ream) {
            Ream iR = (Ream) i;
            stmt.setInt(6, iR.getWeight());
            stmt.setNull(7, Types.INTEGER);
            stmt.setString(8, "Ream");
        }
        if (i instanceof Pen) {
            Pen iP = (Pen) i;
            stmt.setString(7, iP.getColor());
            stmt.setNull(6, Types.VARCHAR);
            stmt.setString(8, "Pen");
        }
        stmt.close();
        con.close();
    }

    @Override
    public void deleteById(int id) throws SQLException, IOException {
        Connection con = JdbcTools.getConnection();

        Statement stmt = con.createStatement();

        stmt.execute("DELETE FROM Items WHERE itemID = " + id);

        stmt.close();
        con.close();
    }

    @Override
    public Item selectById(int id) throws SQLException, IOException {
        Item item = null;

        Connection con = JdbcTools.getConnection();

        Statement stmt = con.createStatement();

        ResultSet result = stmt.executeQuery("SELECT itemID, reference, brand, designation, unitaryPrice, stockQty, weight, color, type FROM Items WHERE itemID = " + id);

        result.next();
        String type = result.getString("type");

        if (Objects.equals(type, "Ream")) {
            item = new Ream(result.getInt("itemID"), result.getString("reference"), result.getString("brand"), result.getString("designation"), result.getFloat("unitaryPrice"), result.getInt("stockQty"), result.getInt("weight"));
        } else {
            item = new Pen(result.getInt("itemID"), result.getString("reference"), result.getString("brand"), result.getString("designation"), result.getFloat("unitaryPrice"), result.getInt("stockQty"), result.getString("color"));
        }

        result.close();
        stmt.close();
        con.close();

        return item;
    }

    @Override
    public List<Item> selectAll() throws SQLException, IOException {
        List<Item> itemsList = new ArrayList<>();

        Connection con = JdbcTools.getConnection();

        Statement stmt = con.createStatement();

        ResultSet result = stmt.executeQuery("SELECT itemID, reference, brand, designation, unitaryPrice, stockQty, weight, color, type FROM Items");

        String type = "";

        while (result.next()) {
            type = result.getString("type");
            if (Objects.equals(type, "Ream")) {
                Item i = new Ream(result.getInt("itemID"), result.getString("reference"), result.getString("brand"), result.getString("designation"), result.getFloat("unitaryPrice"), result.getInt("stockQty"), result.getInt("weight"));
                itemsList.add(i);
            } else {
                Item i = new Pen(result.getInt("itemID"), result.getString("reference"), result.getString("brand"), result.getString("designation"), result.getFloat("unitaryPrice"), result.getInt("stockQty"), result.getString("color"));
                itemsList.add(i);
            }
        }

        result.close();
        stmt.close();
        con.close();

        return itemsList;
    }

}
