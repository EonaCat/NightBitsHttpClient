package test.nightbits.me.test;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import org.apache.http.Header;
import org.json.JSONException;

import me.NightBits.HttpClient.NightBitsBinaryHttpResponseHandler;
import me.NightBits.HttpClient.NightBitsHttpClient;
import me.NightBits.HttpClient.NightBitsHttpResponseHandler;
import me.NightBits.HttpClient.NightBitsJsonHttpResponseHandler;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TestLibrary();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void TestLibrary()
    {
        String test = "HTTPTest ";
        final String finalTest = test;
        NightBitsHttpClient client = new NightBitsHttpClient();
        client.get("http://www.google.com", new NightBitsHttpResponseHandler()
        {
            @Override
            public void onStart()
            {
                Log.d("TEST", "STARTED " + finalTest);
            }

            @Override
            public void onFinish()
            {
                Log.d("TEST", "FINISHED " +finalTest);
            }

            @Override
            public void onSuccess(java.lang.String content)
            {
                Log.d("TEST", "SUCCEEED " + finalTest);
                ((TextView)findViewById(R.id.textView1)).setText(finalTest + " OK");
            }

            @Override
            public void onSuccess(int statusCode, org.apache.http.Header[] headers, java.lang.String content)
            {
                Log.d("TEST", "SUCCEEED " + finalTest);
                ((TextView)findViewById(R.id.textView1)).setText(finalTest + " OK");
            }

            @Override
            public void onSuccess(int statusCode, java.lang.String content)
            {
                Log.d("TEST", "SUCCEEED " + finalTest);
                ((TextView)findViewById(R.id.textView1)).setText(finalTest + " OK");
            }

            @Override
            public void onFailure(Throwable exception)
            {
                Log.d("TEST", "FAILED " + finalTest);
                ((TextView)findViewById(R.id.textView1)).setText(finalTest + " OK");
            }

            @Override
            public void onFailure(Throwable exception, String content)
            {
                Log.d("TEST", "FAILED " + finalTest);
                ((TextView)findViewById(R.id.textView1)).setText(finalTest + " OK");
            }
        });

        test = "JSONTest ";
        final String finalTest2 = test;
        client.get("http://ip.jsontest.com", new NightBitsJsonHttpResponseHandler()
        {
            @Override
            public void onStart()
            {
                Log.d("TEST", "STARTED " + finalTest2);
            }

            @Override
            public void onFinish()
            {
                Log.d("TEST", "FINISHED " + finalTest2);
            }

            @Override
            public void onSuccess(org.json.JSONObject response)
            {
                Log.d("TEST", "SUCCEEDED " + finalTest2);
                try {
                    ((TextView)findViewById(R.id.textView2)).setText(finalTest2 + " OK => " + response.getString("ip"));
                } catch (JSONException e) {
                    // Do nothing
                }

            }

            public void onSuccess(org.json.JSONArray response)
            {
                Log.d("TEST", "SUCCEEDED " + finalTest2);
                try {
                    ((TextView)findViewById(R.id.textView2)).setText(finalTest + " OK => " + response.get(0).toString());
                } catch (JSONException e) {
                    // Do nothing
                }
            }

            public void onFailure(java.lang.Throwable exception, org.json.JSONObject errorResponse)
            {
                Log.d("TEST", "FAILED " + finalTest2);
                ((TextView)findViewById(R.id.textView2)).setText(finalTest + " FAILED => "+exception.getMessage());
            }

            public void onFailure(java.lang.Throwable exception, org.json.JSONArray errorResponse)
            {
                Log.d("TEST", "FAILED " + finalTest2);
                ((TextView)findViewById(R.id.textView2)).setText(finalTest + " FAILED => "+exception.getMessage());
            }
        });

        test = "ImageTest ";
        final String final3Test = test;
        client.get("http://1.bp.blogspot.com/-u5dfSsMOMC0/UZO_5DC_W9I/AAAAAAAACM8/YCMn15HPzpE/s1600/Studio_table.png", new NightBitsBinaryHttpResponseHandler()
        {
            @Override
            public void onStart()
            {
                Log.d("TEST", "STARTED " + final3Test);
            }

            @Override
            public void onFinish()
            {
                Log.d("TEST", "FINISHED " + final3Test);
            }

            @Override
            public void onSuccess(byte[] binaryData)
            {
                Bitmap bitmap = BitmapFactory.decodeByteArray(binaryData, 0, binaryData.length);
                ((ImageView)findViewById(R.id.imageView1)).setImageBitmap(bitmap);
                Log.d("TEST", "SUCCEEDED " + final3Test);
            }

            @Override
            public void onSuccess(int statusCode, byte[] binaryData)
            {
                Bitmap bitmap = BitmapFactory.decodeByteArray(binaryData, 0, binaryData.length);
                ((ImageView)findViewById(R.id.imageView1)).setImageBitmap(bitmap);
                Log.d("TEST", "SUCCEEDED " + final3Test);
            }

            @Override
            public void onFailure(java.lang.Throwable exception, byte[] binaryData)
            {
                Log.d("TEST", "FAILED " + final3Test);
                ((TextView)findViewById(R.id.textView2)).setText(final3Test + exception.getMessage());
            }
        });
    }
}
