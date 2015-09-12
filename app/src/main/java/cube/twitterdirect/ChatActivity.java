package cube.twitterdirect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class ChatActivity extends AppCompatActivity {

    public static final String TAG = ChatActivity.class.getSimpleName();
    public static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown;charset=utf-8");

    EditText mMessage;
    Button mSend;
    String mReceiver;
    String mReceiverUserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        mMessage = (EditText) findViewById(R.id.messageText);
        mSend = (Button) findViewById(R.id.sendButton);



    }
    @Override
    public void onResume() {
        super.onResume();

        Intent intent = getIntent();
        mReceiver = intent.getStringExtra("RECEIVER");
        mReceiverUserId = intent.getStringExtra("RECEIVERID");

        String mText = mMessage.getText().toString();


        OkHttpClient client = new OkHttpClient();
        String body = "text="+mText+"&screen_name="+mReceiver+"&user_id="+mReceiverUserId;
        Request request = new Request.Builder()
                .url("https://api.twitter.com/1.1/direct_messages/new.json")
                .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, body))
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                //Alert about sending request
            }

            @Override
            public void onResponse(Response response) throws IOException {
                //message send
                Log.v(TAG, response.body().string());
            }
        });
    }

}
