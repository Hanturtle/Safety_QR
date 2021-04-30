구글에서 제공하는 [zxing 라이브러리](https://github.com/zxing/zxing)를 활용하여 QR 코드 리더기 만들기

1. build.gradle(Module) 코드 추가

* SDK Version 24 미만
```java
implementation('com.journeyapps:zxing-android-embedded:3.6.0') { transitive = false }
implementation 'com.google.zxing:core:3.3.0'
```
* SDK Version 24 이상
```java
implementation 'com.journeyapps:zxing-android-embedded:4.1.0'
implementation 'androidx.appcompat:appcompat:1.0.2'
```
<br>

2. 원하는 액티비티에 IntentIntegrator 클래스 선언
```java
IntentIntegrator integrator = new IntentIntegrator(MainActivity.this);
integrator.setOrientationLocked(false);
integrator.setPrompt("바코드 및 QR코드 등록을 위해\n상자안에 위치시켜 주세요\n\n");  // 밑에 문구 수정 가능
integrator.initiateScan();
```

3. onActivityResult 오버라이딩
```java
@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                //result.getContents 를 이용 데이터 재가공
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
```
<br>

**세로 모드로 스캔하려면 AndroidManifest.xml의 application 태그 수정**

```java
<activity
            android:name="com.journeyapps.barcodescanner.CaptureActivity"
            android:screenOrientation="fullSensor"
            tools:replace="screenOrientation" />
```
<br><br>
- 210402 ScanQR Code
```java
public class ScanQR extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_qr);

        new IntentIntegrator(this).initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();

                // todo
            } else {
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                // todo
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}

```

