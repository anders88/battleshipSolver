package no.something.ftas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;



public class BattleshipSolver {

    private static final String BASE_URL="http://localhost:8081/";
	private static final String PLAYER_ID="0114231";

	public static void main(String[] args) throws Exception {
        String res = httpPost(BASE_URL + "game/shoot/" + PLAYER_ID, "[[0,0],[1,0]]");
        System.out.println(res);
    }



    private static String httpPost(String url, String answer) throws Exception {
        URLConnection conn = new URL(url).openConnection();
        conn.setDoOutput(true);
        try (PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(),"utf-8"))) {
            printWriter.append(answer);
        }
        return toString(conn.getInputStream());
    }

    private static String toString(InputStream inputStream) throws IOException {
        try (Reader reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"))) {
            StringBuilder result = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                result.append((char)c);
            }
            return result.toString();
        }
    }
}
