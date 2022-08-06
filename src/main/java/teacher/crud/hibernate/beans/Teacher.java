package teacher.crud.hibernate.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teachers")
public class Teacher {
	
	@Id
	@GeneratedValue
	@Column(name = "idTeacher")
	private int idTeacher;
	
	@Column(name = "teacherFirstName")
	private String teacherFirstName;
	
	@Column(name = "teacherLastName")
	private String teacherLastName;
	
	@Column(name = "teacherRank")
	private int teacherRank;
	
	@Column(name = "teacherSalary")
	private Double teacherSalary;
	
	@Column(name = "teacherSubjectTaught")
	private String teacherSubjectTaught;
	
	public Teacher() {
		super();
	}

	public Teacher(String teacherFirstName, String teacherLastName, int teacherRank, Double teacherSalary,
			String teacherSubjectTaught) {
		super();
		this.teacherFirstName = teacherFirstName;
		this.teacherLastName = teacherLastName;
		this.teacherRank = teacherRank;
		this.teacherSalary = teacherSalary;
		this.teacherSubjectTaught = teacherSubjectTaught;
	}

	public Teacher(int idTeacher, String teacherFirstName, String teacherLastName, int teacherRank,
			Double teacherSalary, String teacherSubjectTaught) {
		super();
		this.idTeacher = idTeacher;
		this.teacherFirstName = teacherFirstName;
		this.teacherLastName = teacherLastName;
		this.teacherRank = teacherRank;
		this.teacherSalary = teacherSalary;
		this.teacherSubjectTaught = teacherSubjectTaught;
	}

	public int getIdTeacher() {
		return idTeacher;
	}

	public void setIdTeacher(int idTeacher) {
		this.idTeacher = idTeacher;
	}

	public String getTeacherFirstName() {
		return teacherFirstName;
	}

	public void setTeacherFirstName(String teacherFirstName) {
		this.teacherFirstName = teacherFirstName;
	}

	public String getTeacherLastName() {
		return teacherLastName;
	}

	public void setTeacherLastName(String teacherLastName) {
		this.teacherLastName = teacherLastName;
	}

	public int getTeacherRank() {
		return teacherRank;
	}

	public void setTeacherRank(int teacherRank) {
		this.teacherRank = teacherRank;
	}

	public Double getTeacherSalary() {
		return teacherSalary;
	}

	public void setTeacherSalary(Double teacherSalary) {
		this.teacherSalary = teacherSalary;
	}

	public String getTeacherSubjectTaught() {
		return teacherSubjectTaught;
	}

	public void setTeacherSubjectTaught(String teacherSubjectTaught) {
		this.teacherSubjectTaught = teacherSubjectTaught;
	}

	@Override
	public String toString() {
		return "Teacher [idTeacher=" + idTeacher + ", teacherFirstName=" + teacherFirstName + ", teacherLastName="
				+ teacherLastName + ", teacherRank=" + teacherRank + ", teacherSalary=" + teacherSalary
				+ ", teacherSubjectTaught=" + teacherSubjectTaught + "]";
	}	
}