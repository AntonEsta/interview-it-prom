package com.example.interviewitprom.application.directories.interfaces;

import java.util.List;

public interface DirectorySearchService<T> {

  List<T> getAll();

  T getById(long id);

}
