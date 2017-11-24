package ru.melpholan.entitty.reports;

import ru.melpholan.entitty.Personal;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "DailyDoctorsReport")
public class DailyDoctorsReport implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDailyDoctorsReport")
    private Integer idDoctorsReport;

    @Temporal(TemporalType.DATE)
    @Column(name = "ddr_report_date")
    private Date reportDate;

    @ManyToOne
    @JoinColumn(name = "Personal_idPersonal", referencedColumnName = "idPersonal")
    private Personal personal;

    @ManyToOne
    @JoinColumn(name = "TypeOfDoctorsCalls_idCalls", referencedColumnName = "idCalls")
    private TypeOfDoctorsCalls typeOfDoctorsCalls;

    public TypeOfDoctorsCalls getTypeOfDoctorsCalls() {
        return typeOfDoctorsCalls;
    }

    public void setTypeOfDoctorsCalls(TypeOfDoctorsCalls typeOfDoctorsCalls){
        this.typeOfDoctorsCalls = typeOfDoctorsCalls;
    }

    public Integer getIdDoctorsReport() {
        return idDoctorsReport;
    }

    public void setIdDoctorsReport(Integer idDoctorsReport) {
        this.idDoctorsReport = idDoctorsReport;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public DailyDoctorsReport(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DailyDoctorsReport)) return false;

        DailyDoctorsReport that = (DailyDoctorsReport) o;

        if (!getReportDate().equals(that.getReportDate())) return false;
        if (!getPersonal().equals(that.getPersonal())) return false;
        return getTypeOfDoctorsCalls().equals(that.getTypeOfDoctorsCalls());
    }

    @Override
    public int hashCode() {
        int result = getReportDate().hashCode();
        result = 31 * result + getPersonal().hashCode();
        result = 31 * result + getTypeOfDoctorsCalls().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "DailyDoctorsReport{" +
                "idDoctorsReport=" + idDoctorsReport +
                ", reportDate=" + reportDate +
                ", personal=" + personal +
                ", typeOfDoctorsCalls=" + typeOfDoctorsCalls +
                '}';


    }
}
