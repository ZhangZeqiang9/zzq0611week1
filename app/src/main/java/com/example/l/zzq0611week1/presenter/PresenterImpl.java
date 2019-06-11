package com.example.l.zzq0611week1.presenter;

import com.example.l.zzq0611week1.Contract;
import com.example.l.zzq0611week1.model.ModelImpl;

import java.lang.ref.SoftReference;

/*
 * p层交互
 * zzq
 */
public class PresenterImpl implements Contract.Presenter {
    private Contract.Model model;
    private Contract.IView iView;
    private SoftReference<Contract.IView> soft;
    public PresenterImpl(Contract.IView iView) {
        this.iView = iView;
        model = new ModelImpl();
        soft = new SoftReference<>(iView);
    }

    @Override
    public void getdata(int page) {
        model.ShowData(page, new Contract.CallBack() {
            @Override
            public void getData(String data) {
                iView.getResult(data);
            }
        });
    }

    @Override
    public void onDeatch() {
        if(soft!=null){
            soft.clear();
        }
        if(model!=null){
            model=null;
        }
    }
}
