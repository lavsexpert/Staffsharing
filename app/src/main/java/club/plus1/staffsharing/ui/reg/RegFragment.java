package club.plus1.staffsharing.ui.reg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import club.plus1.staffsharing.R;

public class RegFragment extends Fragment {

    private static final String ARG_PAGE = "ARG_PAGE";
    private int page;

    EditText editCompanyName;
    EditText editCompanyId;
    EditText editEmployeeSurname;
    EditText editEmployeeName;
    EditText editEmployeePatronymic;
    EditText editEmployeeId;

    static RegFragment newInstance(int page) {
        RegFragment fragment = new RegFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            page = getArguments().getInt(ARG_PAGE);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        if (page == 0) {
            View view = inflater.inflate(R.layout.reg_company, container, false);
            editCompanyName = view.findViewById(R.id.editCompanyName);
            editCompanyId = view.findViewById(R.id.editCompanyId);
            return view;
        } else {
            View view = inflater.inflate(R.layout.reg_employee, container, false);
            editEmployeeSurname = view.findViewById(R.id.editEmployeeSurname);
            editEmployeeName = view.findViewById(R.id.editEmployeeName);
            editEmployeePatronymic = view.findViewById(R.id.editEmployeePatronymic);
            editEmployeeId = view.findViewById(R.id.editEmployeeId);
            return view;
        }
    }

}
