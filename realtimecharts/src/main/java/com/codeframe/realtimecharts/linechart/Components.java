package com.codeframe.realtimecharts.linechart;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.LineDataSet;

public class Components {
    private XAxis xAxis;
    private YAxis yAxis;
    private YAxis leftY;
    private LineChart chart;
    private LineDataSet indicatorLine;

    public LineDataSet getIndicatorLine(String label, float width, LineDataSet.Mode mode, int color) {
        LineDataSet lineDataSet = new LineDataSet(null, label);
        lineDataSet.setLineWidth(width);
        lineDataSet.setMode(mode);
        lineDataSet.setColor(color);
        lineDataSet.setDrawIcons(true);


        return lineDataSet;
    }

    public LineDataSet getIndicatorLine(String x_axis_label) {
        return  new LineDataSet(null, x_axis_label);
    }






    public LineChart getChart() {
        return chart;
    }

    public Components(XAxis xAxis, YAxis yAxis, YAxis leftY, LineChart chart) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.leftY = leftY;
        this.chart = chart;
    }

    public XAxis getxAxis() {
        return xAxis;
    }

    public YAxis getyAxis() {
        return yAxis;
    }

    public YAxis getLeftY() {
        return leftY;
    }


}
