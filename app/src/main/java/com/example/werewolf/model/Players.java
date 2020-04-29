package com.example.werewolf.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class Players implements Parcelable {
    public String pname;
    private Uri pimg;

    public Players() {
    }

    public Players(String pname, Uri pimg) {
        this.pname = pname;
        this.pimg = pimg;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Uri getPimg() {
        return pimg;
    }

    public void setPimg(Uri pimg) {
        this.pimg = pimg;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.pimg, flags);
        dest.writeString(this.pname);
    }

    protected Players(Parcel in) {
        this.pimg = in.readParcelable(Uri.class.getClassLoader());
        this.pname = in.readString();
    }

    public static final Parcelable.Creator<Players> CREATOR = new Parcelable.Creator<Players>() {
        @Override
        public Players createFromParcel(Parcel source) {
            return new Players(source);
        }

        @Override
        public Players[] newArray(int size) {
            return new Players[size];
        }
    };
}
