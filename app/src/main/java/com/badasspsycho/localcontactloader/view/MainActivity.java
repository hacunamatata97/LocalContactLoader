package com.badasspsycho.localcontactloader.view;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.badasspsycho.localcontactloader.R;

public class MainActivity extends AppCompatActivity {

    private static final int READ_CONTACTS_REQUEST = 100;
    private RecyclerView mContactList;
    private Button mButtonRetry;
    private TextView mTextErrorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        requestPermission();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
            @NonNull int[] grantResults) {
        if (requestCode == READ_CONTACTS_REQUEST) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                showContactList();
            } else {
                enableErrorViews();
            }
        }
    }

    private void showContactList() {
        mContactList.setVisibility(View.VISIBLE);
        mTextErrorMessage.setVisibility(View.GONE);
        mButtonRetry.setVisibility(View.GONE);
    }

    private void enableErrorViews() {
        mContactList.setVisibility(View.GONE);
        mTextErrorMessage.setVisibility(View.VISIBLE);
        mButtonRetry.setVisibility(View.VISIBLE);
    }

    private void initializeViews() {
        mContactList = findViewById(R.id.list_contact);
        mButtonRetry = findViewById(R.id.button_grant_permission);
        mTextErrorMessage = findViewById(R.id.text_permission_error);

        mButtonRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermission();
            }
        });
    }

    private void requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[] { Manifest.permission.READ_CONTACTS }, READ_CONTACTS_REQUEST);
            }
        }
    }
}
