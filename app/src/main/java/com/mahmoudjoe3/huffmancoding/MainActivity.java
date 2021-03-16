package com.mahmoudjoe3.huffmancoding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "huffmanEncoder";
    EditText wordTXT,codeTXT;
    Button convertToCodeBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wordTXT=findViewById(R.id.word);
        codeTXT=findViewById(R.id.code);
        convertToCodeBtn=findViewById(R.id.convert);
        convertToCodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String word=wordTXT.getText().toString();
                codeTXT.setText(Huffman.encode(word));
                try {
                    byte[] bytes=word.getBytes("UTF-8");
                    byte[] bytes1=codeTXT.getText().toString().getBytes("UTF-8");
                    Log.d(TAG, "onClick: the word "+word+" size = "+bytes.length+" the code size = "+bytes1.length);

                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}