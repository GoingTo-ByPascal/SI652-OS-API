package goingto.com.model.geographic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

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
	private Integer stars;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	@OneToOne
	@JoinColumn(name="locatable_id")
	private Locatable locatable;

	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "place_categories",
			joinColumns = {@JoinColumn(name = "place_id")},
			inverseJoinColumns = {@JoinColumn(name = "category_id")})
	@JsonIgnore
	List<Category> categories;
}
