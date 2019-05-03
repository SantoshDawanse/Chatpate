package com.dawnsoft.chatpate.chatpatefrags;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.dawnsoft.chatpate.R;
import com.dawnsoft.chatpate.model.ChatpateAdapter;
import com.dawnsoft.chatpate.model.ChatpateItem;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomChatpateFrag extends Fragment {

    private ListView listView;
    private Button okBtn;

    private ChatpateAdapter chatpateAdapter;

    //for selected item
    private ArrayList<String> selectedList;


    public CustomChatpateFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_custom_chatpate, container, false);

        listView = view.findViewById(R.id.custom_chatpate_listview);
        okBtn = view.findViewById(R.id.custom_chatpate_ok_btn);

        selectedList = new ArrayList<>();

        String[] values = new String[]{"Onion", "Cucumber", "Tomato", "Peas", "Potato",
                "Dhaniya", "Chat Masala", "Green Chilly", "Kagati", "Oil", "Salt",
                "Murai", "Chau Chau", "Chilly Powder", "Masala"};


        ArrayList<ChatpateItem> chatpateItems = new ArrayList<>();
        for (int i = 0; i < values.length; ++i) {
            chatpateItems.add(new ChatpateItem(values[i], 0));

            selectedList.add(values[i]);
        }

        chatpateAdapter = new ChatpateAdapter(getContext(), chatpateItems);
        listView.setAdapter(chatpateAdapter);
        chatpateAdapter.notifyDataSetChanged();

        okBtn.setOnClickListener(v -> {
            for (int i = 0; i < chatpateItems.size(); i++) {
                Log.i("Position " + i, String.valueOf(chatpateItems.get(i).getItemAmount()));
            }
        });

        return view;
    }

}
