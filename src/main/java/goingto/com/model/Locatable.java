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

@Entity
@Table(name = "locatables")
public class Locatable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Column(name = "description",length = 100)
    private String description;
    @NotEmpty
    @Column(name = "address",length = 100)
    private String address;
    @NotEmpty
    @Column(name = "latitude")
    private float latitude;
    @NotEmpty
    @Column(name = "longitude")
    private float longitude;
    

	public Locatable() {
	}
	public Locatable(Long id, @NotEmpty String description, @NotEmpty String address, @NotEmpty float latitude,
			@NotEmpty float longitude) {
		this.id = id;
		this.description = description;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	@OneToOne
	@JoinColumn(name="reviewable_id")
	private Reviewable reviewable;

}