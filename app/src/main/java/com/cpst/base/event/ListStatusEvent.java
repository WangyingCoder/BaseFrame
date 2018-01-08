package com.cpst.base.event;

/**
 * Created by wy on 2017/12/3.
 * 状态 Event
 */

public class ListStatusEvent {
    public static final int  Top = 0;
    public static final int  Scrool = 1;
    private int statue;

    public int getStatue(){
        return statue;
    }

    public ListStatusEvent (int statue){
        this.statue = statue;
    }
}
