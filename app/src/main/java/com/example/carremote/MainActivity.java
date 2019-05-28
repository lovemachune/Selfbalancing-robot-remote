package com.example.carremote;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private TextView mTextMessage;
    private Fragment selectFragment = null;
    private Control control;
    private Connection connection;
    private  setPID set_pid;
    private Timer timer;
    private TimerTask timerTask;
    private  int type = 0;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_Connection:
                    selectFragment = connection;
                    type = 0;
                    break;
                case R.id.navigation_Control:
                    selectFragment = control;
                    type = 1;
                    break;
                case R.id.navigation_PID:
                    selectFragment = set_pid;
                    type = 2;
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectFragment).commit();
            return  true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        control = new Control();
        connection = new Connection();
        set_pid = new setPID();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                if(connection.getmBluetoothConnection()!=null && connection.getmBluetoothConnection().isConnected())
                {
                        if(type == 1)
                        {
                            String motor_R, motor_L;
                            int [] joyValue = control.getJoy_value();
                            motor_L = Integer.toString(joyValue[1]);
                            motor_R = Integer.toString(joyValue[0]);
                            btSentText(motor_L+','+motor_R);
                        }
                        if(type == 2)
                        {
                            if(set_pid.getSend())
                                btSentText(set_pid.getData());
                            else
                            {
                                String messenge = connection.getmBluetoothConnection().read();
                                String data[] = messenge.split(",");
                                set_pid.getPhi().setText(data[0]);
                                set_pid.getSpeed().setText(data[1]);
                                set_pid.setSend();
                                //test again
                            }
                        }
                }
            }
        };
        timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 1000, 250);
        Log.d(TAG,"timer set");

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        selectFragment = connection;
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectFragment).commit();
    }
    public void btSentText(String command) {
        connection.getmBluetoothConnection().write(command);
    }
    public String btRendText()
    {
        return connection.getmBluetoothConnection().read();
    }

}
