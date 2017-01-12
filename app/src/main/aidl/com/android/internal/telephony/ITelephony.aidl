// ITelephony.aidl
package com.android.internal.telephony;

// Declare any non-default types here with import statements

interface ITelephony {

    boolean endCall();
    void answerRingingCall();
    void dial(String number);
    void silenceRinger();
    boolean isOffhook();

    void call(String str) ;

        void cancelMissedCallsNotification() ;

        int disableApnType(String str);

        boolean disableDataConnectivity() ;

        void disableLocationUpdates() ;

        int enableApnType(String str);

        boolean enableDataConnectivity() ;

        void enableLocationUpdates();

        int getActivePhoneType();

        int getCallState();

        int getCdmaEriIconIndex();

        int getCdmaEriIconMode();

        String getCdmaEriText() ;

        boolean getCdmaNeedsProvisioning();

        Bundle getCellLocation();

        int getDataActivity();

        int getDataState();

        int getNetworkType();

        int getVoiceMessageCount();

        boolean handlePinMmi(String str);

        boolean hasIccCard();

        boolean isDataConnectivityPossible() ;

        boolean isIdle();

        boolean isRadioOn();

        boolean isRinging();

        boolean isSimPinEnabled();

        boolean setRadio(boolean z) ;

        boolean showCallScreen();

        boolean showCallScreenWithDialpad(boolean z);

        boolean supplyPin(String str);

        void toggleRadioOnOff();

        void updateServiceLocation();
}
