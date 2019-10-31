package pe.edu.upc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="events")
public class Event {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEvent;
	
	@Column(name = "name", nullable = false, length = 30)
	private String name;
	
	@Column(name = "description", nullable = false, length = 30)
	private String description;
	
	@Column(name = "salary", nullable = false, length = 30)
	private Double salary;

	public Long getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(Long idEvent) {
		this.idEvent = idEvent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	
}
