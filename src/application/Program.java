package application;

import java.util.Date;

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
	}

}
