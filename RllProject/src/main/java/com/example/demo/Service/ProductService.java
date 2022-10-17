package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.Repository.ProductRepository;
import com.example.demo.bean.Product;

@Service
public class ProductService 
{
	@Autowired
	ProductRepository accountrepository;
	
 //add new Account
	public String storeAccount(Product account) 
	{
		accountrepository.save(account);
		return "account create Successfully";
	}
	
	
// get all account
	public List<Product> getAllAccount()
	{
		return accountrepository.findAll();
	}
	
	//find Account by id
	public String findAccountById(int aid) 
	{
		Optional<Product> result =accountrepository.findById(aid);
		if(result.isPresent()) 
		{
			Product acc = result.get();
			return acc.toString();
		}
		else 
		{
		    return "account not Present";	
		}
		
	}
	
	//delete account by id
	 public String DeleteAccount(int aid) 
		{
			Optional<Product> result =accountrepository.findById(aid);
			if(result.isPresent()) 
			{
				Product acc = result.get();
				accountrepository.delete(acc);
				return "account deleted successfully";
			}
			else 
			{
			    return "account not Present";	
			}
			
		}
	 
	 
	 public String updateAccount(Product account) 
		{
			Optional<Product> result =accountrepository.findById(account.getAid());
			if(result.isPresent()) 
			{
				Product acc = result.get();
				acc.setPrice(account.getPrice());
				acc.setUname(account.getUname());
				acc.setSeller(account.getSeller());
				acc.setDescription(account.getDescription());
				
			
				accountrepository.saveAndFlush(acc);
				return "Account updated successfully";
			}
			else 
			{
			    return "Account not Present";	
			}
			
		}

	

}
