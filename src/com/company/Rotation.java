package com.company;

public class Rotation {
    public int[] rz(double alfar,int[] vv)
    {
        double c1=Math.cos(alfar);
        double s1=Math.sin(alfar);
        double[][] rot={{1,0,0}, {0,c1,-s1},{0,s1,c1}};

        int[] vp=new int [3];
        for(int i=0;i<3;i++)
        {
            vp[i]=0;
            for(int j=0;j<3;j++)
                vp[i]=(int)(vp[i]+rot[i][j]*vv[j]);
        }
        return vp;
    }
}
