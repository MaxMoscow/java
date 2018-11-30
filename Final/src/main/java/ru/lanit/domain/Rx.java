package ru.lanit.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "RX")
public class Rx implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;
    private Long userId;
    private Long doctorId;
    private String symptoms;
    private String medicine;
    private Timestamp createTime;
    private Timestamp lastUpdated;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "USER_ID")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "DOCTOR_ID")
    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    @Basic
    @Column(name = "SYMPTOMS")
    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    @Basic
    @Column(name = "MEDICINE")
    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    @Basic
    @Column(name = "CREATE_TIME")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "LAST_UPDATED")
    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rx rxEntity = (Rx) o;
        return id == rxEntity.id &&
                Objects.equals(userId, rxEntity.userId) &&
                Objects.equals(doctorId, rxEntity.doctorId) &&
                Objects.equals(symptoms, rxEntity.symptoms) &&
                Objects.equals(medicine, rxEntity.medicine) &&
                Objects.equals(createTime, rxEntity.createTime) &&
                Objects.equals(lastUpdated, rxEntity.lastUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, doctorId, symptoms, medicine, createTime, lastUpdated);
    }

}
