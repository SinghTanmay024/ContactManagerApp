package com.timbuchalka.contactmanagerapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModel extends AndroidViewModel {

    //  If you need to use context inside your Viewmodel
    //  you should use AndroidViewModel (AVM),
    //  because it contains the application context.

    // Repository
    private Repository myRepository;

    // LiveData
    private LiveData<List<Contacts>> allContacts;

    public MyViewModel(@NonNull Application application) {
        super(application);
        this.myRepository = new Repository(application);
    }

    public LiveData<List<Contacts>> getAllContacts(){
        allContacts = myRepository.getAllContacts();
        return allContacts;
    }


    public void addNewContact(Contacts contact){
        myRepository.addContact(contact);
    }

    public void deleteContact(Contacts contact){
        myRepository.deleteContact(contact);
    }
}
