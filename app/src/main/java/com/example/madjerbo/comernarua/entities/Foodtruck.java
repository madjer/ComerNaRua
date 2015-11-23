package com.example.madjerbo.comernarua.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class Foodtruck implements Parcelable {
    public String id;
    public String nome;
    public String descricao;
    public String logo_thumb;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(id);
        parcel.writeString(nome);
        parcel.writeString(descricao);
        parcel.writeString(logo_thumb);
    }
}
