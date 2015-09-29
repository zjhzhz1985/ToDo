package com.zhehekeji.taskpool;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskListFragment extends ListFragment {
    //ImageView myImageViewz1;
    private ArrayList<Task> mTasks;
    private static final String TAG = "TaskListFragment";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.tasks_title);
        mTasks = TaskLab.get(getActivity()).getTasks();

//        ArrayAdapter<Task> adapter = new ArrayAdapter<Task>(getActivity(),
//                                                            android.R.layout.simple_list_item_1,
//                                                            mTasks);
        TaskAdapter adapter = new TaskAdapter(mTasks);

        setListAdapter(adapter);
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View v = inflater.inflate(R.layout.fragment_zhtime,container,false);
//
//
//
//        return v;
//    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        Task t = ((TaskAdapter) getListAdapter()).getItem(position);
        Log.d(TAG,t.getTitle() + " was clicked");
    }

    private class TaskAdapter extends ArrayAdapter<Task>{
        public TaskAdapter(ArrayList<Task> tasks){
            super(getActivity(),0,tasks);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            if(convertView == null){
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_task, null);
            }

            Task t = getItem(position);

            TextView titleTextView = (TextView)convertView.findViewById(R.id.list_item_task_TextView1);
            titleTextView.setText(t.getTitle());

            TextView dateTextView = (TextView)convertView.findViewById(R.id.list_item_task_TextView2);
            dateTextView.setText("dateTextView");

            CheckBox solvedCheckBox = (CheckBox)convertView.findViewById(R.id.list_item_task_CheckBox1);
            solvedCheckBox.setChecked(true);
            return convertView;
        }
    }

}
