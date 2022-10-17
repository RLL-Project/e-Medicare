package medicines;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: Abhinav Bhardwaj
 * Date: 14/10/22
 * Time: 19:46
 */

public interface MedicineJPARepo extends JpaRepository<MedicineObject, Integer> {
    List<MedicineObject> findById(int productId);
    List<MedicineObject> findByName(String name);
}