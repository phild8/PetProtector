package edu.orangecoastcollege.cs273.petprotector;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

    /**
     * Created by Phil on 10/28/2017.
     *
     * Helper class that provides a new adapter for the PetListActivity class.
     */
    public class PetListAdapter extends ArrayAdapter<Pet> {

        private Context mContext;
        private List<Pet> mPetList = new ArrayList<>();
    private int mResourceId;

    private LinearLayout linLay;

    /**
     * Creates a new list adapter
     * @param c The context from the activity.
     * @param rId The Id of the of the file name.
     * @param pets The list of pets to be displayed.
     */
    public PetListAdapter(Context c, int rId, List<Pet> pets){
        super(c, rId, pets);
        mContext = c;
        mResourceId = rId;
        mPetList = pets;
    }

    /**
     * Gets the views that are associated with the view adapter
     * @param pos The position of the button item clicked inside of the list.
     * @param convertView @nullable
     * @param parent @nullable
     * @return The current views that where selected from the adapter.
     */
    @NonNull
    @Override
    public View getView(int pos, @Nullable View convertView, @NonNull ViewGroup parent){

        final Pet petSelect = mPetList.get(pos);

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(mResourceId, null);

        linLay = view.findViewById(R.id.petListLinearLayout);

        TextView nameTextView = linLay.findViewById(R.id.nameAdapterTextView);
        TextView detailsTextVIew = linLay.findViewById(R.id.detailsAdapterTextView);
        ImageView petImageView = linLay.findViewById(R.id.petAdapterImageView);


        petImageView.setImageURI(petSelect.getImageUri());
        nameTextView.setText(petSelect.getName());
        detailsTextVIew.setText(petSelect.getDetails());

        linLay.setTag(petSelect);

        return view;
    }
}
