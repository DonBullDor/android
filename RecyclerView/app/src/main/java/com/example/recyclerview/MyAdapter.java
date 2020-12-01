package com.example.recyclerview;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/* Now comes the heart of RecyclerView – the adapter. Create a new Java file
called MyAdapter.java. Our new class will extend from the
RecylerView.Adapter class so there are several key methods we need to
override */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
        implements SelectMode {

    private SelectMode mListener;
    private List<String> nameList;
    //Added following list
    @SuppressLint("UseSparseArrays")
    private SparseArray<Boolean> selectedList = new SparseArray<>();

    public MyAdapter(List<String> list, SelectMode listener) { //Added listener to parameters
        nameList = list;
        mListener = listener;
    }

    /* The adapter only calls onCreateViewHolder() to
    create enough items to show on the screen (plus a few extra for scrolling),
    whereas onBindViewHolder() is called for each item as it’s displayed. */
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /* Inflate a new view hierarchy from the specified xml resource. here from parent*/
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        /* We inflate the xml which gives us a view */
        View view = inflater.inflate(R.layout.item, parent, false);
        /* Return the generated view */
        return new MyViewHolder(view);
    }

    /*This is why RecyclerView takes advantage of the fact that as you scroll and new rows come on
    screen also old rows disappear off screen. Instead of creating new view for each new row,
    an old view is recycled and reused by binding new data to it.
    This happens exactly in onBindViewHolder(). Initially you will get new unused view holders
    and you have to fill them with data you want to display. But as you scroll you'll start getting
     view holders that were used for rows that went off screen and you have to replace old data
     that they held with new data.
     */
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        final String name = nameList.get(position);
        holder.textView.setText(name);
        holder.itemView.setSelected(selectedList.get(position, false)); //New (for There's more)

        // add onClickListener on items in the recyclerView
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.itemView.setSelected(!holder.itemView.isSelected());
                if (holder.itemView.isSelected()) {
                    selectedList.put(position, true);
                } else {
                    // remove selected item
                    selectedList.remove(position);
                }
                onSelect();
            }
        });
        holder.itemView.setSelected(selectedList.get(position, false));
    }

    @Override
    public int getItemCount() {
        if (nameList == null) {
            return 0;
        } else {
            return nameList.size();
        }
    }

    // function for removing items used in onBindViewHolder
    private void remove(int position) {
        nameList.remove(position);
        notifyItemRemoved(position);
    }

    // delete all selected at once
    public void deleteAllSelected() {
        if (selectedList.size() == 0) {
            return;
        }
        for (int index = nameList.size() - 1; index >= 0; index--) {
            if (selectedList.get(index, false)) {
                remove(index);
            }
        }
        selectedList.clear();
    }

    @Override
    public void onSelect() {
        if (mListener != null) {
            mListener.onSelect();
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public MyViewHolder(View itemVieww) {
            super(itemVieww);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
