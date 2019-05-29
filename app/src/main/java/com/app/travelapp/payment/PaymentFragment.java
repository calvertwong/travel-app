package com.app.travelapp.payment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.app.travelapp.R;
import com.app.travelapp.utils.SummaryFragment;
import com.paypal.android.sdk.payments.PayPalAuthorization;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalItem;
import com.paypal.android.sdk.payments.PayPalOAuthScopes;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalPaymentDetails;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;
import com.paypal.android.sdk.payments.ShippingAddress;
import org.json.JSONException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * A simple {@link Fragment} subclass.
 */
public class PaymentFragment extends Fragment {

    private static final String TAG = "paymentExample";
    private static final String CONFIG_ENVIRONMENT = PayPalConfiguration.ENVIRONMENT_NO_NETWORK;
    private static final int REQUEST_CODE_PAYMENT = 1;
    private Button button;
    private TextView textresult;
    Context context;
    private String[] selectedSeatArray;
    private SharedPreferences sharedPreferences;
    private int numOfTickets;
    private String totalFare;
    private String resultText;



    private static final String CONFIG_CLIENT_ID = "AWoffHc6UApu6IbpSCjucIVblKmQIpJCJqOTu0eAlKvGGiiS67ZZj5B4p8P7WB_Ad8dvnoviQkUpRHEh";

    private static PayPalConfiguration config = new PayPalConfiguration()
            .environment(CONFIG_ENVIRONMENT)
            .clientId(CONFIG_CLIENT_ID)
            // The following are only used in PayPalFuturePaymentActivity.
            .merchantName("Example Merchant")
            .merchantPrivacyPolicyUri(Uri.parse("https://www.example.com/privacy"))
            .merchantUserAgreementUri(Uri.parse("https://www.example.com/legal"));


    public PaymentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_payment, container, false);

        TextView toolbar_title_tv = getActivity().findViewById(R.id.toolbar_title_tv);
        toolbar_title_tv.setText(getString(R.string.payment));

        button = view.findViewById(R.id.buyItBtn);
        textresult = view.findViewById(R.id.txtResult);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String seatLabelString = sharedPreferences.getString("selectedseats", "");
        selectedSeatArray = seatLabelString.split(",");
        resultText = calculateTotalFare(selectedSeatArray);
        textresult.setText("No. of Seats : " + selectedSeatArray.length + "\n" + "Total Amount : " + resultText);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("noOfSeats",(String.valueOf(selectedSeatArray.length)));
        editor.putString("totalAmount",resultText);
        editor.apply();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBuyPressed();
            }
        });
        return view;
    }


    private String calculateTotalFare(String[] selectedSeatArray) {

        totalFare = String.valueOf(selectedSeatArray.length * Float.parseFloat(sharedPreferences.getString("fare", "0")));

        return totalFare;
    }

    private void onBuyPressed() {

        PayPalPayment thingToBuy = getThingToBuy(PayPalPayment.PAYMENT_INTENT_SALE);

        /*
         * See getStuffToBuy(..) for examples of some available payment options.
         */

        Intent intent = new Intent(getActivity(), PaymentActivity.class);

        // send the same configuration for restart resiliency
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT, thingToBuy);
        startActivityForResult(intent, REQUEST_CODE_PAYMENT);

    }

    private PayPalPayment getThingToBuy(String paymentIntent) {
        return new PayPalPayment(new BigDecimal(calculateTotalFare(selectedSeatArray)), "USD", selectedSeatArray.length + " Bus Seat",
                paymentIntent);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PAYMENT) {
            if (resultCode == getActivity().RESULT_OK) {
                PaymentConfirmation confirm =
                        data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
                if (confirm != null) {
                    try {
                        Log.i(TAG, confirm.toJSONObject().toString(4));
                        Log.i(TAG, confirm.getPayment().toJSONObject().toString(4));


                        //displayResultText("PaymentConfirmation info received from PayPal");
                        displayResultText("No. of Seats : " + selectedSeatArray.length +
                                            "\n" + "Total Amount : " + resultText);


                    } catch (JSONException e) {
                        Log.e(TAG, "an extremely unlikely failure occurred: ", e);
                    }
                }
            } else if (resultCode == getActivity().RESULT_CANCELED) {
                Log.i(TAG, "The user canceled.");
            } else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID) {
                Log.i(
                        TAG,
                        "An invalid Payment or PayPalConfiguration was submitted. Please see the docs.");
            }

        }
    }


    private PayPalPayment getStuffToBuy(String paymentIntent) {
        //--- include an item list, payment amount details
        PayPalItem[] items =
                {
                        new PayPalItem("sample item #1", 2, new BigDecimal("87.50"), "USD",
                                "sku-12345678"),
                        new PayPalItem("free sample item #2", 1, new BigDecimal("0.00"),
                                "USD", "sku-zero-price"),
                        new PayPalItem("sample item #3 with a longer name", 6, new BigDecimal("37.99"),
                                "USD", "sku-33333")
                };
        BigDecimal subtotal = PayPalItem.getItemTotal(items);
        BigDecimal shipping = new BigDecimal("7.21");
        BigDecimal tax = new BigDecimal("4.67");
        PayPalPaymentDetails paymentDetails = new PayPalPaymentDetails(shipping, subtotal, tax);
        BigDecimal amount = subtotal.add(shipping).add(tax);
        PayPalPayment payment = new PayPalPayment(amount, "USD", "sample item", paymentIntent);
        payment.items(items).paymentDetails(paymentDetails);

        //--- set other optional fields like invoice_number, custom field, and soft_descriptor
        payment.custom("This is text that will be associated with the payment that the app can use.");

        return payment;
    }


    private void addAppProvidedShippingAddress(PayPalPayment paypalPayment) {
        ShippingAddress shippingAddress =
                new ShippingAddress().recipientName("Mom Parker").line1("52 North Main St.")
                        .city("Austin").state("TX").postalCode("78729").countryCode("US");
        paypalPayment.providedShippingAddress(shippingAddress);
    }

    /*
     * Enable retrieval of shipping addresses from buyer's PayPal account
     */
    private void enableShippingAddressRetrieval(PayPalPayment paypalPayment, boolean enable) {
        paypalPayment.enablePayPalShippingAddressesRetrieval(enable);
    }

    private PayPalOAuthScopes getOauthScopes() {
        /* create the set of required scopes
         * Note: see https://developer.paypal.com/docs/integration/direct/identity/attributes/ for mapping between the
         * attributes you select for this app in the PayPal developer portal and the scopes required here.
         */
        Set<String> scopes = new HashSet<>(
                Arrays.asList(PayPalOAuthScopes.PAYPAL_SCOPE_EMAIL, PayPalOAuthScopes.PAYPAL_SCOPE_ADDRESS));
        return new PayPalOAuthScopes(scopes);
    }


    private void sendAuthorizationToServer(PayPalAuthorization authorization) {

    }


    protected void displayResultText(String result) {
        textresult.setText(result);
        SummaryFragment summaryFragment = new SummaryFragment();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, summaryFragment).addToBackStack(null).commit();
        //Toast.makeText(getActivity(), result, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onDestroy() {
        // Stop service when done
        //stopService(new Intent(this, PayPalService.class));
        super.onDestroy();
    }


}
