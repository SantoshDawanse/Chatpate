package com.dawnsoft.chatpate.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.dawnsoft.chatpate.R;

import java.util.ArrayList;
import java.util.List;

public class ChatpateAdapter extends ArrayAdapter<ChatpateItem> {

    private Context mContext;
    private List<ChatpateItem> chatpateItemList = new ArrayList<>();
    private List<Integer> itemAmountList = new ArrayList<>();


    public ChatpateAdapter(Context context, List<ChatpateItem> chatpateItemList) {
        super(context, 0, chatpateItemList);
        mContext = context;
        this.chatpateItemList = chatpateItemList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View currentView = convertView;
        if (currentView == null) {
            currentView = LayoutInflater.from(getContext()).inflate(R.layout.chatpate_custom_rowitem, parent, false);
        }

        ChatpateItem chatpateItem = getItem(position);

        TextView itemName = currentView.findViewById(R.id.rowitem_title);
        itemName.setText(chatpateItem.getItemName());

        SeekBar amountSeekBar = currentView.findViewById(R.id.rowitem_seekbar);
        amountSeekBar.setProgress(chatpateItem.getItemAmount());

        CheckBox itemIsChecked = currentView.findViewById(R.id.rowitem_checkbox);
        itemIsChecked.setChecked(chatpateItem.isChecked());

        RelativeLayout contactListItem = currentView.findViewById(R.id.rowitem_rl);
//        contactListItem.setOnClickListener(v -> ((ListView) parent).performItemClick(v, position, ((ListView) parent).getAdapter().getItemId(position)));

        amountSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                chatpateItem.setItemAmount(seekBar.getProgress());
//                ((ListView) parent).performItemClick(, position, ((ListView) parent).getAdapter().getItemId(position));
                Toast.makeText(getContext(), String.valueOf(seekBar.getProgress()), Toast.LENGTH_SHORT).show();
                chatpateItem.setItemAmount(seekBar.getProgress());
                notifyDataSetChanged();
            }
        });

        return currentView;
    }

    @Override
    public int getCount() {
        return chatpateItemList.size();
    }

    //checking whether the checkbox is checked or not
    public void isSelected(boolean check){
        View view = LayoutInflater.from(getContext()).inflate(R.layout.chatpate_custom_rowitem, null);
        CheckBox checkBox = view.findViewById(R.id.rowitem_checkbox);
        checkBox.setChecked(check);
    }

    public void setSeekBarProgress(int progress) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.chatpate_custom_rowitem, null);
        SeekBar seekBar = view.findViewById(R.id.rowitem_seekbar);
        seekBar.setProgress(progress);
    }

    public List<ChatpateItem> getArray() {

        return chatpateItemList;
    }
}
