package com.dawnsoft.chatpate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.dawnsoft.chatpate.chatpatefrags.AboutFrag;
import com.dawnsoft.chatpate.chatpatefrags.CustomChatpateFrag;

public class ChatpateAdmin extends AppCompatActivity {

    private Button _regularChatpateBtn, _customChatpateBtn, _aboutChatpateBtn;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatpate_admin);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        _regularChatpateBtn = findViewById(R.id.chatpate_regular);
        _customChatpateBtn = findViewById(R.id.chatpate_customize);
        _aboutChatpateBtn = findViewById(R.id.chatpate_about);

        loadFragment(new AboutFrag());

        _customChatpateBtn.setOnClickListener(v -> {
                    loadFragment(new CustomChatpateFrag());
//                    setUIEnabled(false);
                }
        );

        _aboutChatpateBtn.setOnClickListener(v -> loadFragment(new AboutFrag()));
    }

    private void setUIEnabled(boolean bool) {
        _customChatpateBtn.setEnabled(bool);
        _aboutChatpateBtn.setEnabled(bool);
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.chatpate_frameLayout, fragment);
        fragmentTransaction.commit();
    }
}
