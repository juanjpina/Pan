
/**
 * Write a description of class Resultado here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;


public class Resultado extends JFrame implements ActionListener 
{
    
    private JTextArea area;
    private JLabel pan,harina,agua;
     
    
    
    
    
    /**
     * Constructor for objects of class Resultado
     */
    public Resultado()
    {
        super("GridBagLayout");
        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        area = new JTextArea();
        pan = new JLabel("hola");
        harina = new JLabel();
        agua = new JLabel();
        
        gbc.gridx=0;//donde empieza
        gbc.gridy=0;
        gbc.gridwidth=2; //columnas
        gbc.gridheight=1; //filas
        gbc.weightx=1; // proporcion de como crece
        gbc.weighty=1;
        gbc.fill=GridBagConstraints.BOTH;
        add(pan, gbc);
        this.setVisible(true);
        
        
        
        
        
        
    }
 
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void actionPerformed(ActionEvent e)
    {
        // put your code here
        
    }
}
