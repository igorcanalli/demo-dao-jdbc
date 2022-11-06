package model.dao;

import java.util.List;

import modal.entities.Department;
import modal.entities.Seller;

public interface SellerDao {
	
	void insert(Seller seller);

	void update(Seller seller);

	void deleteById(Integer seller);

	Seller findById(Integer id);

	List<Seller> findAll();
	
	List<Seller> findByDepartment(Department department);

}
