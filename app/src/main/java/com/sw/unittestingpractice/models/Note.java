package com.sw.unittestingpractice.models;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")
public class Note implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "content")
    private String content;
    @ColumnInfo(name = "timestimp")
    private String timestimp;


    public Note(@NonNull String title, String content, String timestimp) {
        this.title = title;
        this.content = content;
        this.timestimp = timestimp;
    }

    @Ignore
    public Note(int id, @NonNull String title, String content, String timestimp) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.timestimp = timestimp;
    }

    public Note() {
    }

    public Note(Note note) {
        id = note.id;
        title = note.title;
        content = note.content;
        timestimp = note.timestimp;

    }

    protected Note(Parcel in) {
        id = in.readInt();
        title = in.readString();
        content = in.readString();
        timestimp = in.readString();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimestimp() {
        return timestimp;
    }

    public void setTimestimp(String timestimp) {
        this.timestimp = timestimp;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", timestimp='" + timestimp + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeString(content);
        parcel.writeString(timestimp);
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Note note = (Note) obj;
        return note.getId() == getId()
                && note.getTitle().equals(getTitle())
                && note.getContent().equals(getContent())
                && note.getTimestimp().equals(getTimestimp());
    }
}
