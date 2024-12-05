package com.bonak.steady

import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class PieChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

        // Initialize the PieChart
        PieChart pieChart = findViewById(R.id.pieChart);

        // Create data for the PieChart
        ArrayList<PieEntry> visitors = new ArrayList<>();
        visitors.add(new PieEntry(508, "2016"));
        visitors.add(new PieEntry(600, "2017"));
        visitors.add(new PieEntry(750, "2018"));
        visitors.add(new PieEntry(600, "2019"));
        visitors.add(new PieEntry(670, "2020"));

        // Create a dataset and customize it
        PieDataSet pieDataSet = new PieDataSet(visitors, "Visitors");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(16f);

        // Create PieData and set it to the PieChart
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);

        // Customize the PieChart
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("Visitors");
        pieChart.animateY(2000); // Animate the chart vertically for 2 seconds
    }
}
