package edu.orangecoastcollege.cs273.petprotector;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

import java.util.ArrayList;

/**
 * @author Phillip Davis
 * @version 1.0
 *
 * Created by Phil on 10/27/2017.
 *
 * Creates the SQLite database for the pet class. Stores the pets id, details, image name, name, and
 * phone. This class also provides methods to delete, print, and add to the database.
 */
class DBHelper extends SQLiteOpenHelper {

    static final String DATABASE_NAME = "PetProtector";
    private static final String DATABASE_TABLE = "Pets";
    private static final int DATABASE_VERSION = 1;

    private static final String KEY_FIELD_ID = "id";
    private static final String FIELD_DETAILS = "details";
    private static final String FIELD_IMAGE_NAME = "image";
    private static final String FIELD_NAME = "name";
    private static final String FIELD_PHONE = "phone";

    /**
     * Overloaded constructor of the DBHelper
     * @param context The abstract class of DBHelper.
     */
    public DBHelper(Context context ) {super (context, DATABASE_NAME, null, DATABASE_VERSION);}

    /**
     * Creates a database of pets by using: id, details, image name, name, and a phone.
     * @param database The database to be created.
     */
    @Override
    public void onCreate(SQLiteDatabase database) {
        String table = "CREATE TABLE " + DATABASE_TABLE + " ("
                + KEY_FIELD_ID + " INTEGER PRIMARY KEY, "
                + FIELD_DETAILS + " TEXT, "
                + FIELD_IMAGE_NAME + " TEXT, "
                + FIELD_NAME + " TEXT, "
                + FIELD_PHONE + " TEXT " + ")";
        database.execSQL(table);
    }

    /**
     * Upgrades the database.
     * @param database The new database.
     * @param oldVersion The older database version.
     * @param newVersion The new database version.
     */
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion){
        database.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);

        onCreate(database);
    }

    /**
     * Adds a new pet object to the database.
     * @param newPet The new pet
     */
    public void addPet(Pet newPet){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        /*
        Uri petUri = newPet.getImageUri();
        String petUriStr = petUri.toString();
        petUriStr;
        */

        values.put(FIELD_DETAILS, newPet.getDetails());
        values.put(FIELD_IMAGE_NAME, newPet.getImageUri().toString());
        values.put(FIELD_NAME, newPet.getName());
        values.put(FIELD_PHONE, newPet.getPhone());

        long id = db.insert(DATABASE_TABLE, null, values);
        newPet.setId(id);

        db.close();
    }

    /**
     * Puts all the pet objects in a pet list that are in the database and then returns the list.
     * @return The pet list.
     */
    public ArrayList<Pet> getAllPets(){
        ArrayList<Pet> petList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                DATABASE_TABLE,
                new String[]{KEY_FIELD_ID,
                        FIELD_DETAILS,
                        FIELD_IMAGE_NAME,
                        FIELD_NAME,
                        FIELD_PHONE},
                null, null, null, null, null);

        if(cursor.moveToFirst()){
            do {
                Pet pet = new Pet(
                        cursor.getInt(0),
                        cursor.getString(1),
                        Uri.parse(cursor.getString(2)),
                        cursor.getString(3),
                        cursor.getString(4));

                petList.add(pet);
            } while(cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return petList;
    }


}
