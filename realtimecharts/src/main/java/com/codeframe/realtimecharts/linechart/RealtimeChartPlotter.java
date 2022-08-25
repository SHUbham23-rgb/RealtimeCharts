package com.codeframe.realtimecharts.linechart;

import android.graphics.Color;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

public class RealtimeChartPlotter {
    protected LineChart lineChart;

    public RealtimeChartPlotter(LineChart lineChart) {
        this.lineChart = lineChart;
    }

    public Components getLineChartComponents() {
        // enable description text
        lineChart.getDescription().setEnabled(true);
        Description description = new Description();
        description.setTextColor(Color.WHITE);
        description.setText("Graph");

        lineChart.setDescription(description);
        // enable touch gestures
        lineChart.setTouchEnabled(true);
        // enable scaling and dragging
        lineChart.setDragEnabled(true);
        lineChart.setScaleEnabled(true);
        lineChart.setDrawGridBackground(false);
        // if disabled, scaling can be done on x- and y-axis separately
        lineChart.setPinchZoom(true);
        // set an alternative background color
        lineChart.setBackgroundColor(Color.BLACK);
        LineData data = new LineData();
        //
        // data.addEntry(new Entry(0,2),0);
        data.setValueTextColor(Color.rgb(255, 0, 0));
        // add empty data
        lineChart.setData(data);
        // get the legend (only possible after setting data)
        Legend l = lineChart.getLegend();
        // modify the legend ...
        l.setForm(Legend.LegendForm.LINE);
        l.setTextColor(Color.WHITE);

        XAxis xl = lineChart.getXAxis();
        xl.setTextColor(Color.WHITE);
        xl.setDrawGridLines(true);
        xl.setPosition(XAxis.XAxisPosition.BOTTOM);

        xl.setAvoidFirstLastClipping(true);
        xl.setEnabled(true);

        YAxis leftAxis = lineChart.getAxisLeft();
        leftAxis.setTextColor(Color.WHITE);
        leftAxis.setDrawGridLines(false);
        leftAxis.setAxisMaximum(105);
        leftAxis.setAxisMinimum(0);
        leftAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return String.valueOf(value).replace(".0", "") + "%";
            }
        });
        leftAxis.setDrawGridLines(true);

        YAxis rightAxis = lineChart.getAxisRight();
        rightAxis.setEnabled(false);

        lineChart.getAxisLeft().setDrawGridLines(false);
        lineChart.getXAxis().setDrawGridLines(false);
        lineChart.setDrawBorders(false);


       ;
        return new Components(xl,leftAxis,rightAxis,lineChart);
    }


    /**
     * {@link   public void plot(int x_Val_WRT_Y, LineDataSet lineDataSet)}
     * Plots the graph in a continous loop
     *
     * @param x_Val_WRT_Y
     * @param lineDataSet
     */

    public void plot(int x_Val_WRT_Y, LineDataSet lineDataSet) {

        LineData data = lineChart.getData();

        if (data != null) {

            ILineDataSet set = data.getDataSetByIndex(0);
            // set.addEntry(...); // can be called as well

            if (set == null) {
                set = lineDataSet;
                data.addDataSet(set);
            }

//            data.addEntry(new Entry(set.getEntryCount(), (float) (Math.random() * 80) + 10f), 0);
            data.addEntry(new Entry(set.getEntryCount(), Float.parseFloat(String.valueOf(x_Val_WRT_Y))), 0);
            data.notifyDataChanged();

            // let the chart know it's data has changed
            lineChart.notifyDataSetChanged();

            // limit the number of visible entries
            lineChart.setVisibleXRangeMaximum(3f);
            // mChart.setVisibleYRange(30, AxisDependency.LEFT);

            // move to the latest entry
            lineChart.moveViewToX(data.getEntryCount());
            lineChart.animateX(0);

        }
    }

    private LineDataSet createSet(String x_axis_label) {
        LineDataSet set = new LineDataSet(null, x_axis_label);
        set.setAxisDependency(YAxis.AxisDependency.LEFT);
        set.setLineWidth((float) 3.0);
        set.setColor(Color.MAGENTA);
        set.setHighlightEnabled(false);
        set.setDrawValues(false);
        set.setDrawCircles(false);
        set.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        set.setCubicIntensity(0.2f);
        return set;
    }


}
