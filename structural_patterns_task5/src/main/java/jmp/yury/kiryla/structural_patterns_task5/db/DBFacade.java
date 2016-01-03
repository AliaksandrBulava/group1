/**
 * 
 */
package jmp.yury.kiryla.structural_patterns_task5.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Facade Pattern implementation
 * 
 * @author Yury
 *
 */
public class DBFacade {
    
    /**
     * {@link CreateConnectionOperations}
     */
    private CreateConnectionOperations createConnectionOperations = new CreateConnectionOperations();

    /**
     * {@link CloseOperations}
     */
    private CloseOperations closeOperations = new CloseOperations();
    
    /**
     * Create SQL Connection
     * @return {@link Connection}
     */
    public Connection createConnection() {
	createConnectionOperations.prepare();
	return createConnectionOperations.getConnection();
    }
    
    /**
     * Close SQL Connection
     * @param rs {@link ResultSet}
     * @param stmt {@link Statement}
     * @param con {@link Connection}
     */
    public void closeConnection(ResultSet rs, Statement stmt, Connection con) {
	closeOperations.closeResultSet(rs);
	closeOperations.closeStatement(stmt);
	closeOperations.closeConnection(con);
    }
}
