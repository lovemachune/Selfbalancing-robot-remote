package com.example.carremote;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class setPID extends Fragment {
    private double car_kp, car_ki, car_kd, car_ref;
    private TextView kp,ki,kd,reference, phi, speed;
    private SeekBar seekBar_kp, seekBar_ki, seekBar_kd, seekBar_reference;
    private Button button_kpm, button_kpp, button_kim, button_kip, button_kdm, button_kdp, button_referencem, button_referencep,button_send;
    private  boolean send_receive;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pid, container,false);

        kp = (TextView)view.findViewById(R.id.text_kp);
        ki = (TextView)view.findViewById(R.id.text_ki);
        kd = (TextView)view.findViewById(R.id.text_kd);
        reference = (TextView)view.findViewById(R.id.text_reference);
        phi = (TextView)view.findViewById(R.id.text_phi);
        speed=(TextView)view.findViewById(R.id.text_speed);

        seekBar_kp = (SeekBar)view.findViewById(R.id.pid_kp);
        seekBar_ki = (SeekBar)view.findViewById(R.id.pid_ki);
        seekBar_kd = (SeekBar)view.findViewById(R.id.pid_kd);
        seekBar_reference = (SeekBar)view.findViewById(R.id.pid_reference);

        seekBar_kp.setProgress(50);
        seekBar_ki.setProgress(50);
        seekBar_kd.setProgress(50);
        seekBar_reference.setProgress(50);

        button_kpm = (Button)view.findViewById(R.id.button_kpm);
        button_kpp = (Button)view.findViewById(R.id.button_kpp);
        button_kim = (Button)view.findViewById(R.id.button_kim);
        button_kip = (Button)view.findViewById(R.id.button_kip);
        button_kdm = (Button)view.findViewById(R.id.button_kdm);
        button_kdp = (Button)view.findViewById(R.id.button_kdp);
        button_referencem = (Button)view.findViewById(R.id.button_referencm);
        button_referencep = (Button)view.findViewById(R.id.button_referencp);
        button_send = (Button)view.findViewById(R.id.Send);

        button_kpm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seekBar_kp.incrementProgressBy(-1);
            }
        });
        button_kpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seekBar_kp.incrementProgressBy(1);
            }
        });

        button_kim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seekBar_ki.incrementProgressBy(-1);
            }
        });
        button_kip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seekBar_ki.incrementProgressBy(1);
            }
        });
        button_kdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seekBar_kd.incrementProgressBy(-1);
            }
        });
        button_kdp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seekBar_kd.incrementProgressBy(1);
            }
        });
        button_referencem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seekBar_reference.incrementProgressBy(-1);
            }
        });
        button_referencep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seekBar_reference.incrementProgressBy(1);
            }
        });

        button_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send_receive = false;
            }
        });
        seekBar_kp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                kp.setText(""+ String.format("%.4s",car_kp+(progress-50)/10.)+ "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar_ki.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ki.setText("" +  (car_ki+(progress-50)) + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar_kd.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                kd.setText(""+ (car_kd+0.01*(progress-50)) + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar_reference.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                reference.setText("" +  (car_ref+0.01*(progress-50)) + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        return view;
    }
    boolean getSend() { return send_receive; }
    void setSend(){send_receive = true;}
    TextView getPhi(){return phi;}
    TextView getSpeed(){return  speed;}
    String getData() { return kp.getText()+" "+ki.getText()+" "+kd.getText()+" "+reference.getText(); }
    void setData(double p, double i, double d, double r)
    {
        car_kp = p;
        car_ki = i;
        car_kd = d;
        car_ref = r;
        kp.setText(String.valueOf(car_kp));
        ki.setText(String.valueOf(car_ki));
        kd.setText(String.valueOf(car_kd));
        reference.setText(String.valueOf(car_ref));
    }
}
