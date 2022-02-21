package com.example.sample_4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    public static final String ENCODING = "UTF-8";
    public final String EDIT_TEXT_KEY = "EDIT_TEXT";
//    private TextView tv1;
//    private TextView tv2;
//    private String fileName = "test.txt";
//    String message = "你好，这是一个关于文件I/O";
    private EditText etPre;
    private SharedPreferences sp;
    String[] columns = {
        Contacts.People._ID,
        Contacts.People.NAME,
    };
    private Uri contactUri = Contacts.People.CONTENT_URI;

    private MySQLiteHelper mMyHelper;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPre = findViewById(R.id.et);
        sp = getPreferences(MODE_PRIVATE);
        String result = sp.getString(EDIT_TEXT_KEY,null);
        if(result != null){
            etPre.setText(result);
        }
//
//        tv = findViewById(R.id.tv);
//        String result = getQueryData();
//        tv.setText("ID\t名字\n" + result);
//        mMyHelper = new MySQLiteHelper(this,"my.db",null,1);

//        insertAndUpdateData(mMyHelper);
//        String result = queryData(mMyHelper);
//        tv.setText("名字\t等级\n" + result);
//
//        tv1 = findViewById(R.id.tv1);
//        tv2 = findViewById(R.id.tv2);
//
//        tv1.setText(getFormRaw("test1.txt"));
//        tv2.setText(getFormAssets("test2.txt"));


//        writeFileData(fileName,message);
//        String result = readFileData(fileName);
//
//        tv = findViewById(R.id.tv);
//        tv.setText(result);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(EDIT_TEXT_KEY,String.valueOf(etPre.getText()));
        editor.commit();
    }

    //
//    private void writeFileData(String fileName,String message){
//        try{
//            FileOutputStream fout = openFileOutput(fileName,MODE_PRIVATE);
//            byte[] bytes = message.getBytes();
//            fout.write(bytes);
//            fout.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//    private String readFileData(String fileName){
//        String result = "";
//        try{
//            FileInputStream fin = openFileInput(fileName);
//            int length = fin.available();
//            byte[] buffer = new byte[length];
//            fin.read(buffer);
//            result = new String(buffer);
//            fin.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return result;
//    }

//    private String getFormRaw(String fileName){
//        String result = "";
//        try{
//            InputStream in = getResources().openRawResource(R.raw.test1);
//            int length = in.available();
//            byte[] buffer = new byte[length];
//            in.read(buffer);
//            result = new String(buffer,ENCODING);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    private String getFormAssets(String fileName){
//        String result = "";
//        try{
//            InputStream in = getResources().getAssets().open(fileName);
//            int length = in.available();
//            byte[] buffer = new byte[length];
//            in.read(buffer);
//            result = new String(buffer,ENCODING);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return result;
//    }

//    private void insertAndUpdateData(MySQLiteHelper myHelper){
//        SQLiteDatabase db = myHelper.getWritableDatabase();
//        db.execSQL("insert into hero_info(name,level) values('Hero1',1)");
//
//        ContentValues values = new ContentValues();
//        values.put("name","hero2");
//        values.put("level",2);
//        db.insert("hero_info","id",values);
//
//        values.clear();
//        values.put("name","hero2");
//        values.put("level",3);
//        db.update("hero_info",values,"level = 2",null);
//        db.close();
//    }

//    private String queryData(MySQLiteHelper myHelper){
//        String result = "";
//        SQLiteDatabase db = myHelper.getReadableDatabase();
//        Cursor cursor = db.query("hero_info",null,null,null,null,null,"id asc");
//        int nameIndex = cursor.getColumnIndex("name");
//        int levelIndex = cursor.getColumnIndex("level");
//
//        for (cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
//            result = result + cursor.getString(nameIndex) + "   ";
//            result = result + cursor.getInt(levelIndex) + "  \n";
//        }
//        cursor.close();
//        db.close();
//        return result;
//    }

//    private String getQueryData(){
//        String result = "";
//        ContentResolver resolver = getContentResolver();
//        Cursor cursor = resolver.query(contactUri,columns,null,null,null);
//        int idIndex = cursor.getColumnIndex(Contacts.People._ID);
//        int nameIndex = cursor.getColumnIndex(Contacts.People.NAME);
//        for (cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
//            result = result + cursor.getString(idIndex) + "\t";
//            result = result + cursor.getString(nameIndex) + "\t\n";
//        }
//        cursor.close();
//        return result;
//    }


}