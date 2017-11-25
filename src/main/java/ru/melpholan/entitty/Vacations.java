package ru.melpholan.entitty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Vacations")
public class Vacations implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVacations")
    private Integer idVacations;

    @Temporal(TemporalType.DATE)
    @Column(name = "v_date")
    private Date beginVacationsDate;

    @Column(name = "v_duration")
    private Integer vacationDuration;


    //Getters and Setters

    public Integer getIdVacations() {
        return idVacations;
    }

    public void setIdVacations(Integer idVacations) {
        this.idVacations = idVacations;
    }

    public Date getBeginVacationsDate() {
        return beginVacationsDate;
    }

    public void setBeginVacationsDate(Date beginVacationsDate) {
        this.beginVacationsDate = beginVacationsDate;
    }

    public Integer getVacationDuration() {
        return vacationDuration;
    }

    public void setVacationDuration(Integer vacationDuration) {
        this.vacationDuration = vacationDuration;
    }

    //-----------------------------------------------------------//

    // mapping to Personal
    @ManyToOne
    @JoinColumn(name = "Personal_idPersonal", referencedColumnName = "idPersonal")
    private Personal personal;

    public Personal getPersonal() {
        return this.personal;
    }

    public void setPersonal(Personal personal){
        this.personal = personal;
    }

    //-----------------------------------------------------------//

    //toString


    @Override
    public String toString() {
        return "Vacations{" +
                "idVacations=" + idVacations +
                ", beginVacationsDate=" + beginVacationsDate +
                ", vacationDuration=" + vacationDuration +
                ", personal=" + personal +
                '}';
    }

    // hash and equals


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vacations)) return false;

        Vacations vacations = (Vacations) o;

        if (!getIdVacations().equals(vacations.getIdVacations())) return false;
        if (!getBeginVacationsDate().equals(vacations.getBeginVacationsDate())) return false;
        if (!getVacationDuration().equals(vacations.getVacationDuration())) return false;
        return getPersonal().equals(vacations.getPersonal());
    }

    @Override
    public int hashCode() {
        int result = getIdVacations().hashCode();
        result = 31 * result + getBeginVacationsDate().hashCode();
        result = 31 * result + getVacationDuration().hashCode();
        result = 31 * result + getPersonal().hashCode();
        return result;
    }
}
