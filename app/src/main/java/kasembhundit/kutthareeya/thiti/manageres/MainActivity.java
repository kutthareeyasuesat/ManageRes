package kasembhundit.kutthareeya.thiti.manageres;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create ListView
        createListView();

        //Image Controller

        imageController();


    }   //Main Method

    private void imageController() {
        imageView = (ImageView) findViewById(R.id.imvAuthen);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AuthenActivity.class);
                startActivity(intent);
            }
        });
    }


    private void createListView() {
        ListView listView = (ListView) findViewById(R.id.LivNews);

        try {

            GetAllData getAllData = new GetAllData(this);
            MyConstant myConstant = new MyConstant();
            getAllData.execute(myConstant.getUrlGetNews());
            String strJSON = getAllData.get();
            Log.d("29MayV1", "JSON ==>" + strJSON);

        } catch (Exception e) {
            Log.d("20MayV1", "e createListView ==>" + e.toString());
        }
    }   //create ListView

}   //main class
