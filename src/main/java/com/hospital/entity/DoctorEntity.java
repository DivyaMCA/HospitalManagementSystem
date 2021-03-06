package com.hospital.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "DoctorRecord")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DoctorEntity {

	@Id
	//@SequenceGenerator(name="doctor",initialValue=201,sequenceName = "doctor")
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int doctorId;

	@NotEmpty
	@Size(min = 4, max = 20, message = "doctor name can not be empty, contains minimum 4 character and maximum 20")
	@Column(nullable = false)
	private String doctorName;

	@NotEmpty
	@Size(min = 4, max = 20, message = "designation can not be empty, contains minimum 4 character and maximum 20")
	@Column(nullable = false)
	private String designation;

	@NotEmpty
	@Size(min = 4, max = 20, message = "doctor salary can not be empty")
	@Column(nullable = false)
	private String doctorSalary;

	@ManyToOne
	private HospitalEntity hospital;

	@OneToMany(cascade = CascadeType.ALL)
	private List<PatientEntity> patientEntity = new ArrayList<PatientEntity>();

}