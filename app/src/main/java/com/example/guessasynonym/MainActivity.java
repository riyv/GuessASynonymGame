package com.example.guessasynonym;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private RequestQueue queue;
    private String urlFormat = "https://wordsapiv1.p.rapidapi.com/words/%s/synonyms";

    private EditText input;
    private EditText inputAnswer;
    private TextView synonym1;
    private TextView synonym2;
    private TextView synonym3;
    private TextView status;
    private Button getSynonyms;
    private Button check;

    private String synWord1;
    private String synWord2;
    private String synWord3;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = findViewById(R.id.input_word);
        inputAnswer = findViewById(R.id.input_answer);
        getSynonyms = findViewById(R.id.get_synonyms);
        check = findViewById(R.id.check);
        synonym1 = findViewById(R.id.synonym1);
        synonym2 = findViewById(R.id.synonym2);
        synonym3 = findViewById(R.id.synonym3);
        status = findViewById(R.id.status);


        final RequestQueue queue = Volley.newRequestQueue(this);
        getSynonyms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = String.format(urlFormat, input.getText().toString());
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject jObject;
                        JSONArray jArray;
                        int jArrayLen = 0;
                        try {
                            jObject = new JSONObject(response);
                            jArray = jObject.getJSONArray("synonyms");
                            jArrayLen = jArray.length();

                            if (jArrayLen > 0) {
                                synWord1 = jArray.getString(0);
                                //hide word
                                synonym1.setText(hide(synWord1));

                            }
                            if (jArrayLen > 1) {
                                synWord2 = jArray.getString(1);
                                //hide word
                                synonym2.setText(hide(synWord2));
                            }
                            if (jArrayLen > 2) {
                                synWord3 = jArray.getString(2);
                                //hide word
                                synonym3.setText(hide(synWord3));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            status.setText(response);
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        synonym1.setText("API call did not work");
                    }

                }
                ) {
                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        Map<String, String>  params = new HashMap<String, String>();
                        params.put("x-rapidapi-key", "0a575a6d31msh15147d1eb3ee9ccp1b49f3jsnddaffe775148");
                        return params;
                    }

                };
                queue.add(stringRequest);
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer = inputAnswer.getText().toString();
                if (answer.equals(synWord1) || answer.equals(synWord2) || answer.equals(synWord3)) {
                    status.setText("You guessed one of the synonyms!");
                } else {
                    status.setText("You didn't guess any of the synonyms :(");
                }
            }
        });

    }
    //hide function
    private static String hide(String input) {
        // replace all characters in input string with "-" except one random character
        int length = input.length();
        StringBuilder output = new StringBuilder();

        output.append(input);
        Random random = new Random();

        int newRandom = random.nextInt(length);

        for (int i = 0; i < length; i++) {
            if (i == newRandom) {
                output.setCharAt(i, '-');
                output.setCharAt(length - 1, '-');
                output.setCharAt(0, '-');

            }
        }
        return output.toString();
    }
}
