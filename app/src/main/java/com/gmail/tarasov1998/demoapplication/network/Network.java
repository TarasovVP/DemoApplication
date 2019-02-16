package com.gmail.tarasov1998.demoapplication.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Network {
    private static final String USERS = "http://jsonplaceholder.typicode.com/users";
    private static final String AVATARS = "https://avatars.io/twitter/";

    private String httpgetJson() {
        HttpURLConnection con = null;
        StringBuffer buffer = null;
        try {
            con = (HttpURLConnection) (new URL(USERS)).openConnection();
            con.connect();

            try (InputStream is = con.getInputStream()) {
                buffer = new StringBuffer();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line;
                while ((line = br.readLine()) != null)
                    buffer.append(line).append("\r\n");


            } catch (Throwable t) {
                t.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }

        return buffer != null ? buffer.toString() : null;

    }
    public String getUsers() {
        return httpgetJson();
    }

    public String getAvatars(Integer id) {
        return AVATARS + id;
    }

}
