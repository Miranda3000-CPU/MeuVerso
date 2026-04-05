package com.meu.verso.jeiel;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.appbar.AppBarLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private TextView textview1;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize();
		initializeLogic();
	}
	
	private void initialize() {
		_app_bar = findViewById(R.id._app_bar);
		_coordinator = findViewById(R.id._coordinator);
		_toolbar = findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		if (getSupportActionBar() != null) {
			getSupportActionBar().setDisplayHomeAsUpEnabled(true);
			getSupportActionBar().setHomeButtonEnabled(true);
		}
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		textview1 = findViewById(R.id.textview1);
		
		// Receber versículo da notificação
		if (getIntent().hasExtra("versiculo")) {
			String versiculo = getIntent().getStringExtra("versiculo");
			textview1.setText(versiculo);
		}
	}
	
	private void initializeLogic() {
		// 🔔 PERMISSÃO (Android 13+)
		if (Build.VERSION.SDK_INT >= 33) {
			if (checkSelfPermission(android.Manifest.permission.POST_NOTIFICATIONS) != android.content.pm.PackageManager.PERMISSION_GRANTED) {
				requestPermissions(new String[]{android.Manifest.permission.POST_NOTIFICATIONS}, 1001);
			}
		}
		
		// ⏰ DATA ATUAL
		Calendar now = Calendar.getInstance();
		int today = now.get(Calendar.DAY_OF_YEAR);
		int year = now.get(Calendar.YEAR);
		
		// 💾 CONTROLE DE ENVIO
		SharedPreferences prefs = getSharedPreferences("notif", MODE_PRIVATE);
		int lastDay = prefs.getInt("day", -1);
		int lastYear = prefs.getInt("year", -1);
		
		// 🎯 HORÁRIO ALVO (06:00)
		Calendar target = Calendar.getInstance();
		target.set(Calendar.HOUR_OF_DAY, 6);
		target.set(Calendar.MINUTE, 0);
		target.set(Calendar.SECOND, 0);
		
		// 🚀 ENVIO IMEDIATO se já passou das 06h e ainda não enviou
		boolean permissionGranted = Build.VERSION.SDK_INT < 33 || checkSelfPermission(android.Manifest.permission.POST_NOTIFICATIONS) == android.content.pm.PackageManager.PERMISSION_GRANTED;
		
		if (permissionGranted && now.getTimeInMillis() >= target.getTimeInMillis() && !(lastDay == today && lastYear == year)) {
			Intent intent = new Intent(this, NotificationReceiver.class);
			sendBroadcast(intent);
			prefs.edit().putInt("day", today).putInt("year", year).apply();
		}
		
		// 🔁 AJUSTA PARA O PRÓXIMO DIA
		if (target.getTimeInMillis() <= System.currentTimeMillis()) {
			target.add(Calendar.DAY_OF_MONTH, 1);
		}
		
		// ⏰ AGENDAMENTO DIÁRIO
		AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
		Intent intent = new Intent(this, NotificationReceiver.class);
		PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
		
		if (alarmManager != null) {
			alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, target.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
		}
	}
}
