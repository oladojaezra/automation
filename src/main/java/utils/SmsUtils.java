package utils;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * This class is going to contain all the helper methods related with SMS.
 */
public class SmsUtils {
    private static final String HTTP_HEADER_ACCEPT = "accept";
    private static final String PHONE_FIELD = "phone";
    private static final String OTP_FIELD = "otp";

    /**
     * This method fetches signup OTP from backend for singup process.
     *
     * @param phonenumber The phone number which is used for the signup process.
     * @param apiHostName The api hostname for the current environment.
     * @return The otp used for signup process.
     * @throws UnirestException This exception is thrown in case of network issue or any issue with the api request.
     */
    public static String getOtpNumber(String phonenumber, String apiHostName) throws UnirestException {
        HttpResponse<JsonNode> jsonResponse = (HttpResponse<JsonNode>) Unirest
                .get(apiHostName + "userservice/test/user/getOtpForTest?phone={phone}")
                .header(SmsUtils.HTTP_HEADER_ACCEPT, "*/*").routeParam(SmsUtils.PHONE_FIELD, phonenumber).asJson();
        System.out.println("OTP Request " + jsonResponse.getBody().getObject());
        Object otpvalue = jsonResponse.getBody().getObject().get(SmsUtils.OTP_FIELD);
        return otpvalue.toString();
    }
}
