package com.example.android.justjava;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.NumberFormat;

import static android.content.Intent.EXTRA_SUBJECT;
import static android.provider.CalendarContract.CalendarCache.URI;

public class MainActivity extends AppCompatActivity {

    int number =1;


    String name ="";







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView quanttxt=(TextView) findViewById(R.id.quantity_text_view);
        quanttxt.setText("1");



        }




public void submitOrder(View view)
{



        display(number);
        createOrderSummery(calculatePrice());



}



private  void display (int number)
{

    TextView quanttxt=(TextView) findViewById(R.id.quantity_text_view);

    quanttxt.setText(""+number);

}

private  int calculatePrice()
{

    int price=number*5;
    return price;

}
    public void plus(View view)
    {

        number=number+1;
        if  ( number>100){
        number=100;
        Toast.makeText(MainActivity.this,"Sorry we cant serve more than 100 cups",Toast.LENGTH_SHORT).show();

    }
    else
        {
        display(number);
    }

    }

    public void minus(View view)
    {
            number = number - 1;

            if(number>0){

                display(number);

            }
            else{
                number=1;
                Toast.makeText(MainActivity.this,"Cups cant be less than 1 ",Toast.LENGTH_SHORT).show();
            }
    }
    public void sendmail (String str, String txt ){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(intent.EXTRA_SUBJECT,str);
        intent.putExtra(intent.EXTRA_TEXT,txt);

        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }

    }
    private void createOrderSummery(int calculatePrice){

        EditText yourName= (EditText)findViewById(R.id.yourName);

        name = yourName.getText().toString();

        CheckBox checkBox =(CheckBox)findViewById(R.id.checkBox);

        CheckBox checkBox2=(CheckBox)findViewById(R.id.checkBox2);


        if (name.equals("")|| name.equals(" "))
        {
          Toast.makeText(MainActivity.this,"Please enter your name ",Toast.LENGTH_SHORT).show();



        }


        else if(checkBox.isChecked()&&checkBox2.isChecked()) {

            ImageView checked = (ImageView) findViewById(R.id.checked);
            checked.setVisibility(View.VISIBLE);

            TextView orderSummerTextView=(TextView)findViewById(R.id.order_summery_text_view);


            orderSummerTextView.setText("Name : "+name+"\n"+"Quantity : "+number+"\n"+"Whipped Cream  is Added :)"+"\n"+"Chocolate is added ;)"+"\n"+"Total : "+NumberFormat.getCurrencyInstance().format(calculatePrice+(3*number))+ "\n"+"Thank You!");

            sendmail("ordering coffe","Name : "+name+"\n"+"Quantity : "+number+"\n"+"Whipped Cream  is Added :)"+"\n"+"Chocolate is added ;)"+"\n"+"Total : "+NumberFormat.getCurrencyInstance().format(calculatePrice+(3*number))+ "\n"+"Thank You!");

        }

        else if(checkBox.isChecked())
        {


            ImageView checked = (ImageView) findViewById(R.id.checked);
            checked.setVisibility(View.VISIBLE);

            TextView orderSummerTextView=(TextView)findViewById(R.id.order_summery_text_view);


            orderSummerTextView.setText("Name : "+name+"\n"+"Quantity : "+number+"\n"+"Whipped Cream  is Added :)"+"\n"+"No Chocolate "+"\n"+"Total : "+NumberFormat.getCurrencyInstance().format(calculatePrice+(1*number))+ "\n"+"Thank You!");

           sendmail("ordering coffe","Name : "+name+"\n"+"Quantity : "+number+"\n"+"Whipped Cream  is Added :)"+"\n"+"Chocolate is added ;)"+"\n"+"Total : "+NumberFormat.getCurrencyInstance().format(calculatePrice+(3*number))+ "\n"+"Thank You!");


        }

        else if (checkBox2.isChecked())
        {

            ImageView checked = (ImageView) findViewById(R.id.checked);
            checked.setVisibility(View.VISIBLE);

            TextView orderSummerTextView=(TextView)findViewById(R.id.order_summery_text_view);


            orderSummerTextView.setText("Name : "+name+"\n"+"Quantity : "+number+"\n"+"No Whipped Cream"+"\n"+" Chocolate is added ;) "+"\n"+"Total : "+NumberFormat.getCurrencyInstance().format(calculatePrice+(2*number))+ "\n"+"Thank You!");

           sendmail("ordering coffe","Name : "+name+"\n"+"Quantity : "+number+"\n"+"Whipped Cream  is Added :)"+"\n"+"Chocolate is added ;)"+"\n"+"Total : "+NumberFormat.getCurrencyInstance().format(calculatePrice+(3*number))+ "\n"+"Thank You!");

        }

    else {
            ImageView checked = (ImageView) findViewById(R.id.checked);
            checked.setVisibility(View.VISIBLE);

            TextView orderSummerTextView = (TextView) findViewById(R.id.order_summery_text_view);


            orderSummerTextView.setText("Name : " + name + "\n" + "Quantity : " + number + "\n"+"No Whipped Cream"+"\n"+"No Chocolate"+"\n" + "Total : " + NumberFormat.getCurrencyInstance().format(calculatePrice) + "\n" + "Thank You!");

            sendmail("ordering coffe","Name : "+name+"\n"+"Quantity : "+number+"\n"+"Whipped Cream  is Added :)"+"\n"+"Chocolate is added ;)"+"\n"+"Total : "+NumberFormat.getCurrencyInstance().format(calculatePrice+(3*number))+ "\n"+"Thank You!");

        }


    }




    }


