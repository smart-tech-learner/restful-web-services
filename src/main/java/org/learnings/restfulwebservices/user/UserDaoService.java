package org.learnings.restfulwebservices.user;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Prasana Kumar", LocalDate.now().minusYears(36)));
        users.add(new User(2, "Renitha", LocalDate.now().minusYears(33)));
        users.add(new User(3, "Kayra", LocalDate.now().minusYears(5)));
    }

    public List<User> findAll(){
        return users;
    }

    public User retrieveUserById(int id){
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    public User save(User user){
        user.setId(users.size()+1);
        users.add(user);
        return user;
    }

}
