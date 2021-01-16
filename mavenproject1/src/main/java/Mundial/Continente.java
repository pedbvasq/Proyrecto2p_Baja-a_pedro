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
public class Continente {

    private String nombre;

    public Continente(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return  nombre ;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    

    public static ArrayList<Continente> cargarContinente() {
       
        ArrayList<Continente> continentes = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader(PrincipalProyecto.filerutes+"continentes.txt"))){
            String linea;
            while((linea = bf.readLine())!=null){
                continentes.add(new Continente(linea.trim()));
                
            }
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return continentes;
        
      

    } 
    
}
