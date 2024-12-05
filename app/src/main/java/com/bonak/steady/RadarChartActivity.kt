package com.bonak.steady

import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

public class RadarChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radar_chart);

        // Initialize the RadarChart
        RadarChart radarChart = findViewById(R.id.radarChart);

        // Data for the first website
        ArrayList<RadarEntry> visitorsForFirstWebsite = new ArrayList<>();
        visitorsForFirstWebsite.add(new RadarEntry(420));
        visitorsForFirstWebsite.add(new RadarEntry(475));
        visitorsForFirstWebsite.add(new RadarEntry(508));
        visitorsForFirstWebsite.add(new RadarEntry(660));
        visitorsForFirstWebsite.add(new RadarEntry(550));
        visitorsForFirstWebsite.add(new RadarEntry(630));
        visitorsForFirstWebsite.add(new RadarEntry(470));

        // Create dataset for the first website
        RadarDataSet radarDataSetForFirstWebsite = new RadarDataSet(visitorsForFirstWebsite, "Website 1");
        radarDataSetForFirstWebsite.setColor(Color.RED);
        radarDataSetForFirstWebsite.setLineWidth(2f);
        radarDataSetForFirstWebsite.setValueTextColor(Color.RED);
        radarDataSetForFirstWebsite.setValueTextSize(14f);

        // Add the dataset to RadarData
        RadarData radarData = new RadarData(radarDataSetForFirstWebsite);

        // Labels for X-Axis
        String[] labels = {"2014", "2015", "2016", "2017", "2018", "2019", "2020"};
        XAxis xAxis = radarChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));

        // Set data to the RadarChart and customize
        radarChart.setData(radarData);
        radarChart.getDescription().setEnabled(false);
        radarChart.setWebColor(Color.GRAY);  // Customize the web lines
        radarChart.setWebLineWidth(1.5f);
        radarChart.setWebColorInner(Color.LTGRAY);
        radarChart.setWebLineWidthInner(1f);
        radarChart.animateXY(2000, 2000); // Smooth animation
    }
}
