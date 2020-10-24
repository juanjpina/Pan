import java.io.Serializable;
/**
 * Write a description of class Masa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Masa implements Serializable 
{
    private static final long serialVersionUID=1L;
    public  String  pan, harina,agua,sal,mm;
    public  String p_agua,p_sal,p_mm;
    public String texto;
    
    /**
     * Constructor for objects of class Masa
     */
    public Masa(){}
    
    public Masa(String pan, String harina, String p_agua, String agua, String p_sal, String sal, String p_mm, String mm, String texto)
    {
        this.pan=pan;
        this.harina=harina;
        this.agua=agua;
        this.sal=sal;
        this.mm=mm;
        this.texto=texto;
        this.p_agua=p_agua;
        this.p_sal=p_sal;
        this.p_mm=p_mm;
    }

    public void setPan(){
        this.pan=pan;
    }
    
    public void setHarina(){
        this.harina=harina;
    }
    
    public void setAgua(){
        this.agua=agua;
    }
    
    public void setSal(){
        this.sal=sal;
    }
    
    public void setMm(){
        this.mm=mm;
    }
    
    public void setTexto(){
        this.texto=texto;
    }
    
    public void setp_agua(){
        this.p_agua=p_agua;
    }
    
    public void setp_sal(){
        this.p_sal=p_sal;
    }
    
    public void setp_mm(){
        this.p_mm=p_mm;
    }
    
    public String getPan(){
        return pan;
    }
    
    public String getHarina(){
        return harina;
    }
    
    public String getAgua(){
        return agua;
    }
    
    public String getSal(){
        return sal;
    }
    
    public String getMm(){
        return mm;
    }
    
    public String getTexto(){
        return texto;
    }
    
    public String getp_agua(){
        return p_agua;
    }
    
    public String getp_sal(){
        return p_sal;
    }
    
    public String getp_mm(){
        return p_mm;
    }
    
    public String toString(){
        return "Pan: " + pan + " harina: " + harina + " Agua: " + agua + " Sal: " + sal + " Masa Madre: " + mm + "Texto" + texto;
    }
}

