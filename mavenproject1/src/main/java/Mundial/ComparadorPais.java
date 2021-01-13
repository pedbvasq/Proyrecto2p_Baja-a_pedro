/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mundial;

import java.util.Comparator;

/**
 *
 * @author pedro
 */
public class ComparadorPais implements Comparator<Country>{

    @Override
    public int compare(Country c1, Country c2) {
        if (c1.getMuerte() < c2.getMuerte()) {
                return 1;
            } else if (c1.getMuerte() > c2.getMuerte()) {
                return -1;
            }
        return 0;
       
    }
    
}
