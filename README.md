# NightBitsHttpClient
Android NightBits HttpClient

===================================
NightBitsBinaryHttpResponseHandler:
===================================

```
NightBitsHttpClient client = new NightBitsHttpClient();
String[] allowedTypes = new String[] { "image/png" };

client.get("http://www.google.com/image.png", new NightBitsBinaryHttpResponseHandler(allowedTypes)
{
    @Override
    public void onSuccess(byte[] binaryData)
    {
         // Got a response
    }

    @Override
    public void onFailure(Throwable exception, byte[] binaryData)
    {
         // Response failed
    }
}
```

=============================
NightBitsHttpResponseHandler:
=============================

```
NightBitsHttpClient client = new NightBitsHttpClient();
client.get("http://www.google.com", new NightBitsHttpResponseHandler()
{
    @Override
    public void onStart()
    {
        // Started the request
    }

    @Override
    public void onSuccess(String response)
    {
        // Got a response
    }

    @Override
    public void onFailure(Throwable exception, String response)
    {
        // Got a failure
    }

    @Override
    public void onFinish()
    {
        // Completed the request
    }
}
```

=================================
NightBitsJsonHttpResponseHandler:
=================================

```
NightBitsHttpClient client = new NightBitsHttpClient();
client.get("http://www.google.com", new NightBitsJsonHttpResponseHandler()
{
    @Override
    public void onStart()
    {
        // Started the request
    }

    @Override
    public void onSuccess(int statusCode, JSONObject response)
    {
        // Got a response for the JSONObject
    }

    public void onSuccess(int statusCode,  JSONArray response)
    {
    	// Got a response for the JSONArray
    }

    @Override
    public void onFailure(Throwable exception, JSONObject errorResponse)
    {
        // Got a failure for the JSONObject
    }

    @Override
    public void onFailure(Throwable exception, JSONArray errorResponse)
    {
        // Got a failure for the JSONArray
    }

    @Override
    public void onFinish()
    {
        // Completed the request
    }
}
```

Refer to the javaDocumentation for more information