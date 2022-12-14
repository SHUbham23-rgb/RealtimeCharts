package com.codeframe.realtimechart;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.codeframe.looper.TaskScheduler;
import com.codeframe.realtimecharts.Bargraph;
import com.github.mikephil.charting.charts.BarChart;

public class MainActivity extends AppCompatActivity {
    int i = 0, j = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BarChart viewById = findViewById(R.id.lc);
        Bargraph bargraph = new Bargraph();


        TaskScheduler scheduler = new TaskScheduler();
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                i = i + 1;
                j = i + j + 2;
                //Ex.setCharts(viewById).setBottomXAxis().setYAxis().
                // plotter.plot(i, lineChartComponents.getIndicatorLine("dfghjk",3f, LineDataSet.Mode.CUBIC_BEZIER, Color.MAGENTA));
                // lineChartComponents.getChart().getAxisLeft().setAxisMaximum(lineChartComponents.getChart().getAxisLeft().getAxisMaximum()+10);
                // lineChartComponents.getChart().animateXY(0,2000);
                bargraph.showBarChart(viewById);
            }
        }, 100);
    }
}