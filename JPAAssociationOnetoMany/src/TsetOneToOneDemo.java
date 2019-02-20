import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.cg.ems.dto.Department;
import com.cg.ems.dto.Employee;
import com.cg.ems.util.JPAUtil;

public class TsetOneToOneDemo {

	public static void main(String[] args) {
		EntityManager em=JPAUtil.getEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Department d1=new Department();
		d1.setDeptcode(10);
		d1.setDeptName("Admin");
		
		Department d2=new Department();
		d2.setDeptcode(20);
		d2.setDeptName("Sales");
		
		Employee e1=new Employee();
		e1.setEmpId(111);
		e1.setEmpName("neha");
		e1.setEmpSal(50000);
		e1.setEmpDept(d1);
		Employee e2=new Employee();
		e2.setEmpId(222);
		e2.setEmpName("rishabh");
		e2.setEmpSal(40000);
		e2.setEmpDept(d1);
		Employee e3=new Employee();
		e3.setEmpId(333);
		e3.setEmpName("rishu");
		e3.setEmpSal(30000);
		e3.setEmpDept(d2);
		Employee e4=new Employee();
		e4.setEmpId(444);
		e4.setEmpName("nitin");
		e4.setEmpSal(35000);
		e4.setEmpDept(d2);
		HashSet<Employee> adminEmpSet=new HashSet<Employee>();
		adminEmpSet.add(e1);
		adminEmpSet.add(e2);
		
		HashSet<Employee> saleEmpSet=new HashSet<Employee>();
		saleEmpSet.add(e3);
		saleEmpSet.add(e4);
		
		d1.setEmpSet(adminEmpSet);
		d2.setEmpSet(saleEmpSet);
		et.begin();
		em.persist(d1);
		em.persist(d2);
		et.commit();
		
		System.out.println("department inserted");
		}

}
