package com.sport2.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="BATCHES")
public class Batch_Reg {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="sport_name")
	@NotNull(message="Cannot be Null..!")
	private String sport_name;
	
	@Column(name="sport_time")
	private String sport_time;
	
	@Column(name="desc")
	@NotNull(message="Cannot be Null..!")
	@Size(min = 10, message = "Enter a full Description..!")
	private String desc;
	
	public Batch_Reg() {
		super();
	}
	
	public Batch_Reg(Integer id, String sport_name, String sport_time, String desc) {
		super();
		this.id = id;
		this.sport_name = sport_name;
		this.sport_time = sport_time;
		this.desc = desc;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSport_name() {
		return sport_name;
	}
	
	public void setSport_name(String sport_name) {
		this.sport_name = sport_name;
	}
	
	public String getSport_time() {
		return sport_time;
	}
	public void setSport_time(String sport_time) {
		this.sport_time = sport_time;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Batch_Reg [id=" + id + ", sport_name=" + sport_name + ", sport_time=" + sport_time + ", desc=" + desc
				+ "]";
	}
	
	
	
}
