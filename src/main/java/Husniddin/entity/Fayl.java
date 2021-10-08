package Husniddin.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Fayl {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 30)
    private String nom;
    @Column(nullable = false)
    private FaylTur faylTur;
    @Column(length = 10)
    private String kengaytma;
    private Integer hajm;
    @ManyToOne()
    private User yaratuvchi;
    private String izoh;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public FaylTur getFaylTur() {
        return faylTur;
    }

    public void setFaylTur(FaylTur faylTur) {
        this.faylTur = faylTur;
    }

    public String getKengaytma() {
        return kengaytma;
    }

    public void setKengaytma(String kengaytma) {
        this.kengaytma = kengaytma;
    }

    public Integer getHajm() {
        return hajm;
    }

    public void setHajm(Integer hajm) {
        this.hajm = hajm;
    }

    public User getYaratuvchi() {
        return yaratuvchi;
    }

    public void setYaratuvchi(User yaratuvchi) {
        this.yaratuvchi = yaratuvchi;
    }

    public String getIzoh() {
        return izoh;
    }

    public void setIzoh(String izoh) {
        this.izoh = izoh;
    }
}
