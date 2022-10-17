package medicines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: Abhinav Bhardwaj
 * Date: 14/10/22
 * Time: 19:48
 */

@RestController
@RequestMapping("eMedicare/medicines")
public class MedicineControllers {
    @Autowired
    MedicineServices medicineServices;


    // add new medicines
    @PostMapping("/newMedicine")
    public ResponseEntity<Object> newMedicine(@RequestBody MedicineObject newProd) {
        try {
            MedicineObject res = medicineServices.newMedicine(newProd);

            if(res != null) {
                return new ResponseEntity<Object>(res, HttpStatus.CREATED);
            }
            else {
                return new ResponseEntity<Object>("There is some issue, please try again later.", HttpStatus.NO_CONTENT);
            }
        }
        catch (Exception e) {
            return new ResponseEntity<Object>("Facing some issue while trying to add this medicine, please try with different name.", HttpStatus.BAD_REQUEST);
        }
    }


    // view all medicines
    @GetMapping("/allMedicines")
    public ResponseEntity<Object> allMedicines() {
        try {
            List<MedicineObject> res = medicineServices.allMedicines();

            if(res != null) {
                return new ResponseEntity<Object>(res, HttpStatus.CREATED);
            }
            else {
                return new ResponseEntity<Object>("Sorry !!! No medicine is available.", HttpStatus.NO_CONTENT);
            }
        }
        catch (Exception e) {
            return new ResponseEntity<Object>("Facing some issue while trying to fetch medicines, please try after some time.", HttpStatus.BAD_REQUEST);
        }
    }


    // get medicine by Id
    @GetMapping("/medicine")
    public ResponseEntity<Object> medicine(@RequestParam("medicineId") int medicineId) {
        try {
            List<MedicineObject> res = medicineServices.medicine(medicineId);

            if(res != null) {
                return new ResponseEntity<Object>(res, HttpStatus.CREATED);
            }
            else {
                return new ResponseEntity<Object>("Incorrect medicine id.", HttpStatus.NO_CONTENT);
            }
        }
        catch (Exception e) {
            return new ResponseEntity<Object>("Facing some issue while trying to fetch medicine, please try after some time.", HttpStatus.BAD_REQUEST);
        }
    }


    // get medicine by its name
    @GetMapping("/medicine/search")
    public ResponseEntity<Object> searchMedicine(@RequestParam("name") String name) {
        try {
            List<MedicineObject> res = medicineServices.searchMedicine(name);

            if(res != null) {
                return new ResponseEntity<Object>(res, HttpStatus.FOUND);
            }
            else {
                return new ResponseEntity<Object>("No medicine with such name.", HttpStatus.NO_CONTENT);
            }
        }
        catch (Exception e) {
            return new ResponseEntity<Object>("Facing some issue while trying to fetch this medicine, please try after some time.", HttpStatus.BAD_REQUEST);
        }
    }


    // update medicine using id
    @PutMapping("/medicine")
    public ResponseEntity<Object> updateMedicine(@RequestParam("medicineId") int medicineId,@RequestBody MedicineObject updatedMedicine) {
        try {
            List<MedicineObject> existingMedicineObject = medicineServices.medicine(medicineId);

            if(existingMedicineObject != null) {
                if(updatedMedicine.getName() != null) {
                    existingMedicineObject.get(0).setName(updatedMedicine.getName());
                }
                if(updatedMedicine.getPrice() > 0) {
                    existingMedicineObject.get(0).setPrice(updatedMedicine.getPrice());
                }
                if(updatedMedicine.getSeller() != null) {
                    existingMedicineObject.get(0).setSeller(updatedMedicine.getSeller());
                }
                if(updatedMedicine.getDescription() != null) {
                    existingMedicineObject.get(0).setDescription(updatedMedicine.getDescription());
                }

                return new ResponseEntity<Object>(medicineServices.updateMedicine(existingMedicineObject.get(0)), HttpStatus.CREATED);
            }
            else {
                return new ResponseEntity<Object>("Incorrect medicine Id.", HttpStatus.BAD_REQUEST);
            }
        }
        catch (Exception e) {
            return new ResponseEntity<Object>("Facing some issue while trying to update medicine details, please try with different medicine name or try after some time.", HttpStatus.BAD_REQUEST);
        }
    }


    // delete medicine by Id
    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteMedicine(@RequestParam("medicineId") int medicineId) {
        try {
            List<MedicineObject> existingMedicineObject = medicineServices.medicine(medicineId);

            if(existingMedicineObject != null) {
                medicineServices.medicine(medicineId);
                return new ResponseEntity<Object>("Medicine got deleted successfully.", HttpStatus.ACCEPTED);
            }
            else {
                return new ResponseEntity<Object>("Incorrect medicine id.", HttpStatus.NO_CONTENT);
            }
        }
        catch (Exception e) {
            return new ResponseEntity<Object>("Facing some issue while trying to delete the medicine, please try after some time.", HttpStatus.BAD_REQUEST);
        }
    }
}