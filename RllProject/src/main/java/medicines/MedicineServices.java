package medicines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: Abhinav Bhardwaj
 * Date: 14/10/22
 * Time: 19:47
 */

@Service
public class MedicineServices {

    @Autowired
    MedicineJPARepo medicineJPARepo;

    // to add a new medicine
    public MedicineObject newMedicine(MedicineObject newProd) {
        return medicineJPARepo.save(newProd);
    }

    // to get all the medicines
    public List<MedicineObject> allMedicines() {
        return medicineJPARepo.findAll();
    }

    // to get a particular medicine using medicineId
    public List<MedicineObject> medicine(int medicineId) {
        return medicineJPARepo.findById(medicineId);
    }


    // to get a particular medicine using its name
    public List<MedicineObject> searchMedicine(String name) {
        return medicineJPARepo.findByName(name);
    }


    public MedicineObject updateMedicine( MedicineObject updatedMedicine) {
        return medicineJPARepo.save(updatedMedicine);
    }

    public void deleteMedicine( int medicineId) {
        medicineJPARepo.deleteById(medicineId);
    }

	public List<MedicineObject> searchMedicine(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
