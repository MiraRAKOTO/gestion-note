package com.demo.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "etudiant")
public class Etudiant implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "numEt")
    private int numEt;

    @Column(name = "nomEt")
    private String nomEt;

    @Column(name = "niveauEt")
    private String niveauEt;

    public Etudiant() {
        super();
    }

    public Etudiant(String nomEt, String niveauEt) {
        super();
        this.nomEt = nomEt;
        this.niveauEt = niveauEt;
    }

    public Etudiant(int numEt, String nomEt, String niveauEt) {
        super();
        this.numEt = numEt;
        this.nomEt = nomEt;
        this.niveauEt = niveauEt;
    }

    public int getNumEt() {
        return numEt;
    }

    public void setNumEt(int numEt) {
        this.numEt = numEt;
    }

    public String getNomEt() {
        return nomEt;
    }

    public void setNomEt(String nomEt) {
        this.nomEt = nomEt;
    }

    public String getNiveauEt() {
        return niveauEt;
    }

    public void setNiveauEt(String niveauEt) {
        this.niveauEt = niveauEt;
    }


}
