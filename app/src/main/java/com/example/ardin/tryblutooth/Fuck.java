package com.example.ardin.tryblutooth;
//////////////////////
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//import android.widget.TextView;


//////////////////////
import android.graphics.Color;
//import android.os.Bundle;
import android.util.Log;
//import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendForm;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.components.YAxis.AxisDependency;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;
//import com.xxmassdeveloper.mpchartexample.notimportant.DemoBase;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;

///////////////////sss//////////////////
public class Fuck extends AppCompatActivity implements
        OnChartValueSelectedListener {
    private LineChart mChart;
    //float[] ecgdataset = new float[] {0f,15.6f,16f,16.1f,16.2f,16.1f,16.1f,15.6f,14.8f,13.8f,13.1f,12.8f,12.7f,12.3f,12.2f,12.5f,13f,13.6f,13.7f,13.7f,13.9f,14f,13.8f,13f,12.3f,11.8f,11.7f,11.5f,11.1f,10.8f,11f,11.4f,11.9f,12.1f,12.4f,12.8f,13.1f,13f,12.7f,12.2f,12.2f,11.8f,11.3f,10.6f,10.2f,10.3f,10.5f,10.6f,10.7f,11.1f,11.6f,12f,12.1f,12.2f,12.5f,12.6f,12.5f,11.8f,11.3f,10.9f,10.8f,10.5f,9.8f,9.6f,9.6f,10.1f,10.4f,10.3f,10.7f,11.1f,11.6f,11.6f,11.3f,11.1f,10.9f,10.7f,10f,9f,8.4f,8.2f,8.2f,8.1f,8.1f,8.5f,9.2f,9.9f,10.4f,10.5f,10.6f,10.8f,10.5f,9.8f,8.6f,7.7f,7.3f,6.8f,6.1f,5.7f,5.7f,6.2f,6.6f,6.7f,7.1f,7.3f,7.8f,7.7f,7.1f,6.6f,5.9f,5.3f,4.5f,3.7f,3.2f,3.2f,3.4f,3.5f,3.8f,4.3f,4.7f,5.2f,5.3f,5f,4.8f,4.3f,3.8f,2.9f,2.2f,1.7f,1.5f,1.4f,1.5f,1.5f,2f,2.6f,2.9f,3.2f,3.2f,3.2f,2.9f,2.6f,2f,1.3f,0.6f,0.1f,0.2f,0.4f,0.5f,0.4f,0.2f,0.9f,1.5f,1.8f,2.2f,2.9f,3.1f,3.2f,2.9f,2.4f,2.3f,2f,1.5f,0.9f,0.4f,0.5f,0.6f,0.7f,0.8f,1.4f,2.2f,2.9f,3f,2.9f,2.9f,2.9f,2.4f,1.4f,0.1f,1.1f,1.8f,2.4f,3.2f,4f,4.5f,4.5f,4.6f,5.1f,5.6f,6f,6.6f,7.5f,9.2f,10.7f,12.1f,13.6f,15.1f,16.9f,18.2f,19.1f,19.8f,20.6f,21.4f,21.9f,22.5f,23.3f,24.6f,26.1f,27.5f,29f,30.8f,32.8f,34.6f,36.1f,37.1f,38f,39f,39.5f,39.5f,39.2f,39.2f,39.3f,39.3f,39.3f,39.1f,39.4f,40f,40.5f,40.4f,40.1f,40f,39.8f,38.9f,37.6f,35.9f,34.6f,33.5f,32f,30.7f,29.4f,28.5f,27.9f,27.3f,26.6f,25.9f,25.2f,24.5f,23.4f,22f,20.4f,18.8f,17.2f,15.4f,13.6f,11.9f,10.3f,9.2f,8.1f,7.3f,6.5f,5.8f,5.3f,4.8f,4.2f,3.6f,3f,2.3f,1.5f,0.6f,0.5f,1.4f,2.3f,3.2f,3.9f,4.3f,4.4f,4.5f,4f,3.7f,3.5f,3.1f,2.9f,2.8f,3f,3.3f,3.9f,4.5f,5.1f,6f,6.4f,6.8f,7.1f,7.3f,7.6f,7.9f,8.1f,8.1f,8.4f,9.1f,9.9f,10.2f,10.6f,11.2f,11.6f,11.5f,10.6f,9.5f,8.1f,5.8f,2.7f,1.5f,6.2f,11.7f,17.7f,24.6f,32.6f,41.3f,50.6f,60.3f,71.2f,83.5f,96.3f,109.4f,123.3f,138.4f,154.1f,169.9f,185.3f,200.5f,215.7f,230.4f,243.8f,255.4f,265.9f,275.3f,282.8f,287.7f,290.2f,290.9f,289.2f,284.5f,277f,267.5f,256.2f,243.2f,228.3f,212.1f,194.9f,177.2f,159.5f,141.4f,123.7f,106.2f,89.9f,74.3f,59.7f,46.6f,34.7f,24f,14.9f,6.7f,0.4f,6.4f,11.3f,15.2f,18.9f,21.9f,24.3f,26.3f,27.7f,29.1f,30.1f,30.7f,30.6f,30.4f,29.6f,28.5f,27.2f,25.4f,23.8f,22.3f,21f,19.7f,18.6f,17.9f,17.6f,17.5f,17.2f,16.9f,16.5f,16.1f,15.6f,15f,14.1f,12.8f,11.7f,10.8f,10.4f,9.9f,9.5f,9.4f,9.7f,10.4f,10.6f,10.8f,10.9f,11.1f,11f,10.5f,9.7f,8.8f,8.3f,7.6f,6.8f,6.1f,5.7f,5.9f,6f,6f,5.9f,6.2f,6.4f,6.4f,5.9f,5.2f,4.7f,4f,3.3f,2.3f,1.3f,0.7f,0.4f,0.3f,0f,0.1f,0.5f,0.9f,1f,0.8f,0.6f,0.5f,0f,1.2f,2.4f,3.5f,4.2f,5f,6f,6.8f,7.1f,7.1f,7.1f,7.4f,7.6f,7.4f,7.2f,7.5f,8.2f,9f,9.6f,10.1f,11.1f,12.5f,13.4f,14.2f,14.5f,15f,15.5f,15.5f,15.3f,14.7f,14.5f,14.7f,15f,15.1f,15.4f,16.4f,17.7f,18.9f,19.6f,20.3f,21.4f,22.3f,22.7f,22.6f,22.6f,22.5f,22.7f,22.9f,23f,23.5f,24.2f,25.4f,26.5f,27.9f,29.1f,30.4f,31.4f,32.1f,32.6f,33.2f,33.6f,33.8f,34.1f,34.5f,35.1f,35.9f,36.8f,38.1f,39.4f,40.9f,42.6f,44f,45.3f,46.2f,46.9f,47.6f,48f,48.5f,48.6f,49.1f,49.7f,50.6f,51.7f,52.8f,54.3f,56.1f,57.8f,59.7f,61f,62.2f,63.5f,64.6f,65.6f,66f,66.5f,67.4f,68.3f,69.1f,70.1f,71.2f,73f,74.7f,76.3f,77.7f,79.2f,80.9f,82.3f,83.3f,83.9f,84.6f,85.5f,85.9f,86.2f,86.6f,87.4f,88.2f,88.9f,89.3f,90.1f,91.4f,92.6f,93.6f,94.3f,95f,95.8f,96.1f,96.4f,95.9f,95.5f,95.4f,95f,94.5f,94.1f,93.9f,94.2f,94.2f,94.4f,94.5f,94.6f,94.9f,94.6f,94.2f,93.2f,92.2f,91.3f,89.9f,88.4f,86.9f,85.7f,84.7f,83.5f,82.3f,81.2f,80.5f,79.6f,78.1f,76.4f,74.7f,72.8f,70.5f,67.8f,65.2f,62.6f,60.1f,57.6f,55.3f,53.2f,51.3f,49.6f,48f,46.3f,44.3f,42.3f,40.4f,38f,35.4f,32.6f,29.9f,27.1f,24.3f,21.6f,19f,16.7f,14.5f,12.7f,11f,9.4f,7.8f,6.2f,4.5f,2.6f,0.6f,1.4f,3.4f,5.5f,7.3f,9.2f,10.9f,12.3f,13.5f,14.5f,15.5f,16.3f,16.9f,17.4f,17.9f,18.7f,19.5f,20.2f,20.9f,22f,23f,23.8f,24.4f,24.9f,25.4f,25.9f,26.1f,25.7f,25.4f,25.1f,24.7f,24.3f,23.8f,23.6f,23.9f,24.2f,24.6f,25f,25.7f,26.8f,27.4f,27.8f,27.9f,28.1f,28.2f,27.9f,27.3f,26.6f,26.3f,26.3f,26.3f,26.2f,26.4f,26.9f,27.7f,28.1f,28.2f,28.1f,28f,28f,27.5f,26.4f,25.4f,24.6f,24.1f,23.4f,22.6f,22.3f,22.3f,22.7f,22.9f,23.2f,23.6f,24.1f,24.5f,24.3f,23.9f,23.5f,23.1f,22.6f,21.9f,21.3f,21f,21.1f,21.1f,21.2f,21.3f,21.8f,22.2f,22.3f,22.3f,22.1f,21.8f,21.7f,21.1f,20.2f,19.4f,19f,18.9f,18.7f,18.6f,18.9f,19.4f,20.1f,20.6f,21.1f,21.5f,21.8f,21.9f,21.8f,21.5f,21.4f,21.2f,21f,20.7f,20.3f,20.4f,20.6f,21.1f,21.5f,21.9f,22.1f,22.4f,22.9f,23.2f,23.2f,22.9f,22.5f,22.2f,21.6f,20.8f,20.1f,19.7f,19.4f,19.3f,19.1f,19.2f,19.8f,20.5f,21.1f,21.3f,21.6f,21.7f,21.9f,21.9f,21.3f,20.7f,20.5f,20.4f,20.3f,20.3f,20.3f,21f,21.8f,22.5f,23.1f,23.5f,24.3f,24.6f,24.7f,24.4f,24f,23.7f,23.5f,22.8f,22.2f,21.9f,22.2f,22.5f,22.5f,22.6f,23f,23.4f,23.5f,23f,22.6f,22.1f,21.8f,21.1f,20.2f,19.6f,19.3f,19.3f,19.3f,19.2f,19.6f,20.2f,20.9f,21.2f,21.2f,21.5f,21.9f,22f,21.7f,21.1f,20.8f,20.7f,20.8f,20.5f,20.4f,20.7f,21.2f,21.7f,21.9f,22.2f,22.6f,23f,23f,22.6f,22.2f,21.8f,21.7f,21f,20.3f,19.7f,19.5f,19.5f,19.4f,19.5f,19.8f,20f,20.3f,20.6f,20.6f,20.8f,20.7f,20.6f,20.2f,19.5f,18.9f,18.4f,17.9f,17.6f,17.2f,17.1f,17.2f,17.7f,18.3f,18.8f,19.3f,19.3f,19.8f,20f,19.8f,19.6f,19.2f,18.7f,18.3f,17.9f,17.7f,17.8f,18f,18.4f,18.7f,19.1f,19.7f,19.9f,20.1f,19.9f,19.5f,19f,18.4f,17.7f,16.9f,16.2f,16f,15.8f,15.8f,15.8f,16.3f,17.2f,17.8f,18.1f,18f,18f,18f,17.8f,17.1f,16f,15.4f,15.1f,14.9f,14.7f,14.6f,14.7f,15.5f,16.2f,16.5f,16.9f,17.3f,17.9f,18.1f,17.7f,17.2f,16.7f,16.7f,16.3f,15.6f,15f,14.7f,15.1f,15.3f,15.3f,15.4f,15.7f,16.3f,16.5f,16.2f,16.1f,15.9f,15.6f,14.9f,14.1f,13.4f,12.9f,12.5f,12f,11.5f,11.5f,11.9f,12.1f,12.3f,12.5f,12.7f,13f,12.9f,12.4f,11.8f,11.2f,10.5f,9.4f,8.4f,7.7f,7.4f,7.4f,7.3f,7.2f,7.6f,8.2f,8.8f,9.1f,9.2f,9.4f,9.6f,9.7f,9.3f,8.8f,8.4f,8.1f,7.9f,7.5f,7.4f,7.4f,7.6f,7.8f,7.9f,7.8f,7.7f,7.4f,6.8f,6.1f,5f,4.1f,3.2f,2.7f,2.4f,2f,2f,2.3f,2.9f,3.7f,4.2f,4.5f,4.9f,5.3f,5.3f,4.7f,3.8f,3f,2.2f,1f,0f,1f,1.4f,1.7f,2.2f,2.8f,3.3f,3.6f,4.1f,4.8f,5.9f,7.4f,8.6f,10f,11.6f,13.2f,14.7f,15.9f,17f,18.1f,19.2f,20f,20.5f,21.3f,22.5f,23.9f,25.1f,26f,27.2f,28.9f,30.4f,31.6f,32.5f,33.5f,34.6f,35.2f,35.3f,35.2f,35.1f,34.9f,34.3f,33.1f,32.3f,31.8f,31.7f,31.3f,30.8f,30.4f,30.4f,30.5f,30.2f,29.5f,28.7f,27.8f,26.6f,25f,22.9f,21f,19.4f,17.7f,16f,14.1f,12.8f,12.3f,11.7f,11f,9.9f,8.9f,8f,7f,5.5f,3.7f,2f,0.5f,1f,2.6f,4f,5f,5.4f,5.8f,6.1f,6.4f,6.4f,6.2f,6.4f,6.6f,7.4f,8f,8.6f,9.4f,10.1f,10.8f,11.1f,11.4f,11.4f,11.4f,10.8f,10.1f,9.3f,8.9f,8.6f,8.2f,8f,8f,8.4f,9.2f,9.9f,10.6f,11.3f,12.1f,12.8f,13.2f,13.5f,13.8f,14.2f,14.7f,14.9f,14.9f,15.1f,15.2f,15.5f,15.2f,14.7f,13.7f,12.3f,10.5f,7.6f,3.9f,0.6f,5.9f,12.3f,19.7f,28.1f,37f,47.1f,57.7f,69.1f,81.2f,94.2f,107.6f,121f,134.7f,149.3f,164.3f,179.3f,193.5f,207.8f,221.9f,235.4f,247.8f,257.9f,266.6f,273.7f,278.9f,280.6f,279.6f,276.3f,271f,263f,252.3f,239.8f,225.7f,210.9f,195f,178.3f,161.2f,144f,127f,110.2f,93.4f,77.6f,62.6f,48.8f,35.8f,23.7f,13.3f,4.5f,2.9f,9.2f,14.6f,18.6f,21.4f,23.5f,25.2f,26.6f,27.4f,27.7f,28f,28.4f,28.8f,28.4f,27.7f,27.2f,26.5f,25.9f,24.5f,23f,21.5f,20.2f,19.2f,17.9f,16.8f,16.1f,15.6f,15.5f,15.3f,15f,14.9f,14.9f,14.6f,14f,13f,12.2f,11.5f,10.6f,9.7f,8.6f,7.8f,7.5f,7.1f,7.1f,6.9f,7.1f,7.4f,7.5f,7.7f,7.5f,7.5f,7.4f,7.1f,6.5f,5.9f,5.4f,4.9f,4.6f,4.2f,4f,3.8f,3.9f,4.1f,4.3f,4.6f,4.6f,4.8f,4.6f,4.3f,3.7f,3f,2.4f,1.5f,0.8f,0.1f,0.4f,0.4f,0.3f,0.3f,0.1f,0.1f,0.4f,0.6f,0.4f,0f,0.5f,1f,1.6f,2.8f,3.5f,4.3f,4.6f,4.9f,5.2f,5.4f,5.1f,4.7f,4.4f,4.7f,5.1f,5.5f,6.1f,7f,8.4f,9.7f,10.6f,11.4f,12.4f,13.5f,14.1f,14.1f,14.1f,14.4f,14.8f,15.1f,15.2f,15.7f,16.7f,17.8f,18.8f,19.7f,20.8f,22.2f,23.3f,24.2f,24.4f,24.8f,25.3f,25.6f,25.6f,25.4f,25.6f,26.2f,26.9f,27.6f,28.3f,29.3f,30.7f,32f,33f,33.7f,34.6f,35.7f,36.3f,36.6f,36.8f,37.4f,38f,38.6f,39f,39.8f,41f,42.3f,43.6f,44.8f,46.2f,47.7f,49.1f,50.3f,51.3f,52.3f,53.2f,54f,54.6f,54.9f,55.7f,56.8f,57.8f,59.1f,60.3f,61.9f,63.6f,65.4f,67.1f,68.5f,69.9f,71.1f,72.1f,72.9f,73.5f,74.1f,74.9f,75.7f,76.6f,77.6f,79f,80.7f,82.3f,84f,85.4f,86.7f,87.9f,88.8f,89.6f,89.9f,90.2f,90.4f,90.7f,91.4f,91.8f,92.5f,93.5f,94.7f,95.8f,96.7f,97.5f,98.3f,99f,99.2f,99.1f,98.7f,98.4f,98f,97.6f,97.1f,97f,97f,97.3f,97.2f,97.3f,97.4f,97.6f,97.6f,97f,96.4f,95.6f,94.5f,93.3f,91.5f,89.8f,88.3f,86.8f,85.3f,83.7f,82f,80.7f,79.6f,78.3f,76.7f,75.1f,73.4f,71.6f,69.4f,66.7f,64.1f,61.5f,59f,56.3f,53.2f,50.4f,48.1f,45.7f,43.5f,41f,38.9f,37.2f,35.5f,33.5f,31.1f,28.8f,26.8f,24.5f,21.7f,18.7f,16.1f,14f,11.7f,9.2f,7f,5.4f,4.2f,2.8f,1.5f,0.1f,1.4f,2.4f,3.7f,5.5f,7.1f,8.6f,9.9f,11.4f,13.1f,14.4f,15f,15.5f,15.8f,16.4f,16.7f,16.7f,16.9f,17.4f,18.1f,18.7f,19.3f,20.1f,20.9f,21.9f,22.3f,22.4f,22.5f,22.6f,22.6f,22f,21.3f,20.9f,20.5f,20.5f,20.4f,20.3f,20.6f,21f,21.6f,22f,22.2f,22.6f,22.7f,22.6f,22.4f,21.7f,21.2f,20.7f,20.2f,19.6f,19.1f,18.9f,18.8f,18.9f,19.1f,19.2f,19.5f,19.8f,19.9f,19.8f,19.6f,19.3f,19f,18.7f,18.2f,17.6f,17.1f,17f,16.9f,16.9f,17f,17.2f,17.4f,17.6f,17.8f,17.7f,17.7f,17.5f,17.3f,16.7f,16.1f,15.3f,14.7f,14.3f,13.9f,13.6f,13.5f,14.1f,14.7f,15.2f,15.7f,16.2f,16.8f,17.2f,17f,16.8f,16.5f,16.2f,15.8f,15.2f,14.6f,14.5f,14.7f,14.9f,14.9f,15.3f,16f,16.8f,17.2f,17f,17f,16.9f,16.7f,16.2f,15.4f,14.7f,14.6f,14.6f,14.6f,14.6f,14.8f,15.7f,16.2f,16.3f,16.2f,16.4f,16.7f,16.4f,15.4f,14.3f,13.5f,13f,12.4f,11.6f,11.1f,11.1f,11.4f,11.7f,12f,12.4f,12.9f,13.5f,13.5f,13.3f,13.2f,12.9f,12.7f,12.2f,11.6f,11.4f,11.3f,11.4f,11.7f,11.8f,12.2f,12.6f,13.3f,13.6f,13.8f,14f,14.1f,14f,13.6f,13.1f,12.9f,12.7f,12.2f,12.2f,12.1f,12.4f,12.8f,13.3f,13.8f,14.3f,14.9f,15.5f,15.8f,15.9f,15.9f,15.6f,15.3f,14.7f,14f,13.5f,13.2f,13f,13.1f,13.2f,13.5f,13.8f,14.3f,14.7f,14.7f,14.5f,14.2f,14f,13.6f,12.8f,12f,11.6f,11.7f,11.9f,11.9f,12.2f,12.6f,13.6f,14.3f,14.8f,14.9f,15.1f,15.4f,15.3f,14.7f,13.9f,13.4f,13.2f,12.9f,12.5f,12.3f,12.7f,13.4f,14.1f,14.2f,14.6f,14.9f,15.4f,15.4f,14.8f,14.1f,13.6f,13.2f,12.7f,12.1f,11.6f,11.5f,11.9f,12.1f,12.4f,13f,13.6f,14.1f,14.2f,14.1f,14f,13.8f,13.4f,12.6f,12f,11.7f,11.6f,11.6f,11.3f,11.4f,12f,12.7f,13.2f,13.1f,13.5f,13.8f,14.1f,14f,13.3f,12.8f,12.4f,12.5f,12f,11.5f,11.3f,11.3f,11.9f,12.1f,12f,12.4f,13.1f,13.6f,13.7f,13.2f,13.2f,13.2f,12.7f,11.9f,10.8f,10f,9.6f,9.2f,9f,8.8f,9f,9.4f,9.9f,10.4f,10.7f,11f,11.3f,11.3f,11f,10.6f,10.1f,9.7f,9.2f,8.9f,8.7f,8.5f,8.7f,9f,9.3f,9.4f,9.2f,8.9f,8.3f,7.3f,6f,4.7f,3.1f,1.8f,0.3f,1f,2.1f,2.8f,3.4f,3.8f,4.1f,4.7f,4.8f,5.3f,6.1f,7.3f,8.6f,9.9f,11.4f,13.3f,15.3f,16.8f,18f,19.2f,20.6f,21.8f,22.3f,22.9f,23.7f,25f,26.1f,26.9f,27.8f,28.9f,30.4f,31.6f,32.3f,33f,33.8f,34.4f,34.6f,34.1f,33.5f,33.1f,32.7f,32.2f,31.2f,30.5f,30.2f,30.1f,30f,29.6f,29.3f,29.3f,29.3f,28.9f,28f,26.9f,26.2f,25f,23.2f,21f,18.9f,17.2f,15.5f,13.8f,12f,10.8f,10.1f,9.4f,8.9f,7.9f,7.1f,6.5f,5.6f,4.4f,2.8f,1.5f,0.3f,1.2f,2.7f,4f,4.7f,5.2f,5.7f,6.1f,6.3f,6.3f,6f,6.3f,6.6f,7f,7.3f,7.8f,8.6f,9.5f,9.9f,10f,10.1f,10.1f,10.1f,9.7f,9f,8.4f,8.3f,8.3f,8.2f,8.3f,8.8f,9.4f,10.5f,11.3f,12.1f,13f,13.7f,14.4f,14.9f,14.9f,15f,14.9f,15.2f,15.2f,15f,14.9f,14.6f,14.6f,14.4f,13.6f,11.9f,9.6f,7.2f,3.5f,1.5f,7.7f,14.4f,22f,30.9f,40.9f,51.3f,62.2f,74f,86.4f,99.3f,113f,127.1f,141.4f,156f,171.2f,186.4f,201.1f,215.5f,229.1f,242f,253.8f,264.3f,272.5f,278.5f,282.1f,283.7f,282.2f,277.5f,270.5f,261.2f,249.7f,236f,220.9f,205.2f,188.6f,171.7f,154.2f,137f,120.6f,104.4f,88.7f,73.3f,59f,46f,33.7f,22f,11.5f,2.7f,4.8f,11.3f,16.8f,21.3f,24.4f,26.6f,28.2f,29.6f,30.6f,31f,31f,31f,31.2f,31.1f,30.6f,29.6f,28.7f,27.8f,26.6f,24.9f,22.9f,21.2f,19.6f,18.1f,16.6f,15.2f,14.4f,14.1f,13.8f,13.4f,13f,12.9f,13.1f,12.9f,12.2f,11.5f,10.7f,10.1f,9.1f,8.2f,7.4f,6.9f,6.4f,6.2f,6.2f,6.4f,6.7f,6.9f,6.9f,6.7f,6.5f,6f,5.3f,4.5f,3.5f,2.5f,1.7f,1.2f,0.8f,0.5f,0.4f,0.4f,0.6f,0.8f,0.9f,1.1f,1f,0.8f,0.4f,0.5f,1.2f,1.9f,2.6f,3.3f,4.2f,4.7f,5.2f,5.4f,5.3f,5.3f,5f,4.7f,4.1f,3.9f,4f,4.3f,4.5f,5f,6.1f,7.3f,8.4f,8.9f,9.4f,10f,10.5f,10.6f,10.2f,9.8f,9.7f,9.9f,10.1f,10.3f,10.7f,11.8f,12.8f,13.7f,14.5f,15.4f,16.6f,17.3f,17.7f,17.7f,17.7f,18.2f,18.5f,18.8f,18.9f,19.2f,20.1f,21.1f,22.1f,23f,23.9f,25.1f,25.7f,26.1f,26.1f,26.4f,26.8f,26.7f,26.5f,26.4f,26.8f,27.5f,28.4f,29.1f,30f,31.3f,32.7f,33.9f,34.8f,35.5f,36.2f,36.9f,37.2f,37.1f,37.3f,37.9f,38.5f,38.9f,39.2f,40.1f,41.6f,43f,44.4f,45.4f,46.6f,48f,49.2f,50f,50.4f,50.9f,51.7f,52.1f,52.5f,52.7f,53.5f,54.7f,55.7f,56.7f,57.5f,59f,60.7f,62.3f,63.8f,64.7f,65.9f,67.2f,68f,68.6f,68.8f,69.2f,69.8f,70.3f,70.8f,71.6f,72.7f,74.1f,75.4f,76.6f,77.9f,79.1f,80.3f,81.1f,81.8f,82f,82.2f,82.2f,82.2f,82.4f,82.6f,82.9f,83.4f,84.1f,84.8f,85.7f,86.6f,87.3f,87.9f,87.9f,87.8f,87.6f,87.3f,86.9f,86.2f,85.5f,85.1f,84.6f,84.5f,84.2f,84f,84f,83.7f,83.3f,82.5f,81.5f,80.3f,78.9f,77.2f,74.9f,72.8f,70.8f,69.1f,67.3f,65.3f,63.6f,62.5f,61.6f,60.3f,58.7f,57f,55.7f,53.8f,51.3f,48.6f,46f,43.7f,41.2f,38.4f,35.8f,33.7f,32f,30f,28.1f,26.2f,24.4f,22.8f,21f,18.7f,16.5f,14.5f,12.2f,9.8f,7.1f,4.8f,2.9f,0.9f,1f,3.2f,4.5f,5.7f,6.6f,7.5f,8.4f,9.1f,9.7f,10.6f,11.8f,13.2f,14.5f,15.6f,17.3f,18.9f,20.3f,21.1f,21.7f,22.4f,22.7f,23f,23f,22.7f,22.9f,22.9f,23.3f,23.8f,24.1f,24.9f,25.6f,26.3f,26.8f,27.1f,27.4f,27.6f,27.4f,27.1f,26.5f,26f,25.7f,25.6f,25.5f,25.5f,25.6f,26.1f,26.7f,27f,27.4f,27.6f,27.7f,27.8f,27.5f,27.1f,26.8f,26.5f,26.2f,26f,25.8f,25.7f,25.9f,26.2f,26.5f,26.8f,26.8f,26.9f,27f,26.8f,26.6f,26.2f,25.9f,25.5f,25.1f,24.7f,24.6f,24.8f,25.1f,25.2f,25.4f,25.5f,26.1f,26.5f,26.6f,26.5f,26.2f,26.1f,25.6f,24.9f,24.4f,24.1f,24.1f,23.9f,23.7f,23.9f,24.5f,25.2f,25.9f,26.1f,26.5f,27.1f,27.5f,27.8f,27.7f,27.2f,27.2f,26.8f,26.1f,25.3f,25f,25.1f,25.1f,24.9f,24.8f,25.2f,26f,26.6f,26.5f,26.5f,26.5f,26.6f,26.3f,25.4f,24.8f,24.4f,24.1f,23.6f,23f,23f,23.5f,24.2f,24.7f,24.9f,25.4f,25.5f,25.8f,25.7f,25.2f,24.8f,24.2f,23.9f,23.5f,23.2f,23.2f,23.5f,23.8f,24.2f,24.5f,24.9f,25.4f,25.6f,25.6f,25.3f,25f,24.7f,24.2f,23.8f,23.5f,23.4f,23.5f,23.6f,23.8f,24.1f,24.7f,25.2f,25.6f,25.7f,25.8f,25.7f,25.6f,25.4f,24.9f,24.4f,23.8f,23.4f,23.1f,22.8f,22.8f,22.6f,23f,23.3f,23.3f,23.4f,23.3f,23.5f,23.4f,22.9f,22.3f,21.7f,21.5f,21.1f,20.5f,20.1f,19.8f,20.1f,20.5f,20.7f,21f,21.3f,22.2f,22.6f,22.6f,22.4f,22.4f,22.4f,22.1f,21.2f,20.4f,20.1f,19.8f,19.8f,19.5f,19.6f,20f,20.7f,21.2f,21.3f,21.4f,21.7f,21.8f,21.6f,20.8f,20.3f,19.9f,19.6f,19.1f,18.8f,18.6f,19.1f,19.6f,19.8f,20.3f,20.7f,21.2f,21.1f,20.7f,20.1f,19.6f,19.1f,18.3f,17.4f,16.7f,16.6f,16.6f,16.6f,16.6f,17f,17.6f,18.4f,18.6f,18.7f,18.9f,19f,18.8f,18.3f,17.5f,16.9f,16.6f,16.7f,16.5f,16.4f,16.6f,17.4f,18f,18.5f,18.7f,19f,19.3f,19.1f,18.5f,17.6f,16.7f,15.8f,14.8f,13.7f,12.7f,12f,11.7f,11.3f,10.8f,10.5f,10.1f,10f,9.5f,8.7f,7.9f,6.8f,5.7f,4.4f,3f,1.8f,0.6f,0.5f,1.1f,1.7f,2.2f,2.4f,2.6f,3.1f,3.4f,3.9f,4.7f,5.3f,6.3f,7.8f,9.2f,10.8f,12.4f,13.7f,15.2f,16.4f,17.6f,18.3f,18.9f,19.3f,19.6f,20.1f,20.5f,21.1f,22f,22.9f,23.8f,24.9f,26f,27.1f,27.8f,28.2f,28.1f,27.8f,27.2f,26.4f,25.3f,24f,23f,22.2f,21.4f,20.7f,20.3f,20f,19.9f,19.6f,18.7f,17.5f,16.4f,15.1f,13.4f,11.3f,9.1f,7.2f,5.4f,4f,2.2f,0.8f,0.2f,1.1f,2f,3f,4.1f,4.9f,5.7f,6.7f,8f,9.3f,10.5f,11.5f,12.3f,13.6f,14.3f,14.6f,14.7f,14.6f,14.9f,14.9f,14.6f,14.4f,14.5f,15f,15.3f,15.3f,15.8f,16.5f,17f,17.1f,17f,16.9f,17f,16.6f,16.2f,15.5f,15f,14.6f,14.2f,13.7f,13.6f,13.7f,14.5f,15.2f,15.9f,17f,18.2f,19.7f,20.6f,21.2f,21.8f,22.2f,22.4f,22f,21f,19.9f,18.8f,17.7f,16.2f,13.6f,10.9f,8f,4.6f,0.3f,6.6f,13.3f,21f,30f,40.5f,52f,64f,76.9f,90.3f,104.1f,118.3f,132.7f,147.1f,161.4f,175.5f,189.6f,203.2f,216.4f,229f,240.6f,251.2f,260.6f,268.5f,274.1f,276.7f,277.5f,275.8f,270.7f,262.8f,252.6f,240.6f,226.8f,211.5f,195.4f,178.7f,161.8f,144.9f,127.9f,111.6f,95.9f,80.8f,66.2f,52.3f,39.3f,27.3f,16.2f,6.1f,2.9f,10.7f,17.5f,23.3f,28f,31.8f,34.9f,37f,38.6f,39.5f,40.4f,40.9f,40.9f,40.7f,40.3f,40.5f,40.2f,39.6f,38.8f,37.8f,37f,35.7f,33.8f,31.9f,30.2f,28.4f,26.5f,24.4f,22.6f,21.4f,20.3f,19.3f,18.2f,17.4f,17.3f,17.5f,17.3f,16.9f,16.5f,16.2f,15.8f,15.2f,13.9f,13.1f,12.6f,12.2f,11.8f,11.5f,11.6f,12.2f,12.8f,12.9f,13.1f,13.2f,13.6f,13.3f,12.5f,11.5f,10.5f,9.7f,8.7f,7.6f,6.7f,6.4f,6.3f,6f,6f,6.2f,6.3f,6.3f,6.1f,5.6f,5f,4.2f,3.2f,1.9f,0.8f,0.1f,0.6f,0.8f,1f,1.2f,0.8f,0.4f,0.1f,0.1f,0.5f,0.9f,1.3f,2.1f,3.2f,4.4f,5.5f,6.3f,7.2f,7.9f,8.4f,8.4f,8.2f,8.1f,8f,8f,7.9f,7.9f,8.2f,8.9f,9.6f,10.4f,11.1f,11.9f,12.8f,13.7f,14.4f,14.9f,15.1f,15.4f,15.7f,16.1f,16.3f,16.6f,17.1f,17.9f,18.7f,19.5f,20.4f,21.6f,22.8f,23.8f,24.4f,25.2f,25.9f,26.6f,27f,27f,26.7f,26.6f,26.8f,27.2f,27.2f,27.7f,28.7f,29.7f,30.7f,31.7f,32.6f,33.7f,34.6f,35.1f,35.4f,35.7f,36.2f,36.6f,37f,37.4f,38.1f,39.4f,40.8f,42f,43.5f,45.2f,47f,48.5f,49.5f,50.5f,51.6f,52.5f,52.9f,53.1f,53.7f,54.8f,55.7f,56.7f,57.8f,59.3f,61.2f,62.9f,64.4f,65.6f,67f,68.6f,69.6f,70.2f,70.4f,70.9f,71.6f,72.2f,72.7f,73.1f,73.9f,75.2f,76.3f,77.4f,78.2f,79.1f,80f,80.6f,80.8f,80.9f,81f,81.1f,81.2f,80.9f,80.9f,81.2f,81.6f,82f,82.4f,83.1f,83.7f,84.4f,84.8f,85.1f,85.3f,85.2f,85f,84.5f,84f,83.4f,82.8f,82.1f,81.4f,81f,80.4f,80.1f,79.5f,79.1f,78.5f,77.8f,76.9f,75.7f,74.5f,73f,71.1f,69f,66.7f,64.4f,62.1f,59.9f,57.9f,55.9f,54.2f,52.4f,50.9f,49.4f,47.6f,45.9f,43.5f,41.3f,38.9f,36.4f,34f,31.2f,28.8f,26.7f,24.9f,23.2f,21.6f,20.3f,19.3f,18.4f,17f,15.4f,13.7f,11.9f,10f,7.7f,5f,2.5f,0.6f,1.4f,3.4f,5.2f,6.5f,7.3f,8f,9f,9.9f,10.5f,11.2f,12f,13.4f,14.7f,15.8f,16.9f,17.9f,18.9f,19.9f,20.2f,20.4f,20.4f,20.5f,20.4f,20.1f,19.9f,19.9f,20.3f,20.6f,20.8f,21.2f,21.9f,22.8f,23.3f,23.6f,23.9f,24f,24.2f,23.9f,23.4f,23f,22.7f,22.6f,22.3f,21.9f,21.9f,22.3f,22.6f
  //  };
    float[] ecgdataset = new float[] {0,103,101,101,100,97,94,89,84,80,76,72,70,75,72,71,72,73,73,73,72,70,74,73,73,73,73,71,74,75,73,71,69,67,65,70,76,77,77,76,73,71,75,77,77,76,76,76,70,58,74,104,109,85,40,8,137,144,93,78,79,80,79,80,82,80,81,82,82,84,85,84,89,88,91,94,97,97,97,97,100,98,96,95,93,88,84,81,79,76,76,75,77,75,74,75,75,74,73,74,76,76,74,76,77,77,76,74,75,71,67,65,68,76,76,79,77,75,72,76,78,78,76,76,76,76,60,54,81,0};
    float converted = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //////////////////////////////

        //////////////////////////////
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_fuck);


        mChart = (LineChart) findViewById(R.id.chart1);
        mChart.setOnChartValueSelectedListener(this);

        // enable description text
        mChart.getDescription().setEnabled(true);

        // enable touch gestures
        mChart.setTouchEnabled(true);

        // enable scaling and dragging
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(true);
        mChart.setDrawGridBackground(false);

        // if disabled, scaling can be done on x- and y-axis separately
        mChart.setPinchZoom(true);

        // set an alternative background color
        mChart.setBackgroundColor(Color.LTGRAY);

        LineData data = new LineData();
        data.setValueTextColor(Color.WHITE);

        // add empty data
        mChart.setData(data);

        // get the legend (only possible after setting data)
        Legend l = mChart.getLegend();

        // modify the legend ...
        l.setForm(LegendForm.LINE);
        //l.setTypeface(mTfLight);
        l.setTextColor(Color.WHITE);

        XAxis xl = mChart.getXAxis();
        //xl.setTypeface(mTfLight);
        xl.setTextColor(Color.WHITE);
        xl.setDrawGridLines(false);
        xl.setAvoidFirstLastClipping(true);
        xl.setEnabled(true);

        YAxis leftAxis = mChart.getAxisLeft();
        //leftAxis.setTypeface(mTfLight);
        leftAxis.setTextColor(Color.WHITE);
        leftAxis.setAxisMaximum(400f);
        leftAxis.setAxisMinimum(-100f);
        leftAxis.setDrawGridLines(true);

        YAxis rightAxis = mChart.getAxisRight();
        rightAxis.setEnabled(false);
        ////////////
         feedMultiple();

    }

    // @Override
    // public boolean onCreateOptionsMenu(Menu menu) {
    //     getMenuInflater().inflate(R.menu.realtime, menu);
    //     return true;
    // }

    // @Override
    // public boolean onOptionsItemSelected(MenuItem item) {

    //   switch (item.getItemId()) {
    //      case R.id.actionAdd: {
    //         addEntry();
    //        break;
    //     }
    //      case R.id.actionClear: {
    //         mChart.clearValues();
    //         Toast.makeText(this, "Chart cleared!", Toast.LENGTH_SHORT).show();
    //         break;
    //      }
    //       case R.id.actionFeedMultiple: {
    //           feedMultiple();
    //           break;
    //         }
    //     }
    //     return true;
    //  }

    private void addEntry() {

        LineData data = mChart.getData();

        if (data != null) {

            ILineDataSet set = data.getDataSetByIndex(0);
            // set.addEntry(...); // can be called as well

            if (set == null) {
                set = createSet();
                data.addDataSet(set);
            }

            //data.addEntry(new Entry(set.getEntryCount(), (float) (Math.random() * 40) + 30f), 0);
            data.addEntry(new Entry(set.getEntryCount(), converted), 0);
            data.notifyDataChanged();
            //heartRate++;
            // let the chart know it's data has changed
            mChart.notifyDataSetChanged();

            // limit the number of visible entries
            mChart.setVisibleXRangeMaximum(120);
            // mChart.setVisibleYRange(30, AxisDependency.LEFT);

            // move to the latest entry
            mChart.moveViewToX(data.getEntryCount());

            // this automatically refreshes the chart (calls invalidate())
            // mChart.moveViewTo(data.getXValCount()-7, 55f,
            // AxisDependency.LEFT);
        }
    }

    private LineDataSet createSet() {

        LineDataSet set = new LineDataSet(null, "Dynamic Data");
        set.setAxisDependency(AxisDependency.LEFT);
        set.setColor(ColorTemplate.getHoloBlue());
        set.setCircleColor(Color.WHITE);
        set.setLineWidth(2f);
        set.setCircleRadius(4f);
        set.setFillAlpha(65);
        set.setFillColor(ColorTemplate.getHoloBlue());
        set.setHighLightColor(Color.rgb(244, 117, 117));
        set.setValueTextColor(Color.WHITE);
        set.setValueTextSize(9f);
        set.setDrawValues(false);
        return set;
    }

    private Thread thread;

    private void feedMultiple() {

        if (thread != null)
            thread.interrupt();

        final Runnable runnable = new Runnable() {

            @Override
            public void run() {
                addEntry();
            }
        };

        thread = new Thread(new Runnable() {

            @Override
            public void run() {
               //  int i = 0;
                // while (i == 0){
                for (int i = 0; i < 130; i++) {
                    converted = ecgdataset[i];
                    // Don't generate garbage runnables inside the loop.
                    runOnUiThread(runnable);

                    try {
                        Thread.sleep(25);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    if (i == 129){i = 0;}
                }
            }
        });

        thread.start();
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {
        Log.i("Entry selected", e.toString());
    }

    @Override
    public void onNothingSelected() {
        Log.i("Nothing selected", "Nothing selected.");
    }

    //@Override
    //protected void onPause() {
    //    super.onPause();

    //   if (thread != null) {
    //      thread.interrupt();
    //  }
    // }

}
