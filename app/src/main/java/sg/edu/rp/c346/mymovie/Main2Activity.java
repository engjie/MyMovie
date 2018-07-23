package sg.edu.rp.c346.mymovie;

import android.content.Intent;
import android.media.Rating;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView tvTitle;
    TextView tvDate;
    TextView tvYear;
    ImageView Imgrated;
    TextView tvInTheatre;
    TextView tvDescription;
    RatingBar tvRating;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvTitle = findViewById(R.id.textViewTitle);
        tvDate = findViewById(R.id.textViewDate);
        tvYear = findViewById(R.id.textViewYear);
        tvInTheatre = findViewById(R.id.textViewInTheatre);
        tvDescription = findViewById(R.id.textViewDescription);
        Imgrated = findViewById(R.id.imageViewMovie);



        Intent intentReceived = getIntent();
        String Title = intentReceived.getStringExtra("Title");
        String Date = intentReceived.getStringExtra("Date");
        String Year = intentReceived.getStringExtra("Year");
        String genre = intentReceived.getStringExtra("genre");
        String inTheatre = intentReceived.getStringExtra("inTheatre");
        String description = intentReceived.getStringExtra("description");

        String rated = intentReceived.getStringExtra("rated");

        if (rated.equals("g")){
            Imgrated.setImageResource(R.drawable.rating_g);
        }
        else if (rated.equals("pg")){
            Imgrated.setImageResource(R.drawable.rating_pg);

        }

        else if (rated.equals("pg13")){
            Imgrated.setImageResource(R.drawable.rating_pg13);

        }

        else  if (rated.equals("nc16")){
            Imgrated.setImageResource(R.drawable.rating_nc16);

        }

        else if (rated.equals("m18")){
            Imgrated.setImageResource(R.drawable.rating_m18);

        }

        else{
            Imgrated.setImageResource(R.drawable.rating_r21);

        }
        tvTitle.setText(Title);
        tvDate.setText("Watch On: "+Date);
        tvYear.setText(Year + " - " + genre);
        tvInTheatre.setText("In Theat: "+inTheatre);
        tvDescription.setText(description);




    }
}

