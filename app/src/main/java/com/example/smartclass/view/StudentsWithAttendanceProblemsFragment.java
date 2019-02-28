package com.example.smartclass.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.smartclass.R;
import com.example.smartclass.adapter.StudentsWithAttendanceProblemsRecyclerViewAdapter;
import com.example.smartclass.bean.StudentInformationBean;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by YangFan
 * On 2019/2/16
 * GitHub: https://github.com/TIYangFan
 * Email: yangfan_98@163.com
 */
public class StudentsWithAttendanceProblemsFragment extends Fragment {

    @BindView(R.id.studentsWithAttendanceProblemsRecyclerView)
    RecyclerView studentsWithAttendanceProblemsRecyclerView;

    private ArrayList<StudentInformationBean> listData;

//    private String[][] data = {
//            {"计科1706", "杨帆", "1033170614"},
//            {"计科1706", "杨帆", "1033170614"},
//            {"计科1706", "杨帆", "1033170614"},
//            {"计科1706", "杨帆", "1033170614"},
//            {"计科1706", "杨帆", "1033170614"},
//            {"计科1706", "杨帆", "1033170614"},
//            {"计科1706", "杨帆", "1033170614"},
//            {"计科1706", "杨帆", "1033170614"},
//            {"计科1706", "杨帆", "1033170614"},
//            {"计科1706", "杨帆", "1033170614"},
//    };

    public static StudentsWithAttendanceProblemsFragment newInstance() {

        Bundle args = new Bundle();
        StudentsWithAttendanceProblemsFragment fragment = new StudentsWithAttendanceProblemsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_unfocused_detail, container, false);
        ButterKnife.bind(this, root);
        initRecyclerView(Objects.requireNonNull(container));
        return root;
    }

    private void initRecyclerView(ViewGroup container){

        studentsWithAttendanceProblemsRecyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        studentsWithAttendanceProblemsRecyclerView.setAdapter(new StudentsWithAttendanceProblemsRecyclerViewAdapter(listData));
    }

    public void setListData(ArrayList<StudentInformationBean> listData){

        this.listData = listData;
    }

}