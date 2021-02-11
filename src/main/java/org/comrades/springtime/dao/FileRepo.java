package org.comrades.springtime.dao;

import org.comrades.springtime.module.FileModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepo extends JpaRepository<FileModel, String> {


}