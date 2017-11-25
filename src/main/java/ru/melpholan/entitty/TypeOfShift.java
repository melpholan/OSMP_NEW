package ru.melpholan.entitty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TypeOfShift")
public class TypeOfShift implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTypeOfShift", nullable = false)
    private Integer idTypeOfShift;

    public Integer getIdTypeOfShift() {
        return idTypeOfShift;
    }

    public void setIdTypeOfShift(Integer idTypeOfShift) {
        this.idTypeOfShift = idTypeOfShift;
    }


    @Column(name = "type_of_shift")
    private String typeOfShift;


    //mapping to Grafik
    @OneToMany(mappedBy = "typeOfShift")
    private Set<Grafik> grafikSet = new HashSet<Grafik>();

    public void setGrafikSet(Set<Grafik> grafikSet){
        this.grafikSet = grafikSet;
    }

    public Set<Grafik> getGrafikSet() {
        return this.grafikSet;
    }

    public void addGrafikSet(Grafik grafik){
        grafik.setTypeOfShift(this);
        grafikSet.add(grafik);
    }

    public TypeOfShift(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypeOfShift)) return false;

        TypeOfShift that = (TypeOfShift) o;

        if (!getIdTypeOfShift().equals(that.getIdTypeOfShift())) return false;
        return typeOfShift.equals(that.typeOfShift);
    }

    @Override
    public int hashCode() {
        int result = getIdTypeOfShift().hashCode();
        result = 31 * result + typeOfShift.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TypeOfShift{" +
                "idTypeOfShift=" + idTypeOfShift +
                ", typeOfShift='" + typeOfShift + '\'' +
                ", grafikSet=" + grafikSet +
                '}';
    }
}
