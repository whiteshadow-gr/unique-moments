package gr.um.uniquemoments.test;

import gr.um.database.MockControllerContactsDB;
import gr.um.entities.Contact;

import java.util.ArrayList;

import android.test.InstrumentationTestCase;

public class ControllerContactsDBUnitTest extends InstrumentationTestCase
{
 private ArrayList<Contact> initDB;
 private MockControllerContactsDB mockDB;
 
 
 public ControllerContactsDBUnitTest() 
 {
  super();
  
 }

 protected void setUp() throws Exception 
 {
  super.setUp();
  initDB = new ArrayList<Contact>();
  Contact temp = new Contact("George Bush", "1234");
  temp.setID("1");
  initDB.add(temp);
  
  temp = new Contact("Kotsos Mitsos", "2345");
  temp.setID("2");
  initDB.add(temp);
  
  temp = new Contact("Makis Tzikos", "3456");
  temp.setID("3");
  initDB.add(temp);
  
  temp = new Contact("Maria Xatzi", "4567");
  temp.setID("4");
  initDB.add(temp);
  mockDB = new MockControllerContactsDB();
  mockDB.MockInitiallize(initDB);
 }

 protected void tearDown() throws Exception {
  super.tearDown();
 }

 public void testImportPhonebookData()
 {
  fail("");
 }

 public void testAddContact() 
 {
  Contact myContact = new Contact();
  myContact.setID("6");
  myContact.setName("Test Test");
  myContact.setPhone("1469");
  
  assertTrue(mockDB.addContact(myContact));
 }
 public void testEmptyAddContact() 
 {
  Contact myContact = new Contact();
  myContact.setID("");
  myContact.setName("");
  myContact.setPhone("");
  assertFalse(mockDB.addContact(myContact));
 }
 public void testEmptyIdAddContact()
 {
  Contact myContact = new Contact();
  myContact.setID("");
  myContact.setName("Test Test");
  myContact.setPhone("45678");
  assertFalse(mockDB.addContact(myContact));
 }
 public void testEmptyNameAddContact()
 {
  Contact myContact = new Contact();
  myContact.setID("6");
  myContact.setName("");
  myContact.setPhone("45678");
  assertFalse(mockDB.addContact(myContact));
 }
 public void testEmptyPhoneAddContact()
 {
  Contact myContact = new Contact();
  myContact.setID("6");
  myContact.setName("Test Test");
  myContact.setPhone("");
  assertFalse(mockDB.addContact(myContact));
 }
 public void testWrongIdAddContact()
 {
  Contact myContact = new Contact();
  myContact.setID("ASDFG");
  myContact.setName("Test Test");
  myContact.setPhone("45678");
  assertFalse(mockDB.addContact(myContact));
 }
 
 public void testWrongNameAddContact()
 {
  Contact myContact = new Contact();
  myContact.setID("6");
  myContact.setName("456789");
  myContact.setPhone("45678");
  assertFalse(mockDB.addContact(myContact));
 }
 
 public void testWrongPhoneAddContact()
 {
  Contact myContact = new Contact();
  myContact.setID("6");
  myContact.setName("456789");
  myContact.setPhone("AAAAA");
  assertFalse(mockDB.addContact(myContact));
 }
 
 public void testGetContacts() 
 {
  assertNotNull(mockDB.getContacts());
 }
 
 public void testDeleteContact() 
 {
  Contact myContact = new Contact();
  myContact.setID("6");
  myContact.setName("Test Test");
  myContact.setPhone("1469");
  assertTrue(mockDB.deleteContact(myContact));
 }
 
 public void testEditContact()
 {
  Contact myContact = new Contact("Makis Marios", "3456");
  myContact.setID("3");
  assertTrue(mockDB.editContact(myContact));
 }
 
 public void testEmptyEditContact()
 {
  Contact myContact = new Contact();
  myContact.setID(null);
  myContact.setName(null);
  myContact.setPhone(null);
  assertTrue(mockDB.editContact(myContact));
 }
}