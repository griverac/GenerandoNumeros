/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package generadordenumeros;
import java.io.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author Libni
 */
public class Acciones {
    //Scanner scanner = new Scanner(System.in);
    
    public static void generarArchivo() {
        JFrame jFrame = new JFrame();
        try {
            BufferedWriter escribir = new BufferedWriter(new FileWriter("numeros.txt"));
            Random random = new Random();
            
            for (int i = 0; i < 1000000; i++) {
                int numero = random.nextInt(20000001) - 10000000;
                escribir.write(String.valueOf(numero));
                escribir.newLine();
            }
            
            escribir.close();
            JOptionPane.showMessageDialog(jFrame,"GENERADO EXITOSAMENTE.");
        } catch (IOException e) {
            System.out.println("Error de generación.");
        }
    }
    
    public static void ordenarArchivo() {
        JFrame jFrame = new JFrame();
        try {
            BufferedReader leer = new BufferedReader(new FileReader("numeros.txt"));
            List<Integer> numeros = new ArrayList<>();
            String linea;
            
            while ((linea = leer.readLine()) != null) {
                numeros.add(Integer.parseInt(linea));
            }
            
            leer.close();
            Collections.sort(numeros);
            
            BufferedWriter escribir = new BufferedWriter(new FileWriter("ORDENADOS.txt"));
            
            for (int numero : numeros) {
                escribir.write(String.valueOf(numero));
                escribir.newLine();
            }
            
            escribir.close();
            JOptionPane.showMessageDialog(jFrame,"ARCHIVO ORDENADO.");
        } catch (IOException e) {
            System.out.println("ERROR AL PROCESAR EL ORDEN.");
        }
        
    }
    
}
