package com.crio.jukebox.respositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.crio.jukebox.entities.User;

public class UserRepository implements IuserServiceRepository{
    private final Map<String,User>userMap;
    private Integer autoIncrement = 0;

    
    public UserRepository(){
        userMap = new HashMap<String,User>();
    }
    public UserRepository(Map<String,User>user){
        this.userMap=user;
    }


    @Override
    public User save(User entity) {
        if(entity.getId()==null){
        autoIncrement++;
        User user  = new User(Integer.toString(autoIncrement),entity.getName());
        userMap.put(autoIncrement.toString(), user);
        return user;

        }
        userMap.put(entity.getId(),entity);
        return entity;
    }
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }
    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public void delete(User entity) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void deleteById(String id) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public boolean existsById(String id) {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public List<User> findAll() {
        return userMap.values().stream().collect(Collectors.toList());
        // TODO Auto-generated method stub
    }
    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(userMap.get(id));
        // TODO Auto-generated method stub
      
    }
   

}
