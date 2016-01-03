/**
 * 
 */
package jmp.yury.kiryla.structural_patterns_task5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jmp.yury.kiryla.structural_patterns_task5.db.DBFacade;

/**
 * Main class
 * 
 * @author Yury
 *
 */
public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
	DBFacade facade = new DBFacade();
	
	Connection con = null;
	PreparedStatement ps = null;	
	
	try {
	    con = facade.createConnection();
	    ps = con.prepareStatement("CREATE TABLE NAMES(NAME VARCHAR(50))");
	    ps.execute();
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    facade.closeConnection(null, ps, con);
	}

    }

}
