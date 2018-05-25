package com.bitp3453.project_mobile;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Password extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    EditText e1;
    FirebaseAuth auth;
    ProgressDialog dialog;

    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dialog = new ProgressDialog(this);
        e1 = (EditText) findViewById(R.id.editPass);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.view_image, menu);
        return true;
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id=item.getItemId();
        switch (id){

            case R.id.nav_view_image:
                Intent h= new Intent(Password.this,ViewImage.class);
                startActivity(h);
                break;
            case R.id.nav_upload_image:
                Intent i= new Intent(Password.this,UploadImage.class);
                startActivity(i);
                break;

            case R.id.nav_delete:
                Intent s= new Intent(Password.this,DeleteImage.class);
                startActivity(s);
                break;
            case R.id.nav_password:
                Intent l= new Intent(Password.this,Password.class);
                startActivity(l);
                break;
            case R.id.nav_photo:
                Intent k= new Intent(Password.this,Photo.class);
                startActivity(k);
                break;
            case R.id.nav_logout:
                auth.signOut();
                finish();
                Intent n= new Intent(Password.this,MainActivity.class);
                startActivity(n);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void change(View v)
    {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user !=null)
        {
            dialog.setMessage("Changing password, please wait!!!");
            dialog.show();
            user.updatePassword(e1.getText().toString())
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful())
                            {
                                dialog.dismiss();
                                auth.signOut();
                                finish();
                                Intent i = new Intent (Password.this, MainActivity.class);
                                startActivity(i);

                                Toast.makeText(getApplicationContext(),"Your password has been update",Toast.LENGTH_LONG);
                            }
                            else
                            {
                                dialog.dismiss();
                                Toast.makeText(getApplicationContext(), "Update pass fail",Toast.LENGTH_SHORT);
                            }

                        }
                    });
        }
    }

    public void signOut(View v) {
        auth.signOut();
        finish();
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
