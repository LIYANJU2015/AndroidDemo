/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.internal.telecom;

import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;


/**
 * Interface used to interact with Telecom. Mostly this is used by TelephonyManager for passing
 * commands that were previously handled by ITelephony.
 * {@hide}
 */
interface ITelecomService {
    /**
     * Brings the in-call screen to the foreground if there is an active call.
     *
     * @param showDialpad if true, make the dialpad visible initially.
     */
    void showInCallScreen(boolean showDialpad, String callingPackage);



    /**
     * @see TelecomManager#getAllPhoneAccountsCount
     */
    int getAllPhoneAccountsCount();





    /**
     * @see TelecomServiceImpl#getDefaultPhoneApp
     */
    ComponentName getDefaultPhoneApp();

    /**
     * @see TelecomServiceImpl#getDefaultDialerPackage
     */
    String getDefaultDialerPackage();

    /**
     * @see TelecomServiceImpl#getSystemDialerPackage
     */
    String getSystemDialerPackage();

    //
    // Internal system apis relating to call management.
    //

    /**
     * @see TelecomServiceImpl#silenceRinger
     */
    void silenceRinger(String callingPackage);

    /**
     * @see TelecomServiceImpl#isInCall
     */
    boolean isInCall(String callingPackage);

    /**
     * @see TelecomServiceImpl#isRinging
     */
    boolean isRinging(String callingPackage);

    /**
     * @see TelecomServiceImpl#getCallState
     */
    int getCallState();

    /**
     * @see TelecomServiceImpl#endCall
     */
    boolean endCall();

    /**
     * @see TelecomServiceImpl#acceptRingingCall
     */
    void acceptRingingCall();

    /**
     * @see TelecomServiceImpl#cancelMissedCallsNotification
     */
    void cancelMissedCallsNotification(String callingPackage);

    /**
     * @see TelecomServiceImpl#handleMmi
     */
    boolean handlePinMmi(String dialString, String callingPackage);



    /**
     * @see TelecomServiceImpl#isTtySupported
     */
    boolean isTtySupported(String callingPackage);

    /**
     * @see TelecomServiceImpl#getCurrentTtyMode
     */
    int getCurrentTtyMode(String callingPackage);


    /**
     * @see TelecomServiceImpl#placeCall
     */
    void placeCall(in Uri handle, in Bundle extras, String callingPackage);

    /**
     * @see TelecomServiceImpl#setDefaultDialer
     */
    boolean setDefaultDialer(in String packageName);
}
