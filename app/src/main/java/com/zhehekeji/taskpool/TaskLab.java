package com.zhehekeji.taskpool;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by admin on 15/9/6.
 */
public class TaskLab {
    //用户新增任务组
    private ArrayList<Task> mUserAddTasks;

    //用户日常任务组
    private ArrayList<Task> mUserUsualTasks;

    private ArrayList<Task> mTasks;

    private static TaskLab sTaskLab;
    private Context mAppContext;

    private TaskLab(Context appContext){
        mAppContext = appContext;
        mTasks = new ArrayList<Task>();
        for(int i = 0; i < 10; i++){
            Task t = new Task();
            t.setTitle("Task #" + i);
            mTasks.add(t);
        }
    }

    public static TaskLab get(Context c){
        if(sTaskLab == null){
            sTaskLab = new TaskLab(c.getApplicationContext());
        }
        return sTaskLab;
    }

    public ArrayList<Task> getTasks(){
        return mTasks;
    }

    public Task getTask(UUID id){
        for(Task c : mTasks){
            if(c.getId().equals(id))
                return c;
        }
        return null;
    }

    public void setUserUsualTasks(){

    }

    public ArrayList<Task> getUserUsualTasks(){
        return mUserUsualTasks;
    }

    public void setUserAddTasks(){

    }

    public ArrayList<Task> getUserAddTasks(){
        return mUserAddTasks;
    }



}
