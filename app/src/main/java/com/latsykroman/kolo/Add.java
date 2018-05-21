package com.latsykroman.kolo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Add extends AppCompatActivity{

    private FirebaseDatabase database;
    private DatabaseReference reference;


    TextView text_name, text_client,  text_kilki, text_author;
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        add = (Button) findViewById(R.id.button2);
        text_name = (TextView) findViewById(R.id.name);
        text_client = (TextView) findViewById(R.id.zamov_name);
        text_kilki = (TextView) findViewById(R.id.editText);
        text_author = (TextView) findViewById(R.id.editText3);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("archive");


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                adduser();

            }
        });
    }



    public void adduser(){
        String name = text_name.getText().toString();
        String client = text_client.getText().toString();
        String key = reference.push().getKey();
        String author = text_author.getText().toString();
        int kilkist =  Integer.valueOf(text_kilki.getText().toString());
        UserModel newUser = new UserModel(""+name, ""+key,  kilkist, ""+client, author);
        Map<String, Object> userValues = newUser.toMap();
        Map<String, Object> user = new HashMap<>();
        user.put(key ,userValues);
        reference.updateChildren(user);
        Toast.makeText(Add.this, "Книгу додано, поверніться назад, щоб переглянути список", Toast.LENGTH_LONG).show();
    }


}
