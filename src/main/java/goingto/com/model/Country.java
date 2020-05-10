package goingto.com.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Column(name = "short_name",length = 3)
    private String shortName;
    @NotEmpty
    @Column(name = "full_name",length = 100)
    private String fullName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    
    public Locatable getLocatable() {
		return locatable;
	}

	public void setLocatable(Locatable locatable) {
		this.locatable = locatable;
	}

	public Country(Long id, @NotEmpty String shortName, @NotEmpty String fullName, Locatable locatable) {
		super();
		this.id = id;
		this.shortName = shortName;
		this.fullName = fullName;
		this.locatable = locatable;
	}


	@OneToOne
	@JoinColumn(name = "locatable_id")
	private Locatable locatable;

}