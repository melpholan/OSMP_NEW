package ru.melpholan.entitty;

import ru.melpholan.entitty.reports.doctorsReports.DailyDoctorsReport;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Personal")
public class Personal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPersonal")
    private Integer idPersonal;

    @Column(name = "p_name")
    private String name;

    @Column(name = "p_surname")
    private String surname;

    @Column(name = "p_patronymic")
    private String patronymic;

    @Temporal(TemporalType.DATE)
    @Column(name = "p_birthday")
    private Date birthsday;

    @Temporal(TemporalType.DATE)
    @Column(name = "p_last_date_work_license")
    private Date lastDateOfWorkLicense;

    @Temporal(TemporalType.DATE)
    @Column(name = "p_date_of_employment")
    private Date dateOfEmployment;

    @Temporal(TemporalType.DATE)
    @Column(name = "p_date_of_dismissal")
    private Date dateOfDimissal;


    //mapping to Profession
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "Professions_idProfessions", referencedColumnName = "idProfessions")
    private Professions profession;

    public Professions getProfession(){
        return this.profession;
    }

    public void setProfession(Professions profession){
        this.profession = profession;
    }


    //mapping to DailyDoctorsReport
    @OneToMany(mappedBy = "personal")
    private Set<DailyDoctorsReport> reports;

    public void setReports(Set<DailyDoctorsReport> reports) {
        this.reports = reports;
    }

    public Set<DailyDoctorsReport> getReports() {
        return this.reports;
    }

    public void addReports(DailyDoctorsReport doctorsReport){
        doctorsReport.setPersonal(this);
        this.reports.add(doctorsReport);
    }

    //mapping to Address
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "Adreses_idAdress")
    private Adreses adress;

    public Adreses getAdreses(){
        return this.adress;
    }

    public void setAdress(Adreses adress){
        this.adress = adress;
    }


    //mapping to Contacts
    @OneToMany(mappedBy = "personal", cascade = CascadeType.REMOVE)
    private Set<Contacts> contacts = new HashSet<Contacts>();

    public void setContacts(Set<Contacts> contacts){
        this.contacts=contacts;
    }

    public Set<Contacts> getContacts() {
        return this.contacts;
    }

    public void addContacts(Contacts contact){
        contact.setPersonal(this);
        this.contacts.add(contact);
    }


    //mapping to Grafik
    @OneToMany(mappedBy = "personal", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Grafik> grafik = new HashSet<Grafik>();

    public Set<Grafik> getGrafik(){
        return this.grafik;
    }

    public void setGrafik(Set<Grafik> grafikSet){
        this.grafik = grafikSet;
    }

    public void addGrafik(Grafik grafik){
        grafik.setPersonal(this);
        this.grafik.add(grafik);
    }


    // mapping to Vacations
    @OneToMany(mappedBy = "personal")
    private Set<Vacations> vacations = new HashSet<Vacations>();

    public void setVacations(Set<Vacations> vacations) {
        this.vacations = vacations;
    }

    public Set<Vacations> getVacations() {
        return this.vacations;
    }

    public void addVacations(Vacations vacations){
        vacations.setPersonal(this);
        this.vacations.add(vacations);
    }

    //-----------------------------------------------------------//
    //constructor without parameters
    public Personal(){}

    // getters and setters
    public Integer getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Integer idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getBirthsday() {
        return birthsday;
    }

    public void setBirthsday(Date birthsday) {
        this.birthsday = birthsday;
    }

    public Date getLastDateOfWorkLicense() {
        return lastDateOfWorkLicense;
    }

    public void setLastDateOfWorkLicense(Date lastDateOfWorkLicense) {
        this.lastDateOfWorkLicense = lastDateOfWorkLicense;
    }

    public Date getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(Date dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public Date getDateOfDimissal() {
        return dateOfDimissal;
    }

    public void setDateOfDimissal(Date dateOfDimissal) {
        this.dateOfDimissal = dateOfDimissal;
    }

    // toString
    @Override
    public String toString() {
        return "Personal{" +
                "idPersonal=" + idPersonal +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthsday=" + birthsday +
                ", lastDateOfWorkLicense=" + lastDateOfWorkLicense +
                ", dateOfEmployment=" + dateOfEmployment +
                ", dateOfDimissal=" + dateOfDimissal +
                ", adress=" + adress +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Personal)) return false;

        final Personal personal = (Personal) o;

        if (!getName().equals(personal.getName())) return false;
        if (!getSurname().equals(personal.getSurname())) return false;
        return getProfession().equals(personal.getProfession());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getSurname().hashCode();
        result = 31 * result + getProfession().hashCode();
        return result;
    }
}
