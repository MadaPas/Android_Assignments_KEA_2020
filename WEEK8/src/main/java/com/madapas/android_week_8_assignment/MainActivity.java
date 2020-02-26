package com.madapas.android_week_8_assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.madapas.android_week_8_assignment.model.Note;
import com.madapas.android_week_8_assignment.model.NoteDao;
import com.madapas.android_week_8_assignment.model.NoteDatabase;
import com.madapas.android_week_8_assignment.adapter.NoteAdapter;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    RecyclerView notesList;
    NoteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NoteDao dao = NoteDatabase.getDb(getApplicationContext()).noteDao();

        final List<Note> notes = dao.getAll();

        notesList = findViewById(R.id.notesList);
        notesList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NoteAdapter(notes);
        notesList.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.note_list_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    protected void onResume() {
        super.onResume();

        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        NoteDatabase.destroyInstance();
    }

    public void newNote(MenuItem menuItem) {

        startActivity(new Intent(this, EditActivity.class));
    }
}
