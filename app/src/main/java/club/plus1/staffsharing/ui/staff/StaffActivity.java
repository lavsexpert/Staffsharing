package club.plus1.staffsharing.ui.staff;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

import club.plus1.staffsharing.R;

public class StaffActivity extends AppCompatActivity {

    SearchView searchView;
    RecyclerView recyclerView;
    StaffAdapter adapter;
    List<StaffItem> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.staff);
        setData();
        adapter = new StaffAdapter(this, list);
        recyclerView = findViewById(R.id.listStaff);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        setTitle(getString(R.string.staff_title));

        searchView = findViewById(R.id.searchStaff);
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
        list.add(new StaffItem("Есть 10 программистов"));
        list.add(new StaffItem("Готов работать охранником"));
        list.add(new StaffItem("Подбираем любые команды под проект"));
    }
}
