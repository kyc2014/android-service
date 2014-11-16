package com.abroad.studies.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
 
/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author Satheesh
 *
 */
@Entity
@Table(name="user")
public class User {
 
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="id")
    private String id;
    @Column(name="name")
	private String name;
    @Column(name="email")
	private String email;
    @Column(name="ugScore")
    private Float ugScore;
    @Column(name="greQuants")
    private Integer greQuants;
    @Column(name="greVerbal")
    private Integer greVerbal;
    @Column(name="greAWA")
    private Float greAWA;
    @Column(name="toeflSpeaking")
	private Integer toeflSpeaking;
    @Column(name="toeflListening")
	private Integer toeflListening;
    @Column(name="toeflWriting")
	private Integer toeflWriting;
	@Column(name="workExperience")
    private Integer workExperience;
    @Column(name="country")
    private String country;
    @Column(name="actId")
    private String actId;
    @Column(name="backlogs")
    private String backlogs;
    @Column(name="description")
    private String description;
    @Column(name="timestamp")
    private long timestamp;
    @Column(name="mailFlag")
    private int mailFlag;
    @Column(name="regId")
    private String regId;
    
    
    public int getMailFlag() {
		return mailFlag;
	}

	public void setMailFlag(int mailFlag) {
		this.mailFlag = mailFlag;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

    private String status;
    

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    public String getActId() {
		return actId;
	}

	public void setActId(String actId) {
		this.actId = actId;
	}

	public String getBacklogs() {
		return backlogs;
	}

	public void setBacklogs(String backlogs) {
		this.backlogs = backlogs;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Float getUgScore() {
		return ugScore;
	}

	public void setUgScore(Float ugScore) {
		this.ugScore = ugScore;
	}

	public Integer getGreQuants() {
		return greQuants;
	}

	public void setGreQuants(Integer greQuants) {
		this.greQuants = greQuants;
	}

	public Integer getGreVerbal() {
		return greVerbal;
	}

	public void setGreVerbal(Integer greVerbal) {
		this.greVerbal = greVerbal;
	}

	public Float getGreAWA() {
		return greAWA;
	}

	public void setGreAWA(Float greAWA) {
		this.greAWA = greAWA;
	}

	public Integer getToeflSpeaking() {
		return toeflSpeaking;
	}

	public void setToeflSpeaking(Integer toeflSpeaking) {
		this.toeflSpeaking = toeflSpeaking;
	}

	public Integer getToeflListening() {
		return toeflListening;
	}

	public void setToeflListening(Integer toeflListening) {
		this.toeflListening = toeflListening;
	}

	public Integer getToeflWriting() {
		return toeflWriting;
	}

	public void setToeflWriting(Integer toeflWriting) {
		this.toeflWriting = toeflWriting;
	}

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	public Integer getWorkExperience() {
		return workExperience;
	}

	public void setWorkExperience(Integer workExperience) {
		this.workExperience = workExperience;
	}
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getCountry() {
        return country;
    }
 
    public void setCountry(String country) {
        this.country = country;
    }
     
    @Override
    public String toString(){
        return "id="+id+", name="+name+", country="+country+", actId="+actId+", status="+status+", email="+email;
    }
}
