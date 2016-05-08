package github.weiggle.com.saoyisao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import github.weiggle.widget.SaoYiSaoWidget;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SaoYiSaoWidget widget = new SaoYiSaoWidget(this);
        setContentView(widget);
    }
}
