package com.example.ardin.tryblutooth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import java.io.FileWriter;
import java.util.Arrays;

public class RealTomkins extends AppCompatActivity {
    //int[] ecgdataset = new int[] {0,103,101,101,100,97,94,89,84,80,76,72,70,75,72,71,72,73,73,73,72,70,74,73,73,73,73,71,74,75,73,71,69,67,65,70,76,77,77,76,73,71,75,77,77,76,76,76,70,58,74,104,109,85,40,8,137,144,93,78,79,80,79,80,82,80,81,82,82,84,85,84,89,88,91,94,97,97,97,97,100,98,96,95,93,88,84,81,79,76,76,75,77,75,74,75,75,74,73,74,76,76,74,76,77,77,76,74,75,71,67,65,68,76,76,79,77,75,72,76,78,78,76,76,76,76,60,54,81,0,67,65,68,76,76,79,77,75,72,76,78,78,76,76,76,76,60,54,81,0};
    int[] ecgdataset = new int[]{0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            159,
            159,
            159,
            159,
            159,
            159,
            159,
            159,
            159,
            159,
            159,
            159,
            159,
            160,
            159,
            159,
            159,
            159,
            160,
            159,
            160,
            159,
            159,
            166,
            174,
            182,
            189,
            195,
            201,
            206,
            210,
            213,
            214,
            216,
            217,
            217,
            215,
            212,
            208,
            203,
            198,
            191,
            183,
            175,
            165,
            160,
            159,
            159,
            159,
            159,
            159,
            159,
            159,
            160,
            159,
            160,
            159,
            159,
            160,
            158,
            167,
            195,
            225,
            254,
            283,
            312,
            341,
            370,
            400,
            428,
            458,
            486,
            515,
            546,
            546,
            515,
            486,
            458,
            428,
            400,
            370,
            341,
            312,
            283,
            254,
            225,
            195,
            168,
            156,
            151,
            142,
            135,
            127,
            119,
            113,
            104,
            99,
            104,
            112,
            120,
            127,
            135,
            142,
            150,
            157,
            160,
            159,
            159,
            159,
            159,
            159,
            159,
            159,
            159,
            159,
            159,
            159,
            160,
            167,
            175,
            182,
            190,
            197,
            204,
            210,
            216,
            222,
            227,
            232,
            236,
            239,
            242,
            244,
            246,
            247,
            247,
            246,
            245,
            243,
            241,
            237,
            234,
            229,
            225,
            219,
            213,
            207,
            200,
            193,
            186,
            178,
            171,
            163,
            159,
            159,
            159,
            159,
            159,
            159,
            159,
            159,
            159,
            159,
            159,
            159,
            159,
            159,
            159,
            159,
            159,
            159,
            159,
            159,
            159,
            159,
            159,
            160,
            162,
            164,
            166,
            167,
            168,
            168,
            168,
            167,
            165,
            163,
            161,
            159,
            159,
            159,
            159,
            159,
            159,
            159,
            159,
            159,
            159,
            159,
            159
    };
    int i = 63;
    int n = 0;
    int t = 1;
    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    int h;
    int j;
    double tran;
    double movewin;
    int sensorValue[] = new int[250];
    int lowPass[] = new int[250];
    int highPass[] = new int[250];
    double transferFunc[] = new double[260];
    double squareFunc[] = new double[250];
    double movingwindowin[] = new double[300];
    int lowpassone;
    int lowpasstwo;
    int highpassone;
    double movingwinone;
    double firstmiv = 0.0222222222;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_tomkins);

        while(i!=250){
        ecg();
        //if(i == 250){
        //    i = 50;
        //}
    }
        for(int count=200; count<=250; count++){
            System.out.format("fucking morwin %f%n", movingwindowin[count]);
        }
    }
    public void ecg() {

        //sensorValue[i] = i;
        sensorValue[i] = ecgdataset[i];
        n=i;
        a = (n*t)-t;
        b = (n*t)-(2*t);
        c = n*t;
        d = (n*t)-(6*t);
        e = (n*t)-(12*t);
        f = (n*t)-(16*t);
        g = (n*t)-(32*t);
        h = (n*t)+t;
        j = (n*t)+(2*t);
        //tran = 1/(8*t);
        tran = 0.125;
        movewin = 0.01;
        lowpassone = 2*lowPass[a];
        lowpasstwo = 2*ecgdataset[d];
        highpassone = 32*lowPass[f];

        //System.out.format("The data number is: %d%n", i);
        //low pass
        //System.out.format("The value of lenght is: %d%n", ecgdataset.length);

        //lowPass[i]=(2*lowPass[a])-lowPass[b]+sensorValue[c]-(2*sensorValue[d])+sensorValue[e];

        //lowPass[i]=2*lowPass[a]-lowPass[b]+sensorValue[c]-2*sensorValue[d]+sensorValue[e];
        //System.out.format("The value of lowpass is: %d%n", lowPass[i]);

            lowPass[i] = lowpassone - lowPass[b] + ecgdataset[c] - lowpasstwo + ecgdataset[e];
            //high pass

            highPass[i] = highpassone - (highPass[a]+lowPass[c]-lowPass[g]);

        //System.out.format("The value of bandpass is: %d%n", highPass[i]);
        //now output are band pass

        //transfer function
        //transferFunc[i]=tran*((-1*highPass[b])-(2*highPass[a]));

        //transferFunc[i-2]=tran*(-highPass[b]-(2*highPass[a]));
        transferFunc[i-2]=tran*(-highPass[i-4]-(2*highPass[i-3])+(2*highPass[i-1])+highPass[i]);
        //+(2*highPass[h])+highPass[j]
        //System.out.format("The value of transfer is: %.10f%n", transferFunc[i]);
        //System.out.format("The value of tran is: %d%n", tran);
        //System.out.format("Tran is: %.10f%n", tran);
        //squaring function

        squareFunc[i-2] = transferFunc[i-2]*transferFunc[i-2];

        //System.out.format("The value of square is: %.10f%n", squareFunc[i]);

        //moving window integration
        for(int mvi=0; mvi<=45; mvi++){
            movingwinone = movingwinone + squareFunc[i-45+mvi];
        }
        movingwindowin[i-45]=firstmiv*movingwinone;
        //printout
        //System.out.format("The data number is: %d%n", i);
        //System.out.format("The value of a is: %d%n", a);
        //System.out.format("The value of b is: %d%n", b);
        //System.out.format("The value of c is: %d%n", c);
        //System.out.format("The value of d is: %d%n", d);
        //System.out.format("The value of e is: %d%n", e);
        //System.out.format("The value of lowpass[a] is: %d%n", lowPass[a]);
        //System.out.format("The value of lowpass[b] is: %d%n", lowPass[b]);
        //System.out.format("The value of sensor[c] is: %d%n", sensorValue[c]);
        //System.out.format("The value of sensor[d] is: %d%n", sensorValue[d]);
        //System.out.format("The value of sensor[e] is: %d%n", sensorValue[e]);
        //System.out.format("i %d%n", i-12);
        //System.out.format("data %d%n", ecgdataset[i-12]);
        //System.out.format("sensor %d%n", sensorValue[i-12]);
        ////////
        //System.out.format("fucking lowpassone %d%n", lowpassone);
        //System.out.format("fucking lowPass[b] %d%n", lowPass[b]);
        //System.out.format("fucking ecgdataset[c] %d%n", ecgdataset[c]);
        //System.out.format("fucking lowpasstwo %d%n", lowpasstwo);
        //System.out.format("fucking ecgdataset[e] %d%n", ecgdataset[e]);
        //System.out.format("fucking lowpass %d%n", lowPass[i-12]);
        //System.out.format("fucking highpass %d%n", highPass[i-12]);
        //System.out.format("fucking transfer %f%n", transferFunc[i-12]);
        //System.out.format("fucking square %f%n", squareFunc[i-12]);
        System.out.format("fucking square %f%n", movingwindowin[i-45]);
        ////////
        //System.out.format("The value of bandpass is: %d%n", highPass[i]);
        //System.out.format("The value of transfer is: %.10f%n", transferFunc[i]);
        //System.out.format("The value of square is: %.10f%n", squareFunc[i]);


        //if(i>=200){
        //    sensorValue[i-200] = sensorValue[i];
        //    lowPass[i-200] = lowPass[i];
        //    highPass[i-200] = highPass[i];
        //}
        i++;

    }
}
