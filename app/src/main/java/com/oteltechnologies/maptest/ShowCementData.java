package com.oteltechnologies.maptest;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Qvertz on 2/13/2017.
 */
public class ShowCementData implements Parcelable{
    public String name;
    private String  price;
    private int thumbnail;


    public ShowCementData() {
    }

    public ShowCementData(String name, String price, int thumbnail) {
        this.name = name;
        this.price = price;
        this.thumbnail = thumbnail;
    }

    protected ShowCementData(Parcel in) {
        name = in.readString();
        price = in.readString();
        thumbnail = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(price);
        dest.writeInt(thumbnail);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ShowCementData> CREATOR = new Creator<ShowCementData>() {
        @Override
        public ShowCementData createFromParcel(Parcel in) {
            return new ShowCementData(in);
        }

        @Override
        public ShowCementData[] newArray(int size) {
            return new ShowCementData[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

}
