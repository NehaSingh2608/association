import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.cg.ems.dto.Address;
import com.cg.ems.dto.Student;
import com.cg.ems.util.JPAUtil;

public class TsetOneToOneDemo {

	public static void main(String[] args) {
		EntityManager em=JPAUtil.getEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Address vAddress=new Address();
		vAddress.setCity("Basti");
		vAddress.setState("Basti");
		vAddress.setStreet("Block Road");
		vAddress.setZipcode("219875");
		
		Address rAddress=new Address();
		rAddress.setCity("Lucknow");
		rAddress.setState("UP");
		rAddress.setStreet("MR Road");
		rAddress.setZipcode("211731");
		
		Student neha=new Student();
		neha.setStuName("neha lavania");
		neha.setStuAddress(vAddress);
		
		Student rishabh=new Student();
		rishabh.setStuName("rishabh agarwal");
		rishabh.setStuAddress(rAddress);
		
		et.begin();
		em.persist(neha);
		em.persist(rishabh);
		et.commit();
		System.out.println("data is inserted");
		
		System.out.println("========fetch=======");
		
	}

}
