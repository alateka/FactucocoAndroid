// Author ==> Alberto Pérez Fructuoso
// File   ==> Invoice.java
// Date   ==> 2022/05/29

package tk.alateka.factucoco.model;

import java.io.Serializable;

public class Invoice implements Serializable {

    private int id;
    private String name;
    private String date;
    private float vatRate;
    private float vat;
    private float amount;
    private float total;
    private String description;

    public Invoice(int id, String name, String date, float vatRate, float vat, float amount, float total, String description) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.vatRate = vatRate;
        this.vat = vat;
        this.amount = amount;
        this.total = total;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getVatRate() {
        return vatRate;
    }

    public void setVatRate(float vatRate) {
        this.vatRate = vatRate;
    }

    public float getVat() {
        return vat;
    }

    public void setVat(float amount) {
        this.vat = amount;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
