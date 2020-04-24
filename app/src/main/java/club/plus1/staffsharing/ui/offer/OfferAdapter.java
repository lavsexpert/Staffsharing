package club.plus1.staffsharing.ui.offer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import club.plus1.staffsharing.R;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.OfferHolder>{

    Context context;
    List<OfferItem> list;

    OfferAdapter(Context context, List<OfferItem> list){
        this.context = context;
        this.list = list;
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

    class OfferHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public OfferHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textOffer);
        }
    }
}
