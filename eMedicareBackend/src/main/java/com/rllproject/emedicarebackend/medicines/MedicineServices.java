package com.rllproject.emedicarebackend.medicines;

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
}
