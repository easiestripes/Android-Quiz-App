package cloyster.android_mini_app_cloyster;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by main-mini on 9/19/16.
 */
public class ListArrayAdapter extends ArrayAdapter {

    public ListArrayAdapter(Context context, ArrayList<String> quizzes) {
        super(context, 0, quizzes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        String quiz = getItem(position).toString();
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.finished_text_layout, parent, false);
        }
        // Lookup view for data population
        TextView quiz_textview = (TextView) convertView.findViewById(R.id.quiz_1);
        //TextView tvHome = (TextView) convertView.findViewById(R.id.tvHome);
        // Populate the data into the template view using the data object
        //tvName.setText(user.name);
        //tvHome.setText(user.hometown);
        // Return the completed view to render on screen
        return quiz_textview;
    }
}
