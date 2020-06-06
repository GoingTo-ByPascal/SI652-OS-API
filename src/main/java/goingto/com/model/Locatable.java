package goingto.com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "locatables")
public class Locatable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name = "address",length = 100)
    private String address;

    @NotEmpty
    @Column(name = "description",length = 100)
    private String description;

    @NotEmpty
    @Column(name = "latitude")
    private Float latitude;

    @NotEmpty
    @Column(name = "longitude")
    private Float longitude;



}