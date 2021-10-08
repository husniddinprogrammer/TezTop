package Husniddin.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "poliya")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Poliya {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nomi;
    private Integer narxi;
    private String manzil;
    private Integer status;
    private String googleMap;
    private String koordinataX;
    private String koordinataY;
    @ManyToOne
    private User boshliq;
    @ManyToOne
    private User admin;
    @ManyToOne
    private MaydonTuri maydonTuri;
    private Long oqilgan;
    private Long oqilganIchi;
    @ManyToOne
    private Fayl photo1;
    @ManyToOne
    private Fayl photo2;

    public Poliya(){};

    public Poliya(Long id, String nomi, Integer narxi, String manzil, Integer status, String googleMap, String koordinataX, String koordinataY, User boshliq, User admin, MaydonTuri maydonTuri, Long oqilgan, Long oqilganIchi, Fayl photo1, Fayl photo2) {
        this.id = id;
        this.nomi = nomi;
        this.narxi = narxi;
        this.manzil = manzil;
        this.status = status;
        this.googleMap = googleMap;
        this.koordinataX = koordinataX;
        this.koordinataY = koordinataY;
        this.boshliq = boshliq;
        this.admin = admin;
        this.maydonTuri = maydonTuri;
        this.oqilgan = oqilgan;
        this.oqilganIchi = oqilganIchi;
        this.photo1 = photo1;
        this.photo2 = photo2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomi() {
        return nomi;
    }

    public void setNomi(String nomi) {
        this.nomi = nomi;
    }

    public Integer getNarxi() {
        return narxi;
    }

    public void setNarxi(Integer narxi) {
        this.narxi = narxi;
    }

    public String getManzil() {
        return manzil;
    }

    public void setManzil(String manzil) {
        this.manzil = manzil;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getGoogleMap() {
        return googleMap;
    }

    public void setGoogleMap(String googleMap) {
        this.googleMap = googleMap;
    }

    public String getKoordinataX() {
        return koordinataX;
    }

    public void setKoordinataX(String koordinataX) {
        this.koordinataX = koordinataX;
    }

    public String getKoordinataY() {
        return koordinataY;
    }

    public void setKoordinataY(String koordinataY) {
        this.koordinataY = koordinataY;
    }

    public User getBoshliq() {
        return boshliq;
    }

    public void setBoshliq(User boshliq) {
        this.boshliq = boshliq;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public MaydonTuri getMaydonTuri() {
        return maydonTuri;
    }

    public void setMaydonTuri(MaydonTuri maydonTuri) {
        this.maydonTuri = maydonTuri;
    }

    public Long getOqilgan() {
        return oqilgan;
    }

    public void setOqilgan(Long oqilgan) {
        this.oqilgan = oqilgan;
    }

    public Long getOqilganIchi() {
        return oqilganIchi;
    }

    public void setOqilganIchi(Long oqilganIchi) {
        this.oqilganIchi = oqilganIchi;
    }

    public Fayl getPhoto1() {
        return photo1;
    }

    public void setPhoto1(Fayl photo1) {
        this.photo1 = photo1;
    }

    public Fayl getPhoto2() {
        return photo2;
    }

    public void setPhoto2(Fayl photo2) {
        this.photo2 = photo2;
    }
}
