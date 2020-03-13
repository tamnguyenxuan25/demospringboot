package com.spring.example.springBootApiDemo.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.spring.example.springBootApiDemo.config.WorkStatus;

@Entity
@Table(name = "work")
public class Work {
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="work_name", length = 60)
	private String workName;
	
	@JsonFormat(pattern = "yyyy-mm-dd", shape = Shape.STRING)
    @Column(name="starting_date", length = 10)
	private String startingDate;
	
	@JsonFormat(pattern = "yyyy-mm-dd", shape = Shape.STRING)
    @Column(name="end_date", length = 10)
	private String endDate;
	
	@Enumerated(EnumType.STRING)
    @Column(length = 8)
	private WorkStatus status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWorkName() {
		return workName;
	}

	public void setWorkName(String workName) {
		this.workName = workName;
	}

	public String getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(String startingDate) {
		this.startingDate = startingDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public WorkStatus getStatus() {
		return status;
	}

	public void setStatus(WorkStatus status) {
		this.status = status;
	}

	public Work( String workName, String startingDate, String endDate, WorkStatus status) {
		super();
		this.workName = workName;
		this.startingDate = startingDate;
		this.endDate = endDate;
		this.status = status;
	}
	
	public Work(){}
	
}
