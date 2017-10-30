package edu.orangecoastcollege.cs273.petprotector;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class PetDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_details);

        TextView petDetailsNameTextView = (TextView) findViewById(R.id.petDetailsNameTextView);
        ImageView petDetailsImageUri = (ImageView) findViewById(R.id.petDetailsImageView);
        TextView petDetailsDescriptionTextView = (TextView) findViewById(R.id.petDetailsDescriptionTextView);
        TextView petDetailsPhoneTextView = (TextView) findViewById(R.id.petDetailsPhoneTextView);

        Intent detailsIntent = getIntent();

        petDetailsNameTextView.setText(detailsIntent.getStringExtra("Name"));
        petDetailsImageUri.setImageURI(Uri.parse(detailsIntent.getStringExtra("Pic")));
        petDetailsDescriptionTextView.setText(detailsIntent.getStringExtra("Description"));
        petDetailsPhoneTextView.setText(detailsIntent.getStringExtra("Phone"));
    }
}
