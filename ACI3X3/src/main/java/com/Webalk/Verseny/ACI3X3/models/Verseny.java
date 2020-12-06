package com.Webalk.Verseny.ACI3X3.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Verseny {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String futamnev;
    private int palyahossz;
    private String helyszin;
    private int nezoszam;
    private String szponzor;
    private String gyoztes;
    private String tvado;

    public Verseny(Long id, String futamnev, int palyahossz, String helyszin,int nezoszam,String szponzor,String gyoztes,String tvado) {
        this.id = id;
        this.futamnev = futamnev;
        this.palyahossz = palyahossz;
        this.helyszin = helyszin;
        this.nezoszam=nezoszam;
        this.szponzor=szponzor;
        this.gyoztes=gyoztes;
        this.tvado=tvado;
        
    }

    public Verseny() {
        this.id=null;
        this.futamnev=null;
        this.palyahossz=0;
        this.helyszin=null;
        this.nezoszam=0;
        this.szponzor=null;
        this.gyoztes=null;
        this.tvado=null;
        
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFutamnev() {
        return futamnev;
    }
    public void setFutamnev(String name) {
        this.futamnev = name;
    }

    public int getPalyahossz() {
        return palyahossz;
    }
    

    public void setPalyahossz(int palyahossz) {
        this.palyahossz = palyahossz;
    }

    public String getHelyszin() {
        return helyszin;
    }

    public void setHelyszin(String helyszin) {
        this.helyszin = helyszin;
    }
    public int getNezoszam() {
        return nezoszam;
    }

    public void setNezoszam(int nezoszam) {
        this.nezoszam = nezoszam;
    }
    public String getSzponzor() {
        return szponzor;
    }

    public void setSzponzor(String szponzor) {
        this.szponzor = szponzor;
    }
    public String getGyoztes() {
        return gyoztes;
    }

    public void setGyoztes(String gyoztes) {
        this.gyoztes = gyoztes;
    }
    public String getTvado() {
        return tvado;
    }

    public void setTvado(String tvado) {
        this.tvado = tvado;
    }



 
 
}
