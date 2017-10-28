package edu.orangecoastcollege.cs273.petprotector;

import android.net.Uri;

/**
 * @author Phillip Davis
 * @version 1.0
 *
 * Created by Phil on 10/27/2017.
 *
 * The model, creates a pet object with types mId, mDetails, mImageUri, mName, and mPhone. Provides
 * getter and setters for the data types and two constructors.
 */
public class Pet {
    private int mId;
    private String mDetails;
    private Uri mImageUri;
    private String mName;
    private String mPhone;

    public Pet(int id, String details, Uri imageUri, String name, String phone) {
        mId = id;
        mDetails = details;
        mImageUri = imageUri;
        mName = name;
        mPhone = phone;
    }

    public Pet(String details, Uri imageUri, String name, String phone) {
        mDetails = details;
        mImageUri = imageUri;
        mName = name;
        mPhone = phone;
    }

    public String getDetails() {
        return mDetails;
    }

    public void setDetails(String details) {
        mDetails = details;
    }

    public int getId() {
        return mId;
    }

    public Uri getImageUri() {
        return mImageUri;
    }

    public void setImageUri(Uri imageUri) {
        mImageUri = imageUri;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "mDetails='" + mDetails + '\'' +
                ", mId=" + mId +
                ", mImageUri='" + mImageUri + '\'' +
                ", mName='" + mName + '\'' +
                ", mPhone=" + mPhone +
                '}';
    }
}
