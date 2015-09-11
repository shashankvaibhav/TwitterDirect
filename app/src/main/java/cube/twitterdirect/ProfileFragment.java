package cube.twitterdirect;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProfileFragment extends Fragment {

    EditText mScreenName;
    Button mReadyButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        mScreenName = (EditText)getView().findViewById(R.id.screenName);
        mReadyButton = (Button) getView().findViewById(R.id.readyButton);
        mReadyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HoldConstants.screenName =  mScreenName.getText().toString();
                Toast.makeText(getActivity(),"Welcome "+HoldConstants.screenName,Toast.LENGTH_LONG).show();
            }
        });

    }
}
