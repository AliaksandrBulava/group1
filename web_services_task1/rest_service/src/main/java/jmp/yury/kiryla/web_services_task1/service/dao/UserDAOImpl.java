/**
 * 
 */
package jmp.yury.kiryla.web_services_task1.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import jmp.yury.kiryla.web_services_task1.beans.User;

/**
 * {@link UserDAO} implementation
 * 
 * @author Yury_Kiryla
 *
 */
public class UserDAOImpl implements UserDAO {
	
	/**
	 * {@link DataSource}
	 */
	@Resource(name="jdbc/rest_db")
	private DataSource ds;

	/**
	 * @see jmp.yury.kiryla.web_services_task1.service.dao.UserDAO#create(jmp.yury.kiryla.web_services_task1.beans.User)
	 */
	@Override
	public void create(User user) {
		try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement("", Statement.RETURN_GENERATED_KEYS)){
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getLogin());
			ps.setString(4, user.getEmail());
			
			if (ps.executeUpdate() > 0) {
				try (ResultSet rs = ps.getGeneratedKeys()) {
					if (rs.next()) {
						user.setId(rs.getLong(1));
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see jmp.yury.kiryla.web_services_task1.service.dao.UserDAO#getUserById(long)
	 */
	@Override
	public User getUserById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see jmp.yury.kiryla.web_services_task1.service.dao.UserDAO#getAll()
	 */
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see jmp.yury.kiryla.web_services_task1.service.dao.UserDAO#update(jmp.yury.kiryla.web_services_task1.beans.User)
	 */
	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see jmp.yury.kiryla.web_services_task1.service.dao.UserDAO#delete(jmp.yury.kiryla.web_services_task1.beans.User)
	 */
	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

}
