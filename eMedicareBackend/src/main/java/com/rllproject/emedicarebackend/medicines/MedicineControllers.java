package com.rllproject.emedicarebackend.medicines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/medicine/")
    @ResponseBody
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
}
