import java.awt.*;  
  
public class kuva extends Canvas{  
      
    public void paint(Graphics g) {  
  
        Toolkit t=Toolkit.getDefaultToolkit();  
        Image i=t.getImage("buka.jpg");  
        g.drawImage(i, 120,100,this);  
          
    }  
}