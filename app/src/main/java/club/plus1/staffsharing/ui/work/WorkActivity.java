package club.plus1.staffsharing.ui.work;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

import club.plus1.staffsharing.R;

public class WorkActivity extends AppCompatActivity {

    SearchView searchView;
    RecyclerView recyclerView;
    WorkAdapter adapter;
    List<WorkItem> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.work);
        setData();
        adapter = new WorkAdapter(this, list);
        recyclerView = findViewById(R.id.listWork);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        setTitle(getString(R.string.work_title));

        searchView = findViewById(R.id.searchWork);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.filter(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.filter(newText);
                return true;
            }
        });
    }

    private void setData() {
        list = new ArrayList<>();
        list.add(new WorkItem("Ищем программиста"));
        list.add(new WorkItem("Нужен охранник"));
        list.add(new WorkItem("Ищем человека для обзвонов"));
    }
}
