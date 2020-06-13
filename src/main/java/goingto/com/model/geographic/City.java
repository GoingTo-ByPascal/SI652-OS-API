package goingto.com.model.geographic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import goingto.com.model.AuditModel;
import goingto.com.model.geographic.Country;
import goingto.com.model.geographic.Locatable;
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
@Data@NoArgsConstructor@AllArgsConstructor
@Entity
@Table(name = "cities")
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty
	@Column(name = "name", length = 45)
	private String name;

	@ManyToOne
	@JoinColumn(name = "country_id")
	@JsonIgnore
	private Country country;

	@OneToOne
	@JoinColumn(name = "locatable_id")
	@JsonIgnore
	private Locatable locatable;

}