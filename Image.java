import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.*;
import java.text.DecimalFormat;

/**
 * Write a description of class Frame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Image  implements ActionListener
{
    //ModeloTabla modeloTabla;
    List lista;
    Masa masa;
    private JFrame frame, resultad, listado;
    private JPanel panelS, panelC, panelx,panelR,panelG, panelL;
    private JTextField cantidad,c_sal;
    private JSlider h2o, barra;
    private JButton smallerButton;
    private JButton largerButton;
    private JLabel sp,tH2o, pMm,pan ,harina, agua, sal,mm, harinaT, aguaT, salT, mmT,texto1,texto2, thT;
    
    
    private TableModel model;
    private AbstractTableModel tab;
    private JTable tablas;
    private static final String COMMA_SEPERATED = "###,###.00";
    public DefaultTableModel modelo;
    DecimalFormat decimalFormat = new DecimalFormat(COMMA_SEPERATED);
    private JTextArea areaTexto;
    private JScrollPane areaDeTexto;
    //public int tH;
    
    private String numCadena, numSal, area;
    public float resultado, Iharina, Iagua, Isal, Imm, tH;
    public int lk,can;
    
    /**
     * Constructor for objects of class Frame
     */
   
    
    
    public Image()
    {
        lista= new List();
        masa= new Masa();
        makeFrame();
        //modeloTabla = new ModeloTabla();
    }
    
    /**
     * Action listener 
     */
    public void actionPerformed(ActionEvent event)
    {
        System.out.println("Menu Item" + event.getActionCommand());
    }   
    
    /**
     * metodo que devuel el valor de la proporcion de masa madre
     */
    public int proporcionmm(){       
         int a=barra.getValue();
         return a; 
    }
    
    /***
     * devuelve el valor del agua
     */
    public int propocionAgua()
    {
        int b=h2o.getValue();
        return b;       
    }
    
    /**
     * comprobar si es entero
     */
    public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    
    }
    
    public static boolean isSal (String cadena_sal) {
        boolean check = true;
        Character c;
        
        String cadena = cadena_sal;
     for (int i = 0; i < (cadena_sal.length()); i++) {
        c = cadena.charAt(i);
        if (!Character.isDigit(c)) {
          if (c.equals('.') ) {
           
        } else {
           check = false;
           break;
        }
       }
     }
     return check;
    }    
    
    /**
     * metodo que abre un nuevo frame con el resultado del caluclo
     * lo llama el boton calculo.
     */
    public void resul(){
    
               numCadena= cantidad.getText();
               numSal=c_sal.getText();
               
               
               int numero=0;
               //double resultadoSal=0;
               if ((isNumeric(numCadena)== true ) && (isSal(numSal)== true)) {
                numero = Integer.parseInt(numCadena);
                tH= numero; 
                float resultadoSal=Float.parseFloat(numSal);
                    
                Font fuente = new Font("Lucida Console",Font.BOLD,20);
                Color myColor = new Color(244,246,215);
                
                resultad = new JFrame("Cantidades finales");
                resultad.setSize(500,700);
                resultad.setLocation(1000,500);
         
                texto1=new JLabel("RESULTADO");
               
              
                //llamada a metodos para el calculo.
                Iharina = lista.calculoHarina(tH, propocionAgua(), resultadoSal);
                Iagua = lista.calculoAgua(Iharina, propocionAgua());
                Isal = lista.calculoSal(Iharina, resultadoSal);
                Imm = lista. calculoMm(Iharina, proporcionmm());
                
                Iharina=lista.resultadoHarina(Imm, Iharina);
                Iagua=lista.resultadoAgua(Imm, Iagua);
                 
                // para de float  a string para poder imprimir. 
                String Sharina =String.valueOf(decimalFormat.format(Iharina));  
                String Sagua = String.valueOf(decimalFormat.format(Iagua));
                String Ssal = String.valueOf(decimalFormat.format(Isal));
                String Smm = String.valueOf(decimalFormat.format(Imm));            
                String stH = String.valueOf(decimalFormat.format(tH));
                
                
                pMm = new JLabel("Porcentaje masa madre");
                pan = new JLabel("Pan"); 
                harina = new JLabel("Harina");
                agua = new JLabel("Agua");
                sal = new JLabel("Sal");
                mm = new JLabel("Masa Madre");
                
                thT = new JLabel(stH + " gr");
                harinaT = new JLabel(Sharina + " gr");
                aguaT = new JLabel(Sagua + " gr");
                salT = new JLabel(Ssal + " gr");
                mmT = new JLabel(Smm + " gr");
               
                texto1.setFont(fuente);
                pMm.setFont(fuente);
                harina.setFont(fuente);
                agua.setFont(fuente);
                sal.setFont(fuente);
                mm.setFont(fuente);
                harinaT.setFont(fuente);
                aguaT.setFont(fuente);
                salT.setFont(fuente);
                mmT.setFont(fuente);
                pan.setFont(fuente);
                thT.setFont(fuente);       
                    
                resultad.setLayout(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
              
                gbc.gridx=0;//donde empieza
                gbc.gridy=0;
                gbc.gridwidth=2; //columnas
                gbc.gridheight=1; //filas
                gbc.weightx=1; // proporcion de como crece
                gbc.weighty=1;
                gbc.fill=GridBagConstraints.NONE;
                resultad.add(texto1, gbc);
                
                gbc.gridx=0;//donde empieza
                gbc.gridy=1;
                gbc.gridwidth=1; //columnas
                gbc.gridheight=1; //filas
                gbc.weightx=1; // proporcion de como crece
                gbc.weighty=1;
                gbc.fill=GridBagConstraints.NONE;
                resultad.add(pan, gbc);        
        
                gbc.gridx=1;//donde empieza
                gbc.gridy=1;
                gbc.gridwidth=1; //columnas
                gbc.gridheight=1; //filas
                gbc.weightx=1; // proporcion de como crece
                gbc.weighty=1;
                gbc.fill=GridBagConstraints.NONE;
                resultad.add(thT, gbc);    
        
                gbc.gridx=0;//donde empieza
                gbc.gridy=2;
                gbc.gridwidth=1; //columnas
                gbc.gridheight=1; //filas
                gbc.weightx=1; // proporcion de como crece
                gbc.weighty=1;
                gbc.fill=GridBagConstraints.NONE;
                resultad.add(harina, gbc);
        
                gbc.gridx=1;//donde empieza
                gbc.gridy=2;
                gbc.gridwidth=1; //columnas
                gbc.gridheight=1; //filas
                gbc.weightx=1; // proporcion de como crece
                gbc.weighty=1;
                gbc.fill=GridBagConstraints.NONE;
                resultad.add(harinaT, gbc);
        
                gbc.gridx=0;//donde empieza
                gbc.gridy=3;
                gbc.gridwidth=1; //columnas
                gbc.gridheight=1; //filas
                gbc.weightx=1; // proporcion de como crece
                gbc.weighty=1;
                gbc.fill=GridBagConstraints.NONE;
                resultad.add(agua, gbc);
        
                gbc.gridx=1;//donde empieza
                gbc.gridy=3;
                gbc.gridwidth=1; //columnas
                gbc.gridheight=1; //filas
                gbc.weightx=1; // proporcion de como crece
                gbc.weighty=1;
                gbc.fill=GridBagConstraints.NONE;
                resultad.add(aguaT, gbc);
        
                gbc.gridx=0;//donde empieza
                gbc.gridy=4;
                gbc.gridwidth=1; //columnas
                gbc.gridheight=1; //filas
                gbc.weightx=1; // proporcion de como crece
                gbc.weighty=1;
                gbc.fill=GridBagConstraints.NONE;
                resultad.add(mm, gbc);
        
                gbc.gridx=1;//donde empieza
                gbc.gridy=4;
                gbc.gridwidth=1; //columnas
                gbc.gridheight=1; //filas
                gbc.weightx=1; // proporcion de como crece
                gbc.weighty=1;
                gbc.fill=GridBagConstraints.NONE;
                resultad.add(mmT, gbc);
        
                gbc.gridx=0;//donde empieza
                gbc.gridy=5;
                gbc.gridwidth=1; //columnas
                gbc.gridheight=1; //filas
                gbc.weightx=1; // proporcion de como crece
                gbc.weighty=1;
                gbc.fill=GridBagConstraints.NONE;
                resultad.add(sal, gbc);
        
                gbc.gridx=1;//donde empieza
                gbc.gridy=5;
                gbc.gridwidth=1; //columnas
                gbc.gridheight=1; //filas
                gbc.weightx=1; // proporcion de como crece
                gbc.weighty=1;
                gbc.fill=GridBagConstraints.NONE;
                resultad.add(salT, gbc);
                
                //area de texto comentarios
                areaTexto = new JTextArea();
                areaDeTexto = new JScrollPane(areaTexto);
                areaTexto.setFont(fuente);
                areaDeTexto.getVerticalScrollBar();
                gbc.gridx=0;//donde empieza
                gbc.gridy=6;
                gbc.gridwidth=2; //columnas
                gbc.gridheight=1; //filas
                gbc.weightx=1; // proporcion de como crece
                gbc.weighty=1;
                gbc.fill=GridBagConstraints.BOTH;
                resultad.add(areaDeTexto,  gbc);
                
                
                
                JButton g = new JButton("GUARDAR");   
                gbc.gridx=0;//donde empieza
                gbc.gridy=7;
                gbc.gridwidth=2; //columnas
                gbc.gridheight=1; //filas
                gbc.weightx=1; // proporcion de como crece
                gbc.weighty=1;
                gbc.fill=GridBagConstraints.NONE;
                resultad.add(g, gbc);
                
                propocionAgua();
                String p_agua =String.valueOf(propocionAgua());
                String p_sal =String.valueOf(propocionAgua());
                String p_mm =String.valueOf(proporcionmm());
               
                g.addActionListener(e->grabar(stH,Sharina,p_agua,Sagua,numSal,Ssal,p_mm, Smm,area));
        
        
        
         //------------------------------------------------------------       
              
               
                //botonGrabar(tH,Iharina,Iagua,Isal,Imm); 
               // resultad.pack();
                resultad.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(resultad,"Introduce una cantidad","Advertencia",0);
            
        }
    }
    
    /*public void botonGrabar(String tH, String Iharina, String p_agua, String Iagua, String p_sal, String Isal, String p_mm, String Imm, String texto)
    {
        panelG = new JPanel();
        
        JButton botonG = new JButton("GUARDAR");
        panelG.add(botonG);
        //resultad.add(panelG, BorderLayout.SOUTH);
        botonG.addActionListener(e->grabar(tH,Iharina,p_agua,Iagua,p_sal, Isal,p_mm, Imm,area));
        //lista.escribir();
        
    }*/
    
    public String verificarTexto(String texto){
            //int a=0;
            //boolean ok=false;
            String textoFinal=" ";
            for (int x=0;x<texto.length();x++){
                    char as= texto.charAt(x);
                //int ascii=(int) texto.charAt(x);
                
                if(as=='\n'){
                 //a++;
                 textoFinal=textoFinal + " " ;  
                 //ok=true;       
                        }
                     else{textoFinal=textoFinal + String.valueOf(as);}
                    
                                 }               
            return textoFinal;                     
    }
    
    public void grabar(String tH, String Iharina, String p_agua, String Iagua, String p_sal, String Isal, String p_mm, String Imm, String texto)
    {
        area=areaTexto.getText(); 
        area=verificarTexto(area);
        
        if(area==null){
            area=" ";
            lista.inserta(tH,Iharina,p_agua,Iagua,p_sal, Isal,p_mm, Imm,area);
        }else{
            lista.inserta(tH,Iharina,p_agua,Iagua,p_sal, Isal,p_mm, Imm,area);
        }
        
        
        
           //lista.g();
           resultad.setVisible(false);  
    }
       
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void makeFrame()
    {
        frame = new JFrame("Calculadora masa de panadero ");
        frame.setSize(700,400);
        frame.setLocation(300,200);
        menu(frame);
            Color myColor = new Color(244,246,215);
            BorderLayout layout = new BorderLayout();
            //layout.setHgap(100);
            layout.setVgap(15);
            panelS = new JPanel();
            panelS.setLayout( layout);
            panelS.setBackground(myColor); 
           
            //boton calcula  
            JButton p = new JButton("Calcula");        
            panelS.add(p,BorderLayout.NORTH);
            p.addActionListener(e->resul());
            frame.add(panelS,BorderLayout.NORTH);      
            panelC = new JPanel();
            panelC.setLayout(new GridLayout(4,2,10,10));
            panelC.setBackground(myColor);
            sp = new JLabel("   ");
          
            //barra desplazamiento mm
            barra = new JSlider(20,50,40);
            barra.setMajorTickSpacing(5);
            barra.setFont(new Font("Serif",Font.BOLD,15));
            barra.setSnapToTicks(true);
            barra.setPaintTicks(true);
            barra.setPaintLabels(true);
            barra.setBackground(myColor);
            barra.addChangeListener(e->proporcionmm());
            
            // barra desplazamiento agua
            h2o = new JSlider(50,75,65);
            h2o.setMajorTickSpacing(5);
            h2o.setFont(new Font("Serif", Font.BOLD,15));
            h2o.setSnapToTicks(true);
            h2o.setPaintTicks(true);
            h2o.setPaintLabels(true);
            h2o.setBackground(myColor);
            h2o.addChangeListener(e->propocionAgua());
          
            //sal
            c_sal = new JTextField();
            c_sal.setFont(new Font("Serif",Font.BOLD,25));
            
            
            
            //pasar de int a string los metodos de calculo------------------------------- 
            cantidad = new JTextField(4);
            cantidad.setFont(new Font("Serif",Font.BOLD,25));
           
            pMm = new JLabel("  Porcentaje masa madre");
            pan = new JLabel("  Pan"); 
            tH2o = new JLabel("  Porcentaje de Agua");
            sal= new JLabel("Sal");
            pMm.setFont(new Font("Serif",Font.BOLD,20));
            pan.setFont(new Font("Serif",Font.BOLD,20));
            tH2o.setFont(new Font("Serif",Font.BOLD,20));
            sal.setFont(new Font("Serif",Font.BOLD,20));
            
            panelC.add(pMm);
            panelC.add(barra);
            panelC.add(tH2o);
            panelC.add(h2o);
            panelC.add(pan);
            panelC.add(cantidad);
            panelC.add(sal);
            panelC.add(c_sal);
        
            frame.add(panelC,BorderLayout.CENTER);  
            //frame.pack();
            frame.setVisible(true);
    }
       
    /**
     * Creacion de un menu de texto
     */
    public void menu(JFrame frame)
    {
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
     
        //menu file
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        fileMenu.setFont(new Font("Serif",Font.BOLD,20));
        
        JMenuItem openItem = new JMenuItem("Listado");
        openItem.addActionListener(e -> openFile());
        openItem.setFont(new Font("Serif",Font.BOLD,20));
        fileMenu.add(openItem);
        
        JMenuItem quitItem = new JMenuItem("Quit");
        quitItem.addActionListener(e -> quit());
        fileMenu.add(quitItem);
        quitItem.setFont(new Font("Serif",Font.BOLD,20));
    }
    
   
    
    /**
     * crea un panel con el resultado de la lectura del array.
     */
    public void openFile()
    {
        listado = new JFrame("Listado");
        listado.setBounds(400,300,1500,1500);
        panelL = new JPanel();
        Font fuente = new Font("Lucida Console",Font.BOLD,15);
        BorderLayout layout = new BorderLayout();
        panelL.setLayout(layout);
        panelL.setBackground(new Color(244,246,215));
        
        
        texto2 = new JLabel("LISTADO");
        texto2.setHorizontalAlignment(SwingConstants.CENTER);
        
        panelL.add(texto2);
        listado.add(panelL,BorderLayout.NORTH);
                
        tablas = new JTable(lista.leerBufer());
        //tablas.getAutoResizeMode();
        //tablas.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN); 
        //tablas.setSize(800,800);
        tablas.setFont(fuente);
        tablas.setRowHeight(30);
        //tablas.setEditingColumn(23);
        //tablas.getColumn(6).setPreferredWidth(50);
        JScrollPane scroll = new JScrollPane(tablas);
        listado.add((scroll),BorderLayout.CENTER);
        
        JScrollPane sc_fila = new JScrollPane();
        tablas.getColumnModel().getColumn(0).setPreferredWidth(40);//pan
        tablas.getColumnModel().getColumn(1).setPreferredWidth(25);
        tablas.getColumnModel().getColumn(2).setPreferredWidth(25);
        tablas.getColumnModel().getColumn(3).setPreferredWidth(25);
        tablas.getColumnModel().getColumn(4).setPreferredWidth(25);
        tablas.getColumnModel().getColumn(5).setPreferredWidth(25);
        tablas.getColumnModel().getColumn(6).setPreferredWidth(25);
        tablas.getColumnModel().getColumn(7).setPreferredWidth(25);
        tablas.getColumnModel().getColumn(8).setPreferredWidth(500);
        
       
        //listado.pack();
        listado.setVisible(true);
        
        
    }
      
    /**
     * salida del programa
     */
    private void quit()
    {
        System.exit(0);
    }
    
}
