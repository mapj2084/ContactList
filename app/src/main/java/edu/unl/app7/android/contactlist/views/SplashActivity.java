package edu.unl.app7.android.contactlist.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.firebase.client.DataSnapshot;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import edu.unl.app7.android.contactlist.R;
import edu.unl.app7.android.contactlist.manager.FirebaseContactManager;
import edu.unl.app7.android.contactlist.model.Contact;


public class SplashActivity extends AppCompatActivity implements ValueEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }


    @Override
    protected void onStart() {
        super.onStart();
        FirebaseContactManager.getInstance().getContactFromServer(this);
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for (DataSnapshot contact: dataSnapshot.getChildren()) {
            FirebaseContactManager.getInstance().addContactHashMap(contact.getValue(Contact.class));
        }
        startMainActivity();
    }

    @Override
    public void onCancelled(FirebaseError firebaseError) {
        startMainActivity();
    }

    private void startMainActivity() {
        // TODO: make an Intent to go to contact list activity
    }
}
