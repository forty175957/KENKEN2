import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestSwing extends JFrame {
    GameMap map=GameMap.getInstance();
    Integer[][] m=new Integer[3][3];
    public Container cp;


    public  TestSwing(int a){
        super("KENKEN-MAP");
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(3,3));
        this.setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        map.setFrame(this);
        map.createMap();
        pack();
        setSize(new Dimension(188, 216));
        setVisible(true);
        //Risolutore Res = new Risolutore(GameMap.getInstance().blocks.get(3));
    }

    private class TestCell extends JButton{
        int x,y;
        String n;
        Container cp;

        public TestCell(int x,int y,int n){
            this.x = x;
            this.y = y;
            cp=cp;
            this.n = new Integer(n).toString();
            Border emptyBorder = BorderFactory.createEmptyBorder();
            setBorder(emptyBorder);
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("TestCell "+n+" pressed");
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            /*paint(g);
            this.setBounds(this.x,this.y,60,60);
            this.setLocation(this.x,this.y);
            this.setSize(new Dimension(60,60));*/
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(2));
            g2.drawString(this.n,30,30);
            g2.drawString("+",5,10);
            g2.drawLine(0,0,60,0);
            g2.setStroke(new BasicStroke(2));
            g2.drawLine(60,0,60,60);
            g2.setStroke(new BasicStroke(2));
            g2.drawLine(60,60,0,60);
            g2.setStroke(new BasicStroke(2));
            g2.drawLine(0,60,0,0);
        }
    }

    public static void main(String[] args) {
        new TestSwing(1);
    }

}