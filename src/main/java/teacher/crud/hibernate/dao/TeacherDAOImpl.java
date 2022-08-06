package teacher.crud.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import teacher.crud.hibernate.beans.Teacher;
import teacher.crud.hibernate.db.HibernateConnection;

public class TeacherDAOImpl implements TeacherDAO {

	@Override
	public void addTeacher(Teacher teacher) {
		Transaction transaction = null;
		try (Session session = HibernateConnection.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(teacher);
			transaction.commit();		
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}		
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		Transaction transaction = null;
		try (Session session = HibernateConnection.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.update(teacher);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}		
	}

	@Override
	public void deleteTeacher(int idTeacher) {
		Transaction transaction = null;
		Teacher teacher = null;
		
		try (Session session = HibernateConnection.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			teacher = session.get(Teacher.class, idTeacher);
			session.delete(teacher);
			transaction.commit();			
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> getAllTeachers() {
		Transaction transaction = null;
		List<Teacher> teachers = null;
		
		try (Session session = HibernateConnection.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			teachers = session.createSQLQuery("SELECT * FROM school_schema.teachers").list();
			transaction.commit();			
			
		} catch (Exception e) {
			// TODO: handle exception
		}		
		
		return teachers;
	}

	@Override
	public Teacher getTeacher(int idTeacher) {
		Transaction transaction = null;
		Teacher teacher = null;
		
		try (Session session = HibernateConnection.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			teacher = session.get(Teacher.class, idTeacher);
			transaction.commit();			
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}	
		
		return teacher;
	}
}
