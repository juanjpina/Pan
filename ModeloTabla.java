import javax.swing.table.AbstractTableModel;
import javax.swing.table.*;
/**
 * Write a description of class Jtable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ModeloTabla extends AbstractTableModel
{
    
   String [] colum ={"PAN","HARINA","AGUA","SAL","MASA MADRE","COMENTARIOS"};  
   List list;
   
   public ModeloTabla()
   {
    this.list=list;
   }
    
   public int getColumnCount()
    {
        return 6;
    }
    
    public int getRowCount()
    {
        return 6;
    }
    
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        
        
        
        
        
        return null; 
    } 
    
    
    
    
    
    
}
