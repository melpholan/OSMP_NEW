package ru.melpholan.entitty.reports;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TypeOfDoctorsCalls")
public class TypeOfDoctorsCalls implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCalls")
    private Integer idCalls;

    @Column(name = "ddr_name_of_type_calls")
    private String nameOfCallsTypes;

    @OneToMany(mappedBy = "typeOfDoctorsCalls")
    private Set<DailyDoctorsReport> dailyDoctorsReports = new HashSet<DailyDoctorsReport>();

    public void setDailyDoctorsReports(Set<DailyDoctorsReport> drs){
        this.dailyDoctorsReports = drs;
    }

    public Set<DailyDoctorsReport> getDailyDoctorsReports(){
        return dailyDoctorsReports;
    }

    public void addDayliDoctorsReport(DailyDoctorsReport report){
        report.setTypeOfDoctorsCalls(this);
        dailyDoctorsReports.add(report);
    }

    public TypeOfDoctorsCalls(){}

    public Integer getIdCalls() {
        return idCalls;
    }

    public void setIdCalls(Integer idCalls) {
        this.idCalls = idCalls;
    }

    public String getNameOfCallsTypes() {
        return nameOfCallsTypes;
    }

    public void setNameOfCallsTypes(String nameOfCallsTypes) {
        this.nameOfCallsTypes = nameOfCallsTypes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeOfDoctorsCalls that = (TypeOfDoctorsCalls) o;

        if (!getIdCalls().equals(that.getIdCalls())) return false;
        return getNameOfCallsTypes().equals(that.getNameOfCallsTypes());
    }

    @Override
    public int hashCode() {
        int result = getIdCalls().hashCode();
        result = 31 * result + getNameOfCallsTypes().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TypeOfDoctorsCalls{" +
                "idCalls=" + idCalls +
                ", nameOfCallsTypes='" + nameOfCallsTypes + '\'' +
                '}';
    }
}
