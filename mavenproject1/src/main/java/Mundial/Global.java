/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mundial;

import com.poo_espol.mavenproject1.PrincipalProyecto;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public class Global {
     protected String nombre;
    protected int caso;
    protected int muerte;

    public Global(String nombre, int caso, int muerte) {
        this.nombre = nombre;
        this.caso = caso;
        this.muerte = muerte;
    }
    
     public static ArrayList<Global> cargarglobal(Global g) {
        ArrayList<Global> globales = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader(PrincipalProyecto.filerutes+"globales.csv"))){
            String linea;
            while((linea = bf.readLine())!=null){
                String lista[] = linea.split("\\|");
                int c = Integer.valueOf(lista[1].trim());
                int m = Integer.valueOf(lista[2].trim());
                globales.add(new Global(lista[0].trim(),c,m));
                 
            }
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         return globales;
     

    }
     
}
