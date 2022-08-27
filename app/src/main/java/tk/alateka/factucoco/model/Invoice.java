// Author ==> Alberto Pérez Fructuoso
// File   ==> Invoice.java
// Date   ==> 2022/05/29

package tk.alateka.factucoco.model;

public class Invoice {

    private int id;
    private String name;
    private String date;
    private float vatRate;
    private float amount;
    private float total;

    public Invoice(int id, String name, String date, float vatRate, float amount, float total) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.vatRate = vatRate;
        this.amount = amount;
        this.total = total;
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
}
