package com.example.minhh.ideo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.Toast;

import com.example.minhh.ideo.Fragments.IntroFragment;
import com.example.minhh.ideo.Helper.InitializeListClip;
import com.example.minhh.ideo.Helper.ListHome;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.zip.Inflater;

public class Home extends AppCompatActivity {
    /*
        This class grid view detail of one animals.
         */
//    GridView gv;
    ListView lvdata;
    public static ArrayList<String> imgPath = new ArrayList<String>();
    public static ArrayList<Drawable> imgDrawable = new ArrayList<Drawable>();
    public static String[] prgmNameList = {"Sơ lược về ứng dụng", "Tra cứu từ vựng", "Học từ vựng theo câu", "Trắc nghiệm từ vựng", "Thoát"};

    DrawerLayout _drawerLayout;
    Toolbar _toolbar;
    NavigationView _nvDrawer;

    public static int[] prgmImages = {R.drawable.ic_intro_item, R.drawable.ic_research_item,
            R.drawable.ic_learning_item, R.drawable.ic_testing_item, R.drawable.ic_exit_item};

    public void setFragment(int position) {
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        switch (position) {
            case 0:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();

                IntroFragment introFragment = new IntroFragment();
                fragmentTransaction.replace(R.id.fragment, introFragment);
                fragmentTransaction.commit();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        InitializeListClip generateClip = new InitializeListClip();

        lvdata = (ListView) findViewById(R.id.lvData);
        ListHome adapter = new ListHome(this, prgmNameList, prgmImages);
        lvdata.setAdapter(adapter);
        lvdata.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        _drawerLayout.closeDrawer(GravityCompat.START);
                        TableLayout introFrag = (TableLayout) view.findViewById(R.id.list_view_layout);
                        introFrag.setBackgroundColor(Color.parseColor("#cc7e00"));
                        setFragment(0);
                        break;
                    case 1:
                        _drawerLayout.closeDrawer(GravityCompat.START);
                        Intent dictionaryActivity = new Intent(Home.this, Dictionary.class);
                        startActivity(dictionaryActivity);
                        break;
                    case 2:
                        android.app.AlertDialog.Builder builderNontify = new android.app.AlertDialog.Builder(Home.this);
                        builderNontify
                                .setTitle("Chức năng không khả dụng")
                                .setMessage("Chức năng hiện chưa cập nhật, vui lòng đợi phiên bản sau")
                                .setIcon(R.drawable.ic_alert_fix)
                                .setPositiveButton("OK", new  DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        android.app.AlertDialog alertNontify = builderNontify.create();
                        alertNontify.show();

                        break;
                    case 3:
                        _drawerLayout.closeDrawer(GravityCompat.START);
                        Intent testingActivity = new Intent(Home.this, Testing.class);
                        startActivity(testingActivity);
                        break;
                    case 4:
                        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(Home.this);
                        builder
                                .setTitle("Thoát ứng dụng")
                                .setMessage("Bạn có chắc không?")
                                .setIcon(R.drawable.ic_alert_fix)
                                .setPositiveButton("Có, tôi muốn thoát", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        System.exit(0);
                                    }
                                });
                        builder.setNegativeButton("Không, để sau", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        android.app.AlertDialog alert = builder.create();
                        alert.show();
                        break;
                }
            }
        });

        _toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(_toolbar);

        _nvDrawer = (NavigationView) findViewById(R.id.navigation_view);
        _nvDrawer.setItemIconTintList(null);//icon not fill
        _nvDrawer.setVerticalScrollBarEnabled(true);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        _drawerLayout = (DrawerLayout) findViewById(R.id.navigation_drawer_layout);

        setFragment(0);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.exit(0);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        _drawerLayout.openDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK: {
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(Home.this);
                builder
                        .setTitle("Thoát ứng dụng")
                        .setMessage("Bạn có chắc không?")
                        .setIcon(R.drawable.ic_alert_fix)
                        .setPositiveButton("Có, tôi muốn thoát", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                System.exit(0);
                            }
                        });
                builder.setNegativeButton("Không, để sau", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                android.app.AlertDialog alert = builder.create();
                alert.show();
                //your Action code
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
