package wagespoon.imperialdigital.com.wagespoon;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Fullscreen;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;

@Fullscreen
@EActivity(R.layout.activity_sign_in)
@WindowFeature(Window.FEATURE_NO_TITLE)
public class SignInActivity extends AppCompatActivity {

    int currnetType;

    @ViewById
    TextView tvSignIn;
    @ViewById
    TextView tviEmployer;
    @ViewById
    TextView tviEmployee;
    @ViewById
    ImageView iviEmployer;
    @ViewById
    ImageView iviEmployee;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sign_in);
//    }

    @AfterViews
    void initViews() {

    }

    @Click({R.id.ll_employee, R.id.ll_employer})
    void chooseYourSide(View view) {
        currnetType = view.getId();
        switch (currnetType) {
            case R.id.ll_employee:
                iviEmployer.setColorFilter(ContextCompat.getColor(this, R.color.Gray));
                tviEmployer.setTextColor(ContextCompat.getColor(this, R.color.Gray));
                iviEmployee.setColorFilter(ContextCompat.getColor(this, R.color.White));
                tviEmployee.setTextColor(ContextCompat.getColor(this, R.color.White));
                break;
            case R.id.ll_employer:
                iviEmployer.setColorFilter(ContextCompat.getColor(this, R.color.White));
                tviEmployer.setTextColor(ContextCompat.getColor(this, R.color.White));
                iviEmployee.setColorFilter(ContextCompat.getColor(this, R.color.Gray));
                tviEmployee.setTextColor(ContextCompat.getColor(this, R.color.Gray));
                break;
        }
    }

    @Click({R.id.tvSignUp})
    void signUp() {
        Intent intent = new Intent(this, SignUpActivity_.class);
        startActivity(intent);
    }

    @Click(R.id.tvSignIn)
    void signIn() {
        Intent intent = null;
        switch (currnetType) {
            case R.id.ll_employee:
                intent = new Intent(this, EmployeeMainActivity.class);
                break;
            case R.id.ll_employer:
                intent = new Intent(this, EmployerMainActivity.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Choose Your side", Toast.LENGTH_SHORT).show();
        }
    }
}
