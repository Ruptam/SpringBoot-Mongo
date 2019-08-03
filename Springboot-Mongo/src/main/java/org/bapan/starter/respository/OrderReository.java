/**
 * 
 */
package org.bapan.starter.respository;

import java.util.List;

import org.bapan.starter.entity.Order;
import org.bapan.starter.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * @author Ruptam
 *
 */
public interface OrderReository extends MongoRepository<User, Integer> {

	List<User> findByName(String name);

	@Query("{'Address.city':?0}")
	List<User> findByCity(String city);
	
	@Query("{'Orders.productName':?0}")
	List<User> findByProductName(String productName);
}
