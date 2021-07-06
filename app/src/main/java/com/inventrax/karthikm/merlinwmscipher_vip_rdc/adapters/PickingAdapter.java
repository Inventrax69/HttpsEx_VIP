package com.inventrax.karthikm.merlinwmscipher_vip_rdc.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.inventrax.karthikm.merlinwmscipher_vip_rdc.R;
import com.inventrax.karthikm.merlinwmscipher_vip_rdc.fragments.PickingHeaderFragment;
import com.inventrax.karthikm.merlinwmscipher_vip_rdc.pojos.OutbountDTO;

import java.util.List;

public class PickingAdapter extends RecyclerView.Adapter<PickingAdapter.Recycle> {
    Context context;
    FragmentActivity activity;
    List<OutbountDTO> lstOutbound;
    private String pickRefNo = "", pickobdId;
    public final PickingHeaderFragment.OnListFragmentInteractionListener mListener;
    Button btnPicking;


    public PickingAdapter(FragmentActivity activity, Context context, List<OutbountDTO> lstOutbound, PickingHeaderFragment.OnListFragmentInteractionListener listener
    ) {
        this.context = context;
        this.activity = activity;
        this.lstOutbound = lstOutbound;
        this.mListener = listener;
    }

    @Override
    public Recycle onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.pickinglayout, parent, false);
        return new Recycle(v);
    }

    @Override
    public void onBindViewHolder(Recycle holder, @SuppressLint("RecyclerView") final int position) {
        holder.pickLocation.setText(lstOutbound.get(position).getLocation());
        holder.pickSku.setText(lstOutbound.get(position).getSKU());
        holder.pickSkuDescription.setText(lstOutbound.get(position).getMaterialDescription());
        String pickedQty = lstOutbound.get(position).getPickedQty();
        String assignedQty = lstOutbound.get(position).getAssignedQuantity();
        holder.pickQuantity.setText(pickedQty + "/" + assignedQty);

/*        if(!pickedQty.equalsIgnoreCase(assignedQty)){
            btnPicking.setVisibility(View.VISIBLE);
        }*/

        if (lstOutbound.get(position).getPendingQty().equalsIgnoreCase("0.00"))
            btnPicking.setVisibility(View.GONE);
        else
            btnPicking.setVisibility(View.VISIBLE);


    }

    @Override
    public int getItemCount() {
        return lstOutbound.size();
    }

    public class Recycle extends RecyclerView.ViewHolder {
        TextView pickLocation, pickSku, pickSkuDescription, pickQuantity;
        View mView;

        public Recycle(View itemView) {
            super(itemView);
            pickLocation = (TextView) itemView.findViewById(R.id.pickLocation);
            pickSku = (TextView) itemView.findViewById(R.id.pickSku);
            pickSkuDescription = (TextView) itemView.findViewById(R.id.pickSkuDescription);
            pickQuantity = (TextView) itemView.findViewById(R.id.pickQuantity);
            btnPicking = (Button) itemView.findViewById(R.id.btnPicking);


            btnPicking.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (null != mListener) {
                        // returns selected position to the fragment
                        int position = getAdapterPosition();
                        mListener.onListFragmentInteraction(position);


                    }
                }
            });
        }
    }
}
