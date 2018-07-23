package sg.edu.rp.c346.mymovie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    ListView lvmovie;
    ArrayList<MovieItem> almovieList;
    CustomAdapter caMovie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvmovie = findViewById(R.id.listViewMovie);

        almovieList = new ArrayList<>();


        Calendar date1 = Calendar.getInstance();
        date1.set(2014,11,15);


        Calendar date2 = Calendar.getInstance();
        date1.set(2015,5,15);


        MovieItem item1 = new MovieItem("The Avengers","2012","pg13"," Action|Sci-Fi ",date1,"Golden Village-Bishan","Nick Fury of S.H.I.E.L.D. assembles a team of superheroes to save the planet from Loki and his army.");

        MovieItem item2 = new MovieItem("Planes","2013","pg","Animation|Comedy",date2,"Cathay-AMK Hub","A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race.");


        almovieList.add(item1);
        almovieList.add(item2);

       caMovie = new CustomAdapter(this, R.layout.movie_item, almovieList);

      lvmovie.setAdapter(caMovie);



        lvmovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                MovieItem getPos = almovieList.get(position);

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);

                intent.putExtra("Title", getPos.getTitle());
                intent.putExtra("Date",getPos.getDateString());
                intent.putExtra("Year",getPos.getYear());
                intent.putExtra("rated",getPos.getRated());
                intent.putExtra("genre",getPos.getGenre());
                intent.putExtra("inTheatre",getPos.getIn_theatre());
                intent.putExtra("description",getPos.getDescription());


                startActivity(intent);
            }
        });
    }
}
