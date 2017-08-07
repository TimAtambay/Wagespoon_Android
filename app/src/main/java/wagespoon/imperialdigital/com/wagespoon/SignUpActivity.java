package wagespoon.imperialdigital.com.wagespoon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Fullscreen;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;

@Fullscreen
@EActivity(R.layout.activity_sign_up)
@WindowFeature(Window.FEATURE_NO_TITLE)
public class SignUpActivity extends AppCompatActivity {

    @ViewById
    TextView tvGetStarted;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sign_up);
//    }

    @AfterViews
    void initViews() {

    }

    @Click(R.id.tvGetStarted)
    void showVerifiyLink(){
        Intent intent = new Intent(this, ConfirmEmailActivity.class);
        startActivity(intent);
    }
}
