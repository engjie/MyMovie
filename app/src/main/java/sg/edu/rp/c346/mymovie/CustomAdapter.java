package sg.edu.rp.c346.mymovie;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 16019641 on 23/7/2018.
 */

public class CustomAdapter extends ArrayAdapter {


    Context parent_context;
    int layout_id;
    ArrayList<MovieItem> toDoList;


    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<MovieItem> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        toDoList = objects;
    }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            // Obtain the LayoutInflater object.
            LayoutInflater inflater = (LayoutInflater) parent_context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            // Inflate a new view hierarchy from the specified xml resource (layout_id)
            // and return the root View of the inflated hierarchy.
            View rowView = inflater.inflate(layout_id, parent, false);

            TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
            TextView tvYear = rowView.findViewById(R.id.textViewYear);
            ImageView ivImpt = rowView.findViewById(R.id.imageViewMovie);


            MovieItem currentItem = toDoList.get(position);
            tvTitle.setText(currentItem.getTitle());
            tvYear.setText(currentItem.getYear() +"-" + currentItem.getGenre() );


            if(currentItem.getRated() =="pg") {
                ivImpt.setImageResource(R.drawable.rating_pg);
            }
            else if(currentItem.getRated() =="pg13"){
                ivImpt.setImageResource(R.drawable.rating_pg13);
            }
            else if(currentItem.getRated() =="g"){
                ivImpt.setImageResource(R.drawable.rating_g);
            }
            else if(currentItem.getRated() =="m18"){
                ivImpt.setImageResource(R.drawable.rating_m18);
            }

            else if(currentItem.getRated() =="nc16") {
                ivImpt.setImageResource(R.drawable.rating_nc16);
            }
            else{
                ivImpt.setImageResource(R.drawable.rating_r21);
            }


            return rowView;
        }
}
