package com.example.safety_qr.domain;

public class History {

    public int id;
    public String url;
    public String result;

    public History(String url, String result){
        this.url = url;
        this.result = result;
    }
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}

