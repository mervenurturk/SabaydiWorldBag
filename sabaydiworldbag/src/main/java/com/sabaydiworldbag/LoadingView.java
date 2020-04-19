package com.sabaydiworldbag;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

public class LoadingView {
    private Context con;
    private Dialog progressBar;
    public LoadingView(Context con){
        this.con=con;

    }

    public void showLoading(){

        LayoutInflater inflater = (LayoutInflater) con.getSystemService(con.LAYOUT_INFLATER_SERVICE);
        View vloading   = inflater.inflate(R.layout.loadingview, null);
        if (progressBar!=null){
            progressBar.dismiss();
            progressBar=null;
        }
        progressBar = new Dialog(con);
        progressBar.requestWindowFeature(Window.FEATURE_NO_TITLE);
        progressBar.setContentView(vloading);
        progressBar.setCancelable(false);
        progressBar.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        progressBar.show();

    }
    public void hideLoading(){
        if (progressBar!=null){
            progressBar.dismiss();
        }

    }

}
