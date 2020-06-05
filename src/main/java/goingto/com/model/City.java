package goingto.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "cities")
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty
	@Column(name = "name", length = 45)
	private String name;
	public String getName() {
		return name;
	}
	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;
	@OneToOne
	@JoinColumn(name = "locatable_id")
	private Locatable locatable;

}