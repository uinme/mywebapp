package model;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class ModelTest {
  @Test
  public void getFieldNames() {
    UserModel user = new UserModel();
    List<String> fieldNames = user.getFieldNames();

    Iterator<String> expectedFieldNames = Arrays.asList(
      "id",
      "username",
      "email",
      "encryptedPassword",
      "createdAt",
      "updatedAt"
    ).iterator();

    for (String fieldName : fieldNames) {
      expectedFieldNames.hasNext();

      Boolean expected = true;
      Boolean actual = fieldName.contains(expectedFieldNames.next());

      assertThat(actual, is(expected));
    }
  }
}
