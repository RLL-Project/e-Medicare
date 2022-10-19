package com.medicare;
import static org.junit.Assert.assertTrue;   
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.medicare.medicines.Medicines;
import com.medicare.cart.Cart;
import com.medicare.cart.CartRepository;
import com.medicare.cart.CartService;
import com.medicare.cart.CartServiceImpl;
import com.medicare.medicines.MedicineRepository;
import com.medicare.medicines.MedicineService;
import com.medicare.medicines.MedicineServiceImpl;



@RunWith(Suite.class)
@SuiteClasses({ })
@SpringBootTest
public class CartTest {
	@Autowired
	CartService cs;
	@Autowired 
	CartRepository cr;

	@Test
	@DisplayName("GET Cart details")
	public void getallcartTest(){

	    List<Cart> as = cs.getCart();
	 double rs =as.size();
	 assertTrue(rs>0);

	}
	



	@Test
	@DisplayName("Delete Medicine")
	public void deletecarttest() {
	Cart ce =new Cart();
	ce.setMedicineId(5);
	cs.deleteCart(5);
	assertFalse(cr.existsById(ce.getMedicineId()));
	}
}
