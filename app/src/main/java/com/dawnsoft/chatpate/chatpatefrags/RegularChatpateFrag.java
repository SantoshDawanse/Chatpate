package com.dawnsoft.chatpate.chatpatefrags;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dawnsoft.chatpate.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegularChatpateFrag extends Fragment {


    public RegularChatpateFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_regular_chatpate, container, false);
    }

}
