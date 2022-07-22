package com.example.adminquotesapp.Models;

public class Upload
{
    String mName;
    String mImageUrl;
    String mKey;

    public Upload()
    {
    }

    public Upload(String name, String imageUrl)
    {
        if (name.trim().equals(""))
        {
            name = "No Name";
        }

        mName = name;
        mImageUrl = imageUrl;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public String getmKey() {
        return mKey;
    }

    public void setmKey(String mKey) {
        this.mKey = mKey;
    }
}
