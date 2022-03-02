package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author sqlitetutorial.net
 */
public class Insert {

    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/film.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * Insert a new row into the warehouses table
     *
     * @param name
     * @param capacity
     */
    public void insert(String moviename, String actor,String actress,int yearofrelease,String directorname) {
        String sql = "INSERT INTO movies(moviename,actor,actress,yearofrelease,directorname) VALUES(?,?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, moviename);
            pstmt.setString(2, actor);
            pstmt.setString(3, actress);
            pstmt.setInt(4, yearofrelease);
            pstmt.setString(5, directorname);

            pstmt.executeUpdate();
		System.out.println("Inserted successful");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Insert app = new Insert();
        // insert three new rows
        app.insert("raw","vijay","asin",2012,"vimal");
        app.insert("balan","suriya","asin",2015,"vimal");
        app.insert("valimai","ajith","nayan",2022,"vimal");
        app.insert("kodi","vijay","asin",2010,"vimal");
        app.insert("et","vijay","asin",2011,"vimal");    }

}