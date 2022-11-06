package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

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
		
		System.out.println("=== Test 5: seller update ===");
		Seller sellerUpdate = sallerDao.findById(1);
		sellerUpdate.setName("Martha Waine");
		sallerDao.update(sellerUpdate);
		System.out.println("Update Completed!");

		System.out.println("=== Test 6: seller delete ===");
		System.out.println("Enter Id for delete test:");
		sallerDao.deleteById(new Scanner(System.in).nextInt());
		System.out.println("=== Excluse completed ===");
		
	}

}
