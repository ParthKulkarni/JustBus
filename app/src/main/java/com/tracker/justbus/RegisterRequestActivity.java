package com.tracker.justbus;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by saurabh on 3/2/18.
 */

public class RegisterRequestActivity extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "https://bobtail-chapter.000webhostapp.com/iot_register.php";
    private Map<String, String> params;

    public RegisterRequestActivity(String student_id, String student_fname, String student_lname, String stud_father,
                                   String stud_mother, String f_phone, String m_phone, String e_phone, double home_lat,
                                   double home_lon, int school_id, String f_email, String m_email, String stud_dob,
                                   String blood_group, String image_link, String stud_guardian, String g_phone,
                                   int shift, String address, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("student_id", student_id);
        params.put("student_fname", student_fname);
        params.put("student_lname", student_lname);
        params.put("stud_father", stud_father);
        params.put("stud_mother", stud_mother);
        params.put("f_phone", f_phone);
        params.put("m_phone", m_phone);
        params.put("e_phone", e_phone);
        params.put("home_lat", home_lat+"");
        params.put("home_lon", home_lon+"");
        params.put("school_id", school_id+"");
        params.put("f_email", f_email);
        params.put("m_email", m_email);
        params.put("stud_dob", stud_dob);
        params.put("blood_group", blood_group);
        params.put("image_link", image_link);
        params.put("stud_guardian", stud_guardian);
        params.put("g_phone", g_phone);
        params.put("shift", shift+"");
        params.put("address", address);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
