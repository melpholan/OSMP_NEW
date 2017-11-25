package ru.melpholan.entitty.reports.doctorsReports;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "QuantityOfCalls")
public class QuantityOfCalls implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idQuntityOfCalls")
    private Integer idQuantityOfCalls;

    @Column(name = "ddr_quantity")
    private Integer quantityCalls;

    // mapping to SubtypeOfDoctorsCalls
    @ManyToOne
    @JoinColumn(name = "SubtypesOfDoctorCalls_idSubtypesOfDoctorCalls", referencedColumnName = "idSubtypesOfDoctorCalls")
    private SubtypeOfDoctorsCalls subtypeOfDoctorsCalls;

    public void setSubtypeOfDoctorsCalls(SubtypeOfDoctorsCalls subtypeOfDoctorsCalls) {
        this.subtypeOfDoctorsCalls = subtypeOfDoctorsCalls;
    }

    public SubtypeOfDoctorsCalls getSubtypeOfDoctorsCalls() {
        return subtypeOfDoctorsCalls;
    }


    // constructor without parameters
    public QuantityOfCalls(){}


    // hash and equals


    // toString
    @Override
    public String toString() {
        return "QuantityOfCalls{" +
                "idQuantityOfCalls=" + idQuantityOfCalls +
                ", quantityCalls=" + quantityCalls +
                '}';
    }
}
