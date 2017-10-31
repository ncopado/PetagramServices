package com.ncopado.petagram.restApi.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ncopado on 16/10/17.
 */

public class ResponseLike {


    @SerializedName("data")
    public String data;

    @SerializedName("meta")
    public  Code message;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Code getMessage() {
        return message;
    }

    public void setMessage(Code message) {
        this.message = message;
    }
}


class  Code{

    public  String CodeM;

    public String getCodeM() {
        return CodeM;
    }

    public void setCodeM(String codeM) {
        CodeM = codeM;
    }
}


