package classes;

import java.io.IOException;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import android.os.AsyncTask;
import android.util.Log;
import android.util.Xml;

public class Ksoap  extends AsyncTask<Object, Object, Object>{
	
	private String text = "toto";
	
	/*private static final String	SOAP_ACTION	= "hello";
	private static final String	METHOD_NAME	= "hello";                                      //Loïc
	private static final String	NAMESPACE	= "http://facade.puy.com/";
	private static final String	URL	= "http://10.162.130.137:8080/PuyService/Puy?WSDL";*/
	
	private String	SOAP_ACTION	= "hello";
	private String	METHOD_NAME	= "hello";                                      //Antoine
	private String	NAMESPACE	= "http://facade.puy.com/";
	private String	URL	= "http://10.162.130.151:8080/PuyService/Puy?WSDL";
	
	public Ksoap(String SOAP_ACTION, String METHOD_NAME) {
		this.SOAP_ACTION = SOAP_ACTION;
		this.METHOD_NAME = METHOD_NAME;
		
	}

	@Override
	protected Object doInBackground(Object... params) {
		// TODO Auto-generated method stub
		Log.d("TAG", "1");
        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
        //request.addProperty("ville", ville);
        
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(request);
        
        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
        try {
			androidHttpTransport.call(SOAP_ACTION, envelope);
			
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			
			String text = response.toString();                     //Fonctionne
			/*SoapObject obj = (SoapObject) envelope.bodyIn;      //Fonctionne aussi ^^
			text = obj.getPropertyAsString(0).toString();*/
			Log.d("TAG", text);
	        return text;
		} catch (HttpResponseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	        Log.d("TAG", "e");
	        return "e";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	        Log.d("TAG", "e");
	        return "e";
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	        Log.d("TAG", "e");
	        return "e";
		}
	}
	
	@Override
	public void onPostExecute(Object result) {
	
	}

}
