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
    private TextView kp,ki,kd,reference;
    private SeekBar seekBar_kp, seekBar_ki, seekBar_kd, seekBar_reference;
    private Button button_kpm, button_kpp, button_kim, button_kip, button_kdm, button_kdp, button_referencem, button_referencep;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pid, container,false);

        kp = (TextView)view.findViewById(R.id.text_kp);
        ki = (TextView)view.findViewById(R.id.text_ki);
        kd = (TextView)view.findViewById(R.id.text_kd);
        reference = (TextView)view.findViewById(R.id.text_reference);

        seekBar_kp = (SeekBar)view.findViewById(R.id.pid_kp);
        seekBar_ki = (SeekBar)view.findViewById(R.id.pid_ki);
        seekBar_kd = (SeekBar)view.findViewById(R.id.pid_kd);
        seekBar_reference = (SeekBar)view.findViewById(R.id.pid_reference);

        button_kpm = (Button)view.findViewById(R.id.button_kpm);
        button_kpp = (Button)view.findViewById(R.id.button_kpp);
        button_kim = (Button)view.findViewById(R.id.button_kim);
        button_kip = (Button)view.findViewById(R.id.button_kip);
        button_kdm = (Button)view.findViewById(R.id.button_kdm);
        button_kdp = (Button)view.findViewById(R.id.button_kdp);
        button_referencem = (Button)view.findViewById(R.id.button_referencm);
        button_referencep = (Button)view.findViewById(R.id.button_referencp);

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

        seekBar_kp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                kp.setText(""+ (progress-50)+ "");
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
                ki.setText("" +  (progress-50) + "");
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
                kd.setText(""+ (progress-50) + "");
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
                reference.setText("" +  (progress-50) + "");
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
    String getData()
    {
        return kp.getText()+" "+ki.getText()+" "+kd.getText()+" "+reference.getText();
    }
}
