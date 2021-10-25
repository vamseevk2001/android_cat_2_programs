package com.example.fileoperations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;


import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import java.io.BufferedReader;
import java.io.File;
import android.widget.ArrayAdapter;
import android.os.Environment;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import android.text.method.TextKeyListener;
import java.io.FileOutputStream;
import android.widget.TextView;
import android.widget.EditText;
import java.io.IOException;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private  File file = null;
    private ArrayList<String> myList = null;
    private ListView mListView = null;
    private ArrayAdapter aAdapter= null;
    private Button saveButton=null;
    private File myExternalFile = null;
    private String filename = "SampleFile.txt";
    private String filepath = "MyFileStorageDIR";
    private EditText inputText = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = findViewById(R.id.userlist);
        saveButton = findViewById(R.id.extSaveButton);
        inputText = findViewById(R.id.editText);
        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
            saveButton.setEnabled(false);
            Log.d("Files", "EXT STORAGE NOT AVAIALABLE");
        }
        else{
            File root = android.os.Environment.getExternalStorageDirectory();
            File dir = new File(root.getAbsolutePath() +"/Download/mm/");
            Log.d("Absolute PATH", root.getAbsolutePath());
            dir.mkdirs();
           // myExternalFile = new File(dir, filename);
            //myExternalFile = new File(getExternalFilesDir(filepath), filename);
           /* try {
 //               myExternalFile.createNewFile();
                FileOutputStream fos = new FileOutputStream(myExternalFile, true);
                String text = "SAY HELLO!!!!!!!!!!";
                fos.write(text.getBytes());
                fos.close();

            }catch (Exception e){
                Log.d("Errror", e.toString());
            }

            */
        }
    }


    public void onCreateExtFile(View view) {
        try {

            FileOutputStream fos = new FileOutputStream(myExternalFile);
            fos.write(inputText.getText().toString().getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }

        inputText.setText("");
        Toast.makeText(this, "File saved successfully in External Storage!",
                Toast.LENGTH_SHORT
        ).show();
    }

    private boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        Log.d("ExtStorageState", extStorageState);
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
        //if(extStorageState.equalsIgnoreCase("mounted")){
            Log.d("COND", "TRUE");
            return true;
        } else{
            return false;
        }
    }
    private boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        Log.d("ExtStorageState:---", extStorageState);
        if (Environment.MEDIA_MOUNTED_READ_ONLY == extStorageState) {
            Log.d("COND---", "TRUE");
            return true;
        } else{
            return false;
        }
    }


    public void writeFile(View v) {
        // add-write text into file
        try {
            String fileName= "myoutput.txt";
            FileOutputStream fileout = openFileOutput(fileName, Context.MODE_PRIVATE);
            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
            String textmsg= "Hello world!!!!";
            outputWriter.write(textmsg);
            outputWriter.close();

            //display file saved message
            Toast.makeText(this, "File saved successfully!"+getFileStreamPath(fileName),Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void appendFile(View v) {
        // add-write text into file
        try {
            String fileName= "myoutput.txt";
            FileOutputStream fileout = openFileOutput(fileName, Context.MODE_APPEND);
            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
            String content = inputText.getText().toString();
            outputWriter.write(content);
            outputWriter.close();

            //display file saved message
            Toast.makeText(this, "Content Appended successfully!"+getFileStreamPath(fileName)+new File(fileName).length(),Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void readFile(View v) {
        TextView tv = findViewById(R.id.textView);
        // add-write text into file
        try {
            String fileName= "myoutput.txt";
            FileInputStream filein = openFileInput(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(filein));
            StringBuilder sb = new StringBuilder();
            String content=null;
            while(true){
                if((content =br.readLine())==null){
                    break;
                }
                sb .append(content);
            }

            tv.setText(sb.toString());
            //Toast.makeText(this, "File saved successfully!"+getFileStreamPath(fileName),Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void listFiles(View view){
        try{
            String root_sd = Environment.getExternalStorageDirectory().toString();
            //file = File(root_sd + "/external_sd")
            Log.d("root_sd", root_sd);
            file = new File(root_sd + "/data/data/fileoperations/");
            File[] fileList=  file.listFiles();

            for (int i=0;i<fileList.length;i++) {
                if (myList != null) {
                    myList.add(fileList[i].getName());
                }

            }
            mListView.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1, myList));

        }
        catch(Exception e){
            Log.d("Error in RETREIVAL",e.toString());
        }

    }

}