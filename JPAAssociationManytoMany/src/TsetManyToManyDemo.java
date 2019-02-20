

import java.util.Date;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.cg.ems.dto.Product;
import com.cg.ems.dto.Supplier;
import com.cg.ems.util.JPAUtil;

public class TsetManyToManyDemo {

	public static void main(String[] args) {
		EntityManager em=JPAUtil.getEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Product p1=new Product();
		p1.setProductCode(100);
		p1.setProdName("TV");
		p1.setProductPrice(1000);
		
		Product p2=new Product();
		p2.setProductCode(200);
		p2.setProdName("cd");
		p2.setProductPrice(2000);
		
		Product p3=new Product();
		p3.setProductCode(300);
		p3.setProdName("Refigirator");
		p3.setProductPrice(3000);
		
		Product p4=new Product();
		p4.setProductCode(400);
		p4.setProdName("DVD");
		p4.setProductPrice(4000);
		
		HashSet<Product> elecProSet=new HashSet<Product>();
		elecProSet.add(p1);
		elecProSet.add(p2);
		elecProSet.add(p3);
		elecProSet.add(p4);
		
		
		Supplier sony=new Supplier();
		sony.setSupplierId(111);
		sony.setSupplyDate(new Date());
		sony.setProductSet(elecProSet);
		
		Supplier lg=new Supplier();
		lg.setSupplierId(222);
		lg.setSupplyDate(new Date(2018,12,04));
		
			
		HashSet<Supplier> suppSet=new HashSet<Supplier>();
		suppSet.add(sony);
		suppSet.add(lg);
		
		p1.setSupSet(suppSet);
		
		et.begin();
		em.persist(sony);
		et.commit();
		
		System.out.println("product is inserted");
	}

}
