package cube.twitterdirect.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import cube.twitterdirect.InboxFragment;
import cube.twitterdirect.R;


public class MessageAdapter extends BaseAdapter {
    private Context mContext;
    private String[] mUser;

    public MessageAdapter(Context context, String[] user){
        mContext = context;
        mUser = user;
    }

    @Override
    public int getCount() {

        return mUser.length;
    }

    @Override
    public Object getItem(int position) {

        return mUser[position];
    }

    @Override
    public long getItemId(int position) {

        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null ){
            //Brand New
            convertView = LayoutInflater.from(mContext).inflate(R.layout.message_item , null);
            holder = new ViewHolder();
            holder.receiverLabel = (TextView) convertView.findViewById(R.id.screenName);
            convertView.setTag(holder);

        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }

        String user = mUser [position];
        holder.receiverLabel.setText(user);
        return convertView;
    }
    private static class ViewHolder{

        TextView receiverLabel;

    }
}
