package com.qa.new_account.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;



@Entity
public class ClassRoom{
	
	public ClassRoom() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "class_Id")
	private Long ClassroomId;
	@Column(length = 100)
	 private String trainer;
	@JoinColumn(name = "class_Id", referencedColumnName ="class_Id")
	@OneToMany (fetch = FetchType.EAGER, cascade= CascadeType.ALL)
    private List<Trainee> trainees;
	

	public ClassRoom(Long ClassroomId, String trainer, List<Trainee> trainees) {
		this.ClassroomId = ClassroomId;
		this.trainer = trainer;
		this.trainees = trainees;
	}
	public Long getClassroomId() {
		return ClassroomId;
	}
	public void setClassroomId(Long classroomId) {
		ClassroomId = classroomId;
	}
	public String getTrainer() {
		return trainer;
	}
	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}
	public List<Trainee> getTrainees() {
		return trainees;
	}
	
	public void setTrainees(List<Trainee> trainees) {
		this.trainees=trainees;
	}
}
