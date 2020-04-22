package com.jinasoft.graph;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;


import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;


import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GraphView graphView;
    PieChart pieChart;
    com.github.mikephil.charting.charts.LineChart LineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        graphView = findViewById(R.id.graph);
        pieChart = findViewById(R.id.graph2);
        LineChart = findViewById(R.id.graph3);

       linegraph();
       piegraph();
        line2graph();
    }


    public void linegraph() {
        int black = getResources().getColor(R.color.black);

        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, 0),
                new DataPoint(1, 5),
                new DataPoint(2, 5),
                new DataPoint(3, 5),
                new DataPoint(4, 5),
                new DataPoint(5, 1),
                new DataPoint(6, 2),
                new DataPoint(7, 2)
        });
//        series.setDrawBackground(true);
//        series.setBackgroundColor(black);
        series.setAnimated(true);
        series.setDrawDataPoints(true);
//        series.setTitle("People");


//        graphView.getViewport().setScalable(true);
//        graphView.getViewport().setScalableY(true);
        graphView.addSeries(series);

        graphView.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if (isValueX) {
                    // x 축 라벨
                    return super.formatLabel(value, isValueX);
                } else {
                    // y 축 라벨
                    return super.formatLabel(value, isValueX);
                }
            }
        });


        BarGraphSeries<DataPoint> series2 = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 0),
                new DataPoint(1, 5),
//                new DataPoint(3, 3),
                new DataPoint(5, 10),
//                new DataPoint(7, 10)
        });
        series2.setDataWidth(1d);
        series2.setSpacing(50);
        series2.setAnimated(true);
        series2.setDrawValuesOnTop(true);
//        series2.setTitle("Children");
        series2.setColor(Color.argb(255, 60, 200, 128));
//        series2.setValuesOnTopColor(black);

        graphView.addSeries(series2);

        graphView.getLegendRenderer().setVisible(false);
        graphView.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);


    }
    public void piegraph(){
        pieChart.setUsePercentValues(false);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5,10,5,5);

        pieChart.setDragDecelerationFrictionCoef(0.95f);

        pieChart.setDrawHoleEnabled(false);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(61f);

        ArrayList<PieEntry> yValues = new ArrayList<PieEntry>();

        yValues.add(new PieEntry(1,"1"));
        yValues.add(new PieEntry(1,"2"));
        yValues.add(new PieEntry(1,"3"));
        yValues.add(new PieEntry(1,"4"));
        yValues.add(new PieEntry(1,"5"));

//        Description description = new Description();
//        description.setText("세계 국가"); //라벨
//        description.setTextSize(15);
//        pieChart.setDescription(description);

//        pieChart.animateY(1000, Easing.EasingOption.EaseInOutCubic); //애니메이션
        ArrayList<Integer> Colors = new ArrayList<>();
        Colors.add(getResources().getColor(R.color.orange));
        Colors.add(getResources().getColor(R.color.orange));
        Colors.add(getResources().getColor(R.color.blue));
        Colors.add(getResources().getColor(R.color.orange));
        Colors.add(getResources().getColor(R.color.black));


//        R.color.black,R.color.orange,R.color.blue,R.color.orange,R.color.black
        PieDataSet dataSet = new PieDataSet(yValues,"");
        dataSet.setSliceSpace(3);
        dataSet.setSelectionShift(5);
        dataSet.setColors(Colors);
//        lineDataSet.setDrawCubic(boolean enabled)

        PieData data = new PieData((dataSet));
        data.setValueTextSize(0);
        data.setValueTextColor(Color.YELLOW);
        pieChart.setData(data);
    }


    public void line2graph(){


        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0, 15));
        entries.add(new Entry(1, 14));
        entries.add(new Entry(2, 13));
        entries.add(new Entry(3, 12));
        entries.add(new Entry(4, 11));
        entries.add(new Entry(5, 10));
        entries.add(new Entry(6, 11));
        entries.add(new Entry(7, 12));
        entries.add(new Entry(8, 13));
        entries.add(new Entry(9, 14));
        entries.add(new Entry(10, 15));
        entries.add(new Entry(11, 13));

        ArrayList<Entry> entries2 = new ArrayList<>();
        entries2.add(new Entry(0, 11));
        entries2.add(new Entry(1, 10));
        entries2.add(new Entry(2, 9));
        entries2.add(new Entry(3, 8));
        entries2.add(new Entry(4, 7));
        entries2.add(new Entry(5, 6));
        entries2.add(new Entry(6, 7));
        entries2.add(new Entry(7, 8));
        entries2.add(new Entry(8, 9));
        entries2.add(new Entry(9, 10));
        entries2.add(new Entry(10, 11));
        entries2.add(new Entry(11, 12));


        ArrayList<Entry> entries3 = new ArrayList<>();
        entries3.add(new Entry(0, 10));
