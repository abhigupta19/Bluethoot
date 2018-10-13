package com.example.user.bluoo;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
  BluetoothAdapter b;
  Button b1,b2,b3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        if(b.isEnabled())
        {
            Toast.makeText(getApplicationContext(),"Bluetooth is turnon",Toast.LENGTH_LONG);

        }
        else {
            Intent i1 = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivity(i1);
            if (b.isEnabled()) {
                Toast.makeText(getApplicationContext(), "Bluetooth is turnedon", Toast.LENGTH_LONG);
            }

        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.disable();
                if(b.isEnabled())
                {
                    Toast.makeText(getApplicationContext(),"Bluetooth could not turnoff",Toast.LENGTH_LONG);
                }
                else {

                    Toast.makeText(getApplicationContext(), "Bluetooth is turnoff", Toast.LENGTH_LONG);

                }
            }

        });
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                    startActivity(i);
                }
            });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Set<BluetoothDevice> p=b.getBondedDevices();
                ListView l=(ListView)findViewById(R.id.list);
                ArrayList pll=new ArrayList();
                for(BluetoothDevice baa:p)
                {
                    pll.add(baa.getName());
                }
                ArrayAdapter ar;
                ar = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,pll);
                l.setAdapter(ar);

            }
        });

    }
}
