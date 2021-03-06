package com.codefororlando.petadoption.data.impl;

import android.net.Uri;
import android.os.Parcel;
import android.support.annotation.NonNull;

import com.codefororlando.petadoption.data.IAnimal;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Animal implements IAnimal {

    // Properties

    @NonNull
    private final Uri uri;

    @NonNull
    @SerializedName("petId")
    String id;

    @NonNull
    @SerializedName("petName")
    private String name;

    @NonNull
    private
    @Gender
    String gender;

    @NonNull
    private String species;

    @NonNull
    private String breed;

    @NonNull
    private String age;

    @SerializedName("adoptable")
    private boolean isAdoptable;

    private boolean shouldActQuickly;

    @NonNull
    private String color;

    @NonNull
    private String description;

    @NonNull
    private String activityLevel;

    @NonNull
    private String intakeDate;

    @NonNull
    private String shelterId;

    List<String> images;

    // Constructors
    public Animal(@NonNull Uri uri, @NonNull String name, @NonNull @Gender String gender,
                  @NonNull String species, @NonNull String breed) {
        this.uri = uri;
        this.name = name;
        this.gender = gender;
        this.species = species;
        this.breed = breed;
        images = new ArrayList<>();
    }

    public Animal(@NonNull Uri uri) {
        this.uri = uri;
    }

    protected Animal(Parcel in) {
        uri = in.readParcelable(Uri.class.getClassLoader());
    }

    // IRetrievable Implementation
    public static final Creator<Animal> CREATOR = new Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(uri, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    @NonNull
    public Uri getUri() {
        return uri;
    }

    @Override
    @NonNull
    public String getTag() {
        return id;//uri.toString();
    }

    // IAnimal Implementation

    @NonNull
    @Override
    public String getId() {
        return id;
    }

    @NonNull
    @Override
    public String getName() {
        return name;
    }

    @NonNull
    @Override
    public String getSpecies() {
        return species;
    }

    @NonNull
    @Override
    public String getBreed() {
        return breed;
    }

    @NonNull
    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public String getAge() {
        return age;
    }

    @Override
    public boolean isAdoptable() {
        return isAdoptable;
    }

    @Override
    public boolean shouldActQuickly() {
        return shouldActQuickly;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getActivityLevel() {
        return activityLevel;
    }

    @Override
    public String getIntakeDate() {
        return intakeDate;
    }

    @Override
    public String getShelterId() {
        return shelterId;
    }

    public List<String> getImages() {
        //HACK
//        ArrayList<String> placeholder = new ArrayList<String>() {{
//            add("http://placekitten.com/g/200/300");
//        }};
//        return placeholder;
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}