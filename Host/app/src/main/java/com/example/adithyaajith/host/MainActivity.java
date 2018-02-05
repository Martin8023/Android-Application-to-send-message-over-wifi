package com.example.adithyaajith.host;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.AsyncTask;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ToggleButton warn1, warn2, warn3, warn4, warn5, warn6;
    ConstraintLayout mylay;
    String IP = "192.168.49.116";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        warn1 = findViewById(R.id.warn1);
        warn2 = findViewById(R.id.warn2);
        warn3 = findViewById(R.id.warn3);
        warn4 = findViewById(R.id.warn4);
        warn5 = findViewById(R.id.warn5);
        warn6 = findViewById(R.id.warn6);
        mylay = findViewById(R.id.MyLayout);

        warn1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    long time = System.currentTimeMillis();
                    String date1 = DateFormat.getDateTimeInstance().format(new Date(time));
                    MyClientTask myClientTask = new MyClientTask(IP, 8080, date1);
                    myClientTask.execute();
                    // The toggle is enabled
                    mylay.setBackgroundColor(Color.BLUE);
                } else {
                    // The toggle is disabled
                    mylay.setBackgroundColor(Color.WHITE);
                    long time = System.currentTimeMillis();
                    String date1 = DateFormat.getDateTimeInstance().format(new Date(time));
                    MyClientTask myClientTask = new MyClientTask(IP, 8080, date1);
                    myClientTask.execute();
                }
            }
        });


        warn2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    MyClientTask myClientTask = new MyClientTask(IP, 8080,"Warning2");
                    myClientTask.execute();
                    // The toggle is enabled
                    mylay.setBackgroundColor(Color.BLUE);
                } else {
                    // The toggle is disabled
                    MyClientTask myClientTask = new MyClientTask(IP, 8080,"WarningOFF");
                    myClientTask.execute();
                    mylay.setBackgroundColor(Color.WHITE);
                }
            }
        });

        warn3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    MyClientTask myClientTask = new MyClientTask(IP, 8080,"Warning3");
                    myClientTask.execute();
                    mylay.setBackgroundColor(Color.BLUE);
                } else {
                    // The toggle is disabled
                    MyClientTask myClientTask = new MyClientTask(IP, 8080,"WarningOFF");
                    myClientTask.execute();
                    mylay.setBackgroundColor(Color.WHITE);
                }
            }
        });

        warn4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    MyClientTask myClientTask = new MyClientTask(IP, 8080,"Warning4");
                    myClientTask.execute();
                    mylay.setBackgroundColor(Color.BLUE);
                } else {
                    // The toggle is disabled
                    MyClientTask myClientTask = new MyClientTask(IP, 8080,"WarningOFF");
                    myClientTask.execute();
                    mylay.setBackgroundColor(Color.WHITE);
                }
            }
        });

        warn5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    MyClientTask myClientTask = new MyClientTask(IP, 8080,"Warning5");
                    myClientTask.execute();
                    mylay.setBackgroundColor(Color.BLUE);
                } else {
                    // The toggle is disabled
                    MyClientTask myClientTask = new MyClientTask(IP, 8080,"WarningOFF");
                    myClientTask.execute();
                    mylay.setBackgroundColor(Color.WHITE);
                }
            }
        });

        warn6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    MyClientTask myClientTask = new MyClientTask(IP, 8080,"Warning6");
                    myClientTask.execute();
                    mylay.setBackgroundColor(Color.BLUE);
                } else {
                    // The toggle is disabled
                    MyClientTask myClientTask = new MyClientTask(IP, 8080,"WarningOFF");
                    myClientTask.execute();
                    mylay.setBackgroundColor(Color.WHITE);
                }
            }
        });


    }

    public class MyClientTask extends AsyncTask<Void, Void, Void> {

        String dstAddress;
        int dstPort;
        String response = "";
        String msgToServer;

        MyClientTask(String addr, int port, String msgTo) {
            dstAddress = addr;
            dstPort = port;
            msgToServer = msgTo;
        }

        @Override
        protected Void doInBackground(Void... arg0) {

            Socket socket = null;
            DataOutputStream dataOutputStream = null;
            DataInputStream dataInputStream = null;

            try {
                socket = new Socket(dstAddress, dstPort);
                dataOutputStream = new DataOutputStream(
                        socket.getOutputStream());
                dataInputStream = new DataInputStream(socket.getInputStream());

                if (msgToServer != null) {
                    dataOutputStream.writeUTF(msgToServer);
                }

                response = dataInputStream.readUTF();

            } catch (UnknownHostException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                response = "UnknownHostException: " + e.toString();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                response = "IOException: " + e.toString();
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

                if (dataOutputStream != null) {
                    try {
                        dataOutputStream.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }

    }
}


