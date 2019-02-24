package com.example.smartclass.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.smartclass.R;
import com.example.smartclass.manager.LineChartManager;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by YangFan
 * On 2019/2/16
 * GitHub: https://github.com/TIYangFan
 * Email: yangfan_98@163.com
 */
public class OverallAttendanceStatisticsFragment extends Fragment implements OnChartValueSelectedListener {

    @BindView(R.id.lineChart)
    LineChart lineChart;

    private LineChartManager lineChartManager;
    private LineData lineData;

    public static OverallAttendanceStatisticsFragment newInstance() {

        Bundle args = new Bundle();

        OverallAttendanceStatisticsFragment fragment = new OverallAttendanceStatisticsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_overall_attendance_statistics, container, false);
        ButterKnife.bind(this, root);

        setLineChartData();
        lineChartManager = new LineChartManager(lineChart, lineData, false);
        lineChartManager.initChartView();

        return root;
    }

    private void setLineChartData(){

        List<Entry> valsComp1 = new ArrayList<>();
        List<Entry> valsComp2 = new ArrayList<>();

        valsComp1.add(new Entry(0,10));
        valsComp1.add(new Entry(1, (float) 9.5));
        valsComp1.add(new Entry(2,8));
        valsComp1.add(new Entry(3,7));
        valsComp1.add(new Entry((float) 3.5,6));
        valsComp1.add(new Entry(4, (float) 5.7));
        valsComp1.add(new Entry(5, (float) 5.5));
        valsComp1.add(new Entry(6, (float) 5.1));


        valsComp2.add(new Entry(0,2));
        valsComp2.add(new Entry(1,0));
        valsComp2.add(new Entry(2,4));
        valsComp2.add(new Entry(3,2));

        LineDataSet setComp1 = new LineDataSet(valsComp1, "Company1");

        LineDataSet setComp2 = new LineDataSet(valsComp2, "Company2");

        List<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(setComp1);
        dataSets.add(setComp2);

        lineData = new LineData(dataSets);
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }
}
