package com.company;

import java.awt.*;
import javax.swing.*;

public class Panel extends JPanel implements Runnable {

    public int[] screen(int v0[],int[] vv){
        int[] xs= new int[2];
        xs[0]=(int)(v0[0]-vv[0]*0.7071/2+vv[1]);
        xs[1]=(int)(v0[1]+vv[0]*0.7071/2-vv[2]);
        return xs;
    }//end screen

    Thread t;
    int x0=400, y0=400, z0=0, xk=200, yk=200, zk=200;
    int[]v0={x0,y0,z0};
    int[]v1={xk,0,0};
    int[]v2={0,yk,0};
    int[]v3={0,0,zk};
    int[]v12={xk,yk,0};
    int[]v23={0,yk,zk};
    int[]v13={xk,0,zk};
    int[]v123={xk,yk,zk};

    int[] v1r=new int[3];
    int[] v2r=new int[3];
    int[] v3r=new int[3];
    int[] v12r=new int[3];
    int[] v23r=new int[3];
    int[] v13r=new int[3];
    int[] v123r=new int[3];

    int[] s1=new int[3];
    int[] s2=new int[3];
    int[] s3=new int[3];
    int[] s12=new int[3];
    int[] s23=new int[3];
    int[] s13=new int[3];
    int[] s123=new int[3];

    public Panel(){
        t=new Thread(this);
        t.start();

    }

    public void run(){
        double a=0;
        double amax=100000*Math.PI;
        while(a<amax){
            Rotation rot = new Rotation();
            v1r=rot.rz(a, v1);
            v2r=rot.rz(a, v2);
            v3r=rot.rz(a, v3);
            v12r=rot.rz(a, v12);
            v23r=rot.rz(a, v23);
            v13r=rot.rz(a, v13);
            v123r=rot.rz(a, v123);
            repaint();
            try{
                t.sleep(10);
            }catch (InterruptedException e){}
            a=a+0.020;
        }
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 =(Graphics2D)g;
        g2.drawLine(0,400,800,400);
        g2.drawLine(400,0,400,800);
        BasicStroke dim1 = new BasicStroke(3f);
        g2.setStroke(dim1);
        g2.drawLine(x0,y0,x0-400,y0+400);
        g2.drawLine(x0, y0, x0+400, y0);
        g2.drawLine(x0, y0, x0, y0-400);
        BasicStroke dim2 = new BasicStroke(5f);


        g2.setStroke(dim2);
        g2.setColor(Color.BLUE);

        s1=screen(v0,v1r);
        g2.setColor(Color.RED);
        g2.drawLine(s1[0], s1[1], s1[0], s1[1]);
        g2.drawLine(x0,y0,s1[0],s1[1]);
        g2.setColor(Color.BLUE);

        s2=screen(v0,v2r);
        g2.drawLine(s2[0], s2[1], s2[0], s2[1]);
        g2.drawLine(x0,y0,s2[0],s2[1]);

        s3=screen(v0,v3r);

        g2.drawLine(s3[0], s3[1], s3[0], s3[1]);
        g2.drawLine(x0,y0,s3[0],s3[1]);


        s12=screen(v0,v12r);

        g2.drawLine(s12[0], s12[1], s12[0], s12[1]);
        g2.drawLine(s1[0], s1[1], s12[0], s12[1]);
        g2.drawLine(s2[0], s2[1], s12[0], s12[1]);

        s23=screen(v0,v23r);

        g2.drawLine(s23[0], s23[1], s23[0], s23[1]);
        g2.drawLine(s2[0], s2[1], s23[0], s23[1]);
        g2.drawLine(s3[0], s3[1], s23[0], s23[1]);

        s13=screen(v0,v13r);
        g2.drawLine(s13[0], s13[1], s13[0], s13[1]);
        g2.drawLine(s1[0], s1[1], s13[0], s13[1]);
        g2.drawLine(s3[0], s3[1], s13[0], s13[1]);

        s123=screen(v0,v123r);

        g2.drawLine(s123[0], s123[1], s123[0], s123[1]);
        g2.drawLine(s23[0], s23[1], s123[0], s123[1]);
        g2.drawLine(s13[0], s13[1], s123[0], s123[1]);

        g2.drawLine(s12[0], s12[1], s123[0], s123[1]);
    }
}
