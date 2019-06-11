package com.example.l.zzq0611week1;
/*
 * 契约类
 */
public interface Contract {
    /*
    * M层
    */
    interface Model{
        void ShowData(int page,CallBack callBack);
    }
    /*
     * V层
     */
    interface IView{
        void getResult(String data);
    }
    /*
     * P层
     */
    interface Presenter{
        void getdata(int page);
        void onDeatch();
    }
    interface CallBack{
        void getData(String data);
    }
}
