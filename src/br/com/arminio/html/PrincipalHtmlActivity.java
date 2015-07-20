package br.com.arminio.html;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

@SuppressLint("SetJavaScriptEnabled")
public class PrincipalHtmlActivity extends Activity {

	private WebView html;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal_html);

		html = (WebView) findViewById(R.id.htmlView);
		WebSettings webSettings = html.getSettings();
		webSettings.setJavaScriptEnabled(true);
		webSettings.setDomStorageEnabled(true);
		webSettings.setDatabaseEnabled(true);
		webSettings.setAllowFileAccess(true);  
		if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
			html.getSettings().setDatabasePath("/data/data/" + html.getContext().getPackageName() + "/databases/");
		}
		html.setWebChromeClient(new WebChromeClient()); 
		html.setWebViewClient(new WebViewClient()); 
		html.loadUrl("file:///android_asset/html/index.html");
	}

}
