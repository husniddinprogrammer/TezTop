package Husniddin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Xabar {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private Buyurtma buyurtma;
    private String qisqaXabar;
    @ManyToOne
    private XabarTuri xabarTuri;
    private Integer status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime xabarVaqti;
    private Integer poliyaHozirgiNarxi;
    private Integer tulovNarxiPlastik;
    private Integer tulovNarxiNaqd;
    @ManyToOne
    private TulovQilish tulovQilish;
    public Xabar() { }

    public Xabar(Long id, Buyurtma buyurtma, String qisqaXabar, XabarTuri xabarTuri, Integer status, LocalDateTime xabarVaqti, Integer poliyaHozirgiNarxi, Integer tulovNarxiPlastik, Integer tulovNarxiNaqd, TulovQilish tulovQilish) {
        this.id = id;
        this.buyurtma = buyurtma;
        this.qisqaXabar = qisqaXabar;
        this.xabarTuri = xabarTuri;
        this.status = status;
        this.xabarVaqti = xabarVaqti;
        this.poliyaHozirgiNarxi = poliyaHozirgiNarxi;
        this.tulovNarxiPlastik = tulovNarxiPlastik;
        this.tulovNarxiNaqd = tulovNarxiNaqd;
        this.tulovQilish = tulovQilish;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Buyurtma getBuyurtma() {
        return buyurtma;
    }

    public void setBuyurtma(Buyurtma buyurtma) {
        this.buyurtma = buyurtma;
    }

    public String getQisqaXabar() {
        return qisqaXabar;
    }

    public void setQisqaXabar(String qisqaXabar) {
        this.qisqaXabar = qisqaXabar;
    }

    public XabarTuri getXabarTuri() {
        return xabarTuri;
    }

    public void setXabarTuri(XabarTuri xabarTuri) {
        this.xabarTuri = xabarTuri;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getXabarVaqti() {
        return xabarVaqti;
    }

    public void setXabarVaqti(LocalDateTime xabarVaqti) {
        this.xabarVaqti = xabarVaqti;
    }

    public Integer getPoliyaHozirgiNarxi() {
        return poliyaHozirgiNarxi;
    }

    public void setPoliyaHozirgiNarxi(Integer poliyaHozirgiNarxi) {
        this.poliyaHozirgiNarxi = poliyaHozirgiNarxi;
    }

    public Integer getTulovNarxiPlastik() {
        return tulovNarxiPlastik;
    }

    public void setTulovNarxiPlastik(Integer tulovNarxiPlastik) {
        this.tulovNarxiPlastik = tulovNarxiPlastik;
    }

    public Integer getTulovNarxiNaqd() {
        return tulovNarxiNaqd;
    }

    public void setTulovNarxiNaqd(Integer tulovNarxiNaqd) {
        this.tulovNarxiNaqd = tulovNarxiNaqd;
    }

    public TulovQilish getTulovQilish() {
        return tulovQilish;
    }

    public void setTulovQilish(TulovQilish tulovQilish) {
        this.tulovQilish = tulovQilish;
    }
}
