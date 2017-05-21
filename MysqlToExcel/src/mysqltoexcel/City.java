/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqltoexcel;

/**
 *
 * @author wdfeww
 */
public class City {
    int id;
    String name;
    String countryCode;
    String district;
    long population;

    public City(int id, String name, String countryCode, String district, long population) {
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }

    public int getid() {
        return id;
    }

    public String getname() {
        return name;
    }

    public String getcountryCode() {
        return countryCode;
    }

    public String getdistrict() {
        return district;
    }

    public long getpopulation() {
        return population;
    }
    
}
