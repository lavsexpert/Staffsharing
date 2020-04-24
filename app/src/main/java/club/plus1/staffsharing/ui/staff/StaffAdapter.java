package club.plus1.staffsharing.ui.staff;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import club.plus1.staffsharing.R;

public class StaffAdapter extends RecyclerView.Adapter<StaffAdapter.StaffHolder>{

    Context context;
    List<StaffItem> list;

    StaffAdapter(Context context, List<StaffItem> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public StaffHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.staff_item, parent, false);
        return new StaffHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StaffHolder holder, int position) {
        final StaffItem item = list.get(position);
        holder.textView.setText(item.text);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class StaffHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public StaffHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textStaff);
        }
    }
}
