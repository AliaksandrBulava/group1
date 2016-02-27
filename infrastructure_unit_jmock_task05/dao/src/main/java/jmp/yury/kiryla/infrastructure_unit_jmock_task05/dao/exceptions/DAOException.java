/**
 * 
 */
package jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao.exceptions;

import java.sql.SQLException;

/**
 * DAO Exception
 * 
 * @author Yury
 *
 */
public class DAOException extends RuntimeException {

    /**
     * Eclipse generated
     */
    private static final long serialVersionUID = 1320019258391551059L;

    /**
     * @param message
     */
    public DAOException(String message) {
	super(message);
    }

    /**
     * Constructor
     * 
     * @param message
     *            Error message
     * @param cause
     *            {@link SQLException}
     */
    public DAOException(String message, SQLException cause) {
	super(message, cause);
    }
}
