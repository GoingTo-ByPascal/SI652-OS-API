package goingto.com.model.interaction;

import goingto.com.model.business.Partner;
import goingto.com.model.business.Service;
import goingto.com.model.geographic.Locatable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "partner_services")
public class PartnerService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name = "points")
    private Float points;

    @OneToOne
    @JoinColumn(name = "locatable_id")
    private Locatable locatable;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    @ManyToOne
    @JoinColumn(name = "partner_id")
    private Partner partner;


}
