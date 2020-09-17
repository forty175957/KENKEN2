import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class RisolutoreGui extends JFrame {
    int counter=0;
    JTextField counterDisplay;
    ArrayList<int[][]> soluzioni;

    public RisolutoreGui(ArrayList<int[][]> s){
        super("RISOLUTORE-GUI");
        soluzioni=s;
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(1,4));
        this.setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setSize(new Dimension(600, 70));
        setVisible(true);
        JButton next=new JButton("NEXT");
        JButton previous=new JButton("PREVIOUS");
        counterDisplay = new JTextField("",2);
        counterDisplay.setEditable(false);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(counter!=soluzioni.size()-1){
                    counter++;
                    showMap(counter);
                }
            }
        });
        previous.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(counter!=0) {
                    counter--;
                    showMap(counter);
                }
            }
        });
        cp.add(previous);
        cp.add(counterDisplay);
        cp.add(next);
        showMap(counter);
    }

    public void showMap(int n) {
        counterDisplay.setText("Soluzione n: "+new Integer(counter).toString());
        int[][] currentSol = soluzioni.get(n);
        GameMap.getInstance().valueMatrix=currentSol;
        GameMap.getInstance().updateMap();
    }

}
