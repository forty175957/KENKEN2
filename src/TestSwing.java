import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestSwing extends JFrame {
    GameMap map=GameMap.getInstance();
    Integer[][] m=new Integer[3][3];



    public TestSwing (){
        super("HelloWorld!");
        Container cp = getContentPane();
        //cp.add(new JLabel("Hello World!"));
        cp.setLayout(new GridLayout(3,3));
        GridBagConstraints c = new GridBagConstraints();
        c.gridheight=60;c.gridwidth=60;
        c.fill = GridBagConstraints.BOTH;
        c.ipadx=61;c.ipady=61;

        this.setResizable(false);
        c.fill=GridBagConstraints.BOTH;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        map.setFrame(this);
        /*JButton bt = new TestCell(0,0,1,cp);
        JButton bt2 = new TestCell(60,60,2,cp);
        JButton bt3= new TestCell(120,120,3,cp);
        JButton bt4 = new TestCell(0,60,4,cp);
        cp.add(bt4);
        c.gridx=0;c.gridy=0;
        cp.add(bt);
        c.gridx=1;c.gridy=1;
        cp.add(bt2);
        c.gridx=2;c.gridy=2;
        cp.add(bt3);*/
        Block b1=new Block(1);
        Cell c1=new Cell(0,0,b1);
        cp.add(c1);
        pack();
        setSize(new Dimension(182, 210));
        setVisible(true);
        //setExtendedState(JFrame.);
    }

    private class TestCell extends JButton{
        int x,y;
        String n;

        public TestCell(int x,int y,int n,Container cp){
            this.x = x;
            this.y = y;
            this.n = new Integer(n).toString();
            Border emptyBorder = BorderFactory.createEmptyBorder();
            setBorder(emptyBorder);
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("cell "+n+" pressed");
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            //paint(g);
            this.setBounds(this.x,this.y,60,60);
            this.setSize(new Dimension(60,60));
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(4));
            g2.drawString(this.n,30,30);
            g2.drawString("+",5,10);
            g2.drawLine(0,0,60,0);
            g2.setStroke(new BasicStroke(8));
            g2.drawLine(60,0,60,60);
            g2.setStroke(new BasicStroke(4));
            g2.drawLine(60,60,0,60);
            g2.setStroke(new BasicStroke(8));
            g2.drawLine(0,60,0,0);
        }
    }

    public static void main(String[] args) {
        new TestSwing();
    }

}