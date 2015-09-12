package cube.twitterdirect;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

import cube.twitterdirect.adapter.MessageAdapter;

public class InboxFragment extends android.support.v4.app.ListFragment {

    public static final String TAG = InboxFragment.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_inbox, container, false);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        String[] mUsers = new String[10];
        for(int i=0;i<=9;i++){
            mUsers[i] = "619best";
        }
        MessageAdapter adapter = new MessageAdapter(getListView().getContext() , mUsers);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent intent = new Intent(getActivity(),ChatActivity.class);
        intent.putExtra("RECEIVER","619best");
        intent.putExtra("RECEIVERID","150617056");
        startActivity(intent);
    }
}
