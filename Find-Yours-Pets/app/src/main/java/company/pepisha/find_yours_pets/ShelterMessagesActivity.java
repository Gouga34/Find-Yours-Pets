package company.pepisha.find_yours_pets;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import company.pepisha.find_yours_pets.connection.ServerConnectionManager;
import company.pepisha.find_yours_pets.connection.ServerDbOperation;
import company.pepisha.find_yours_pets.db.message.Message;
import company.pepisha.find_yours_pets.views.MessageViews;

public class ShelterMessagesActivity extends BaseActivity {

    private ListView messagesList;

    private class GetSheltersMessagesDbOperation extends ServerDbOperation {

        public GetSheltersMessagesDbOperation(Context c) {
            super(c, "getSheltersMessages");
        }

        @Override
        protected void onPostExecute(HashMap<String, Object> result) {
            if (result != null) {
                List<Message> messages = new ArrayList<>();

                if (result.get("messagesAboutAnimals").toString() != "null") {
                    HashMap<String, Object> messagesAboutAnimals = ServerConnectionManager.unmarshallReponse(result.get("messagesAboutAnimals").toString());
                    messages.addAll(MessageViews.getMessagesList(messagesAboutAnimals));
                }

                if (result.get("messagesAboutShelter").toString() != "null") {
                    HashMap<String, Object> messagesAboutShelter = ServerConnectionManager.unmarshallReponse(result.get("messagesAboutShelter").toString());
                    messages.addAll(MessageViews.getMessagesList(messagesAboutShelter));
                }

                MessageViews.createMessagesList(messagesList, messages);
            }
        }
    }

    private class GetMessagesAboutAnimalDbOperation extends ServerDbOperation {

        public GetMessagesAboutAnimalDbOperation(Context c) {
            super(c, "getMessagesAboutAnimal");
        }

        @Override
        protected void onPostExecute(HashMap<String, Object> result) {
            if (result != null) {
                MessageViews.createMessagesList(messagesList, MessageViews.getMessagesList(result));
            }
        }
    }

    private void loadShelterMessages(int idShelter) {
        HashMap<String, String> messagesRequest = new HashMap<String, String>();
        messagesRequest.put("idShelter", Integer.toString(idShelter));
        new GetSheltersMessagesDbOperation(this).execute(messagesRequest);
    }

    private void loadAnimalMessages(int idAnimal) {
        HashMap<String, String> messagesRequest = new HashMap<String, String>();
        messagesRequest.put("idAnimal", Integer.toString(idAnimal));
        new GetMessagesAboutAnimalDbOperation(this).execute(messagesRequest);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_messages);

        messagesList = (ListView) findViewById(R.id.messagesList);

        if (getIntent().hasExtra("idShelter")) {
            loadShelterMessages(getIntent().getIntExtra("idShelter", 1));
        }
        else if (getIntent().hasExtra("idAnimal")) {
            loadAnimalMessages(getIntent().getIntExtra("idAnimal", 1));
        }
    }
}
