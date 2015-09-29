package com.zhehekeji.taskpool;

import java.util.UUID;

/**
 * Created by admin on 15/9/6.
 */
public class Task {
    private UUID mId;
    private String mTitle;
    //time
    //完成度  mCompleteQuantity／mTotalQuantity
    private int mCompleteQuantity;
    private int mTotalQuantity;

    private Boolean IsTodayCompleted = false;

    public Task() {
        mId = UUID.randomUUID();
        mCompleteQuantity = 0;
        mTotalQuantity = 0;
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public void setCompleteQuantity(int aint) {
        mCompleteQuantity = aint;
    }

    public void setTotalQuantity(int aint) {
        mTotalQuantity = aint;
    }

    public String getDegreeOfCompletion() {
        return mCompleteQuantity + "/" + mTotalQuantity;
    }

    public void addCompleteQuantity(int aint) {
        mCompleteQuantity = mCompleteQuantity + aint;
    }

    public void addTotalQuantity(int aint) {
        mTotalQuantity = mTotalQuantity + aint;
    }

    public void setIsTodayCompleted() {
        IsTodayCompleted = true;
        mCompleteQuantity++;
    }

    @Override
    public String toString(){
        return mTitle;
    }

}
