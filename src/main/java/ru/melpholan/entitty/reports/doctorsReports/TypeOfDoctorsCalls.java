package ru.melpholan.entitty.reports.doctorsReports;

import javax.persistence.*;
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


    //mapping to DailyDoctorsReports
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


    // mapping to SubtypeOfDoctorsCalls
    @OneToMany(mappedBy = "typeOfDoctorsCalls")
    private Set<SubtypeOfDoctorsCalls> subtypeOfDoctorsCalls = new HashSet<SubtypeOfDoctorsCalls>();

    public Set<SubtypeOfDoctorsCalls> getSubtypeOfDoctorsCalls() {
        return subtypeOfDoctorsCalls;
    }

    public void setSubtypeOfDoctorsCalls(Set<SubtypeOfDoctorsCalls> subtypeOfDoctorsCalls) {
        this.subtypeOfDoctorsCalls = subtypeOfDoctorsCalls;
    }

    public void addSubtypeOfDoctorsCalls(SubtypeOfDoctorsCalls subtype){
        subtype.setTypeOfDoctorsCalls(this);
        this.subtypeOfDoctorsCalls.add(subtype);
    }


    // constructor without parameters
    public TypeOfDoctorsCalls(){}


    //getters and setters
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



    // hash and equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypeOfDoctorsCalls)) return false;

        TypeOfDoctorsCalls that = (TypeOfDoctorsCalls) o;

        return getNameOfCallsTypes().equals(that.getNameOfCallsTypes());
    }

    @Override
    public int hashCode() {
        return getNameOfCallsTypes().hashCode();
    }

    // toString
    @Override
    public String toString() {
        return "TypeOfDoctorsCalls{" +
                "idCalls=" + idCalls +
                ", nameOfCallsTypes='" + nameOfCallsTypes + '\'' +
                '}';
    }
}
