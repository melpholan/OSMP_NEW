package ru.melpholan.entitty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Contacts")
public class Contacts implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idContacts")
    private Integer idContacts;

    @Column(name = "phone_home")
    private String homePhone;

    @Column(name = "phone_mobile")
    private String mobilePhone;

    @Column(name = "email")
    private String emil;

    //Personal
    @ManyToOne
    @JoinColumn
    private Personal personal;

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }


    public Integer getIdContacts() {
        return idContacts;
    }

    public void setIdContacts(Integer idContacts) {
        this.idContacts = idContacts;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmil() {
        return emil;
    }

    public void setEmil(String emil) {
        this.emil = emil;
    }


    public Contacts(){}

    @Override
    public String toString() {
        return "Contacts{" +
                "idContacts=" + idContacts +
                ", homePhone='" + homePhone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", emil='" + emil + '\'' +
                ", personal=" + personal +
                '}';
    }
}
