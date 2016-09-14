package me.maffew.practice;

import java.sql.*;
import java.util.UUID;

import me.maffew.practice.Main;

public class MySQL {
    private Main plugin;
    private Connection con = null;

    public MySQL(Main p) {
        this.plugin = p;
    }

    public void openConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.con = DriverManager.getConnection("jdbc:mysql://" + this.plugin.getConfig().getString("MySQL.hostname") + "/" + this.plugin.getConfig().getString("MySQL.database"), this.plugin.getConfig().getString("MySQL.username"), this.plugin.getConfig().getString("MySQL.password"));
            System.out.println("MySQL : Connected");
        } catch (Exception e) {
            System.out.println(" Error: " + e);
        }
    }

    public void getAllInfo(String username) {
        //getCurrentELO();
    }

    public void closeConnection() {
        System.out.println("MySQL : Closing connection");
        if (this.con != null) {
            try {
                this.con.close();
                System.out.println("MySQL : Closed");
            } catch (SQLException e) {
                System.out.println("MySQL : Error closing the connection");
            }
        }
    }

    public static int getCurrentELO(Connection con, String dbName, UUID uuid) throws SQLException {
        Statement stmt = null;
        String elo = "select ELO " + "from " + dbName + ".players" + " WHERE UUID = " + "'" + uuid + "'";

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(elo);
            while(rs.next()) {
                String currentELO = rs.getString("ELO");
                int ELO = Integer.parseInt(currentELO);
                return ELO;
            }
        } catch (SQLException e) {
            System.out.println("MySQL : Error getting player ELO");
        } finally {
            if(stmt != null) {
                stmt.close();
            }
        }
        return 0;
    }

    public void setPlayerELO(Connection con, String dbname, UUID uuid, int newELO) throws SQLException {



    }

	public void createTable() {
		// TODO Auto-generated method stub
		
	}
	
	public Connection getConnection() {
		
		return this.con;
		
	}


}
