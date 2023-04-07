package com.crio.jukebox.respositories;

import java.util.List;
import java.util.Optional;
import com.crio.jukebox.exception.NoSuchSongExistException;
import com.crio.jukebox.exception.NoSuchUserExistException;
import com.crio.jukebox.exception.PlaylistNotFoundException;

public interface CRUDRepository<T,ID> {
    public T save(T entity);
    public List<T> findAll();
    public Optional<T> findById(ID id) throws PlaylistNotFoundException,NoSuchUserExistException;
    boolean existsById(ID id) throws NoSuchSongExistException;
    public void delete(T entity);
    public void deleteById(ID id);
    public long count();
}