//        entries3.add(new Entry(1, 6));
//        entries3.add(new Entry(2, 7));
//        entries3.add(new Entry(3, 8));
//        entries3.add(new Entry(4, 9));
//        entries3.add(new Entry(5, 10));
//        entries3.add(new Entry(6, 9));
//        entries3.add(new Entry(7, 8));
//        entries3.add(new Entry(8, 7));
//        entries3.add(new Entry(9, 9));
//        entries3.add(new Entry(10, 11));
        entries3.add(new Entry(11, 10));

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("하나");
        labels.add("둘");
        labels.add("셋");
        labels.add("넷");
        labels.add("다섯");
        labels.add("여섯");
        labels.add("일곱");
        labels.add("여덟");
        labels.add("아홉");
        labels.add("열");
        labels.add("열하나");
        labels.add("열둘");


        LineDataSet dataset = new LineDataSet(entries,"1번");
        dataset.setAxisDependency(YAxis.AxisDependency.LEFT);
        LineDataSet dataset2 = new LineDataSet(entries2,"2번");
        dataset2.setAxisDependency(YAxis.AxisDependency.LEFT);
        LineDataSet dataset3 = new LineDataSet(entries3,"3번");
        dataset2.setAxisDependency(YAxis.AxisDependency.LEFT);

        YAxis leftAxis = LineChart.getAxisLeft();

        LimitLine ll=new LimitLine(150,"");
        ll.setEnabled(false);

        leftAxis.addLimitLine(ll);


/**축**/
        XAxis xAxis = LineChart.getXAxis(); // x 축 설정
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM); //x 축 표시에 대한 위치 설정
//        xAxis.setValueFormatter(new MyXAxisValueFormatter(labels)); //X축의 데이터를 제 가공함. new ChartXValueFormatter은 Custom한 소스
        xAxis.setLabelCount(5, true); //X축의 데이터를 최대 몇개 까지 나타낼지에 대한 설정 5개 force가 true 이면 반드시 보여줌
        xAxis.setDrawLabels(true);
        xAxis.setTextColor(R.color.black); // X축 텍스트컬러설정
//        xAxis.setGridColor(R.color.orange); // X축 줄의 컬러 설정
//        xAxis.setDrawGridLines(false);
        xAxis.setEnabled(false);
        xAxis.setLabelCount(labels.size());
/**y축**/
        YAxis yAxisLeft = LineChart.getAxisLeft(); //Y축의 왼쪽면 설정
        yAxisLeft.setValueFormatter(new MyYAxisValueFormatter()); //X축의 데이터를 제 가공함. new ChartXValueFormatter은 Custom한 소스
        yAxisLeft.setTextColor(R.color.black); // X축 텍스트컬러설정
        yAxisLeft.setGridColor(R.color.black); // X축 줄의 컬러 설정
        yAxisLeft.setEnabled(false);

        YAxis yAxisRight = LineChart.getAxisRight(); //Y축의 오른쪽면 설정
//        yAxisLeft.setLabelCount(14);


        yAxisRight.setDrawLabels(false);
        yAxisRight.setDrawAxisLine(false);
        yAxisRight.setDrawGridLines(false);
        //y축의 활성화를 제거함


//        LineData data = new LineData(labels, dataset);
//        LineData data = new LineData(dataset);
        LineData data = new LineData();
        data.addDataSet(dataset);
        data.addDataSet(dataset2);
        data.addDataSet(dataset3);

//        dataset.setLabel(String.valueOf(labels));

        dataset.setColors(getResources().getColor(R.color.blue));
        dataset.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        dataset.setCircleColor(getResources().getColor(R.color.black));

//        dataset3.setColors(ColorTemplate.MATERIAL_COLORS);
        dataset3.setColor(getResources().getColor(R.color.orange));
        dataset3.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        dataset3.setCircleColor(getResources().getColor(R.color.orange));


//        dataset.setCircleRadius(6);// 포인트 두께
//        dataset.setDrawCubic(true); //선 둥글게 만들기
//        dataset.setDrawFilled(true); //그래프 밑부분 색칠*/

        LineChart.setData(data);

//        LineChart.animateY(5000);

    }
    public class MyXAxisValueFormatter implements IAxisValueFormatter {

        private ArrayList<String> mValues;

        public MyXAxisValueFormatter(ArrayList<String> values) {
            this.mValues = values;
        }

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            // "value" represents the position of the label on the axis (x or y)
            return mValues.get((int) value);
        }

        /** this is only needed if numbers are returned, else return 0 */

        public int getDecimalDigits() {
            return 0;
        }
    }

    public class MyYAxisValueFormatter implements IAxisValueFormatter {

        private DecimalFormat mFormat;

        public MyYAxisValueFormatter() {

            // format values to 1 decimal digit
            mFormat = new DecimalFormat("###,###");
        }

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            // "value" represents the position of the label on the axis (x or y)
            return mFormat.format(value);
        }

        /** this is only needed if numbers are returned, else return 0 */

        public int getDecimalDigits() { return 1; }
    }


}

