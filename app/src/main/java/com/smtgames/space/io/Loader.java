package com.smtgames.space.io;

import android.content.res.AssetManager;

import com.smtgames.space.engine.MainSurfaceView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Loader {

    public static String loadString(String path) {
        AssetManager am = MainSurfaceView.getAssetManager();

        try {
            InputStream input = am.open(path);
            InputStreamReader reader = new InputStreamReader(input);
            BufferedReader bufferedReader = new BufferedReader(reader);

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }

            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
