/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primaverastay;

/**
 *
 * @author Potpot
 */
public class Unit {
    
 private int unitId;
    private String unitNumber;
    private String unitType;
    private int capacity;
    private double pricePerNight;
    private String status;

    public Unit(int unitId, String unitNumber, String unitType,
                int capacity, double pricePerNight, String status) {

        this.unitId = unitId;
        this.unitNumber = unitNumber;
        this.unitType = unitType;
        this.capacity = capacity;
        this.pricePerNight = pricePerNight;
        this.status = status;
    }

    public int getUnitId() {
        return unitId;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public String getUnitType() {
        return unitType;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public String getStatus() {
        return status;
    }
}
