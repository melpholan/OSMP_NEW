package ru.melpholan.entitty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Grafik")
public class Grafik implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idGrafik", nullable = false,unique = true)
    private Integer Grafik;

    public Integer getGrafik() {
        return Grafik;
    }

    public void setGrafik(Integer grafik) {
        Grafik = grafik;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "grafic_date", nullable = false)
    private Date grafikDate;

    @Column(name = "hours_quantity", nullable = false)
    private Integer hoursQuantity;

    //mapping to Personal
    @ManyToOne
    @JoinColumn(name = "Personal_idPersonal", referencedColumnName = "idPersonal")
    private Personal personal;

    public Personal getPersonal() {
        return this.personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }


    //mapping to TypeOfShift
    @ManyToOne
    @JoinColumn(name = "TypeOfShift_idTypeOfShift", referencedColumnName = "idTypeOfShift")
    private TypeOfShift typeOfShift;

    public void setTypeOfShift(TypeOfShift typeOfShift){
        this.typeOfShift = typeOfShift;
    }

    public TypeOfShift getTypeOfShift() {
        return typeOfShift;
    }
}
