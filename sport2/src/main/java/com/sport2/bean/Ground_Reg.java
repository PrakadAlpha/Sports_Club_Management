package com.sport2.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="GROUNDS")
public class Ground_Reg {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message="Cannot be Null..!")
	private String event;
	
	@FutureOrPresent(message="Enter valid date..!")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@NotNull(message="Cannot be Null..!")
	private Date date;
	
	@NotNull(message="Cannot be Null..!")
	private String desc;
	
	private String status = "";
	
	@OneToOne
	private Users user;
	
	
	public Ground_Reg() {
		super();
	}
	
	public Ground_Reg(Integer id, String event, Date date, String desc, String status, Users user) {
		super();
		this.id = id;
		this.event = event;
		this.date = date;
		this.desc = desc;
		this.status = status;
		this.user = user;
	}
	
	
	
	
	public Users getUser() {
		return user;
	}
	
	public Integer getUserId() {
		return user.getId();
	}
	
	public void setUserId(Integer id) {
		user.setId(id);
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Ground_Reg [id=" + id + ", event=" + event + ", date=" + date + ", desc=" + desc + ", status=" + status
				+ user+ "..";
	}


	
}
