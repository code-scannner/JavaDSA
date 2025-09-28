package systemDesign;

import java.time.Instant;
import java.util.*;

public class PhoneBook {

    Map<String, Contact> contacts;
    List<Call> calls;

    boolean ongoing;

    PhoneBook() {
        contacts = new HashMap<>();
        calls = new ArrayList<>();
        ongoing = false;
    }

    public void makeCall(String phoneno) {
        Contact contact = contacts.get(phoneno);
        if (contact == null)
            return;
        Call call = new Call(contact);
        contact.calls++;
        calls.add(call);
        ongoing = true;
    }

    public void endCall() {
        if (ongoing) {
            ongoing = false;
            Call call = calls.get(calls.size() - 1);
            call.endTime = Date.from(Instant.now());
        }
    }

    public void addContact(String phoneNo, String name) {
        contacts.put(phoneNo, new Contact(phoneNo, name));
    }

    public void history() {
        for (Call call : calls) {
            System.out.println(call);
        }
    }

    public void showFavorites(int top) {
        Contact[] allContacts = (Contact[]) contacts.values().toArray(new Contact[0]);

        Arrays.sort(allContacts, (a, b) -> b.calls - a.calls);

        if (allContacts.length > 5) {
            allContacts = Arrays.copyOf(allContacts, top);
        }

        for (Contact c : allContacts) {
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        pb.addContact("9569886315", "Shreyansh Gupta");
        pb.addContact("8318024124", "Anju Gupta");
        pb.makeCall("9569886315");
        pb.makeCall("8318024124");
        pb.makeCall("8318024124");
        pb.makeCall("9569886315");
        pb.makeCall("9569886315");
        pb.endCall();
        // pb.history();
        pb.showFavorites(5);
    }
}

class Contact {
    String phoneno;
    String name;
    int calls;

    Contact(String phone, String n) {
        phoneno = phone;
        name = n;
        calls = 0;
    }

    @Override
    public String toString() {
        return name + " " + phoneno;
    }
}

class Call {
    Contact contact;
    Date startTime;
    Date endTime;

    @Override
    public String toString() {
        return contact.name + ": " + startTime.toInstant() + " - " + endTime.toInstant();
    }

    Call(Contact c) {
        contact = c;
        startTime = Date.from(Instant.now());
    }
}