import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.*;
/**
 * Write a description of class List here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class List
{
    ArrayList<Masa> lista;
    ArrayList<String> listaInteger;
    private static final long serialVersionUID=1L;
    private float pan,harina,agua,sal,mm;
    public static float total_Harina_Final;
    Image image;
    DefaultTableModel modelo;
      
    /**
     * Constructor for objects of class List
     */
    public List()
    {
        
        lista = new ArrayList<Masa>();
        
    }
 
    public void listar(){
        
        for(Masa x: lista){
        
        System.out.println(x);
       }
        
        
    }
    
    /**
     * calcula la cantidad de harina
     * @param la cantidad de pan que quieres hacer
     * @return la harina que se necesita para hacer el pan
     */
    public float calculoHarina(float pan, float agua, float sal)
    {       
        float totalHarina=pan*100/(agua+sal+100);
        return totalHarina;
    }
    
    /**
     * calcula la cantidad de agua
     * @param la cantidad de pan que quieres hacer
     * @return el agua que se necesita para hacer el pan
     */
    public float calculoAgua(float totalHarina, float agua)
    {
        agua=totalHarina*agua/100;        
        return agua;
    }
    
    /**
     * calcula la cantidad de sal
     * @param la cantidad de pan que quieres hacer
     * @return la sal que se necesita para hacer el pan
     */
    public float calculoSal(float totalHarina, float sal)
    {
        sal = totalHarina*sal/100;
        return sal;
    }
    
    /**
     * calcula la cantidad de masa madre
     * @param la cantidad de pan que quieres hacer
     * @return la masa madre que se necesita para hacer el pan
     */
    public float calculoMm(float totalHarina, float porcentaje)
    {
        float mm_Total= totalHarina*porcentaje/100;     
        return mm_Total;
    }
    
    /**
     * Calcula la harina final menos la masa madre
     * @param recibe los total de harina y de masa madre
     * @return el total de harina que se necesita.
     */
    public float resultadoHarina(float mm_Total, float totalHarina)
    {
        total_Harina_Final=totalHarina-(mm_Total/2);
        return total_Harina_Final;
    }
       
    /**
     * Calcula el agua final menos la masa madre
     * @param recibe los gramos de pan y el porcentaje para la masa madre
     * @return el total de agua que se necesita.
     */
    public float resultadoAgua(float mm_Total, float agua)
    {   
        float total_Agua_Final=agua-(mm_Total/2);
        return total_Agua_Final;
    }
    
    public void calculo(int pan, int cAgua, int porcentaje, int totalHarina)
    {
        System.out.println(calculoHarina(pan,sal,agua));
        System.out.println(calculoAgua(pan, cAgua));
        System.out.println(calculoSal(totalHarina, sal));
        System.out.println(calculoMm(totalHarina, porcentaje));
    
    }
    
    /**
     * este metodo no sirve para el programa
     */
    public void escribir(){
        try{
        ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream("C:/Users/Juanjo/Downloads/masa/fichero.txt",true));
        escribir.writeObject(lista);
        escribir.close();
        }catch(Exception e){        
        
        }
    }
    
    /**
     * este metodo es de prueba no sirve para el programa 
     */
        public void leer(){
        try{
            
            //ObjectInputStream leer = new ObjectInputStream(new FileInputStream("C:/Users/Juanjo/Downloads/masa/fichero.txt"));
            //ArrayList<Masa> listaRecuperada =(ArrayList<Masa>) leer.readObject();
            
            for(Masa x: lista){
        
                System.out.println(x);
            }
            //leer.close();
        }catch(Exception e){
       
        }
        
    }
    
    
    
    
    
    /**
     * metodo que imprime en pantalla el resultado. en un tabla.
     */
    public DefaultTableModel leerBufer(){
     String nombreFichero ="C:/Users/Juanjo/Downloads/masa/ficheros.txt";
        
     modelo = new DefaultTableModel();  
     
     modelo.addColumn("PAN");
     modelo.addColumn("HARINA");
     modelo.addColumn("PORCENTAJE");
     modelo.addColumn("AGUA");
     modelo.addColumn("PORCENTAJE");
     modelo.addColumn("SAL");
     modelo.addColumn("PORCENTAJE");
     modelo.addColumn("MASA MADRE");
     modelo.addColumn("COMENTARIOS");
     
     
     try{
            BufferedReader br = new BufferedReader(new FileReader(nombreFichero));
            String listaRecuperada;
             while((listaRecuperada = br.readLine()) !=null){
            
                Object[] fila = new Object[9]; 
                String[] a =listaRecuperada.split("\t");
                fila[0] = a [0];
                fila[1] = a [1];
                fila[2] = a [2];
                fila[3] = a [3];
                fila[4] = a [4];
                fila[5] = a [5];
                fila[6] = a [6];
                fila[7] = a [7];
                fila[8] = a [8];
                
              
                modelo.addRow(fila);
                
                
            }
            br.close();            
          }catch(Exception e){       
        }   
        return modelo;
    }
    
    
    
    /**
     * crea una lista de producto.
     * Es llamado desde la clase image para crear un objeto cada vez.
     */
     public void inserta(String pan, String harina, String p_agua,String agua,String p_sal, String sal,String p_mm, String mm, String texto){      
         Masa m = new Masa(pan,harina,p_agua,agua,p_sal,sal,p_mm,mm,texto);
         lista.add(m);
         g();
    }
    
    /**
     * guarda los datos en un fichero. 
     * Es llamado desde la clase image.
     */
    public void g(){
        File fichero = new File("C:/Users/Juanjo/Downloads/masa/ficheros.txt");
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(fichero,true));
        
            for(Masa m:lista){
                
                bw.write(m.getPan()+ "\t" + m.getHarina() +
                        "\t" + m.getp_agua() + "\t" + m.getAgua() + 
                        "\t" + m.getp_sal() +"\t" + m.getSal() +
                        "\t" + m.getp_mm() + "\t" +m.getMm() +
                        "\t" + m.getTexto() + "\n");
                }
                bw.close();
        }catch(Exception ex){}   
        }
}
    
    
   