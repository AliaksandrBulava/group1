/**
 * 
 */
package jmp.yury.kiryla.infrastructure_build_maven_gradle.dao.exceptions;

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
