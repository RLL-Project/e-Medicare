package medicines;
package com.rllproject.emedicare.medicines;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA
 * User: Abhinav Bhardwaj
 * Date: 14/10/22
 * Time: 19:39
 */

@Entity
public class MedicineObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int medicineId;

    @Column(unique = true)
    private String name;
    private float price;
    private String seller;
    private String description;


    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}