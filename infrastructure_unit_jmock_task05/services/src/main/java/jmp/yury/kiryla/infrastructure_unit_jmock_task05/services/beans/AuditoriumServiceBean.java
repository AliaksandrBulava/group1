/**
 * 
 */
package jmp.yury.kiryla.infrastructure_unit_jmock_task05.services.beans;

import java.util.List;

import jmp.yury.kiryla.infrastructure_unit_jmock_task05.beans.Auditorium;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao.AuditoriumDAO;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.services.AuditoriumService;

/**
 * {@link AuditoriumService} implementation
 * 
 * @author Yury
 *
 */
public class AuditoriumServiceBean implements AuditoriumService {
    /**
     * {@link AuditoriumDAO}
     */
    private AuditoriumDAO auditoriumDAO;

    /**
     * @param auditoriumDAO {@link AuditoriumDAO}
     */
    public AuditoriumServiceBean(AuditoriumDAO auditoriumDAO) {
	super();
	this.auditoriumDAO = auditoriumDAO;
    }

    /**
     * @see jmp.yury.kiryla.infrastructure_unit_jmock_task05.services.AuditoriumService#register(java.lang.String)
     */
    @Override
    public Auditorium register(String name) {
	if (name != null && !name.isEmpty() && auditoriumDAO.getAuditorium(name) == null) {
	    Auditorium auditorium = new Auditorium();
	    auditorium.setName(name);
	    auditoriumDAO.saveAuditorium(auditorium);
	    return auditorium;
	}
	return null;
    }

	/**
	 * @see jmp.yury.kiryla.infrastructure_unit_jmock_task05.services.AuditoriumService#getAll()
	 */
	@Override
	public List<Auditorium> getAll() {
		return auditoriumDAO.getAuditoriums();
	}

	/**
	 * @see jmp.yury.kiryla.infrastructure_unit_jmock_task05.services.AuditoriumService#get(long)
	 */
	@Override
	public Auditorium get(long id) {
		return auditoriumDAO.getAuditorium(id);
	}

    
}
