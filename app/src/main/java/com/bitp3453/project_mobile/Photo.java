package com.bitp3453.project_mobile;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
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
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Photo extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FirebaseAuth auth;
    FirebaseUser user;

    public Button mButtonMain,mButtonMain2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        mButtonMain = findViewById(R.id.button4);

        mButtonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toMainPage();

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

/*        Bitmap bp = (Bitmap) data.getExtras().get("data");
        ImageView iv = (ImageView)findViewById(R.id.imageView);
        iv.setImageBitmap(bp);*/

        Intent intent2 = new Intent(Photo.this, UploadImage.class);
        startActivity(intent2);
    }

    private void toMainPage()
    {
        Runnable run = new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void run() {

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE_SECURE);
                startActivityForResult(intent,0);

            }
        };

        Thread thr = new Thread(run);
        thr.start();
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
                Intent h= new Intent(Photo.this,ViewImage.class);
                startActivity(h);
                break;
            case R.id.nav_upload_image:
                Intent i= new Intent(Photo.this,UploadImage.class);
                startActivity(i);
                break;

            case R.id.nav_delete:
                Intent s= new Intent(Photo.this,DeleteImage.class);
                startActivity(s);
                break;
            case R.id.nav_password:
                Intent l= new Intent(Photo.this,Password.class);
                startActivity(l);
                break;
            case R.id.nav_photo:
                Intent k= new Intent(Photo.this,Photo.class);
                startActivity(k);
                break;
            case R.id.nav_logout:

                Intent n= new Intent(Photo.this,MainActivity.class);
                startActivity(n);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void signOut(View v) {
        auth.signOut();
        finish();
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
