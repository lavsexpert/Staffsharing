package club.plus1.staffsharing.ui.work;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import club.plus1.staffsharing.R;

public class WorkAdapter extends RecyclerView.Adapter<WorkAdapter.WorkHolder>{

    Context context;
    List<WorkItem> list;

    WorkAdapter(Context context, List<WorkItem> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public WorkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.work_item, parent, false);
        return new WorkHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkHolder holder, int position) {
        final WorkItem item = list.get(position);
        holder.textView.setText(item.text);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class WorkHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public WorkHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textWork);
        }
    }
}
