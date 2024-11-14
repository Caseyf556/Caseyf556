class ContactServiceTest {

    private ContactService contactService;

    @BeforeEach
    void setUp() {
        contactService = new ContactService();
    }

    @Test
    void testAddContactMethod() {
        // Create a contact
        String testID = contactService.GenerateUniqueID();
        Contact contact = new Contact(testID, "Hunter", "Mason", "7025554900", "6029 East Street");
        
        // Add contact to the list
        contactService.AddContact(contact);
        
        // Confirm contact is in the list
        assertFalse(contactService.GetContactList().isEmpty());
        assertEquals(testID, contactService.GetContactList().elementAt(0).getId());
        assertTrue(contactService.GetContactCount() > 0);
    }

    @Test
    void testDeleteContactMethod() {
        // Create new contact
        Contact contact = new Contact("123456", "Hunter", "Mason", "7025554900", "6029 East Street");
        
        // Try to remove with null id
        Assertions.assertThrows(IllegalArgumentException.class, () -> contactService.DeleteContact(null));
        
        // Try to remove with id that's too long
        Assertions.assertThrows(IllegalArgumentException.class, () -> contactService.DeleteContact("12345678901"));
        
        // Try to remove from empty list
        Assertions.assertThrows(IllegalArgumentException.class, () -> contactService.DeleteContact("1234567890"));
        
        // Add the contact
        contactService.AddContact(contact);
        
        // Remove a contact that isn't there
        contactService.DeleteContact("123457");
        
        // Confirm contact list is not empty
        assertFalse(contactService.GetContactList().isEmpty());
        assertTrue(contactService.GetContactCount() > 0);
        
        // Remove correct contact
        contactService.DeleteContact("123456");
        
        // Confirm list is empty
        assertEquals(0, contactService.GetContactCount());
        assertTrue(contactService.GetContactList().isEmpty());
    }

    @Test
    void testUpdateContactMethodErrors() {
        // Contact list is empty
        Assertions.assertThrows(IllegalArgumentException.class, () -> contactService.UpdateContact("123456", "Casey", 1));
        
        // Create new contact, add to list
        Contact contact = new Contact("123456", "Hunter", "Mason", "7025554900", "6029 East Street");
        contactService.AddContact(contact);
        
        // Check that contact was added
        assertFalse(contactService.GetContactList().isEmpty());
        
        // ID is too long
        Assertions.assertThrows(IllegalArgumentException.class, () -> contactService.UpdateContact("12345678901", "Casey", 1));
        
        // ID is null
        Assertions.assertThrows(IllegalArgumentException.class, () -> contactService.UpdateContact(null, "Casey", 1));
        
        // Update value is null
        Assertions.assertThrows(IllegalArgumentException.class, () -> contactService.UpdateContact("123456", null, 1));
        
        // Selection value is less than zero
        Assertions.assertThrows(IllegalArgumentException.class, () -> contactService.UpdateContact("123456", "Casey", -1));
        
        // Print "contact not found" to console
        contactService.UpdateContact("123457", "Casey", 1);
        
        // Print "contact not updated" to console
        contactService.UpdateContact("123456", "Casey", 5);
    }

    @Test
    void testUpdateContactMethod() {
        Contact contact = new Contact("123456", "Hunter", "Mason", "7025554900", "6029 East Street");
        contactService.AddContact(contact);
        assertFalse(contactService.GetContactList().isEmpty());
        
        // Update first name
        contactService.UpdateContact("123456", "Casey", 1);
        assertEquals("Casey Mason", contactService.GetContactList().elementAt(0).getFullName());
        
        // Update last name
        contactService.UpdateContact("123456", "Mason", 2);
        assertEquals("Casey Mason", contactService.GetContactList().elementAt(0).getFullName());
        
        // Update phone number
        contactService.UpdateContact("123456", "4402255499", 3);
        assertEquals("4402255499", contactService.GetContactList().elementAt(0).getPhoneNumber());
        
        // Update address
        contactService.UpdateContact("123456", "9955 Whitson Ave", 4);
        assertEquals("9955 Whitson Ave", contactService.GetContactList().elementAt(0).getAddress());
        
        // Update first name too long
        Assertions.assertThrows(IllegalArgumentException.class, () -> contactService.UpdateContact("123456", "CaseyMason", 1));
        
        // Check that list has been updated
        assertEquals(1, contactService.GetContactCount());
        assertEquals("Casey Mason", contactService.GetContactList().elementAt(0).getFullName());
    }
}
