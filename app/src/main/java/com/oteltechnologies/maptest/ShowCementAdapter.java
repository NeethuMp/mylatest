package com.oteltechnologies.maptest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Qvertz on 2/13/2017.
 */

public class ShowCementAdapter extends RecyclerView.Adapter<ShowCementAdapter.MyViewHolder> {

private Context mContext;
private List<ShowCementData> cementDataList;


public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView cementName, cementPrice;
    public ImageView thumbnail;
    public Button but;

    public MyViewHolder(View view) {
        super(view);
        cementName = (TextView) view.findViewById(R.id.cement_text1);
        cementPrice = (TextView) view.findViewById(R.id.cement_text2);
        thumbnail = (ImageView) view.findViewById(R.id.cement_img);
        but=(Button)view.findViewById(R.id.buy_btn);
    }
}


    public ShowCementAdapter(Context mContext, List<ShowCementData> cementDatas) {
        this.mContext = mContext;
        this.cementDataList = cementDatas;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cement_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final ShowCementData album = cementDataList.get(position);
        holder.cementName.setText(album.getName());
        holder.cementPrice.setText(album.getPrice());
        // loading album cover using Glide library
        Picasso.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);

        holder.but.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(view.getContext(),ShoppingBagActivity.class);
                        //bundle.putInt("IMAGE", cementDataList.get(position).getThumbnail());
                        //bundle.putString("name",cementDataList.get(position).getName());
                       // Toast.makeText(mContext,album.getName(),Toast.LENGTH_LONG).show();
                       // intent.putExtras(bundle);
                        intent.putExtra("IMAGE",cementDataList.get(position).getThumbnail());
                        intent.putExtra("name",cementDataList.get(position).getName());
                        view.getContext().startActivity(intent);
                    }
                }
        );

    }



    @Override
    public int getItemCount() {
        return cementDataList.size();
    }
}
