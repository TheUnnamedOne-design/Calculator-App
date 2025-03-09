package com.example.calculator_app;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Binder;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.SuperscriptSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

import java.util.Spliterator;

public class calculator_theme_dark extends AppCompatActivity {

    Button button_switch,nine_and_pi,eight_and_e,seven_and_ln,six_and_log,five_and_left_bracket,four_and_right_bracket,three_and_sin,two_and_cos,one_and_tan,decimal_point_and_exponent,c_and_factorial,zero_and_square_root,left_arrow,right_arrow,backspace,division_sign,multiplication_sign,subtraction_sign,addition_sign,equals_to;
    ImageView switch_and_back_image,nine_and_pi_image,eight_and_e_image,seven_and_ln_image,six_and_log_image,five_and_left_bracket_image,four_and_right_bracket_image,three_and_sin_image,two_and_cos_image,one_and_tan_image,decimal_point_and_exponent_image,c_and_factorial_image,zero_and_square_root_image;
    String uri_pi,uri_e,uri_ln,uri_log,uri_left_bracket,uri_right_bracket,uri_sin,uri_cos,uri_tan,uri_exponent,uri_factorial,uri_back,uri_square_root;
    public boolean check_keyboard_state;
    public EditText editText;
    public TextView answer_text,equals_to_text;
    public static int position=0;
    public static String pi = "\u03C0",division="\u00F7",multiplication="\u00D7";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_theme_dark);
        getSupportActionBar().setTitle("Calculator");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        EditText editText=(EditText)findViewById(R.id.Sample);
        editText.setPressed(true);

        equals_to_text=(TextView)findViewById(R.id.equals_to_text_box);
        answer_text=(TextView)findViewById(R.id.Answer_box);

        division_sign=(Button)findViewById(R.id.division_button);
        multiplication_sign=(Button)findViewById(R.id.multiplication_button);
        addition_sign=(Button)findViewById(R.id.addition_button);
        subtraction_sign=(Button)findViewById(R.id.subtraction_button);
        equals_to=(Button)findViewById(R.id.equals_to_button);

        backspace=(Button)findViewById(R.id.delete_button);

        left_arrow=(Button)findViewById(R.id.button_left_arrow);
        right_arrow=(Button)findViewById(R.id.button_right_arrow);

        check_keyboard_state=false;
        nine_and_pi=(Button)findViewById(R.id.nine_and_pi);
        nine_and_pi_image=(ImageView)findViewById(R.id.nine_and_pi_image);

        eight_and_e=(Button)findViewById(R.id.eight_and_e);
        eight_and_e_image=(ImageView)findViewById(R.id.eight_and_e_image);

        seven_and_ln=(Button)findViewById(R.id.seven_and_ln);
        seven_and_ln_image=(ImageView)findViewById(R.id.seven_and_ln_image);

        six_and_log=(Button)findViewById(R.id.six_and_log);
        six_and_log_image=(ImageView)findViewById(R.id.six_and_log_image);

        five_and_left_bracket=(Button)findViewById(R.id.five_and_left_bracket);
        five_and_left_bracket_image=(ImageView)findViewById(R.id.five_and_left_bracket_image);

        four_and_right_bracket=(Button)findViewById(R.id.four_and_right_bracket);
        four_and_right_bracket_image=(ImageView)findViewById(R.id.four_and_right_bracket_image);

        three_and_sin=(Button)findViewById(R.id.three_and_sine_button);
        three_and_sin_image=(ImageView)findViewById(R.id.three_and_sine_button_image);

        two_and_cos=(Button)findViewById(R.id.two_and_cosine_button);
        two_and_cos_image=(ImageView)findViewById(R.id.two_and_cosine_button_image);

        one_and_tan=(Button)findViewById(R.id.one_and_tan_button);
        one_and_tan_image=(ImageView)findViewById(R.id.one_and_tan_button_image);

        decimal_point_and_exponent=(Button)findViewById(R.id.decimal_and_exponent_button);
        decimal_point_and_exponent_image=(ImageView)findViewById(R.id.decimal_and_exponent_button_image);

        c_and_factorial=(Button)findViewById(R.id.clear_and_factorial_button);
        c_and_factorial_image=(ImageView)findViewById(R.id.clear_and_factorial_button_image);

        zero_and_square_root=(Button)findViewById(R.id.zero_and_square_root);
        zero_and_square_root_image=(ImageView)findViewById(R.id.zero_and_square_root_image);

        button_switch=(Button)findViewById(R.id.switch_and_back_button);
        switch_and_back_image=(ImageView)findViewById(R.id.switch_and_back_button_image);

        equals_to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equals_to_text.setText("=");
                String s=editText.getText().toString();
                calculation_algorithm(s,editText,answer_text);
            }
        });


        zero_and_square_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(!check_keyboard_state)
                {
                    cursor_place_function("0",editText);
                }
                else
                {
                    cursor_place_function("arctan{}",editText);
                }
            }
        });

        left_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(position!=0)
                {
                    position--;
                    editText.setSelection(position);
                }

            }
        });

        right_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(position!=editText.length())
                {
                    position++;
                    editText.setSelection(position);
                }

            }
        });


        nine_and_pi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(!check_keyboard_state)
                {
                    cursor_place_function("9",editText);
                }
                else
                {
                    cursor_place_function(pi,editText);
                }
            }
        });

        eight_and_e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(!check_keyboard_state)
                {
                    cursor_place_function("8",editText);
                }
                else
                {
                    cursor_place_function("e",editText);
                }
            }
        });

        seven_and_ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(!check_keyboard_state)
                {
                    cursor_place_function("7",editText);
                }
                else
                {
                    cursor_place_function("arcsin{}",editText);
                }
            }
        });

        six_and_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(!check_keyboard_state)
                {
                    cursor_place_function("6",editText);
                }
                else
                {
                    cursor_place_function("arccos{}",editText);
                }
            }
        });

        five_and_left_bracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(!check_keyboard_state)
                {
                    cursor_place_function("5",editText);
                }
                else
                {
                    cursor_place_function("(",editText);
                }
            }
        });

        four_and_right_bracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!check_keyboard_state)
                {
                    cursor_place_function("4",editText);
                }
                else
                {
                    cursor_place_function(")",editText);
                }
            }
        });

        three_and_sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!check_keyboard_state)
                {
                    cursor_place_function("3",editText);
                }
                else
                {
                    cursor_place_function("sin{}",editText);
                }
            }
        });


        two_and_cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!check_keyboard_state)
                {
                    cursor_place_function("2",editText);
                }
                else
                {
                    cursor_place_function("cos{}",editText);
                }
            }
        });

        one_and_tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!check_keyboard_state)
                {
                    cursor_place_function("1",editText);
                }
                else
                {
                    cursor_place_function("tan{}",editText);
                }
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(position!=0)
                {
                    EditText holder;
                    holder=editText;
                    String text_container=holder.getText().toString();
                    String initial=text_container.substring(0,position-1);
                    String later=text_container.substring(position,text_container.length());
                    holder.setText(initial+later);
                    position--;
                    holder.setPressed(true);
                    holder.setSelection(position);
                }
            }
        });

        button_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keyboard_function();

            }
        });

        division_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cursor_place_function(division,editText);
            }
        });

        multiplication_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cursor_place_function(multiplication,editText);
            }
        });

        addition_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cursor_place_function("+",editText);
            }
        });

        subtraction_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cursor_place_function("-",editText);
            }
        });

        decimal_point_and_exponent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!check_keyboard_state)
                {
                    cursor_place_function(".",editText);
                }
                else
                {
                    cursor_place_function("pow{}{}",editText);
                }
            }
        });

        c_and_factorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!check_keyboard_state)
                {
                    position=0;
                    editText.setText("");
                    answer_text.setText("");
                    equals_to_text.setText("");
                }
                else
                {
                    cursor_place_function("!",editText);
                }
            }
        });

    }

    public void keyboard_function()
    {
        if(!check_keyboard_state)
        {
            check_keyboard_state=true;
        }
        else
        {
            check_keyboard_state=false;
        }
        toast_func();
    }

    public void toast_func()
    {
        if(check_keyboard_state)
        {
            uri_pi = "@drawable/grey_colour_pi";
            int imageResource = getResources().getIdentifier(uri_pi, null, getPackageName());
            Drawable res = getResources().getDrawable(imageResource);
            nine_and_pi_image.setImageDrawable(res);
            nine_and_pi.setText(" ");

            uri_e = "@drawable/grey_colour_e";
            int imageResource2 = getResources().getIdentifier(uri_e, null, getPackageName());
            Drawable res2 = getResources().getDrawable(imageResource2);
            eight_and_e_image.setImageDrawable(res2);
            eight_and_e.setText(" ");

            uri_ln = "@drawable/grey_arcsin_button";
            int imageResource3 = getResources().getIdentifier(uri_ln, null, getPackageName());
            Drawable res3 = getResources().getDrawable(imageResource3);
            seven_and_ln_image.setImageDrawable(res3);
            seven_and_ln.setText(" ");

            uri_log = "@drawable/grey_arccos_button";
            int imageResource4 = getResources().getIdentifier(uri_log, null, getPackageName());
            Drawable res4 = getResources().getDrawable(imageResource4);
            six_and_log_image.setImageDrawable(res4);
            six_and_log.setText(" ");

            uri_left_bracket = "@drawable/grey_colour_left_bracket";
            int imageResource5 = getResources().getIdentifier(uri_left_bracket, null, getPackageName());
            Drawable res5 = getResources().getDrawable(imageResource5);
            five_and_left_bracket_image.setImageDrawable(res5);
            five_and_left_bracket.setText(" ");

            uri_right_bracket = "@drawable/grey_colour_right_bracket";
            int imageResource6 = getResources().getIdentifier(uri_right_bracket, null, getPackageName());
            Drawable res6 = getResources().getDrawable(imageResource6);
            four_and_right_bracket_image.setImageDrawable(res6);
            four_and_right_bracket.setText(" ");

            uri_sin = "@drawable/grey_colour_sin";
            int imageResource7 = getResources().getIdentifier(uri_sin, null, getPackageName());
            Drawable res7 = getResources().getDrawable(imageResource7);
            three_and_sin_image.setImageDrawable(res7);
            three_and_sin.setText(" ");

            uri_cos = "@drawable/grey_colour_cos";
            int imageResource8 = getResources().getIdentifier(uri_cos, null, getPackageName());
            Drawable res8 = getResources().getDrawable(imageResource8);
            two_and_cos_image.setImageDrawable(res8);
            two_and_cos.setText(" ");

            uri_tan = "@drawable/grey_colour_tan";
            int imageResource9 = getResources().getIdentifier(uri_tan, null, getPackageName());
            Drawable res9 = getResources().getDrawable(imageResource9);
            one_and_tan_image.setImageDrawable(res9);
            one_and_tan.setText(" ");

            uri_exponent = "@drawable/silver_button_exponent";
            int imageResource10 = getResources().getIdentifier(uri_exponent, null, getPackageName());
            Drawable res10 = getResources().getDrawable(imageResource10);
            decimal_point_and_exponent_image.setImageDrawable(res10);
            decimal_point_and_exponent.setText(" ");

            uri_factorial = "@drawable/silver_button";
            int imageResource11 = getResources().getIdentifier(uri_factorial, null, getPackageName());
            Drawable res11 = getResources().getDrawable(imageResource11);
            c_and_factorial_image.setImageDrawable(res11);
            c_and_factorial.setText("!");

            uri_back = "@drawable/grey_colour_back";
            int imageResource12 = getResources().getIdentifier(uri_back, null, getPackageName());
            Drawable res12 = getResources().getDrawable(imageResource12);
            switch_and_back_image.setImageDrawable(res12);
            button_switch.setText(" ");

            uri_square_root = "@drawable/grey_arctan_button";
            int imageResource13 = getResources().getIdentifier(uri_square_root, null, getPackageName());
            Drawable res13 = getResources().getDrawable(imageResource13);
            zero_and_square_root_image.setImageDrawable(res13);
            zero_and_square_root.setText(" ");

        }
        else
        {
            uri_pi = "@drawable/grey_colour_button";
            int imageResource = getResources().getIdentifier(uri_pi, null, getPackageName());
            Drawable res = getResources().getDrawable(imageResource);
            nine_and_pi_image.setImageDrawable(res);
            nine_and_pi.setText("9");

            uri_e = "@drawable/grey_colour_button";
            int imageResource2 = getResources().getIdentifier(uri_e, null, getPackageName());
            Drawable res2 = getResources().getDrawable(imageResource2);
            eight_and_e_image.setImageDrawable(res2);
            eight_and_e.setText("8");

            uri_ln = "@drawable/grey_colour_button";
            int imageResource3 = getResources().getIdentifier(uri_ln, null, getPackageName());
            Drawable res3 = getResources().getDrawable(imageResource3);
            seven_and_ln_image.setImageDrawable(res3);
            seven_and_ln.setText("7");

            uri_log = "@drawable/grey_colour_button";
            int imageResource4 = getResources().getIdentifier(uri_log, null, getPackageName());
            Drawable res4 = getResources().getDrawable(imageResource4);
            six_and_log_image.setImageDrawable(res4);
            six_and_log.setText("6");

            uri_left_bracket = "@drawable/grey_colour_button";
            int imageResource5 = getResources().getIdentifier(uri_left_bracket, null, getPackageName());
            Drawable res5 = getResources().getDrawable(imageResource5);
            five_and_left_bracket_image.setImageDrawable(res5);
            five_and_left_bracket.setText("5");

            uri_right_bracket = "@drawable/grey_colour_button";
            int imageResource6 = getResources().getIdentifier(uri_right_bracket, null, getPackageName());
            Drawable res6 = getResources().getDrawable(imageResource6);
            four_and_right_bracket_image.setImageDrawable(res6);
            four_and_right_bracket.setText("4");

            uri_sin = "@drawable/grey_colour_button";
            int imageResource7 = getResources().getIdentifier(uri_sin, null, getPackageName());
            Drawable res7 = getResources().getDrawable(imageResource7);
            three_and_sin_image.setImageDrawable(res7);
            three_and_sin.setText("3");

            uri_cos = "@drawable/grey_colour_button";
            int imageResource8 = getResources().getIdentifier(uri_cos, null, getPackageName());
            Drawable res8 = getResources().getDrawable(imageResource8);
            two_and_cos_image.setImageDrawable(res8);
            two_and_cos.setText("2");

            uri_tan = "@drawable/grey_colour_button";
            int imageResource9 = getResources().getIdentifier(uri_tan, null, getPackageName());
            Drawable res9 = getResources().getDrawable(imageResource9);
            one_and_tan_image.setImageDrawable(res9);
            one_and_tan.setText("1");

            uri_exponent = "@drawable/silver_button";
            int imageResource10 = getResources().getIdentifier(uri_exponent, null, getPackageName());
            Drawable res10 = getResources().getDrawable(imageResource10);
            decimal_point_and_exponent_image.setImageDrawable(res10);
            decimal_point_and_exponent.setText(".");

            uri_factorial = "@drawable/silver_button";
            int imageResource11 = getResources().getIdentifier(uri_factorial, null, getPackageName());
            Drawable res11 = getResources().getDrawable(imageResource11);
            c_and_factorial_image.setImageDrawable(res11);
            c_and_factorial.setText("C");

            uri_back = "@drawable/grey_switch_button";
            int imageResource12 = getResources().getIdentifier(uri_back, null, getPackageName());
            Drawable res12 = getResources().getDrawable(imageResource12);
            switch_and_back_image.setImageDrawable(res12);
            button_switch.setText(" ");

            uri_square_root = "@drawable/grey_0_button";
            int imageResource13 = getResources().getIdentifier(uri_square_root, null, getPackageName());
            Drawable res13 = getResources().getDrawable(imageResource13);
            zero_and_square_root_image.setImageDrawable(res13);
            zero_and_square_root.setText("0");
        }
    }

    private static void cursor_place_function(String s,EditText editText2)
    {
        EditText holder;
        holder=editText2;
        String newtext =s;
        String text_container=holder.getText().toString();
        String initial=text_container.substring(0,position);
        String later=text_container.substring(position,text_container.length());
        holder.setText(initial+s+later);
        position+=s.length();
        holder.setPressed(true);
        holder.setSelection(position);

    }

    private static void calculation_algorithm(String receive,EditText ed,TextView view)
    {
        String s1,s2,s3;

        s1=receive;
        s2=receive;
        s3=receive;

        boolean checker=(String_checker(s1));
        number_locator(s2);
        boolean checker2=sign_bracket_verifier(s2,view);
        boolean checker3=true,checker4;
        String f,l;
        f=s1.substring(0,1);
        l=s1.substring(s1.length()-1,s1.length());
        if(is_mathematical_sign(f)||is_mathematical_sign(l))
        {
            checker3=false;
        }
        if(checker&&checker2&&checker3)
        {
            view.setText("true");
            advanced_algorithm(s2,view);
        }
        else
        {
           view.setText("Syntax error");
        }

    }
    private static void number_locator(String s1)
    {

    }
    private static boolean String_checker(String s1)
    {
        boolean firstcheck=bracket_checker(s1);
        return firstcheck;
    }
    private static boolean bracket_checker(String s1)
    {
        int l=0;
        int u=s1.length();
        int a1,a2,a3,a4;
        int cbl=0,cbr=0,crbl=0,crbr=0;
        for(a1=0;a1<u;a1++)
        {
            if(s1.charAt(a1)=='(')
            {
                cbl++;
            }
            else if(s1.charAt(a1)==')')
            {
                cbr++;
            }
            else if(s1.charAt(a1)=='{')
            {
                crbl++;
            }
            else if(s1.charAt(a1)=='}')
            {
                crbr++;
            }
        }
        boolean c1=false,c2=false;
        if(cbl==cbr)
        {
            c1=true;
        }
        if(crbl==crbr)
        {
            c2=true;
        }
        boolean finalcheck=false;
        if(c1&&c2)
        {
            finalcheck=true;
        }
        return finalcheck;
    }
    private static boolean sign_bracket_verifier(String s2,TextView view)
    {
        boolean check=true;

        String s=s2;
        int a1,a2,a3,a4;
        for(a1=0;a1<s2.length();a1++)
        {
            if(s2.charAt(a1)=='('||s2.charAt(a1)==')'||s2.charAt(a1)=='{'||s2.charAt(a1)=='}')
            {
                if(s2.charAt(a1)=='(')
                {
                    String p1,p2,p3,p4;

                    if(a1!=0)
                    {
                        p1=s2.substring(a1-1,a1);
                        boolean checker=mathematical_sign_check(p1);
                        boolean checker2=false;
                        if(p1.equals("(")||p1.equals("{"))
                        {
                            checker2=true;
                        }
                        if(!checker&&!checker2)
                        {
                            check=false;

                            break;
                        }
                    }
                    if(a1!=s2.length()-1)
                    {
                        p2=s2.substring(a1+1,a1+2);
                        boolean checker=mathematical_sign_check(p2);
                        boolean checker2=false;
                        if(p2.equals(")")||p2.equals("("))
                        {
                            checker2=true;
                        }
                        if(checker&&!checker2)
                        {
                            check=false;
                            break;
                        }
                    }
                }
                else if(s2.charAt(a1)==')')
                {
                    String p1,p2,p3,p4;

                    if(a1!=0)
                    {
                        p1=s2.substring(a1-1,a1);
                        boolean checker=mathematical_sign_check(p1);
                        boolean checker2=false;
                        if(p1.equals("(")||p1.equals(")")||p1.equals("}"))
                        {
                            checker2=true;
                        }
                        if(checker&&!checker2)
                        {
                            check=false;

                            break;
                        }
                    }
                    if(a1!=s2.length()-1)
                    {
                        p2=s2.substring(a1+1,a1+2);
                        boolean checker=mathematical_sign_check(p2);
                        boolean checker2=false;
                        if(p2.equals(")")||p2.equals("}"))
                        {
                            checker2=true;
                        }
                        if(!checker&&!checker2)
                        {
                            check=false;
                            break;
                        }
                    }
                }
                else if(s2.charAt(a1)=='}')
                {
                    String p1,p2,p3,p4;

                    if(a1!=0)
                    {
                        p1=s2.substring(a1-1,a1);
                        boolean checker=mathematical_sign_check(p1);
                        boolean checker2=false;
                        if(p1.equals(")")||p1.equals("}"))
                        {
                            checker2=true;
                        }
                        if(checker&&checker2)
                        {
                            check=false;

                            break;
                        }
                    }
                    if(a1!=s2.length()-1)
                    {
                        p2=s2.substring(a1+1,a1+2);
                        boolean checker=mathematical_sign_check(p2);
                        boolean checker2=false;
                        if(p2.equals(")")||p2.equals("}"))
                        {
                            checker2=true;
                        }
                        if(!checker&&!checker2)
                        {
                            check=false;
                            break;
                        }
                    }
                }
            }
        }
        return check;
    }
    private static boolean mathematical_sign_check(String str)
    {
        boolean check=false;
        if(str.equals("+")||str.equals("-")||str.equals(division)||str.equals(multiplication))
        {
            check=true;
            return check;
        }
        return check;
    }
    private static boolean is_mathematical_sign(String s1)
    {
        String s2,s3;
        s2=s1;
        if(s2.equals("+")||s2.equals(multiplication)||s2.equals("-")||s2.equals(division))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    private static boolean is_number(String s1)
    {
        String s2,s3;
        s2=s1;
        int a1,a2,a3,a4;
        String arr[]={"0","1","2","3","4","5","6","7","8","9","."};
        boolean check=true;
        for(a1=0;a1<arr.length;a1++)
        {
            if(!(s2.equals(arr[a1])))
            {
                check=false;
            }
        }
        return check;
    }
    private static boolean is_maths_symbol(String s1)
    {
        String s2,s3;
        s2=s1;
        int a1,a2,a3,a4;
        String arr[]={"+","-",division,multiplication};
        boolean check=true;
        for(a1=0;a1<arr.length;a1++)
        {
            if(!(s2.equals(arr[a1])))
            {
                check=false;
            }
        }
        return check;
    }
    private static void advanced_algorithm(String s,TextView ed)
    {
        String s1=s;
        String s2=s1;
        String a=simplify_function(s2,ed);
    }
    private static String simplify_function(String s, TextView ed)
    {
        String s1=s;
        int a1,a2,a3;
        int count1=0,count2=0;
        String holder="";
        int indices[][]=new int[s.length()][2];
        int limit=0;
        for(a1=0;a1<s.length();a1++)
        {
            if(s.charAt(a1)=='('||s.charAt(a1)=='{')
            {
               // ed.setText(ed.getText().toString()+holder);

                limit=locate_current_end_point(s.substring(a1,s.length()));
                indices[count1][0]=a1;
                indices[count1][1]=limit+a1;
                count1++;

            }
        }

        String parts[]=new String[count1];
         for(a2=0;a2<count1;a2++)
         {
             parts[count2]=s.substring(indices[a2][0],indices[a2][1]);
             count2++;
         }
         String complete="";
         for(a3=0;a3<count2;a3++)
         {
             complete+=parts[a3]+" ";
         }
         ed.setText(complete);

        return "";
    }
    private static int locate_current_end_point(String s)
    {

        int a1,a2,a3;
        int ll=0,ul=0;
        int count=0;
        for(a1=0;a1<s.length();a1++)
        {
            if(s.charAt(a1)=='{'||s.charAt(a1)=='(')
            {
                count++;
            }
            if(s.charAt(a1)=='}'||s.charAt(a1)==')')
            {
                count--;
            }
            if(count==0&&a1!=0)
            {
                ul=a1+1;
                break;
            }
        }
        String holder="";
        holder=s.substring(ll,ul);
        return ul;
    }
    private static String main_Calculator(String s)
    {
        String s1=s;
        int a1,a2,a3,a4;
        String single_number="";
        int ll=0,ul=0;
        String numbers[]=new String[s.length()];
        int count=0,count1=0;

        while(count!=s.length())
        {
            char h=s.charAt(count);
            String temp=""+h;
            if(is_number(temp)||count==s.length())
            {
                single_number+=temp;
            }
            else
            {

            }
            ul++;
            count++;

        }
        return "";
    }

}
