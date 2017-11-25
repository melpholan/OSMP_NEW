package ru.melpholan.entitty.reports.doctorsReports;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SubtypesOfDoctorCalls")
public class SubtypeOfDoctorsCalls implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSubtypesOfDoctorCalls")
    private Integer idSubtyperOfDoctorsCalls;

    @Column(name = "name_of_subtype_doctors_calls")
    private String nameOfSubtypeDoctorsCalls;

    // mapping to TypeOfDoctorsCalls
    @ManyToOne
    @JoinColumn(name = "TypeOfDoctorsCalls_idCalls",referencedColumnName = "idCalls")
    private TypeOfDoctorsCalls typeOfDoctorsCalls;

    public void setTypeOfDoctorsCalls(TypeOfDoctorsCalls type){
        this.typeOfDoctorsCalls = type;
    }

    public TypeOfDoctorsCalls getTypeOfDoctorsCalls() {
        return this.typeOfDoctorsCalls;
    }


    //mapping to QuantityOfCalls
    @OneToMany(mappedBy = "subtypeOfDoctorsCalls")
    private Set<QuantityOfCalls> quantityOfCalls = new HashSet<QuantityOfCalls>();

    public Set<QuantityOfCalls> getQuantityOfCalls() {
        return quantityOfCalls;
    }

    public void setQuantityOfCalls(Set<QuantityOfCalls> quantityOfCalls) {
        this.quantityOfCalls = quantityOfCalls;
    }

    public void addQuantityOfCalls(QuantityOfCalls quantity){

        quantity.setSubtypeOfDoctorsCalls(this);
        quantityOfCalls.add(quantity);
    }

    // getters and setters
    public Integer getIdSubtyperOfDoctorsCalls() {
        return idSubtyperOfDoctorsCalls;
    }

    public void setIdSubtyperOfDoctorsCalls(Integer idSubtyperOfDoctorsCalls) {
        this.idSubtyperOfDoctorsCalls = idSubtyperOfDoctorsCalls;
    }

    public String getNameOfSubtypeDoctorsCalls() {
        return nameOfSubtypeDoctorsCalls;
    }

    public void setNameOfSubtypeDoctorsCalls(String nameOfSubtypeDoctorsCalls) {
        this.nameOfSubtypeDoctorsCalls = nameOfSubtypeDoctorsCalls;
    }


    // constructor without parameters
    public SubtypeOfDoctorsCalls(){}


    // hash and equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubtypeOfDoctorsCalls)) return false;

        SubtypeOfDoctorsCalls that = (SubtypeOfDoctorsCalls) o;

        return getNameOfSubtypeDoctorsCalls().equals(that.getNameOfSubtypeDoctorsCalls());
    }


    @Override
    public int hashCode() {
        return getNameOfSubtypeDoctorsCalls().hashCode();
    }

    // toString
    @Override
    public String toString() {
        return "SubtypeOfDoctorsCalls{" +
                "idSubtyperOfDoctorsCalls=" + idSubtyperOfDoctorsCalls +
                ", nameOfSubtypeDoctorsCalls='" + nameOfSubtypeDoctorsCalls + '\'' +
                '}';
    }
}
