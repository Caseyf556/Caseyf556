public class ContactService {

    private List<Contact> _contactList = new ArrayList<>();
    private int _contactCount = 0;

    public int getContactCount() {
        return _contactCount;
    }

    public List<Contact> getContactList() {
        return new ArrayList<>(_contactList); // Return a copy to prevent modification
    }

    public void addContact(String id, String fName, String lName, String phone, String addy) {
        Contact newContact = new Contact(id, fName, lName, phone, addy);
        _contactList.add(newContact);
        _contactCount++;
    }

    public void addContact(Contact contact) {
        _contactList.add(contact);
        _contactCount++;
    }

    public void deleteContact(String id) {
        if (id == null || id.length() > 10) {
            throw new IllegalArgumentException("Invalid ID");
        }

        if (_contactList.isEmpty()) {
            throw new IllegalArgumentException("No contacts to delete");
        }

        Contact contactToRemove = null;
        for (Contact c : _contactList) {
            if (c.getId().equals(id)) {
                contactToRemove = c;
                break;
            }
        }

        if (contactToRemove != null) {
            _contactList.remove(contactToRemove);
            _contactCount--;
            System.out.println("Contact removed from list.");
        } else {
            throw new IllegalArgumentException("Contact not found.");
        }
    }

    public void updateContact(String id, String update, int selection) {
        if (id == null || id.length() > 10 || update == null || selection < 0) {
            throw new IllegalArgumentException("Invalid ID or update");
        }

        if (_contactList.isEmpty()) {
            throw new IllegalArgumentException("No contacts exist in list");
        }

        Contact contactToUpdate = null;
        for (Contact c : _contactList) {
            if (c.getId().equals(id)) {
                contactToUpdate = c;
                break;
            }
        }

        if (contactToUpdate == null) {
            throw new IllegalArgumentException("Contact not found.");
        }

        switch (selection) {
            case 1:
                contactToUpdate.setFirstName(update);
                break;
            case 2:
                contactToUpdate.setLastName(update);
                break;
            case 3:
                contactToUpdate.setPhoneNumber(update);
                break;
            case 4:
                contactToUpdate.setAddress(update);
                break;
            default:
                throw new IllegalArgumentException("Invalid change requested.");
        }
    }

    public void updateContact(String id, String fName, String lName, String phone, String addy) {
        if (id == null || id.length() > 10) {
            throw new IllegalArgumentException("Invalid ID");
        }

        if (_contactList.isEmpty()) {
            throw new IllegalArgumentException("No contacts exist in list");
        }

        Contact contactToUpdate = null;
        for (Contact c : _contactList) {
            if (c.getId().equals(id)) {
                contactToUpdate = c;
                break;
            }
        }

        if (contactToUpdate == null) {
            throw new IllegalArgumentException("Contact not found.");
        }

        contactToUpdate.setFirstName(fName);
        contactToUpdate.setLastName(lName);
        contactToUpdate.setAddress(addy);
        contactToUpdate.setPhoneNumber(phone);
    }

    public String generateUniqueID() {
        Random rand = new Random();
        String uniqueID;

        do {
            uniqueID = String.valueOf(rand.nextInt(1000000000));
        } while (_contactList.stream().anyMatch(c -> c.getId().equals(uniqueID)));

        System.out.println("ID created: " + uniqueID);
        return uniqueID;
    }
}
