package charityapp.v2;

import java.util.ArrayList;

public class InputChecker {
    public static boolean isValidID(String id) {
        return !id.isEmpty() && id.matches("^\\d*\\d\\d*$");
    }

    /**
     * Returns the ID of a user if found to be valid. Else, it returns -1.
     * @param id ID to be checked.
     * @return ID or -1 (invalid).
     */
    public static int isUser(int id) {
        ArrayList<Person> users = Person.getUsers();
        if(users.size() != 0) {
            int index = 0;
            for(Person p: Person.getUsers()) {
                if (id == p.getId()) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

}
