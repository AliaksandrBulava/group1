package jmp.yury.kiryla.jpa_task1.beans;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Employee home address
 * 
 * @author Yury_Kiryla
 *
 */
@Embeddable
public class Address {

	/**
	 * Country
	 */
	@Column(name="a_country", nullable=false)
	private String country;

	/**
	 * State
	 */
	@Column(name="a_state")
	private String state;

	/**
	 * City
	 */
	@Column(name="a_city", nullable=false)
	private String city;

	/**
	 * Street
	 */
	@Column(name="a_street")
	private String street;

	/**
	 * Home
	 */
	@Column(name="a_home")
	private String home;

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street
	 *            the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the home
	 */
	public String getHome() {
		return home;
	}

	/**
	 * @param home
	 *            the home to set
	 */
	public void setHome(String home) {
		this.home = home;
	}

}
