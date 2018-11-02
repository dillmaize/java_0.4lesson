package ru.stqa.ak.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ak.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
   app.getNavigationHelper().gotoGroupPage();
   if (! app.getGroupHelper().isThereAGroup()){
        app.getGroupHelper().createGroup(new GroupData("test1", null, null));
   }
   app.getGroupHelper().selectGroup();
   app.getGroupHelper().deleteSelectedGroups();
   app.getGroupHelper().returnToGroupPage();
   app.getNavigationHelper().gotoHomePage();
  }

}
