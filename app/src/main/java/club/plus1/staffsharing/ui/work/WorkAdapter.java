package club.plus1.staffsharing.ui.work;

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

public class WorkAdapter extends RecyclerView.Adapter<WorkAdapter.WorkHolder>{

    private Context context;
    private List<WorkItem> list;
    private List<WorkItem> copy;

    WorkAdapter(Context context, List<WorkItem> list){
        this.context = context;
        this.list = list;
        copy = new ArrayList<>();
        copy.addAll(list);
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

    void filter(String text) {
        list.clear();
        if(text.isEmpty()){
            list.addAll(copy);
        } else{
            text = text.toLowerCase();
            for(WorkItem item: copy){
                if(item.text.toLowerCase().contains(text)){
                    list.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }

    class WorkHolder extends RecyclerView.ViewHolder{
        TextView textView;
        WorkHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textWork);
        }
    }
}
