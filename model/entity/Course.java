package model.entity;
import java.text.*;
import java.util.Date;
import java.util.TimeZone;

//
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Course  {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) private Long
	id;
	@Persistent private String name;
	@Persistent private String depa;
	@Persistent private String nivel;
	@Persistent private String profe;
	@Persistent private String hab;
	@Persistent private Date date;

	public Course(String name, String depa, String nivel, String profe, String hab) {
		this.name = name;
		this.depa = depa;
		this.nivel = nivel;	
		this.profe=profe;
		this.hab=hab;
		TimeZone.setDefault(TimeZone.getTimeZone("America/Lima"));
		this.date=new Date();
		
	}
	public Course() {
		this.name = name;
		this.depa = depa;
		this.nivel = nivel;
		this.profe=profe;
		this.hab=hab;
	}
	public Long getId() {

		return id;
	}
	public String isId() {
		String td = String.valueOf(this.id);
		return td;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProfe() {
		return profe;
	}
	public void setProfe(String profe) {
		this.profe = profe;
	}
	public String getHab() {
		return hab;
	}
	public void setHab(String hab) {
		this.hab = hab;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the id
	 */

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the city
	 */
	public String getDepa() {
		return depa;
	}
	/**
	 * @param city the city to set
	 */
	public void setDepa(String depa) {
		this.depa = depa;
	}
	/**
	 * @return the state
	 */
	public String getNivel() {
		return nivel;
	}
	/**
	 * @param state the state to set
	 */
	public void setNivel(String nivel) { 
		this.nivel = nivel;
	}
	

} 