package com.example.javatry;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView r;
    MyAdapter m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r = findViewById(R.id.userRecyclerView);
        r.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        // Create an instance of the Room database
        AppDatabase db = Room.databaseBuilder(this, AppDatabase.class, "user-db").build();

        // Create a new user and insert it into the database
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                UserDao dao = db.userDao();
                dao.deleteAll();
                User user = new User();
                user.setAge(30);
                user.setName("alok");
                dao.insert(user);

                for(int i =0;i<10;i++){
                    User u = new User();
                    user.setAge(i);
                    user.setName("user"+Integer.valueOf(i).toString());
                    dao.insert(user);
                }
                // Retrieve all users from the database
                List<User> users = dao.getAllUsers();
                m = new MyAdapter(users);

                r.setAdapter(m);

                // Log the information of retrieved users

            }
        });

        thread.start();
    }
}
