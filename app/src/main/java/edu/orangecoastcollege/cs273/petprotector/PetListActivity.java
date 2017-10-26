package edu.orangecoastcollege.cs273.petprotector;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * The controller - Starts the pet activity. Loads pets that need to be protected.
 */
public class PetListActivity extends AppCompatActivity {

    private ImageView petImageView;
    private Uri imageUri;

    // Constants for permissions;
    private static final int GRANTED = PackageManager.PERMISSION_GRANTED;
    private static final int DENIED = PackageManager.PERMISSION_DENIED;

    /**
     * Creates the activity that will be displayed. Will show any pets that need to be protected.
     * @param savedInstanceState Loads a saved instance if there are any.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_list);

        petImageView = (ImageView) findViewById(R.id.petImageView);
        petImageView.setImageURI(getUriFromResource(this, R.drawable.none));
    }

    /**
     * Selects permissions that will prompt the user.
     * @param v ImageView button click
     */
    public void selectPetImage(View v){
        List<String> permslist = new ArrayList<>();

        // Check each permission individually
        int hasCameraPerm = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        if (hasCameraPerm == DENIED)
            permslist.add(Manifest.permission.CAMERA);

        int readStoragePerm = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (readStoragePerm == DENIED)
            permslist.add(Manifest.permission.READ_EXTERNAL_STORAGE);

        int writeStoragePerm = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (writeStoragePerm == DENIED)
            permslist.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);

        // Some of the permissions have not been granted
        if (permslist.size() > 0){
            // Convert the permsList into an array:
            String[] permsArray = new String[permslist.size()]; // ensure the sizes are the same
            permslist.toArray(permsArray);

            // Ask user for them:
            ActivityCompat.requestPermissions(this, permsArray, 1337);
        }

        // Let's make sure we have all the permissions, then start the Image Gallery:
        if (hasCameraPerm == GRANTED && readStoragePerm == GRANTED && writeStoragePerm == GRANTED){
            // Let's open up the image gallery
            Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            // Star the activity for a result (picture)
            startActivityForResult(galleryIntent, 1);
        }
    }

    /**
     * Loads the image from the gallery.
     * @param requestCode The image from the gallery.
     * @param resultCode If permission was granted
     * @param data Checks if there is content to be displayed.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null){
            // data = data from GalleryIntent (The URI of sme image)
            imageUri = data.getData();
            petImageView.setImageURI(imageUri);
        }

    }

    /**
     * gets a image from the URI string
     * @param context Any activity passed
     * @param resId ID of the resources
     * @return A concatenated URI string of package + typename + entryname
     */
    public static Uri getUriFromResource(Context context, int resId){
        Resources res = context.getResources();
        // Build a String in the form:
        // android.resources://edu.orangecoastcollege.cs273.petprotector/drawable/none
        String uri = ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                + res.getResourcePackageName(resId) + "/"
                + res.getResourceTypeName(resId) + "/"
                + res.getResourceEntryName(resId);

        // Parse the String in order to  construct a URI
        return Uri.parse(uri);
    }
}
