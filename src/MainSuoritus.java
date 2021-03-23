import javax.swing.JFrame;

public class MainSuoritus {
    public static void main(String[] args) {
        new Aloitusnaytto();
        kuva morko =new kuva();  
        JFrame f = new JFrame();
        f.add(morko);  
        f.setSize(600,600);  
        f.setVisible(true);
    
        }
}