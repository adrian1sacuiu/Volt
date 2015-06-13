package services.DAO;

import domain.Department;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import services.DAO.controller.SessionController;

import java.util.List;

@Repository
public class DepartmentDao extends SessionController {
	private static final Logger logger = Logger.getLogger(DepartmentDao.class);

	public boolean addDepartment(Department department) throws Exception {
		logger.info("Inside addDepartment method.");
		boolean result = false;

		try {
			getCurrentSession().save(department);
			result = true;

		} catch (Exception e) {
			logger.error("in addDepartment method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
			throw e;
		}

		return result;
	}

	public boolean updateDepartment(Department department) throws Exception {
		logger.info("Inside updateDepartment method.");
		boolean result = false;

		try {
			getCurrentSession().update(department);
			result = true;

		} catch (Exception e) {
			logger.error("in updateDepartment method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
			throw e;
		}

		return result;
	}

	public boolean deleteDepartment(Department department) throws Exception {
		logger.info("Inside deleteDepartment method.");
		boolean result = false;

		try {
			getCurrentSession().delete(department);
			result = true;

		} catch (Exception e) {
			logger.error("in deleteDepartment method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
			throw e;
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Department> getAllDepartments() {
		logger.info("Inside getAllDepartments method.");
		List<Department> departments = null;

		try {
			departments = getCurrentSession().createCriteria(Department.class).list();

		} catch (Exception e) {
			logger.error("in getAllDepartments method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return departments;
	}

	public Department getDepartmentById(Long id) {
		logger.info("Inside getDepartmentById method.");
		Department department = null;

		try {
			department = (Department) getCurrentSession().get(Department.class, id);
		} catch (Exception e) {
			logger.error("in getDepartmentById method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return department;
	}

	@SuppressWarnings("unchecked")
	public List<Department> getDepartmentsByName(String name) {
		logger.info("Inside getDepartmentsByName method.");
		List<Department> departments = null;

		try {
			Query query = getCurrentSession().getNamedQuery("getDepartmentsByName");
			query.setParameter("name", name);

			departments = (List<Department>) query.list();

		} catch (Exception e) {
			logger.error("in getDepartmentsByName method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return departments;
	}

	@SuppressWarnings("unchecked")
	public List<Department> getDepartmentsByLocation(String location) {
		logger.info("Inside getDepartmentsByLocation method.");
		List<Department> departments = null;

		try {
			Query query = getCurrentSession().getNamedQuery("getDepartmentsByLocation");
			query.setParameter("location", location);

			departments = (List<Department>) query.list();

		} catch (Exception e) {
			logger.error("in getDepartmentsByLocation method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return departments;
	}

	@SuppressWarnings("unchecked")
	public List<Department> getDepartmentsByAddress(String address) {
		logger.info("Inside getDepartmentsByAddress method.");
		List<Department> departments = null;

		try {
			Query query = getCurrentSession().getNamedQuery("getDepartmentsByAddress");
			query.setParameter("address", address);

			departments = (List<Department>) query.list();

		} catch (Exception e) {
			logger.error("in getDepartmentsByAddress method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return departments;
	}

}
