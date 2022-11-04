package application;

import java.util.Date;
import java.util.List;

import modal.entities.Department;
import modal.entities.Seller;
import model.dao.DaoFactory;
import model.dao.SellerDao;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sallerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== Test 1: seller findById ===");
		
		Seller seller = sallerDao.findById(3);
				
		System.out.println(seller);
		
		System.out.println("=== Test 2: seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> sellerList = sallerDao.findByDepartment(department);
		
		for(Seller obj : sellerList) {
			System.out.println(obj);
		}
		
		System.out.println("=== Test 3: seller findAll ===");
		List<Seller> sellerListAll = sallerDao.findAll();
		
		for(Seller obj : sellerListAll) {
			System.out.println(obj);
		}
		
		System.out.println("=== Test 4: seller insert ===");
		Seller sellerNew = new Seller(null,"Greg","greg@gmail.com",new Date(), 4000.0, department);
		
		sallerDao.insert(sellerNew);
		
		System.out.println("Inserted! new id = " + sellerNew.getId());

	}

}
