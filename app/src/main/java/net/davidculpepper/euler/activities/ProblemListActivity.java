package net.davidculpepper.euler.activities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import net.davidculpepper.euler.EulerApplication;
import net.davidculpepper.euler.R;
import net.davidculpepper.euler.adapters.ProblemAdapter;
import net.davidculpepper.euler.intents.ProblemIntent;
import net.davidculpepper.euler.models.Problem;

import java.util.List;

import javax.inject.Inject;

public class ProblemListActivity extends ListActivity {

    @Inject List<Problem> problems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_list);
        EulerApplication.inject(this);
        setListAdapter(new ProblemAdapter(this, problems));
    }

    @Override
    protected void onListItemClick(ListView list, View view, int position, long id) {
        Intent intent = new ProblemIntent.Builder(this)
                .position(position)
                .build();
        startActivity(intent);
    }
}