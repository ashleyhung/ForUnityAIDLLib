package com.example.forunityaidllib;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;

import com.example.foregroundservice.IMyAidlInterface;

public class MainActivity extends UnityPlayerActivity {

    private IMyAidlInterface aidlInterface;

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i("ServiceConnection", "onServiceConnected() called");
            aidlInterface = IMyAidlInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i("ServiceConnection", "onServiceDisconnected() called");
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public String getServiceLocalTime()
    {
        String retVal = "";
        try {
            retVal = "call aidl here";
//            retVal = aidlInterface.getLocalTime();
            Toast.makeText(MainActivity.this, retVal, Toast.LENGTH_SHORT).show();
//        } catch (RemoteException e){
        } catch (Exception e){
            retVal = e.toString();
            Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
        }
        return retVal;
    }
}