package goingto.com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "places")
public class Place {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty
	@Column(name = "name", length = 45)
	private String name;
	@NotEmpty
	@Column(name = "stars")
	private String stars;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	@OneToOne
	@JoinColumn(name="locatable_id")
	private Locatable locatable;
}
