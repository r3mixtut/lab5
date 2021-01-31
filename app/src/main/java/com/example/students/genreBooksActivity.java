package com.example.students;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class genreBooksActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre_books);
        Intent intent = getIntent();
        String author = intent.getStringExtra(BooksListActivity.AUTHOR);
        Books_genre books_genre = Books_genre.getGenreList(author);

        EditText txtAuthor = (EditText)findViewById(R.id.author);
        txtAuthor.setText(books_genre.getAuthor());

        EditText txtGenre = (EditText)findViewById(R.id.genre);
        txtGenre.setText(books_genre.getGenre());

        TextView txtImageAuthor = (TextView)findViewById(R.id.authorText);
        txtImageAuthor.setText(books_genre.getAuthor());

        TextView txtImageGenre = (TextView)findViewById(R.id.genreText);
        txtImageGenre.setText(books_genre.getGenre());

        if(books_genre.getCountryOfIssue() == 0){
            ((RadioButton) findViewById(R.id.radio_countryOfIssue_Usa)).setChecked(true);
        }
        else{
            ((RadioButton) findViewById(R.id.radio_UnitedKingdom)).setChecked(true);
        }

        ((CheckBox) findViewById(R.id.CBcriticallyTestedFlg)).setChecked(books_genre.isCriticallyTestedFlg());
        ((CheckBox) findViewById(R.id.CBonSaleFlg)).setChecked(books_genre.isOnSaleFlg());

    }
    public void onBtnOkClick(View view) {
        String outString = "Автор " + ((TextView) findViewById(R.id.authorText)).getText() + "\n";
        outString +=  "Жанр " + ((TextView) findViewById(R.id.genreText)).getText() + "\n" + "Cтрана издания ";
        if(((RadioButton) findViewById(R.id.radio_countryOfIssue_Usa)).isChecked()){
            outString +=  ((TextView) findViewById(R.id.radio_countryOfIssue_Usa)).getText() + "\n";
         }else{
            outString +=  ((TextView) findViewById(R.id.radio_UnitedKingdom)).getText() + "\n";
        }
        if(((CheckBox)findViewById(R.id.CBcriticallyTestedFlg)).isChecked()){
            outString += "было проверено критиком\n";
        }else{
            outString += "не было проверено критиком\n";
        }
        outString += "В данный момент ";
        if(((CheckBox)findViewById(R.id.CBonSaleFlg)).isChecked()){
            outString += "В продаже\n";
        }else{
            outString += "изнят из продажи\n";
        }
        Toast.makeText(this, outString, Toast.LENGTH_LONG).show();
    }
}