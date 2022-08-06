package teacher.crud.hibernate.dao;

import java.util.List;
import teacher.crud.hibernate.beans.Teacher;


public interface TeacherDAO {
	
	public void addTeacher(Teacher teacher);
	
	public void updateTeacher(Teacher teacher);
		
	public void deleteTeacher(int idTeacher);
	
	public List<Teacher> getAllTeachers();
	
	public Teacher getTeacher(int idTeacher);

}
