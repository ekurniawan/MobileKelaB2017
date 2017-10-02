package actualsolusi.com.samplekelasb;

import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by erick on 02/10/2017.
 */

public class RecyclerItemListener implements RecyclerView.OnItemTouchListener {

    private RecyclerTouchListener listener;

    public interface RecyclerTouchListener{
        public void OnClickItem(View v, int position);
        public void OnLongClickItem(View v,int position);
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
