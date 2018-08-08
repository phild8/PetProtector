package edu.orangecoastcollege.cs273.petprotector;

import android.net.Uri;

/**
 * @author Phillip Davis
 * @version 1.0
 *
 * Created by Phil on 10/27/2017.
 *
 * The model, creates a pet object with types mId, mDetails, mImageUri, mName, and mPhone. Provides
 * getter and setters for the data types and t       wo constructors.
 */
public class Pet {
    private long mId;
    private String mDetails;
    private Uri mImageUri;
    private String mName;
    private String mPhone;

    /**
     * Constructors the pet class with all data types
     * @param id The pets unique ID.
     * @param details The details for the pet to be adopted.
     * @param imageUri A picture of the pet to be adopted.
     * @param name The name of the pet to be adopted.
     * @param phone The phone number of the adoption agency.
     */
    public Pet(long id, String details, Uri imageUri, String name, String phone) {
        mId = id;
        mDetails = details;
        mImageUri = imageUri;
        mName = name;
        mPhone = phone;
    }

    /**
     * Overloaded constructor of the pet class. Does not provide an ID
     * @param details Details of the pet to be adopted.
     * @param imageUri The picture of the pet adopted to be adopted.
     * @param name The name of the pet to be adopted.
     * @param phone The phone number of the adoption agency.
     */
    public Pet(String details, Uri imageUri, String name, String phone) {
        mDetails = details;
        mImageUri = imageUri;
        mName = name;
        mPhone = phone;
    }

    /**
     * Gets the pets details.
     * @return mDetails
     */
    public String getDetails() {
        return mDetails;
    }

    /**
     * Sets the pets details.
     * @param details The pets new details.
     */
    public void setDetails(String details) {
        mDetails = details;
    }

    /**
     * Gets the pets ID.
     * @return mId
     */
    public long getId() {
        return mId;
    }

    /**
     * Sets the pet's ID.
     * @param id The new ID.
     */
    public void setId(long id) {
        mId = id;
    }

    /**
     * Gets the mImageUri of the pet.
     * @return mImageUri
     */
    public Uri getImageUri() {
        return mImageUri;
    }

    /**
     * Sets a new image URI of the pet.
     * @param imageUri The new image URI.
     */
    public void setImageUri(Uri imageUri) {
        mImageUri = imageUri;
    }

    /**
     * Gets the pets name.
     * @return mName
     */
    public String getName() {
        return mName;
    }

    /**
     * Sets a new name for the pet.
     * @param name The pets new name.
     */
    public void setName(String name) {
        mName = name;
    }

    /**
     * Gets the phone number of the adoption agency.
     * @return mPhone
     */
    public String getPhone() {
        return mPhone;
    }

    /**
     * Sets the phone number of the adoption agency.
     * @param phone The new phone phone number.
     */
    public void setPhone(String phone) {
        mPhone = phone;
    }

    /**
     * Turns the pet object into string format with the data types: mId, mDetails, mImageUri, mName,
     * and mPhone.
     * @return The object in string form.
     */
    @Override
    public String toString() {
        return "Pet{" +
                "mId=" + mId +
                ", mDetails='" + mDetails + '\'' +
                ", mImageUri=" + mImageUri +
                ", mName='" + mName + '\'' +
                ", mPhone='" + mPhone + '\'' +
                '}';
    }
}
