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

public class Ksoap  extends AsyncTask< Void, byte[], Void>{
	
	private String text = "toto";
	
	/*private static final String	SOAP_ACTION	= "hello";
	private static final String	METHOD_NAME	= "hello";                                      //Loïc
	private static final String	NAMESPACE	= "http://facade.puy.com/";
	private static final String	URL	= "http://10.162.130.137:8080/PuyService/Puy?WSDL";*/
	
	private static final String	SOAP_ACTION	= "hello";
	private static final String	METHOD_NAME	= "hello";                                      //Antoine
	private static final String	NAMESPACE	= "http://facade.puy.com/";
	private static final String	URL	= "http://10.162.130.151:8080/PuyService/Puy?WSDL";
	
	public Ksoap() {
		
	}

	@Override
	protected Void doInBackground(Void... params) {
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
		} catch (HttpResponseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	        Log.d("TAG", "e");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	        Log.d("TAG", "e");
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	        Log.d("TAG", "e");
		}
		return null;
	}

}
