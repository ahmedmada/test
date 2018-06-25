package com.qader.ahmed.souqdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qader.ahmed.souqdemo.R;
import com.qader.ahmed.souqdemo.model.CategoryModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Ahmed AbdElQader on 08-Apr-18.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    ArrayList<CategoryModel> list;
    private LayoutInflater mInflater;
    Context context;

    int parent = 0;

    public CategoryAdapter(Context context,ArrayList<CategoryModel> list,int parent) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.list = list;
        this.parent = parent;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.category_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {


        if (parent == list.get(position).getParent()){

            holder.categoryName.setText(list.get(position).getName());

            Picasso.get().load(list.get(position).getImage()).into(holder.categoryImage);

            holder.categoryLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
    //                Intent i = new Intent(context, ViewPDF.class);
    //                i.putExtra("story",position);
    //                context.startActivity(i);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder  {

        ImageView categoryImage;
        TextView categoryName;
        LinearLayout categoryLayout;

        ViewHolder(View itemView) {
            super(itemView);
            categoryImage = (ImageView) itemView.findViewById(R.id.categoryImage);
            categoryName = (TextView) itemView.findViewById(R.id.categoryName);
            categoryLayout = (LinearLayout) itemView.findViewById(R.id.categoryLayout);
        }

    }

}