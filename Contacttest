class ContactTest {

    @Test
    void testContactNullArguments() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, null, null, null, null);
        });
    }

    @Test
    void testContactAndGetters() {
        Contact contact = new Contact("123456", "Casey", "Farmer", "7025554980", "6029 East Street");
        assertEquals("Casey Farmer", contact.getFullName());
        assertEquals("7025554980", contact.getPhoneNumber());
        assertEquals("6029 East Street", contact.getAddress());
        assertEquals("123456", contact.getId());
    }

    @Test
    void testSetFirstAndLastName() {
        Contact contact = new Contact("123456", "Casey", "Farmer", "7025554900", "6029 East Street");
        contact.setFirstName("Casey");
        contact.setLastName("Farmer");
        assertEquals("Casey Farmer", contact.getFullName());
    }

    @Test
    void testSetPhoneNumberAndAddress() {
        Contact contact = new Contact("123456", "Casey", "Farmer", "7025554900", "6029 East Street");
        contact.setPhoneNumber("7024595355");
        contact.setAddress("1220 W Alexander Rd");
        assertEquals("7024595355", contact.getPhoneNumber());
        assertEquals("1220 W Alexander Rd", contact.getAddress());
    }

    @Test
    void testNullSetAttributes() {
        Contact contact = new Contact("123456", "casey", "Casey", "7025554900", "6029 East Street");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName(null);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(null);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhoneNumber(null);
        });
    }

    @Test
    void testAllGetters() {
        Contact contact = new Contact("123456", "Casey", "Farmer", "7025554900", "6029 East Street");
        assertEquals("Casey Farmer", contact.getFullName());
        assertEquals("123456", contact.getId());
        assertEquals("7025554900", contact.getPhoneNumber());
        assertEquals("6029 East Street", contact.getAddress());
    }
}
