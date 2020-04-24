package club.plus1.staffsharing.ui.offer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import club.plus1.staffsharing.R;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.OfferHolder>{

    private Context context;
    private List<OfferItem> list;
    private List<OfferItem> copy;

    OfferAdapter(Context context, List<OfferItem> list){
        this.context = context;
        this.list = list;
        copy = new ArrayList<>();
        copy.addAll(list);
    }

    @NonNull
    @Override
    public OfferHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.offer_item, parent, false);
        return new OfferHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OfferHolder holder, int position) {
        final OfferItem item = list.get(position);
        holder.textView.setText(item.text);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    void filter(String text) {
        list.clear();
        if(text.isEmpty()){
            list.addAll(copy);
        } else{
            text = text.toLowerCase();
            for(OfferItem item: copy){
                if(item.text.toLowerCase().contains(text)){
                    list.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }

    class OfferHolder extends RecyclerView.ViewHolder{
        TextView textView;
        OfferHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textOffer);
        }
    }
}
