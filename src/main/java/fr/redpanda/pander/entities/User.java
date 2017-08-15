/**
 * 
 */
package fr.redpanda.pander.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import fr.redpanda.pander.utils.StringManager;

/**
 * 
 * @author Gwénolé LE HENAFF
 *
 */
public abstract class User {

	protected Long id;
	protected String email;
	protected String password;
	protected String phone;
	protected String address;
	protected String postcode;
	protected String city;
	protected String photo;
	protected String description;
	protected Boolean disabled;
	protected Role role;
	protected Date createdAt;
	protected Date updatedAt;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the postcode
	 */
	public String getPostcode() {
		return postcode;
	}

	/**
	 * @param postcode
	 *            the postcode to set
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
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
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo
	 *            the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the disabled
	 */
	public Boolean isDisabled() {
		return disabled;
	}

	/**
	 * @param disabled
	 *            the disabled to set
	 */
	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt
	 *            the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt
	 *            the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * 
	 */
	public User() {
		super();
	}

	/**
	 * @param email
	 */
	public User(String email) {
		super();
		this.setEmail(email);
		this.setDisabled(false);
	}

	/**
	 * @param result
	 *            the result set to parse
	 * @throws SQLException
	 */
	public User(ResultSet result) throws SQLException {
		super();
		this.setId(result.getLong("id"));
		this.setEmail(result.getString("email"));
		this.setPassword(result.getString("password"));
		this.setPhone(result.getString("phone"));
		this.setAddress(result.getString("address"));
		this.setPostcode(result.getString("postcode"));
		this.setCity(result.getString("city"));
		this.setPhoto(result.getString("photo"));
		this.setDescription(result.getString("description"));
		this.setDisabled(result.getBoolean("disabled"));
		this.setRole(StringManager.getRoleFrom(result.getString("role")));
		this.setCreatedAt(new Date(result.getDate("created_at").getTime()));
		this.setUpdatedAt(new Date(result.getDate("updated_at").getTime()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return email;
	}

}
