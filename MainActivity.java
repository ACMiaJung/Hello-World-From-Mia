package com.example.helloworldfrommia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Seeing that it could be boring for the users to interact with buttons that stop working after the first click,
    // I modified the buttons so that they'll continue on working as promised every time the user clicks on them.

    private int count = 0;
    private boolean backgroundIsPink = true;
    private boolean saysHello = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = ((TextView)(findViewById(R.id.text)));

        // User can tap a button to change the text color of the label.
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // change the text color of the label.
                    // (text color will keep on changing each time the user clicks on the button-
                    // from original color (black), to ocean, to purple, to magenta, then to black again.)
                textView.setTextColor(getResources().getColor(
                        (count==0?R.color.ocean:count==1?R.color.purple_500:count==2?R.color.magenta:android.R.color.black)));
                count++;
                count = count<4? count:0;
            }
        });

        // User can tap a button to change the color of the background view.
        // (the color of the background will keep on changing each time the user clicks the button.)
        findViewById(R.id.changeBackgroundButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // each time the button is clicked, the background color changes between pink and sky blue.
                    // if background is pink, then clicking the button will change it to sky blue.
                    // if background is NOT pink (is sky blue), then clicking the button will change it back to pink

                findViewById(R.id.parent).setBackgroundColor(getResources().getColor(
                        backgroundIsPink==true? R.color.sky:R.color.soft_pink));
                backgroundIsPink = backgroundIsPink==true? false:true;

            }
        });

        //User can tap a button to change the text string of the label - Android is Awesome!
        // (each time the button is clicked, the text string changes between "Hello from Mia" and "Android is Awesome")
        findViewById(R.id.changeTextButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (saysHello){
                    textView.setText("Android is\nsuper awesome!");
                    textView.setTextSize(57);
                    saysHello=false;
                }
                else {
                    textView.setText(" \" Hello from Mia! \" ");
                    textView.setTextSize(50);
                    saysHello=true;
                }
            }
        });

        //User can tap on the background view (parent) to reset all views to default settings.
        findViewById(R.id.parent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1. reset text (id: @id/text) to the original text (" \n Hello from Mia! \n " , size 50)
                    textView.setText(" \" Hello from Mia! \" ");
                    textView.setTextSize(50);
                    saysHello=true;

                // 2. reset text (id: @id/text) color to original color (black).
                    textView.setTextColor(getResources().getColor(R.color.black));
                    count=0;

                // 3. reset background color to original color (R.color.soft_pink)
                    findViewById(R.id.parent).setBackgroundColor(getResources().getColor(R.color.soft_pink));
                    backgroundIsPink=true;
            }
        });

        //User can tap the “Change text string” button to update the label with the text from the text field.
        findViewById(R.id.changeCustomTextButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //change the text to what's in the edit text view.
                String userEnteredText = ((EditText)findViewById(R.id.editText)).getText().toString();
                textView.setTextSize(40);
                //If the text field is empty, update label with default text string.
                if (userEnteredText.isEmpty()){
                    textView.setText("Enter your own text!");
                }
                else{
                    textView.setText(userEnteredText);
                }
            }
        });
    }
}