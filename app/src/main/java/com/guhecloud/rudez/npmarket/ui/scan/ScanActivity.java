package com.guhecloud.rudez.npmarket.ui.scan;

import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.dlazaro66.qrcodereaderview.QRCodeReaderView;
import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.base.RxActivity;
import com.guhecloud.rudez.npmarket.mvp.contract.ScanContract;
import com.guhecloud.rudez.npmarket.mvp.presenter.ScanPresenter;
import com.guhecloud.rudez.npmarket.util.SnackbarUtil;

import butterknife.BindView;

public class ScanActivity extends RxActivity<ScanPresenter> implements ScanContract.View, QRCodeReaderView.OnQRCodeReadListener {

    @BindView(R.id.qrdecoderview)
    QRCodeReaderView qrCodeReaderView;
    @BindView(R.id.view_toolbar)
    Toolbar viewToolbar;

    @Override
    protected void injectObject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_scan;
    }

    @Override
    protected void onResume() {
        super.onResume();
        qrCodeReaderView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        qrCodeReaderView.stopCamera();
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {
        setToolBar(viewToolbar, "二维码扫描",true);
        qrCodeReaderView.setOnQRCodeReadListener(this);

        // Use this function to enable/disable decoding
        qrCodeReaderView.setQRDecodingEnabled(true);

        // Use this function to change the autofocus interval (default is 5 secs)
        qrCodeReaderView.setAutofocusInterval(500L);

        // Use this function to enable/disable Torch
        qrCodeReaderView.setTorchEnabled(true);

        // Use this function to set front camera preview
        qrCodeReaderView.setFrontCamera();

        // Use this function to set back camera preview
        qrCodeReaderView.setBackCamera();
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void onQRCodeRead(String text, PointF[] points) {
//        ToastUtil.show(text);
        SnackbarUtil.showDefault(this,text);
    }
}
