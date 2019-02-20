package com.cg.ems.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="emp_master")
public class Employee 
{
	@Id
	@Column(name="emp_id",length=10)
	private int empId;
	@Column(name="emp_name",length=25)
	private String empName;
	@Column(name="emp_sal",length=10)
	private float empSal;
	@ManyToOne
	@JoinColumn(name="dept_code")
	private Department empDept;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public float getEmpSal() {
		return empSal;
	}
	public void setEmpSal(float empSal) {
		this.empSal = empSal;
	}
	public Department getEmpDept() {
		return empDept;
	}
	public void setEmpDept(Department empDept) {
		this.empDept = empDept;
	}
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int empId, String empName, float empSal, Department empDept) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
		this.empDept = empDept;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + ", empDept=" + empDept
				+ "]";
	}
	
	
	
}
