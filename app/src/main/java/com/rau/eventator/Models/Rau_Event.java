package com.rau.eventator.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Yur on 13.10.2016.
 */

public class Rau_Event implements Parcelable{
    private String mName;
    private String mDate;
    private String mPlace;
    private String mType;
    private String mImageUrl;
    private String mDesc;
    private Boolean isImportant;

    public Rau_Event() {
    }

    public Rau_Event(String name, String date, String place, String type,String imageUrl,String desc,Boolean isImportant) {
        this.mName = name;
        this.mDate = date;
        this.mPlace = place;
        this.mType = type;
        this.mDesc=desc;
        this.mImageUrl=imageUrl;
        this.isImportant=isImportant;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public String getPlace() {
        return mPlace;
    }

    public void setPlace(String place) {
        mPlace = place;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public String getDesc() {
        return mDesc;
    }

    public void setDesc(String desc) {
        mDesc = desc;
    }

    public Boolean getImportant() {
        return isImportant;
    }

    public void setImportant(Boolean important) {
        isImportant = important;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
    parcel.writeString(mName);
    parcel.writeString(mDate);
    parcel.writeString(mPlace);
    parcel.writeString(mType);
    parcel.writeString(mImageUrl);
    parcel.writeString(mDesc);
    parcel.writeInt( isImportant?1:0);
    }
    public static final Parcelable.Creator<Rau_Event> CREATOR = new Parcelable.Creator<Rau_Event>() {

        public Rau_Event createFromParcel(Parcel in) {
            return new Rau_Event(in);
        }

        public Rau_Event[] newArray(int size) {
            return new Rau_Event[size];
        }
    };


    private Rau_Event(Parcel parcel) {

        mName = parcel.readString();
        mDate = parcel.readString();
        mPlace = parcel.readString();
        mType = parcel.readString();
        mImageUrl = parcel.readString();
        mDesc = parcel.readString();
        isImportant=(parcel.readInt()==0)?false:true;

    }
}
