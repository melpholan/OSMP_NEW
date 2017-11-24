package ru.melpholan.entitty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Professions")
public class Professions implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProfessions")
    private Integer idProfession;

    @Column(name = "profession_name", updatable = false, insertable = false)
    private String profession;

    @OneToMany(mappedBy = "profession")
    private Set<Personal> personals = new HashSet<Personal>();

    public Set<Personal> getPersonals(){
        return this.personals;
    }

    public void setPersonal(Set<Personal> personals){
        this.personals=personals;
    }

    public void addPersonal(Personal personal){
        personal.setProfession(this);
        personals.add(personal);
    }

    public Integer getIdProfession() {
        return idProfession;
    }

    public void setIdProfession(Integer idProfession) {
        this.idProfession = idProfession;
    }

    @Column(name = "profession_name")
    private String professionName;

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    public Professions(){}

    @Override
    public String toString() {
        return "Professions{" +
                "idProfession=" + idProfession +
                ", profession='" + profession + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
       // if (this == o) return true;
       // if (o == null || getClass() != o.getClass()) return false;

        if(o == null || !(o instanceof Professions) ) return false;
        final Professions that = (Professions) o;

//        if (!idProfession.equals(that.idProfession)) return false;
        return this.getProfessionName().equals(that.getProfessionName());
    }

    @Override
    public int hashCode() {
        //int result = idProfession.hashCode();
        int result = 31 + this.getProfessionName().hashCode();
        return result;
    }
}
